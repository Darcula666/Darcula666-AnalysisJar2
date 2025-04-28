/*    */ package com.redare.devframework.sql.db;
/*    */ import com.redare.devframework.common.pojo.Page;
/*    */ import com.redare.devframework.sql.db.base.SpringJdbcHelper;
/*    */ import java.sql.Connection;
/*    */ import java.sql.Date;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.jdbc.support.GeneratedKeyHolder;
/*    */ 
/*    */ public class OracleJdbcHelper extends SpringJdbcHelper {
/*    */   public Map<String, Object> insertReturnFields(String sql, Object[] params, String[] fields) {
/* 15 */     GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
/* 16 */     getJdbcTemplate().update(con -> { PreparedStatement ps = con.prepareStatement(sql, fields); if (params != null && params.length > 0) for (int i = 0; i < params.length; i++) { if (params[i] instanceof Date) { ps.setObject(i + 1, new Date(((Date)params[i]).getTime())); } else { ps.setObject(i + 1, params[i]); }  }   return ps; }(KeyHolder)keyHolder);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     return keyHolder.getKeys();
/*    */   }
/*    */ 
/*    */   
/*    */   public Number insertReturnFieldNumber(String sql, Object[] params) {
/* 34 */     return insertReturnFieldNumber(sql, params, "id");
/*    */   }
/*    */   
/*    */   public <T> Page<T> queryForPageBean(String sql, Class<T> type, Object[] params, int curPage, int pageSize, boolean calCount, boolean allList, boolean cutSql) {
/*    */     List<T> resultList;
/* 39 */     Page<T> page = new Page();
/*    */     
/* 41 */     if (allList) {
/* 42 */       List<T> list = queryForListBean(sql, type, params);
/* 43 */       if (list != null) {
/* 44 */         page.setTotalCount(list.size());
/*    */       }
/* 46 */       page.setCurPage(curPage);
/* 47 */       page.setPageSize(pageSize);
/* 48 */       page.setResult(list);
/* 49 */       return page;
/*    */     } 
/* 51 */     if (calCount) {
/*    */       String totalSql;
/* 53 */       if (cutSql) {
/* 54 */         totalSql = String.format("select count(*) from %s ", new Object[] { cutCountSql(sql) });
/*    */       } else {
/* 56 */         totalSql = String.format("select count(*) from ( %s ) a", new Object[] { sql });
/*    */       } 
/* 58 */       printSql(totalSql);
/* 59 */       Integer count = (Integer)getJdbcTemplate().queryForObject(totalSql, Integer.class, params);
/* 60 */       page.setTotalCount(count.intValue());
/*    */     } 
/* 62 */     String pageSql = String.format("select * from (select a.*,rownum rn from (  %s ) a where rownum <= %s ) a where rn > %s ", new Object[] { sql, 
/*    */           
/* 64 */           Integer.valueOf(curPage * pageSize), Integer.valueOf((curPage - 1) * pageSize) });
/*    */     
/* 66 */     if (type == Map.class) {
/* 67 */       resultList = queryForListMap(pageSql, params);
/*    */     } else {
/* 69 */       resultList = queryForListBean(pageSql, type, params);
/*    */     } 
/* 71 */     page.setResult(resultList);
/* 72 */     page.setCurPage(curPage);
/* 73 */     page.setPageSize(pageSize);
/* 74 */     return page;
/*    */   }
/*    */   
/*    */   public <T> List<T> queryForListBean(String sql, Class<T> type, Object[] params, int curPage, int pageSize) {
/*    */     List<T> resultList;
/* 79 */     String pageSql = String.format("select * from (select a.*,rownum rn from (  %s ) a where rownum <= %s ) a where rn > %s ", new Object[] { sql, 
/*    */           
/* 81 */           Integer.valueOf(curPage * pageSize), Integer.valueOf((curPage - 1) * pageSize) });
/*    */     
/* 83 */     if (type == Map.class) {
/* 84 */       resultList = queryForListMap(pageSql, params);
/*    */     } else {
/* 86 */       resultList = queryForListBean(pageSql, type, params);
/*    */     } 
/* 88 */     return resultList;
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/db/OracleJdbcHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */