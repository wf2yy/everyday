package com.smile.tkpro.common;

import com.alibaba.fastjson.JSONObject;
/**
 * 
 * <p>Description: [API调用结果json]</p>
 * @author  <a href="mailto: hanshixiong@camelotchina.com">郑成德</a>
 * @version 1.0 
 */
public class ApiResponse {
	/**
	 * 
	 * <p>Description:[获取标准格式返回结果]</p>
	 * @param status required APIStatus 
	 * @param data 结果集
	 * @return {"status":{"code":xxx,"message":"xxx"},"data":{xxx}}
	 * @author[郑成德]
	 */
	public static String data(APIStatus status, Object data) {
		JSONObject result = new JSONObject();
		JSONObject statusJson = new JSONObject();
		statusJson.put("code", status.getCode());
		statusJson.put("message", status.getMessage());
		result.put("status", statusJson);
		result.put("data", data);
		return result.toJSONString();
	}
	/**
	 * 
	 * <p>Description:[获取标准格式返回结果]</p>
	 * @param status required APIStatus 
	 * @param data 结果集
	 * @return {"status":{"code":xxx,"message":"xxx"},"data":{xxx}}
	 * @author[郑成德]
	 */
	public static JSONObject jsonData(APIStatus status, Object data) {
		JSONObject result = new JSONObject();
		JSONObject statusJson = new JSONObject();
		statusJson.put("code", status.getCode());
		statusJson.put("message", status.getMessage());
		result.put("status", statusJson);
		result.put("data", data);
		return result;
	}
	/**
	 * 
	 * <p>Description:[获取标准格式返回结果]</p>
	 * @param status required APIStatus 
	 * @return {"status":{"code":xxx,"message":"xxx"}}
	 * @author[郑成德]
	 */
	public static String data(APIStatus status) {
		JSONObject result = new JSONObject();
		JSONObject statusJson = new JSONObject();
		statusJson.put("code", status.getCode());
		statusJson.put("message", status.getMessage());
		result.put("status", statusJson);
		return result.toJSONString();
	}
	/**
	 * 
	 * <p>Description:[获取标准格式返回结果]</p>
	 * @param status required APIStatus 
	 * @return {"status":{"code":xxx,"message":"xxx"}}
	 * @author[郑成德]
	 */
	public static JSONObject jsonData(APIStatus status) {
		JSONObject result = new JSONObject();
		JSONObject statusJson = new JSONObject();
		statusJson.put("code", status.getCode());
		statusJson.put("message", status.getMessage());
		result.put("status", statusJson);
		return result;
	}
	
	/**
	 * 
	 * <p>Description:[获取请求处理成功返回结果]</p>
	 * @return {"status":{"code":200,"message":"ok"}}
	 * @author[郑成德]
	 */
	public static JSONObject success() {
		return jsonData(APIStatus.OK_200);
	}

	/**
	 * 
	 * <p>Description:[获取请求处理成功返回结果]</p>
	 * @param data 返回数据 
	 * @return {"status":{"code":200,"message":"ok"},"data":xxx}
	 * @author[郑成德]
	 */
	public static JSONObject success(Object data) {
		return jsonData(APIStatus.OK_200, data);
	}

	/**
	 * 
	 * <p>Description:[获取请求参数错误返回结果]</p>
	 * @return {"status":{"code":400,"message":"Bad Request."}}
	 * @author[郑成德]
	 */
	public static JSONObject errorPara() {
		return jsonData(APIStatus.ERROR_400);
	}
	
	/**
	 * 
	 * <p>Description:[获取请求参数错误返回结果]</p>
	 * @param data 返回数据 
	 * @return {"status":{"code":400,"message":"Bad Request."},"data":xxx}
	 * @author[郑成德]
	 */
	public static JSONObject errorPara(Object data) {
		return jsonData(APIStatus.ERROR_400, data);
	}
	
}
