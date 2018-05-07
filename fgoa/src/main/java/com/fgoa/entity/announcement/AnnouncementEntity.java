/*     */ package com.fgoa.entity.announcement;
/*     */ 
/*     */ import com.fgoa.utils.HtmlUtils;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.Table;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="t_oa_announcement")
/*     */ public class AnnouncementEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private String title;
/*     */   private Date validtime;
/*     */   private Date invalidtime;
/*     */   private Date executeTime;
/*     */   private String content;
/*     */   private String type;
/*     */   private boolean showEndTime;
/*     */   private List<TSDepart> departs;
/*     */   private List<TSUser> users;
/*     */   private String masterDepartName;
/*     */   private String departsNameStr;
/*     */   private String usersNameStr;
/*     */   public String plainContent;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/*  75 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(String id) {
/*  79 */     this.id = id;
/*     */   }
/*     */   
/*     */   @Column(name="TITLE", nullable=false, length=100)
/*     */   public String getTitle() {
/*  84 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  88 */     this.title = title;
/*     */   }
/*     */   
/*     */   @Column(name="VALIDTIME", nullable=false)
/*     */   public Date getValidtime() {
/*  93 */     return this.validtime;
/*     */   }
/*     */   
/*     */   public void setValidtime(Date validtime) {
/*  97 */     this.validtime = validtime;
/*     */   }
/*     */   
/*     */   @Column(name="INVALIDTIME", nullable=false)
/*     */   public Date getInvalidtime() {
/* 102 */     return this.invalidtime;
/*     */   }
/*     */   
/*     */   public void setInvalidtime(Date invalidtime) {
/* 106 */     this.invalidtime = invalidtime;
/*     */   }
/*     */   
/*     */   @Column(name="CONTENT", nullable=false)
/*     */   public String getContent() {
/* 111 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(String content) {
/* 115 */     this.content = content;
/*     */   }
/*     */   
/*     */   @ManyToMany
/*     */   @JoinTable(name="t_oa_announce_depart", joinColumns={@javax.persistence.JoinColumn(name="announce_id", referencedColumnName="id")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="depart_id", referencedColumnName="id")})
/*     */   public List<TSDepart> getDeparts() {
/* 121 */     return this.departs;
/*     */   }
/*     */   
/*     */   public void setDeparts(List<TSDepart> departs) {
/* 125 */     this.departs = departs;
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
/*     */   @ManyToMany
/*     */   @JoinTable(name="t_oa_announce_user", joinColumns={@javax.persistence.JoinColumn(name="announce_id", referencedColumnName="id")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="user_id", referencedColumnName="id")})
/*     */   public List<TSUser> getUsers()
/*     */   {
/* 140 */     return this.users;
/*     */   }
/*     */   
/*     */   public void setUsers(List<TSUser> users) {
/* 144 */     this.users = users;
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
/*     */   public Date getExecuteTime()
/*     */   {
/* 158 */     return this.executeTime;
/*     */   }
/*     */   
/*     */   @Column(name="EXECUTETIME", nullable=false)
/*     */   public void setExecuteTime(Date executeTime) {
/* 163 */     this.executeTime = executeTime;
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
/* 177 */     return this.masterDepartName;
/*     */   }
/*     */   
/*     */   public void setMasterDepartName(String masterDepartName) {
/* 181 */     this.masterDepartName = masterDepartName;
/*     */   }
/*     */   
/*     */   @Column(name="departsName", nullable=true)
/*     */   public String getDepartsNameStr() {
/* 186 */     return this.departsNameStr;
/*     */   }
/*     */   
/*     */   public void setDepartsNameStr(String departsName) {
/* 190 */     this.departsNameStr = departsName;
/*     */   }
/*     */   
/*     */   @Column(name="usersName", nullable=true)
/*     */   public String getUsersNameStr() {
/* 195 */     return this.usersNameStr;
/*     */   }
/*     */   
/*     */   public void setUsersNameStr(String usersNameStr) {
/* 199 */     this.usersNameStr = usersNameStr;
/*     */   }
/*     */   
/*     */   @Column(name="type", nullable=false)
/*     */   public String getType() {
/* 204 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 208 */     this.type = type;
/*     */   }
/*     */   
/*     */   public boolean isShowEndTime() {
/* 212 */     return this.showEndTime;
/*     */   }
/*     */   
/*     */   public void setShowEndTime(boolean showEndTime) {
/* 216 */     this.showEndTime = showEndTime;
/*     */   }
/*     */   
/*     */   public String getPlainContent() {
/* 220 */     return this.plainContent;
/*     */   }
/*     */   
/*     */   public void setPlainContent(String plainContent) {
/* 224 */     this.plainContent = HtmlUtils.getPureTextFromHtml(this.content);
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\announcement\AnnouncementEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */