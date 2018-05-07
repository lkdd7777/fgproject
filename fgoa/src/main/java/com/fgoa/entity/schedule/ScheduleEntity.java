/*     */ package com.fgoa.entity.schedule;
/*     */ 
/*     */ import com.fgoa.entity.announcement.AnnouncementEntity;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.hibernate.annotations.GenericGenerator;
/*     */ import org.jeecgframework.web.system.pojo.base.TSDepart;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_oa_schedule", schema="")
/*     */ public class ScheduleEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String address;
/*     */   private String content;
/*     */   private Date executetime;
/*     */   private List<TSDepart> departs;
/*     */   private List<TSUser> users;
/*     */   private String masterDepartName;
/*     */   private String departsNameStr;
/*     */   private String usersNameStr;
/*     */   private AnnouncementEntity anno;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  79 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ADDRESS", nullable=false, length=1000)
/*     */   public String getAddress()
/*     */   {
/*  87 */     return this.address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/*  95 */     this.address = address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CONTENT", nullable=false, length=1000)
/*     */   public String getContent()
/*     */   {
/* 103 */     return this.content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 111 */     this.content = content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="EXECUTETIME", nullable=false)
/*     */   public Date getExecutetime()
/*     */   {
/* 119 */     return this.executetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setExecutetime(Date executetime)
/*     */   {
/* 127 */     this.executetime = executetime;
/*     */   }
/*     */   
/*     */   @ManyToMany
/*     */   @JoinTable(name="t_oa_schedule_depart", joinColumns={@JoinColumn(name="schedule_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="depart_id", referencedColumnName="id")})
/*     */   public List<TSDepart> getDeparts() {
/* 133 */     return this.departs;
/*     */   }
/*     */   
/*     */   public void setDeparts(List<TSDepart> departs) {
/* 137 */     this.departs = departs;
/* 138 */     StringBuilder sb = new StringBuilder();
/* 139 */     if (CollectionUtils.isNotEmpty(departs)) {
/* 140 */       for (TSDepart d : departs) {
/* 141 */         sb.append(d.getDepartname() + ",");
/*     */       }
/*     */       
/* 144 */       sb.deleteCharAt(sb.length() - 1);
/*     */     }
/* 146 */     this.departsNameStr = sb.toString();
/*     */   }
/*     */   
/*     */   @ManyToMany
/*     */   @JoinTable(name="t_oa_schedule_user", joinColumns={@JoinColumn(name="schedule_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
/*     */   public List<TSUser> getUsers() {
/* 152 */     return this.users;
/*     */   }
/*     */   
/*     */   public void setUsers(List<TSUser> users) {
/* 156 */     this.users = users;
/* 157 */     StringBuilder sb = new StringBuilder();
/* 158 */     if (CollectionUtils.isNotEmpty(users)) {
/* 159 */       for (TSUser d : users) {
/* 160 */         sb.append(d.getRealName() + ",");
/*     */       }
/*     */       
/* 163 */       sb.deleteCharAt(sb.length() - 1);
/*     */     }
/* 165 */     this.usersNameStr = sb.toString();
/*     */   }
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
/*     */   public String getMasterDepartName()
/*     */   {
/* 179 */     return this.masterDepartName;
/*     */   }
/*     */   
/*     */   public void setMasterDepartName(String masterDepartName) {
/* 183 */     this.masterDepartName = masterDepartName;
/*     */   }
/*     */   
/*     */   @Column(name="departsName", nullable=true)
/*     */   public String getDepartsNameStr() {
/* 188 */     return this.departsNameStr;
/*     */   }
/*     */   
/*     */   public void setDepartsNameStr(String departsName) {
/* 192 */     this.departsNameStr = departsName;
/*     */   }
/*     */   
/*     */   @Column(name="usersName", nullable=true)
/*     */   public String getUsersNameStr() {
/* 197 */     return this.usersNameStr;
/*     */   }
/*     */   
/*     */   public void setUsersNameStr(String usersNameStr) {
/* 201 */     this.usersNameStr = usersNameStr;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="anno_id")
/*     */   public AnnouncementEntity getAnno() {
/* 207 */     return this.anno;
/*     */   }
/*     */   
/*     */   public void setAnno(AnnouncementEntity anno) {
/* 211 */     this.anno = anno;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\schedule\ScheduleEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */