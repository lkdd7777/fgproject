/*     */ package com.jfinal.weixin.sdk.msg;
/*     */ 
/*     */ import com.jfinal.weixin.sdk.msg.in.InImageMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InShortVideoMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InTextMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InVideoMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InVoiceMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InCustomEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InMassEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentException;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class InMsgParser
/*     */ {
/*     */   public static InMsg parse(String xml)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       return doParse(xml);
/*     */     } catch (DocumentException e) {
/*  29 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static InMsg doParse(String xml)
/*     */     throws DocumentException
/*     */   {
/*  45 */     Document doc = org.dom4j.DocumentHelper.parseText(xml);
/*  46 */     Element root = doc.getRootElement();
/*  47 */     String toUserName = root.elementText("ToUserName");
/*  48 */     String fromUserName = root.elementText("FromUserName");
/*  49 */     Integer createTime = Integer.valueOf(Integer.parseInt(root.elementText("CreateTime")));
/*  50 */     String msgType = root.elementText("MsgType");
/*  51 */     if ("text".equals(msgType))
/*  52 */       return parseInTextMsg(root, toUserName, fromUserName, createTime, msgType);
/*  53 */     if ("image".equals(msgType))
/*  54 */       return parseInImageMsg(root, toUserName, fromUserName, createTime, msgType);
/*  55 */     if ("voice".equals(msgType))
/*  56 */       return parseInVoiceMsgAndInSpeechRecognitionResults(root, toUserName, fromUserName, createTime, msgType);
/*  57 */     if ("video".equals(msgType))
/*  58 */       return parseInVideoMsg(root, toUserName, fromUserName, createTime, msgType);
/*  59 */     if ("shortvideo".equals(msgType))
/*  60 */       return parseInShortVideoMsg(root, toUserName, fromUserName, createTime, msgType);
/*  61 */     if ("location".equals(msgType))
/*  62 */       return parseInLocationMsg(root, toUserName, fromUserName, createTime, msgType);
/*  63 */     if ("link".equals(msgType))
/*  64 */       return parseInLinkMsg(root, toUserName, fromUserName, createTime, msgType);
/*  65 */     if ("event".equals(msgType))
/*  66 */       return parseInEvent(root, toUserName, fromUserName, createTime, msgType);
/*  67 */     throw new RuntimeException("无法识别的消息类型 " + msgType + "，请查阅微信公众平台开发文档");
/*     */   }
/*     */   
/*     */   private static InMsg parseInTextMsg(Element root, String toUserName, String fromUserName, Integer createTime, String msgType) {
/*  71 */     InTextMsg msg = new InTextMsg(toUserName, fromUserName, createTime, msgType);
/*  72 */     msg.setContent(root.elementText("Content"));
/*  73 */     msg.setMsgId(root.elementText("MsgId"));
/*  74 */     return msg;
/*     */   }
/*     */   
/*     */   private static InMsg parseInImageMsg(Element root, String toUserName, String fromUserName, Integer createTime, String msgType) {
/*  78 */     InImageMsg msg = new InImageMsg(toUserName, fromUserName, createTime, msgType);
/*  79 */     msg.setPicUrl(root.elementText("PicUrl"));
/*  80 */     msg.setMediaId(root.elementText("MediaId"));
/*  81 */     msg.setMsgId(root.elementText("MsgId"));
/*  82 */     return msg;
/*     */   }
/*     */   
/*     */   private static InMsg parseInVoiceMsgAndInSpeechRecognitionResults(Element root, String toUserName, String fromUserName, Integer createTime, String msgType) {
/*  86 */     String recognition = root.elementText("Recognition");
/*  87 */     if (com.jfinal.kit.StrKit.isBlank(recognition)) {
/*  88 */       InVoiceMsg msg = new InVoiceMsg(toUserName, fromUserName, createTime, msgType);
/*  89 */       msg.setMediaId(root.elementText("MediaId"));
/*  90 */       msg.setFormat(root.elementText("Format"));
/*  91 */       msg.setMsgId(root.elementText("MsgId"));
/*  92 */       return msg;
/*     */     }
/*     */     
/*  95 */     InSpeechRecognitionResults msg = new InSpeechRecognitionResults(toUserName, fromUserName, createTime, msgType);
/*  96 */     msg.setMediaId(root.elementText("MediaId"));
/*  97 */     msg.setFormat(root.elementText("Format"));
/*  98 */     msg.setMsgId(root.elementText("MsgId"));
/*  99 */     msg.setRecognition(recognition);
/* 100 */     return msg;
/*     */   }
/*     */   
/*     */   private static InMsg parseInVideoMsg(Element root, String toUserName, String fromUserName, Integer createTime, String msgType)
/*     */   {
/* 105 */     InVideoMsg msg = new InVideoMsg(toUserName, fromUserName, createTime, msgType);
/* 106 */     msg.setMediaId(root.elementText("MediaId"));
/* 107 */     msg.setThumbMediaId(root.elementText("ThumbMediaId"));
/* 108 */     msg.setMsgId(root.elementText("MsgId"));
/* 109 */     return msg;
/*     */   }
/*     */   
/*     */   private static InMsg parseInShortVideoMsg(Element root, String toUserName, String fromUserName, Integer createTime, String msgType) {
/* 113 */     InShortVideoMsg msg = new InShortVideoMsg(toUserName, fromUserName, createTime, msgType);
/* 114 */     msg.setMediaId(root.elementText("MediaId"));
/* 115 */     msg.setThumbMediaId(root.elementText("ThumbMediaId"));
/* 116 */     msg.setMsgId(root.elementText("MsgId"));
/* 117 */     return msg;
/*     */   }
/*     */   
/*     */   private static InMsg parseInLocationMsg(Element root, String toUserName, String fromUserName, Integer createTime, String msgType) {
/* 121 */     InLocationMsg msg = new InLocationMsg(toUserName, fromUserName, createTime, msgType);
/* 122 */     msg.setLocation_X(root.elementText("Location_X"));
/* 123 */     msg.setLocation_Y(root.elementText("Location_Y"));
/* 124 */     msg.setScale(root.elementText("Scale"));
/* 125 */     msg.setLabel(root.elementText("Label"));
/* 126 */     msg.setMsgId(root.elementText("MsgId"));
/* 127 */     return msg;
/*     */   }
/*     */   
/*     */   private static InMsg parseInLinkMsg(Element root, String toUserName, String fromUserName, Integer createTime, String msgType) {
/* 131 */     InLinkMsg msg = new InLinkMsg(toUserName, fromUserName, createTime, msgType);
/* 132 */     msg.setTitle(root.elementText("Title"));
/* 133 */     msg.setDescription(root.elementText("Description"));
/* 134 */     msg.setUrl(root.elementText("Url"));
/* 135 */     msg.setMsgId(root.elementText("MsgId"));
/* 136 */     return msg;
/*     */   }
/*     */   
/*     */   private static InMsg parseInEvent(Element root, String toUserName, String fromUserName, Integer createTime, String msgType)
/*     */   {
/* 141 */     String event = root.elementText("Event");
/* 142 */     String eventKey = root.elementText("EventKey");
/*     */     
/*     */ 
/* 145 */     if ((("subscribe".equals(event)) || ("unsubscribe".equals(event))) && (com.jfinal.kit.StrKit.isBlank(eventKey))) {
/* 146 */       return new com.jfinal.weixin.sdk.msg.in.event.InFollowEvent(toUserName, fromUserName, createTime, msgType, event);
/*     */     }
/*     */     
/*     */ 
/* 150 */     String ticket = root.elementText("Ticket");
/* 151 */     if (("subscribe".equals(event)) && (com.jfinal.kit.StrKit.notBlank(eventKey)) && (eventKey.startsWith("qrscene_"))) {
/* 152 */       InQrCodeEvent e = new InQrCodeEvent(toUserName, fromUserName, createTime, msgType, event);
/* 153 */       e.setEventKey(eventKey);
/* 154 */       e.setTicket(ticket);
/* 155 */       return e;
/*     */     }
/*     */     
/* 158 */     if ("SCAN".equals(event)) {
/* 159 */       InQrCodeEvent e = new InQrCodeEvent(toUserName, fromUserName, createTime, msgType, event);
/* 160 */       e.setEventKey(eventKey);
/* 161 */       e.setTicket(ticket);
/* 162 */       return e;
/*     */     }
/*     */     
/*     */ 
/* 166 */     if ("LOCATION".equals(event)) {
/* 167 */       InLocationEvent e = new InLocationEvent(toUserName, fromUserName, createTime, msgType, event);
/* 168 */       e.setLatitude(root.elementText("Latitude"));
/* 169 */       e.setLongitude(root.elementText("Longitude"));
/* 170 */       e.setPrecision(root.elementText("Precision"));
/* 171 */       return e;
/*     */     }
/*     */     
/*     */ 
/* 175 */     if ("CLICK".equals(event)) {
/* 176 */       InMenuEvent e = new InMenuEvent(toUserName, fromUserName, createTime, msgType, event);
/* 177 */       e.setEventKey(eventKey);
/* 178 */       return e;
/*     */     }
/*     */     
/* 181 */     if ("VIEW".equals(event)) {
/* 182 */       InMenuEvent e = new InMenuEvent(toUserName, fromUserName, createTime, msgType, event);
/* 183 */       e.setEventKey(eventKey);
/* 184 */       return e;
/*     */     }
/*     */     
/* 187 */     if ("TEMPLATESENDJOBFINISH".equals(event)) {
/* 188 */       com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent e = new com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent(toUserName, fromUserName, createTime, msgType, event);
/* 189 */       e.setMsgId(root.elementText("MsgID"));
/* 190 */       e.setStatus(root.elementText("Status"));
/* 191 */       return e;
/*     */     }
/*     */     
/* 194 */     if ("MASSSENDJOBFINISH".equals(event)) {
/* 195 */       InMassEvent e = new InMassEvent(toUserName, fromUserName, createTime, msgType, event);
/* 196 */       e.setMsgId(root.elementText("MsgID"));
/* 197 */       e.setStatus(root.elementText("Status"));
/* 198 */       e.setTotalCount(root.elementText("TotalCount"));
/* 199 */       e.setFilterCount(root.elementText("FilterCount"));
/* 200 */       e.setSentCount(root.elementText("SentCount"));
/* 201 */       e.setErrorCount(root.elementText("ErrorCount"));
/* 202 */       return e;
/*     */     }
/*     */     
/* 205 */     if ("kf_create_session".equals(event)) {
/* 206 */       InCustomEvent e = new InCustomEvent(toUserName, fromUserName, createTime, msgType, event);
/* 207 */       e.setKfAccount(root.elementText("KfAccount"));
/* 208 */       return e;
/*     */     }
/*     */     
/* 211 */     if ("kf_close_session".equals(event)) {
/* 212 */       InCustomEvent e = new InCustomEvent(toUserName, fromUserName, createTime, msgType, event);
/* 213 */       e.setKfAccount(root.elementText("KfAccount"));
/* 214 */       return e;
/*     */     }
/*     */     
/* 217 */     if ("kf_switch_session".equals(event)) {
/* 218 */       InCustomEvent e = new InCustomEvent(toUserName, fromUserName, createTime, msgType, event);
/* 219 */       e.setKfAccount(root.elementText("KfAccount"));
/* 220 */       e.setToKfAccount(root.elementText("ToKfAccount"));
/* 221 */       return e;
/*     */     }
/*     */     
/* 224 */     throw new RuntimeException("无法识别的事件类型" + event + "，请查阅微信公众平台开发文档");
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws DocumentException
/*     */   {
/* 229 */     String xml = 
/* 230 */       "<xml>\n<ToUserName><![CDATA[James]]></ToUserName>\n<FromUserName><![CDATA[JFinal]]></FromUserName>\n<CreateTime>1348831860</CreateTime>\n<MsgType><![CDATA[text]]></MsgType>\n<Content><![CDATA[this is a test]]></Content>\n<MsgId>1234567890123456</MsgId>\n</xml>";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 245 */     String xml_2 = 
/* 246 */       "<xml>\n<ToUserName><![CDATA[James]]></ToUserName>\n<FromUserName><![CDATA[JFinal]]></FromUserName>\n<CreateTime>1348831860</CreateTime>\n<MsgType><![CDATA[text]]></MsgType>\n<Content><![CDATA[this is a test]]></Content>\n<MsgId>1234567890123456</MsgId>\n</xml>";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 255 */     Document doc = org.dom4j.DocumentHelper.parseText(xml_2);
/* 256 */     Element root = doc.getRootElement();
/* 257 */     String value = root.elementText("abc");
/* 258 */     System.out.println(value);
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\InMsgParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */