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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_user_gzgl", schema="")
/*     */ public class TUserGzglEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
/*     */   private String bndsbjs;
/*     */   private String gzkzh;
/*     */   private String bndqtjs;
/*     */   private String zszgxcbz;
/*     */   private String xjyzze;
/*     */   private String sndsbjs;
/*     */   private String xjje;
/*     */   private String sndqtjs;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  62 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  70 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="UID", nullable=true, length=36)
/*     */   public String getUid()
/*     */   {
/*  78 */     return this.uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUid(String uid)
/*     */   {
/*  86 */     this.uid = uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BNDSBJS", nullable=true, length=100)
/*     */   public String getBndsbjs()
/*     */   {
/*  94 */     return this.bndsbjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBndsbjs(String bndsbjs)
/*     */   {
/* 102 */     this.bndsbjs = bndsbjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GZKZH", nullable=true, length=100)
/*     */   public String getGzkzh()
/*     */   {
/* 110 */     return this.gzkzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGzkzh(String gzkzh)
/*     */   {
/* 118 */     this.gzkzh = gzkzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BNDQTJS", nullable=true, length=100)
/*     */   public String getBndqtjs()
/*     */   {
/* 126 */     return this.bndqtjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBndqtjs(String bndqtjs)
/*     */   {
/* 134 */     this.bndqtjs = bndqtjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ZSZGXCBZ", nullable=true, length=100)
/*     */   public String getZszgxcbz()
/*     */   {
/* 142 */     return this.zszgxcbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZszgxcbz(String zszgxcbz)
/*     */   {
/* 150 */     this.zszgxcbz = zszgxcbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XJYZZE", nullable=true, length=100)
/*     */   public String getXjyzze()
/*     */   {
/* 158 */     return this.xjyzze;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXjyzze(String xjyzze)
/*     */   {
/* 166 */     this.xjyzze = xjyzze;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SNDSBJS", nullable=true, length=100)
/*     */   public String getSndsbjs()
/*     */   {
/* 174 */     return this.sndsbjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSndsbjs(String sndsbjs)
/*     */   {
/* 182 */     this.sndsbjs = sndsbjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XJJE", nullable=true, length=100)
/*     */   public String getXjje()
/*     */   {
/* 190 */     return this.xjje;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXjje(String xjje)
/*     */   {
/* 198 */     this.xjje = xjje;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SNDQTJS", nullable=true, length=100)
/*     */   public String getSndqtjs()
/*     */   {
/* 206 */     return this.sndqtjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSndqtjs(String sndqtjs)
/*     */   {
/* 214 */     this.sndqtjs = sndqtjs;
/*     */   }
/*     */ }


