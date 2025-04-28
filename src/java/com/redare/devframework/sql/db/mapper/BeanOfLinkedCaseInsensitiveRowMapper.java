/*    */ package com.redare.devframework.sql.db.mapper;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.ResultSetMetaData;
/*    */ import java.sql.SQLException;
/*    */ import org.springframework.beans.BeanUtils;
/*    */ import org.springframework.jdbc.core.RowMapper;
/*    */ import org.springframework.jdbc.support.JdbcUtils;
/*    */ import org.springframework.util.LinkedCaseInsensitiveMap;
/*    */ 
/*    */ public class BeanOfLinkedCaseInsensitiveRowMapper<T extends LinkedCaseInsensitiveMap>
/*    */   implements RowMapper<LinkedCaseInsensitiveMap>
/*    */ {
/*    */   private Class<T> type;
/*    */   
/*    */   public BeanOfLinkedCaseInsensitiveRowMapper(Class<T> type) {
/* 18 */     this.type = type;
/*    */   }
/*    */ 
/*    */   
/*    */   public LinkedCaseInsensitiveMap mapRow(ResultSet rs, int rowNum) throws SQLException {
/* 23 */     ResultSetMetaData rsmd = rs.getMetaData();
/* 24 */     int columnCount = rsmd.getColumnCount();
/* 25 */     LinkedCaseInsensitiveMap mapOfColValues = createColumnMap(columnCount);
/* 26 */     for (int i = 1; i <= columnCount; i++) {
/* 27 */       String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
/* 28 */       Object obj = getColumnValue(rs, i);
/* 29 */       mapOfColValues.put(key, obj);
/*    */     } 
/* 31 */     return mapOfColValues;
/*    */   }
/*    */   protected LinkedCaseInsensitiveMap createColumnMap(int columnCount) {
/*    */     LinkedCaseInsensitiveMap map;
/* 35 */     Constructor<T> constructor = null;
/*    */     try {
/* 37 */       constructor = this.type.getConstructor(new Class[] { int.class });
/* 38 */     } catch (NoSuchMethodException noSuchMethodException) {}
/*    */ 
/*    */     
/* 41 */     if (constructor == null) {
/* 42 */       map = (LinkedCaseInsensitiveMap)BeanUtils.instantiate(this.type);
/*    */     } else {
/* 44 */       map = (LinkedCaseInsensitiveMap)BeanUtils.instantiateClass(constructor, new Object[] { Integer.valueOf(columnCount) });
/*    */     } 
/* 46 */     return map;
/*    */   }
/*    */   
/*    */   protected String getColumnKey(String columnName) {
/* 50 */     return columnName;
/*    */   }
/*    */   
/*    */   protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
/* 54 */     return JdbcUtils.getResultSetValue(rs, index);
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/db/mapper/BeanOfLinkedCaseInsensitiveRowMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */