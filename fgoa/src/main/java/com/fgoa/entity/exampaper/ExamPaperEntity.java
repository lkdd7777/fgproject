/*     */ package com.fgoa.entity.exampaper;
/*     */ 
/*     */ import com.fgoa.entity.examquestion.ExamClassEntity;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import org.jeecgframework.web.system.pojo.base.TSUser;
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
/*     */ @Table(name="t_oa_exam_paper", schema="")
/*     */ public class ExamPaperEntity
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Date starttime;
/*     */   private Date endtime;
/*     */   private Integer score;
/*     */   private Date pausetime;
/*     */   private String iscomplete;
/*     */   private List<ExamPaperQuestionEntity> questionList;
/*     */   private TSUser user;
/*     */   private ExamClassEntity examClass;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(name="ID", nullable=false, length=20)
/*     */   public Integer getId()
/*     */   {
/*  60 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  68 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="STARTTIME", nullable=true)
/*     */   public Date getStarttime()
/*     */   {
/*  76 */     return this.starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStarttime(Date starttime)
/*     */   {
/*  84 */     this.starttime = starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ENDTIME", nullable=true)
/*     */   public Date getEndtime()
/*     */   {
/*  92 */     return this.endtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEndtime(Date endtime)
/*     */   {
/* 100 */     this.endtime = endtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SCORE", nullable=true, length=10)
/*     */   public Integer getScore()
/*     */   {
/* 108 */     return this.score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScore(Integer score)
/*     */   {
/* 116 */     this.score = score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PAUSETIME", nullable=true)
/*     */   public Date getPausetime()
/*     */   {
/* 124 */     return this.pausetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPausetime(Date pausetime)
/*     */   {
/* 132 */     this.pausetime = pausetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ISCOMPLETE", nullable=true, length=10)
/*     */   public String getIscomplete()
/*     */   {
/* 140 */     return this.iscomplete;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIscomplete(String iscomplete)
/*     */   {
/* 148 */     this.iscomplete = iscomplete;
/*     */   }
/*     */   
/*     */   @ManyToOne(targetEntity=TSUser.class)
/*     */   public TSUser getUser() {
/* 153 */     return this.user;
/*     */   }
/*     */   
/*     */   public void setUser(TSUser user) {
/* 157 */     this.user = user;
/*     */   }
/*     */   
/*     */   @ManyToOne(targetEntity=ExamClassEntity.class)
/*     */   public ExamClassEntity getExamClass() {
/* 162 */     return this.examClass;
/*     */   }
/*     */   
/*     */   public void setExamClass(ExamClassEntity examClass) {
/* 166 */     this.examClass = examClass;
/*     */   }
/*     */   
/*     */   @OneToMany(mappedBy="paper")
/*     */   public List<ExamPaperQuestionEntity> getQuestionList() {
/* 171 */     return this.questionList;
/*     */   }
/*     */   
/*     */   public void setQuestionList(List<ExamPaperQuestionEntity> questionList) {
/* 175 */     this.questionList = questionList;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\exampaper\ExamPaperEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */