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
/*     */ @Table(name="t_user_jcjl", schema="")
/*     */ public class TUserJcjlEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
/*     */   private String jclb;
/*     */   private String jcjb;
/*     */   private String jcsj;
/*     */   private String yy;
/*     */   private String jg;
/*     */   private String jcjlbz;
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
/*     */   @Column(name="JCLB", nullable=true, length=100)
/*     */   public String getJclb()
/*     */   {
/*  90 */     return this.jclb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJclb(String jclb)
/*     */   {
/*  98 */     this.jclb = jclb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JCJB", nullable=true, length=100)
/*     */   public String getJcjb()
/*     */   {
/* 106 */     return this.jcjb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJcjb(String jcjb)
/*     */   {
/* 114 */     this.jcjb = jcjb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JCSJ", nullable=true, length=100)
/*     */   public String getJcsj()
/*     */   {
/* 122 */     return this.jcsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJcsj(String jcsj)
/*     */   {
/* 130 */     this.jcsj = jcsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="YY", nullable=true, length=100)
/*     */   public String getYy()
/*     */   {
/* 138 */     return this.yy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYy(String yy)
/*     */   {
/* 146 */     this.yy = yy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JG", nullable=true, length=100)
/*     */   public String getJg()
/*     */   {
/* 154 */     return this.jg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJg(String jg)
/*     */   {
/* 162 */     this.jg = jg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JCJLBZ", nullable=true, length=100)
/*     */   public String getJcjlbz()
/*     */   {
/* 170 */     return this.jcjlbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJcjlbz(String jcjlbz)
/*     */   {
/* 178 */     this.jcjlbz = jcjlbz;
/*     */   }
/*     */ }


