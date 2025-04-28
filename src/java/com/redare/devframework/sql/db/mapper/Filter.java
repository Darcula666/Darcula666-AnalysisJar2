/*   */ package com.redare.devframework.sql.db.mapper;
/*   */ 
/*   */ public interface Filter<T>
/*   */ {
/*   */   default boolean resultSetNext() {
/* 6 */     return true;
/*   */   }
/*   */   
/*   */   boolean isNeedThisData(T paramT);
/*   */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/db/mapper/Filter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */