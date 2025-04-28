/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import com.redare.devframework.sql.lazy.LazyParam;
/*     */ import com.redare.devframework.sql.lazy.LazySql;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Update
/*     */   extends UpdateFields
/*     */ {
/*     */   public static UpdateFields fields() {
/*  11 */     return new UpdateFields();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Update(String table) {
/*  16 */     addSql("update", new Object[0]).addSql(table, new Object[0]).addSql("set", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Where where() {
/*  25 */     return new Where(this);
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
/*     */   public Update add(String field, Number number) {
/*  37 */     super.add(field, number);
/*  38 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update sub(String field, Number number) {
/*  43 */     super.sub(field, number);
/*  44 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update multi(String field, Number number) {
/*  49 */     super.multi(field, number);
/*  50 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update div(String field, Number number) {
/*  55 */     super.div(field, number);
/*  56 */     return this;
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
/*     */   
/*     */   public Update addIf(boolean bool, String field, Number number) {
/*  69 */     super.addIf(bool, field, number);
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update subIf(boolean bool, String field, Number number) {
/*  75 */     super.subIf(bool, field, number);
/*  76 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update multiIf(boolean bool, String field, Number number) {
/*  81 */     super.multiIf(bool, field, number);
/*  82 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update divIf(boolean bool, String field, Number number) {
/*  87 */     super.divIf(bool, field, number);
/*  88 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update addIf(boolean bool, String field, LazyParam<Number> lazyParam) {
/*  93 */     super.addIf(bool, field, lazyParam);
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update subIf(boolean bool, String field, LazyParam<Number> lazyParam) {
/*  99 */     super.subIf(bool, field, lazyParam);
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update multiIf(boolean bool, String field, LazyParam<Number> lazyParam) {
/* 105 */     super.multiIf(bool, field, lazyParam);
/* 106 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update divIf(boolean bool, String field, LazyParam<Number> lazyParam) {
/* 111 */     super.divIf(bool, field, lazyParam);
/* 112 */     return this;
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
/*     */   public Update setIfNotNull(String field, Object params) {
/* 124 */     super.setIfNotNull(field, params);
/* 125 */     return this;
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
/*     */   
/*     */   public Update setIfNotNull(String field, Object params, LazyParam lazyParam) {
/* 138 */     super.setIfNotNull(field, params, lazyParam);
/* 139 */     return this;
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
/*     */   public Update setIfNotBlank(String field, String params) {
/* 151 */     super.setIfNotBlank(field, params);
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update setIfElse(String field, boolean bool, Object params, LazyParam lazyParam) {
/* 157 */     super.setIfElse(field, bool, params, lazyParam);
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update setIfElse(String field, boolean bool, Object params1, Object params2) {
/* 163 */     super.setIfElse(field, bool, params1, params2);
/* 164 */     return this;
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
/*     */   
/*     */   public Update setIf(boolean bool, String field, Object params) {
/* 177 */     super.setIf(bool, field, params);
/* 178 */     return this;
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
/*     */   
/*     */   public Update setIf(boolean bool, String field, LazyParam lazyParam) {
/* 191 */     super.setIf(bool, field, lazyParam);
/* 192 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update setIf(boolean bool, String field) {
/* 197 */     super.setIf(bool, field);
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update set(List<String> fields) {
/* 203 */     super.set(fields);
/* 204 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update set(String... fields) {
/* 209 */     super.set(fields);
/* 210 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update set(String field) {
/* 215 */     super.set(field);
/* 216 */     return this;
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
/*     */   public Update set(String field, Object params) {
/* 228 */     super.set(field, params);
/* 229 */     return this;
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
/*     */   
/*     */   public Update setIf(boolean bool, String field, LazySql lazySql) {
/* 242 */     super.setIf(bool, field, lazySql);
/* 243 */     return this;
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
/*     */   public Update set(String field, Sql sql) {
/* 255 */     super.set(field, sql);
/* 256 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update set(UpdateFields update) {
/* 261 */     super.set(update);
/* 262 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update setIf(boolean bool, LazySql<UpdateFields> lazySql) {
/* 267 */     super.setIf(bool, lazySql);
/* 268 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update setIfNotNull(Object object, LazySql<UpdateFields> lazySql) {
/* 273 */     super.setIfNotNull(object, lazySql);
/* 274 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Update setIf(boolean bool, LazySql<UpdateFields> trueSql, LazySql<UpdateFields> falseSql) {
/* 279 */     super.setIf(bool, trueSql, falseSql);
/* 280 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public UpdateFields setIfElse(String field, boolean bool, LazySql trueSql, LazySql falseSql) {
/* 285 */     super.setIfElse(field, bool, trueSql, falseSql);
/* 286 */     return this;
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Update.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */