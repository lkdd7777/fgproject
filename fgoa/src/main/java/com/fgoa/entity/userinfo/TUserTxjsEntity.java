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
/*     */ @Table(name="t_user_txjs", schema="")
/*     */ public class TUserTxjsEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
/*     */   private String tzsj;
/*     */   private String txqje;
/*     */   private String txhje;
/*     */   private String txwh;
/*     */   private String txbz;
/*     */   private String txyy;
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
/*     */   @Column(name="TZSJ", nullable=true, length=100)
/*     */   public String getTzsj()
/*     */   {
/*  90 */     return this.tzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTzsj(String tzsj)
/*     */   {
/*  98 */     this.tzsj = tzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TXQJE", nullable=true, length=100)
/*     */   public String getTxqje()
/*     */   {
/* 106 */     return this.txqje;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTxqje(String txqje)
/*     */   {
/* 114 */     this.txqje = txqje;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TXHJE", nullable=true, length=100)
/*     */   public String getTxhje()
/*     */   {
/* 122 */     return this.txhje;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTxhje(String txhje)
/*     */   {
/* 130 */     this.txhje = txhje;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TXWH", nullable=true, length=100)
/*     */   public String getTxwh()
/*     */   {
/* 138 */     return this.txwh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTxwh(String txwh)
/*     */   {
/* 146 */     this.txwh = txwh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TXBZ", nullable=true, length=100)
/*     */   public String getTxbz()
/*     */   {
/* 154 */     return this.txbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTxbz(String txbz)
/*     */   {
/* 162 */     this.txbz = txbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TXYY", nullable=true, length=100)
/*     */   public String getTxyy()
/*     */   {
/* 170 */     return this.txyy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTxyy(String txyy)
/*     */   {
/* 178 */     this.txyy = txyy;
/*     */   }
/*     */ }


