/*    */ package com.jfinal.weixin.sdk.kit;
/*    */ 
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.kit.HashKit;
/*    */ import com.jfinal.weixin.sdk.api.ApiConfig;
/*    */ import com.jfinal.weixin.sdk.api.ApiConfigKit;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SignatureCheckKit
/*    */ {
/* 23 */   public static final SignatureCheckKit me = new SignatureCheckKit();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean checkSignature(String signature, String timestamp, String nonce)
/*    */   {
/* 45 */     String TOKEN = ApiConfigKit.getApiConfig().getToken();
/* 46 */     String[] array = { TOKEN, timestamp, nonce };
/* 47 */     Arrays.sort(array);
/* 48 */     String tempStr = new StringBuilder(String.valueOf(array[0])).append(array[1]).append(array[2]).toString();
/* 49 */     tempStr = HashKit.sha1(tempStr);
/* 50 */     return tempStr.equalsIgnoreCase(signature);
/*    */   }
/*    */   
/*    */   public boolean checkSignature(Controller c) {
/* 54 */     return checkSignature(c.getPara("signature"), c.getPara("timestamp"), c.getPara("nonce"));
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\kit\SignatureCheckKit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */