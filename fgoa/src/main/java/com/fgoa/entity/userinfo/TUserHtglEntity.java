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
/*     */ @Entity
/*     */ @Table(name="t_user_htgl", schema="")
/*     */ public class TUserHtglEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
/*     */   private String htbh;
/*     */   private String sybzht;
/*     */   private String qyhtsj;
/*     */   private String htdqsj;
/*     */   private String xqsj;
/*     */   private String htglbz;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  58 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  66 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="UID", nullable=true, length=36)
/*     */   public String getUid()
/*     */   {
/*  74 */     return this.uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUid(String uid)
/*     */   {
/*  82 */     this.uid = uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="HTBH", nullable=true, length=100)
/*     */   public String getHtbh()
/*     */   {
/*  90 */     return this.htbh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHtbh(String htbh)
/*     */   {
/*  98 */     this.htbh = htbh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SYBZHT", nullable=true, length=100)
/*     */   public String getSybzht()
/*     */   {
/* 106 */     return this.sybzht;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSybzht(String sybzht)
/*     */   {
/* 114 */     this.sybzht = sybzht;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="QYHTSJ", nullable=true, length=100)
/*     */   public String getQyhtsj()
/*     */   {
/* 122 */     return this.qyhtsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setQyhtsj(String qyhtsj)
/*     */   {
/* 130 */     this.qyhtsj = qyhtsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="HTDQSJ", nullable=true, length=100)
/*     */   public String getHtdqsj()
/*     */   {
/* 138 */     return this.htdqsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHtdqsj(String htdqsj)
/*     */   {
/* 146 */     this.htdqsj = htdqsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XQSJ", nullable=true, length=100)
/*     */   public String getXqsj()
/*     */   {
/* 154 */     return this.xqsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXqsj(String xqsj)
/*     */   {
/* 162 */     this.xqsj = xqsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="HTGLBZ", nullable=true, length=100)
/*     */   public String getHtglbz()
/*     */   {
/* 170 */     return this.htglbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHtglbz(String htglbz)
/*     */   {
/* 178 */     this.htglbz = htglbz;
/*     */   }
/*     */ }


