/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.lang.time.DateFormatUtils;
/*     */ 
/*     */ public class BaseSql
/*     */   implements Sql
/*     */ {
/*  16 */   private static final Pattern debugPattern = Pattern.compile("\\?");
/*     */   
/*     */   private final StringBuilder sqlBuilder;
/*     */   private final List<Object> sqlParams;
/*     */   
/*     */   public BaseSql() {
/*  22 */     this.sqlBuilder = new StringBuilder();
/*  23 */     this.sqlParams = new ArrayList();
/*     */   }
/*     */   
/*     */   public BaseSql(String sql, Object... params) {
/*  27 */     this();
/*  28 */     addSql(sql, params);
/*     */   }
/*     */   
/*     */   public BaseSql(String sql, List<Object> params) {
/*  32 */     this();
/*  33 */     addSql(sql, params);
/*     */   }
/*     */   
/*     */   public BaseSql(Sql sql) {
/*  37 */     this.sqlBuilder = sql.getSql();
/*  38 */     this.sqlParams = sql.getParams();
/*     */   }
/*     */   
/*     */   public StringBuilder getSql() {
/*  42 */     return this.sqlBuilder;
/*     */   }
/*     */   
/*     */   public List<Object> getParams() {
/*  46 */     return this.sqlParams;
/*     */   }
/*     */ 
/*     */   
/*     */   public String debugSql() {
/*  51 */     String sql = toString();
/*  52 */     if (CollectionUtils.isEmpty(this.sqlParams)) {
/*  53 */       return sql;
/*     */     }
/*     */     
/*  56 */     StringBuffer newContent = new StringBuffer();
/*     */     
/*  58 */     Matcher matcher = debugPattern.matcher(sql);
/*  59 */     int i = 0;
/*  60 */     while (matcher.find() && 
/*  61 */       i < this.sqlParams.size()) {
/*     */ 
/*     */       
/*  64 */       Object value = this.sqlParams.get(i);
/*  65 */       if (value == null) {
/*  66 */         matcher.appendReplacement(newContent, "null");
/*  67 */       } else if (value instanceof Number) {
/*  68 */         matcher.appendReplacement(newContent, value.toString());
/*  69 */       } else if (value instanceof Boolean) {
/*  70 */         matcher.appendReplacement(newContent, String.valueOf(((Boolean)value).booleanValue() ? 1 : 0));
/*  71 */       } else if (value instanceof Date) {
/*  72 */         matcher.appendReplacement(newContent, String.format("'%s'", new Object[] { DateFormatUtils.format((Date)value, "yyyy-MM-dd HH:mm:ss") }));
/*     */       } else {
/*  74 */         matcher.appendReplacement(newContent, String.format("'%s'", new Object[] { value }));
/*     */       } 
/*  76 */       i++;
/*     */     } 
/*  78 */     matcher.appendTail(newContent);
/*  79 */     return newContent.toString();
/*     */   }
/*     */   
/*     */   protected BaseSql addSql(String sql, List<Object> params) {
/*  83 */     return addSqlIf(true, sql, params);
/*     */   }
/*     */   
/*     */   protected BaseSql addSql(String sql, Object... params) {
/*  87 */     return addSqlIf(true, sql, params);
/*     */   }
/*     */   
/*     */   protected BaseSql addSqlIf(boolean bool, String sql, List<Object> params) {
/*  91 */     if (!bool || StringUtils.isBlank(sql)) {
/*  92 */       return this;
/*     */     }
/*  94 */     if (this.sqlBuilder.length() != 0) {
/*  95 */       this.sqlBuilder.append(" ");
/*     */     }
/*  97 */     this.sqlBuilder.append(sql);
/*  98 */     addParams(params);
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   protected BaseSql addSqlIf(boolean bool, String sql, Object... params) {
/* 103 */     if (!bool || StringUtils.isBlank(sql)) {
/* 104 */       return this;
/*     */     }
/* 106 */     if (this.sqlBuilder.length() != 0) {
/* 107 */       this.sqlBuilder.append(" ");
/*     */     }
/* 109 */     this.sqlBuilder.append(sql);
/* 110 */     addParams(params);
/* 111 */     return this;
/*     */   }
/*     */   
/*     */   protected BaseSql addSqlIf(boolean bool, Sql sql) {
/* 115 */     StringBuilder builder = sql.getSql();
/* 116 */     if (builder == null) {
/* 117 */       return this;
/*     */     }
/* 119 */     return addSqlIf(bool, builder.toString(), sql.getParams());
/*     */   }
/*     */   
/*     */   protected BaseSql addSql(Sql sql) {
/* 123 */     StringBuilder builder = sql.getSql();
/* 124 */     if (builder == null) {
/* 125 */       return this;
/*     */     }
/* 127 */     return addSql(builder.toString(), sql.getParams());
/*     */   }
/*     */   
/*     */   protected BaseSql addParams(List<Object> params) {
/* 131 */     if (CollectionUtils.isNotEmpty(params)) {
/* 132 */       this.sqlParams.addAll(params);
/*     */     }
/* 134 */     return this;
/*     */   }
/*     */   
/*     */   protected BaseSql addParams(Object... params) {
/* 138 */     if (ArrayUtils.isNotEmpty(params)) {
/* 139 */       for (Object v : params) {
/* 140 */         this.sqlParams.add(v);
/*     */       }
/*     */     }
/* 143 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 148 */     return getSql().toString();
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/BaseSql.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */