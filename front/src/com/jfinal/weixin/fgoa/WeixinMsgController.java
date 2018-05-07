/*     */ package com.jfinal.weixin.fgoa;
/*     */ 
/*     */ import com.jfinal.kit.PropKit;
/*     */ import com.jfinal.log.Logger;
/*     */ import com.jfinal.weixin.sdk.api.ApiConfig;
/*     */ import com.jfinal.weixin.sdk.msg.in.InImageMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
/*     */ import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
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
/*     */ import com.jfinal.weixin.sdk.msg.out.OutCustomMsg;
/*     */ import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
/*     */ 
/*     */ public class WeixinMsgController extends com.jfinal.weixin.sdk.jfinal.MsgController
/*     */ {
/*  26 */   static Logger logger = Logger.getLogger(WeixinMsgController.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ApiConfig getApiConfig()
/*     */   {
/*  34 */     ApiConfig ac = new ApiConfig();
/*     */     
/*     */ 
/*  37 */     ac.setToken(PropKit.get("token"));
/*  38 */     ac.setAppId(PropKit.get("appId"));
/*  39 */     ac.setAppSecret(PropKit.get("appSecret"));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */     ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", Boolean.valueOf(false)).booleanValue());
/*  47 */     ac.setEncodingAesKey(PropKit.get("encodingAesKey", "setting it in config file"));
/*  48 */     return ac;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void processInTextMsg(InTextMsg inTextMsg)
/*     */   {
/*  54 */     OutCustomMsg outCustomMsg = new OutCustomMsg(inTextMsg);
/*  55 */     render(outCustomMsg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void processInVoiceMsg(InVoiceMsg inVoiceMsg)
/*     */   {
/*  62 */     OutCustomMsg outCustomMsg = new OutCustomMsg(inVoiceMsg);
/*  63 */     render(outCustomMsg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void processInVideoMsg(InVideoMsg inVideoMsg)
/*     */   {
/*  70 */     OutCustomMsg outCustomMsg = new OutCustomMsg(inVideoMsg);
/*  71 */     render(outCustomMsg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void processInShortVideoMsg(InShortVideoMsg inShortVideoMsg)
/*     */   {
/*  78 */     OutCustomMsg outCustomMsg = new OutCustomMsg(inShortVideoMsg);
/*  79 */     render(outCustomMsg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void processInLocationMsg(InLocationMsg inLocationMsg)
/*     */   {
/*  86 */     OutCustomMsg outCustomMsg = new OutCustomMsg(inLocationMsg);
/*  87 */     render(outCustomMsg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void processInLinkMsg(InLinkMsg inLinkMsg)
/*     */   {
/*  94 */     OutCustomMsg outCustomMsg = new OutCustomMsg(inLinkMsg);
/*  95 */     render(outCustomMsg);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void processInCustomEvent(InCustomEvent inCustomEvent)
/*     */   {
/* 101 */     logger.debug("测试方法：processInCustomEvent()");
/* 102 */     renderNull();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void processInImageMsg(InImageMsg inImageMsg)
/*     */   {
/* 108 */     OutCustomMsg outCustomMsg = new OutCustomMsg(inImageMsg);
/* 109 */     render(outCustomMsg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void processInFollowEvent(InFollowEvent inFollowEvent)
/*     */   {
/* 117 */     if ("subscribe".equals(inFollowEvent.getEvent()))
/*     */     {
/* 119 */       logger.debug("关注：" + inFollowEvent.getFromUserName());
/* 120 */       OutTextMsg outMsg = new OutTextMsg(inFollowEvent);
/* 121 */       outMsg.setContent("这是武汉市房地产市场管理中心</br>\r\n感谢您的关注");
/* 122 */       render(outMsg);
/*     */     }
/*     */     
/* 125 */     if ("unsubscribe".equals(inFollowEvent.getEvent()))
/*     */     {
/* 127 */       logger.debug("取消关注：" + inFollowEvent.getFromUserName());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent)
/*     */   {
/* 134 */     if ("subscribe".equals(inQrCodeEvent.getEvent()))
/*     */     {
/* 136 */       logger.debug("扫码未关注：" + inQrCodeEvent.getFromUserName());
/* 137 */       OutTextMsg outMsg = new OutTextMsg(inQrCodeEvent);
/* 138 */       outMsg.setContent("感谢您的关注，二维码内容：" + inQrCodeEvent.getEventKey());
/* 139 */       render(outMsg);
/*     */     }
/* 141 */     if ("SCAN".equals(inQrCodeEvent.getEvent()))
/*     */     {
/* 143 */       logger.debug("扫码已关注：" + inQrCodeEvent.getFromUserName());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void processInLocationEvent(InLocationEvent inLocationEvent)
/*     */   {
/* 150 */     logger.debug("发送地理位置事件：" + inLocationEvent.getFromUserName());
/* 151 */     OutTextMsg outMsg = new OutTextMsg(inLocationEvent);
/* 152 */     outMsg.setContent("地理位置是：" + inLocationEvent.getLatitude());
/* 153 */     render(outMsg);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void processInMassEvent(InMassEvent inMassEvent)
/*     */   {
/* 159 */     logger.debug("测试方法：processInMassEvent()");
/* 160 */     renderNull();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void processInMenuEvent(InMenuEvent inMenuEvent)
/*     */   {
/* 168 */     logger.debug("菜单事件：" + inMenuEvent.getFromUserName());
/* 169 */     OutTextMsg outMsg = new OutTextMsg(inMenuEvent);
/* 170 */     outMsg.setContent("菜单事件内容是：" + inMenuEvent.getEventKey());
/* 171 */     render(outMsg);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void processInSpeechRecognitionResults(InSpeechRecognitionResults inSpeechRecognitionResults)
/*     */   {
/* 177 */     logger.debug("语音识别事件：" + inSpeechRecognitionResults.getFromUserName());
/* 178 */     OutTextMsg outMsg = new OutTextMsg(inSpeechRecognitionResults);
/* 179 */     outMsg.setContent("语音识别内容是：" + inSpeechRecognitionResults.getRecognition());
/* 180 */     render(outMsg);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent)
/*     */   {
/* 186 */     logger.debug("测试方法：processInTemplateMsgEvent()");
/* 187 */     renderNull();
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\fgoa\WeixinMsgController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */