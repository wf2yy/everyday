package com.smile.tkpro.common;

/**
 * 
 * <p>Description: [API 请求结果-状态码]</p>
 * @author  郑成德
 * @version 1.0 
 */
public enum APIStatus {
	/** 404 Not Found. 访问的API不存在. */
	NOT_FOUND_404(404, "Not Found."),
	/** 403 Not Found. 禁止访问,没有权限. */
	FORBIDDEN_403(403, "Forbidden."),
	/** 401 Unauthorized. 未登录或登录状态已失效. */
	UNAUTHORIZED_401(401, "Unauthorized."),
	/** 200 Ok. 请求处理成功. */
	OK_200(200, "Ok"),
	/** 500 Internal Server Error. 服务器内部错误,请求处理失败. */
	ERROR_500(500, "Internal Server Error."),
	/** 400 Bad Request. 请求参数有问题. */
	ERROR_400(400, "Bad Request.");
	
	private int code;
	private String message;
	private  APIStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	
}
