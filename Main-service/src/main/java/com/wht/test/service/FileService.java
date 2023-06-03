package com.wht.test.service;

import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import com.wht.client.Result;
import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import com.wht.client.form.file.AddFileTypeForm;
import com.wht.client.form.file.EditFileTypeForm;
import com.wht.client.obj.FileTypeDo;
import com.wht.client.util.StorageUtil;
import com.wht.test.repository.FileTypeRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;


/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/27 16:58
 */
@Service
public class FileService {
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private FileTypeRepository fileTypeRepository;

    public String upload(MultipartFile file,String type) {
        if (type == null || type.equals("")) type = "default";
        FileInfo fileInfo = fileStorageService.of(file)
                .setPath("file/")
                .setObjectId(StorageUtil.get())
                .setObjectType(type)
                .putAttr("platform","七牛云")
                .upload();
        if (fileInfo == null) {
            throw new CustomException(ErrorCode.FILE_UPLOAD_FAILED);
        }
        return fileInfo.getUrl();
    }

    public String uploadImage(MultipartFile file) {
        FileInfo fileInfo = fileStorageService.of(file)
                .setPath("/image")
                .setObjectId(StorageUtil.get())
                .setObjectType("user")
                .putAttr("platform","七牛云")
                .image(img -> img.size(1000, 1000))  //将图片大小调整到 1000*1000
                .upload();
        if (fileInfo == null) {
            throw new CustomException(ErrorCode.FILE_UPLOAD_FAILED);
        }
        return fileInfo.getUrl();
    }

    public void deleteFileByUrl(String url) {
        fileStorageService.delete(url);
    }

    public void downloadFile(String url, HttpServletResponse response) {
        //获取文件
        FileInfo fileInfo = fileStorageService.getFileInfoByUrl(url);
        if (fileInfo == null) {
            throw new CustomException(ErrorCode.FILE_NOT_EXISTED);
        }
        //设置响应头
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileInfo.getOriginalFilename());

        //写入响应流中
        try {
            OutputStream outputStream = response.getOutputStream();
            fileStorageService.download(url).outputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Result addFileType(AddFileTypeForm addFileTypeForm) {
        FileTypeDo fileTypeDo = new FileTypeDo();
        fileTypeDo.setImage(addFileTypeForm.getImage());
        fileTypeDo.setTitle(addFileTypeForm.getTitle());
        fileTypeDo.setDescription(addFileTypeForm.getDescription());
        fileTypeRepository.save(fileTypeDo);
        return Result.success();
    }

    public Result getAllFileType() {
        return Result.success(fileTypeRepository.findAll());
    }

    public Result deleteFileType(String id) {
        fileTypeRepository.deleteById(id);
        return Result.success();
    }

    public Result editFileType(EditFileTypeForm editFileTypeForm) {
        if (editFileTypeForm.getId() == null) {
            throw new CustomException(ErrorCode.FILE_TYPE_NOT_EXISTED);
        }
        FileTypeDo fileTypeDo = new FileTypeDo();
        fileTypeDo.setImage(editFileTypeForm.getImage());
        fileTypeDo.setTitle(editFileTypeForm.getTitle());
        fileTypeDo.setDescription(editFileTypeForm.getDescription());
        fileTypeDo.setId(editFileTypeForm.getId());
        Optional<FileTypeDo> fileTypeDoOptional = fileTypeRepository.findById(editFileTypeForm.getId());
        if (!fileTypeDoOptional.isPresent()) {
            throw new CustomException(ErrorCode.FILE_TYPE_NOT_EXISTED);
        }
        fileTypeRepository.save(fileTypeDo);
        return Result.success();
    }

    public FileTypeDo getFileTypeById(String id) {
        Optional<FileTypeDo> fileTypeDoOptional = fileTypeRepository.findById(id);
        if (!fileTypeDoOptional.isPresent()) {
            throw new CustomException(ErrorCode.FILE_TYPE_NOT_EXISTED);
        }
        return fileTypeDoOptional.get();
    }
}
