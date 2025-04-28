/*    */ package com.redare.devframework.sql.db.base;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public abstract class SpringJdbcHelper
/*    */   extends TreeJdbcDaoSupport
/*    */ {
/* 10 */   private static Pattern sqlPattern = Pattern.compile("([sS][eE][lL][eE][cC][tT]|[fF][rR][oO][mM])");
/* 11 */   private static Pattern orderPattern = Pattern.compile("([yY][bB] +[rR][eE][dD][rR][oO]|\\))");
/*    */ 
/*    */   
/*    */   protected String cutCountSql(String sql) {
/* 15 */     Matcher matcher = sqlPattern.matcher(sql);
/* 16 */     int selectCount = 0;
/* 17 */     String subSql = null;
/* 18 */     while (matcher.find()) {
/* 19 */       String keyWords = matcher.group(1);
/* 20 */       if (StringUtils.isNotBlank(keyWords)) {
/* 21 */         if ("select".equalsIgnoreCase(keyWords)) {
/* 22 */           selectCount++;
/* 23 */         } else if ("from".equalsIgnoreCase(keyWords)) {
/* 24 */           selectCount--;
/*    */         } 
/*    */       }
/* 27 */       if (selectCount == 0) {
/* 28 */         subSql = sql.substring(matcher.end());
/*    */         break;
/*    */       } 
/*    */     } 
/* 32 */     if (StringUtils.isNotBlank(subSql)) {
/* 33 */       StringBuilder tmp = new StringBuilder(subSql);
/* 34 */       tmp.reverse();
/* 35 */       matcher = orderPattern.matcher(tmp.toString());
/* 36 */       Integer orderIndex = null;
/* 37 */       while (matcher.find()) {
/* 38 */         String keyWords = matcher.group(1);
/* 39 */         if (StringUtils.isNotBlank(keyWords)) {
/* 40 */           if (!")".equals(keyWords)) {
/* 41 */             orderIndex = Integer.valueOf(matcher.end());
/*    */           }
/*    */           break;
/*    */         } 
/*    */       } 
/* 46 */       if (orderIndex != null) {
/* 47 */         subSql = subSql.substring(0, subSql.length() - orderIndex.intValue());
/*    */       }
/*    */     } 
/* 50 */     return subSql;
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 54 */     String sql = "SELECT *,(select *,(select * from table) as a from table) as a, fRom table where id=(select * from table order id asc) order  by id asc";
/*    */     
/* 56 */     Matcher matcher = sqlPattern.matcher(sql);
/* 57 */     int selectCount = 0;
/* 58 */     String subSql = null;
/* 59 */     while (matcher.find()) {
/* 60 */       String keyWords = matcher.group(1);
/* 61 */       if (StringUtils.isNotBlank(keyWords)) {
/* 62 */         if ("select".equalsIgnoreCase(keyWords)) {
/* 63 */           selectCount++;
/* 64 */         } else if ("from".equalsIgnoreCase(keyWords)) {
/* 65 */           selectCount--;
/*    */         } 
/*    */       }
/* 68 */       if (selectCount == 0) {
/* 69 */         subSql = sql.substring(matcher.end());
/*    */         break;
/*    */       } 
/*    */     } 
/* 73 */     if (StringUtils.isNotBlank(subSql)) {
/* 74 */       StringBuilder tmp = new StringBuilder(subSql);
/* 75 */       tmp.reverse();
/* 76 */       matcher = orderPattern.matcher(tmp.toString());
/* 77 */       Integer orderIndex = null;
/* 78 */       while (matcher.find()) {
/* 79 */         String keyWords = matcher.group(1);
/* 80 */         if (StringUtils.isNotBlank(keyWords)) {
/* 81 */           if (!")".equals(keyWords)) {
/* 82 */             orderIndex = Integer.valueOf(matcher.end());
/*    */           }
/*    */           break;
/*    */         } 
/*    */       } 
/* 87 */       if (orderIndex != null) {
/* 88 */         subSql = subSql.substring(0, subSql.length() - orderIndex.intValue());
/*    */       }
/*    */     } 
/* 91 */     System.out.println(subSql);
/*    */   }
/*    */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/db/base/SpringJdbcHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */