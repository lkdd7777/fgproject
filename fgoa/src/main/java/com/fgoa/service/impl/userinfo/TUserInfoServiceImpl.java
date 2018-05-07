/*     */ package com.fgoa.service.impl.userinfo;
/*     */ 
/*     */ import com.fgoa.entity.userinfo.TUserGzglEntity;
/*     */ import com.fgoa.entity.userinfo.TUserGzjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserHtglEntity;
/*     */ import com.fgoa.entity.userinfo.TUserInfoEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJcjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJtcyEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJyjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserPxjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserTxjsEntity;
/*     */ import com.fgoa.service.userinfo.TUserInfoServiceI;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import org.jeecgframework.core.common.exception.BusinessException;
/*     */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*     */ import org.jeecgframework.core.util.MyBeanUtils;
/*     */ import org.jeecgframework.core.util.oConvertUtils;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Service("tUserInfoService")
/*     */ @Transactional
/*     */ public class TUserInfoServiceImpl
/*     */   extends CommonServiceImpl implements TUserInfoServiceI
/*     */ {
/*     */   public <T> void delete(T entity)
/*     */   {
/*  30 */     super.delete(entity);
/*     */     
/*  32 */     doDelSql((TUserInfoEntity)entity);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addMain(TUserInfoEntity tUserInfo, List<TUserJtcyEntity> tUserJtcyList, List<TUserJyjlEntity> tUserJyjlList, List<TUserGzjlEntity> tUserGzjlList, List<TUserHtglEntity> tUserHtglList, List<TUserJcjlEntity> tUserJcjlList, List<TUserPxjlEntity> tUserPxjlList, List<TUserGzglEntity> tUserGzglList, List<TUserTxjsEntity> tUserTxjsList)
/*     */   {
/*  38 */     save(tUserInfo);
/*     */     
/*     */ 
/*  41 */     for (TUserJtcyEntity tUserJtcy : tUserJtcyList)
/*     */     {
/*  43 */       tUserJtcy.setUid(tUserInfo.getId());
/*  44 */       save(tUserJtcy);
/*     */     }
/*     */     
/*  47 */     for (TUserJyjlEntity tUserJyjl : tUserJyjlList)
/*     */     {
/*  49 */       tUserJyjl.setUid(tUserInfo.getId());
/*  50 */       save(tUserJyjl);
/*     */     }
/*     */     
/*  53 */     for (TUserGzjlEntity tUserGzjl : tUserGzjlList)
/*     */     {
/*  55 */       tUserGzjl.setUid(tUserInfo.getId());
/*  56 */       save(tUserGzjl);
/*     */     }
/*     */     
/*  59 */     for (TUserHtglEntity tUserHtgl : tUserHtglList)
/*     */     {
/*  61 */       tUserHtgl.setUid(tUserInfo.getId());
/*  62 */       save(tUserHtgl);
/*     */     }
/*     */     
/*  65 */     for (TUserJcjlEntity tUserJcjl : tUserJcjlList)
/*     */     {
/*  67 */       tUserJcjl.setUid(tUserInfo.getId());
/*  68 */       save(tUserJcjl);
/*     */     }
/*     */     
/*  71 */     for (TUserPxjlEntity tUserPxjl : tUserPxjlList)
/*     */     {
/*  73 */       tUserPxjl.setUid(tUserInfo.getId());
/*  74 */       save(tUserPxjl);
/*     */     }
/*     */     
/*  77 */     for (TUserGzglEntity tUserGzgl : tUserGzglList)
/*     */     {
/*  79 */       tUserGzgl.setUid(tUserInfo.getId());
/*  80 */       save(tUserGzgl);
/*     */     }
/*     */     
/*  83 */     for (TUserTxjsEntity tUserTxjs : tUserTxjsList)
/*     */     {
/*  85 */       tUserTxjs.setUid(tUserInfo.getId());
/*  86 */       save(tUserTxjs);
/*     */     }
/*     */     
/*  89 */     doAddSql(tUserInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void updateMain(TUserInfoEntity tUserInfo, List<TUserJtcyEntity> tUserJtcyList, List<TUserJyjlEntity> tUserJyjlList, List<TUserGzjlEntity> tUserGzjlList, List<TUserHtglEntity> tUserHtglList, List<TUserJcjlEntity> tUserJcjlList, List<TUserPxjlEntity> tUserPxjlList, List<TUserGzglEntity> tUserGzglList, List<TUserTxjsEntity> tUserTxjsList)
/*     */   {
/*  96 */     saveOrUpdate(tUserInfo);
/*     */     
/*     */ 
/*  99 */     Object id0 = tUserInfo.getId();
/* 100 */     Object id1 = tUserInfo.getId();
/* 101 */     Object id2 = tUserInfo.getId();
/* 102 */     Object id3 = tUserInfo.getId();
/* 103 */     Object id4 = tUserInfo.getId();
/* 104 */     Object id5 = tUserInfo.getId();
/* 105 */     Object id6 = tUserInfo.getId();
/* 106 */     Object id7 = tUserInfo.getId();
/*     */     
/*     */ 
/* 109 */     String hql0 = "from TUserJtcyEntity where 1 = 1 AND uID = ? ";
/* 110 */     List<TUserJtcyEntity> tUserJtcyOldList = findHql(hql0, new Object[] { id0 });
/*     */     TUserJtcyEntity sendE;
/* 112 */     for (TUserJtcyEntity oldE : tUserJtcyOldList) {
/* 113 */       boolean isUpdate = false;
/* 114 */       for (Iterator localIterator2 = tUserJtcyList.iterator(); localIterator2.hasNext();) { sendE = (TUserJtcyEntity)localIterator2.next();
/*     */         
/* 116 */         if (oldE.getId().equals(sendE.getId())) {
/*     */           try {
/* 118 */             MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
/* 119 */             saveOrUpdate(oldE);
/*     */           } catch (Exception e) {
/* 121 */             e.printStackTrace();
/* 122 */             throw new BusinessException(e.getMessage());
/*     */           }
/* 124 */           isUpdate = true;
/* 125 */           break;
/*     */         }
/*     */       }
/* 128 */       if (!isUpdate)
/*     */       {
/* 130 */         super.delete(oldE);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 135 */     for (TUserJtcyEntity tUserJtcy : tUserJtcyList) {
/* 136 */       if (oConvertUtils.isEmpty(tUserJtcy.getId()))
/*     */       {
/* 138 */         tUserJtcy.setUid(tUserInfo.getId());
/* 139 */         save(tUserJtcy);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 144 */     String hql1 = "from TUserJyjlEntity where 1 = 1 AND uID = ? ";
/* 145 */     List tUserJyjlOldList = findHql(hql1, new Object[] { id1 });
/*     */     TUserJyjlEntity sendE;
/* 147 */     for (TUserJyjlEntity oldE : (List)tUserJyjlOldList) {
/* 148 */       boolean isUpdate = false;
/* 149 */       for (Iterator localIterator3 = tUserJyjlList.iterator(); localIterator3.hasNext();) { sendE = (TUserJyjlEntity)localIterator3.next();
/*     */         
/* 151 */         if (oldE.getId().equals(sendE.getId())) {
/*     */           try {
/* 153 */             MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
/* 154 */             saveOrUpdate(oldE);
/*     */           } catch (Exception e) {
/* 156 */             e.printStackTrace();
/* 157 */             throw new BusinessException(e.getMessage());
/*     */           }
/* 159 */           isUpdate = true;
/* 160 */           break;
/*     */         }
/*     */       }
/* 163 */       if (!isUpdate)
/*     */       {
/* 165 */         super.delete(oldE);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 170 */     for (TUserJyjlEntity tUserJyjl : tUserJyjlList) {
/* 171 */       if (oConvertUtils.isEmpty(tUserJyjl.getId()))
/*     */       {
/* 173 */         tUserJyjl.setUid(tUserInfo.getId());
/* 174 */         save(tUserJyjl);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 179 */     String hql2 = "from TUserGzjlEntity where 1 = 1 AND uID = ? ";
/* 180 */     List<TUserGzjlEntity> tUserGzjlOldList = findHql(hql2, new Object[] { id2 });
/*     */     TUserGzjlEntity sendE;
/* 182 */     for (TUserGzjlEntity oldE : tUserGzjlOldList) {
/* 183 */       boolean isUpdate = false;
/* 184 */       for (Iterator localIterator4 = tUserGzjlList.iterator(); localIterator4.hasNext();) { sendE = (TUserGzjlEntity)localIterator4.next();
/*     */         
/* 186 */         if (oldE.getId().equals(sendE.getId())) {
/*     */           try {
/* 188 */             MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
/* 189 */             saveOrUpdate(oldE);
/*     */           } catch (Exception e) {
/* 191 */             e.printStackTrace();
/* 192 */             throw new BusinessException(e.getMessage());
/*     */           }
/* 194 */           isUpdate = true;
/* 195 */           break;
/*     */         }
/*     */       }
/* 198 */       if (!isUpdate)
/*     */       {
/* 200 */         super.delete(oldE);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 205 */     for (TUserGzjlEntity tUserGzjl : tUserGzjlList) {
/* 206 */       if (oConvertUtils.isEmpty(tUserGzjl.getId()))
/*     */       {
/* 208 */         tUserGzjl.setUid(tUserInfo.getId());
/* 209 */         save(tUserGzjl);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 214 */     String hql3 = "from TUserHtglEntity where 1 = 1 AND uID = ? ";
/* 215 */     List<TUserHtglEntity> tUserHtglOldList = findHql(hql3, new Object[] { id3 });
/*     */     TUserHtglEntity sendE;
/* 217 */     for (TUserHtglEntity oldE : tUserHtglOldList) {
/* 218 */       boolean isUpdate = false;
/* 219 */       for (Iterator localIterator5 = tUserHtglList.iterator(); localIterator5.hasNext();) { sendE = (TUserHtglEntity)localIterator5.next();
/*     */         
/* 221 */         if (oldE.getId().equals(sendE.getId())) {
/*     */           try {
/* 223 */             MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
/* 224 */             saveOrUpdate(oldE);
/*     */           } catch (Exception e) {
/* 226 */             e.printStackTrace();
/* 227 */             throw new BusinessException(e.getMessage());
/*     */           }
/* 229 */           isUpdate = true;
/* 230 */           break;
/*     */         }
/*     */       }
/* 233 */       if (!isUpdate)
/*     */       {
/* 235 */         super.delete(oldE);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 240 */     for (TUserHtglEntity tUserHtgl : tUserHtglList) {
/* 241 */       if (oConvertUtils.isEmpty(tUserHtgl.getId()))
/*     */       {
/* 243 */         tUserHtgl.setUid(tUserInfo.getId());
/* 244 */         save(tUserHtgl);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 249 */     String hql4 = "from TUserJcjlEntity where 1 = 1 AND uID = ? ";
/* 250 */     List<TUserJcjlEntity> tUserJcjlOldList = findHql(hql4, new Object[] { id4 });
/*     */     TUserJcjlEntity sendE;
/* 252 */     for (TUserJcjlEntity oldE : tUserJcjlOldList) {
/* 253 */       boolean isUpdate = false;
/* 254 */       for (Iterator localIterator6 = tUserJcjlList.iterator(); localIterator6.hasNext();) { sendE = (TUserJcjlEntity)localIterator6.next();
/*     */         
/* 256 */         if (oldE.getId().equals(sendE.getId())) {
/*     */           try {
/* 258 */             MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
/* 259 */             saveOrUpdate(oldE);
/*     */           } catch (Exception e) {
/* 261 */             e.printStackTrace();
/* 262 */             throw new BusinessException(e.getMessage());
/*     */           }
/* 264 */           isUpdate = true;
/* 265 */           break;
/*     */         }
/*     */       }
/* 268 */       if (!isUpdate)
/*     */       {
/* 270 */         super.delete(oldE);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 275 */     for (TUserJcjlEntity tUserJcjl : tUserJcjlList) {
/* 276 */       if (oConvertUtils.isEmpty(tUserJcjl.getId()))
/*     */       {
/* 278 */         tUserJcjl.setUid(tUserInfo.getId());
/* 279 */         save(tUserJcjl);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 284 */     String hql5 = "from TUserPxjlEntity where 1 = 1 AND uID = ? ";
/* 285 */     List<TUserPxjlEntity> tUserPxjlOldList = findHql(hql5, new Object[] { id5 });
/*     */     TUserPxjlEntity sendE;
/* 287 */     for (TUserPxjlEntity oldE : tUserPxjlOldList) {
/* 288 */       boolean isUpdate = false;
/* 289 */       for (Iterator localIterator7 = tUserPxjlList.iterator(); localIterator7.hasNext();) { sendE = (TUserPxjlEntity)localIterator7.next();
/*     */         
/* 291 */         if (oldE.getId().equals(sendE.getId())) {
/*     */           try {
/* 293 */             MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
/* 294 */             saveOrUpdate(oldE);
/*     */           } catch (Exception e) {
/* 296 */             e.printStackTrace();
/* 297 */             throw new BusinessException(e.getMessage());
/*     */           }
/* 299 */           isUpdate = true;
/* 300 */           break;
/*     */         }
/*     */       }
/* 303 */       if (!isUpdate)
/*     */       {
/* 305 */         super.delete(oldE);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 310 */     for (TUserPxjlEntity tUserPxjl : tUserPxjlList) {
/* 311 */       if (oConvertUtils.isEmpty(tUserPxjl.getId()))
/*     */       {
/* 313 */         tUserPxjl.setUid(tUserInfo.getId());
/* 314 */         save(tUserPxjl);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 319 */     String hql6 = "from TUserGzglEntity where 1 = 1 AND uID = ? ";
/* 320 */     List<TUserGzglEntity> tUserGzglOldList = findHql(hql6, new Object[] { id6 });
/*     */     TUserGzglEntity sendE;
/* 322 */     for (TUserGzglEntity oldE : tUserGzglOldList) {
/* 323 */       boolean isUpdate = false;
/* 324 */       for (Iterator localIterator8 = tUserGzglList.iterator(); localIterator8.hasNext();) { sendE = (TUserGzglEntity)localIterator8.next();
/*     */         
/* 326 */         if (oldE.getId().equals(sendE.getId())) {
/*     */           try {
/* 328 */             MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
/* 329 */             saveOrUpdate(oldE);
/*     */           } catch (Exception e) {
/* 331 */             e.printStackTrace();
/* 332 */             throw new BusinessException(e.getMessage());
/*     */           }
/* 334 */           isUpdate = true;
/* 335 */           break;
/*     */         }
/*     */       }
/* 338 */       if (!isUpdate)
/*     */       {
/* 340 */         super.delete(oldE);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 345 */     for (TUserGzglEntity tUserGzgl : tUserGzglList) {
/* 346 */       if (oConvertUtils.isEmpty(tUserGzgl.getId()))
/*     */       {
/* 348 */         tUserGzgl.setUid(tUserInfo.getId());
/* 349 */         save(tUserGzgl);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 354 */     String hql7 = "from TUserTxjsEntity where 1 = 1 AND uID = ? ";
/* 355 */     List<TUserTxjsEntity> tUserTxjsOldList = findHql(hql7, new Object[] { id7 });
/*     */     
/* 357 */     for (TUserTxjsEntity oldE : tUserTxjsOldList) {
/* 358 */       boolean isUpdate = false;
/* 359 */       for (TUserTxjsEntity sendE : tUserTxjsList)
/*     */       {
/* 361 */         if (oldE.getId().equals(sendE.getId())) {
/*     */           try {
/* 363 */             MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
/* 364 */             saveOrUpdate(oldE);
/*     */           } catch (Exception e) {
/* 366 */             e.printStackTrace();
/* 367 */             throw new BusinessException(e.getMessage());
/*     */           }
/* 369 */           isUpdate = true;
/* 370 */           break;
/*     */         }
/*     */       }
/* 373 */       if (!isUpdate)
/*     */       {
/* 375 */         super.delete(oldE);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 380 */     for (TUserTxjsEntity tUserTxjs : tUserTxjsList) {
/* 381 */       if (oConvertUtils.isEmpty(tUserTxjs.getId()))
/*     */       {
/* 383 */         tUserTxjs.setUid(tUserInfo.getId());
/* 384 */         save(tUserTxjs);
/*     */       }
/*     */     }
/*     */     
/* 388 */     doUpdateSql(tUserInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public void delMain(TUserInfoEntity tUserInfo)
/*     */   {
/* 394 */     delete(tUserInfo);
/*     */     
/*     */ 
/* 397 */     Object id0 = tUserInfo.getId();
/* 398 */     Object id1 = tUserInfo.getId();
/* 399 */     Object id2 = tUserInfo.getId();
/* 400 */     Object id3 = tUserInfo.getId();
/* 401 */     Object id4 = tUserInfo.getId();
/* 402 */     Object id5 = tUserInfo.getId();
/* 403 */     Object id6 = tUserInfo.getId();
/* 404 */     Object id7 = tUserInfo.getId();
/*     */     
/*     */ 
/* 407 */     String hql0 = "from TUserJtcyEntity where 1 = 1 AND uID = ? ";
/* 408 */     List<TUserJtcyEntity> tUserJtcyOldList = findHql(hql0, new Object[] { id0 });
/* 409 */     deleteAllEntitie(tUserJtcyOldList);
/*     */     
/*     */ 
/* 412 */     String hql1 = "from TUserJyjlEntity where 1 = 1 AND uID = ? ";
/* 413 */     List<TUserJyjlEntity> tUserJyjlOldList = findHql(hql1, new Object[] { id1 });
/* 414 */     deleteAllEntitie(tUserJyjlOldList);
/*     */     
/*     */ 
/* 417 */     String hql2 = "from TUserGzjlEntity where 1 = 1 AND uID = ? ";
/* 418 */     List<TUserGzjlEntity> tUserGzjlOldList = findHql(hql2, new Object[] { id2 });
/* 419 */     deleteAllEntitie(tUserGzjlOldList);
/*     */     
/*     */ 
/* 422 */     String hql3 = "from TUserHtglEntity where 1 = 1 AND uID = ? ";
/* 423 */     List<TUserHtglEntity> tUserHtglOldList = findHql(hql3, new Object[] { id3 });
/* 424 */     deleteAllEntitie(tUserHtglOldList);
/*     */     
/*     */ 
/* 427 */     String hql4 = "from TUserJcjlEntity where 1 = 1 AND uID = ? ";
/* 428 */     List<TUserJcjlEntity> tUserJcjlOldList = findHql(hql4, new Object[] { id4 });
/* 429 */     deleteAllEntitie(tUserJcjlOldList);
/*     */     
/*     */ 
/* 432 */     String hql5 = "from TUserPxjlEntity where 1 = 1 AND uID = ? ";
/* 433 */     List<TUserPxjlEntity> tUserPxjlOldList = findHql(hql5, new Object[] { id5 });
/* 434 */     deleteAllEntitie(tUserPxjlOldList);
/*     */     
/*     */ 
/* 437 */     String hql6 = "from TUserGzglEntity where 1 = 1 AND uID = ? ";
/* 438 */     List<TUserGzglEntity> tUserGzglOldList = findHql(hql6, new Object[] { id6 });
/* 439 */     deleteAllEntitie(tUserGzglOldList);
/*     */     
/*     */ 
/* 442 */     String hql7 = "from TUserTxjsEntity where 1 = 1 AND uID = ? ";
/* 443 */     List<TUserTxjsEntity> tUserTxjsOldList = findHql(hql7, new Object[] { id7 });
/* 444 */     deleteAllEntitie(tUserTxjsOldList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean doAddSql(TUserInfoEntity t)
/*     */   {
/* 454 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean doUpdateSql(TUserInfoEntity t)
/*     */   {
/* 462 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean doDelSql(TUserInfoEntity t)
/*     */   {
/* 470 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String replaceVal(String sql, TUserInfoEntity t)
/*     */   {
/* 479 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 480 */     sql = sql.replace("#{bh}", String.valueOf(t.getBh()));
/* 481 */     sql = sql.replace("#{xm}", String.valueOf(t.getXm()));
/* 482 */     sql = sql.replace("#{xb}", String.valueOf(t.getXb()));
/* 483 */     sql = sql.replace("#{mz}", String.valueOf(t.getMz()));
/* 484 */     sql = sql.replace("#{sfz}", String.valueOf(t.getSfz()));
/* 485 */     sql = sql.replace("#{hyzt}", String.valueOf(t.getHyzt()));
/* 486 */     sql = sql.replace("#{csrq}", String.valueOf(t.getCsrq()));
/* 487 */     sql = sql.replace("#{bgdh}", String.valueOf(t.getBgdh()));
/* 488 */     sql = sql.replace("#{xl}", String.valueOf(t.getXl()));
/* 489 */     sql = sql.replace("#{jjlxdh}", String.valueOf(t.getJjlxdh()));
/* 490 */     sql = sql.replace("#{qq}", String.valueOf(t.getQq()));
/* 491 */     sql = sql.replace("#{jg}", String.valueOf(t.getJg()));
/* 492 */     sql = sql.replace("#{jtzz}", String.valueOf(t.getJtzz()));
/* 493 */     sql = sql.replace("#{hkszd}", String.valueOf(t.getHkszd()));
/* 494 */     sql = sql.replace("#{zzmm}", String.valueOf(t.getZzmm()));
/* 495 */     sql = sql.replace("#{rdtsj}", String.valueOf(t.getRdtsj()));
/* 496 */     sql = sql.replace("#{dnzw}", String.valueOf(t.getDnzw()));
/* 497 */     sql = sql.replace("#{tnzw}", String.valueOf(t.getTnzw()));
/* 498 */     sql = sql.replace("#{dzb}", String.valueOf(t.getDzb()));
/* 499 */     sql = sql.replace("#{rdjd}", String.valueOf(t.getRdjd()));
/* 500 */     sql = sql.replace("#{dfjs}", String.valueOf(t.getDfjs()));
/* 501 */     sql = sql.replace("#{twzw}", String.valueOf(t.getTwzw()));
/* 502 */     sql = sql.replace("#{grxxbz}", String.valueOf(t.getGrxxbz()));
/* 503 */     sql = sql.replace("#{ygxs}", String.valueOf(t.getYgxs()));
/* 504 */     sql = sql.replace("#{zzzt}", String.valueOf(t.getZzzt()));
/* 505 */     sql = sql.replace("#{gw}", String.valueOf(t.getGw()));
/* 506 */     sql = sql.replace("#{bm}", String.valueOf(t.getBm()));
/* 507 */     sql = sql.replace("#{zzjszc}", String.valueOf(t.getZzjszc()));
/* 508 */     sql = sql.replace("#{gwdj}", String.valueOf(t.getGwdj()));
/* 509 */     sql = sql.replace("#{zw}", String.valueOf(t.getZw()));
/* 510 */     sql = sql.replace("#{cjgzsj}", String.valueOf(t.getCjgzsj()));
/* 511 */     sql = sql.replace("#{sbzh}", String.valueOf(t.getSbzh()));
/* 512 */     sql = sql.replace("#{zwjb}", String.valueOf(t.getZwjb()));
/* 513 */     sql = sql.replace("#{xzwgznx}", String.valueOf(t.getXzwgznx()));
/* 514 */     sql = sql.replace("#{zc}", String.valueOf(t.getZc()));
/* 515 */     sql = sql.replace("#{xzwgzsj}", String.valueOf(t.getXzwgzsj()));
/* 516 */     sql = sql.replace("#{bjbgznx}", String.valueOf(t.getBjbgznx()));
/* 517 */     sql = sql.replace("#{jckh}", String.valueOf(t.getJckh()));
/* 518 */     sql = sql.replace("#{bmtzjl}", String.valueOf(t.getBmtzjl()));
/* 519 */     sql = sql.replace("#{gjjzh}", String.valueOf(t.getGjjzh()));
/* 520 */     sql = sql.replace("#{dwxxbz}", String.valueOf(t.getDwxxbz()));
/* 521 */     sql = sql.replace("#{rbdwsj}", String.valueOf(t.getRbdwsj()));
/* 522 */     sql = sql.replace("#{gl}", String.valueOf(t.getGl()));
/* 523 */     sql = sql.replace("#{rbjbsj}", String.valueOf(t.getRbjbsj()));
/* 524 */     sql = sql.replace("#{rdwqd}", String.valueOf(t.getRdwqd()));
/* 525 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 526 */     return sql;
/*     */   }
/*     */ }


