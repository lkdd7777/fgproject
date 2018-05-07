/*     */ package com.fgoa.entity.officesupply;
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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_oa_office_supply", schema="")
/*     */ @ExcelTarget(id="officeSupplyEntity")
/*     */ public class OfficeSupplyEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   @Excel(exportName="序号", orderNum="1", needMerge=false)
/*     */   private Integer myorder;
/*     */   @Excel(exportName="中心名称", orderNum="2", needMerge=false)
/*     */   private String guestname;
/*     */   @Excel(exportName="分类", orderNum="3", needMerge=false)
/*     */   private String devicetype;
/*     */   @Excel(exportName="产品名称", orderNum="4", needMerge=false)
/*     */   private String devicename;
/*     */   @Excel(exportName="采购时间", orderNum="5", needMerge=false)
/*     */   private Date purchasedate;
/*     */   @Excel(exportName="单位", orderNum="6", needMerge=false)
/*     */   private String unit;
/*     */   @Excel(exportName="数量", orderNum="7", needMerge=false)
/*     */   private Integer number;
/*     */   @Excel(exportName="单价", orderNum="8", needMerge=false)
/*     */   private Double price;
/*     */   @Excel(exportName="金额", orderNum="9", needMerge=false)
/*     */   private Double money;
/*     */   @Excel(exportName="申请科室", orderNum="10", needMerge=false)
/*     */   private String depart;
/*     */   @Excel(exportName="签收备注", orderNum="11", needMerge=false)
/*     */   private String remark;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  85 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  93 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="MYORDER", nullable=true, length=11)
/*     */   public Integer getMyorder()
/*     */   {
/* 101 */     return this.myorder;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMyorder(Integer myorder)
/*     */   {
/* 109 */     this.myorder = myorder;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GUESTNAME", nullable=true, length=100)
/*     */   public String getGuestname()
/*     */   {
/* 117 */     return this.guestname;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGuestname(String guestname)
/*     */   {
/* 125 */     this.guestname = guestname;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DEVICETYPE", nullable=true, length=100)
/*     */   public String getDevicetype()
/*     */   {
/* 133 */     return this.devicetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDevicetype(String devicetype)
/*     */   {
/* 141 */     this.devicetype = devicetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DEVICENAME", nullable=true, length=100)
/*     */   public String getDevicename()
/*     */   {
/* 149 */     return this.devicename;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDevicename(String devicename)
/*     */   {
/* 157 */     this.devicename = devicename;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PURCHASEDATE", nullable=true)
/*     */   public Date getPurchasedate()
/*     */   {
/* 165 */     return this.purchasedate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPurchasedate(Date purchasedate)
/*     */   {
/* 173 */     this.purchasedate = purchasedate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="UNIT", nullable=true, length=100)
/*     */   public String getUnit()
/*     */   {
/* 181 */     return this.unit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUnit(String unit)
/*     */   {
/* 189 */     this.unit = unit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="NUMBER", nullable=true)
/*     */   public Integer getNumber()
/*     */   {
/* 197 */     return this.number;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNumber(Integer number)
/*     */   {
/* 205 */     this.number = number;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PRICE", nullable=true)
/*     */   public Double getPrice()
/*     */   {
/* 213 */     return this.price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPrice(Double price)
/*     */   {
/* 221 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="MONEY", nullable=true)
/*     */   public Double getMoney()
/*     */   {
/* 229 */     return this.money;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMoney(Double money)
/*     */   {
/* 237 */     this.money = money;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DEPART", nullable=true, length=100)
/*     */   public String getDepart()
/*     */   {
/* 245 */     return this.depart;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDepart(String depart)
/*     */   {
/* 253 */     this.depart = depart;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="REMARK", nullable=true, length=500)
/*     */   public String getRemark()
/*     */   {
/* 261 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 269 */     this.remark = remark;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\officesupply\OfficeSupplyEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */