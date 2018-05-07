/*     */ package com.jfinal.weixin.sdk.msg;
/*     */ 
/*     */ import com.jfinal.weixin.sdk.msg.out.OutCustomMsg;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutImageMsg;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutMsg;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutMusicMsg;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutNewsMsg;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutVideoMsg;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutVoiceMsg;
/*     */ import freemarker.cache.StringTemplateLoader;
/*     */ import freemarker.core.InvalidReferenceException;
/*     */ import freemarker.template.Configuration;
/*     */ import freemarker.template.ObjectWrapper;
/*     */ import freemarker.template.Template;
/*     */ import freemarker.template.TemplateExceptionHandler;
/*     */ import java.io.PrintStream;
/*     */ import java.io.StringWriter;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ public class OutMsgXmlBuilder
/*     */ {
/*  26 */   private static String encoding = "utf-8";
/*  27 */   private static Configuration config = initFreeMarkerConfiguration();
/*     */   
/*     */   public static String build(OutMsg outMsg)
/*     */   {
/*  31 */     if (outMsg == null) {
/*  32 */       throw new IllegalArgumentException("参数 OutMsg 不能为 null");
/*     */     }
/*  34 */     Map root = new HashMap();
/*     */     
/*  36 */     root.put("__msg", outMsg);
/*     */     try
/*     */     {
/*  39 */       Template template = config.getTemplate(outMsg.getClass().getSimpleName(), encoding);
/*  40 */       StringWriter sw = new StringWriter();
/*  41 */       template.process(root, sw);
/*  42 */       return sw.toString();
/*     */     } catch (InvalidReferenceException e) {
/*  44 */       throw new RuntimeException("可能是 " + outMsg.getClass().getSimpleName() + " 对象中的某些属性未赋值，请仔细检查", e);
/*     */     } catch (Exception e) {
/*  46 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   private static Configuration initFreeMarkerConfiguration() {
/*  51 */     Configuration config = new Configuration();
/*  52 */     StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
/*  53 */     initStringTemplateLoader(stringTemplateLoader);
/*  54 */     config.setTemplateLoader(stringTemplateLoader);
/*     */     
/*     */ 
/*  57 */     config.setTemplateUpdateDelay(999999);
/*     */     
/*     */ 
/*     */ 
/*  61 */     config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
/*     */     
/*     */ 
/*  64 */     config.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
/*     */     
/*  66 */     config.setDefaultEncoding(encoding);
/*     */     
/*     */ 
/*     */ 
/*  70 */     config.setOutputEncoding(encoding);
/*     */     
/*  72 */     config.setLocale(Locale.getDefault());
/*  73 */     config.setLocalizedLookup(false);
/*     */     
/*     */ 
/*     */ 
/*  77 */     config.setNumberFormat("#0.#####");
/*  78 */     config.setDateFormat("yyyy-MM-dd");
/*  79 */     config.setTimeFormat("HH:mm:ss");
/*  80 */     config.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
/*  81 */     return config;
/*     */   }
/*     */   
/*     */   private static void initStringTemplateLoader(StringTemplateLoader loader)
/*     */   {
/*  86 */     loader.putTemplate(OutTextMsg.class.getSimpleName(), "<xml>\n<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n<CreateTime>${__msg.createTime}</CreateTime>\n<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n<Content><![CDATA[${__msg.content}]]></Content>\n</xml>");
/*     */     
/*  88 */     loader.putTemplate(OutNewsMsg.class.getSimpleName(), "<xml>\n<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n<CreateTime>${__msg.createTime}</CreateTime>\n<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n<ArticleCount>${__msg.getArticleCount()}</ArticleCount>\n<Articles>\n<#list __msg.getArticles() as x>\n<item>\n<Title><![CDATA[${(x.title)!}]]></Title>\n<Description><![CDATA[${(x.description)!}]]></Description>\n<PicUrl><![CDATA[${(x.picUrl)!}]]></PicUrl>\n<Url><![CDATA[${(x.url)!}]]></Url>\n</item>\n</#list>\n</Articles>\n</xml>");
/*     */     
/*  90 */     loader.putTemplate(OutImageMsg.class.getSimpleName(), "<xml>\n<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n<CreateTime>${__msg.createTime}</CreateTime>\n<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n<Image>\n<MediaId><![CDATA[${__msg.mediaId}]]></MediaId>\n</Image>\n</xml>");
/*     */     
/*  92 */     loader.putTemplate(OutVoiceMsg.class.getSimpleName(), "<xml>\n<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n<CreateTime>${__msg.createTime}</CreateTime>\n<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n<Voice>\n<MediaId><![CDATA[${__msg.mediaId}]]></MediaId>\n</Voice>\n</xml>");
/*     */     
/*  94 */     loader.putTemplate(OutVideoMsg.class.getSimpleName(), "<xml>\n<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n<CreateTime>${__msg.createTime}</CreateTime>\n<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n<Video>\n<MediaId><![CDATA[${__msg.mediaId}]]></MediaId>\n<Title><![CDATA[${(__msg.title)!}]]></Title>\n<Description><![CDATA[${(__msg.description)!}]]></Description>\n</Video>\n</xml>");
/*     */     
/*  96 */     loader.putTemplate(OutMusicMsg.class.getSimpleName(), "<xml>\n<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n<CreateTime>${__msg.createTime}</CreateTime>\n<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n<Music>\n<Title><![CDATA[${(__msg.title)!}]]></Title>\n<Description><![CDATA[${(__msg.description)!}]]></Description>\n<MusicUrl><![CDATA[${(__msg.musicUrl)!}]]></MusicUrl>\n<HQMusicUrl><![CDATA[${(__msg.hqMusicUrl)!}]]></HQMusicUrl>\n<FuncFlag>${__msg.funcFlag}</FuncFlag>\n</Music>\n</xml>");
/*     */     
/*  98 */     loader.putTemplate(OutCustomMsg.class.getSimpleName(), "<xml>\n<ToUserName><![CDATA[${__msg.toUserName}]]></ToUserName>\n<FromUserName><![CDATA[${__msg.fromUserName}]]></FromUserName>\n<CreateTime>${__msg.createTime}</CreateTime>\n<MsgType><![CDATA[${__msg.msgType}]]></MsgType>\n</xml>");
/*     */   }
/*     */   
/*     */   public static void setEncoding(String encoding) {
/* 102 */     encoding = encoding;
/*     */   }
/*     */   
/*     */   public static String getEncoding() {
/* 106 */     return encoding;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 110 */     OutTextMsg msg = new OutTextMsg();
/* 111 */     msg.setToUserName("to james");
/* 112 */     msg.setFromUserName("from james");
/* 113 */     msg.setCreateTime(msg.now());
/* 114 */     msg.setContent("jfinal weixin 极速开发平台碉堡了");
/* 115 */     String xml = build(msg);
/* 116 */     System.out.println(xml);
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\OutMsgXmlBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */