package com.gaozhao.app_common.util;


import com.gaozhao.app_common.po.Result;

/**
 * 
*
* @ClassName: ResultUtil.java
* @Description: 结果工具类
*
 */
public class ResultUtil {

	/**
	 * 
	* @Function: Result success(Object data)
	* @Description: 成功时使用默认的状态和信息
	*
	* @param:data 要返回的数据对象
	* @return：返回一个成功对象 new Result("OK","success",data)
	 */
	public static Result success(Object data) {
        return new Result("OK","success",data);
    }
	
	/**
	 * 
	* @Function: Result success(Object data)
	* @Description: 成功时使用默认的状态和信息
	*
	* @param:msg 要返回的信息
	* @return：返回一个成功对象 new Result("OK","success",data)
	*
	 */
	public static Result success(String msg) {
        return new Result("OK","success",msg);
    }

	/**
	 * 
	* @Function: Result success()
	* @Description: 使用默认的成功的信息和信息，用在返回成功时，不用返回的数据的情况下
	*
	* @return：返回一个成功对象 new Result("OK","success",null)
	*
	 */
	public static Result success() {
        return success(null);
    }

	/**
	 * 
	* @Function: Result error(String code, String msg)
	* @Description: 请求失败时，自定义返回的状态和消息
	*
	* @param:code 自定义的状态码
	* @param msg 自定义的错误消息
	* @return：new Result(code,msg,null);错误结果对象
	 */
	public static Result error(String code, String msg) {
        return new Result(code,msg,null);
    }

	/**
	 * 
	* @Function: Result error(String msg) 
	* @Description: 请求失败时，使用默认的错误状态码
	*
	* @param: msg 返回的错误消息
	* @return：new Result("ERROR",msg,null); 错误结果对象
	 */
	public static Result error(String msg) {
        return error("ERROR", msg);
    }
}
