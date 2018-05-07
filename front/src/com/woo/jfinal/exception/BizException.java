/*    */ package com.woo.jfinal.exception;
/*    */ 
/*    */ public class BizException extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 8133786349562154746L;
/*    */   
/*    */   public BizException() {}
/*    */   
/*    */   public BizException(String message, Throwable cause)
/*    */   {
/* 11 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public BizException(String message) {
/* 15 */     super(message);
/*    */   }
/*    */   
/*    */   public BizException(Throwable cause) {
/* 19 */     super(cause);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\woo\jfinal\exception\BizException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */