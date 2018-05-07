/*     */ package com.jfinal.weixin.sdk.encrypt;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.StringReader;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WXBizMsgCryptTest
/*     */ {
/*  24 */   String encodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
/*  25 */   String token = "pamtest";
/*  26 */   String timestamp = "1409304348";
/*  27 */   String nonce = "xxxxxx";
/*  28 */   String appId = "wxb11529c136998cb6";
/*  29 */   String replyMsg = "我是中文abcd123";
/*  30 */   String xmlFormat = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
/*  31 */   String afterAesEncrypt = "jn1L23DB+6ELqJ+6bruv21Y6MD7KeIfP82D6gU39rmkgczbWwt5+3bnyg5K55bgVtVzd832WzZGMhkP72vVOfg==";
/*  32 */   String randomStr = "aaaabbbbccccdddd";
/*     */   
/*  34 */   String replyMsg2 = "<xml><ToUserName><![CDATA[oia2Tj我是中文jewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";
/*  35 */   String afterAesEncrypt2 = "jn1L23DB+6ELqJ+6bruv23M2GmYfkv0xBh2h+XTBOKVKcgDFHle6gqcZ1cZrk3e1qjPQ1F4RsLWzQRG9udbKWesxlkupqcEcW7ZQweImX9+wLMa0GaUzpkycA8+IamDBxn5loLgZpnS7fVAbExOkK5DYHBmv5tptA9tklE/fTIILHR8HLXa5nQvFb3tYPKAlHF3rtTeayNf0QuM+UW/wM9enGIDIJHF7CLHiDNAYxr+r+OrJCmPQyTy8cVWlu9iSvOHPT/77bZqJucQHQ04sq7KZI27OcqpQNSto2OdHCoTccjggX5Z9Mma0nMJBU+jLKJ38YB1fBIz+vBzsYjrTmFQ44YfeEuZ+xRTQwr92vhA9OxchWVINGC50qE/6lmkwWTwGX9wtQpsJKhP+oS7rvTY8+VdzETdfakjkwQ5/Xka042OlUb1/slTwo4RscuQ+RdxSGvDahxAJ6+EAjLt9d8igHngxIbf6YyqqROxuxqIeIch3CssH/LqRs+iAcILvApYZckqmA7FNERspKA5f8GoJ9sv8xmGvZ9Yrf57cExWtnX8aCMMaBropU/1k+hKP5LVdzbWCG0hGwx/dQudYR/eXp3P0XxjlFiy+9DMlaFExWUZQDajPkdPrEeOwofJb";
/*     */   
/*     */   public void testNormal() throws ParserConfigurationException, SAXException, IOException {
/*     */     try {
/*  39 */       WXBizMsgCrypt pc = new WXBizMsgCrypt(this.token, this.encodingAesKey, this.appId);
/*  40 */       String afterEncrpt = pc.encryptMsg(this.replyMsg, this.timestamp, this.nonce);
/*     */       
/*  42 */       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/*  43 */       DocumentBuilder db = dbf.newDocumentBuilder();
/*  44 */       StringReader sr = new StringReader(afterEncrpt);
/*  45 */       InputSource is = new InputSource(sr);
/*  46 */       Document document = db.parse(is);
/*     */       
/*  48 */       Element root = document.getDocumentElement();
/*  49 */       NodeList nodelist1 = root.getElementsByTagName("Encrypt");
/*  50 */       NodeList nodelist2 = root.getElementsByTagName("MsgSignature");
/*     */       
/*  52 */       String encrypt = nodelist1.item(0).getTextContent();
/*  53 */       String msgSignature = nodelist2.item(0).getTextContent();
/*  54 */       String fromXML = String.format(this.xmlFormat, new Object[] { encrypt });
/*     */       
/*     */ 
/*  57 */       String str1 = pc.decryptMsg(msgSignature, this.timestamp, this.nonce, fromXML);
/*     */     }
/*     */     catch (AesException localAesException) {}
/*     */   }
/*     */   
/*     */   public void testAesEncrypt()
/*     */   {
/*     */     try
/*     */     {
/*  66 */       WXBizMsgCrypt localWXBizMsgCrypt = new WXBizMsgCrypt(this.token, this.encodingAesKey, this.appId);
/*     */     }
/*     */     catch (AesException e) {
/*  69 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void testAesEncrypt2()
/*     */   {
/*     */     try {
/*  76 */       WXBizMsgCrypt localWXBizMsgCrypt = new WXBizMsgCrypt(this.token, this.encodingAesKey, this.appId);
/*     */     }
/*     */     catch (AesException e)
/*     */     {
/*  80 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void testIllegalAesKey()
/*     */   {
/*     */     try {
/*  87 */       new WXBizMsgCrypt(this.token, "abcde", this.appId);
/*     */     }
/*     */     catch (AesException e) {}
/*     */   }
/*     */   
/*     */ 
/*     */   public void testValidateSignatureError()
/*     */     throws ParserConfigurationException, SAXException, IOException
/*     */   {
/*     */     try
/*     */     {
/*  98 */       WXBizMsgCrypt pc = new WXBizMsgCrypt(this.token, this.encodingAesKey, this.appId);
/*  99 */       String afterEncrpt = pc.encryptMsg(this.replyMsg, this.timestamp, this.nonce);
/* 100 */       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/* 101 */       DocumentBuilder db = dbf.newDocumentBuilder();
/* 102 */       StringReader sr = new StringReader(afterEncrpt);
/* 103 */       InputSource is = new InputSource(sr);
/* 104 */       Document document = db.parse(is);
/*     */       
/* 106 */       Element root = document.getDocumentElement();
/* 107 */       NodeList nodelist1 = root.getElementsByTagName("Encrypt");
/*     */       
/* 109 */       String encrypt = nodelist1.item(0).getTextContent();
/* 110 */       String fromXML = String.format(this.xmlFormat, new Object[] { encrypt });
/* 111 */       pc.decryptMsg("12345", this.timestamp, this.nonce, fromXML);
/*     */     }
/*     */     catch (AesException e) {}
/*     */   }
/*     */   
/*     */ 
/*     */   public void testVerifyUrl()
/*     */     throws AesException
/*     */   {
/* 120 */     WXBizMsgCrypt wxcpt = new WXBizMsgCrypt("QDG6eK", 
/* 121 */       "jWmYm7qr5nMoAUwZRjGtBxmz3KA1tkAj3ykkR6q2B2C", "wx5823bf96d3bd56c7");
/* 122 */     String verifyMsgSig = "5c45ff5e21c57e6ad56bac8758b79b1d9ac89fd3";
/* 123 */     String timeStamp = "1409659589";
/* 124 */     String nonce = "263014780";
/* 125 */     String echoStr = "P9nAzCzyDtyTWESHep1vC5X9xho/qYX3Zpb4yKa9SKld1DsH3Iyt3tP3zNdtp+4RPcs8TgAE7OaBO+FZXvnaqQ==";
/* 126 */     wxcpt.verifyUrl(verifyMsgSig, timeStamp, nonce, echoStr);
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\encrypt\WXBizMsgCryptTest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */