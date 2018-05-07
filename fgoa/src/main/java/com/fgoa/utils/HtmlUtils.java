package com.fgoa.utils;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;

public class HtmlUtils {

	/**
	 * 从html文本中提取纯文本
	 * @param htmlContent
	 * @return
	 */
	public static String getPureTextFromHtml(String htmlContent){
		if(StringUtils.isBlank(htmlContent)){
			//jsoup解析null值会报错
			htmlContent="";
		}
		return Jsoup.parse(htmlContent).text();
	}
	
}
