/*    */ package com.fgoa.entity.examquestion;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_oa_exam_class", schema="")
/*    */ public class ExamClassEntity
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String classname;
/*    */   private String isstart;
/*    */   private Date limitedtime;
/*    */   private List<ExamQuestionEntity> questions;
/*    */   
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="ID", nullable=false, length=20)
/*    */   public Integer getId()
/*    */   {
/* 45 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId(Integer id)
/*    */   {
/* 53 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @Column(name="CLASSNAME", nullable=false)
/*    */   public String getClassname()
/*    */   {
/* 61 */     return this.classname;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setClassname(String classname)
/*    */   {
/* 69 */     this.classname = classname;
/*    */   }
/*    */   
/*    */   @OneToMany(mappedBy="examClass")
/*    */   public List<ExamQuestionEntity> getQuestions() {
/* 74 */     return this.questions;
/*    */   }
/*    */   
/*    */   public void setQuestions(List<ExamQuestionEntity> questions) {
/* 78 */     this.questions = questions;
/*    */   }
/*    */   
/*    */   public String getIsstart() {
/* 82 */     return this.isstart;
/*    */   }
/*    */   
/*    */   public void setIsstart(String isstart) {
/* 86 */     this.isstart = isstart;
/*    */   }
/*    */   
/*    */   public Date getLimitedtime() {
/* 90 */     return this.limitedtime;
/*    */   }
/*    */   
/*    */   public void setLimitedtime(Date limitedtime) {
/* 94 */     this.limitedtime = limitedtime;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\examquestion\ExamClassEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */