/*     */ package com.fgoa.entity.carassets;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ @Entity
/*     */ @Table(name="tbl_car_assets", schema="")
/*     */ public class CarAssetsEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private Integer sortNum;
/*     */   @Excel(exportName="保险", orderNum="1", needMerge=false)
/*     */   private String insurance;
/*     */   @Excel(exportName="过桥费", orderNum="2", needMerge=false)
/*     */   private String bridgeToll;
/*     */   @Excel(exportName="油卡充值", orderNum="3", needMerge=false)
/*     */   private String cardRecharge;
/*     */   @Excel(exportName="维修", orderNum="4", needMerge=false)
/*     */   private String repairs;
/*     */   @Excel(exportName="停车费", orderNum="5", needMerge=false)
/*     */   private String parkingFee;
/*     */   @Excel(exportName="用油量", orderNum="6", needMerge=false)
/*     */   private String oilCapacity;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  70 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  78 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SORT_NUM", nullable=true, length=10)
/*     */   public Integer getSortNum()
/*     */   {
/*  86 */     return this.sortNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSortNum(Integer sortNum)
/*     */   {
/*  94 */     this.sortNum = sortNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="INSURANCE", nullable=true, length=100)
/*     */   public String getInsurance()
/*     */   {
/* 102 */     return this.insurance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInsurance(String insurance)
/*     */   {
/* 110 */     this.insurance = insurance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BRIDGE_TOLL", nullable=true, length=100)
/*     */   public String getBridgeToll()
/*     */   {
/* 118 */     return this.bridgeToll;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBridgeToll(String bridgeToll)
/*     */   {
/* 126 */     this.bridgeToll = bridgeToll;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CARD_RECHARGE", nullable=true, length=100)
/*     */   public String getCardRecharge()
/*     */   {
/* 134 */     return this.cardRecharge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCardRecharge(String cardRecharge)
/*     */   {
/* 142 */     this.cardRecharge = cardRecharge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="REPAIRS", nullable=true, length=100)
/*     */   public String getRepairs()
/*     */   {
/* 150 */     return this.repairs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRepairs(String repairs)
/*     */   {
/* 158 */     this.repairs = repairs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PARKING_FEE", nullable=true, length=100)
/*     */   public String getParkingFee()
/*     */   {
/* 166 */     return this.parkingFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParkingFee(String parkingFee)
/*     */   {
/* 174 */     this.parkingFee = parkingFee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="OIL_CAPACITY", nullable=true, length=100)
/*     */   public String getOilCapacity()
/*     */   {
/* 182 */     return this.oilCapacity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOilCapacity(String oilCapacity)
/*     */   {
/* 190 */     this.oilCapacity = oilCapacity;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\carassets\CarAssetsEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */