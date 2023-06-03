package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.form.file.AddFileTypeForm;
import com.wht.client.form.file.EditFileTypeForm;
import com.wht.client.obj.FileInfoDo;
import com.wht.client.obj.FileTypeDo;
import com.wht.test.service.FileDetailService;
import com.wht.test.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/27 16:57
 */
@RequestMapping("/api")
@RestController
public class FileController {
    @Autowired
    FileService fileService;
    @Autowired
    FileDetailService fileDetailService;

    /**
     * 获取所有文件信息
     * @return 文件信息列表
     */
    @GetMapping("/getAllFiles")
    public Result<List<FileInfoDo>> getAllFiles() {
        return Result.success(fileDetailService.getAllFiles());
    }

    @PostMapping("/editFileInfo")
    public Result editFilInfo(@RequestBody FileInfoDo fileInfoDo) {
        fileDetailService.editFileInfo(fileInfoDo);
        return Result.success();
    }

    /**
     * 根据文件类型查找文件
     * @param typeId
     * @return
     */
    @GetMapping("/getFilesByTypeId")
    public Result<List<FileInfoDo>> getFilesByType(String typeId) {
        FileTypeDo fileTypeDo = fileService.getFileTypeById(typeId);
        return Result.success(fileDetailService.getFilesByType(fileTypeDo.getTitle()));
    }

    /**
     * 上传文件，成功返回文件 url
     * @param file 要上传的文件
     * @return 文件url
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file,String type) {
        return Result.success(fileService.upload(file,type));
    }

    /**
     * 上传图片
     * @param file
     * @return 图片url
     */
    @PostMapping("/uploadImage")
    public Result<String> uploadImage(MultipartFile file) {
        return Result.success(fileService.uploadImage(file));
    }

    /**
     * 根据文件url删除文件
     * @param url 文件url
     * @return 执行结果
     */
    @PostMapping("/deleteFileByUrl")
    public Result deleteFile(String url) {
        fileService.deleteFileByUrl(url);
        return Result.success();
    }

    /**
     * 根据url下载文件
     * @param url 文件url
     * @param response 文件流
     */
    @GetMapping("/downloadFile")
    public void downloadFile(String url, HttpServletResponse response) {
        fileService.downloadFile(url, response);
    }

    /**
     * 增加文件分类
     * @param addFileTypeForm
     * @return
     */
    @PostMapping("/addFileType")
    public Result addFileType(@RequestBody AddFileTypeForm addFileTypeForm) {
        return fileService.addFileType(addFileTypeForm);
    }

    /**
     * 获取所有文件分类信息
     * @return
     */
    @GetMapping("/getAllFileType")
    public Result getAllFileType() {
        return fileService.getAllFileType();
    }

    @GetMapping("/getFileTypeById")
    public Result getFileTypeById(String id) {
        return Result.success(fileService.getFileTypeById(id));
    }

    /**
     * 删除文件分类信息
     * @param id
     * @return
     */
    @PostMapping("/deleteFileType")
    public Result deleteFileType(String id) {
        return fileService.deleteFileType(id);
    }

    /**
     * 编辑文件类型
     * @param editFileTypeForm
     * @return
     */
    @PostMapping("/editFileType")
    public Result editFileType(@RequestBody EditFileTypeForm editFileTypeForm) {
        return fileService.editFileType(editFileTypeForm);
    }

}
