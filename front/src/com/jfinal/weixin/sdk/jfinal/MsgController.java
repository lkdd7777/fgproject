/*     */ package com.jfinal.weixin.sdk.jfinal;
/*     */ 
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.ext.interceptor.NotAction;
/*     */ import com.jfinal.log.Logger;
/*     */ import com.jfinal.weixin.sdk.api.ApiConfig;
/*     */ import com.jfinal.weixin.sdk.api.ApiConfigKit;
/*     */ import com.jfinal.weixin.sdk.kit.MsgEncryptKit;
/*     */ import com.jfinal.weixin.sdk.msg.in.InImageMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InShortVideoMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InTextMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InVideoMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InVoiceMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InCustomEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InMassEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent;
/*     */ import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public abstract class MsgController extends com.jfinal.core.Controller
/*     */ {
/*  30 */   private static final Logger log = Logger.getLogger(MsgController.class);
/*  31 */   private String inMsgXml = null;
/*  32 */   private InMsg inMsg = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract ApiConfig getApiConfig();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Before({MsgInterceptor.class})
/*     */   public void index()
/*     */   {
/*  46 */     if (ApiConfigKit.isDevMode()) {
/*  47 */       System.out.println("接收消息:");
/*  48 */       System.out.println(getInMsgXml());
/*     */     }
/*     */     
/*     */ 
/*  52 */     InMsg msg = getInMsg();
/*  53 */     if ((msg instanceof InTextMsg)) {
/*  54 */       processInTextMsg((InTextMsg)msg);
/*  55 */     } else if ((msg instanceof InImageMsg)) {
/*  56 */       processInImageMsg((InImageMsg)msg);
/*  57 */     } else if ((msg instanceof InVoiceMsg)) {
/*  58 */       processInVoiceMsg((InVoiceMsg)msg);
/*  59 */     } else if ((msg instanceof InVideoMsg)) {
/*  60 */       processInVideoMsg((InVideoMsg)msg);
/*  61 */     } else if ((msg instanceof InShortVideoMsg)) {
/*  62 */       processInShortVideoMsg((InShortVideoMsg)msg);
/*  63 */     } else if ((msg instanceof InLocationMsg)) {
/*  64 */       processInLocationMsg((InLocationMsg)msg);
/*  65 */     } else if ((msg instanceof InLinkMsg)) {
/*  66 */       processInLinkMsg((InLinkMsg)msg);
/*  67 */     } else if ((msg instanceof InCustomEvent)) {
/*  68 */       processInCustomEvent((InCustomEvent)msg);
/*  69 */     } else if ((msg instanceof InFollowEvent)) {
/*  70 */       processInFollowEvent((InFollowEvent)msg);
/*  71 */     } else if ((msg instanceof InQrCodeEvent)) {
/*  72 */       processInQrCodeEvent((InQrCodeEvent)msg);
/*  73 */     } else if ((msg instanceof InLocationEvent)) {
/*  74 */       processInLocationEvent((InLocationEvent)msg);
/*  75 */     } else if ((msg instanceof InMassEvent)) {
/*  76 */       processInMassEvent((InMassEvent)msg);
/*  77 */     } else if ((msg instanceof InMenuEvent)) {
/*  78 */       processInMenuEvent((InMenuEvent)msg);
/*  79 */     } else if ((msg instanceof InSpeechRecognitionResults)) {
/*  80 */       processInSpeechRecognitionResults((InSpeechRecognitionResults)msg);
/*  81 */     } else if ((msg instanceof InTemplateMsgEvent)) {
/*  82 */       processInTemplateMsgEvent((InTemplateMsgEvent)msg);
/*     */     } else {
/*  84 */       log.error("未能识别的消息类型。 消息 xml 内容为：\n" + getInMsgXml());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void render(com.jfinal.weixin.sdk.msg.out.OutMsg outMsg)
/*     */   {
/*  91 */     String outMsgXml = com.jfinal.weixin.sdk.msg.OutMsgXmlBuilder.build(outMsg);
/*     */     
/*  93 */     if (ApiConfigKit.isDevMode()) {
/*  94 */       System.out.println("发送消息:");
/*  95 */       System.out.println(outMsgXml);
/*  96 */       System.out.println("--------------------------------------------------------------------------------\n");
/*     */     }
/*     */     
/*     */ 
/* 100 */     if (ApiConfigKit.getApiConfig().isEncryptMessage()) {
/* 101 */       outMsgXml = MsgEncryptKit.encrypt(outMsgXml, getPara("timestamp"), getPara("nonce"));
/*     */     }
/*     */     
/* 104 */     renderText(outMsgXml, "text/xml");
/*     */   }
/*     */   
/*     */   public void renderOutTextMsg(String content) {
/* 108 */     OutTextMsg outMsg = new OutTextMsg(getInMsg());
/* 109 */     outMsg.setContent(content);
/* 110 */     render(outMsg);
/*     */   }
/*     */   
/*     */   @Before({NotAction.class})
/*     */   public String getInMsgXml() {
/* 115 */     if (this.inMsgXml == null) {
/* 116 */       this.inMsgXml = com.jfinal.kit.HttpKit.readIncommingRequestData(getRequest());
/*     */       
/*     */ 
/* 119 */       if (ApiConfigKit.getApiConfig().isEncryptMessage()) {
/* 120 */         this.inMsgXml = MsgEncryptKit.decrypt(this.inMsgXml, getPara("timestamp"), getPara("nonce"), getPara("msg_signature"));
/*     */       }
/*     */     }
/* 123 */     return this.inMsgXml;
/*     */   }
/*     */   
/*     */   @Before({NotAction.class})
/*     */   public InMsg getInMsg() {
/* 128 */     if (this.inMsg == null)
/* 129 */       this.inMsg = com.jfinal.weixin.sdk.msg.InMsgParser.parse(getInMsgXml());
/* 130 */     return this.inMsg;
/*     */   }
/*     */   
/*     */   protected abstract void processInTextMsg(InTextMsg paramInTextMsg);
/*     */   
/*     */   protected abstract void processInImageMsg(InImageMsg paramInImageMsg);
/*     */   
/*     */   protected abstract void processInVoiceMsg(InVoiceMsg paramInVoiceMsg);
/*     */   
/*     */   protected abstract void processInVideoMsg(InVideoMsg paramInVideoMsg);
/*     */   
/*     */   protected abstract void processInShortVideoMsg(InShortVideoMsg paramInShortVideoMsg);
/*     */   
/*     */   protected abstract void processInLocationMsg(InLocationMsg paramInLocationMsg);
/*     */   
/*     */   protected abstract void processInLinkMsg(InLinkMsg paramInLinkMsg);
/*     */   
/*     */   protected abstract void processInCustomEvent(InCustomEvent paramInCustomEvent);
/*     */   
/*     */   protected abstract void processInFollowEvent(InFollowEvent paramInFollowEvent);
/*     */   
/*     */   protected abstract void processInQrCodeEvent(InQrCodeEvent paramInQrCodeEvent);
/*     */   
/*     */   protected abstract void processInLocationEvent(InLocationEvent paramInLocationEvent);
/*     */   
/*     */   protected abstract void processInMassEvent(InMassEvent paramInMassEvent);
/*     */   
/*     */   protected abstract void processInMenuEvent(InMenuEvent paramInMenuEvent);
/*     */   
/*     */   protected abstract void processInSpeechRecognitionResults(InSpeechRecognitionResults paramInSpeechRecognitionResults);
/*     */   
/*     */   protected abstract void processInTemplateMsgEvent(InTemplateMsgEvent paramInTemplateMsgEvent);
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\jfinal\MsgController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */