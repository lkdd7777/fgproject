/*     */ package com.fgoa.entity.carfee;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.GenericGenerator;
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
/*     */ @Table(name="t_oa_car_fee", schema="")
/*     */ public class CarFeeEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private Date recorddate;
/*     */   private String feetype;
/*     */   private Integer amount;
/*     */   private String remark;
/*     */   private String carid;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  54 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  62 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RECORDDATE", nullable=false)
/*     */   public Date getRecorddate()
/*     */   {
/*  70 */     return this.recorddate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRecorddate(Date recorddate)
/*     */   {
/*  78 */     this.recorddate = recorddate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="FEETYPE", nullable=false, length=20)
/*     */   public String getFeetype()
/*     */   {
/*  86 */     return this.feetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFeetype(String feetype)
/*     */   {
/*  94 */     this.feetype = feetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="AMOUNT", nullable=false, scale=2, length=100)
/*     */   public Integer getAmount()
/*     */   {
/* 102 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmount(Integer amount)
/*     */   {
/* 110 */     this.amount = amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="REMARK", nullable=true, length=1000)
/*     */   public String getRemark()
/*     */   {
/* 118 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 126 */     this.remark = remark;
/*     */   }
/*     */   
/*     */   public String getCarid() {
/* 130 */     return this.carid;
/*     */   }
/*     */   
/*     */   public void setCarid(String carid) {
/* 134 */     this.carid = carid;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\carfee\CarFeeEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */