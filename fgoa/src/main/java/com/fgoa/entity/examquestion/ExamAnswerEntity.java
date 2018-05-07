/*    */ package com.fgoa.entity.examquestion;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.ManyToOne;
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
/*    */ @Table(name="t_oa_exam_question_answer", schema="")
/*    */ public class ExamAnswerEntity
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private ExamQuestionEntity question;
/*    */   private String content;
/*    */   private boolean isCorrect;
/*    */   
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="ID", nullable=false, length=20)
/*    */   public Integer getId()
/*    */   {
/* 42 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId(Integer id)
/*    */   {
/* 50 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 54 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 58 */     this.content = content;
/*    */   }
/*    */   
/*    */   @Column(name="isCorrect")
/*    */   public boolean isCorrect() {
/* 63 */     return this.isCorrect;
/*    */   }
/*    */   
/*    */   public void setCorrect(boolean isCorrect) {
/* 67 */     this.isCorrect = isCorrect;
/*    */   }
/*    */   
/*    */   @ManyToOne
/*    */   public ExamQuestionEntity getQuestion() {
/* 72 */     return this.question;
/*    */   }
/*    */   
/*    */   public void setQuestion(ExamQuestionEntity question) {
/* 76 */     this.question = question;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\examquestion\ExamAnswerEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */