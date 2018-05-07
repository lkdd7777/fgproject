/*     */ package com.fgoa.controller.houseassets;
/*     */ 
/*     */ import com.fgoa.entity.examconfig.ExamConfigEntity;
import com.fgoa.entity.houseassets.HouseAssetsEntity;
/*     */ import com.fgoa.service.houseassets.HouseAssetsServiceI;

/*     */ import java.util.HashMap;
/*     */ import java.util.Map;

/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;

/*     */ import org.apache.log4j.Logger;
/*     */ import org.jeecgframework.core.common.controller.BaseController;
/*     */ import org.jeecgframework.core.common.exception.BusinessException;
/*     */ import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
/*     */ import org.jeecgframework.core.common.model.json.AjaxJson;
/*     */ import org.jeecgframework.core.common.model.json.DataGrid;
/*     */ import org.jeecgframework.core.constant.Globals;
/*     */ import org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil;
/*     */ import org.jeecgframework.core.util.MyBeanUtils;
/*     */ import org.jeecgframework.core.util.StringUtil;
/*     */ import org.jeecgframework.tag.core.easyui.TagUtil;
/*     */ import org.jeecgframework.tag.vo.datatable.SortDirection;
/*     */ import org.jeecgframework.web.system.service.SystemService;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
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
/*     */ @Controller
/*     */ @RequestMapping({"/houseAssetsController"})
/*     */ public class HouseAssetsController
/*     */   extends BaseController
/*     */ {
/*  52 */   private static final Logger logger = Logger.getLogger(HouseAssetsController.class);
/*     */   @Autowired
/*     */   private HouseAssetsServiceI houseAssetsService;
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */   private String message;
/*     */   
/*     */   public String getMessage()
/*     */   {
/*  61 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/*  65 */     this.message = message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"houseAssets"})
/*     */   public ModelAndView houseAssets(HttpServletRequest request)
/*     */   {
/*  76 */     return new ModelAndView("com/fgoa/houseassets/houseAssetsList");
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
/*     */   @RequestMapping(params={"datagrid"})
/*     */   public void datagrid(HouseAssetsEntity houseAssets, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/*  90 */     CriteriaQuery cq = new CriteriaQuery(HouseAssetsEntity.class, dataGrid);
/*  91 */     Map<String, Object> orderMap = new HashMap();
/*  92 */     orderMap.put("sortNum", SortDirection.desc);
/*  93 */     cq.setOrder(orderMap);
/*     */     
/*  95 */     HqlGenerateUtil.installHql(cq, houseAssets, request.getParameterMap());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 101 */     cq.add();
/* 102 */     this.houseAssetsService.getDataGridReturn(cq, true);
/* 103 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doDel(HouseAssetsEntity houseAssets, HttpServletRequest request)
/*     */   {
/* 114 */     AjaxJson j = new AjaxJson();
/* 115 */     houseAssets = (HouseAssetsEntity)this.systemService.getEntity(HouseAssetsEntity.class, houseAssets.getId());
/* 116 */     this.message = "tbl_house_assets删除成功";
/*     */     try {
/* 118 */       this.houseAssetsService.delete(houseAssets);
/* 119 */       this.systemService.addLog(this.message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 121 */       e.printStackTrace();
/* 122 */       this.message = "tbl_house_assets删除失败";
/* 123 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 125 */     j.setMsg(this.message);
/* 126 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doBatchDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doBatchDel(String ids, HttpServletRequest request)
/*     */   {
/* 137 */     AjaxJson j = new AjaxJson();
/* 138 */     this.message = "tbl_house_assets删除成功";
/*     */     try {
	for(String id:ids.split(",")){
		ExamConfigEntity examConfig = systemService.getEntity(ExamConfigEntity.class, 
		Integer.parseInt(id)
		);
		houseAssetsService.delete(examConfig);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
	}
/*     */     } catch (Exception e) {
/* 148 */       e.printStackTrace();
/* 149 */       this.message = "tbl_house_assets删除失败";
/* 150 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 152 */     j.setMsg(this.message);
/* 153 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doAdd"})
/*     */   @ResponseBody
/*     */   public AjaxJson doAdd(HouseAssetsEntity houseAssets, HttpServletRequest request)
/*     */   {
/* 166 */     AjaxJson j = new AjaxJson();
/* 167 */     this.message = "tbl_house_assets添加成功";
/*     */     try {
/* 169 */       this.houseAssetsService.save(houseAssets);
/* 170 */       this.systemService.addLog(this.message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 172 */       e.printStackTrace();
/* 173 */       this.message = "tbl_house_assets添加失败";
/* 174 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 176 */     j.setMsg(this.message);
/* 177 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doUpdate"})
/*     */   @ResponseBody
/*     */   public AjaxJson doUpdate(HouseAssetsEntity houseAssets, HttpServletRequest request)
/*     */   {
/* 189 */     AjaxJson j = new AjaxJson();
/* 190 */     this.message = "tbl_house_assets更新成功";
/* 191 */     HouseAssetsEntity t = (HouseAssetsEntity)this.houseAssetsService.get(HouseAssetsEntity.class, houseAssets.getId());
/*     */     try {
/* 193 */       MyBeanUtils.copyBeanNotNull2Bean(houseAssets, t);
/* 194 */       this.houseAssetsService.saveOrUpdate(t);
/* 195 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 197 */       e.printStackTrace();
/* 198 */       this.message = "tbl_house_assets更新失败";
/* 199 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 201 */     j.setMsg(this.message);
/* 202 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goAdd"})
/*     */   public ModelAndView goAdd(HouseAssetsEntity houseAssets, HttpServletRequest req)
/*     */   {
/* 213 */     if (StringUtil.isNotEmpty(houseAssets.getId())) {
/* 214 */       houseAssets = (HouseAssetsEntity)this.houseAssetsService.getEntity(HouseAssetsEntity.class, houseAssets.getId());
/* 215 */       req.setAttribute("houseAssetsPage", houseAssets);
/*     */     }
/* 217 */     return new ModelAndView("com/fgoa/houseassets/houseAssets-add");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goUpdate"})
/*     */   public ModelAndView goUpdate(HouseAssetsEntity houseAssets, HttpServletRequest req)
/*     */   {
/* 226 */     if (StringUtil.isNotEmpty(houseAssets.getId())) {
/* 227 */       houseAssets = (HouseAssetsEntity)this.houseAssetsService.getEntity(HouseAssetsEntity.class, houseAssets.getId());
/* 228 */       req.setAttribute("houseAssetsPage", houseAssets);
/*     */     }
/* 230 */     return new ModelAndView("com/fgoa/houseassets/houseAssets-update");
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @RequestMapping(params={"exportXls"})
/*     */   public void exportXls(HouseAssetsEntity course, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_3
/*     */     //   1: ldc -11
/*     */     //   3: invokeinterface 247 2 0
/*     */     //   8: aconst_null
/*     */     //   9: astore 5
/*     */     //   11: aconst_null
/*     */     //   12: astore 6
/*     */     //   14: ldc -4
/*     */     //   16: astore 5
/*     */     //   18: aload_2
/*     */     //   19: invokestatic 254	org/jeecgframework/core/util/BrowserUtils:isIE	(Ljavax/servlet/http/HttpServletRequest;)Z
/*     */     //   22: ifeq +45 -> 67
/*     */     //   25: aload_3
/*     */     //   26: ldc_w 260
/*     */     //   29: new 262	java/lang/StringBuilder
/*     */     //   32: dup
/*     */     //   33: ldc_w 264
/*     */     //   36: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   39: aload 5
/*     */     //   41: ldc_w 267
/*     */     //   44: invokestatic 269	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   47: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   50: ldc_w 279
/*     */     //   53: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   56: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   59: invokeinterface 284 3 0
/*     */     //   64: goto +56 -> 120
/*     */     //   67: new 181	java/lang/String
/*     */     //   70: dup
/*     */     //   71: aload 5
/*     */     //   73: ldc_w 267
/*     */     //   76: invokevirtual 288	java/lang/String:getBytes	(Ljava/lang/String;)[B
/*     */     //   79: ldc_w 292
/*     */     //   82: invokespecial 294	java/lang/String:<init>	([BLjava/lang/String;)V
/*     */     //   85: astore 7
/*     */     //   87: aload_3
/*     */     //   88: ldc_w 260
/*     */     //   91: new 262	java/lang/StringBuilder
/*     */     //   94: dup
/*     */     //   95: ldc_w 264
/*     */     //   98: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   101: aload 7
/*     */     //   103: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   106: ldc_w 279
/*     */     //   109: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   112: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   115: invokeinterface 284 3 0
/*     */     //   120: aconst_null
/*     */     //   121: astore 7
/*     */     //   123: new 53	org/jeecgframework/core/common/hibernate/qbc/CriteriaQuery
/*     */     //   126: dup
/*     */     //   127: ldc 55
/*     */     //   129: aload 4
/*     */     //   131: invokespecial 57	org/jeecgframework/core/common/hibernate/qbc/CriteriaQuery:<init>	(Ljava/lang/Class;Lorg/jeecgframework/core/common/model/json/DataGrid;)V
/*     */     //   134: astore 8
/*     */     //   136: aload 8
/*     */     //   138: aload_1
/*     */     //   139: aload_2
/*     */     //   140: invokeinterface 81 1 0
/*     */     //   145: invokestatic 87	org/jeecgframework/core/extend/hqlsearch/HqlGenerateUtil:installHql	(Lorg/jeecgframework/core/common/hibernate/qbc/CriteriaQuery;Ljava/lang/Object;Ljava/util/Map;)V
/*     */     //   148: aload_0
/*     */     //   149: getfield 96	com/fgoa/controller/houseassets/HouseAssetsController:houseAssetsService	Lcom/fgoa/service/houseassets/HouseAssetsServiceI;
/*     */     //   152: aload 8
/*     */     //   154: iconst_0
/*     */     //   155: invokestatic 297	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
/*     */     //   158: invokeinterface 303 3 0
/*     */     //   163: astore 9
/*     */     //   165: new 307	org/jeecgframework/poi/excel/entity/ExcelTitle
/*     */     //   168: dup
/*     */     //   169: ldc -4
/*     */     //   171: ldc_w 309
/*     */     //   174: ldc -4
/*     */     //   176: invokespecial 311	org/jeecgframework/poi/excel/entity/ExcelTitle:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
/*     */     //   179: ldc 55
/*     */     //   181: aload 9
/*     */     //   183: invokestatic 314	org/jeecgframework/poi/excel/ExcelExportUtil:exportExcel	(Lorg/jeecgframework/poi/excel/entity/ExcelTitle;Ljava/lang/Class;Ljava/util/Collection;)Lorg/apache/poi/hssf/usermodel/HSSFWorkbook;
/*     */     //   186: astore 7
/*     */     //   188: aload_3
/*     */     //   189: invokeinterface 320 1 0
/*     */     //   194: astore 6
/*     */     //   196: aload 7
/*     */     //   198: aload 6
/*     */     //   200: invokevirtual 324	org/apache/poi/hssf/usermodel/HSSFWorkbook:write	(Ljava/io/OutputStream;)V
/*     */     //   203: goto +43 -> 246
/*     */     //   206: astore 7
/*     */     //   208: aload 6
/*     */     //   210: invokevirtual 330	java/io/OutputStream:flush	()V
/*     */     //   213: aload 6
/*     */     //   215: invokevirtual 335	java/io/OutputStream:close	()V
/*     */     //   218: goto +43 -> 261
/*     */     //   221: astore 11
/*     */     //   223: goto +38 -> 261
/*     */     //   226: astore 10
/*     */     //   228: aload 6
/*     */     //   230: invokevirtual 330	java/io/OutputStream:flush	()V
/*     */     //   233: aload 6
/*     */     //   235: invokevirtual 335	java/io/OutputStream:close	()V
/*     */     //   238: goto +5 -> 243
/*     */     //   241: astore 11
/*     */     //   243: aload 10
/*     */     //   245: athrow
/*     */     //   246: aload 6
/*     */     //   248: invokevirtual 330	java/io/OutputStream:flush	()V
/*     */     //   251: aload 6
/*     */     //   253: invokevirtual 335	java/io/OutputStream:close	()V
/*     */     //   256: goto +5 -> 261
/*     */     //   259: astore 11
/*     */     //   261: return
/*     */     // Line number table:
/*     */     //   Java source line #242	-> byte code offset #0
/*     */     //   Java source line #243	-> byte code offset #8
/*     */     //   Java source line #244	-> byte code offset #11
/*     */     //   Java source line #246	-> byte code offset #14
/*     */     //   Java source line #248	-> byte code offset #18
/*     */     //   Java source line #249	-> byte code offset #25
/*     */     //   Java source line #250	-> byte code offset #26
/*     */     //   Java source line #251	-> byte code offset #29
/*     */     //   Java source line #252	-> byte code offset #39
/*     */     //   Java source line #253	-> byte code offset #41
/*     */     //   Java source line #252	-> byte code offset #44
/*     */     //   Java source line #253	-> byte code offset #50
/*     */     //   Java source line #251	-> byte code offset #56
/*     */     //   Java source line #249	-> byte code offset #59
/*     */     //   Java source line #254	-> byte code offset #64
/*     */     //   Java source line #255	-> byte code offset #67
/*     */     //   Java source line #256	-> byte code offset #79
/*     */     //   Java source line #255	-> byte code offset #82
/*     */     //   Java source line #257	-> byte code offset #87
/*     */     //   Java source line #258	-> byte code offset #91
/*     */     //   Java source line #257	-> byte code offset #115
/*     */     //   Java source line #261	-> byte code offset #120
/*     */     //   Java source line #262	-> byte code offset #123
/*     */     //   Java source line #263	-> byte code offset #136
/*     */     //   Java source line #265	-> byte code offset #148
/*     */     //   Java source line #266	-> byte code offset #165
/*     */     //   Java source line #267	-> byte code offset #174
/*     */     //   Java source line #266	-> byte code offset #176
/*     */     //   Java source line #267	-> byte code offset #179
/*     */     //   Java source line #266	-> byte code offset #183
/*     */     //   Java source line #268	-> byte code offset #188
/*     */     //   Java source line #269	-> byte code offset #196
/*     */     //   Java source line #270	-> byte code offset #203
/*     */     //   Java source line #273	-> byte code offset #208
/*     */     //   Java source line #274	-> byte code offset #213
/*     */     //   Java source line #275	-> byte code offset #218
/*     */     //   Java source line #271	-> byte code offset #226
/*     */     //   Java source line #273	-> byte code offset #228
/*     */     //   Java source line #274	-> byte code offset #233
/*     */     //   Java source line #275	-> byte code offset #238
/*     */     //   Java source line #278	-> byte code offset #243
/*     */     //   Java source line #273	-> byte code offset #246
/*     */     //   Java source line #274	-> byte code offset #251
/*     */     //   Java source line #275	-> byte code offset #256
/*     */     //   Java source line #279	-> byte code offset #261
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	262	0	this	HouseAssetsController
/*     */     //   0	262	1	course	HouseAssetsEntity
/*     */     //   0	262	2	request	HttpServletRequest
/*     */     //   0	262	3	response	HttpServletResponse
/*     */     //   0	262	4	dataGrid	DataGrid
/*     */     //   9	63	5	codedFileName	String
/*     */     //   12	240	6	fOut	java.io.OutputStream
/*     */     //   85	17	7	newtitle	String
/*     */     //   121	76	7	workbook	org.apache.poi.hssf.usermodel.HSSFWorkbook
/*     */     //   206	1	7	localException	Exception
/*     */     //   134	19	8	cq	CriteriaQuery
/*     */     //   163	19	9	courses	java.util.List<HouseAssetsEntity>
/*     */     //   226	18	10	localObject	Object
/*     */     //   221	1	11	localIOException	java.io.IOException
/*     */     //   241	1	11	localIOException1	java.io.IOException
/*     */     //   259	1	11	localIOException2	java.io.IOException
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   14	203	206	java/lang/Exception
/*     */     //   208	218	221	java/io/IOException
/*     */     //   14	208	226	finally
/*     */     //   228	238	241	java/io/IOException
/*     */     //   246	256	259	java/io/IOException
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\controller\houseassets\HouseAssetsController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */