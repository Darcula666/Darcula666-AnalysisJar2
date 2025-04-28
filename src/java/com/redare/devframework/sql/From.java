/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import com.redare.devframework.sql.lazy.LazySql;
/*     */ 
/*     */ public class From
/*     */   extends BaseSql {
/*     */   protected From(BaseSql sql, String table, String alias) {
/*   8 */     super(sql);
/*   9 */     addSql("from", new Object[0]).addSql(table, new Object[0]).addSql(alias, new Object[0]);
/*     */   }
/*     */   
/*     */   protected From(BaseSql sql, Sql table, String alias) {
/*  13 */     super(sql);
/*  14 */     addSql("from", new Object[0]).addSql("(", new Object[0]).addSql(table).addSql(")", new Object[0]).addSql(alias, new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectWhere where() {
/*  23 */     return new SelectWhere(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order orderBy() {
/*  32 */     return new Order(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Group groupBy(String... fields) {
/*  42 */     return new Group(this, fields);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Join join(String table, String alias) {
/*  53 */     return joinIf(true, table, alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Join join(Sql table, String alias) {
/*  64 */     return join("inner", table, alias);
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
/*     */   public Join joinIf(boolean bool, String table, String alias) {
/*  76 */     return joinIf(bool, "inner", table, alias);
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
/*     */   public Join joinIf(boolean bool, LazySql<Sql> lazySql, String alias) {
/*  88 */     return joinIf(bool, "inner", lazySql, alias);
/*     */   }
/*     */   
/*     */   public Join joinIf(boolean bool, Sql sql, String alias) {
/*  92 */     return joinIf(bool, "inner", sql, alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Join leftJoin(String table, String alias) {
/* 103 */     return leftJoinIf(true, table, alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Join leftJoin(Sql table, String alias) {
/* 114 */     return join("left", table, alias);
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
/*     */   public Join leftJoinIf(boolean bool, String table, String alias) {
/* 126 */     return joinIf(bool, "left", table, alias);
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
/*     */   public Join leftJoinIf(boolean bool, LazySql<Sql> lazySql, String alias) {
/* 138 */     return joinIf(bool, "left", lazySql, alias);
/*     */   }
/*     */   
/*     */   public Join leftJoinIf(boolean bool, Sql sql, String alias) {
/* 142 */     return joinIf(bool, "left", sql, alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Join rightJoin(String table, String alias) {
/* 153 */     return rightJoinIf(true, table, alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Join rightJoin(Sql table, String alias) {
/* 164 */     return join("right", table, alias);
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
/*     */   public Join rightJoinIf(boolean bool, String table, String alias) {
/* 176 */     return joinIf(bool, "right", table, alias);
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
/*     */   public Join rightJoinIf(boolean bool, LazySql<Sql> lazySql, String alias) {
/* 188 */     return joinIf(bool, "right", lazySql, alias);
/*     */   }
/*     */   
/*     */   public Join rightJoinIf(boolean bool, Sql sql, String alias) {
/* 192 */     return joinIf(bool, "right", sql, alias);
/*     */   }
/*     */   
/*     */   private Join join(String type, Sql table, String alias) {
/* 196 */     return new Join(this, type, table, alias);
/*     */   }
/*     */   
/*     */   private Join joinIf(boolean bool, String type, LazySql<Sql> lazySql, String alias) {
/* 200 */     if (!bool) {
/* 201 */       return new Join(this, false, type, "", "");
/*     */     }
/* 203 */     return join(type, lazySql.getSql(), alias);
/*     */   }
/*     */   
/*     */   private Join joinIf(boolean bool, String type, Sql sql, String alias) {
/* 207 */     if (!bool) {
/* 208 */       return new Join(this, false, type, "", "");
/*     */     }
/* 210 */     return join(type, sql, alias);
/*     */   }
/*     */   
/*     */   private Join joinIf(boolean bool, String type, String table, String alias) {
/* 214 */     return new Join(this, bool, type, table, alias);
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/From.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */