package com.wht.test.service;

import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.recorder.FileRecorder;
import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import com.wht.client.obj.FileInfoDo;
import com.wht.test.repository.FileInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/27 20:27
 */
@Service
public class FileDetailService  implements FileRecorder {
    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public boolean record(FileInfo fileInfo) {
        FileInfoDo fileInfoDo = new FileInfoDo();
        BeanUtils.copyProperties(fileInfo,fileInfoDo);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fileInfoDo.setCreateTime(dateFormat.format(new Date()));
        return fileInfoRepository.save(fileInfoDo) != null;
    }

    @Override
    public FileInfo getByUrl(String url) {
        FileInfoDo fileInfoDo = fileInfoRepository.findByUrl(url);
        FileInfo fileInfo = new FileInfo();
        BeanUtils.copyProperties(fileInfoDo,fileInfo);
        return fileInfo;
    }

    @Override
    public boolean delete(String url) {
        return fileInfoRepository.deleteByUrl(url) == 1;
    }

    public List<FileInfoDo> getAllFiles() {
        return fileInfoRepository.findAll();
    }

    public List<FileInfoDo> getFilesByType(String type) {
        return fileInfoRepository.findAllByObjectType(type);
    }

    public void editFileInfo(FileInfoDo fileInfoDo) {
        String id = fileInfoDo.getId();
        if (id == null || id.equals("") || !fileInfoRepository.findById(id).isPresent()) {
            throw new CustomException(ErrorCode.FILE_NOT_EXISTED);
        }
        fileInfoRepository.save(fileInfoDo);
    }
}
