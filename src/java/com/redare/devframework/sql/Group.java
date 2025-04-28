/*    */ package com.redare.devframework.sql;
/*    */ 
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class Group
/*    */   extends BaseSql {
/*    */   protected Group(BaseSql sql, String... fields) {
/*  8 */     super(sql);
/*  9 */     addSql("group by", new Object[0]).addSql(StringUtils.join((Object[])fields, ","), new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Order orderBy() {
/* 18 */     return new Order(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Having having() {
/* 27 */     return new Having(this);
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Group.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */