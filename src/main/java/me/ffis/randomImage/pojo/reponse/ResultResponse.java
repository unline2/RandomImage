package me.ffis.randomImage.pojo.reponse;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by fanfan on 2019/12/05.
 */

@Data
@ToString
@NoArgsConstructor
public class ResultResponse implements Result {

    //操作是否成功
    private boolean flag;
    //操作代码
    private Integer code;
    //提示信息
    private String message;
    //返回数据
    private Object data;

    public ResultResponse(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public ResultResponse(Result result) {
        this.flag = result.flag();
        this.code = result.code();
        this.message = result.message();
    }

    public ResultResponse(Result result, Object data) {
        this.flag = result.flag();
        this.code = result.code();
        this.message = result.message();
        this.data = data;
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
