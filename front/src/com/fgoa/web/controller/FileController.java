/*    */ package com.fgoa.web.controller;
/*    */ 
/*    */ import com.fgoa.web.model.AddonFile;
/*    */ import com.jfinal.upload.UploadFile;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class FileController extends com.jfinal.core.Controller
/*    */ {
/*    */   public static final String ADDON_FILE_FOLDER = "/userupload/addon/";
/*    */   
/*    */   public void uploadFile()
/*    */   {
/* 14 */     String id = getPara("id");
/* 15 */     String type = getPara("type");
/* 16 */     String path = getRequest().getSession().getServletContext()
/* 17 */       .getRealPath("/userupload/addon/" + id);
/* 18 */     UploadFile file = getFile("Filedata", path, Integer.valueOf(52428800), "utf-8");
/*    */     
/* 20 */     if ((StringUtils.isBlank(id)) || (StringUtils.isBlank(type)) || 
/* 21 */       (file.getFile() == null)) {
/* 22 */       renderError(500);
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     String fileName = file.getFileName();
/*    */     
/*    */ 
/* 29 */     ((AddonFile)((AddonFile)((AddonFile)((AddonFile)new AddonFile().set("name", file.getFileName())).set("type", type)).set("path", "/userupload/addon/" + id + "/" + fileName)).set("refid", id))
/* 30 */       .save();
/*    */     
/* 32 */     renderJson("{success:true}");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\FileController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */