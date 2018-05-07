/*    */ package com.jfinal.weixin.sdk.encrypt;
/*    */ 
/*    */ 
/*    */ public class AesException
/*    */   extends Exception
/*    */ {
/*    */   public static final int OK = 0;
/*    */   
/*    */   public static final int ValidateSignatureError = -40001;
/*    */   
/*    */   public static final int ParseXmlError = -40002;
/*    */   public static final int ComputeSignatureError = -40003;
/*    */   public static final int IllegalAesKey = -40004;
/*    */   public static final int ValidateAppidError = -40005;
/*    */   public static final int EncryptAESError = -40006;
/*    */   public static final int DecryptAESError = -40007;
/*    */   public static final int IllegalBuffer = -40008;
/*    */   private int code;
/*    */   
/*    */   private static String getMessage(int code)
/*    */   {
/* 22 */     switch (code) {
/*    */     case -40001: 
/* 24 */       return "签名验证错误";
/*    */     case -40002: 
/* 26 */       return "xml解析失败";
/*    */     case -40003: 
/* 28 */       return "sha加密生成签名失败";
/*    */     case -40004: 
/* 30 */       return "SymmetricKey非法";
/*    */     case -40005: 
/* 32 */       return "appid校验失败";
/*    */     case -40006: 
/* 34 */       return "aes加密失败";
/*    */     case -40007: 
/* 36 */       return "aes解密失败";
/*    */     case -40008: 
/* 38 */       return "解密后得到的buffer非法";
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 46 */     return null;
/*    */   }
/*    */   
/*    */   public int getCode()
/*    */   {
/* 51 */     return this.code;
/*    */   }
/*    */   
/*    */   AesException(int code) {
/* 55 */     super(getMessage(code));
/* 56 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\encrypt\AesException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */