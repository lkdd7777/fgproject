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
/*     */ @Entity
/*     */ @Table(name="t_user_fj", schema="")
/*     */ public class UserFjEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String uid;
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
/*     */   @Column(name="UID", nullable=true, length=36)
/*     */   public String getUid()
/*     */   {
/*  66 */     return this.uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUid(String uid)
/*     */   {
/*  74 */     this.uid = uid;
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


