/*     */ package com.fgoa.entity.examconfig;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
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
/*     */ @Table(name="t_oa_exam_config", schema="")
/*     */ public class ExamConfigEntity
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private String title;
/*     */   private Integer maxage;
/*     */   private Integer minage;
/*     */   private Integer allowtime;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(name="ID", nullable=false, length=20)
/*     */   public Integer getId()
/*     */   {
/*  51 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  59 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TITLE", nullable=false, length=100)
/*     */   public String getTitle()
/*     */   {
/*  67 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  75 */     this.title = title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="MAXAGE", nullable=true, length=2)
/*     */   public Integer getMaxage()
/*     */   {
/*  83 */     return this.maxage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMaxage(Integer maxage)
/*     */   {
/*  91 */     this.maxage = maxage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="MINAGE", nullable=true, length=2)
/*     */   public Integer getMinage()
/*     */   {
/*  99 */     return this.minage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMinage(Integer minage)
/*     */   {
/* 107 */     this.minage = minage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ALLOWTIME", nullable=false, length=3)
/*     */   public Integer getAllowtime()
/*     */   {
/* 115 */     return this.allowtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAllowtime(Integer allowtime)
/*     */   {
/* 123 */     this.allowtime = allowtime;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\examconfig\ExamConfigEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */