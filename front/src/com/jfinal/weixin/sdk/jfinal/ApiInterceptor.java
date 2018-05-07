package com.jfinal.weixin.sdk.jfinal;

import com.jfinal.aop.Interceptor;

public class ApiInterceptor
  implements Interceptor
{
  /* Error */
  public void intercept(com.jfinal.aop.Invocation inv)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 18	com/jfinal/aop/Invocation:getController	()Lcom/jfinal/core/Controller;
    //   4: astore_2
    //   5: aload_2
    //   6: instanceof 24
    //   9: ifne +13 -> 22
    //   12: new 26	java/lang/RuntimeException
    //   15: dup
    //   16: ldc 28
    //   18: invokespecial 30	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_2
    //   23: checkcast 24	com/jfinal/weixin/sdk/jfinal/ApiController
    //   26: invokevirtual 33	com/jfinal/weixin/sdk/jfinal/ApiController:getApiConfig	()Lcom/jfinal/weixin/sdk/api/ApiConfig;
    //   29: invokestatic 37	com/jfinal/weixin/sdk/api/ApiConfigKit:setThreadLocalApiConfig	(Lcom/jfinal/weixin/sdk/api/ApiConfig;)V
    //   32: aload_1
    //   33: invokevirtual 43	com/jfinal/aop/Invocation:invoke	()V
    //   36: goto +9 -> 45
    //   39: astore_3
    //   40: invokestatic 46	com/jfinal/weixin/sdk/api/ApiConfigKit:removeThreadLocalApiConfig	()V
    //   43: aload_3
    //   44: athrow
    //   45: invokestatic 46	com/jfinal/weixin/sdk/api/ApiConfigKit:removeThreadLocalApiConfig	()V
    //   48: return
    // Line number table:
    //   Java source line #15	-> byte code offset #0
    //   Java source line #16	-> byte code offset #5
    //   Java source line #17	-> byte code offset #12
    //   Java source line #20	-> byte code offset #22
    //   Java source line #21	-> byte code offset #32
    //   Java source line #22	-> byte code offset #36
    //   Java source line #23	-> byte code offset #39
    //   Java source line #24	-> byte code offset #40
    //   Java source line #25	-> byte code offset #43
    //   Java source line #24	-> byte code offset #45
    //   Java source line #26	-> byte code offset #48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	ApiInterceptor
    //   0	49	1	inv	com.jfinal.aop.Invocation
    //   4	19	2	controller	com.jfinal.core.Controller
    //   39	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	39	39	finally
  }
}


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\jfinal\ApiInterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */