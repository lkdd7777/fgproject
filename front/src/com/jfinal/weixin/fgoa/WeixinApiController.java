/*     */ package com.jfinal.weixin.fgoa;
/*     */ 
/*     */ import com.jfinal.kit.PropKit;
/*     */ import com.jfinal.weixin.sdk.api.ApiConfig;
/*     */ import com.jfinal.weixin.sdk.api.ApiResult;
/*     */ import com.jfinal.weixin.sdk.api.MenuApi;
/*     */ import com.jfinal.weixin.sdk.api.QrcodeApi;
/*     */ import com.jfinal.weixin.sdk.api.UserApi;
/*     */ 
/*     */ public class WeixinApiController extends com.jfinal.weixin.sdk.jfinal.ApiController
/*     */ {
/*     */   public ApiConfig getApiConfig()
/*     */   {
/*  14 */     ApiConfig ac = new ApiConfig();
/*     */     
/*     */ 
/*  17 */     ac.setToken(PropKit.get("token"));
/*  18 */     ac.setAppId(PropKit.get("appId"));
/*  19 */     ac.setAppSecret(PropKit.get("appSecret"));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  26 */     ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", Boolean.valueOf(false)).booleanValue());
/*  27 */     ac.setEncodingAesKey(PropKit.get("encodingAesKey", "setting it in config file"));
/*  28 */     return ac;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void getMenu()
/*     */   {
/*  35 */     ApiResult apiResult = MenuApi.getMenu();
/*  36 */     if (apiResult.isSucceed()) {
/*  37 */       renderText(apiResult.getJson());
/*     */     } else {
/*  39 */       renderText(apiResult.getErrorMsg());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void createMenu()
/*     */   {
/*  47 */     String str = "{\n    \"button\": [\n        {\n            \"name\": \"进入理财\",\n            \"url\": \"http://m.bajie8.com/bajie/enter\",\n            \"type\": \"view\"\n        },\n        {\n            \"name\": \"安全保障\",\n            \"key\": \"112\",\n\t    \"type\": \"click\"\n        },\n        {\n\t    \"name\": \"使用帮助\",\n\t    \"url\": \"http://m.bajie8.com/footer/cjwt\",\n\t    \"type\": \"view\"\n        }\n    ]\n}";
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  66 */     ApiResult apiResult = MenuApi.createMenu(str);
/*  67 */     if (apiResult.isSucceed()) {
/*  68 */       renderText(apiResult.getJson());
/*     */     } else {
/*  70 */       renderText(apiResult.getErrorMsg());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void getFollowers()
/*     */   {
/*  78 */     ApiResult apiResult = UserApi.getFollows();
/*  79 */     renderText(apiResult.getJson());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getUserInfo()
/*     */   {
/*  87 */     ApiResult apiResult = UserApi.getUserInfo("ohbweuNYB_heu_buiBWZtwgi4xzU");
/*  88 */     renderText(apiResult.getJson());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void sendMsg()
/*     */   {
/*  96 */     String str = " {\n           \"touser\":\"ohbweuNYB_heu_buiBWZtwgi4xzU\",\n           \"template_id\":\"9SIa8ph1403NEM3qk3z9-go-p4kBMeh-HGepQZVdA7w\",\n           \"url\":\"http://www.sina.com\",\n           \"topcolor\":\"#FF0000\",\n           \"data\":{\n                   \"first\": {\n                       \"value\":\"恭喜你购买成功！\",\n                       \"color\":\"#173177\"\n                   },\n                   \"keyword1\":{\n                       \"value\":\"去哪儿网发的酒店红包（1个）\",\n                       \"color\":\"#173177\"\n                   },\n                   \"keyword2\":{\n                       \"value\":\"1元\",\n                       \"color\":\"#173177\"\n                   },\n                   \"remark\":{\n                       \"value\":\"欢迎再次购买！\",\n                       \"color\":\"#173177\"\n                   }\n           }\n       }";
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */     ApiResult apiResult = com.jfinal.weixin.sdk.api.TemplateMsgApi.send(str);
/* 121 */     renderText(apiResult.getJson());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getQrcode()
/*     */   {
/* 129 */     String str = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
/* 130 */     ApiResult apiResult = QrcodeApi.create(str);
/* 131 */     renderText(apiResult.getJson());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getShorturl()
/*     */   {
/* 143 */     String str = "{\"action\":\"long2short\",\"long_url\":\"http://wap.koudaitong.com/v2/showcase/goods?alias=128wi9shh&spm=h56083&redirect_count=1\"}";
/*     */     
/* 145 */     ApiResult apiResult = com.jfinal.weixin.sdk.api.ShorturlApi.getShorturl(str);
/* 146 */     renderText(apiResult.getJson());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getRecord()
/*     */   {
/* 154 */     String str = "{\n    \"endtime\" : 987654321,\n    \"pageindex\" : 1,\n    \"pagesize\" : 10,\n    \"starttime\" : 123456789\n }";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 160 */     ApiResult apiResult = com.jfinal.weixin.sdk.api.CustomServiceApi.getRecord(str);
/* 161 */     renderText(apiResult.getJson());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getCallbackIp()
/*     */   {
/* 169 */     ApiResult apiResult = com.jfinal.weixin.sdk.api.CallbackIpApi.getCallbackIp();
/* 170 */     renderText(apiResult.getJson());
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\fgoa\WeixinApiController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */