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
/*     */ @Table(name="t_user_jtcy", schema="")
/*     */ public class TUserJtcyEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
/*     */   private String xm;
/*     */   private String gx;
/*     */   private String gzdw;
/*     */   private String zw;
/*     */   private String dh;
/*     */   private String jtcybz;
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
/*     */   @Column(name="XM", nullable=true, length=50)
/*     */   public String getXm()
/*     */   {
/*  90 */     return this.xm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXm(String xm)
/*     */   {
/*  98 */     this.xm = xm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GX", nullable=true, length=50)
/*     */   public String getGx()
/*     */   {
/* 106 */     return this.gx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGx(String gx)
/*     */   {
/* 114 */     this.gx = gx;
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
/*     */   @Column(name="ZW", nullable=true, length=50)
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
/*     */   @Column(name="DH", nullable=true, length=50)
/*     */   public String getDh()
/*     */   {
/* 154 */     return this.dh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDh(String dh)
/*     */   {
/* 162 */     this.dh = dh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JTCYBZ", nullable=true, length=100)
/*     */   public String getJtcybz()
/*     */   {
/* 170 */     return this.jtcybz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJtcybz(String jtcybz)
/*     */   {
/* 178 */     this.jtcybz = jtcybz;
/*     */   }
/*     */ }


