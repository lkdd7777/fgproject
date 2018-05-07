/*     */ package com.fgoa.entity.examquestion;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
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
/*     */ @Entity
/*     */ @Table(name="t_oa_exam_question", schema="")
/*     */ public class ExamQuestionEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String type;
/*     */   private String title;
/*     */   private List<ExamAnswerEntity> answerList;
/*     */   private ExamClassEntity examClass;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  49 */     return this.id;
/*     */   }
/*     */   
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
/*     */ 
/*     */ 
/*     */   @Column(name="TYPE", nullable=true, updatable=false)
/*     */   public String getType()
/*     */   {
/*  68 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/*  77 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Column(name="TITLE", nullable=true, length=1000)
/*     */   public String getTitle()
/*     */   {
/*  87 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  96 */     this.title = title;
/*     */   }
/*     */   
/*     */   @OneToMany(mappedBy="question", cascade={javax.persistence.CascadeType.ALL})
/*     */   public List<ExamAnswerEntity> getAnswerList() {
/* 101 */     return this.answerList;
/*     */   }
/*     */   
/*     */   public void setAnswerList(List<ExamAnswerEntity> answerList) {
/* 105 */     this.answerList = answerList;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   public ExamClassEntity getExamClass() {
/* 110 */     return this.examClass;
/*     */   }
/*     */   
/*     */   public void setExamClass(ExamClassEntity examClass) {
/* 114 */     this.examClass = examClass;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\examquestion\ExamQuestionEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */