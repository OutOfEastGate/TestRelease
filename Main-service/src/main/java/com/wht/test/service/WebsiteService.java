package com.wht.test.service;

import com.wht.client.form.website.AddWebsiteForm;
import com.wht.client.obj.WebsiteDo;
import com.wht.test.repository.WebsiteRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public record WebsiteService(WebsiteRepository websiteRepository) {
    public WebsiteDo addWebsite(AddWebsiteForm addWebsiteForm) throws IOException {
        WebsiteDo websiteDo = new WebsiteDo();
        websiteDo.setName(addWebsiteForm.getName());
        websiteDo.setDesc(addWebsiteForm.getDesc());
        websiteDo.setLink(addWebsiteForm.getLink());

        // 发起 HTTP 请求并获取网页内容
        Document doc = Jsoup.connect(addWebsiteForm.getLink()).get();

        // 获取网站标题
        String title = doc.title();
        websiteDo.setTitle(title);

        // 获取网站图标
        Elements iconElements = doc.select("link[rel~=(?i)^(shortcut|icon|apple-touch-icon)]");
        Element iconElement = iconElements.first();
        String iconUrl = iconElement != null ? iconElement.attr("href") : "";
        if (!iconUrl.startsWith("http"))
            websiteDo.setIcon(addWebsiteForm.getLink() + iconUrl.substring(1));


        return websiteRepository.save(websiteDo);
    }

    public List<WebsiteDo> getAllWebsite() {
        return websiteRepository.findAll();
    }

    public void deleteWebsite(String id) {
        websiteRepository.deleteById(id);
    }
}
