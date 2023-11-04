package com.wht.test.service;

import com.wht.client.dto.api.WeatherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${wht.api.url}", name = "api")
public interface ApiService {
    /**
     * 获取历史上的今天
     * @return
     */
    @GetMapping("/api/common/history")
    Object getHistoryToday();

    /**
     * 获取天气预报
     * @return
     */
    @GetMapping("/api/weather/GetWeather")
    WeatherDto getWeather();
}
