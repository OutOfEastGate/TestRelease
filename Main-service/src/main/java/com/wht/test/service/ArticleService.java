package com.wht.test.service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wht.client.Result;
import com.wht.client.dto.AllArticlesDto;
import com.wht.client.dto.PageResult;
import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import com.wht.client.form.AddArticleForm;
import com.wht.client.form.EditArticleForm;
import com.wht.client.form.IdForm;
import com.wht.client.form.PageForm;
import com.wht.client.obj.ArticleDo;
import com.wht.test.repository.ArticleRepository;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.service.CasdoorUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/25 13:38
 */
@Service
public class ArticleService {
    ArticleRepository articleRepository;
//    @Autowired
//    RabbitTemplate rabbitTemplate;
    CasdoorUserService casdoorUserService;
    public ArticleService(ArticleRepository articleRepository, CasdoorUserService casdoorUserService) {
        this.articleRepository = articleRepository;
        this.casdoorUserService = casdoorUserService;
    }

    public ArticleDo addArticle(AddArticleForm addArticleForm) {
        ArticleDo articleDo = new ArticleDo();
        BeanUtils.copyProperties(addArticleForm, articleDo);
        articleRepository.save(articleDo);
        //发送消息，同步es
//        rabbitTemplate.convertAndSend(MQConstants.DOC_EXCHANGE,MQConstants.DOC_INSERT_KEY,articleDo.getId());
        return articleDo;
    }

    public List<AllArticlesDto> getAllArticle() {
        List<ArticleDo> allArticles = articleRepository.findAll();
        List<AllArticlesDto> res = new ArrayList<>();
        allArticles.forEach(articleDo -> {
            AllArticlesDto allArticlesDto = new AllArticlesDto();
            BeanUtils.copyProperties(articleDo,allArticlesDto);

            String author = articleDo.getAuthor();
            CasdoorUser user;
            if (StringUtils.isNotEmpty(author)) {
                try {
                    user = casdoorUserService.getUser(author);
                    allArticlesDto.setAuthorAvatar(user.getAvatar());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            res.add(allArticlesDto);
        });
        return res;
    }

    public void deleteArticleById(IdForm idForm) {
        articleRepository.deleteById(idForm.getId());
        //发送消息，同步es
//        rabbitTemplate.convertAndSend(MQConstants.DOC_EXCHANGE,MQConstants.DOC_DELETE_KEY,idForm.getId());
    }

    public ArticleDo getArticleById(String id) {
        Optional<ArticleDo> articleDoOptional = articleRepository.findById(id);
        if (articleDoOptional.isEmpty()){
            throw new CustomException(ErrorCode.ARTICLE_NOT_EXIST);
        }
        return articleDoOptional.get();
    }

    public void editArticle(EditArticleForm editArticleForm) {
        if (editArticleForm.getId() == null || Objects.equals(editArticleForm.getId(), "")) {
            throw new CustomException(ErrorCode.ARTICLE_NOT_EXIST);
        }

        Optional<ArticleDo> repositoryById = articleRepository.findById(editArticleForm.getId());
        if (repositoryById.isEmpty()) {
            throw new CustomException(ErrorCode.ARTICLE_NOT_EXIST);
        }
        ArticleDo articleDo = repositoryById.get();
        articleDo.setContent(editArticleForm.getContent());
        articleDo.setDescription(editArticleForm.getDescription());
        articleDo.setTitle(editArticleForm.getTitle());
        articleDo.setImage(editArticleForm.getImage());
        articleRepository.save(articleDo);

        //发送消息，同步es
//        rabbitTemplate.convertAndSend(MQConstants.DOC_EXCHANGE,MQConstants.DOC_DELETE_KEY,articleDo.getId());
    }

    public List<AllArticlesDto> searchArticle(String text) {
        List<AllArticlesDto> res = new ArrayList<>();
        getAllArticle().forEach(allArticlesDto -> {
            if (allArticlesDto.getTitle().contains(text) ||
            allArticlesDto.getDescription().contains(text)) {
                res.add(allArticlesDto);
            }
        });
        return res;
    }

    public PageResult<List<AllArticlesDto>> getArticlesByPage(PageForm pageForm) {
        PageRequest pageRequest = PageRequest.of(pageForm.getCurrentPage(), pageForm.getPageSize());

        Page<ArticleDo> articleDos = articleRepository.findAll(pageRequest);
        long totalPages = articleDos.getTotalElements();
        List<AllArticlesDto> res = new ArrayList<>();
        articleDos.forEach(articleDo -> {
            AllArticlesDto allArticlesDto = new AllArticlesDto();
            BeanUtils.copyProperties(articleDo,allArticlesDto);

            String author = articleDo.getAuthor();
            CasdoorUser user;
            if (StringUtils.isNotEmpty(author)) {
                try {
                    user = casdoorUserService.getUser(author);
                    allArticlesDto.setAuthorAvatar(user.getAvatar());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            res.add(allArticlesDto);
        });

        return new PageResult(pageForm.getCurrentPage(),pageForm.getPageSize(),totalPages,res);
    }
}
