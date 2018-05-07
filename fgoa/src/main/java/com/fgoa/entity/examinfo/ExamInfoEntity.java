/*    */ package com.fgoa.entity.examinfo;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="t_oa_exam_info", schema="")
/*    */ public class ExamInfoEntity
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String type;
/*    */   private String content;
/*    */   
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
/*    */   @Column(name="ID", nullable=false, length=20)
/*    */   public Integer getId()
/*    */   {
/* 47 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId(Integer id)
/*    */   {
/* 55 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @Column(name="TYPE", nullable=false, length=10)
/*    */   public String getType()
/*    */   {
/* 63 */     return this.type;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setType(String type)
/*    */   {
/* 71 */     this.type = type;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @Column(name="CONTENT", nullable=false, length=5000)
/*    */   public String getContent()
/*    */   {
/* 79 */     return this.content;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setContent(String content)
/*    */   {
/* 87 */     this.content = content;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\examinfo\ExamInfoEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */