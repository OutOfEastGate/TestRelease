package com.wht.test.service;

import com.wht.client.dto.SystemInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.text.DecimalFormat;

@AllArgsConstructor
@Service
public class SystemService {

    private final SystemInfo systemInfo;
    public SystemInfoDto getSystemInfo() {
        SystemInfoDto systemInfoDto = new SystemInfoDto();

        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        GlobalMemory memory = hardware.getMemory();
        CentralProcessor processor = hardware.getProcessor();
        // CPU信息
        long systemUptime = operatingSystem.getSystemUptime();
        long h = systemUptime/3600;
        long m = (systemUptime%3600)/60;
        long s = (systemUptime%3600)%60;

        systemInfoDto.setSystemRuntime( h+"小时"+m+"分"+s+"秒");
        systemInfoDto.setCpuNum(processor.getPhysicalProcessorCount());
        systemInfoDto.setCpuThreadNum(processor.getLogicalProcessorCount());
        long totalByte = memory.getTotal();
        long availableByte = memory.getAvailable();
        systemInfoDto.setTotalMemory(formatByte(totalByte));
        DecimalFormat df = new DecimalFormat("#.00");
        systemInfoDto.setMemoryUsage(Double.parseDouble(df.format((totalByte - availableByte) * 1.0 / totalByte)));

        //jvm参数
        Runtime runtime = Runtime.getRuntime();
        long jvmTotalMemoryByte = runtime.totalMemory();
        long freeMemoryByte = runtime.freeMemory();
        systemInfoDto.setJvmMemoryUsage(Double.parseDouble(df.format((jvmTotalMemoryByte - freeMemoryByte) * 1.0 / jvmTotalMemoryByte)));

        return systemInfoDto;
    }

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
