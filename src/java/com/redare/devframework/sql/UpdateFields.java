/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import com.redare.devframework.sql.lazy.LazyParam;
/*     */ import com.redare.devframework.sql.lazy.LazySql;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ public class UpdateFields
/*     */   extends BaseSql
/*     */ {
/*     */   private List<String> fields;
/*     */   private boolean hasCreate = false;
/*     */   
/*     */   protected UpdateFields() {
/*  18 */     this.fields = new ArrayList<>();
/*     */   }
/*     */   
/*     */   private UpdateFields createSql() {
/*  22 */     if (this.hasCreate) {
/*  23 */       return this;
/*     */     }
/*  25 */     this.hasCreate = true;
/*  26 */     if (this.fields == null || this.fields.isEmpty()) {
/*  27 */       return this;
/*     */     }
/*  29 */     addSql(StringUtils.join(this.fields, ","), new Object[0]);
/*  30 */     this.fields.clear();
/*  31 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields add(String field, Number number) {
/*  35 */     return setSelf(field, "+", number);
/*     */   }
/*     */   
/*     */   public UpdateFields sub(String field, Number number) {
/*  39 */     return setSelf(field, "-", number);
/*     */   }
/*     */   
/*     */   public UpdateFields multi(String field, Number number) {
/*  43 */     return setSelf(field, "*", number);
/*     */   }
/*     */   
/*     */   public UpdateFields div(String field, Number number) {
/*  47 */     return setSelf(field, "/", number);
/*     */   }
/*     */   
/*     */   public UpdateFields addIf(boolean bool, String field, Number number) {
/*  51 */     if (!bool) {
/*  52 */       return this;
/*     */     }
/*  54 */     return add(field, number);
/*     */   }
/*     */   
/*     */   public UpdateFields subIf(boolean bool, String field, Number number) {
/*  58 */     if (!bool) {
/*  59 */       return this;
/*     */     }
/*  61 */     return sub(field, number);
/*     */   }
/*     */   
/*     */   public UpdateFields multiIf(boolean bool, String field, Number number) {
/*  65 */     if (!bool) {
/*  66 */       return this;
/*     */     }
/*  68 */     return multi(field, number);
/*     */   }
/*     */   
/*     */   public UpdateFields divIf(boolean bool, String field, Number number) {
/*  72 */     if (!bool) {
/*  73 */       return this;
/*     */     }
/*  75 */     return div(field, number);
/*     */   }
/*     */   
/*     */   public UpdateFields addIf(boolean bool, String field, LazyParam<Number> lazyParam) {
/*  79 */     if (!bool) {
/*  80 */       return this;
/*     */     }
/*  82 */     return add(field, (Number)lazyParam.getParam());
/*     */   }
/*     */   
/*     */   public UpdateFields subIf(boolean bool, String field, LazyParam<Number> lazyParam) {
/*  86 */     if (!bool) {
/*  87 */       return this;
/*     */     }
/*  89 */     return sub(field, (Number)lazyParam.getParam());
/*     */   }
/*     */   
/*     */   public UpdateFields multiIf(boolean bool, String field, LazyParam<Number> lazyParam) {
/*  93 */     if (!bool) {
/*  94 */       return this;
/*     */     }
/*  96 */     return multi(field, (Number)lazyParam.getParam());
/*     */   }
/*     */   
/*     */   public UpdateFields divIf(boolean bool, String field, LazyParam<Number> lazyParam) {
/* 100 */     if (!bool) {
/* 101 */       return this;
/*     */     }
/* 103 */     return div(field, (Number)lazyParam.getParam());
/*     */   }
/*     */   
/*     */   public UpdateFields setIfNotNull(String field, Object params) {
/* 107 */     return setIf((params != null), field, params);
/*     */   }
/*     */   
/*     */   public UpdateFields setIfNotNull(String field, Object params, LazyParam lazyParam) {
/* 111 */     return setIf((params != null), field, lazyParam);
/*     */   }
/*     */   
/*     */   public UpdateFields setIfNotBlank(String field, String params) {
/* 115 */     return setIf(StringUtils.isNotBlank(params), field, params);
/*     */   }
/*     */   
/*     */   public UpdateFields setIfElse(String field, boolean bool, LazySql trueSql, LazySql falseSql) {
/* 119 */     if (bool) {
/* 120 */       set(field, trueSql.getSql());
/*     */     } else {
/* 122 */       set(field, falseSql.getSql());
/*     */     } 
/* 124 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields setIfElse(String field, boolean bool, Object params1, LazyParam lazyParam) {
/* 128 */     if (bool) {
/* 129 */       set(field, params1);
/*     */     } else {
/* 131 */       set(field, lazyParam.getParam());
/*     */     } 
/* 133 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields setIfElse(String field, boolean bool, Object params1, Object params2) {
/* 137 */     if (bool) {
/* 138 */       set(field, params1);
/*     */     } else {
/* 140 */       set(field, params2);
/*     */     } 
/* 142 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields setIf(boolean bool, String field, Object params) {
/* 146 */     if (!bool) {
/* 147 */       return this;
/*     */     }
/* 149 */     return set(field, params);
/*     */   }
/*     */   
/*     */   public UpdateFields setIf(boolean bool, String field, LazyParam lazyParam) {
/* 153 */     if (!bool) {
/* 154 */       return this;
/*     */     }
/* 156 */     return set(field, lazyParam.getParam());
/*     */   }
/*     */   
/*     */   public UpdateFields setIf(boolean bool, String field) {
/* 160 */     if (!bool) {
/* 161 */       return this;
/*     */     }
/* 163 */     return set(field);
/*     */   }
/*     */   
/*     */   public UpdateFields set(List<String> fields) {
/* 167 */     if (CollectionUtils.isEmpty(fields)) {
/* 168 */       return this;
/*     */     }
/* 170 */     fields.forEach(field -> set(field));
/*     */ 
/*     */     
/* 173 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields set(String... fields) {
/* 177 */     for (int i = 0; i < fields.length; i++) {
/* 178 */       set(fields[i]);
/*     */     }
/* 180 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields set(String field) {
/* 184 */     this.fields.add(String.format("%s = ?", new Object[] { field }));
/* 185 */     addParams(new Object[] { null });
/* 186 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields set(String field, Object params) {
/* 190 */     this.fields.add(String.format("%s = ?", new Object[] { field }));
/* 191 */     addParams(new Object[] { params });
/* 192 */     return this;
/*     */   }
/*     */   
/*     */   private UpdateFields setSelf(String field, String op, Object params) {
/* 196 */     this.fields.add(String.format("%s = %s %s ?", new Object[] { field, field, op }));
/* 197 */     addParams(new Object[] { params });
/* 198 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields setIf(boolean bool, String field, LazySql lazySql) {
/* 202 */     if (!bool) {
/* 203 */       return this;
/*     */     }
/* 205 */     return set(field, lazySql.getSql());
/*     */   }
/*     */   
/*     */   public UpdateFields set(String field, Sql sql) {
/* 209 */     StringBuilder sqlBuilder = sql.getSql();
/* 210 */     this.fields.add(String.format("%s = (%s)", new Object[] { field, sqlBuilder.toString() }));
/* 211 */     addParams(sql.getParams());
/* 212 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields set(UpdateFields update) {
/* 216 */     StringBuilder sqlBuilder = update.getSql();
/* 217 */     String sql = sqlBuilder.toString();
/* 218 */     if (StringUtils.isNotBlank(sql)) {
/* 219 */       this.fields.add(sql);
/* 220 */       addParams(update.getParams());
/*     */     } 
/* 222 */     return this;
/*     */   }
/*     */   
/*     */   public UpdateFields setIf(boolean bool, LazySql<UpdateFields> lazySql) {
/* 226 */     if (!bool) {
/* 227 */       return this;
/*     */     }
/* 229 */     return set((UpdateFields)lazySql.getSql());
/*     */   }
/*     */   
/*     */   public UpdateFields setIf(boolean bool, LazySql<UpdateFields> trueSql, LazySql<UpdateFields> falseSql) {
/* 233 */     return bool ? set((UpdateFields)trueSql.getSql()) : set((UpdateFields)falseSql.getSql());
/*     */   }
/*     */   
/*     */   public UpdateFields setIfNotNull(Object object, LazySql<UpdateFields> lazySql) {
/* 237 */     if (object == null) {
/* 238 */       return this;
/*     */     }
/* 240 */     return set((UpdateFields)lazySql.getSql());
/*     */   }
/*     */ 
/*     */   
/*     */   public StringBuilder getSql() {
/* 245 */     createSql();
/* 246 */     return super.getSql();
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/UpdateFields.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */