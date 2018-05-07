/*    */ package com.jfinal.weixin.sdk.encrypt;
/*    */ 
/*    */ import java.nio.charset.Charset;
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
/*    */ class PKCS7Encoder
/*    */ {
/* 18 */   static Charset CHARSET = Charset.forName("utf-8");
/* 19 */   static int BLOCK_SIZE = 32;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static byte[] encode(int count)
/*    */   {
/* 29 */     int amountToPad = BLOCK_SIZE - count % BLOCK_SIZE;
/* 30 */     if (amountToPad == 0) {
/* 31 */       amountToPad = BLOCK_SIZE;
/*    */     }
/*    */     
/* 34 */     char padChr = chr(amountToPad);
/* 35 */     String tmp = new String();
/* 36 */     for (int index = 0; index < amountToPad; index++) {
/* 37 */       tmp = tmp + padChr;
/*    */     }
/* 39 */     return tmp.getBytes(CHARSET);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static byte[] decode(byte[] decrypted)
/*    */   {
/* 49 */     int pad = decrypted[(decrypted.length - 1)];
/* 50 */     if ((pad < 1) || (pad > 32)) {
/* 51 */       pad = 0;
/*    */     }
/* 53 */     return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static char chr(int a)
/*    */   {
/* 63 */     byte target = (byte)(a & 0xFF);
/* 64 */     return (char)target;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\encrypt\PKCS7Encoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */