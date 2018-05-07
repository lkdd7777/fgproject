/*    */ package com.fgoa.entity.enquipment;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.GenericGenerator;
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
/*    */ @Table(name="t_oa_enquipment_type", schema="")
/*    */ public class EnquipmentTypeEntity
/*    */   implements Serializable
/*    */ {
/*    */   private String id;
/*    */   private String name;
/*    */   private String unitName;
/*    */   
/*    */   @Id
/*    */   @GeneratedValue(generator="paymentableGenerator")
/*    */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*    */   @Column(name="ID", nullable=false, length=36)
/*    */   public String getId()
/*    */   {
/* 48 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setId(String id)
/*    */   {
/* 56 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @Column(name="NAME", nullable=false, length=100)
/*    */   public String getName()
/*    */   {
/* 64 */     return this.name;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 72 */     this.name = name;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @Column(name="UNIT_NAME", nullable=false, length=100)
/*    */   public String getUnitName()
/*    */   {
/* 80 */     return this.unitName;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setUnitName(String unitName)
/*    */   {
/* 88 */     this.unitName = unitName;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\enquipment\EnquipmentTypeEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */