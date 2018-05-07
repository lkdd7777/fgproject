/*     */ package com.fgoa.entity.carassets;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ @Entity
/*     */ @Table(name="t_car_fj", schema="")
/*     */ public class CarFjEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String cid;
/*     */   private String wjms;
/*     */   private String wjlj;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  50 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  58 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CID", nullable=true, length=36)
/*     */   public String getCid()
/*     */   {
/*  66 */     return this.cid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCid(String cid)
/*     */   {
/*  74 */     this.cid = cid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="WJMS", nullable=true, length=100)
/*     */   public String getWjms()
/*     */   {
/*  82 */     return this.wjms;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWjms(String wjms)
/*     */   {
/*  90 */     this.wjms = wjms;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="WJLJ", nullable=true, length=200)
/*     */   public String getWjlj()
/*     */   {
/*  98 */     return this.wjlj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWjlj(String wjlj)
/*     */   {
/* 106 */     this.wjlj = wjlj;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\carassets\CarFjEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */