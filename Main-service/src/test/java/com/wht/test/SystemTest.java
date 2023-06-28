package com.wht.test;


import org.junit.jupiter.api.Test;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.text.DecimalFormat;
import java.util.Arrays;

public class SystemTest {

    @Test
    public void testSystem() {
        int cpu = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu核心数： " + cpu);
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usedMemory = totalMemory - freeMemory;
        double memoryUsage = (double) usedMemory / totalMemory * 100;
        System.out.println("运行内存使用率：" + memoryUsage + "%");

        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        int availableProcessors = operatingSystemMXBean.getAvailableProcessors();
        double systemCpuUsage = operatingSystemMXBean.getSystemLoadAverage();

        double cpuUsagePerCore = systemCpuUsage / availableProcessors;

        System.out.println("System CPU Usage: " + systemCpuUsage + "%");
        System.out.println("CPU Usage per Core: " + cpuUsagePerCore + "%");

    }

    @Test
    public void testCore() throws InterruptedException {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        GlobalMemory memory = hardware.getMemory();
        CentralProcessor processor = hardware.getProcessor();
        // CPU信息
        System.out.println("系统运行时间：" + operatingSystem.getSystemUptime());
        System.out.println("CPU核心数：" + processor.getLogicalProcessorCount());
        System.out.println("CPU线程数：" + processor.getPhysicalProcessorCount());
        long totalByte = memory.getTotal();
        //剩余
        long availableByte = memory.getAvailable();
        System.out.println("系统总内存：" + formatByte(totalByte));
        System.out.println("已使用内存：" + formatByte(totalByte - availableByte));
        System.out.println("内存使用率：" + new DecimalFormat("#.##%").format((totalByte - availableByte) * 1.0 / totalByte));

        //jvm参数
        Runtime runtime = Runtime.getRuntime();
        long jvmTotalMemoryByte = runtime.totalMemory();
        long freeMemoryByte = runtime.freeMemory();
        System.out.println("jvm内存使用率：" + new DecimalFormat("#.##%").format((jvmTotalMemoryByte - freeMemoryByte) * 1.0 / jvmTotalMemoryByte));
    }

    /**
     * 单位转换
     */
    private static String formatByte(long byteNumber) {
        //换算单位
        double FORMAT = 1024.0;
        double kbNumber = byteNumber / FORMAT;
        if (kbNumber < FORMAT) {
            return new DecimalFormat("#.##KB").format(kbNumber);
        }
        double mbNumber = kbNumber / FORMAT;
        if (mbNumber < FORMAT) {
            return new DecimalFormat("#.##MB").format(mbNumber);
        }
        double gbNumber = mbNumber / FORMAT;
        if (gbNumber < FORMAT) {
            return new DecimalFormat("#.##GB").format(gbNumber);
        }
        double tbNumber = gbNumber / FORMAT;
        return new DecimalFormat("#.##TB").format(tbNumber);
    }

    }
