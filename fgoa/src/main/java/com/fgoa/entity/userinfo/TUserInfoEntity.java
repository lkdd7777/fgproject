/*     */ package com.fgoa.entity.userinfo;
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
/*     */ @Table(name="t_user_info", schema="")
/*     */ public class TUserInfoEntity
/*     */   implements Serializable
/*     */ {
/*     */   private String id;
/*     */   private Integer bh;
/*     */   private String xm;
/*     */   private Integer xb;
/*     */   private String mz;
/*     */   private String sfz;
/*     */   private Integer hyzt;
/*     */   private String csrq;
/*     */   private String bgdh;
/*     */   private Integer xl;
/*     */   private String jjlxdh;
/*     */   private String qq;
/*     */   private String jg;
/*     */   private String jtzz;
/*     */   private String hkszd;
/*     */   private Integer zzmm;
/*     */   private String rdtsj;
/*     */   private String dnzw;
/*     */   private String tnzw;
/*     */   private String dzb;
/*     */   private String rdjd;
/*     */   private String dfjs;
/*     */   private String twzw;
/*     */   private String grxxbz;
/*     */   private Integer ygxs;
/*     */   private Integer zzzt;
/*     */   private Integer gw;
/*     */   private Integer bm;
/*     */   private String zzjszc;
/*     */   private Integer gwdj;
/*     */   private String zw;
/*     */   private String cjgzsj;
/*     */   private String sbzh;
/*     */   private Integer zwjb;
/*     */   private String xzwgznx;
/*     */   private Integer zc;
/*     */   private String xzwgzsj;
/*     */   private String bjbgznx;
/*     */   private String jckh;
/*     */   private String bmtzjl;
/*     */   private String gjjzh;
/*     */   private String dwxxbz;
/*     */   private String rbdwsj;
/*     */   private String gl;
/*     */   private String rbjbsj;
/*     */   private String rdwqd;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(generator="paymentableGenerator")
/*     */   @GenericGenerator(name="paymentableGenerator", strategy="uuid")
/*     */   @Column(name="ID", nullable=false, length=36)
/*     */   public String getId()
/*     */   {
/* 134 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/* 142 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BH", nullable=false, length=10)
/*     */   public Integer getBh()
/*     */   {
/* 150 */     return this.bh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBh(Integer bh)
/*     */   {
/* 158 */     this.bh = bh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XM", nullable=false, length=20)
/*     */   public String getXm()
/*     */   {
/* 166 */     return this.xm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXm(String xm)
/*     */   {
/* 174 */     this.xm = xm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XB", nullable=true, length=10)
/*     */   public Integer getXb()
/*     */   {
/* 182 */     return this.xb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXb(Integer xb)
/*     */   {
/* 190 */     this.xb = xb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="MZ", nullable=true, length=50)
/*     */   public String getMz()
/*     */   {
/* 198 */     return this.mz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMz(String mz)
/*     */   {
/* 206 */     this.mz = mz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SFZ", nullable=true, length=20)
/*     */   public String getSfz()
/*     */   {
/* 214 */     return this.sfz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSfz(String sfz)
/*     */   {
/* 222 */     this.sfz = sfz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="HYZT", nullable=true, length=10)
/*     */   public Integer getHyzt()
/*     */   {
/* 230 */     return this.hyzt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHyzt(Integer hyzt)
/*     */   {
/* 238 */     this.hyzt = hyzt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CSRQ", nullable=true, length=50)
/*     */   public String getCsrq()
/*     */   {
/* 246 */     return this.csrq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCsrq(String csrq)
/*     */   {
/* 254 */     this.csrq = csrq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BGDH", nullable=true, length=50)
/*     */   public String getBgdh()
/*     */   {
/* 262 */     return this.bgdh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBgdh(String bgdh)
/*     */   {
/* 270 */     this.bgdh = bgdh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XL", nullable=true, length=10)
/*     */   public Integer getXl()
/*     */   {
/* 278 */     return this.xl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXl(Integer xl)
/*     */   {
/* 286 */     this.xl = xl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JJLXDH", nullable=true, length=20)
/*     */   public String getJjlxdh()
/*     */   {
/* 294 */     return this.jjlxdh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJjlxdh(String jjlxdh)
/*     */   {
/* 302 */     this.jjlxdh = jjlxdh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="QQ", nullable=true, length=20)
/*     */   public String getQq()
/*     */   {
/* 310 */     return this.qq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setQq(String qq)
/*     */   {
/* 318 */     this.qq = qq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JG", nullable=true, length=20)
/*     */   public String getJg()
/*     */   {
/* 326 */     return this.jg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJg(String jg)
/*     */   {
/* 334 */     this.jg = jg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JTZZ", nullable=true, length=200)
/*     */   public String getJtzz()
/*     */   {
/* 342 */     return this.jtzz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJtzz(String jtzz)
/*     */   {
/* 350 */     this.jtzz = jtzz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="HKSZD", nullable=true, length=200)
/*     */   public String getHkszd()
/*     */   {
/* 358 */     return this.hkszd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHkszd(String hkszd)
/*     */   {
/* 366 */     this.hkszd = hkszd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ZZMM", nullable=true, length=10)
/*     */   public Integer getZzmm()
/*     */   {
/* 374 */     return this.zzmm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZzmm(Integer zzmm)
/*     */   {
/* 382 */     this.zzmm = zzmm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RDTSJ", nullable=true, length=50)
/*     */   public String getRdtsj()
/*     */   {
/* 390 */     return this.rdtsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRdtsj(String rdtsj)
/*     */   {
/* 398 */     this.rdtsj = rdtsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DNZW", nullable=true, length=50)
/*     */   public String getDnzw()
/*     */   {
/* 406 */     return this.dnzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDnzw(String dnzw)
/*     */   {
/* 414 */     this.dnzw = dnzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TNZW", nullable=true, length=50)
/*     */   public String getTnzw()
/*     */   {
/* 422 */     return this.tnzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnzw(String tnzw)
/*     */   {
/* 430 */     this.tnzw = tnzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DZB", nullable=true, length=50)
/*     */   public String getDzb()
/*     */   {
/* 438 */     return this.dzb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDzb(String dzb)
/*     */   {
/* 446 */     this.dzb = dzb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RDJD", nullable=true, length=50)
/*     */   public String getRdjd()
/*     */   {
/* 454 */     return this.rdjd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRdjd(String rdjd)
/*     */   {
/* 462 */     this.rdjd = rdjd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DFJS", nullable=true, length=50)
/*     */   public String getDfjs()
/*     */   {
/* 470 */     return this.dfjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDfjs(String dfjs)
/*     */   {
/* 478 */     this.dfjs = dfjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="TWZW", nullable=true, length=50)
/*     */   public String getTwzw()
/*     */   {
/* 486 */     return this.twzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTwzw(String twzw)
/*     */   {
/* 494 */     this.twzw = twzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GRXXBZ", nullable=true, length=500)
/*     */   public String getGrxxbz()
/*     */   {
/* 502 */     return this.grxxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGrxxbz(String grxxbz)
/*     */   {
/* 510 */     this.grxxbz = grxxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="YGXS", nullable=true, length=10)
/*     */   public Integer getYgxs()
/*     */   {
/* 518 */     return this.ygxs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYgxs(Integer ygxs)
/*     */   {
/* 526 */     this.ygxs = ygxs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ZZZT", nullable=true, length=10)
/*     */   public Integer getZzzt()
/*     */   {
/* 534 */     return this.zzzt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZzzt(Integer zzzt)
/*     */   {
/* 542 */     this.zzzt = zzzt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GW", nullable=true, length=10)
/*     */   public Integer getGw()
/*     */   {
/* 550 */     return this.gw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGw(Integer gw)
/*     */   {
/* 558 */     this.gw = gw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BM", nullable=true, length=10)
/*     */   public Integer getBm()
/*     */   {
/* 566 */     return this.bm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBm(Integer bm)
/*     */   {
/* 574 */     this.bm = bm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ZZJSZC", nullable=true, length=50)
/*     */   public String getZzjszc()
/*     */   {
/* 582 */     return this.zzjszc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZzjszc(String zzjszc)
/*     */   {
/* 590 */     this.zzjszc = zzjszc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GWDJ", nullable=true, length=10)
/*     */   public Integer getGwdj()
/*     */   {
/* 598 */     return this.gwdj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGwdj(Integer gwdj)
/*     */   {
/* 606 */     this.gwdj = gwdj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ZW", nullable=true, length=50)
/*     */   public String getZw()
/*     */   {
/* 614 */     return this.zw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZw(String zw)
/*     */   {
/* 622 */     this.zw = zw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="CJGZSJ", nullable=true, length=50)
/*     */   public String getCjgzsj()
/*     */   {
/* 630 */     return this.cjgzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCjgzsj(String cjgzsj)
/*     */   {
/* 638 */     this.cjgzsj = cjgzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="SBZH", nullable=true, length=50)
/*     */   public String getSbzh()
/*     */   {
/* 646 */     return this.sbzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSbzh(String sbzh)
/*     */   {
/* 654 */     this.sbzh = sbzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ZWJB", nullable=true, length=10)
/*     */   public Integer getZwjb()
/*     */   {
/* 662 */     return this.zwjb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZwjb(Integer zwjb)
/*     */   {
/* 670 */     this.zwjb = zwjb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XZWGZNX", nullable=true, length=50)
/*     */   public String getXzwgznx()
/*     */   {
/* 678 */     return this.xzwgznx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXzwgznx(String xzwgznx)
/*     */   {
/* 686 */     this.xzwgznx = xzwgznx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="ZC", nullable=true, length=10)
/*     */   public Integer getZc()
/*     */   {
/* 694 */     return this.zc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZc(Integer zc)
/*     */   {
/* 702 */     this.zc = zc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="XZWGZSJ", nullable=true, length=50)
/*     */   public String getXzwgzsj()
/*     */   {
/* 710 */     return this.xzwgzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXzwgzsj(String xzwgzsj)
/*     */   {
/* 718 */     this.xzwgzsj = xzwgzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BJBGZNX", nullable=true, length=50)
/*     */   public String getBjbgznx()
/*     */   {
/* 726 */     return this.bjbgznx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBjbgznx(String bjbgznx)
/*     */   {
/* 734 */     this.bjbgznx = bjbgznx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="JCKH", nullable=true, length=50)
/*     */   public String getJckh()
/*     */   {
/* 742 */     return this.jckh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJckh(String jckh)
/*     */   {
/* 750 */     this.jckh = jckh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="BMTZJL", nullable=true, length=500)
/*     */   public String getBmtzjl()
/*     */   {
/* 758 */     return this.bmtzjl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBmtzjl(String bmtzjl)
/*     */   {
/* 766 */     this.bmtzjl = bmtzjl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GJJZH", nullable=true, length=50)
/*     */   public String getGjjzh()
/*     */   {
/* 774 */     return this.gjjzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGjjzh(String gjjzh)
/*     */   {
/* 782 */     this.gjjzh = gjjzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="DWXXBZ", nullable=true, length=500)
/*     */   public String getDwxxbz()
/*     */   {
/* 790 */     return this.dwxxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDwxxbz(String dwxxbz)
/*     */   {
/* 798 */     this.dwxxbz = dwxxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RBDWSJ", nullable=true, length=50)
/*     */   public String getRbdwsj()
/*     */   {
/* 806 */     return this.rbdwsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRbdwsj(String rbdwsj)
/*     */   {
/* 814 */     this.rbdwsj = rbdwsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="GL", nullable=true, length=50)
/*     */   public String getGl()
/*     */   {
/* 822 */     return this.gl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGl(String gl)
/*     */   {
/* 830 */     this.gl = gl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RBJBSJ", nullable=true, length=50)
/*     */   public String getRbjbsj()
/*     */   {
/* 838 */     return this.rbjbsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRbjbsj(String rbjbsj)
/*     */   {
/* 846 */     this.rbjbsj = rbjbsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Column(name="RDWQD", nullable=true, length=100)
/*     */   public String getRdwqd()
/*     */   {
/* 854 */     return this.rdwqd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRdwqd(String rdwqd)
/*     */   {
/* 862 */     this.rdwqd = rdwqd;
/*     */   }
/*     */ }


