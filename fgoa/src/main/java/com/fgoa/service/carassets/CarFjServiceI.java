package com.fgoa.service.carassets;

import com.fgoa.entity.carassets.CarFjEntity;
import java.io.Serializable;
import org.jeecgframework.core.common.service.CommonService;

public interface CarFjServiceI
  extends CommonService
{
  public <T> void delete(T paramT);
  
  public <T> Serializable save(T paramT);
  
  public <T> void saveOrUpdate(T paramT);
  
  public boolean doAddSql(CarFjEntity paramCarFjEntity);
  
  public boolean doUpdateSql(CarFjEntity paramCarFjEntity);
  
  public boolean doDelSql(CarFjEntity paramCarFjEntity);
}


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\carassets\CarFjServiceI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */