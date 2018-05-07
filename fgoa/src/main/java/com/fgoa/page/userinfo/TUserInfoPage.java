/*     */ package com.fgoa.page.userinfo;
/*     */ 
/*     */ import com.fgoa.entity.userinfo.TUserGzglEntity;
/*     */ import com.fgoa.entity.userinfo.TUserGzjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserHtglEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJcjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJtcyEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJyjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserPxjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserTxjsEntity;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class TUserInfoPage
/*     */   implements Serializable
/*     */ {
/*  36 */   private List<TUserJtcyEntity> tUserJtcyList = new ArrayList();
/*     */   
/*  38 */   public List<TUserJtcyEntity> getTUserJtcyList() { return this.tUserJtcyList; }
/*     */   
/*     */   public void setTUserJtcyList(List<TUserJtcyEntity> tUserJtcyList) {
/*  41 */     this.tUserJtcyList = tUserJtcyList;
/*     */   }
/*     */   
/*  44 */   private List<TUserJyjlEntity> tUserJyjlList = new ArrayList();
/*     */   
/*  46 */   public List<TUserJyjlEntity> getTUserJyjlList() { return this.tUserJyjlList; }
/*     */   
/*     */   public void setTUserJyjlList(List<TUserJyjlEntity> tUserJyjlList) {
/*  49 */     this.tUserJyjlList = tUserJyjlList;
/*     */   }
/*     */   
/*  52 */   private List<TUserGzjlEntity> tUserGzjlList = new ArrayList();
/*     */   
/*  54 */   public List<TUserGzjlEntity> getTUserGzjlList() { return this.tUserGzjlList; }
/*     */   
/*     */   public void setTUserGzjlList(List<TUserGzjlEntity> tUserGzjlList) {
/*  57 */     this.tUserGzjlList = tUserGzjlList;
/*     */   }
/*     */   
/*  60 */   private List<TUserHtglEntity> tUserHtglList = new ArrayList();
/*     */   
/*  62 */   public List<TUserHtglEntity> getTUserHtglList() { return this.tUserHtglList; }
/*     */   
/*     */   public void setTUserHtglList(List<TUserHtglEntity> tUserHtglList) {
/*  65 */     this.tUserHtglList = tUserHtglList;
/*     */   }
/*     */   
/*  68 */   private List<TUserJcjlEntity> tUserJcjlList = new ArrayList();
/*     */   
/*  70 */   public List<TUserJcjlEntity> getTUserJcjlList() { return this.tUserJcjlList; }
/*     */   
/*     */   public void setTUserJcjlList(List<TUserJcjlEntity> tUserJcjlList) {
/*  73 */     this.tUserJcjlList = tUserJcjlList;
/*     */   }
/*     */   
/*  76 */   private List<TUserPxjlEntity> tUserPxjlList = new ArrayList();
/*     */   
/*  78 */   public List<TUserPxjlEntity> getTUserPxjlList() { return this.tUserPxjlList; }
/*     */   
/*     */   public void setTUserPxjlList(List<TUserPxjlEntity> tUserPxjlList) {
/*  81 */     this.tUserPxjlList = tUserPxjlList;
/*     */   }
/*     */   
/*  84 */   private List<TUserGzglEntity> tUserGzglList = new ArrayList();
/*     */   
/*  86 */   public List<TUserGzglEntity> getTUserGzglList() { return this.tUserGzglList; }
/*     */   
/*     */   public void setTUserGzglList(List<TUserGzglEntity> tUserGzglList) {
/*  89 */     this.tUserGzglList = tUserGzglList;
/*     */   }
/*     */   
/*  92 */   private List<TUserTxjsEntity> tUserTxjsList = new ArrayList();
/*     */   
/*  94 */   public List<TUserTxjsEntity> getTUserTxjsList() { return this.tUserTxjsList; }
/*     */   
/*     */   public void setTUserTxjsList(List<TUserTxjsEntity> tUserTxjsList) {
/*  97 */     this.tUserTxjsList = tUserTxjsList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private String id;
/*     */   
/*     */ 
/*     */   private Integer bh;
/*     */   
/*     */ 
/*     */   private String xm;
/*     */   
/*     */   private Integer xb;
/*     */   
/*     */   private String mz;
/*     */   
/*     */   private String sfz;
/*     */   
/*     */   private Integer hyzt;
/*     */   
/*     */   private String csrq;
/*     */   
/*     */   private String bgdh;
/*     */   
/*     */   private Integer xl;
/*     */   
/*     */   private String jjlxdh;
/*     */   
/*     */   private String qq;
/*     */   
/*     */   private String jg;
/*     */   
/*     */   private String jtzz;
/*     */   
/*     */   private String hkszd;
/*     */   
/*     */   private Integer zzmm;
/*     */   
/*     */   private String rdtsj;
/*     */   
/*     */   private String dnzw;
/*     */   
/*     */   private String tnzw;
/*     */   
/*     */   private String dzb;
/*     */   
/*     */   private String rdjd;
/*     */   
/*     */   private String dfjs;
/*     */   
/*     */   private String twzw;
/*     */   
/*     */   private String grxxbz;
/*     */   
/*     */   private Integer ygxs;
/*     */   
/*     */   private Integer zzzt;
/*     */   
/*     */   private Integer gw;
/*     */   
/*     */   private Integer bm;
/*     */   
/*     */   private String zzjszc;
/*     */   
/*     */   private Integer gwdj;
/*     */   
/*     */   private String zw;
/*     */   
/*     */   private String cjgzsj;
/*     */   
/*     */   private String sbzh;
/*     */   
/*     */   private Integer zwjb;
/*     */   
/*     */   private String xzwgznx;
/*     */   
/*     */   private Integer zc;
/*     */   
/*     */   private String xzwgzsj;
/*     */   
/*     */   private String bjbgznx;
/*     */   
/*     */   private String jckh;
/*     */   
/*     */   private String bmtzjl;
/*     */   
/*     */   private String gjjzh;
/*     */   
/*     */   private String dwxxbz;
/*     */   
/*     */   private String rbdwsj;
/*     */   
/*     */   private String gl;
/*     */   
/*     */   private String rbjbsj;
/*     */   
/*     */   private String rdwqd;
/*     */   
/*     */   public String getId()
/*     */   {
/* 198 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/* 206 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getBh()
/*     */   {
/* 213 */     return this.bh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBh(Integer bh)
/*     */   {
/* 221 */     this.bh = bh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getXm()
/*     */   {
/* 228 */     return this.xm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXm(String xm)
/*     */   {
/* 236 */     this.xm = xm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getXb()
/*     */   {
/* 243 */     return this.xb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXb(Integer xb)
/*     */   {
/* 251 */     this.xb = xb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMz()
/*     */   {
/* 258 */     return this.mz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMz(String mz)
/*     */   {
/* 266 */     this.mz = mz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSfz()
/*     */   {
/* 273 */     return this.sfz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSfz(String sfz)
/*     */   {
/* 281 */     this.sfz = sfz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getHyzt()
/*     */   {
/* 288 */     return this.hyzt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHyzt(Integer hyzt)
/*     */   {
/* 296 */     this.hyzt = hyzt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCsrq()
/*     */   {
/* 303 */     return this.csrq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCsrq(String csrq)
/*     */   {
/* 311 */     this.csrq = csrq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBgdh()
/*     */   {
/* 318 */     return this.bgdh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBgdh(String bgdh)
/*     */   {
/* 326 */     this.bgdh = bgdh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getXl()
/*     */   {
/* 333 */     return this.xl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXl(Integer xl)
/*     */   {
/* 341 */     this.xl = xl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getJjlxdh()
/*     */   {
/* 348 */     return this.jjlxdh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJjlxdh(String jjlxdh)
/*     */   {
/* 356 */     this.jjlxdh = jjlxdh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getQq()
/*     */   {
/* 363 */     return this.qq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setQq(String qq)
/*     */   {
/* 371 */     this.qq = qq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getJg()
/*     */   {
/* 378 */     return this.jg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJg(String jg)
/*     */   {
/* 386 */     this.jg = jg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getJtzz()
/*     */   {
/* 393 */     return this.jtzz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJtzz(String jtzz)
/*     */   {
/* 401 */     this.jtzz = jtzz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getHkszd()
/*     */   {
/* 408 */     return this.hkszd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHkszd(String hkszd)
/*     */   {
/* 416 */     this.hkszd = hkszd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getZzmm()
/*     */   {
/* 423 */     return this.zzmm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZzmm(Integer zzmm)
/*     */   {
/* 431 */     this.zzmm = zzmm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRdtsj()
/*     */   {
/* 438 */     return this.rdtsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRdtsj(String rdtsj)
/*     */   {
/* 446 */     this.rdtsj = rdtsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDnzw()
/*     */   {
/* 453 */     return this.dnzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDnzw(String dnzw)
/*     */   {
/* 461 */     this.dnzw = dnzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTnzw()
/*     */   {
/* 468 */     return this.tnzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTnzw(String tnzw)
/*     */   {
/* 476 */     this.tnzw = tnzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDzb()
/*     */   {
/* 483 */     return this.dzb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDzb(String dzb)
/*     */   {
/* 491 */     this.dzb = dzb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRdjd()
/*     */   {
/* 498 */     return this.rdjd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRdjd(String rdjd)
/*     */   {
/* 506 */     this.rdjd = rdjd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDfjs()
/*     */   {
/* 513 */     return this.dfjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDfjs(String dfjs)
/*     */   {
/* 521 */     this.dfjs = dfjs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTwzw()
/*     */   {
/* 528 */     return this.twzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTwzw(String twzw)
/*     */   {
/* 536 */     this.twzw = twzw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getGrxxbz()
/*     */   {
/* 543 */     return this.grxxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGrxxbz(String grxxbz)
/*     */   {
/* 551 */     this.grxxbz = grxxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getYgxs()
/*     */   {
/* 558 */     return this.ygxs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYgxs(Integer ygxs)
/*     */   {
/* 566 */     this.ygxs = ygxs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getZzzt()
/*     */   {
/* 573 */     return this.zzzt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZzzt(Integer zzzt)
/*     */   {
/* 581 */     this.zzzt = zzzt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getGw()
/*     */   {
/* 588 */     return this.gw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGw(Integer gw)
/*     */   {
/* 596 */     this.gw = gw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getBm()
/*     */   {
/* 603 */     return this.bm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBm(Integer bm)
/*     */   {
/* 611 */     this.bm = bm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getZzjszc()
/*     */   {
/* 618 */     return this.zzjszc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZzjszc(String zzjszc)
/*     */   {
/* 626 */     this.zzjszc = zzjszc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getGwdj()
/*     */   {
/* 633 */     return this.gwdj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGwdj(Integer gwdj)
/*     */   {
/* 641 */     this.gwdj = gwdj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getZw()
/*     */   {
/* 648 */     return this.zw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZw(String zw)
/*     */   {
/* 656 */     this.zw = zw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCjgzsj()
/*     */   {
/* 663 */     return this.cjgzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCjgzsj(String cjgzsj)
/*     */   {
/* 671 */     this.cjgzsj = cjgzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSbzh()
/*     */   {
/* 678 */     return this.sbzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSbzh(String sbzh)
/*     */   {
/* 686 */     this.sbzh = sbzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getZwjb()
/*     */   {
/* 693 */     return this.zwjb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZwjb(Integer zwjb)
/*     */   {
/* 701 */     this.zwjb = zwjb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getXzwgznx()
/*     */   {
/* 708 */     return this.xzwgznx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXzwgznx(String xzwgznx)
/*     */   {
/* 716 */     this.xzwgznx = xzwgznx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getZc()
/*     */   {
/* 723 */     return this.zc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setZc(Integer zc)
/*     */   {
/* 731 */     this.zc = zc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getXzwgzsj()
/*     */   {
/* 738 */     return this.xzwgzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXzwgzsj(String xzwgzsj)
/*     */   {
/* 746 */     this.xzwgzsj = xzwgzsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBjbgznx()
/*     */   {
/* 753 */     return this.bjbgznx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBjbgznx(String bjbgznx)
/*     */   {
/* 761 */     this.bjbgznx = bjbgznx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getJckh()
/*     */   {
/* 768 */     return this.jckh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJckh(String jckh)
/*     */   {
/* 776 */     this.jckh = jckh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBmtzjl()
/*     */   {
/* 783 */     return this.bmtzjl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBmtzjl(String bmtzjl)
/*     */   {
/* 791 */     this.bmtzjl = bmtzjl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getGjjzh()
/*     */   {
/* 798 */     return this.gjjzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGjjzh(String gjjzh)
/*     */   {
/* 806 */     this.gjjzh = gjjzh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDwxxbz()
/*     */   {
/* 813 */     return this.dwxxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDwxxbz(String dwxxbz)
/*     */   {
/* 821 */     this.dwxxbz = dwxxbz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRbdwsj()
/*     */   {
/* 828 */     return this.rbdwsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRbdwsj(String rbdwsj)
/*     */   {
/* 836 */     this.rbdwsj = rbdwsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getGl()
/*     */   {
/* 843 */     return this.gl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGl(String gl)
/*     */   {
/* 851 */     this.gl = gl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRbjbsj()
/*     */   {
/* 858 */     return this.rbjbsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRbjbsj(String rbjbsj)
/*     */   {
/* 866 */     this.rbjbsj = rbjbsj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRdwqd()
/*     */   {
/* 873 */     return this.rdwqd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRdwqd(String rdwqd)
/*     */   {
/* 881 */     this.rdwqd = rdwqd;
/*     */   }
/*     */ }


