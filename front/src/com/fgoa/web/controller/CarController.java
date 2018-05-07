/*   */ package com.fgoa.web.controller;
/*   */ 
/*   */ import com.fgoa.web.model.Car;
/*   */ 
/*   */ public class CarController extends com.jfinal.core.Controller
/*   */ {
/*   */   public void index() {
/* 8 */     setAttr("list", Car.dao.find("select * from t_oa_car"));
/* 9 */     render("car.ftl");
/*   */   }
/*   */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\CarController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */