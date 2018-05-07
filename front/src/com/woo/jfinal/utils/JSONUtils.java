package com.woo.jfinal.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author wuchangwen
 * @desc json操作的工具类
 * 
 */

public class JSONUtils {
	
	private static final Logger LOGGER = Logger.getLogger(JSONUtils.class);
	
	/**
	 * 根据字符串生成json对象
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject buildJson(String jsonStr) {
		if(StringUtils.isBlank(jsonStr)){
			return null;
		}
		JSONObject jsonObject = null;
		try {
			jsonObject = JSONObject.parseObject(jsonStr);
		} catch (JSONException e) {
			LOGGER.error("解析JSON内容发生错误:" + e.getMessage()
					+ "--------待解析的内容为：" + jsonStr);
			return null;
		}
		return jsonObject;
	}

	/**
	 * 根据字符串获取json值
	 * @param jsonStr
	 * @param key
	 * @return
	 */
	public static String findValue(String jsonStr, String key){
		JSONObject jsonObject=buildJson(jsonStr);
		if(jsonObject==null){
			return null;
		}
		return jsonObject.getString(key);
	}

	/**
	 * 根据字符串获取json数组
	 * @param jsonStr
	 * @param key
	 * @return
	 */
	public static JSONArray findJsonArray(String jsonStr, String key){
		JSONObject jsonObject=buildJson(jsonStr);
		if(jsonObject==null){
			return null;
		}
		return jsonObject.getJSONArray(key);
	}
}
