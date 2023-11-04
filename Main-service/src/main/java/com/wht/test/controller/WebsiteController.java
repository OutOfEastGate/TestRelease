package com.wht.test.controller;


import com.wht.client.Result;
import com.wht.client.form.IdForm;
import com.wht.client.form.website.AddWebsiteForm;
import com.wht.client.obj.WebsiteDo;
import com.wht.test.service.WebsiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/website")
@RestController
public class WebsiteController {
    private final WebsiteService websiteService;

    @GetMapping("/getAllWebsite")
    public Result<List<WebsiteDo>> getAllWebsite() {
        return Result.success(websiteService.getAllWebsite());
    }

    @PostMapping("/addWebsite")
    public Result<?> addWebsite(@RequestBody AddWebsiteForm addWebsiteForm) throws IOException {
        return Result.success(websiteService.addWebsite(addWebsiteForm));
    }

    @PostMapping("/deleteWebsite")
    public Result<?> deleteWebsite(@RequestBody IdForm idForm) {
        websiteService.deleteWebsite(idForm.getId());
        return Result.success();
    }

}
