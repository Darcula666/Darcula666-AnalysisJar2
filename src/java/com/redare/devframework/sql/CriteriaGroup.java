/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CriteriaGroup
/*     */   extends BaseSql
/*     */ {
/*     */   private boolean isCreate = false;
/*     */   private final String op;
/*     */   private Sql[] sqlArray;
/*     */   private String[] strArray;
/*     */   
/*     */   public static CriteriaGroup and(Sql... sqls) {
/*  19 */     return new CriteriaGroup("and", sqls);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CriteriaGroup and(String... sqls) {
/*  29 */     return new CriteriaGroup("and", sqls);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CriteriaGroup or(Sql... sqls) {
/*  39 */     return new CriteriaGroup("or", sqls);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CriteriaGroup or(String... sqls) {
/*  50 */     return new CriteriaGroup("or", sqls);
/*     */   }
/*     */   
/*     */   private CriteriaGroup(String op, Sql... sqls) {
/*  54 */     this.op = op;
/*  55 */     this.sqlArray = sqls;
/*     */   }
/*     */   
/*     */   private CriteriaGroup(String op, String... sqls) {
/*  59 */     this.op = op;
/*  60 */     this.strArray = sqls;
/*     */   }
/*     */   
/*     */   public StringBuilder getSql() {
/*  64 */     if (this.isCreate) {
/*  65 */       return super.getSql();
/*     */     }
/*  67 */     this.isCreate = true;
/*     */     
/*  69 */     if (ArrayUtils.isEmpty((Object[])this.strArray) && ArrayUtils.isEmpty((Object[])this.sqlArray)) {
/*  70 */       return super.getSql();
/*     */     }
/*     */     
/*  73 */     if (ArrayUtils.isNotEmpty((Object[])this.strArray)) {
/*  74 */       if (this.strArray.length == 1) {
/*  75 */         addSql(this.strArray[0], new Object[0]);
/*  76 */         return super.getSql();
/*     */       } 
/*  78 */       addSql("(", new Object[0]);
/*  79 */       for (int i = 0; i < this.strArray.length; i++) {
/*  80 */         if (i > 0) {
/*  81 */           addSql(this.op, new Object[0]);
/*     */         }
/*  83 */         addSql(this.strArray[i], new Object[0]);
/*     */       } 
/*  85 */       addSql(")", new Object[0]);
/*  86 */     } else if (ArrayUtils.isNotEmpty((Object[])this.sqlArray)) {
/*  87 */       if (this.sqlArray.length == 1) {
/*  88 */         Sql sql = this.sqlArray[0];
/*  89 */         addSql(sql);
/*  90 */         return super.getSql();
/*     */       } 
/*  92 */       addSql("(", new Object[0]);
/*  93 */       for (int i = 0; i < this.sqlArray.length; i++) {
/*  94 */         if (i > 0) {
/*  95 */           addSql(this.op, new Object[0]);
/*     */         }
/*  97 */         Sql sql = this.sqlArray[i];
/*  98 */         addSql(sql);
/*     */       } 
/* 100 */       addSql(")", new Object[0]);
/*     */     } 
/* 102 */     return super.getSql();
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/CriteriaGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */