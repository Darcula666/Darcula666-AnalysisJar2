/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Sql
/*     */ {
/*     */   StringBuilder getSql();
/*     */   
/*     */   List<Object> getParams();
/*     */   
/*     */   String debugSql();
/*     */   
/*     */   static BaseSql sql(Sql sql) {
/*  35 */     return new BaseSql(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static BaseSql sql(String sql) {
/*  45 */     return new BaseSql(sql, new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static BaseSql sql(String sql, Object... params) {
/*  56 */     return new BaseSql(sql, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static BaseSql sql(String sql, List<Object> params) {
/*  67 */     return new BaseSql(sql, params);
/*     */   }
/*     */   
/*     */   static Select select() {
/*  71 */     return new Select();
/*     */   }
/*     */   
/*     */   static Select selectCount() {
/*  75 */     return (new Select()).field("count(*)");
/*     */   }
/*     */   
/*     */   static Select selectCount(String field) {
/*  79 */     return (new Select()).field(String.format("count(%s)", new Object[] { field }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Update update(String table) {
/*  89 */     return new Update(table);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Delete delete(String table) {
/*  99 */     return new Delete(table);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Insert insert(String table) {
/* 109 */     return new Insert(table);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static BaseSql union(Sql... sqls) {
/* 119 */     BaseSql baseSql = new BaseSql();
/* 120 */     int i = 0;
/* 121 */     for (Sql sql : sqls) {
/* 122 */       if (i > 0) {
/* 123 */         baseSql.addSql("union", new Object[0]);
/*     */       }
/* 125 */       baseSql.addSql(sql);
/* 126 */       i++;
/*     */     } 
/* 128 */     return baseSql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static BaseSql union(List<Sql> list) {
/* 138 */     BaseSql baseSql = new BaseSql();
/* 139 */     int i = 0;
/* 140 */     for (Sql sql : list) {
/* 141 */       if (i > 0) {
/* 142 */         baseSql.addSql("union", new Object[0]);
/*     */       }
/* 144 */       baseSql.addSql(sql);
/* 145 */       i++;
/*     */     } 
/* 147 */     return baseSql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static BaseSql unionAll(Sql... sqls) {
/* 157 */     BaseSql baseSql = new BaseSql();
/* 158 */     int i = 0;
/* 159 */     for (Sql sql : sqls) {
/* 160 */       if (i > 0) {
/* 161 */         baseSql.addSql("union all", new Object[0]);
/*     */       }
/* 163 */       baseSql.addSql(sql);
/* 164 */       i++;
/*     */     } 
/* 166 */     return baseSql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static BaseSql unionAll(List<Sql> list) {
/* 176 */     BaseSql baseSql = new BaseSql();
/* 177 */     int i = 0;
/* 178 */     for (Sql sql : list) {
/* 179 */       if (i > 0) {
/* 180 */         baseSql.addSql("union all", new Object[0]);
/*     */       }
/* 182 */       baseSql.addSql(sql);
/* 183 */       i++;
/*     */     } 
/* 185 */     return baseSql;
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Sql.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */