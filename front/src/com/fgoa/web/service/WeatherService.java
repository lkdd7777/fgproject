/*    */ package com.fgoa.web.service;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.fgoa.web.vo.WeatherVo;
/*    */ import com.woo.jfinal.utils.HttpExecutor;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.apache.http.impl.client.DefaultHttpClient;
/*    */ 
/*    */ public class WeatherService
/*    */ {
/* 12 */   public static final WeatherService instance = new WeatherService();
/*    */   private static final String REQUEST_PATH = "http://api.map.baidu.com/telematics/v3/weather?location=武汉&output=json&ak=qYM5KakIUDwdR3RGcSkaxbse";
/*    */   
/*    */   public WeatherVo getWeatherInfo()
/*    */   {
/* 17 */     HttpExecutor executor = new HttpExecutor(new DefaultHttpClient());
/* 18 */     String result = executor.get("http://api.map.baidu.com/telematics/v3/weather?location=武汉&output=json&ak=qYM5KakIUDwdR3RGcSkaxbse");
/*    */     
/* 20 */     JSONObject resultJson = com.woo.jfinal.utils.JSONUtils.buildJson(result);
/* 21 */     WeatherVo info = new WeatherVo();
/* 22 */     if ((resultJson != null) && 
/* 23 */       (StringUtils.equalsIgnoreCase(resultJson.getString("status"), "success")))
/*    */     {
/* 25 */       JSONObject weatherInfo = resultJson.getJSONArray("results")
/* 26 */         .getJSONObject(0).getJSONArray("weather_data")
/* 27 */         .getJSONObject(0);
/*    */       
/* 29 */       info.setSuccess(true);
/* 30 */       info.setDate(weatherInfo.getString("date"));
/* 31 */       info.setDayPictureUrl(weatherInfo.getString("dayPictureUrl"));
/* 32 */       info.setNightPictureUrl(weatherInfo.getString("nightPictureUrl"));
/* 33 */       info.setPm25(resultJson.getJSONArray("results").getJSONObject(0)
/* 34 */         .getString("pm25"));
/* 35 */       info.setWeather(weatherInfo.getString("weather"));
/* 36 */       info.setWind(weatherInfo.getString("wind"));
/* 37 */       info.setTemperature(weatherInfo.getString("temperature"));
/*    */       
/* 39 */       String weatherStr = info.getWeather();
/*    */       
/* 41 */       if (StringUtils.contains(weatherStr, "雪")) {
/* 42 */         info.setPictureUrl("xue.png");
/* 43 */       } else if (StringUtils.contains(weatherStr, "雨")) {
/* 44 */         info.setPictureUrl("yu.png");
/* 45 */       } else if (StringUtils.contains(weatherStr, "云")) {
/* 46 */         info.setPictureUrl("yun.png");
/* 47 */       } else if (StringUtils.contains(weatherStr, "阴")) {
/* 48 */         info.setPictureUrl("yin.png");
/* 49 */       } else if (StringUtils.contains(weatherStr, "风")) {
/* 50 */         info.setPictureUrl("feng.png");
/* 51 */       } else if (StringUtils.contains(weatherStr, "雷")) {
/* 52 */         info.setPictureUrl("lei.png");
/* 53 */       } else if (StringUtils.contains(weatherStr, "晴")) {
/* 54 */         info.setPictureUrl("qing.png");
/*    */       } else {
/* 56 */         info.setPictureUrl("unknow.png");
/*    */ 
/*    */       }
/*    */       
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 65 */       info.setSuccess(false);
/*    */     }
/* 67 */     return info;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\WeatherService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */