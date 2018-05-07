package com.fgoa.service.userinfo;

import com.fgoa.entity.userinfo.UserFjEntity;
import java.io.Serializable;
import org.jeecgframework.core.common.service.CommonService;

public  interface UserFjServiceI
  extends CommonService
{
  public <T> void delete(T paramT);
  
  public <T> Serializable save(T paramT);
  
  public <T> void saveOrUpdate(T paramT);
  
  public boolean doAddSql(UserFjEntity paramUserFjEntity);
  
  public boolean doUpdateSql(UserFjEntity paramUserFjEntity);
  
  public boolean doDelSql(UserFjEntity paramUserFjEntity);
}


