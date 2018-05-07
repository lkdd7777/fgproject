/*     */ package com.fgoa.entity.enquipment;
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
/*     */ @Table(name="t_oa_enquipment", schema="")
/*     */ public class EnquipmentEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String name;
/*     */   private String type;
/*     */   private Double amount;
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
/*     */   @Column(name="NAME", nullable=false, length=100)
/*     */   public String getName()
/*     */   {
/*  66 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  74 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TYPE", nullable=false, length=50)
/*     */   public String getType()
/*     */   {
/*  82 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/*  90 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="AMOUNT", nullable=false, length=22)
/*     */   public Double getAmount()
/*     */   {
/*  98 */     return this.amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAmount(Double amount)
/*     */   {
/* 106 */     this.amount = amount;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\enquipment\EnquipmentEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */