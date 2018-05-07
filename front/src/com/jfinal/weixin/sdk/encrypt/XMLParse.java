/*    */ package com.jfinal.weixin.sdk.encrypt;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class XMLParse
/*    */ {
/*    */   public static Object[] extract(String xmltext)
/*    */     throws AesException
/*    */   {
/* 35 */     Object[] result = new Object[3];
/*    */     try {
/* 37 */       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/* 38 */       DocumentBuilder db = dbf.newDocumentBuilder();
/* 39 */       StringReader sr = new StringReader(xmltext);
/* 40 */       InputSource is = new InputSource(sr);
/* 41 */       Document document = db.parse(is);
/*    */       
/* 43 */       Element root = document.getDocumentElement();
/* 44 */       NodeList nodelist1 = root.getElementsByTagName("Encrypt");
/* 45 */       NodeList nodelist2 = root.getElementsByTagName("ToUserName");
/* 46 */       result[0] = Integer.valueOf(0);
/* 47 */       result[1] = nodelist1.item(0).getTextContent();
/* 48 */       result[2] = nodelist2.item(0).getTextContent();
/* 49 */       return result;
/*    */     } catch (Exception e) {
/* 51 */       e.printStackTrace();
/* 52 */       throw new AesException(-40002);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String generate(String encrypt, String signature, String timestamp, String nonce)
/*    */   {
/* 66 */     String format = "<xml>\n<Encrypt><![CDATA[%1$s]]></Encrypt>\n<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n<TimeStamp>%3$s</TimeStamp>\n<Nonce><![CDATA[%4$s]]></Nonce>\n</xml>";
/*    */     
/*    */ 
/* 69 */     return String.format(format, new Object[] { encrypt, signature, timestamp, nonce });
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\encrypt\XMLParse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */