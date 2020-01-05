package me.ffis.randomImage.pojo.reponse;

import lombok.ToString;

/**
 * 枚举类封装返回常量
 */
@ToString
public enum ReponseCode implements Result {
    FLUSH_SUCCESS(true, 100, "刷新缓存成功"),
    FLUSH_FAIL(false, 101, "刷新缓存失败"),
    FLUSH_IMAGES_FAIL(false, 102, "刷新图片缓存失败"),
    FLUSH_DOMAIN_FAIL(false, 103, "刷新域名缓存失败");

    //操作是否成功
    private boolean flag;
    //操作代码
    private Integer code;
    //提示信息
    private String message;
    //返回信息
    private Object data;

    ReponseCode(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean flag() {
        return flag;
    }

    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public Object data() {
        return data;
    }
}
