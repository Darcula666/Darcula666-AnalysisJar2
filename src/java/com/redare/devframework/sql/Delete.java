/*    */ package com.redare.devframework.sql;
/*    */ 
/*    */ public class Delete
/*    */   extends BaseSql
/*    */ {
/*    */   protected Delete(String table) {
/*  7 */     addSql("delete from", new Object[0]).addSql(table, new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Where where() {
/* 16 */     return new Where(this);
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Delete.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */