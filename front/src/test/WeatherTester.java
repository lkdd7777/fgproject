/*    */ package test;
/*    */ 
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.fgoa.web.vo.WeatherVo;
/*    */ import com.woo.jfinal.utils.HttpExecutor;
/*    */ import com.woo.jfinal.utils.JSONUtils;
/*    */ import org.apache.http.impl.client.DefaultHttpClient;
/*    */ 
/*    */ public class WeatherTester
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 14 */     HttpExecutor executor = new HttpExecutor(new DefaultHttpClient());
/* 15 */     String result = executor
/* 16 */       .get("http://api.map.baidu.com/telematics/v3/weather?location=武汉&output=json&ak=qYM5KakIUDwdR3RGcSkaxbse");
/*    */     
/* 18 */     JSONObject resultJson = JSONUtils.buildJson(result);
/* 19 */     WeatherVo info = new WeatherVo();
/*    */     
/* 21 */     if (org.apache.commons.lang.StringUtils.equalsIgnoreCase(resultJson.getString("status"), "success"))
/*    */     {
/* 23 */       JSONObject weatherInfo = resultJson.getJSONArray("results")
/* 24 */         .getJSONObject(0).getJSONArray("weather_data")
/* 25 */         .getJSONObject(0);
/*    */       
/* 27 */       info.setSuccess(true);
/* 28 */       info.setDate(weatherInfo.getString("date"));
/* 29 */       info.setDayPictureUrl(weatherInfo.getString("dayPictureUrl"));
/* 30 */       info.setNightPictureUrl(weatherInfo.getString("nightPictureUrl"));
/* 31 */       info.setPm25(resultJson.getJSONArray("results").getJSONObject(0)
/* 32 */         .getString("pm25"));
/* 33 */       info.setWeather(weatherInfo.getString("weather"));
/* 34 */       info.setWind(weatherInfo.getString("wind"));
/*    */     } else {
/* 36 */       info.setSuccess(false);
/*    */     }
/*    */     
/* 39 */     System.out.println(info);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\test\WeatherTester.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */