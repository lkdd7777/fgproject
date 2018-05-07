/*     */ package com.fgoa.entity.userinfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_user_jyjl", schema="")
/*     */ public class TUserJyjlEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
/*     */   private String xxmc;
/*     */   private String rxsj;
/*     */   private String bysj;
/*     */   private String sxzy;
/*     */   private String whcd;
/*     */   private String xw;
/*     */   private String jyjlbz;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  60 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  68 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="UID", nullable=true, length=36)
/*     */   public String getUid()
/*     */   {
/*  76 */     return this.uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUid(String uid)
/*     */   {
/*  84 */     this.uid = uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XXMC", nullable=true, length=100)
/*     */   public String getXxmc()
/*     */   {
/*  92 */     return this.xxmc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXxmc(String xxmc)
/*     */   {
/* 100 */     this.xxmc = xxmc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RXSJ", nullable=true, length=100)
/*     */   public String getRxsj()
/*     */   {
/* 108 */     return this.rxsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRxsj(String rxsj)
/*     */   {
/* 116 */     this.rxsj = rxsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BYSJ", nullable=true, length=100)
/*     */   public String getBysj()
/*     */   {
/* 124 */     return this.bysj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBysj(String bysj)
/*     */   {
/* 132 */     this.bysj = bysj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SXZY", nullable=true, length=100)
/*     */   public String getSxzy()
/*     */   {
/* 140 */     return this.sxzy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSxzy(String sxzy)
/*     */   {
/* 148 */     this.sxzy = sxzy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="WHCD", nullable=true, length=100)
/*     */   public String getWhcd()
/*     */   {
/* 156 */     return this.whcd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setWhcd(String whcd)
/*     */   {
/* 164 */     this.whcd = whcd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XW", nullable=true, length=100)
/*     */   public String getXw()
/*     */   {
/* 172 */     return this.xw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXw(String xw)
/*     */   {
/* 180 */     this.xw = xw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JYJLBZ", nullable=true, length=100)
/*     */   public String getJyjlbz()
/*     */   {
/* 188 */     return this.jyjlbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJyjlbz(String jyjlbz)
/*     */   {
/* 196 */     this.jyjlbz = jyjlbz;
/*     */   }
/*     */ }


