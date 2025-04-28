/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import com.redare.devframework.sql.lazy.LazyParam;
/*     */ import com.redare.devframework.sql.lazy.LazySql;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InsertFields
/*     */   extends BaseSql
/*     */ {
/*  18 */   protected List<String> fields = new ArrayList<>();
/*  19 */   protected List<Object> params = new ArrayList();
/*     */   protected boolean hasCreate;
/*     */   
/*     */   public InsertFields fields(String... fields) {
/*  23 */     if (fields == null || fields.length == 0) {
/*  24 */       return this;
/*     */     }
/*  26 */     for (String field : fields) {
/*  27 */       field(field);
/*     */     }
/*  29 */     return this;
/*     */   }
/*     */   
/*     */   public InsertFields fieldIfElse(String field, boolean bool, Object trueParam, Object faultParam) {
/*  33 */     if (bool) {
/*  34 */       field(field, trueParam);
/*     */     } else {
/*  36 */       field(field, faultParam);
/*     */     } 
/*  38 */     return this;
/*     */   }
/*     */   
/*     */   public InsertFields fieldIfElse(String field, boolean bool, Object trueParam, LazyParam faultParam) {
/*  42 */     if (bool) {
/*  43 */       field(field, trueParam);
/*     */     } else {
/*  45 */       field(field, faultParam.getParam());
/*     */     } 
/*  47 */     return this;
/*     */   }
/*     */   
/*     */   public InsertFields fieldIf(boolean bool, String field, LazyParam lazyParam) {
/*  51 */     if (!bool) {
/*  52 */       return this;
/*     */     }
/*     */     
/*  55 */     return field(field, lazyParam.getParam());
/*     */   }
/*     */   
/*     */   public InsertFields fieldIf(boolean bool, String field, Object params) {
/*  59 */     if (!bool) {
/*  60 */       return this;
/*     */     }
/*     */     
/*  63 */     return field(field, params);
/*     */   }
/*     */   
/*     */   public InsertFields field(String field) {
/*  67 */     return field(field, (Object)null);
/*     */   }
/*     */   
/*     */   public InsertFields field(String field, Object param) {
/*  71 */     return field(field, param, (Object)null);
/*     */   }
/*     */   
/*     */   public InsertFields field(String field, Object param, Object defaultValue) {
/*  75 */     this.fields.add(field);
/*  76 */     if (param == null) {
/*  77 */       this.params.add(defaultValue);
/*     */     } else {
/*  79 */       this.params.add(param);
/*     */     } 
/*  81 */     return this;
/*     */   }
/*     */   
/*     */   public InsertFields fieldIf(boolean bool, LazySql<InsertFields> lazyInsert) {
/*  85 */     if (!bool) {
/*  86 */       return this;
/*     */     }
/*  88 */     return field((InsertFields)lazyInsert.getSql());
/*     */   }
/*     */   
/*     */   public InsertFields fieldIf(boolean bool, LazySql<InsertFields> trueInsert, LazySql<InsertFields> falseInsert) {
/*  92 */     return bool ? field((InsertFields)trueInsert.getSql()) : field((InsertFields)falseInsert.getSql());
/*     */   }
/*     */   
/*     */   public InsertFields fieldIfNotNull(Object object, LazySql<InsertFields> lazyInsert) {
/*  96 */     if (object == null) {
/*  97 */       return this;
/*     */     }
/*  99 */     return field((InsertFields)lazyInsert.getSql());
/*     */   }
/*     */   
/*     */   public InsertFields field(InsertFields insert) {
/* 103 */     if (insert.fields != null && !insert.fields.isEmpty()) {
/* 104 */       this.fields.addAll(insert.fields);
/* 105 */       this.params.addAll(insert.params);
/*     */     } 
/* 107 */     return this;
/*     */   }
/*     */   
/*     */   private InsertFields createSql() {
/* 111 */     if (this.hasCreate) {
/* 112 */       return this;
/*     */     }
/* 114 */     this.hasCreate = true;
/*     */     
/* 116 */     if (this.fields == null || this.fields.isEmpty()) {
/* 117 */       return this;
/*     */     }
/*     */     
/* 120 */     String fieldsStr = StringUtils.join(this.fields, ",");
/* 121 */     addSql(fieldsStr, new Object[0]);
/* 122 */     addParams(this.params);
/* 123 */     this.fields.clear();
/* 124 */     this.params.clear();
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public StringBuilder getSql() {
/* 130 */     createSql();
/* 131 */     return super.getSql();
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/InsertFields.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */