package me.ffis.randomImage.pojo.reponse;

/**
 * Created by fanfan on 2019/12/05.
 */
public interface Result {
    //操作是否成功
    boolean flag();

    //操作代码
    Integer code();

    //提示信息
    String message();

    //返回信息
    Object data();
}
