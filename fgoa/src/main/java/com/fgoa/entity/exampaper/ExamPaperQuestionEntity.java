/*     */ package com.fgoa.entity.exampaper;
/*     */ 
/*     */ import com.fgoa.entity.examquestion.ExamQuestionEntity;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ @Entity
/*     */ @Table(name="t_oa_exam_paper", schema="")
/*     */ public class ExamPaperQuestionEntity
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Date answerTime;
/*     */   private ExamPaperEntity paper;
/*     */   private ExamQuestionEntity question;
/*     */   private String answerIds;
/*     */   private String isCorrected;
/*     */   private int orderNum;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(name="ID", nullable=false, length=20)
/*     */   public Integer getId()
/*     */   {
/*  52 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  60 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getIsCorrected() {
/*  64 */     return this.isCorrected;
/*     */   }
/*     */   
/*     */   public void setIsCorrected(String isCorrected) {
/*  68 */     this.isCorrected = isCorrected;
/*     */   }
/*     */   
/*     */   public Date getAnswerTime() {
/*  72 */     return this.answerTime;
/*     */   }
/*     */   
/*     */   public void setAnswerTime(Date answerTime) {
/*  76 */     this.answerTime = answerTime;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   public ExamPaperEntity getPaper() {
/*  81 */     return this.paper;
/*     */   }
/*     */   
/*     */   public void setPaper(ExamPaperEntity paper) {
/*  85 */     this.paper = paper;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   public ExamQuestionEntity getQuestion() {
/*  90 */     return this.question;
/*     */   }
/*     */   
/*     */   public void setQuestion(ExamQuestionEntity question) {
/*  94 */     this.question = question;
/*     */   }
/*     */   
/*     */   public int getOrderNum() {
/*  98 */     return this.orderNum;
/*     */   }
/*     */   
/*     */   public void setOrderNum(int orderNum) {
/* 102 */     this.orderNum = orderNum;
/*     */   }
/*     */   
/*     */   @Column(name="answer_id")
/*     */   public String getAnswerIds() {
/* 107 */     return this.answerIds;
/*     */   }
/*     */   
/*     */   public void setAnswerIds(String answerIds) {
/* 111 */     this.answerIds = answerIds;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\exampaper\ExamPaperQuestionEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */