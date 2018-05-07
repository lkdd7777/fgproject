/*    */ package com.jfinal.weixin.sdk.encrypt;
/*    */ 
/*    */ import java.security.MessageDigest;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class SHA1
/*    */ {
/*    */   public static String getSHA1(String token, String timestamp, String nonce, String encrypt)
/*    */     throws AesException
/*    */   {
/*    */     try
/*    */     {
/* 33 */       String[] array = { token, timestamp, nonce, encrypt };
/* 34 */       StringBuffer sb = new StringBuffer();
/*    */       
/* 36 */       Arrays.sort(array);
/* 37 */       for (int i = 0; i < 4; i++) {
/* 38 */         sb.append(array[i]);
/*    */       }
/* 40 */       String str = sb.toString();
/*    */       
/* 42 */       MessageDigest md = MessageDigest.getInstance("SHA-1");
/* 43 */       md.update(str.getBytes());
/* 44 */       byte[] digest = md.digest();
/*    */       
/* 46 */       StringBuffer hexstr = new StringBuffer();
/* 47 */       String shaHex = "";
/* 48 */       for (int i = 0; i < digest.length; i++) {
/* 49 */         shaHex = Integer.toHexString(digest[i] & 0xFF);
/* 50 */         if (shaHex.length() < 2) {
/* 51 */           hexstr.append(0);
/*    */         }
/* 53 */         hexstr.append(shaHex);
/*    */       }
/* 55 */       return hexstr.toString();
/*    */     } catch (Exception e) {
/* 57 */       e.printStackTrace();
/* 58 */       throw new AesException(-40003);
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\encrypt\SHA1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */