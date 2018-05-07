/*     */ package com.fgoa.entity.post;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import org.hibernate.annotations.GenericGenerator;
/*     */ import org.jeecgframework.poi.excel.annotation.Excel;
/*     */ import org.jeecgframework.poi.excel.annotation.ExcelTarget;
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
/*     */ @Table(name="t_oa_post", schema="")
/*     */ @ExcelTarget(id="postEntity")
/*     */ public class PostEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   @Excel(exportName="日期", orderNum="1", needMerge=false)
/*     */   private Date submittime;
/*     */   @Excel(exportName="文号", orderNum="2", needMerge=false)
/*     */   private String sortnum;
/*     */   @Excel(exportName="标题", orderNum="3", needMerge=false)
/*     */   private String title;
/*     */   @Excel(exportName="发文单位", orderNum="4", needMerge=false)
/*     */   private String departname;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  64 */     return this.id;
/*     */   }
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
/*     */   @Column(name="SUBMITTIME", nullable=true)
/*     */   public Date getSubmittime()
/*     */   {
/*  80 */     return this.submittime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSubmittime(Date submittime)
/*     */   {
/*  88 */     this.submittime = submittime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SORTNUM", nullable=true, length=200)
/*     */   public String getSortnum()
/*     */   {
/*  96 */     return this.sortnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSortnum(String sortnum)
/*     */   {
/* 104 */     this.sortnum = sortnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TITLE", nullable=true, length=1000)
/*     */   public String getTitle()
/*     */   {
/* 112 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/* 120 */     this.title = title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DEPARTNAME", nullable=true, length=200)
/*     */   public String getDepartname()
/*     */   {
/* 128 */     return this.departname;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDepartname(String departname)
/*     */   {
/* 136 */     this.departname = departname;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\post\PostEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */