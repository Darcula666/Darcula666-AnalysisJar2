/*    */ package com.redare.devframework.sql.db;
/*    */ 
/*    */ import com.redare.devframework.common.pojo.Page;
/*    */ import com.redare.devframework.sql.db.base.SpringJdbcHelper;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class MySqlJdbcHelper
/*    */   extends SpringJdbcHelper
/*    */ {
/*    */   public Number insertReturnFieldNumber(String sql, Object[] params) {
/* 13 */     return insertReturnFieldNumber(sql, params, "generated_key");
/*    */   }
/*    */   
/*    */   public <T> Page<T> queryForPageBean(String sql, Class<T> type, Object[] params, int curPage, int pageSize, boolean calCount, boolean allList, boolean cutSql) {
/*    */     List<T> resultList;
/* 18 */     Page<T> page = new Page();
/* 19 */     if (allList) {
/* 20 */       List<T> list = queryForListBean(sql, type, params);
/* 21 */       if (list != null) {
/* 22 */         page.setTotalCount(list.size());
/*    */       }
/* 24 */       page.setCurPage(curPage);
/* 25 */       page.setPageSize(pageSize);
/* 26 */       page.setResult(list);
/* 27 */       return page;
/*    */     } 
/* 29 */     if (calCount) {
/*    */       String totalSql;
/* 31 */       if (cutSql) {
/* 32 */         totalSql = String.format("select count(*) from %s ", new Object[] { cutCountSql(sql) });
/*    */       } else {
/* 34 */         totalSql = String.format("select count(*) from ( %s ) a", new Object[] { sql });
/*    */       } 
/* 36 */       printSql(totalSql);
/* 37 */       Integer count = (Integer)getJdbcTemplate().queryForObject(totalSql, Integer.class, params);
/* 38 */       page.setTotalCount(count.intValue());
/*    */     } 
/* 40 */     String pageSql = String.format(" %s limit %s,%s", new Object[] { sql, Integer.valueOf((curPage - 1) * pageSize), Integer.valueOf(pageSize) });
/*    */     
/* 42 */     if (type == Map.class) {
/* 43 */       resultList = queryForListMap(pageSql, params);
/*    */     } else {
/* 45 */       resultList = queryForListBean(pageSql, type, params);
/*    */     } 
/* 47 */     page.setResult(resultList);
/* 48 */     page.setCurPage(curPage);
/* 49 */     page.setPageSize(pageSize);
/* 50 */     return page;
/*    */   }
/*    */   
/*    */   public <T> List<T> queryForListBean(String sql, Class<T> type, Object[] params, int curPage, int pageSize) {
/*    */     List<T> resultList;
/* 55 */     String pageSql = String.format(" %s limit %s,%s", new Object[] { sql, Integer.valueOf((curPage - 1) * pageSize), Integer.valueOf(pageSize) });
/*    */     
/* 57 */     if (type == Map.class) {
/* 58 */       resultList = queryForListMap(pageSql, params);
/*    */     } else {
/* 60 */       resultList = queryForListBean(pageSql, type, params);
/*    */     } 
/* 62 */     return resultList;
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/db/MySqlJdbcHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */