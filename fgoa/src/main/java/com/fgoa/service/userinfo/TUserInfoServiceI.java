package com.fgoa.service.userinfo;

import com.fgoa.entity.userinfo.TUserGzglEntity;
import com.fgoa.entity.userinfo.TUserGzjlEntity;
import com.fgoa.entity.userinfo.TUserHtglEntity;
import com.fgoa.entity.userinfo.TUserInfoEntity;
import com.fgoa.entity.userinfo.TUserJcjlEntity;
import com.fgoa.entity.userinfo.TUserJtcyEntity;
import com.fgoa.entity.userinfo.TUserJyjlEntity;
import com.fgoa.entity.userinfo.TUserPxjlEntity;
import com.fgoa.entity.userinfo.TUserTxjsEntity;
import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

public  interface TUserInfoServiceI
  extends CommonService
{
  public  <T> void delete(T paramT);
  
  public  void addMain(TUserInfoEntity paramTUserInfoEntity, List<TUserJtcyEntity> paramList, List<TUserJyjlEntity> paramList1, List<TUserGzjlEntity> paramList2, List<TUserHtglEntity> paramList3, List<TUserJcjlEntity> paramList4, List<TUserPxjlEntity> paramList5, List<TUserGzglEntity> paramList6, List<TUserTxjsEntity> paramList7);
  
  public  void updateMain(TUserInfoEntity paramTUserInfoEntity, List<TUserJtcyEntity> paramList, List<TUserJyjlEntity> paramList1, List<TUserGzjlEntity> paramList2, List<TUserHtglEntity> paramList3, List<TUserJcjlEntity> paramList4, List<TUserPxjlEntity> paramList5, List<TUserGzglEntity> paramList6, List<TUserTxjsEntity> paramList7);
  
  public  void delMain(TUserInfoEntity paramTUserInfoEntity);
  
  public  boolean doAddSql(TUserInfoEntity paramTUserInfoEntity);
  
  public  boolean doUpdateSql(TUserInfoEntity paramTUserInfoEntity);
  
  public  boolean doDelSql(TUserInfoEntity paramTUserInfoEntity);
}


