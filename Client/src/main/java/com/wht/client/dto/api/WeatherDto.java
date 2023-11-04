package com.wht.client.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherDto {
    String code;

    Result result;

}

@Data
class Result {
    City city;

    Condition condition;

    Forecast[] forecast;
}


@Data
class City {
    /**
     * 国家名称
     */
    String counname;

    /**
     * 市
     */
    String name;

    /**
     * 省份
     */
    String pname;
}

@Data
class Condition {
    /**
     * 天气
     */
    String condition;

    /**
     * 小提示
     */
    String tips;

    /**
     * 日升时间
     */
    String sunRise;

    /**
     * 日落时间
     */
    String sunSet;

    /**
     * 风向
     */
    String windDir;

    /**
     * 风级
     */
    Integer windLevel;
}


/**
 * 未来七天预报
 */
@Data
class Forecast {

    /**
     * 白天天气
     */
    String conditionDay;

    /**
     * 晚上天气
     */
    String conditionNight;

    /**
     * 预报i日期
     */
    String predictDate;
}