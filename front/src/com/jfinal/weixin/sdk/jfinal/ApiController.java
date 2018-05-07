package com.jfinal.weixin.sdk.jfinal;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.weixin.sdk.api.ApiConfig;

@Before({ApiInterceptor.class})
public abstract class ApiController
  extends Controller
{
  public abstract ApiConfig getApiConfig();
}


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\jfinal\ApiController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */