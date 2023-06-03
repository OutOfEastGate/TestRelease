package com.wht.client.exception;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 16:40
 */
public enum ErrorCode {
    USER_LOGIN_ERROR("401", "未登录"),
    IP_LIMIT("403","访问频繁"),
    ERROR("500", "服务器繁忙"),
    ARTICLE_NOT_EXIST("501","文章不存在"),
    PERMISSION_DENY("503","没有权限"),
    FILE_UPLOAD_FAILED("504","文件上传失败"),
    FILE_NOT_EXISTED("505","文件不存在"),
    USER_UPDATE_EXCEPTION("506","用户更新失败"),
    FILE_TYPE_NOT_EXISTED("507","文件分类不存在"),
    MAIL_ERROR("508","邮件发送失败"),
    USER_NOT_EXISTED("509", "用户不存在"),
    TIME_EXISTED("510", "结束时间不可早于当前时间");


    private final String code;
    private final String msg;
    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
