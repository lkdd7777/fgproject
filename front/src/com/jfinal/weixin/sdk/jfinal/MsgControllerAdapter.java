package com.jfinal.weixin.sdk.jfinal;

import com.jfinal.weixin.sdk.msg.in.InImageMsg;
import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.in.InVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InVoiceMsg;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;

public abstract class MsgControllerAdapter
  extends MsgController
{
  protected abstract void processInFollowEvent(InFollowEvent paramInFollowEvent);
  
  protected abstract void processInTextMsg(InTextMsg paramInTextMsg);
  
  protected abstract void processInMenuEvent(InMenuEvent paramInMenuEvent);
  
  protected void processInImageMsg(InImageMsg inImageMsg) {}
  
  protected void processInVoiceMsg(InVoiceMsg inVoiceMsg) {}
  
  protected void processInVideoMsg(InVideoMsg inVideoMsg) {}
  
  protected void processInLocationMsg(InLocationMsg inLocationMsg) {}
  
  protected void processInLinkMsg(InLinkMsg inLinkMsg) {}
  
  protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent) {}
  
  protected void processInLocationEvent(InLocationEvent inLocationEvent) {}
  
  protected void processInSpeechRecognitionResults(InSpeechRecognitionResults inSpeechRecognitionResults) {}
  
  protected void processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent) {}
}


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\jfinal\MsgControllerAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */