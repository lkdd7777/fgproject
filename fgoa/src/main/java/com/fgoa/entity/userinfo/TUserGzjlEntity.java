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
/*     */ @Table(name="t_user_gzjl", schema="")
/*     */ public class TUserGzjlEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
/*     */   private String rzsj;
/*     */   private String lzsj;
/*     */   private String gzdw;
/*     */   private String zw;
/*     */   private String lzyy;
/*     */   private String gzjlbz;
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
/*     */   @Column(name="RZSJ", nullable=true, length=100)
/*     */   public String getRzsj()
/*     */   {
/*  90 */     return this.rzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRzsj(String rzsj)
/*     */   {
/*  98 */     this.rzsj = rzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="LZSJ", nullable=true, length=100)
/*     */   public String getLzsj()
/*     */   {
/* 106 */     return this.lzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLzsj(String lzsj)
/*     */   {
/* 114 */     this.lzsj = lzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GZDW", nullable=true, length=100)
/*     */   public String getGzdw()
/*     */   {
/* 122 */     return this.gzdw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGzdw(String gzdw)
/*     */   {
/* 130 */     this.gzdw = gzdw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ZW", nullable=true, length=100)
/*     */   public String getZw()
/*     */   {
/* 138 */     return this.zw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZw(String zw)
/*     */   {
/* 146 */     this.zw = zw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="LZYY", nullable=true, length=100)
/*     */   public String getLzyy()
/*     */   {
/* 154 */     return this.lzyy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLzyy(String lzyy)
/*     */   {
/* 162 */     this.lzyy = lzyy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GZJLBZ", nullable=true, length=100)
/*     */   public String getGzjlbz()
/*     */   {
/* 170 */     return this.gzjlbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGzjlbz(String gzjlbz)
/*     */   {
/* 178 */     this.gzjlbz = gzjlbz;
/*     */   }
/*     */ }


