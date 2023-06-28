package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.dto.AllArticlesDto;
import com.wht.client.dto.PageResult;
import com.wht.client.form.AddArticleForm;
import com.wht.client.form.EditArticleForm;
import com.wht.client.form.IdForm;
import com.wht.client.form.PageForm;
import com.wht.client.obj.ArticleDo;
import com.wht.test.config.aop.CacheAnnotation;
import com.wht.test.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/25 13:36
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @CacheAnnotation(cacheTime = "6000")
    @GetMapping("/getAllArticle")
    public Result<List<AllArticlesDto>> getAllArticle() {
        return Result.success(articleService.getAllArticle());
    }

    @CacheAnnotation(cacheTime = "6000")
    @GetMapping("/getArticlesByPage")
    public Result<PageResult<List<AllArticlesDto>>> getArticlesByPage(PageForm pageForm) {
        return Result.success(articleService.getArticlesByPage(pageForm));
    }

    @GetMapping("/getArticleById")
    public Result<ArticleDo> getArticleById(String id) {
        return Result.success(articleService.getArticleById(id));
    }

    @PostMapping("/addArticle")
    public Result addArticle(@RequestBody AddArticleForm addArticleForm) {
        return Result.success(articleService.addArticle(addArticleForm));
    }

    @PostMapping("/editArticle")
    public Result editArticle(@RequestBody EditArticleForm editArticleForm) {
        articleService.editArticle(editArticleForm);
        return Result.success();
    }

    @PostMapping("/deleteArticleById")
    public Result deleteArticle(@RequestBody IdForm idForm) {
        articleService.deleteArticleById(idForm);
        return Result.success();
    }

    @GetMapping("/search/article")
    public Result<List<AllArticlesDto>> searchArticle(String text) {
        return Result.success(articleService.searchArticle(text));
    }
}
