/*      */ package com.redare.devframework.sql;
/*      */ 
/*      */ import com.redare.devframework.common.pojo.LevelTreeQuery;
/*      */ import com.redare.devframework.sql.lazy.LazyParam;
/*      */ import com.redare.devframework.sql.lazy.LazySql;
/*      */ import com.redare.devframework.sql.lazy.LazySqls;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.function.Function;
/*      */ import org.apache.commons.collections.CollectionUtils;
/*      */ import org.apache.commons.lang.ArrayUtils;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ 
/*      */ public class Where
/*      */   extends BaseSql
/*      */ {
/*      */   protected List<Ref> refs;
/*      */   private boolean hasCreate = false;
/*   20 */   private Integer throwCount = null;
/*      */   
/*      */   protected Where(Sql sql) {
/*   23 */     super(sql);
/*   24 */     this.refs = new ArrayList<>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where throwRunExceptionWhenCriteriaCountLess(int count) {
/*   34 */     if (count > 0) {
/*   35 */       this.throwCount = Integer.valueOf(count);
/*      */     }
/*   37 */     return this;
/*      */   }
/*      */   
/*      */   public Where andEqs(String... fields) {
/*   41 */     if (ArrayUtils.isNotEmpty((Object[])fields)) {
/*   42 */       for (String field : fields) {
/*   43 */         andEq(field, "");
/*      */       }
/*      */     }
/*   46 */     return this;
/*      */   }
/*      */   
/*      */   public Where andNotEqs(String... fields) {
/*   50 */     if (ArrayUtils.isNotEmpty((Object[])fields)) {
/*   51 */       for (String field : fields) {
/*   52 */         andNotEq(field, "");
/*      */       }
/*      */     }
/*   55 */     return this;
/*      */   }
/*      */   
/*      */   public Where andLts(String... fields) {
/*   59 */     if (ArrayUtils.isNotEmpty((Object[])fields)) {
/*   60 */       for (String field : fields) {
/*   61 */         andLt(field, "");
/*      */       }
/*      */     }
/*   64 */     return this;
/*      */   }
/*      */   
/*      */   public Where andGts(String... fields) {
/*   68 */     if (ArrayUtils.isNotEmpty((Object[])fields)) {
/*   69 */       for (String field : fields) {
/*   70 */         andGt(field, "");
/*      */       }
/*      */     }
/*   73 */     return this;
/*      */   }
/*      */   
/*      */   public Where andLtEqs(String... fields) {
/*   77 */     if (ArrayUtils.isNotEmpty((Object[])fields)) {
/*   78 */       for (String field : fields) {
/*   79 */         andLtEq(field, "");
/*      */       }
/*      */     }
/*   82 */     return this;
/*      */   }
/*      */   
/*      */   public Where andGtEqs(String... fields) {
/*   86 */     if (ArrayUtils.isNotEmpty((Object[])fields)) {
/*   87 */       for (String field : fields) {
/*   88 */         andGtEq(field, "");
/*      */       }
/*      */     }
/*   91 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqField(String field1, String field2) {
/*  102 */     return and(Criteria.eqField(field1, field2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqFieldIf(boolean bool, String field1, String field2) {
/*  114 */     if (!bool) {
/*  115 */       return this;
/*      */     }
/*  117 */     return andEqField(field1, field2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEq(String field, Object params) {
/*  128 */     return and(Criteria.eq(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEq(String field, Sql sql) {
/*  139 */     return and(Criteria.eq(field, sql));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIf(boolean bool, String field, Object params) {
/*  151 */     if (!bool) {
/*  152 */       return this;
/*      */     }
/*  154 */     return andEq(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  166 */     if (!bool) {
/*  167 */       return this;
/*      */     }
/*  169 */     return andEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  181 */     if (!bool) {
/*  182 */       return this;
/*      */     }
/*  184 */     return andEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIfNotNull(String field, Object params) {
/*  195 */     return andEqIf((params != null), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  207 */     if (params == null) {
/*  208 */       return this;
/*      */     }
/*  210 */     return andEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  222 */     if (params == null) {
/*  223 */       return this;
/*      */     }
/*  225 */     return andEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIfNotBlank(String field, String params) {
/*  236 */     return andEqIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  248 */     if (StringUtils.isBlank(params)) {
/*  249 */       return this;
/*      */     }
/*  251 */     return andEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  263 */     if (StringUtils.isBlank(params)) {
/*  264 */       return this;
/*      */     }
/*  266 */     return andEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEq(String field, Object params) {
/*  277 */     return and(Criteria.notEq(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEq(String field, Sql sql) {
/*  288 */     return and(Criteria.notEq(field, sql));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIf(boolean bool, String field, Object params) {
/*  300 */     if (!bool) {
/*  301 */       return this;
/*      */     }
/*  303 */     return andNotEq(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  315 */     if (!bool) {
/*  316 */       return this;
/*      */     }
/*  318 */     return andNotEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIf(boolean bool, String field, LazySql<Sql> sql) {
/*  330 */     if (!bool) {
/*  331 */       return this;
/*      */     }
/*  333 */     return andNotEq(field, sql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIfNotNull(String field, Object params) {
/*  344 */     return andNotEqIf((params != null), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  356 */     if (params == null) {
/*  357 */       return this;
/*      */     }
/*  359 */     return andNotEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  371 */     if (params == null) {
/*  372 */       return this;
/*      */     }
/*  374 */     return andNotEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIfNotBlank(String field, String params) {
/*  385 */     return andNotEqIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  397 */     if (StringUtils.isBlank(params)) {
/*  398 */       return this;
/*      */     }
/*  400 */     return andNotEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  412 */     if (StringUtils.isBlank(params)) {
/*  413 */       return this;
/*      */     }
/*  415 */     return andNotEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLt(String field, Object params) {
/*  426 */     return and(Criteria.lt(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLt(String field, Sql sql) {
/*  437 */     return and(Criteria.lt(field, sql));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIf(boolean bool, String field, Object params) {
/*  449 */     if (!bool) {
/*  450 */       return this;
/*      */     }
/*  452 */     return andLt(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  464 */     if (!bool) {
/*  465 */       return this;
/*      */     }
/*  467 */     return andLt(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  479 */     if (!bool) {
/*  480 */       return this;
/*      */     }
/*  482 */     return andLt(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIfNotNull(String field, Object params) {
/*  493 */     return andLtIf((params != null), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  505 */     if (params == null) {
/*  506 */       return this;
/*      */     }
/*  508 */     return andLt(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  520 */     if (params == null) {
/*  521 */       return this;
/*      */     }
/*  523 */     return andLt(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIfNotBlank(String field, String params) {
/*  534 */     return andLtIf(StringUtils.isNotBlank(field), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  547 */     if (StringUtils.isBlank(params)) {
/*  548 */       return this;
/*      */     }
/*  550 */     return andLt(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  562 */     if (params == null) {
/*  563 */       return this;
/*      */     }
/*  565 */     return andLt(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEq(String field, Object params) {
/*  576 */     return andLtEqIf(true, field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEq(String field, Sql sql) {
/*  587 */     return and(Criteria.ltEq(field, sql));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIf(boolean bool, String field, Object params) {
/*  599 */     if (!bool) {
/*  600 */       return this;
/*      */     }
/*  602 */     return and(Criteria.ltEq(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  614 */     if (!bool) {
/*  615 */       return this;
/*      */     }
/*  617 */     return andLtEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  629 */     if (!bool) {
/*  630 */       return this;
/*      */     }
/*  632 */     return andLtEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIfNotNull(String field, Object params) {
/*  643 */     return andLtEqIf((params != null), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  655 */     if (params == null) {
/*  656 */       return this;
/*      */     }
/*  658 */     return andLtEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  671 */     if (params == null) {
/*  672 */       return this;
/*      */     }
/*  674 */     return andLtEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIfNotBlank(String field, String params) {
/*  685 */     return andLtEqIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  697 */     if (params == null) {
/*  698 */       return this;
/*      */     }
/*  700 */     return andLtEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLtEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  713 */     if (params == null) {
/*  714 */       return this;
/*      */     }
/*  716 */     return andLtEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGt(String field, Object params) {
/*  727 */     return and(Criteria.gt(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGt(String field, Sql sql) {
/*  738 */     return and(Criteria.gt(field, sql));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIf(boolean bool, String field, Object params) {
/*  750 */     if (!bool) {
/*  751 */       return this;
/*      */     }
/*  753 */     return andGt(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  765 */     if (!bool) {
/*  766 */       return this;
/*      */     }
/*  768 */     return andGt(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  780 */     if (!bool) {
/*  781 */       return this;
/*      */     }
/*  783 */     return andGt(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIfNotNull(String field, Object params) {
/*  794 */     if (params == null) {
/*  795 */       return this;
/*      */     }
/*  797 */     return andGt(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  809 */     if (params == null) {
/*  810 */       return this;
/*      */     }
/*  812 */     return andGt(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  824 */     if (params == null) {
/*  825 */       return this;
/*      */     }
/*  827 */     return andGt(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIfNotBlank(String field, String params) {
/*  838 */     if (StringUtils.isBlank(params)) {
/*  839 */       return this;
/*      */     }
/*  841 */     return andGt(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  853 */     if (StringUtils.isBlank(params)) {
/*  854 */       return this;
/*      */     }
/*  856 */     return andGt(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  868 */     if (StringUtils.isBlank(params)) {
/*  869 */       return this;
/*      */     }
/*  871 */     return andGt(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEq(String field, Object params) {
/*  882 */     return and(Criteria.gtEq(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEq(String field, Sql sql) {
/*  893 */     return and(Criteria.gtEq(field, sql));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIf(boolean bool, String field, Object params) {
/*  905 */     if (!bool) {
/*  906 */       return this;
/*      */     }
/*  908 */     return andGtEq(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  920 */     if (!bool) {
/*  921 */       return this;
/*      */     }
/*  923 */     return andGtEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  935 */     if (!bool) {
/*  936 */       return this;
/*      */     }
/*  938 */     return andGtEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIfNotNull(String field, Object params) {
/*  949 */     if (params == null) {
/*  950 */       return this;
/*      */     }
/*  952 */     return andGtEq(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  964 */     if (params == null) {
/*  965 */       return this;
/*      */     }
/*  967 */     return andGtEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  979 */     if (params == null) {
/*  980 */       return this;
/*      */     }
/*  982 */     return andGtEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIfNotBlank(String field, String params) {
/*  993 */     if (StringUtils.isBlank(params)) {
/*  994 */       return this;
/*      */     }
/*  996 */     return andGtEq(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/* 1008 */     if (StringUtils.isBlank(params)) {
/* 1009 */       return this;
/*      */     }
/* 1011 */     return andGtEq(field, lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andGtEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/* 1023 */     if (StringUtils.isBlank(params)) {
/* 1024 */       return this;
/*      */     }
/* 1026 */     return andGtEq(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetween(String field, Object param1, Object param2) {
/* 1038 */     return and(Criteria.between(field, param1, param2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenIf(boolean bool, String field, Object param1, Object param2) {
/* 1051 */     if (!bool) {
/* 1052 */       return this;
/*      */     }
/* 1054 */     return andBetween(field, param1, param2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenOption(String field, Object param1, Object param2) {
/* 1070 */     return and(Criteria.ifBetween(field, param1, param2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenOption(String field, String param1, String param2) {
/* 1086 */     return and(Criteria.ifBetween(field, StringUtils.isBlank(param1) ? null : param1, StringUtils.isBlank(param2) ? null : param2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenOptionIf(boolean bool, String field, Object param1, Object param2) {
/* 1103 */     if (!bool) {
/* 1104 */       return this;
/*      */     }
/* 1106 */     return andBetweenOption(field, param1, param2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenOptionIf(boolean bool, String field, String param1, String param2) {
/* 1123 */     if (!bool) {
/* 1124 */       return this;
/*      */     }
/* 1126 */     return andBetweenOption(field, param1, param2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenOption(String field1, String field2, Object param1, Object param2) {
/* 1145 */     return and(Criteria.ifBetween(field1, field2, param1, param2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenOption(String field1, String field2, String param1, String param2) {
/* 1164 */     return and(Criteria.ifBetween(field1, field2, StringUtils.isBlank(param1) ? null : param1, StringUtils.isBlank(param2) ? null : param2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenOptionIf(boolean bool, String field1, String field2, Object param1, Object param2) {
/* 1184 */     if (!bool) {
/* 1185 */       return this;
/*      */     }
/* 1187 */     return andBetweenOption(field1, field2, param1, param2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBetweenOptionIf(boolean bool, String field1, String field2, String param1, String param2) {
/* 1207 */     if (!bool) {
/* 1208 */       return this;
/*      */     }
/* 1210 */     return andBetweenOption(field1, field2, param1, param2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIn(String field, List<?> params) {
/* 1221 */     if (params.size() == 1) {
/* 1222 */       return andEq(field, params.get(0));
/*      */     }
/* 1224 */     return and(Criteria.in(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIn(String field, Sql sql) {
/* 1235 */     return and(Criteria.in(field, sql));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andInIf(boolean bool, String field, List<?> params) {
/* 1247 */     if (!bool) {
/* 1248 */       return this;
/*      */     }
/* 1250 */     return andIn(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andInIf(boolean bool, String field, LazyParam<List<?>> params) {
/* 1262 */     if (!bool) {
/* 1263 */       return this;
/*      */     }
/* 1265 */     return andIn(field, (List)params.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andInIf(boolean bool, String field, LazySql<Sql> sql) {
/* 1277 */     if (!bool) {
/* 1278 */       return this;
/*      */     }
/* 1280 */     return andIn(field, sql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andInIfNotEmpty(String field, List<?> params) {
/* 1291 */     if (CollectionUtils.isEmpty(params)) {
/* 1292 */       return this;
/*      */     }
/* 1294 */     return andIn(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andInIfNotEmpty(String field, List<?> params, LazyParam<List<?>> lazyParam) {
/* 1306 */     if (CollectionUtils.isEmpty(params)) {
/* 1307 */       return this;
/*      */     }
/* 1309 */     return andIn(field, (List)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andInIfNotEmpty(String field, List<?> params, LazySql<Sql> lazySql) {
/* 1321 */     if (CollectionUtils.isEmpty(params)) {
/* 1322 */       return this;
/*      */     }
/* 1324 */     return andIn(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotIn(String field, List<?> params) {
/* 1335 */     if (params.size() == 1) {
/* 1336 */       return andNotEq(field, params.get(0));
/*      */     }
/* 1338 */     return and(Criteria.notIn(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotIn(String field, Sql sql) {
/* 1349 */     return and(Criteria.notIn(field, sql));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotInIf(boolean bool, String field, List<?> params) {
/* 1361 */     if (!bool) {
/* 1362 */       return this;
/*      */     }
/* 1364 */     return andNotIn(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotInIf(boolean bool, String field, LazyParam<List<?>> params) {
/* 1376 */     if (!bool) {
/* 1377 */       return this;
/*      */     }
/* 1379 */     return andNotIn(field, (List)params.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotInIf(boolean bool, String field, LazySql<Sql> sql) {
/* 1391 */     if (!bool) {
/* 1392 */       return this;
/*      */     }
/* 1394 */     return andNotIn(field, sql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotInIfNotEmpty(String field, List<?> params) {
/* 1405 */     if (CollectionUtils.isEmpty(params)) {
/* 1406 */       return this;
/*      */     }
/* 1408 */     return andNotIn(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotInIfNotEmpty(String field, List<?> params, LazyParam<List<?>> lazyParam) {
/* 1420 */     if (CollectionUtils.isEmpty(params)) {
/* 1421 */       return this;
/*      */     }
/* 1423 */     return andNotIn(field, (List)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotInIfNotEmpty(String field, List<?> params, LazySql<Sql> lazySql) {
/* 1435 */     if (CollectionUtils.isEmpty(params)) {
/* 1436 */       return this;
/*      */     }
/* 1438 */     return andNotIn(field, lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLike(String field, String params) {
/* 1449 */     return and(Criteria.bLike(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeIf(boolean bool, String field, String params) {
/* 1461 */     if (!bool) {
/* 1462 */       return this;
/*      */     }
/* 1464 */     return andBLike(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeIfNotBlank(String field, String params) {
/* 1475 */     return andBLikeIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1487 */     if (StringUtils.isBlank(params)) {
/* 1488 */       return this;
/*      */     }
/* 1490 */     return andBLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1502 */     if (params == null) {
/* 1503 */       return this;
/*      */     }
/* 1505 */     return andBLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByAnd(String field, List<String> params) {
/* 1516 */     if (CollectionUtils.isEmpty(params)) {
/* 1517 */       return this;
/*      */     }
/* 1519 */     for (String param : params) {
/* 1520 */       andBLike(field, param);
/*      */     }
/* 1522 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 1535 */     if (!bool) {
/* 1536 */       return this;
/*      */     }
/* 1538 */     return andBLikeJoinByAnd(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 1549 */     return andBLikeJoinByAndIf(CollectionUtils.isNotEmpty(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1561 */     if (CollectionUtils.isEmpty(params)) {
/* 1562 */       return this;
/*      */     }
/* 1564 */     return andBLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1576 */     if (StringUtils.isBlank(params)) {
/* 1577 */       return this;
/*      */     }
/* 1579 */     return andBLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1591 */     if (params == null) {
/* 1592 */       return this;
/*      */     }
/* 1594 */     return andBLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByOr(String field, List<String> params) {
/* 1606 */     if (CollectionUtils.isEmpty(params)) {
/* 1607 */       return this;
/*      */     }
/* 1609 */     if (params.size() == 1) {
/* 1610 */       return andBLike(field, params.get(0));
/*      */     }
/* 1612 */     Sql[] criteria = new Sql[params.size()];
/* 1613 */     for (int i = 0; i < params.size(); i++) {
/* 1614 */       criteria[i] = Criteria.bLike(field, params.get(i));
/*      */     }
/* 1616 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 1629 */     if (!bool) {
/* 1630 */       return this;
/*      */     }
/* 1632 */     return andBLikeJoinByOr(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 1643 */     return andBLikeJoinByOrIf(CollectionUtils.isNotEmpty(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1655 */     if (CollectionUtils.isEmpty(params)) {
/* 1656 */       return this;
/*      */     }
/* 1658 */     return andBLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1670 */     if (StringUtils.isBlank(params)) {
/* 1671 */       return this;
/*      */     }
/* 1673 */     return andBLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1685 */     if (params == null) {
/* 1686 */       return this;
/*      */     }
/* 1688 */     return andBLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeFieldsJoinByOr(String params, String... fields) {
/* 1699 */     if (ArrayUtils.isEmpty((Object[])fields)) {
/* 1700 */       return this;
/*      */     }
/* 1702 */     if (fields.length == 1) {
/* 1703 */       return andBLike(fields[0], params);
/*      */     }
/* 1705 */     Sql[] criteria = new Sql[fields.length];
/* 1706 */     for (int i = 0; i < fields.length; i++) {
/* 1707 */       criteria[i] = Criteria.bLike(fields[i], params);
/*      */     }
/* 1709 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeFieldsJoinByOr(String params, List<String> fields) {
/* 1720 */     if (CollectionUtils.isEmpty(fields)) {
/* 1721 */       return this;
/*      */     }
/* 1723 */     if (fields.size() == 1) {
/* 1724 */       return andBLike(fields.get(0), params);
/*      */     }
/* 1726 */     Sql[] criteria = new Sql[fields.size()];
/* 1727 */     for (int i = 0; i < fields.size(); i++) {
/* 1728 */       criteria[i] = Criteria.bLike(fields.get(i), params);
/*      */     }
/* 1730 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 1743 */     if (!bool || ArrayUtils.isEmpty((Object[])fields)) {
/* 1744 */       return this;
/*      */     }
/* 1746 */     return andBLikeFieldsJoinByOr(params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 1758 */     if (!bool) {
/* 1759 */       return this;
/*      */     }
/* 1761 */     return andBLikeFieldsJoinByOr(params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 1772 */     return andBLikeFieldsJoinByOrIf(StringUtils.isNotBlank(params), params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andBLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 1783 */     return andBLikeFieldsJoinByOrIf(StringUtils.isNotBlank(params), params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotBLike(String field, String params) {
/* 1795 */     return and(Criteria.bNotLike(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotBLikeIf(boolean bool, String field, String params) {
/* 1807 */     if (!bool) {
/* 1808 */       return this;
/*      */     }
/* 1810 */     return andNotBLike(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotBLikeIfNotBlank(String field, String params) {
/* 1821 */     return andNotBLikeIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotBLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1833 */     if (StringUtils.isBlank(params)) {
/* 1834 */       return this;
/*      */     }
/* 1836 */     return andNotBLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotBLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1848 */     if (params == null) {
/* 1849 */       return this;
/*      */     }
/* 1851 */     return andNotBLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLike(String field, String params) {
/* 1862 */     return and(Criteria.lLike(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeIf(boolean bool, String field, String params) {
/* 1874 */     if (!bool) {
/* 1875 */       return this;
/*      */     }
/* 1877 */     return andLLike(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeIfNotBlank(String field, String params) {
/* 1888 */     return andLLikeIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1900 */     if (StringUtils.isBlank(params)) {
/* 1901 */       return this;
/*      */     }
/* 1903 */     return andLLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1915 */     if (params == null) {
/* 1916 */       return this;
/*      */     }
/* 1918 */     return andLLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByAnd(String field, List<String> params) {
/* 1929 */     if (CollectionUtils.isEmpty(params)) {
/* 1930 */       return this;
/*      */     }
/* 1932 */     for (String param : params) {
/* 1933 */       andLLike(field, param);
/*      */     }
/* 1935 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 1948 */     if (!bool) {
/* 1949 */       return this;
/*      */     }
/* 1951 */     return andLLikeJoinByAnd(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 1962 */     return andLLikeJoinByAndIf(CollectionUtils.isNotEmpty(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1974 */     if (CollectionUtils.isEmpty(params)) {
/* 1975 */       return this;
/*      */     }
/* 1977 */     return andLLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1989 */     if (StringUtils.isBlank(params)) {
/* 1990 */       return this;
/*      */     }
/* 1992 */     return andLLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 2004 */     if (params == null) {
/* 2005 */       return this;
/*      */     }
/* 2007 */     return andLLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByOr(String field, List<String> params) {
/* 2019 */     if (CollectionUtils.isEmpty(params)) {
/* 2020 */       return this;
/*      */     }
/* 2022 */     if (params.size() == 1) {
/* 2023 */       return andLLike(field, params.get(0));
/*      */     }
/* 2025 */     Sql[] criteria = new Sql[params.size()];
/* 2026 */     for (int i = 0; i < params.size(); i++) {
/* 2027 */       criteria[i] = Criteria.lLike(field, params.get(i));
/*      */     }
/* 2029 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 2042 */     if (!bool) {
/* 2043 */       return this;
/*      */     }
/* 2045 */     return andLLikeJoinByOr(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 2056 */     return andLLikeJoinByOrIf(CollectionUtils.isNotEmpty(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 2068 */     if (CollectionUtils.isEmpty(params)) {
/* 2069 */       return this;
/*      */     }
/* 2071 */     return andLLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 2083 */     if (StringUtils.isBlank(params)) {
/* 2084 */       return this;
/*      */     }
/* 2086 */     return andLLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 2098 */     if (params == null) {
/* 2099 */       return this;
/*      */     }
/* 2101 */     return andLLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeFieldsJoinByOr(String params, String... fields) {
/* 2112 */     if (ArrayUtils.isEmpty((Object[])fields)) {
/* 2113 */       return this;
/*      */     }
/* 2115 */     if (fields.length == 1) {
/* 2116 */       return andLLike(fields[0], params);
/*      */     }
/* 2118 */     Sql[] criteria = new Sql[fields.length];
/* 2119 */     for (int i = 0; i < fields.length; i++) {
/* 2120 */       criteria[i] = Criteria.lLike(fields[i], params);
/*      */     }
/* 2122 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeFieldsJoinByOr(String params, List<String> fields) {
/* 2133 */     if (CollectionUtils.isEmpty(fields)) {
/* 2134 */       return this;
/*      */     }
/* 2136 */     if (fields.size() == 1) {
/* 2137 */       return andLLike(fields.get(0), params);
/*      */     }
/* 2139 */     Sql[] criteria = new Sql[fields.size()];
/* 2140 */     for (int i = 0; i < fields.size(); i++) {
/* 2141 */       criteria[i] = Criteria.lLike(fields.get(i), params);
/*      */     }
/* 2143 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 2156 */     if (!bool || ArrayUtils.isEmpty((Object[])fields)) {
/* 2157 */       return this;
/*      */     }
/* 2159 */     return andLLikeFieldsJoinByOr(params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 2171 */     if (!bool) {
/* 2172 */       return this;
/*      */     }
/* 2174 */     return andLLikeFieldsJoinByOr(params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 2185 */     return andLLikeFieldsJoinByOrIf(StringUtils.isNotBlank(params), params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 2196 */     return andLLikeFieldsJoinByOrIf(StringUtils.isNotBlank(params), params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLLike(String field, String params) {
/* 2208 */     return and(Criteria.notLike(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLLikeIf(boolean bool, String field, String params) {
/* 2220 */     if (!bool) {
/* 2221 */       return this;
/*      */     }
/* 2223 */     return andNotLLike(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLLikeIfNotBlank(String field, String params) {
/* 2234 */     return andNotLLikeIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 2246 */     if (StringUtils.isBlank(params)) {
/* 2247 */       return this;
/*      */     }
/* 2249 */     return andNotLLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 2261 */     if (params == null) {
/* 2262 */       return this;
/*      */     }
/* 2264 */     return andNotLLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLike(String field, String params) {
/* 2275 */     return and(Criteria.rLike(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeIf(boolean bool, String field, String params) {
/* 2287 */     if (!bool) {
/* 2288 */       return this;
/*      */     }
/* 2290 */     return andRLike(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeIfNotBlank(String field, String params) {
/* 2301 */     return andRLikeIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 2313 */     if (StringUtils.isBlank(params)) {
/* 2314 */       return this;
/*      */     }
/* 2316 */     return andRLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 2328 */     if (params == null) {
/* 2329 */       return this;
/*      */     }
/* 2331 */     return andRLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByAnd(String field, List<String> params) {
/* 2342 */     if (CollectionUtils.isEmpty(params)) {
/* 2343 */       return this;
/*      */     }
/* 2345 */     for (String param : params) {
/* 2346 */       andRLike(field, param);
/*      */     }
/* 2348 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 2361 */     if (!bool) {
/* 2362 */       return this;
/*      */     }
/* 2364 */     return andRLikeJoinByAnd(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 2375 */     return andRLikeJoinByAndIf(CollectionUtils.isNotEmpty(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 2387 */     if (CollectionUtils.isEmpty(params)) {
/* 2388 */       return this;
/*      */     }
/* 2390 */     return andRLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 2402 */     if (StringUtils.isBlank(params)) {
/* 2403 */       return this;
/*      */     }
/* 2405 */     return andRLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 2417 */     if (params == null) {
/* 2418 */       return this;
/*      */     }
/* 2420 */     return andRLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByOr(String field, List<String> params) {
/* 2432 */     if (CollectionUtils.isEmpty(params)) {
/* 2433 */       return this;
/*      */     }
/* 2435 */     if (params.size() == 1) {
/* 2436 */       return andRLike(field, params.get(0));
/*      */     }
/* 2438 */     Sql[] criteria = new Sql[params.size()];
/* 2439 */     for (int i = 0; i < params.size(); i++) {
/* 2440 */       criteria[i] = Criteria.rLike(field, params.get(i));
/*      */     }
/* 2442 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 2455 */     if (!bool) {
/* 2456 */       return this;
/*      */     }
/* 2458 */     return andRLikeJoinByOr(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 2469 */     return andRLikeJoinByOrIf(CollectionUtils.isNotEmpty(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 2481 */     if (CollectionUtils.isEmpty(params)) {
/* 2482 */       return this;
/*      */     }
/* 2484 */     return andRLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 2496 */     if (StringUtils.isBlank(params)) {
/* 2497 */       return this;
/*      */     }
/* 2499 */     return andRLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 2511 */     if (params == null) {
/* 2512 */       return this;
/*      */     }
/* 2514 */     return andRLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeFieldsJoinByOr(String params, String... fields) {
/* 2525 */     if (ArrayUtils.isEmpty((Object[])fields)) {
/* 2526 */       return this;
/*      */     }
/* 2528 */     if (fields.length == 1) {
/* 2529 */       return andRLike(fields[0], params);
/*      */     }
/* 2531 */     Sql[] criteria = new Sql[fields.length];
/* 2532 */     for (int i = 0; i < fields.length; i++) {
/* 2533 */       criteria[i] = Criteria.rLike(fields[i], params);
/*      */     }
/* 2535 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeFieldsJoinByOr(String params, List<String> fields) {
/* 2546 */     if (CollectionUtils.isEmpty(fields)) {
/* 2547 */       return this;
/*      */     }
/* 2549 */     if (fields.size() == 1) {
/* 2550 */       return andRLike(fields.get(0), params);
/*      */     }
/* 2552 */     Sql[] criteria = new Sql[fields.size()];
/* 2553 */     for (int i = 0; i < fields.size(); i++) {
/* 2554 */       criteria[i] = Criteria.rLike(fields.get(i), params);
/*      */     }
/* 2556 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 2569 */     if (!bool || ArrayUtils.isEmpty((Object[])fields)) {
/* 2570 */       return this;
/*      */     }
/* 2572 */     return andRLikeFieldsJoinByOr(params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 2584 */     if (!bool) {
/* 2585 */       return this;
/*      */     }
/* 2587 */     return andRLikeFieldsJoinByOr(params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 2598 */     return andRLikeFieldsJoinByOrIf(StringUtils.isNotBlank(params), params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andRLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 2609 */     return andRLikeFieldsJoinByOrIf(StringUtils.isNotBlank(params), params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotRLike(String field, String params) {
/* 2621 */     return and(Criteria.rNotLike(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotRLikeIf(boolean bool, String field, String params) {
/* 2633 */     if (!bool) {
/* 2634 */       return this;
/*      */     }
/* 2636 */     return andNotRLike(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotRLikeIfNotBlank(String field, String params) {
/* 2647 */     return andNotRLikeIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotRLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 2659 */     if (StringUtils.isBlank(params)) {
/* 2660 */       return this;
/*      */     }
/* 2662 */     return andNotRLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotRLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 2674 */     if (params == null) {
/* 2675 */       return this;
/*      */     }
/* 2677 */     return andNotRLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLike(String field, String params) {
/* 2688 */     return and(Criteria.like(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeIf(boolean bool, String field, String params) {
/* 2700 */     if (!bool) {
/* 2701 */       return this;
/*      */     }
/* 2703 */     return andLike(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeIfNotBlank(String field, String params) {
/* 2714 */     return andLikeIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 2726 */     if (StringUtils.isBlank(params)) {
/* 2727 */       return this;
/*      */     }
/* 2729 */     return andLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 2741 */     if (params == null) {
/* 2742 */       return this;
/*      */     }
/* 2744 */     return andLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByAnd(String field, List<String> params) {
/* 2755 */     if (CollectionUtils.isEmpty(params)) {
/* 2756 */       return this;
/*      */     }
/* 2758 */     for (String param : params) {
/* 2759 */       andLike(field, param);
/*      */     }
/* 2761 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 2774 */     if (!bool) {
/* 2775 */       return this;
/*      */     }
/* 2777 */     return andLikeJoinByAnd(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 2788 */     return andLikeJoinByAndIf(CollectionUtils.isNotEmpty(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 2800 */     if (CollectionUtils.isEmpty(params)) {
/* 2801 */       return this;
/*      */     }
/* 2803 */     return andLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 2815 */     if (StringUtils.isBlank(params)) {
/* 2816 */       return this;
/*      */     }
/* 2818 */     return andLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 2830 */     if (params == null) {
/* 2831 */       return this;
/*      */     }
/* 2833 */     return andLikeJoinByAnd(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByOr(String field, List<String> params) {
/* 2845 */     if (CollectionUtils.isEmpty(params)) {
/* 2846 */       return this;
/*      */     }
/* 2848 */     if (params.size() == 1) {
/* 2849 */       return andLike(field, params.get(0));
/*      */     }
/* 2851 */     Sql[] criteria = new Sql[params.size()];
/* 2852 */     for (int i = 0; i < params.size(); i++) {
/* 2853 */       criteria[i] = Criteria.like(field, params.get(i));
/*      */     }
/* 2855 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 2868 */     if (!bool) {
/* 2869 */       return this;
/*      */     }
/* 2871 */     return andLikeJoinByOr(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 2882 */     return andLikeJoinByOrIf(CollectionUtils.isNotEmpty(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 2894 */     if (CollectionUtils.isEmpty(params)) {
/* 2895 */       return this;
/*      */     }
/* 2897 */     return andLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 2909 */     if (StringUtils.isBlank(params)) {
/* 2910 */       return this;
/*      */     }
/* 2912 */     return andLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 2924 */     if (params == null) {
/* 2925 */       return this;
/*      */     }
/* 2927 */     return andLikeJoinByOr(field, (List<String>)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeFieldsJoinByOr(String params, String... fields) {
/* 2938 */     if (ArrayUtils.isEmpty((Object[])fields)) {
/* 2939 */       return this;
/*      */     }
/* 2941 */     if (fields.length == 1) {
/* 2942 */       return andLike(fields[0], params);
/*      */     }
/* 2944 */     Sql[] criteria = new Sql[fields.length];
/* 2945 */     for (int i = 0; i < fields.length; i++) {
/* 2946 */       criteria[i] = Criteria.like(fields[i], params);
/*      */     }
/* 2948 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeFieldsJoinByOr(String params, List<String> fields) {
/* 2959 */     if (CollectionUtils.isEmpty(fields)) {
/* 2960 */       return this;
/*      */     }
/* 2962 */     if (fields.size() == 1) {
/* 2963 */       return andLike(fields.get(0), params);
/*      */     }
/* 2965 */     Sql[] criteria = new Sql[fields.size()];
/* 2966 */     for (int i = 0; i < fields.size(); i++) {
/* 2967 */       criteria[i] = Criteria.like(fields.get(i), params);
/*      */     }
/* 2969 */     return andJoinByOr(criteria);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 2982 */     if (!bool || ArrayUtils.isEmpty((Object[])fields)) {
/* 2983 */       return this;
/*      */     }
/* 2985 */     return andLikeFieldsJoinByOr(params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 2997 */     if (!bool) {
/* 2998 */       return this;
/*      */     }
/* 3000 */     return andLikeFieldsJoinByOr(params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 3011 */     return andLikeFieldsJoinByOrIf(StringUtils.isNotBlank(params), params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 3022 */     return andLikeFieldsJoinByOrIf(StringUtils.isNotBlank(params), params, fields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLike(String field, String params) {
/* 3034 */     return and(Criteria.notLike(field, params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLikeIf(boolean bool, String field, String params) {
/* 3046 */     if (!bool) {
/* 3047 */       return this;
/*      */     }
/* 3049 */     return andNotLike(field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLikeIfNotBlank(String field, String params) {
/* 3060 */     return andNotLikeIf(StringUtils.isNotBlank(params), field, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 3072 */     if (StringUtils.isBlank(params)) {
/* 3073 */       return this;
/*      */     }
/* 3075 */     return andNotLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andNotLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 3087 */     if (params == null) {
/* 3088 */       return this;
/*      */     }
/* 3090 */     return andNotLike(field, (String)lazyParam.getParam());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsNull(String field) {
/* 3100 */     return and(Criteria.isNull(field));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsNullIf(boolean bool, String field) {
/* 3111 */     if (!bool) {
/* 3112 */       return this;
/*      */     }
/* 3114 */     return andIsNull(field);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsNotNull(String field) {
/* 3124 */     return and(Criteria.isNotNull(field));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsNotNullIf(boolean bool, String field) {
/* 3135 */     if (!bool) {
/* 3136 */       return this;
/*      */     }
/* 3138 */     return andIsNotNull(field);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsEmpty(String field) {
/* 3148 */     return and(Criteria.isEmpty(field));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsEmptyIf(boolean bool, String field) {
/* 3159 */     if (!bool) {
/* 3160 */       return this;
/*      */     }
/* 3162 */     return andIsEmpty(field);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsNotEmpty(String field) {
/* 3172 */     return and(Criteria.isNotEmpty(field));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsNotEmptyIf(boolean bool, String field) {
/* 3183 */     if (!bool) {
/* 3184 */       return this;
/*      */     }
/* 3186 */     return andIsNotEmpty(field);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsBlank(String field) {
/* 3196 */     return and(Criteria.isBlank(field));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsBlankIf(boolean bool, String field) {
/* 3207 */     if (!bool) {
/* 3208 */       return this;
/*      */     }
/* 3210 */     return andIsBlank(field);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsNotBlank(String field) {
/* 3220 */     return and(Criteria.isNotBlank(field));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIsNotBlankIf(boolean bool, String field) {
/* 3231 */     if (!bool) {
/* 3232 */       return this;
/*      */     }
/* 3234 */     return andIsNotBlank(field);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where and(Sql sql) {
/* 3244 */     if (!canAddWhere()) {
/* 3245 */       return this;
/*      */     }
/*      */     
/* 3248 */     if (sql == null) {
/* 3249 */       return this;
/*      */     }
/* 3251 */     this.refs.add(Ref.createAndSql(sql));
/* 3252 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where and(String sql) {
/* 3262 */     if (!canAddWhere()) {
/* 3263 */       return this;
/*      */     }
/*      */     
/* 3266 */     if (StringUtils.isBlank(sql)) {
/* 3267 */       return this;
/*      */     }
/* 3269 */     this.refs.add(Ref.createAndSql(Sql.sql(sql)));
/* 3270 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIf(boolean bool, LazySql<Sql> lazySql) {
/* 3281 */     if (!bool) {
/* 3282 */       return this;
/*      */     }
/* 3284 */     return and(lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIf(boolean bool, String sql) {
/* 3295 */     if (!bool) {
/* 3296 */       return this;
/*      */     }
/* 3298 */     return and(sql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIf(boolean bool, LazySql<Sql> trueLazySql, LazySql<Sql> falseLazySql) {
/* 3310 */     if (!canAddWhere()) {
/* 3311 */       return this;
/*      */     }
/* 3313 */     if (bool) {
/* 3314 */       return and(trueLazySql.getSql());
/*      */     }
/* 3316 */     return and(falseLazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIf(boolean bool, String trueSql, String falseSql) {
/* 3329 */     if (!canAddWhere()) {
/* 3330 */       return this;
/*      */     }
/* 3332 */     if (bool) {
/* 3333 */       return and(trueSql);
/*      */     }
/* 3335 */     return and(falseSql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIfNotNull(Object params, LazySql<Sql> lazySql) {
/* 3347 */     return andIf((params != null), lazySql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIfNotNull(Object params, String sql) {
/* 3358 */     return andIf((params != null), sql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIfNotBlank(String params, LazySql<Sql> lazySql) {
/* 3369 */     return andIf(StringUtils.isNotBlank(params), lazySql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIfNotBlank(String params, String sql) {
/* 3380 */     return andIf(StringUtils.isNotBlank(params), sql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIfNotEmpty(List<?> params, LazySql<Sql> lazySql) {
/* 3391 */     return andIf(CollectionUtils.isNotEmpty(params), lazySql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andIfNotEmpty(List<?> params, String sql) {
/* 3402 */     return andIf(CollectionUtils.isNotEmpty(params), sql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andJoinByOr(Sql... sqls) {
/* 3412 */     if (!canAddWhere()) {
/* 3413 */       return this;
/*      */     }
/* 3415 */     if (ArrayUtils.isEmpty((Object[])sqls)) {
/* 3416 */       return this;
/*      */     }
/* 3418 */     this.refs.add(Ref.createAndRef(
/* 3419 */           Ref.createOrSql(Arrays.asList(sqls))));
/*      */     
/* 3421 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andJoinByOr(List<Sql> sqls) {
/* 3431 */     if (!canAddWhere()) {
/* 3432 */       return this;
/*      */     }
/* 3434 */     if (CollectionUtils.isEmpty(sqls)) {
/* 3435 */       return this;
/*      */     }
/* 3437 */     this.refs.add(Ref.createAndRef(
/* 3438 */           Ref.createOrSql(sqls)));
/*      */     
/* 3440 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andJoinByOrIf(boolean bool, LazySqls<Sql> lazySqls) {
/* 3451 */     if (!canAddWhere()) {
/* 3452 */       return this;
/*      */     }
/* 3454 */     if (!bool || lazySqls == null) {
/* 3455 */       return this;
/*      */     }
/* 3457 */     return andJoinByOr(lazySqls.getSqls());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where or(Sql sql) {
/* 3467 */     if (!canAddWhere()) {
/* 3468 */       return this;
/*      */     }
/*      */     
/* 3471 */     if (sql == null) {
/* 3472 */       return this;
/*      */     }
/* 3474 */     this.refs.add(Ref.createOrSql(sql));
/* 3475 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where or(String sql) {
/* 3485 */     if (!canAddWhere()) {
/* 3486 */       return this;
/*      */     }
/*      */     
/* 3489 */     if (StringUtils.isBlank(sql)) {
/* 3490 */       return this;
/*      */     }
/* 3492 */     this.refs.add(Ref.createOrSql(Sql.sql(sql)));
/* 3493 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where orIf(boolean bool, String sql) {
/* 3504 */     if (!bool || StringUtils.isBlank(sql)) {
/* 3505 */       return this;
/*      */     }
/* 3507 */     return or(sql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where orIf(boolean bool, LazySql<Sql> lazySql) {
/* 3518 */     if (!bool || lazySql == null) {
/* 3519 */       return this;
/*      */     }
/* 3521 */     return or(lazySql.getSql());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where orJoinByAnd(Sql... sqls) {
/* 3531 */     if (!canAddWhere()) {
/* 3532 */       return this;
/*      */     }
/* 3534 */     if (ArrayUtils.isEmpty((Object[])sqls)) {
/* 3535 */       return this;
/*      */     }
/* 3537 */     this.refs.add(Ref.createOrRef(
/* 3538 */           Ref.createAndSql(Arrays.asList(sqls))));
/*      */     
/* 3540 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where orJoinByAnd(List<Sql> sqls) {
/* 3550 */     if (!canAddWhere()) {
/* 3551 */       return this;
/*      */     }
/* 3553 */     if (CollectionUtils.isEmpty(sqls)) {
/* 3554 */       return this;
/*      */     }
/* 3556 */     this.refs.add(Ref.createOrRef(
/* 3557 */           Ref.createAndSql(sqls)));
/*      */     
/* 3559 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where orJoinByAndIf(boolean bool, LazySqls<Sql> lazySqls) {
/* 3571 */     if (!bool) {
/* 3572 */       return this;
/*      */     }
/* 3574 */     return orJoinByAnd(lazySqls.getSqls());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andTreeFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelIdTagField, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 3590 */     return andIfNotNull(form, () -> Tree.tree(form.getLevelId(), form.isUp(), table, levelsField, levelIdField, levelIdTagField, form.getLevelNum(), levelNumField, filterSql, form.isLevelNumOnly(), form.isIncSelf()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andTreeFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelIdTagField, String levelNumField) {
/* 3618 */     return andIfNotNull(form, () -> Tree.tree(form.getLevelId(), form.isUp(), table, levelsField, levelIdField, levelIdTagField, form.getLevelNum(), levelNumField, null, form.isLevelNumOnly(), form.isIncSelf()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField) {
/* 3644 */     return andIfNotNull(form, () -> TreeMysql.tree(form.getLevelId(), form.isUp(), table, levelsField, levelIdField, form.getLevelNum(), form.isLevelNumOnly(), form.isIncSelf()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, Function<SelectWhere, Sql> filterSql) {
/* 3668 */     return andIfNotNull(form, () -> TreeMysql.tree(form.getLevelId(), form.isUp(), table, levelsField, levelIdField, form.getLevelNum(), filterSql, form.isLevelNumOnly(), form.isIncSelf()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelNumField) {
/* 3693 */     return andIfNotNull(form, () -> TreeMysql.tree(form.getLevelId(), form.isUp(), table, levelsField, levelIdField, form.getLevelNum(), levelNumField, null, form.isLevelNumOnly(), form.isIncSelf()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Where andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 3720 */     return andIfNotNull(form, () -> TreeMysql.tree(form.getLevelId(), form.isUp(), table, levelsField, levelIdField, form.getLevelNum(), levelNumField, filterSql, form.isLevelNumOnly(), form.isIncSelf()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder getSql() {
/* 3737 */     createSql(true);
/* 3738 */     return super.getSql();
/*      */   }
/*      */   
/*      */   protected String whereKey() {
/* 3742 */     return "where";
/*      */   }
/*      */   
/*      */   protected boolean canAddWhere() {
/* 3746 */     return true;
/*      */   }
/*      */   
/*      */   protected Where createSql(boolean hasFinish) {
/* 3750 */     if (this.hasCreate) {
/* 3751 */       return this;
/*      */     }
/* 3753 */     if (hasFinish) {
/* 3754 */       this.hasCreate = true;
/*      */     }
/* 3756 */     if (this.refs.isEmpty()) {
/* 3757 */       return this;
/*      */     }
/* 3759 */     boolean addWhereKey = true;
/* 3760 */     int whereCount = 0;
/* 3761 */     for (int i = 0; i < this.refs.size(); i++) {
/* 3762 */       Ref ref = this.refs.get(i);
/* 3763 */       Sql sql = ref.getSql();
/* 3764 */       if (sql != null && sql.getSql() != null && !StringUtils.isBlank(StringUtils.trim(sql.getSql().toString()))) {
/*      */ 
/*      */         
/* 3767 */         if (addWhereKey) {
/* 3768 */           addSql(whereKey(), new Object[0]);
/* 3769 */           addWhereKey = false;
/*      */         } else {
/* 3771 */           addSql(ref.getOp(), new Object[0]);
/*      */         } 
/* 3773 */         addSql(sql);
/* 3774 */         whereCount++;
/*      */       } 
/* 3776 */     }  this.refs.clear();
/* 3777 */     if (this.throwCount != null && this.throwCount.intValue() > 0 && 
/* 3778 */       whereCount < this.throwCount.intValue()) {
/* 3779 */       throw new RuntimeException(String.format("criteria count is %s,but need at least %s", new Object[] { Integer.valueOf(whereCount), this.throwCount }));
/*      */     }
/*      */     
/* 3782 */     return this;
/*      */   }
/*      */   
/*      */   private static class Ref
/*      */   {
/*      */     private final String op;
/*      */     private final List<Sql> sqlList;
/*      */     private final List<Ref> refList;
/*      */     
/*      */     public static Ref createAndSql(List<Sql> sqlList) {
/* 3792 */       return new Ref("and", sqlList, null);
/*      */     }
/*      */     
/*      */     public static Ref createAndSql(Sql sql) {
/* 3796 */       return new Ref("and", Arrays.asList(new Sql[] { sql }, ), null);
/*      */     }
/*      */     
/*      */     public static Ref createOrSql(List<Sql> sqlList) {
/* 3800 */       return new Ref("or", sqlList, null);
/*      */     }
/*      */     
/*      */     public static Ref createOrSql(Sql sql) {
/* 3804 */       return new Ref("or", Arrays.asList(new Sql[] { sql }, ), null);
/*      */     }
/*      */     
/*      */     public static Ref createAndRef(List<Ref> refList) {
/* 3808 */       return new Ref("and", null, refList);
/*      */     }
/*      */     
/*      */     public static Ref createAndRef(Ref ref) {
/* 3812 */       return new Ref("and", null, Arrays.asList(new Ref[] { ref }));
/*      */     }
/*      */     
/*      */     public static Ref createOrRef(Ref ref) {
/* 3816 */       return new Ref("or", null, Arrays.asList(new Ref[] { ref }));
/*      */     }
/*      */     
/*      */     public static Ref createOrRef(List<Ref> refList) {
/* 3820 */       return new Ref("or", null, refList);
/*      */     }
/*      */     
/*      */     private Ref(String op, List<Sql> sqlList, List<Ref> refList) {
/* 3824 */       this.op = op;
/* 3825 */       this.sqlList = sqlList;
/* 3826 */       this.refList = refList;
/*      */     }
/*      */     
/*      */     public String getOp() {
/* 3830 */       return this.op;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Sql getSql() {
/* 3836 */       if (this.sqlList != null) {
/* 3837 */         int size = this.sqlList.size();
/* 3838 */         if (size == 1) {
/* 3839 */           return this.sqlList.get(0);
/*      */         }
/*      */         
/* 3842 */         BaseSql baseSql = new BaseSql();
/* 3843 */         baseSql.addSql("(", new Object[0]);
/* 3844 */         for (int i = 0; i < this.sqlList.size(); i++) {
/* 3845 */           if (i > 0) {
/* 3846 */             baseSql.addSql(this.op, new Object[0]);
/*      */           }
/* 3848 */           Sql sql = this.sqlList.get(i);
/* 3849 */           baseSql.addSql(sql);
/*      */         } 
/* 3851 */         baseSql.addSql(")", new Object[0]);
/* 3852 */         return baseSql;
/*      */       } 
/*      */       
/* 3855 */       if (this.refList != null) {
/* 3856 */         int size = this.refList.size();
/* 3857 */         if (size == 1) {
/* 3858 */           return ((Ref)this.refList.get(0)).getSql();
/*      */         }
/*      */         
/* 3861 */         BaseSql baseSql = new BaseSql();
/* 3862 */         baseSql.addSql("(", new Object[0]);
/* 3863 */         for (int i = 0; i < this.refList.size(); i++) {
/* 3864 */           if (i > 0) {
/* 3865 */             baseSql.addSql(this.op, new Object[0]);
/*      */           }
/* 3867 */           Sql sql = ((Ref)this.refList.get(i)).getSql();
/* 3868 */           baseSql.addSql(sql);
/*      */         } 
/* 3870 */         baseSql.addSql(")", new Object[0]);
/* 3871 */         return baseSql;
/*      */       } 
/*      */       
/* 3874 */       return new BaseSql();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Where.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */