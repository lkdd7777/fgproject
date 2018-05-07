/*     */ package com.fgoa.entity.devicemanage;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.GenericGenerator;
/*     */ import org.jeecgframework.poi.excel.annotation.Excel;
/*     */ import org.jeecgframework.poi.excel.annotation.ExcelTarget;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_oa_device_manage", schema="")
/*     */ @ExcelTarget(id="deviceManageEntity")
/*     */ public class DeviceManageEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   @Excel(exportName="序号", orderNum="1", needMerge=false)
/*     */   private Integer myorder;
/*     */   @Excel(exportName="部门", orderNum="2", needMerge=false)
/*     */   private String depart;
/*     */   @Excel(exportName="型号", orderNum="3", needMerge=false)
/*     */   private String model;
/*     */   @Excel(exportName="类型", orderNum="4", needMerge=false)
/*     */   private String type;
/*     */   @Excel(exportName="设备类型", orderNum="5", needMerge=false)
/*     */   private String devicetype;
/*     */   @Excel(exportName="购置时间", orderNum="6", needMerge=false)
/*     */   private Date purchasedate;
/*     */   @Excel(exportName="基本配置", orderNum="7", needMerge=false)
/*     */   private String baseconfig;
/*     */   @Excel(exportName="状况", orderNum="8", needMerge=false)
/*     */   private String status;
/*     */   @Excel(exportName="使用人", orderNum="9", needMerge=false)
/*     */   private String user;
/*     */   @Excel(exportName="备注", orderNum="10", needMerge=false)
/*     */   private String remark;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  82 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  90 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="MYORDER", nullable=true)
/*     */   public Integer getMyorder()
/*     */   {
/*  98 */     return this.myorder;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMyorder(Integer myorder)
/*     */   {
/* 106 */     this.myorder = myorder;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DEPART", nullable=true, length=100)
/*     */   public String getDepart()
/*     */   {
/* 114 */     return this.depart;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDepart(String depart)
/*     */   {
/* 122 */     this.depart = depart;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="MODEL", nullable=true, length=100)
/*     */   public String getModel()
/*     */   {
/* 130 */     return this.model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setModel(String model)
/*     */   {
/* 138 */     this.model = model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TYPE", nullable=true, length=100)
/*     */   public String getType()
/*     */   {
/* 146 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 154 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DEVICETYPE", nullable=true, length=100)
/*     */   public String getDevicetype()
/*     */   {
/* 162 */     return this.devicetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDevicetype(String devicetype)
/*     */   {
/* 170 */     this.devicetype = devicetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PURCHASEDATE", nullable=true, length=100)
/*     */   public Date getPurchasedate()
/*     */   {
/* 178 */     return this.purchasedate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPurchasedate(Date purchasedate)
/*     */   {
/* 186 */     this.purchasedate = purchasedate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BASECONFIG", nullable=true, length=100)
/*     */   public String getBaseconfig()
/*     */   {
/* 194 */     return this.baseconfig;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBaseconfig(String baseconfig)
/*     */   {
/* 202 */     this.baseconfig = baseconfig;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="STATUS", nullable=true, length=100)
/*     */   public String getStatus()
/*     */   {
/* 210 */     return this.status;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 218 */     this.status = status;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="USER", nullable=true, length=100)
/*     */   public String getUser()
/*     */   {
/* 226 */     return this.user;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUser(String user)
/*     */   {
/* 234 */     this.user = user;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="REMARK", nullable=true, length=500)
/*     */   public String getRemark()
/*     */   {
/* 242 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 250 */     this.remark = remark;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\devicemanage\DeviceManageEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */