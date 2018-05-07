/*    */ package com.jfinal.weixin.sdk.encrypt;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ class ByteGroup {
/*  6 */   ArrayList<Byte> byteContainer = new ArrayList();
/*    */   
/*    */   public byte[] toBytes() {
/*  9 */     byte[] bytes = new byte[this.byteContainer.size()];
/* 10 */     for (int i = 0; i < this.byteContainer.size(); i++) {
/* 11 */       bytes[i] = ((Byte)this.byteContainer.get(i)).byteValue();
/*    */     }
/* 13 */     return bytes;
/*    */   }
/*    */   
/*    */   public ByteGroup addBytes(byte[] bytes) { byte[] arrayOfByte;
/* 17 */     int j = (arrayOfByte = bytes).length; for (int i = 0; i < j; i++) { byte b = arrayOfByte[i];
/* 18 */       this.byteContainer.add(Byte.valueOf(b));
/*    */     }
/* 20 */     return this;
/*    */   }
/*    */   
/*    */   public int size() {
/* 24 */     return this.byteContainer.size();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\encrypt\ByteGroup.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */