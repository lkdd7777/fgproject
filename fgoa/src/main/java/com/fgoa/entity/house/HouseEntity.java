/*     */ package com.fgoa.entity.house;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
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
/*     */ @Table(name="t_oa_house", schema="")
/*     */ public class HouseEntity
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private String housename;
/*     */   private String location;
/*     */   private Date contactdate;
/*     */   private Date regdate;
/*     */   private String status;
/*     */   private Date prerentdate;
/*     */   private Integer rentlength;
/*     */   private Date rentlimitdate;
/*     */   private Integer price;
/*     */   private String paytype;
/*     */   private String telnum;
/*     */   private String jzarea;
/*     */   private String tdarea;
/*     */   private String htprice;
/*     */   private Date gaindate;
/*     */   private Date permitdate;
/*     */   private String purpose;
/*     */   private String ownsip;
/*     */   private String useage;
/*     */   private String propertyCharge;
/*     */   private String waterCharge;
/*     */   private String electricityCharge;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.AUTO)
/*     */   @Column(name="ID", nullable=false, length=20)
/*     */   public Integer getId()
/*     */   {
/*  77 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  85 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="HOUSENAME", nullable=false, length=100)
/*     */   public String getHousename()
/*     */   {
/*  93 */     return this.housename;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHousename(String housename)
/*     */   {
/* 101 */     this.housename = housename;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="LOCATION", nullable=false, length=100)
/*     */   public String getLocation()
/*     */   {
/* 109 */     return this.location;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLocation(String location)
/*     */   {
/* 117 */     this.location = location;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CONTACTDATE", nullable=true)
/*     */   public Date getContactdate()
/*     */   {
/* 125 */     return this.contactdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setContactdate(Date contactdate)
/*     */   {
/* 133 */     this.contactdate = contactdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="REGDATE", nullable=false, length=100)
/*     */   public Date getRegdate()
/*     */   {
/* 141 */     return this.regdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegdate(Date regdate)
/*     */   {
/* 149 */     this.regdate = regdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="STATUS", nullable=false, length=100)
/*     */   public String getStatus()
/*     */   {
/* 157 */     return this.status;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 165 */     this.status = status;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PRERENTDATE", nullable=true)
/*     */   public Date getPrerentdate()
/*     */   {
/* 173 */     return this.prerentdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPrerentdate(Date prerentdate)
/*     */   {
/* 181 */     this.prerentdate = prerentdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RENTLENGTH", nullable=true, length=4)
/*     */   public Integer getRentlength()
/*     */   {
/* 189 */     return this.rentlength;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRentlength(Integer rentlength)
/*     */   {
/* 197 */     this.rentlength = rentlength;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RENTLIMITDATE", nullable=true)
/*     */   public Date getRentlimitdate()
/*     */   {
/* 205 */     return this.rentlimitdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRentlimitdate(Date rentlimitdate)
/*     */   {
/* 213 */     this.rentlimitdate = rentlimitdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PRICE", nullable=true, length=10)
/*     */   public Integer getPrice()
/*     */   {
/* 221 */     return this.price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPrice(Integer price)
/*     */   {
/* 229 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PAYTYPE", nullable=true, length=100)
/*     */   public String getPaytype()
/*     */   {
/* 237 */     return this.paytype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPaytype(String paytype)
/*     */   {
/* 245 */     this.paytype = paytype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TELNUM", nullable=false)
/*     */   public String getTelnum()
/*     */   {
/* 253 */     return this.telnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTelnum(String telnum)
/*     */   {
/* 261 */     this.telnum = telnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JZAREA", nullable=true, length=100)
/*     */   public String getJzarea()
/*     */   {
/* 269 */     return this.jzarea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJzarea(String jzarea)
/*     */   {
/* 277 */     this.jzarea = jzarea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TDAREA", nullable=true, length=100)
/*     */   public String getTdarea()
/*     */   {
/* 285 */     return this.tdarea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTdarea(String tdarea)
/*     */   {
/* 293 */     this.tdarea = tdarea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="HTPRICE", nullable=true, length=100)
/*     */   public String getHtprice()
/*     */   {
/* 301 */     return this.htprice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHtprice(String htprice)
/*     */   {
/* 309 */     this.htprice = htprice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GAINDATE", nullable=true)
/*     */   public Date getGaindate()
/*     */   {
/* 317 */     return this.gaindate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGaindate(Date gaindate)
/*     */   {
/* 325 */     this.gaindate = gaindate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PERMITDATE", nullable=true)
/*     */   public Date getPermitdate()
/*     */   {
/* 333 */     return this.permitdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPermitdate(Date permitdate)
/*     */   {
/* 341 */     this.permitdate = permitdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="PURPOSE", nullable=true, length=1000)
/*     */   public String getPurpose()
/*     */   {
/* 349 */     return this.purpose;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPurpose(String purpose)
/*     */   {
/* 357 */     this.purpose = purpose;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="OWNSIP", nullable=true, length=1000)
/*     */   public String getOwnsip()
/*     */   {
/* 365 */     return this.ownsip;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOwnsip(String ownsip)
/*     */   {
/* 373 */     this.ownsip = ownsip;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="USEAGE", nullable=true, length=1000)
/*     */   public String getUseage()
/*     */   {
/* 381 */     return this.useage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUseage(String useage)
/*     */   {
/* 389 */     this.useage = useage;
/*     */   }
/*     */   
/*     */   public String getPropertyCharge() {
/* 393 */     return this.propertyCharge;
/*     */   }
/*     */   
/*     */   public void setPropertyCharge(String propertyCharge) {
/* 397 */     this.propertyCharge = propertyCharge;
/*     */   }
/*     */   
/*     */   public String getWaterCharge() {
/* 401 */     return this.waterCharge;
/*     */   }
/*     */   
/*     */   public void setWaterCharge(String waterCharge) {
/* 405 */     this.waterCharge = waterCharge;
/*     */   }
/*     */   
/*     */   public String getElectricityCharge() {
/* 409 */     return this.electricityCharge;
/*     */   }
/*     */   
/*     */   public void setElectricityCharge(String electricityCharge) {
/* 413 */     this.electricityCharge = electricityCharge;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\entity\house\HouseEntity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */