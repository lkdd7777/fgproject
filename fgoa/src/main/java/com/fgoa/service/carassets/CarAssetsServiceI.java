package com.fgoa.service.carassets;

import com.fgoa.entity.carassets.CarAssetsEntity;
import java.io.Serializable;
import org.jeecgframework.core.common.service.CommonService;

public interface CarAssetsServiceI
  extends CommonService
{
  public <T> void delete(T paramT);
  
  public <T> Serializable save(T paramT);
  
  public <T> void saveOrUpdate(T paramT);
  
  public boolean doAddSql(CarAssetsEntity paramCarAssetsEntity);
  
  public boolean doUpdateSql(CarAssetsEntity paramCarAssetsEntity);
  
  public boolean doDelSql(CarAssetsEntity paramCarAssetsEntity);
}


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\carassets\CarAssetsServiceI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */