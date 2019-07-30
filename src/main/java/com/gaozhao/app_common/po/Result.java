package com.gaozhao.app_common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
*
* @ClassName: Result.java
* @Description: API返回的结果封装类
 */
@ApiModel
public class Result{

    private String code;//返回的代码，成功为"OK"，错误为"ERROR"

    private String msg;//错误消息

    private Object data;//成功情况下返回的数据

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //getter-----------
    @ApiModelProperty(value = "响应码",example = "成功为OK，错误为ERROR",dataType = "String")
    public String getCode() {
        return code;
    }

    @ApiModelProperty(value = "返回的信息",example = "错误情况下返回错误信息，成功时返回空字符串",dataType = "String")
    public String getMsg() {
        return msg;
    }

    @ApiModelProperty(value = "返回的json格式数据,如果响应吗为ERROR时,该字段为空字符串",dataType = "String")
    public Object getData() {
        return data;
    }

    //setter-----

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
