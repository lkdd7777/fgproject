package com.fgoa.web.utils;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlUtils {
	public static String getPureTextFromHtml(String htmlContent) {
		if (StringUtils.isBlank(htmlContent)) {
			htmlContent = "";
		}
		return Jsoup.parse(htmlContent).text();
	}
}
