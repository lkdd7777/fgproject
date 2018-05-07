package com.fgoa.service.houseassets;

import com.fgoa.entity.houseassets.HouseAssetsEntity;
import java.io.Serializable;
import org.jeecgframework.core.common.service.CommonService;

public interface HouseAssetsServiceI
  extends CommonService
{
  public <T> void delete(T paramT);
  
  public <T> Serializable save(T paramT);
  
  public <T> void saveOrUpdate(T paramT);
  
  public boolean doAddSql(HouseAssetsEntity paramHouseAssetsEntity);
  
  public boolean doUpdateSql(HouseAssetsEntity paramHouseAssetsEntity);
  
  public boolean doDelSql(HouseAssetsEntity paramHouseAssetsEntity);
}


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\houseassets\HouseAssetsServiceI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */