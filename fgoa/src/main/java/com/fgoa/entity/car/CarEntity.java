/*     */ package com.fgoa.entity.car;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
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
/*     */ @Table(name="t_oa_car", schema="")
/*     */ public class CarEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String carnum;
/*     */   private Date regdate;
/*     */   private Date presurveydate;
/*     */   private Date surveydate;
/*     */   private Date insurencedate;
/*     */   private Date insurenceLimitdate;
/*     */   private Date etcdate;
/*     */   private Date etclimitdate;
/*     */   private String telnum;
/*     */   private String status;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  63 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  72 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="CARNUM", nullable=false, length=20)
/*     */   public String getCarnum()
/*     */   {
/*  82 */     return this.carnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCarnum(String carnum)
/*     */   {
/*  91 */     this.carnum = carnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="REGDATE", nullable=false)
/*     */   public Date getRegdate()
/*     */   {
/* 101 */     return this.regdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegdate(Date regdate)
/*     */   {
/* 110 */     this.regdate = regdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="PRESURVEYDATE", nullable=false)
/*     */   public Date getPresurveydate()
/*     */   {
/* 120 */     return this.presurveydate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPresurveydate(Date presurveydate)
/*     */   {
/* 129 */     this.presurveydate = presurveydate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="SURVEYDATE", nullable=false)
/*     */   public Date getSurveydate()
/*     */   {
/* 139 */     return this.surveydate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSurveydate(Date surveydate)
/*     */   {
/* 148 */     this.surveydate = surveydate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="ETCDATE", nullable=false)
/*     */   public Date getEtcdate()
/*     */   {
/* 158 */     return this.etcdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEtcdate(Date etcdate)
/*     */   {
/* 167 */     this.etcdate = etcdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="ETCLIMITDATE", nullable=false)
/*     */   public Date getEtclimitdate()
/*     */   {
/* 177 */     return this.etclimitdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEtclimitdate(Date etclimitdate)
/*     */   {
/* 186 */     this.etclimitdate = etclimitdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="TELNUM", nullable=false, length=20)
/*     */   public String getTelnum()
/*     */   {
/* 196 */     return this.telnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTelnum(String telnum)
/*     */   {
/* 205 */     this.telnum = telnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="STATUS", nullable=false)
/*     */   public String getStatus()
/*     */   {
/* 215 */     return this.status;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 224 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Date getInsurencedate() {
/* 228 */     return this.insurencedate;
/*     */   }
/*     */   
/*     */   public void setInsurencedate(Date insurencedate) {
/* 232 */     this.insurencedate = insurencedate;
/*     */   }
/*     */   
/*     */   public Date getInsurenceLimitdate() {
/* 236 */     return this.insurenceLimitdate;
/*     */   }
/*     */   
/*     */   public void setInsurenceLimitdate(Date insurenceLimitdate) {
/* 240 */     this.insurenceLimitdate = insurenceLimitdate;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\car\CarEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */