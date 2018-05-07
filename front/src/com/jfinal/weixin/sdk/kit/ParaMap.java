/*    */ package com.jfinal.weixin.sdk.kit;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ParaMap
/*    */ {
/*  8 */   private Map<String, String> data = new HashMap();
/*    */   
/*    */   public static ParaMap create()
/*    */   {
/* 12 */     return new ParaMap();
/*    */   }
/*    */   
/*    */   public static ParaMap create(String key, String value) {
/* 16 */     return create().put(key, value);
/*    */   }
/*    */   
/*    */   public ParaMap put(String key, String value) {
/* 20 */     this.data.put(key, value);
/* 21 */     return this;
/*    */   }
/*    */   
/*    */   public Map<String, String> getData() {
/* 25 */     return this.data;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\kit\ParaMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */