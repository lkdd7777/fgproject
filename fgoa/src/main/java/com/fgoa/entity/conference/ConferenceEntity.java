/*     */ package com.fgoa.entity.conference;
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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_oa_conference", schema="")
/*     */ public class ConferenceEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private Date executetime;
/*     */   private String content;
/*     */   private String roomtype;
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
/*  72 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/*  80 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="EXECUTETIME", nullable=true)
/*     */   public Date getExecutetime()
/*     */   {
/*  88 */     return this.executetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setExecutetime(Date executetime)
/*     */   {
/*  96 */     this.executetime = executetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CONTENT", nullable=true, length=1000)
/*     */   public String getContent()
/*     */   {
/* 104 */     return this.content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 112 */     this.content = content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ROOMTYPE", nullable=true, length=50)
/*     */   public String getRoomtype()
/*     */   {
/* 120 */     return this.roomtype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRoomtype(String roomtype)
/*     */   {
/* 128 */     this.roomtype = roomtype;
/*     */   }
/*     */   
/*     */   @ManyToMany
/*     */   @JoinTable(name="t_oa_conference_depart", joinColumns={@JoinColumn(name="conference_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="depart_id", referencedColumnName="id")})
/*     */   public List<TSDepart> getDeparts() {
/* 134 */     return this.departs;
/*     */   }
/*     */   
/*     */   public void setDeparts(List<TSDepart> departs) {
/* 138 */     this.departs = departs;
/* 139 */     StringBuilder sb = new StringBuilder();
/* 140 */     if (CollectionUtils.isNotEmpty(departs)) {
/* 141 */       for (TSDepart d : departs) {
/* 142 */         sb.append(d.getDepartname() + ",");
/*     */       }
/*     */       
/* 145 */       sb.deleteCharAt(sb.length() - 1);
/*     */     }
/* 147 */     this.departsNameStr = sb.toString();
/*     */   }
/*     */   
/*     */   @ManyToMany
/*     */   @JoinTable(name="t_oa_conference_user", joinColumns={@JoinColumn(name="conference_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
/*     */   public List<TSUser> getUsers() {
/* 153 */     return this.users;
/*     */   }
/*     */   
/*     */   public void setUsers(List<TSUser> users) {
/* 157 */     this.users = users;
/* 158 */     StringBuilder sb = new StringBuilder();
/* 159 */     if (CollectionUtils.isNotEmpty(users)) {
/* 160 */       for (TSUser d : users) {
/* 161 */         sb.append(d.getRealName() + ",");
/*     */       }
/*     */       
/* 164 */       sb.deleteCharAt(sb.length() - 1);
/*     */     }
/* 166 */     this.usersNameStr = sb.toString();
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
/* 180 */     return this.masterDepartName;
/*     */   }
/*     */   
/*     */   public void setMasterDepartName(String masterDepartName) {
/* 184 */     this.masterDepartName = masterDepartName;
/*     */   }
/*     */   
/*     */   @Column(name="departsName", nullable=true)
/*     */   public String getDepartsNameStr() {
/* 189 */     return this.departsNameStr;
/*     */   }
/*     */   
/*     */   public void setDepartsNameStr(String departsName) {
/* 193 */     this.departsNameStr = departsName;
/*     */   }
/*     */   
/*     */   @Column(name="usersName", nullable=true)
/*     */   public String getUsersNameStr() {
/* 198 */     return this.usersNameStr;
/*     */   }
/*     */   
/*     */   public void setUsersNameStr(String usersNameStr) {
/* 202 */     this.usersNameStr = usersNameStr;
/*     */   }
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="anno_id")
/*     */   public AnnouncementEntity getAnno() {
/* 208 */     return this.anno;
/*     */   }
/*     */   
/*     */   public void setAnno(AnnouncementEntity anno) {
/* 212 */     this.anno = anno;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\conference\ConferenceEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */