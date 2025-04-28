/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import com.redare.devframework.sql.lazy.LazyParam;
/*     */ import com.redare.devframework.sql.lazy.LazySql;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ public class Select
/*     */   extends BaseSql
/*     */ {
/*     */   private final List<String> fieldList;
/*     */   private boolean hasCreate = false;
/*     */   
/*     */   protected Select() {
/*  20 */     this.fieldList = new ArrayList<>();
/*  21 */     addSql("select", new Object[0]);
/*     */   }
/*     */   
/*     */   protected Select(Sql sql) {
/*  25 */     super(sql);
/*  26 */     this.fieldList = new ArrayList<>();
/*  27 */     addSql("select", new Object[0]);
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
/*     */ 
/*     */   
/*     */   public Select timeStatusField(String timeField1, String timeField2, String alias) {
/*  42 */     return field(String.format("case when now() < %s then 0 when now() between %s and %s then 1 else 2 end", new Object[] { timeField1, timeField1, timeField2 }), alias);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public Select timeStatusFieldIf(boolean bool, String timeField1, String timeField2, String alias) {
/*  58 */     if (!bool) {
/*  59 */       return this;
/*     */     }
/*  61 */     return timeStatusField(timeField1, timeField2, alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Select field(String field) {
/*  72 */     return field(field, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Select field(String field, String alias) {
/*  83 */     return field(field, alias, (Object[])null);
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
/*     */   public Select field(String field, String alias, Object... params) {
/*  95 */     if (StringUtils.isBlank(field)) {
/*  96 */       return this;
/*     */     }
/*  98 */     if (StringUtils.isBlank(alias)) {
/*  99 */       this.fieldList.add(field);
/*     */     } else {
/* 101 */       this.fieldList.add(String.format("%s as %s", new Object[] { field, alias }));
/*     */     } 
/* 103 */     addParams(params);
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Select field(Sql sql, String alias) {
/* 115 */     if (sql == null || StringUtils.isBlank(alias)) {
/* 116 */       return this;
/*     */     }
/* 118 */     this.fieldList.add(String.format("(%s) as %s", new Object[] { sql.toString(), alias }));
/* 119 */     addParams(sql.getParams());
/* 120 */     return this;
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
/*     */   public Select fieldIf(boolean bool, String field) {
/* 132 */     if (!bool) {
/* 133 */       return this;
/*     */     }
/* 135 */     return field(field);
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
/*     */   public Select fieldIf(boolean bool, String field, String alias) {
/* 147 */     if (!bool) {
/* 148 */       return this;
/*     */     }
/* 150 */     return field(field, alias);
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
/*     */   public Select fieldIf(boolean bool, String field, String alias, Object... params) {
/* 162 */     if (!bool) {
/* 163 */       return this;
/*     */     }
/* 165 */     return field(field, alias, params);
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
/*     */   public Select fieldIf(boolean bool, LazySql<Sql> lazySql, String alias) {
/* 177 */     if (!bool || lazySql == null) {
/* 178 */       return this;
/*     */     }
/* 180 */     return field(lazySql.getSql(), alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Select fields(String... fields) {
/* 190 */     if (ArrayUtils.isEmpty((Object[])fields)) {
/* 191 */       return this;
/*     */     }
/* 193 */     for (String field : fields) {
/* 194 */       this.fieldList.add(field);
/*     */     }
/* 196 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Select fields(List<String> fields) {
/* 206 */     if (CollectionUtils.isEmpty(fields)) {
/* 207 */       return this;
/*     */     }
/* 209 */     for (String field : fields) {
/* 210 */       this.fieldList.add(field);
/*     */     }
/* 212 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Select fields(Set<String> fields) {
/* 222 */     if (CollectionUtils.isEmpty(fields)) {
/* 223 */       return this;
/*     */     }
/* 225 */     for (String field : fields) {
/* 226 */       this.fieldList.add(field);
/*     */     }
/* 228 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Select fieldsIf(boolean bool, String... fields) {
/* 239 */     if (!bool) {
/* 240 */       return this;
/*     */     }
/* 242 */     return fields(fields);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Select fieldsIf(boolean bool, List<String> fields) {
/* 253 */     if (!bool) {
/* 254 */       return this;
/*     */     }
/* 256 */     return fields(fields);
/*     */   }
/*     */   
/*     */   public Select fieldsIfElse(boolean bool, List<String> trueField, List<String> failFields) {
/* 260 */     if (bool) {
/* 261 */       return fields(trueField);
/*     */     }
/* 263 */     return fields(failFields);
/*     */   }
/*     */ 
/*     */   
/*     */   public Select fieldsIfElse(boolean bool, List<String> trueField, String... failFields) {
/* 268 */     if (bool) {
/* 269 */       return fields(trueField);
/*     */     }
/* 271 */     return fields(failFields);
/*     */   }
/*     */ 
/*     */   
/*     */   public Select fieldsIfElse(boolean bool, LazyParam<List<String>> trueField, String... failFields) {
/* 276 */     if (bool) {
/* 277 */       return fields((List<String>)trueField.getParam());
/*     */     }
/* 279 */     return fields(failFields);
/*     */   }
/*     */ 
/*     */   
/*     */   public Select fieldsIfElse(boolean bool, LazyParam<List<String>> trueField, LazyParam<List<String>> failField) {
/* 284 */     if (bool) {
/* 285 */       return fields((List<String>)trueField.getParam());
/*     */     }
/* 287 */     return fields((List<String>)failField.getParam());
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
/*     */   public Select fieldsIf(boolean bool, Set<String> fields) {
/* 299 */     if (!bool) {
/* 300 */       return this;
/*     */     }
/* 302 */     return fields(fields);
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
/*     */   public Select paramAsField(Object params, String alias) {
/* 314 */     if (StringUtils.isBlank(alias)) {
/* 315 */       return this;
/*     */     }
/* 317 */     this.fieldList.add(String.format("? as %s", new Object[] { alias }));
/* 318 */     addParams(new Object[] { params });
/* 319 */     return this;
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
/*     */   public Select paramAsFieldIf(boolean bool, Object params, String alias) {
/* 331 */     if (!bool) {
/* 332 */       return this;
/*     */     }
/* 334 */     return paramAsField(params, alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public From from(String table) {
/* 344 */     return from(table, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public From from(String table, String alias) {
/* 355 */     return new From(this, table, alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public From from(Sql sql, String alias) {
/* 366 */     return new From(this, sql, alias);
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
/*     */   public From fromIf(boolean bool, String table1, String table2) {
/* 378 */     return fromIf(bool, table1, table2, (String)null);
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
/*     */   public From fromIf(boolean bool, String table1, String table2, String alias) {
/* 391 */     if (bool) {
/* 392 */       return new From(this, table1, alias);
/*     */     }
/* 394 */     return new From(this, table2, alias);
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
/*     */   
/*     */   public From fromIf(boolean bool, LazySql<Sql> table1, LazySql<Sql> table2, String alias) {
/* 408 */     if (bool) {
/* 409 */       return new From(this, table1.getSql(), alias);
/*     */     }
/* 411 */     return new From(this, table2.getSql(), alias);
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
/*     */   
/*     */   public From fromIf(boolean bool, String table1, LazySql<Sql> table2, String alias) {
/* 425 */     if (bool) {
/* 426 */       return new From(this, table1, alias);
/*     */     }
/* 428 */     return new From(this, table2.getSql(), alias);
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
/*     */   
/*     */   public From fromIf(boolean bool, LazySql<Sql> table1, String table2, String alias) {
/* 442 */     if (bool) {
/* 443 */       return new From(this, table1.getSql(), alias);
/*     */     }
/* 445 */     return new From(this, table2, alias);
/*     */   }
/*     */ 
/*     */   
/*     */   private Select createSql() {
/* 450 */     if (this.hasCreate) {
/* 451 */       return this;
/*     */     }
/* 453 */     if (this.fieldList == null || this.fieldList.isEmpty()) {
/* 454 */       addSql("*", new Object[0]);
/*     */     } else {
/* 456 */       addSql(StringUtils.join(this.fieldList, ","), new Object[0]);
/* 457 */       this.fieldList.clear();
/*     */     } 
/* 459 */     this.hasCreate = true;
/* 460 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public StringBuilder getSql() {
/* 465 */     createSql();
/* 466 */     return super.getSql();
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Select.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */