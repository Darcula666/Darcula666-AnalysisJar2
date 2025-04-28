/*     */ package com.redare.devframework.sql.db.base;
/*     */ import com.redare.devframework.common.pojo.Page;
/*     */ import com.redare.devframework.sql.Sql;
/*     */ import com.redare.devframework.sql.db.mapper.Filter;
/*     */ import com.redare.devframework.sql.db.mapper.QueryFilterRowMapperResultSetExtractor;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.springframework.dao.EmptyResultDataAccessException;
/*     */ import org.springframework.jdbc.core.BeanPropertyRowMapper;
/*     */ import org.springframework.jdbc.core.RowMapper;
/*     */ import org.springframework.jdbc.support.GeneratedKeyHolder;
/*     */ 
/*     */ public abstract class BaseJdbcDaoSupport extends JdbcDaoSupport {
/*  21 */   Logger logger = LoggerFactory.getLogger(BaseJdbcDaoSupport.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean printSql;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number insertReturnFieldNumber(Sql sql) {
/*  35 */     printSql(sql);
/*  36 */     return insertReturnFieldNumber(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number insertReturnFieldNumber(Sql sql, String field) {
/*  47 */     printSql(sql);
/*  48 */     return insertReturnFieldNumber(sql.toString(), sql.getParams().toArray(), field);
/*     */   }
/*     */   
/*     */   public Number insertReturnFieldNumber(String sql, Object[] params, String field) {
/*  52 */     return (Number)insertReturnField(sql, params, field);
/*     */   }
/*     */   
/*     */   public Object insertReturnField(String sql, Object[] params, String field) {
/*  56 */     Map<String, Object> fieldValue = insertReturnFields(sql, params, new String[] { field });
/*  57 */     return (fieldValue == null) ? null : fieldValue.get(field);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object insertReturnField(Sql sql, String field) {
/*  68 */     printSql(sql);
/*  69 */     return insertReturnField(sql.toString(), sql.getParams().toArray(), field);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Object> insertReturnFields(Sql sql, String[] fields) {
/*  80 */     printSql(sql);
/*  81 */     return insertReturnFields(sql.toString(), sql.getParams().toArray(), fields);
/*     */   }
/*     */   
/*     */   public Map<String, Object> insertReturnFields(String sql, Object[] params, String[] fields) {
/*  85 */     GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
/*  86 */     getJdbcTemplate().update(con -> { PreparedStatement ps = con.prepareStatement(sql, fields); if (params != null && params.length > 0) for (int i = 0; i < params.length; i++) ps.setObject(i + 1, params[i]);   return ps; }(KeyHolder)keyHolder);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     return keyHolder.getKeys();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int update(Sql sql) {
/* 105 */     printSql(sql);
/* 106 */     return update(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public int update(String sql) {
/* 110 */     return getJdbcTemplate().update(sql);
/*     */   }
/*     */   
/*     */   public int update(String sql, Object[] args) {
/* 114 */     return getJdbcTemplate().update(sql, args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int insert(Sql sql) {
/* 124 */     printSql(sql);
/* 125 */     return insert(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public int insert(String sql) {
/* 129 */     return getJdbcTemplate().update(sql);
/*     */   }
/*     */   
/*     */   public int insert(String sql, Object[] params) {
/* 133 */     return getJdbcTemplate().update(sql, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] batchUpdate(Sql sql, List<Object[]> argList) {
/* 144 */     printSql(sql);
/* 145 */     return batchUpdate(sql.toString(), argList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] batchUpdate(String sql, List<Object[]> argList) {
/* 156 */     return getJdbcTemplate().batchUpdate(sql, argList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long queryForNumber(Sql sql) {
/* 166 */     printSql(sql);
/* 167 */     return queryForNumber(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T queryForNumber(Sql sql, Class<T> type) {
/* 178 */     printSql(sql);
/* 179 */     return queryForNumber(sql.toString(), type, sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public Long queryForNumber(String sql, Object[] args) {
/* 183 */     return (Long)getJdbcTemplate().queryForObject(sql, args, Long.class);
/*     */   }
/*     */   
/*     */   public <T> T queryForNumber(String sql, Class<T> type, Object[] args) {
/* 187 */     return (T)getJdbcTemplate().queryForObject(sql, args, type);
/*     */   }
/*     */   
/*     */   public Long queryForNumber(String sql) {
/* 191 */     return (Long)getJdbcTemplate().queryForObject(sql, Long.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Object> queryForMap(Sql sql) {
/* 201 */     printSql(sql);
/* 202 */     return queryForMap(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public Map<String, Object> queryForMap(String sql, Object[] args) {
/*     */     try {
/* 207 */       return getJdbcTemplate().queryForMap(sql, args);
/* 208 */     } catch (EmptyResultDataAccessException e) {
/* 209 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map<String, Object> queryForMap(String sql) {
/*     */     try {
/* 215 */       return getJdbcTemplate().queryForMap(sql);
/* 216 */     } catch (EmptyResultDataAccessException e) {
/* 217 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public <T> T queryForBean(String sql, Class<T> type) {
/*     */     try {
/* 223 */       return (T)getJdbcTemplate().queryForObject(sql, (RowMapper)new BeanPropertyRowMapper(type));
/* 224 */     } catch (EmptyResultDataAccessException e) {
/* 225 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T queryForBean(Sql sql, Class<T> type) {
/* 237 */     printSql(sql);
/* 238 */     return queryForBean(sql.toString(), type, sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public <T> T queryForBean(String sql, Class<T> type, Object[] args) {
/*     */     try {
/* 243 */       if (type.getSuperclass() != null && 
/* 244 */         "org.springframework.util.LinkedCaseInsensitiveMap".equals(type.getSuperclass().getName())) {
/* 245 */         return (T)getJdbcTemplate().queryForObject(sql, (RowMapper)new BeanOfLinkedCaseInsensitiveRowMapper(type), args);
/*     */       }
/*     */       
/* 248 */       return (T)getJdbcTemplate().queryForObject(sql, (RowMapper)new BeanPropertyRowMapper(type), args);
/* 249 */     } catch (EmptyResultDataAccessException e) {
/* 250 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> queryForListMap(String sql) {
/* 255 */     return getJdbcTemplate().queryForList(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Map<String, Object>> queryForListMap(Sql sql) {
/* 265 */     printSql(sql);
/* 266 */     return queryForListMap(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> queryForListMap(String sql, Object[] args) {
/* 270 */     return getJdbcTemplate().queryForList(sql, args);
/*     */   }
/*     */   
/*     */   public <T> List<T> queryFilterListBean(Sql sql, Class<T> type, Filter<T> filter) {
/* 274 */     return queryFilterListBean(sql.toString(), type, sql.getParams().toArray(), filter);
/*     */   }
/*     */   
/*     */   public <T> List<T> queryFilterListBean(String sql, Class<T> type, Object[] params, Filter<T> filter) {
/* 278 */     return (List<T>)getJdbcTemplate().query(sql, params, (ResultSetExtractor)new QueryFilterRowMapperResultSetExtractor(filter, (RowMapper)new BeanPropertyRowMapper(type)));
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> queryFilterListMap(Sql sql, Filter<Map<String, Object>> filter) {
/* 282 */     return queryFilterListMap(sql.toString(), sql.getParams().toArray(), filter);
/*     */   }
/*     */   
/*     */   public List<Map<String, Object>> queryFilterListMap(String sql, Object[] params, Filter<Map<String, Object>> filter) {
/* 286 */     return (List<Map<String, Object>>)getJdbcTemplate().query(sql, params, (ResultSetExtractor)new QueryFilterRowMapperResultSetExtractor(filter, (RowMapper)new ColumnMapRowMapper()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> List<T> queryForListBean(Sql sql, Class<T> type) {
/* 297 */     printSql(sql);
/* 298 */     return queryForListBean(sql.toString(), type, sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public <T> List<T> queryForListBean(String sql, Class<T> type, Object[] args) {
/* 302 */     if ("org.springframework.util.LinkedCaseInsensitiveMap".equals(type.getSuperclass().getName())) {
/* 303 */       return queryForListBeanOfMap(sql, type, args);
/*     */     }
/* 305 */     return getJdbcTemplate().query(sql, (RowMapper)new BeanPropertyRowMapper(type), args);
/*     */   }
/*     */   
/*     */   public <T> List<T> queryForListBean(String sql, Class<T> type) {
/* 309 */     return getJdbcTemplate().query(sql, (RowMapper)new BeanPropertyRowMapper(type));
/*     */   }
/*     */   
/*     */   private <T> List<T> queryForListBeanOfMap(String sql, Class<T> type, Object[] args) {
/* 313 */     return getJdbcTemplate().query(sql, (RowMapper)new BeanOfLinkedCaseInsensitiveRowMapper(type), args);
/*     */   }
/*     */   
/*     */   public Page<Map> queryForPageMap(Sql sql, int curPage, int pageSize) {
/* 317 */     printSql(sql);
/* 318 */     return queryForPageMap(sql, curPage, pageSize, true, false, true);
/*     */   }
/*     */   
/*     */   public Page<Map> queryForPageMap(String sql, Object[] params, int curPage, int pageSize) {
/* 322 */     return queryForPageMap(sql, params, curPage, pageSize, true, false, true);
/*     */   }
/*     */   
/*     */   public Page<Map> queryForPageMap(Sql sql, int curPage, int pageSize, boolean calCount) {
/* 326 */     printSql(sql);
/* 327 */     return queryForPageMap(sql, curPage, pageSize, calCount, false, true);
/*     */   }
/*     */   
/*     */   public Page<Map> queryForPageMap(String sql, Object[] params, int curPage, int pageSize, boolean calCount) {
/* 331 */     return queryForPageMap(sql, params, curPage, pageSize, calCount, false, true);
/*     */   }
/*     */   
/*     */   public Page<Map> queryForPageMap(Sql sql, int curPage, int pageSize, boolean calCount, boolean allList) {
/* 335 */     printSql(sql);
/* 336 */     return queryForPageMap(sql, curPage, pageSize, calCount, allList, true);
/*     */   }
/*     */   
/*     */   public Page<Map> queryForPageMap(String sql, Object[] params, int curPage, int pageSize, boolean calCount, boolean allList) {
/* 340 */     return queryForPageMap(sql, params, curPage, pageSize, calCount, allList, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public Page<Map> queryForPageMap(Sql sql, int curPage, int pageSize, boolean calCount, boolean allList, boolean cutSql) {
/* 345 */     printSql(sql);
/* 346 */     return queryForPageBean(sql.toString(), Map.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList, cutSql);
/*     */   }
/*     */   
/*     */   public Page<Map> queryForPageMap(String sql, Object[] params, int curPage, int pageSize, boolean calCount, boolean allList, boolean cutSql) {
/* 350 */     return queryForPageBean(sql, Map.class, params, curPage, pageSize, calCount, allList, cutSql);
/*     */   }
/*     */   
/*     */   public <T> Page<T> queryForPageBean(String sql, Class<T> type, int curPage, int pageSize) {
/* 354 */     return queryForPageBean(sql, type, (Object[])null, curPage, pageSize);
/*     */   }
/*     */   
/*     */   public <T> Page<T> queryForPageBean(String sql, Class<T> type, int curPage, int pageSize, boolean calCount) {
/* 358 */     return queryForPageBean(sql, type, (Object[])null, curPage, pageSize, calCount);
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
/*     */   public <T> Page<T> queryForPageBean(Sql sql, Class<T> type, int curPage, int pageSize) {
/* 371 */     printSql(sql);
/* 372 */     return queryForPageBean(sql.toString(), type, sql.getParams().toArray(), curPage, pageSize);
/*     */   }
/*     */   
/*     */   public <T> Page<T> queryForPageBean(String sql, Object[] params, Class<T> type, int curPage, int pageSize) {
/* 376 */     return queryForPageBean(sql, type, params, curPage, pageSize);
/*     */   }
/*     */   
/*     */   public <T> Page<T> queryForPageBean(Sql sql, Class<T> type, int curPage, int pageSize, boolean calCount) {
/* 380 */     printSql(sql);
/* 381 */     return queryForPageBean(sql.toString(), type, sql.getParams().toArray(), curPage, pageSize, calCount);
/*     */   }
/*     */   
/*     */   public <T> Page<T> queryForPageBean(String sql, Object[] params, Class<T> type, int curPage, int pageSize, boolean calCount) {
/* 385 */     return queryForPageBean(sql, type, params, curPage, pageSize, calCount);
/*     */   }
/*     */   
/*     */   public <T> Page<T> queryForPageBean(String sql, Class<T> type, Object[] params, int curPage, int pageSize) {
/* 389 */     return queryForPageBean(sql, type, params, curPage, pageSize, true);
/*     */   }
/*     */   
/*     */   public <T> Page<T> queryForPageBean(String sql, Class<T> type, Object[] params, int curPage, int pageSize, boolean calCount) {
/* 393 */     return queryForPageBean(sql, type, params, curPage, pageSize, calCount, false);
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
/*     */   public <T> Page<T> queryForPageBean(Sql sql, Class<T> type, int curPage, int pageSize, boolean calCount, boolean allList) {
/* 408 */     printSql(sql);
/* 409 */     return queryForPageBean(sql.toString(), type, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
/*     */   }
/*     */   
/*     */   public <T> Page<T> queryForPageBean(Sql sql, Class<T> type, int curPage, int pageSize, boolean calCount, boolean allList, boolean cutSql) {
/* 413 */     printSql(sql);
/* 414 */     return queryForPageBean(sql.toString(), type, sql.getParams().toArray(), curPage, pageSize, calCount, allList, cutSql);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> Page<T> queryForPageBean(String sql, Class<T> type, Object[] params, int curPage, int pageSize, boolean calCount, boolean allList) {
/* 419 */     return queryForPageBean(sql, type, params, curPage, pageSize, calCount, allList, true);
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
/*     */   public <T> List<T> queryForListBean(Sql sql, Class<T> type, int curPage, int pageSize) {
/* 448 */     printSql(sql);
/* 449 */     return queryForListBean(sql.toString(), type, sql.getParams().toArray(), curPage, pageSize);
/*     */   }
/*     */   
/*     */   public <T> List<T> queryForListBean(String sql, Class<T> type, int curPage, int pageSize) {
/* 453 */     return queryForListBean(sql, type, null, curPage, pageSize);
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
/*     */   public <T> List<T> queryForListBean(Sql sql, Class<T> type, int top) {
/* 465 */     printSql(sql);
/* 466 */     return queryForListBean(sql.toString(), type, sql.getParams().toArray(), top);
/*     */   }
/*     */   
/*     */   public <T> List<T> queryForListBean(String sql, Class<T> type, Object[] params, int top) {
/* 470 */     return queryForListBean(sql, type, params, 1, top);
/*     */   }
/*     */   
/*     */   public <T> List<T> queryForListBean(String sql, Class<T> type, int top) {
/* 474 */     return queryForListBean(sql, type, (Object[])null, top);
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
/*     */   public List<Map> queryForListMap(Sql sql, int curPage, int pageSize) {
/* 486 */     printSql(sql);
/* 487 */     return queryForListMap(sql.toString(), sql.getParams().toArray(), curPage, pageSize);
/*     */   }
/*     */   
/*     */   public List<Map> queryForListMap(String sql, Object[] params, int curPage, int pageSize) {
/* 491 */     return queryForListBean(sql, Map.class, params, curPage, pageSize);
/*     */   }
/*     */   
/*     */   public List<Map> queryForListMap(String sql, int curPage, int pageSize) {
/* 495 */     return queryForListMap(sql, null, curPage, pageSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Map> queryForListMap(Sql sql, int top) {
/* 506 */     printSql(sql);
/* 507 */     return queryForListMap(sql.toString(), sql.getParams().toArray(), top);
/*     */   }
/*     */   
/*     */   public List<Map> queryForListMap(String sql, Object[] params, int top) {
/* 511 */     return queryForListMap(sql, params, 1, top);
/*     */   }
/*     */   
/*     */   public List<Map> queryForListMap(String sql, int top) {
/* 515 */     return queryForListMap(sql, (Object[])null, top);
/*     */   }
/*     */   
/*     */   public <T> Set<T> queryListToSet(String sql) {
/* 519 */     return queryListToSet(sql, null);
/*     */   }
/*     */   
/*     */   public <T> Set<T> queryListToSet(Sql sql) {
/* 523 */     printSql(sql);
/* 524 */     return queryListToSet(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> Set<T> queryListToSet(String sql, Object[] params) {
/* 535 */     Set<T> set = new HashSet();
/* 536 */     getJdbcTemplate().query(sql, params, resultSet -> set.add(resultSet.getObject(1)));
/*     */ 
/*     */     
/* 539 */     return set;
/*     */   }
/*     */   
/*     */   public Map queryListToMap(String sql) {
/* 543 */     return queryListToMap(sql, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map queryListToMap(Sql sql) {
/* 553 */     printSql(sql);
/* 554 */     return queryListToMap(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public Map queryListToMap(String sql, Object[] params) {
/* 558 */     Map<Object, Object> map = new HashMap<>();
/* 559 */     getJdbcTemplate().query(sql, params, resultSet -> {
/*     */           ResultSetMetaData metaData = resultSet.getMetaData();
/*     */           if (metaData.getColumnCount() < 2) {
/*     */             return;
/*     */           }
/*     */           map.put(resultSet.getObject(1), resultSet.getObject(2));
/*     */         });
/* 566 */     return map;
/*     */   }
/*     */   
/*     */   public Map<String, List<Object>> queryMapListByColumnKey(String sql) {
/* 570 */     return queryMapListByColumnKey(sql, new Object[0]);
/*     */   }
/*     */   
/*     */   public Map<String, List<Object>> queryMapListByColumnKey(Sql sql) {
/* 574 */     printSql(sql);
/* 575 */     return queryMapListByColumnKey(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, List<Object>> queryMapListByColumnKey(String sql, Object[] params) {
/* 586 */     Map<String, List<Object>> map = new HashMap<>();
/* 587 */     getJdbcTemplate().query(sql, params, resultSet -> {
/*     */           ResultSetMetaData metaData = resultSet.getMetaData();
/*     */           int columnCount = metaData.getColumnCount();
/*     */           for (int i = 0; i < columnCount; i++) {
/*     */             Object obj;
/*     */             String columnName = metaData.getColumnName(i + 1);
/*     */             List<Object> list = map.computeIfAbsent(columnName, ());
/*     */             int type = metaData.getColumnType(i + 1);
/*     */             switch (type) {
/*     */               case -5:
/*     */               case 4:
/*     */               case 5:
/*     */                 obj = Long.valueOf(resultSet.getLong(i + 1));
/*     */                 break;
/*     */               case 6:
/*     */               case 8:
/*     */                 obj = Double.valueOf(resultSet.getDouble(i + 1));
/*     */                 break;
/*     */               case -16:
/*     */               case -9:
/*     */               case -1:
/*     */               case 12:
/*     */                 obj = resultSet.getString(i + 1);
/*     */                 break;
/*     */               case 91:
/*     */               case 92:
/*     */               case 93:
/*     */                 obj = resultSet.getDate(i + 1);
/*     */                 break;
/*     */               default:
/*     */                 obj = resultSet.getObject(i + 1);
/*     */                 break;
/*     */             } 
/*     */             list.add(obj);
/*     */           } 
/*     */         });
/* 623 */     return map;
/*     */   }
/*     */   
/*     */   public <T> List<T> queryListByFirstColumn(String sql) {
/* 627 */     return queryListByFirstColumn(sql, new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> List<T> queryListByFirstColumn(Sql sql) {
/* 637 */     printSql(sql);
/* 638 */     return queryListByFirstColumn(sql.toString(), sql.getParams().toArray());
/*     */   }
/*     */   
/*     */   public <T> List<T> queryListByFirstColumn(String sql, Object[] params) {
/* 642 */     List<T> list = new ArrayList<>();
/* 643 */     getJdbcTemplate().query(sql, params, resultSet -> {
/*     */           Long long_; Double double_; String str; Date date; T obj;
/*     */           ResultSetMetaData metaData = resultSet.getMetaData();
/*     */           int type = metaData.getColumnType(1);
/*     */           switch (type) {
/*     */             case -5:
/*     */             case 4:
/*     */             case 5:
/*     */               long_ = Long.valueOf(resultSet.getLong(1));
/*     */               break;
/*     */             case 6:
/*     */             case 8:
/*     */               double_ = Double.valueOf(resultSet.getDouble(1));
/*     */               break;
/*     */             case -16:
/*     */             case -9:
/*     */             case -1:
/*     */             case 12:
/*     */               str = resultSet.getString(1);
/*     */               break;
/*     */             case 91:
/*     */             case 92:
/*     */             case 93:
/*     */               date = resultSet.getDate(1);
/*     */               break;
/*     */             default:
/*     */               obj = (T)resultSet.getObject(1);
/*     */               break;
/*     */           } 
/*     */           list.add(obj);
/*     */         });
/* 674 */     return list;
/*     */   }
/*     */   
/*     */   protected void printSql(Sql sql) {
/* 678 */     if (this.printSql && 
/* 679 */       this.logger.isDebugEnabled()) {
/* 680 */       this.logger.debug("Debug Sql:{}", sql.debugSql());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void printSql(String sql) {
/* 686 */     if (this.printSql && 
/* 687 */       this.logger.isDebugEnabled()) {
/* 688 */       this.logger.debug(sql);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrintSql() {
/* 694 */     return this.printSql;
/*     */   }
/*     */   
/*     */   public BaseJdbcDaoSupport setPrintSql(boolean printSql) {
/* 698 */     this.printSql = printSql;
/* 699 */     return this;
/*     */   }
/*     */   
/*     */   public abstract Number insertReturnFieldNumber(String paramString, Object[] paramArrayOfObject);
/*     */   
/*     */   public abstract <T> Page<T> queryForPageBean(String paramString, Class<T> paramClass, Object[] paramArrayOfObject, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
/*     */   
/*     */   public abstract <T> List<T> queryForListBean(String paramString, Class<T> paramClass, Object[] paramArrayOfObject, int paramInt1, int paramInt2);
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/db/base/BaseJdbcDaoSupport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */