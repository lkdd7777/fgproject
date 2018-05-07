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
/*     */ @Table(name="t_user_pxjl", schema="")
/*     */ public class TUserPxjlEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
/*     */   private String pxzzbm;
/*     */   private String pxdd;
/*     */   private String pxsj;
/*     */   private String pxjf;
/*     */   private String pxjg;
/*     */   private String dwpxbz;
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
/*     */   @Column(name="PXZZBM", nullable=true, length=100)
/*     */   public String getPxzzbm()
/*     */   {
/*  90 */     return this.pxzzbm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPxzzbm(String pxzzbm)
/*     */   {
/*  98 */     this.pxzzbm = pxzzbm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PXDD", nullable=true, length=100)
/*     */   public String getPxdd()
/*     */   {
/* 106 */     return this.pxdd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPxdd(String pxdd)
/*     */   {
/* 114 */     this.pxdd = pxdd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PXSJ", nullable=true, length=100)
/*     */   public String getPxsj()
/*     */   {
/* 122 */     return this.pxsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPxsj(String pxsj)
/*     */   {
/* 130 */     this.pxsj = pxsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PXJF", nullable=true, length=100)
/*     */   public String getPxjf()
/*     */   {
/* 138 */     return this.pxjf;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPxjf(String pxjf)
/*     */   {
/* 146 */     this.pxjf = pxjf;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PXJG", nullable=true, length=100)
/*     */   public String getPxjg()
/*     */   {
/* 154 */     return this.pxjg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPxjg(String pxjg)
/*     */   {
/* 162 */     this.pxjg = pxjg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DWPXBZ", nullable=true, length=100)
/*     */   public String getDwpxbz()
/*     */   {
/* 170 */     return this.dwpxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDwpxbz(String dwpxbz)
/*     */   {
/* 178 */     this.dwpxbz = dwpxbz;
/*     */   }
/*     */ }


