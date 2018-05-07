/*    */ package com.jfinal.weixin.sdk.kit;
/*    */ 
/*    */ import com.jfinal.weixin.sdk.api.ApiConfig;
/*    */ import com.jfinal.weixin.sdk.api.ApiConfigKit;
/*    */ import com.jfinal.weixin.sdk.encrypt.WXBizMsgCrypt;
/*    */ import java.io.StringReader;
/*    */ import javax.xml.parsers.DocumentBuilder;
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import org.w3c.dom.Document;
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ import org.xml.sax.InputSource;
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
/*    */ public class MsgEncryptKit
/*    */ {
/*    */   private static final String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
/*    */   
/*    */   public static String encrypt(String msg, String timestamp, String nonce)
/*    */   {
/*    */     try
/*    */     {
/* 38 */       ApiConfig ac = ApiConfigKit.getApiConfig();
/* 39 */       WXBizMsgCrypt pc = new WXBizMsgCrypt(ac.getToken(), ac.getEncodingAesKey(), ac.getAppId());
/* 40 */       return pc.encryptMsg(msg, timestamp, nonce);
/*    */     }
/*    */     catch (Exception e) {
/* 43 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public static String decrypt(String encryptedMsg, String timestamp, String nonce, String msgSignature) {
/*    */     try {
/* 49 */       ApiConfig ac = ApiConfigKit.getApiConfig();
/*    */       
/* 51 */       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/* 52 */       DocumentBuilder db = dbf.newDocumentBuilder();
/* 53 */       StringReader sr = new StringReader(encryptedMsg);
/* 54 */       InputSource is = new InputSource(sr);
/* 55 */       Document document = db.parse(is);
/*    */       
/* 57 */       Element root = document.getDocumentElement();
/* 58 */       NodeList nodelist1 = root.getElementsByTagName("Encrypt");
/*    */       
/*    */ 
/* 61 */       String encrypt = nodelist1.item(0).getTextContent();
/*    */       
/*    */ 
/* 64 */       String fromXML = String.format("<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>", new Object[] { encrypt });
/*    */       
/* 66 */       String encodingAesKey = ac.getEncodingAesKey();
/* 67 */       if (encodingAesKey == null) {
/* 68 */         throw new IllegalStateException("encodingAesKey can not be null, config encodingAesKey first.");
/*    */       }
/* 70 */       WXBizMsgCrypt pc = new WXBizMsgCrypt(ac.getToken(), encodingAesKey, ac.getAppId());
/* 71 */       return pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
/*    */     }
/*    */     catch (Exception e) {
/* 74 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\kit\MsgEncryptKit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */