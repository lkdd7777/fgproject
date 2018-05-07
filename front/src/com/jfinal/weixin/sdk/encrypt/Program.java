/*    */ package com.jfinal.weixin.sdk.encrypt;
/*    */ 
/*    */ import java.io.PrintStream;
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
/*    */ public class Program
/*    */ {
/*    */   public static void main(String[] args)
/*    */     throws Exception
/*    */   {
/* 23 */     String encodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
/* 24 */     String token = "pamtest";
/* 25 */     String timestamp = "1409304348";
/* 26 */     String nonce = "xxxxxx";
/* 27 */     String appId = "wxb11529c136998cb6";
/* 28 */     String replyMsg = " 中文<xml><ToUserName><![CDATA[oia2TjjewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";
/*    */     
/* 30 */     WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
/* 31 */     String mingwen = pc.encryptMsg(replyMsg, timestamp, nonce);
/* 32 */     System.out.println("加密后: " + mingwen);
/*    */     
/* 34 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/* 35 */     DocumentBuilder db = dbf.newDocumentBuilder();
/* 36 */     StringReader sr = new StringReader(mingwen);
/* 37 */     InputSource is = new InputSource(sr);
/* 38 */     Document document = db.parse(is);
/*    */     
/* 40 */     Element root = document.getDocumentElement();
/* 41 */     NodeList nodelist1 = root.getElementsByTagName("Encrypt");
/* 42 */     NodeList nodelist2 = root.getElementsByTagName("MsgSignature");
/*    */     
/* 44 */     String encrypt = nodelist1.item(0).getTextContent();
/* 45 */     String msgSignature = nodelist2.item(0).getTextContent();
/*    */     
/* 47 */     String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
/* 48 */     String fromXML = String.format(format, new Object[] { encrypt });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 55 */     String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
/* 56 */     System.out.println("解密后明文: " + result2);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\encrypt\Program.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */