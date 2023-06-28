package com.wht.client.dto;

import lombok.Data;

@Data
public class SystemInfoDto {
    /**
     * cpu核心数
     */
    Integer cpuNum;

    /**
     * 虚拟线程数
     */
    Integer cpuThreadNum;

    /**
     * 系统运行时间
     */
    String systemRuntime;

    /**
     * 总内存
     */
    String totalMemory;

    /**
     * 内存使用率
     */
    Double memoryUsage;

    /**
     * jvm内存使用率
     */
    Double jvmMemoryUsage;
}
