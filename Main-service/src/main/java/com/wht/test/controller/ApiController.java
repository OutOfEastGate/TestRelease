package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.dto.api.WeatherDto;
import com.wht.test.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/api")
@RestController
public class ApiController {
    private final ApiService apiService;

    /**
     * 获取历史上的今天
     * @return 历史上的今天，按照时间正序排列
     */
    @GetMapping("/getHistoryToday")
    public Result<Object> getHistoryToday() {
        return Result.success(apiService.getHistoryToday());
    }

    /**
     * 获取天气预报
     * @return 天气预报（今日天气及七天预报）
     */
    @GetMapping("/getWeather")
    public Result<WeatherDto> getWeather() {
        return Result.success(apiService.getWeather());
    }
}
