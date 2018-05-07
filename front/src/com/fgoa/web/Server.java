/*    */ package com.fgoa.web;
/*    */ 
/*    */ import com.jfinal.server.IServer;
/*    */ 
/*    */ public class Server
/*    */ {
/*    */   private static IServer server;
/*    */   
/*    */   public static void main(String[] args) {
/* 10 */     if ((args == null) || (args.length == 0)) {
/* 11 */       server = com.jfinal.server.ServerFactory.getServer(8080);
/* 12 */       server.start();
/*    */     } else {
/* 14 */       String webAppDir = args[0];
/* 15 */       int port = Integer.parseInt(args[1]);
/* 16 */       String context = args[2];
/* 17 */       int scanIntervalSeconds = Integer.parseInt(args[3]);
/* 18 */       server = com.jfinal.server.ServerFactory.getServer(webAppDir, port, context, 
/* 19 */         scanIntervalSeconds);
/* 20 */       server.start();
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\Server.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */