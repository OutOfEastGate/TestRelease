package com.wht.test.service;

import com.wht.client.dto.PageResult;
import com.wht.client.form.PageForm;
import com.wht.client.obj.IpDo;
import com.wht.test.repository.IpRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 20:52
 */
@Service
public record IpService(IpRepository ipRepository) {
    public PageResult<List<IpDo>> getAllIp(PageForm pageForm) {
        PageRequest pageRequest = PageRequest.of(pageForm.getCurrentPage(), pageForm.getPageSize());
        Page<IpDo> ipDoPage = ipRepository.findAll(pageRequest);
        List<IpDo> res = ipDoPage.get().sorted((a, b) -> b.getDate().compareTo(a.getDate())).collect(Collectors.toList());
        return new PageResult<>(pageForm.getCurrentPage(), pageForm.getPageSize(), ipDoPage.getTotalElements(), res);
    }
}
