/*     */ package com.fgoa.entity.houseassets;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="tbl_house_assets", schema="")
/*     */ public class HouseAssetsEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private Integer sortNum;
/*     */   @Excel(exportName="资产地址", orderNum="1", needMerge=false)
/*     */   private String address;
/*     */   @Excel(exportName="建筑面积", orderNum="2", needMerge=false)
/*     */   private String buildingArea;
/*     */   @Excel(exportName="土地面积", orderNum="3", needMerge=false)
/*     */   private String landArea;
/*     */   @Excel(exportName="合同价款", orderNum="4", needMerge=false)
/*     */   private String contractPrice;
/*     */   @Excel(exportName="取得时间", orderNum="5", needMerge=false)
/*     */   private Date achieveTime;
/*     */   @Excel(exportName="办证时间", orderNum="6", needMerge=false)
/*     */   private Date certificateTime;
/*     */   @Excel(exportName="证载用途", orderNum="7", needMerge=false)
/*     */   private String purpose;
/*     */   @Excel(exportName="权属情况", orderNum="8", needMerge=false)
/*     */   private String ownership;
/*     */   @Excel(exportName="房屋现状", orderNum="9", needMerge=false)
/*     */   private String housingSituation;
/*     */   @Excel(exportName="租金方式", orderNum="10", needMerge=false)
/*     */   private String rentalType;
/*     */   @Excel(exportName="租金", orderNum="11", needMerge=false)
/*     */   private String rental;
/*     */   @Excel(exportName="承租时间", orderNum="12", needMerge=false)
/*     */   private Date leaseTime;
/*     */   @Excel(exportName="租期", orderNum="13", needMerge=false)
/*     */   private String lease;
/*     */   @Excel(exportName="承租人", orderNum="14", needMerge=false)
/*     */   private String user;
/*     */   @Excel(exportName="承租人电话", orderNum="15", needMerge=false)
/*     */   private String userPhone;
/*     */   @Excel(exportName="水电煤等缴费方式", orderNum="16", needMerge=false)
/*     */   private String other;
/*     */   @Excel(exportName="备注", orderNum="17", needMerge=false)
/*     */   private String remark;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/* 103 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/* 111 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SORT_NUM", nullable=true, length=10)
/*     */   public Integer getSortNum()
/*     */   {
/* 119 */     return this.sortNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSortNum(Integer sortNum)
/*     */   {
/* 127 */     this.sortNum = sortNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ADDRESS", nullable=true, length=200)
/*     */   public String getAddress()
/*     */   {
/* 135 */     return this.address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 143 */     this.address = address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BUILDING_AREA", nullable=true, length=100)
/*     */   public String getBuildingArea()
/*     */   {
/* 151 */     return this.buildingArea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBuildingArea(String buildingArea)
/*     */   {
/* 159 */     this.buildingArea = buildingArea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="LAND_AREA", nullable=true, length=100)
/*     */   public String getLandArea()
/*     */   {
/* 167 */     return this.landArea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLandArea(String landArea)
/*     */   {
/* 175 */     this.landArea = landArea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CONTRACT_PRICE", nullable=true, length=100)
/*     */   public String getContractPrice()
/*     */   {
/* 183 */     return this.contractPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContractPrice(String contractPrice)
/*     */   {
/* 191 */     this.contractPrice = contractPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ACHIEVE_TIME", nullable=true)
/*     */   public Date getAchieveTime()
/*     */   {
/* 199 */     return this.achieveTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAchieveTime(Date achieveTime)
/*     */   {
/* 207 */     this.achieveTime = achieveTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CERTIFICATE_TIME", nullable=true)
/*     */   public Date getCertificateTime()
/*     */   {
/* 215 */     return this.certificateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCertificateTime(Date certificateTime)
/*     */   {
/* 223 */     this.certificateTime = certificateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PURPOSE", nullable=true, length=500)
/*     */   public String getPurpose()
/*     */   {
/* 231 */     return this.purpose;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPurpose(String purpose)
/*     */   {
/* 239 */     this.purpose = purpose;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="OWNERSHIP", nullable=true, length=500)
/*     */   public String getOwnership()
/*     */   {
/* 247 */     return this.ownership;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOwnership(String ownership)
/*     */   {
/* 255 */     this.ownership = ownership;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="HOUSING_SITUATION", nullable=true, length=500)
/*     */   public String getHousingSituation()
/*     */   {
/* 263 */     return this.housingSituation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHousingSituation(String housingSituation)
/*     */   {
/* 271 */     this.housingSituation = housingSituation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RENTAL_TYPE", nullable=true, length=11)
/*     */   public String getRentalType()
/*     */   {
/* 279 */     return this.rentalType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRentalType(String rentalType)
/*     */   {
/* 287 */     this.rentalType = rentalType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RENTAL", nullable=true, length=100)
/*     */   public String getRental()
/*     */   {
/* 295 */     return this.rental;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRental(String rental)
/*     */   {
/* 303 */     this.rental = rental;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="LEASE_TIME", nullable=true)
/*     */   public Date getLeaseTime()
/*     */   {
/* 311 */     return this.leaseTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLeaseTime(Date leaseTime)
/*     */   {
/* 319 */     this.leaseTime = leaseTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="LEASE", nullable=true, length=100)
/*     */   public String getLease()
/*     */   {
/* 327 */     return this.lease;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLease(String lease)
/*     */   {
/* 335 */     this.lease = lease;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="USER", nullable=true, length=100)
/*     */   public String getUser()
/*     */   {
/* 343 */     return this.user;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUser(String user)
/*     */   {
/* 351 */     this.user = user;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="USER_PHONE", nullable=true, length=100)
/*     */   public String getUserPhone()
/*     */   {
/* 359 */     return this.userPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserPhone(String userPhone)
/*     */   {
/* 367 */     this.userPhone = userPhone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="OTHER", nullable=true, length=500)
/*     */   public String getOther()
/*     */   {
/* 375 */     return this.other;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOther(String other)
/*     */   {
/* 383 */     this.other = other;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="REMARK", nullable=true, length=500)
/*     */   public String getRemark()
/*     */   {
/* 391 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 399 */     this.remark = remark;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\houseassets\HouseAssetsEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */