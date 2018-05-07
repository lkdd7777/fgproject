package com.woo.jfinal.utils;

import java.util.UUID;

public class UUIDUtils {

	/**
	 * 返回值包含中划线
	 * 
	 * @return
	 */
	public static String getRandomUUIDString() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 返回不包含中划线
	 * 
	 * @return
	 */
	public static String getRandomUUID() {
		return getRandomUUIDString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println(getRandomUUID());
	}
}
