package zhoufazhan.com.mvp.util;

/**
 * Created by zhoufazhan on 2017/4/10.
 * 服务器返回的信息
 */

public class ResponseData<T> {
    //返回成功
    public static final int SUCCESS = 1;
    //返回失败
    public static final int FAILED = 0;
    //返回状态码
    private int code;
    //返回错误信息 当return_code=FAIL时有信息
    private String msg;
    //返回数据 当return_code=SUCCESS时有信息
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
