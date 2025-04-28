/*    */ package com.redare.devframework.sql;
/*    */ 
/*    */ import com.redare.devframework.common.utils.JsonUtils;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class JsonMysql
/*    */   extends BaseSql {
/*    */   public static BaseSql jsonContains(String field, Object json) {
/*  9 */     return jsonContains(field, json, null);
/*    */   }
/*    */   
/*    */   public static BaseSql jsonContains(String field, Object json, String path) {
/* 13 */     if (StringUtils.isBlank(path)) {
/* 14 */       return Sql.sql(String.format("JSON_CONTAINS(%s,'%s')", new Object[] { field, JsonUtils.toJson(json) }));
/*    */     }
/* 16 */     if (path.startsWith("[")) {
/* 17 */       path = String.format("$%s", new Object[] { path });
/*    */     } else {
/* 19 */       path = String.format("$.%s", new Object[] { path });
/*    */     } 
/* 21 */     return Sql.sql(String.format("JSON_CONTAINS(%s,'%s','%s')", new Object[] { field, JsonUtils.toJson(json), path }));
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/JsonMysql.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */