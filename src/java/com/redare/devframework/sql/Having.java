/*    */ package com.redare.devframework.sql;
/*    */ 
/*    */ public class Having
/*    */   extends SelectWhere {
/*    */   protected Having(BaseSql sql) {
/*  6 */     super(sql);
/*    */   }
/*    */   
/*    */   protected String whereKey() {
/* 10 */     return "having";
/*    */   }
/*    */ 
/*    */   
/*    */   public Having throwRunExceptionWhenCriteriaCountLess(int count) {
/* 15 */     super.throwRunExceptionWhenCriteriaCountLess(count);
/* 16 */     return this;
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Having.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */