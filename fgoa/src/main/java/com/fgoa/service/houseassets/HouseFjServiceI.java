package com.fgoa.service.houseassets;

import com.fgoa.entity.houseassets.HouseFjEntity;
import java.io.Serializable;
import org.jeecgframework.core.common.service.CommonService;

public  interface HouseFjServiceI
  extends CommonService
{
  public  <T> void delete(T paramT);
  
  public  <T> Serializable save(T paramT);
  
  public  <T> void saveOrUpdate(T paramT);
  
  public  boolean doAddSql(HouseFjEntity paramHouseFjEntity);
  
  public  boolean doUpdateSql(HouseFjEntity paramHouseFjEntity);
  
  public  boolean doDelSql(HouseFjEntity paramHouseFjEntity);
}


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\houseassets\HouseFjServiceI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */