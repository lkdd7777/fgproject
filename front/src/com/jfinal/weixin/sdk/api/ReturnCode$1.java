/*     */ package com.jfinal.weixin.sdk.api;
/*     */ 
/*     */ import java.util.HashMap;
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
/*     */ class ReturnCode$1
/*     */   extends HashMap<Integer, String>
/*     */ {
/*     */   ReturnCode$1()
/*     */   {
/*  19 */     put(Integer.valueOf(-1), "系统繁忙");
/*  20 */     put(Integer.valueOf(0), "请求成功");
/*  21 */     put(Integer.valueOf(40001), "获取access_token时AppSecret错误，或者access_token无效");
/*  22 */     put(Integer.valueOf(40002), "不合法的凭证类型");
/*  23 */     put(Integer.valueOf(40003), "不合法的OpenID");
/*  24 */     put(Integer.valueOf(40004), "不合法的媒体文件类型");
/*  25 */     put(Integer.valueOf(40005), "不合法的文件类型");
/*  26 */     put(Integer.valueOf(40006), "不合法的文件大小");
/*  27 */     put(Integer.valueOf(40007), "不合法的媒体文件id");
/*  28 */     put(Integer.valueOf(40008), "不合法的消息类型");
/*  29 */     put(Integer.valueOf(40009), "不合法的图片文件大小");
/*  30 */     put(Integer.valueOf(40010), "不合法的语音文件大小");
/*  31 */     put(Integer.valueOf(40011), "不合法的视频文件大小");
/*  32 */     put(Integer.valueOf(40012), "不合法的缩略图文件大小");
/*  33 */     put(Integer.valueOf(40013), "不合法的APPID");
/*  34 */     put(Integer.valueOf(40014), "不合法的access_token");
/*  35 */     put(Integer.valueOf(40015), "不合法的菜单类型");
/*  36 */     put(Integer.valueOf(40016), "不合法的按钮个数");
/*  37 */     put(Integer.valueOf(40017), "不合法的按钮个数");
/*  38 */     put(Integer.valueOf(40018), "不合法的按钮名字长度");
/*  39 */     put(Integer.valueOf(40019), "不合法的按钮KEY长度");
/*  40 */     put(Integer.valueOf(40020), "不合法的按钮URL长度");
/*  41 */     put(Integer.valueOf(40021), "不合法的菜单版本号");
/*  42 */     put(Integer.valueOf(40022), "不合法的子菜单级数");
/*  43 */     put(Integer.valueOf(40023), "不合法的子菜单按钮个数");
/*  44 */     put(Integer.valueOf(40024), "不合法的子菜单按钮类型");
/*  45 */     put(Integer.valueOf(40025), "不合法的子菜单按钮名字长度");
/*  46 */     put(Integer.valueOf(40026), "不合法的子菜单按钮KEY长度");
/*  47 */     put(Integer.valueOf(40027), "不合法的子菜单按钮URL长度");
/*  48 */     put(Integer.valueOf(40028), "不合法的自定义菜单使用用户");
/*  49 */     put(Integer.valueOf(40029), "不合法的oauth_code");
/*  50 */     put(Integer.valueOf(40030), "不合法的refresh_token");
/*  51 */     put(Integer.valueOf(40031), "不合法的openid列表");
/*  52 */     put(Integer.valueOf(40032), "不合法的openid列表长度");
/*  53 */     put(Integer.valueOf(40033), "不合法的请求字符，不能包含\\uxxxx格式的字符");
/*  54 */     put(Integer.valueOf(40035), "不合法的参数");
/*  55 */     put(Integer.valueOf(40038), "不合法的请求格式");
/*  56 */     put(Integer.valueOf(40039), "不合法的URL长度");
/*  57 */     put(Integer.valueOf(40050), "不合法的分组id");
/*  58 */     put(Integer.valueOf(40051), "分组名字不合法");
/*  59 */     put(Integer.valueOf(41001), "缺少access_token参数");
/*  60 */     put(Integer.valueOf(41002), "缺少appid参数");
/*  61 */     put(Integer.valueOf(41003), "缺少refresh_token参数");
/*  62 */     put(Integer.valueOf(41004), "缺少secret参数");
/*  63 */     put(Integer.valueOf(41005), "缺少多媒体文件数据");
/*  64 */     put(Integer.valueOf(41006), "缺少media_id参数");
/*  65 */     put(Integer.valueOf(41007), "缺少子菜单数据");
/*  66 */     put(Integer.valueOf(41008), "缺少oauth code");
/*  67 */     put(Integer.valueOf(41009), "缺少openid");
/*  68 */     put(Integer.valueOf(42001), "access_token超时");
/*  69 */     put(Integer.valueOf(42002), "refresh_token超时");
/*  70 */     put(Integer.valueOf(42003), "oauth_code超时");
/*  71 */     put(Integer.valueOf(43001), "需要GET请求");
/*  72 */     put(Integer.valueOf(43002), "需要POST请求");
/*  73 */     put(Integer.valueOf(43003), "需要HTTPS请求");
/*  74 */     put(Integer.valueOf(43004), "需要接收者关注");
/*  75 */     put(Integer.valueOf(43005), "需要好友关系");
/*  76 */     put(Integer.valueOf(44001), "多媒体文件为空");
/*  77 */     put(Integer.valueOf(44002), "POST的数据包为空");
/*  78 */     put(Integer.valueOf(44003), "图文消息内容为空");
/*  79 */     put(Integer.valueOf(44004), "文本消息内容为空");
/*  80 */     put(Integer.valueOf(45001), "多媒体文件大小超过限制");
/*  81 */     put(Integer.valueOf(45002), "消息内容超过限制");
/*  82 */     put(Integer.valueOf(45003), "标题字段超过限制");
/*  83 */     put(Integer.valueOf(45004), "描述字段超过限制");
/*  84 */     put(Integer.valueOf(45005), "链接字段超过限制");
/*  85 */     put(Integer.valueOf(45006), "图片链接字段超过限制");
/*  86 */     put(Integer.valueOf(45007), "语音播放时间超过限制");
/*  87 */     put(Integer.valueOf(45008), "图文消息超过限制");
/*  88 */     put(Integer.valueOf(45009), "接口调用超过限制");
/*  89 */     put(Integer.valueOf(45010), "创建菜单个数超过限制");
/*  90 */     put(Integer.valueOf(45015), "回复时间超过限制");
/*  91 */     put(Integer.valueOf(45016), "系统分组，不允许修改");
/*  92 */     put(Integer.valueOf(45017), "分组名字过长");
/*  93 */     put(Integer.valueOf(45018), "分组数量超过上限");
/*  94 */     put(Integer.valueOf(46001), "不存在媒体数据");
/*  95 */     put(Integer.valueOf(46002), "不存在的菜单版本");
/*  96 */     put(Integer.valueOf(46003), "不存在的菜单数据");
/*  97 */     put(Integer.valueOf(46004), "不存在的用户");
/*  98 */     put(Integer.valueOf(47001), "解析JSON/XML内容错误");
/*  99 */     put(Integer.valueOf(48001), "api功能未授权");
/* 100 */     put(Integer.valueOf(50001), "用户未授权该api");
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\ReturnCode$1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */