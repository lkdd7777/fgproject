package com.jfinal.weixin.fgoa;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;

@com.jfinal.ext.route.ControllerBind(controllerKey="/api/menu")
public class MenuController extends ApiController
{
  private static final String menuContent = "{\"menu\":{\"button\":[{\"name\":\"办理业务\",\"sub_button\":[{\"name\":\"信访管理\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/PetitionList.html\"},{\"name\":\"收文管理\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/InboxList.html\"},{\"name\":\"发文管理\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/PostList.html\"}]},{\"name\":\"信息查询\",\"sub_button\":[{\"name\":\"本周安排\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/Announcement.html\"},{\"name\":\"个人日程\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/ScheduleList.html\"},{\"name\":\"通讯录\",\"type\":\"view\",\"url\":\"http://58.49.59.137/front/weixin/contact\"}]}]}}";
  
  public void get()
  {
    renderJson("{\"menu\":{\"button\":[{\"name\":\"办理业务\",\"sub_button\":[{\"name\":\"信访管理\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/PetitionList.html\"},{\"name\":\"收文管理\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/InboxList.html\"},{\"name\":\"发文管理\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/PostList.html\"}]},{\"name\":\"信息查询\",\"sub_button\":[{\"name\":\"本周安排\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/Announcement.html\"},{\"name\":\"个人日程\",\"type\":\"view\",\"url\":\"http://58.49.59.137:8011/ScheduleList.html\"},{\"name\":\"通讯录\",\"type\":\"view\",\"url\":\"http://58.49.59.137/front/weixin/contact\"}]}]}}");
  }
  



  public ApiConfig getApiConfig()
  {
    ApiConfig ac = new ApiConfig();
    

    ac.setToken(PropKit.get("token"));
    ac.setAppId(PropKit.get("appId"));
    ac.setAppSecret(PropKit.get("appSecret"));
    




    ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", Boolean.valueOf(false)).booleanValue());
    ac.setEncodingAesKey(PropKit.get("encodingAesKey", 
      "setting it in config file"));
    return ac;
  }
}


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\fgoa\MenuController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */