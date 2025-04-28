/*    */ package com.redare.devframework.sql.db.mapper;
/*    */ 
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.dao.DataAccessException;
/*    */ import org.springframework.jdbc.core.ResultSetExtractor;
/*    */ import org.springframework.jdbc.core.RowMapper;
/*    */ 
/*    */ public class QueryFilterRowMapperResultSetExtractor<T>
/*    */   implements ResultSetExtractor<List<T>> {
/*    */   private final List<T> results;
/*    */   private final Filter<T> filter;
/*    */   private final RowMapper<T> rowMapper;
/*    */   
/*    */   public QueryFilterRowMapperResultSetExtractor(Filter<T> filter, RowMapper<T> rowMapper) {
/* 18 */     this.rowMapper = rowMapper;
/* 19 */     this.results = new ArrayList<>();
/* 20 */     this.filter = filter;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<T> extractData(ResultSet rs) throws SQLException {
/* 25 */     int rowNum = 0;
/* 26 */     while (rs.next()) {
/* 27 */       T t = (T)this.rowMapper.mapRow(rs, rowNum++);
/* 28 */       if (this.filter.isNeedThisData(t)) {
/* 29 */         this.results.add(t);
/*    */       }
/* 31 */       if (!this.filter.resultSetNext()) {
/*    */         break;
/*    */       }
/*    */     } 
/* 35 */     return this.results;
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/db/mapper/QueryFilterRowMapperResultSetExtractor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */