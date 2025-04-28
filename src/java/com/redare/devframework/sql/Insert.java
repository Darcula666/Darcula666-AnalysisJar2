/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import com.redare.devframework.sql.lazy.LazyParam;
/*     */ import com.redare.devframework.sql.lazy.LazySql;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class Insert
/*     */   extends InsertFields {
/*     */   public static InsertFields fields() {
/*  10 */     return new InsertFields();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Insert(String table) {
/*  15 */     addSql("insert into", new Object[0]).addSql(table, new Object[0]);
/*     */   }
/*     */   
/*     */   public Select fromSelect() {
/*  19 */     return new Select(createSql(true));
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert fields(String... fields) {
/*  24 */     super.fields(fields);
/*  25 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert fieldIfElse(String field, boolean bool, Object trueParam, Object faultParam) {
/*  30 */     super.fieldIfElse(field, bool, trueParam, faultParam);
/*  31 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert fieldIfElse(String field, boolean bool, Object trueParam, LazyParam faultParam) {
/*  36 */     super.fieldIfElse(field, bool, trueParam, faultParam);
/*  37 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert fieldIf(boolean bool, String field, LazyParam lazyParam) {
/*  42 */     super.fieldIf(bool, field, lazyParam);
/*  43 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert field(String field) {
/*  48 */     super.field(field);
/*  49 */     return this;
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
/*     */   public Insert field(String field, Object param) {
/*  61 */     super.field(field, param);
/*  62 */     return this;
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
/*     */   public Insert field(String field, Object param, Object defaultValue) {
/*  75 */     super.field(field, param, defaultValue);
/*  76 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert fieldIf(boolean bool, LazySql<InsertFields> lazyInsert) {
/*  81 */     super.fieldIf(bool, lazyInsert);
/*  82 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert fieldIf(boolean bool, LazySql<InsertFields> trueInsert, LazySql<InsertFields> falseInsert) {
/*  87 */     super.fieldIf(bool, trueInsert, falseInsert);
/*  88 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert fieldIfNotNull(Object object, LazySql<InsertFields> lazyInsert) {
/*  93 */     super.fieldIfNotNull(object, lazyInsert);
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insert field(InsertFields insert) {
/*  99 */     super.field(insert);
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public InsertFields fieldIf(boolean bool, String field, Object params) {
/* 105 */     return super.fieldIf(bool, field, params);
/*     */   }
/*     */   
/*     */   private Insert createSql(boolean select) {
/* 109 */     if (this.hasCreate) {
/* 110 */       return this;
/*     */     }
/* 112 */     this.hasCreate = true;
/*     */     
/* 114 */     if (this.fields == null || this.fields.isEmpty()) {
/* 115 */       return this;
/*     */     }
/*     */     
/* 118 */     String fieldsStr = StringUtils.join(this.fields, ",");
/* 119 */     addSql("(", new Object[0]).addSql(fieldsStr, new Object[0]).addSql(")", new Object[0]);
/* 120 */     if (!select) {
/* 121 */       StringBuilder values = new StringBuilder();
/* 122 */       for (int i = 0; i < this.params.size(); i++) {
/* 123 */         if (i > 0) {
/* 124 */           values.append(",");
/*     */         }
/* 126 */         Object value = this.params.get(i);
/* 127 */         if (value instanceof Sql) {
/* 128 */           values.append(value.toString());
/*     */         } else {
/* 130 */           values.append("?");
/* 131 */           addParams(new Object[] { value });
/*     */         } 
/*     */       } 
/* 134 */       addSql("values (", new Object[0]).addSql(values.toString(), new Object[0]).addSql(")", new Object[0]);
/*     */     } 
/* 136 */     this.fields.clear();
/* 137 */     this.params.clear();
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public StringBuilder getSql() {
/* 143 */     createSql(false);
/* 144 */     return super.getSql();
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Insert.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */