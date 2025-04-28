/*      */ package com.redare.devframework.sql;
/*      */ 
/*      */ import com.redare.devframework.common.pojo.LevelTreeQuery;
/*      */ import com.redare.devframework.sql.lazy.LazyParam;
/*      */ import com.redare.devframework.sql.lazy.LazySql;
/*      */ import com.redare.devframework.sql.lazy.LazySqls;
/*      */ import java.util.List;
/*      */ import java.util.function.Function;
/*      */ 
/*      */ public class SelectWhere
/*      */   extends Where
/*      */ {
/*      */   private final boolean whereAnd;
/*      */   
/*      */   protected SelectWhere(Sql sql) {
/*   16 */     this(sql, false);
/*      */   }
/*      */   
/*      */   protected SelectWhere(Sql sql, boolean whereAnd) {
/*   20 */     super(sql);
/*   21 */     this.whereAnd = whereAnd;
/*      */   }
/*      */   
/*      */   public Order orderBy() {
/*   25 */     return new Order(this);
/*      */   }
/*      */   
/*      */   public Group groupBy(String... fields) {
/*   29 */     return new Group(this, fields);
/*      */   }
/*      */ 
/*      */   
/*      */   protected String whereKey() {
/*   34 */     return this.whereAnd ? "and" : "where";
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere throwRunExceptionWhenCriteriaCountLess(int count) {
/*   39 */     super.throwRunExceptionWhenCriteriaCountLess(count);
/*   40 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqs(String... fields) {
/*   45 */     super.andEqs(fields);
/*   46 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqs(String... fields) {
/*   51 */     super.andNotEqs(fields);
/*   52 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLts(String... fields) {
/*   57 */     super.andLts(fields);
/*   58 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGts(String... fields) {
/*   63 */     super.andGts(fields);
/*   64 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqs(String... fields) {
/*   69 */     super.andLtEqs(fields);
/*   70 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqs(String... fields) {
/*   75 */     super.andGtEqs(fields);
/*   76 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqField(String field1, String field2) {
/*   81 */     super.andEqField(field1, field2);
/*   82 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqFieldIf(boolean bool, String field1, String field2) {
/*   87 */     super.andEqFieldIf(bool, field1, field2);
/*   88 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEq(String field, Object params) {
/*   93 */     super.andEq(field, params);
/*   94 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEq(String field, Sql sql) {
/*   99 */     super.andEq(field, sql);
/*  100 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIf(boolean bool, String field, Object params) {
/*  105 */     super.andEqIf(bool, field, params);
/*  106 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  111 */     super.andEqIf(bool, field, lazyParam);
/*  112 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  117 */     super.andEqIf(bool, field, lazySql);
/*  118 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIfNotNull(String field, Object params) {
/*  123 */     super.andEqIfNotNull(field, params);
/*  124 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  129 */     super.andEqIfNotNull(field, params, lazyParam);
/*  130 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  135 */     super.andEqIfNotNull(field, params, lazySql);
/*  136 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIfNotBlank(String field, String params) {
/*  141 */     super.andEqIfNotBlank(field, params);
/*  142 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  147 */     super.andEqIfNotBlank(field, params, lazyParam);
/*  148 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  153 */     super.andEqIfNotBlank(field, params, lazySql);
/*  154 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEq(String field, Object params) {
/*  159 */     super.andNotEq(field, params);
/*  160 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEq(String field, Sql sql) {
/*  165 */     super.andNotEq(field, sql);
/*  166 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIf(boolean bool, String field, Object params) {
/*  171 */     super.andNotEqIf(bool, field, params);
/*  172 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  177 */     super.andNotEqIf(bool, field, lazyParam);
/*  178 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIf(boolean bool, String field, LazySql<Sql> sql) {
/*  183 */     super.andNotEqIf(bool, field, sql);
/*  184 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIfNotNull(String field, Object params) {
/*  189 */     super.andNotEqIfNotNull(field, params);
/*  190 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  195 */     super.andNotEqIfNotNull(field, params, lazyParam);
/*  196 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  201 */     super.andNotEqIfNotNull(field, params, lazySql);
/*  202 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIfNotBlank(String field, String params) {
/*  207 */     super.andNotEqIfNotBlank(field, params);
/*  208 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  213 */     super.andNotEqIfNotBlank(field, params, lazyParam);
/*  214 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  219 */     super.andNotEqIfNotBlank(field, params, lazySql);
/*  220 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLt(String field, Object params) {
/*  225 */     super.andLt(field, params);
/*  226 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLt(String field, Sql sql) {
/*  231 */     super.andLt(field, sql);
/*  232 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIf(boolean bool, String field, Object params) {
/*  237 */     super.andLtIf(bool, field, params);
/*  238 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  243 */     super.andLtIf(bool, field, lazyParam);
/*  244 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  249 */     super.andLtIf(bool, field, lazySql);
/*  250 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIfNotNull(String field, Object params) {
/*  255 */     super.andLtIfNotNull(field, params);
/*  256 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  261 */     super.andLtIfNotNull(field, params, lazyParam);
/*  262 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  267 */     super.andLtIfNotNull(field, params, lazySql);
/*  268 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIfNotBlank(String field, String params) {
/*  273 */     super.andLtIfNotBlank(field, params);
/*  274 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  279 */     super.andLtIfNotBlank(field, params, lazyParam);
/*  280 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  285 */     super.andLtIfNotBlank(field, params, lazySql);
/*  286 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEq(String field, Object params) {
/*  291 */     super.andLtEq(field, params);
/*  292 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEq(String field, Sql sql) {
/*  297 */     super.andLtEq(field, sql);
/*  298 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIf(boolean bool, String field, Object params) {
/*  303 */     super.andLtEqIf(bool, field, params);
/*  304 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  309 */     super.andLtEqIf(bool, field, lazyParam);
/*  310 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  315 */     super.andLtEqIf(bool, field, lazySql);
/*  316 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIfNotNull(String field, Object params) {
/*  321 */     super.andLtEqIfNotNull(field, params);
/*  322 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  327 */     super.andLtEqIfNotNull(field, params, lazyParam);
/*  328 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  333 */     super.andLtEqIfNotNull(field, params, lazySql);
/*  334 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIfNotBlank(String field, String params) {
/*  339 */     super.andLtEqIfNotBlank(field, params);
/*  340 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  345 */     super.andLtEqIfNotBlank(field, params, lazyParam);
/*  346 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLtEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  351 */     super.andLtEqIfNotBlank(field, params, lazySql);
/*  352 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGt(String field, Object params) {
/*  357 */     super.andGt(field, params);
/*  358 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGt(String field, Sql sql) {
/*  363 */     super.andGt(field, sql);
/*  364 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIf(boolean bool, String field, Object params) {
/*  369 */     super.andGtIf(bool, field, params);
/*  370 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  375 */     super.andGtIf(bool, field, lazyParam);
/*  376 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  381 */     super.andGtIf(bool, field, lazySql);
/*  382 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIfNotNull(String field, Object params) {
/*  387 */     super.andGtIfNotNull(field, params);
/*  388 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  393 */     super.andGtIfNotNull(field, params, lazyParam);
/*  394 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  399 */     super.andGtIfNotNull(field, params, lazySql);
/*  400 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIfNotBlank(String field, String params) {
/*  405 */     super.andGtIfNotBlank(field, params);
/*  406 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  411 */     super.andGtIfNotBlank(field, params, lazyParam);
/*  412 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  417 */     super.andGtIfNotBlank(field, params, lazySql);
/*  418 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEq(String field, Object params) {
/*  423 */     super.andGtEq(field, params);
/*  424 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEq(String field, Sql sql) {
/*  429 */     super.andGtEq(field, sql);
/*  430 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIf(boolean bool, String field, Object params) {
/*  435 */     super.andGtEqIf(bool, field, params);
/*  436 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  441 */     super.andGtEqIf(bool, field, lazyParam);
/*  442 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  447 */     super.andGtEqIf(bool, field, lazySql);
/*  448 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIfNotNull(String field, Object params) {
/*  453 */     super.andGtEqIfNotNull(field, params);
/*  454 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  459 */     super.andGtEqIfNotNull(field, params, lazyParam);
/*  460 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  465 */     super.andGtEqIfNotNull(field, params, lazySql);
/*  466 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIfNotBlank(String field, String params) {
/*  471 */     super.andGtEqIfNotBlank(field, params);
/*  472 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  477 */     super.andGtEqIfNotBlank(field, params, lazyParam);
/*  478 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andGtEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  483 */     super.andGtEqIfNotBlank(field, params, lazySql);
/*  484 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetween(String field, Object param1, Object param2) {
/*  489 */     super.andBetween(field, param1, param2);
/*  490 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenIf(boolean bool, String field, Object param1, Object param2) {
/*  495 */     super.andBetweenIf(bool, field, param1, param2);
/*  496 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenOption(String field, Object param1, Object param2) {
/*  501 */     super.andBetweenOption(field, param1, param2);
/*  502 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenOption(String field, String param1, String param2) {
/*  507 */     super.andBetweenOption(field, param1, param2);
/*  508 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenOptionIf(boolean bool, String field, Object param1, Object param2) {
/*  513 */     super.andBetweenOptionIf(bool, field, param1, param2);
/*  514 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenOptionIf(boolean bool, String field, String param1, String param2) {
/*  519 */     super.andBetweenOptionIf(bool, field, param1, param2);
/*  520 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenOption(String field1, String field2, Object param1, Object param2) {
/*  525 */     super.andBetweenOption(field1, field2, param1, param2);
/*  526 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenOption(String field1, String field2, String param1, String param2) {
/*  531 */     super.andBetweenOption(field1, field2, param1, param2);
/*  532 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenOptionIf(boolean bool, String field1, String field2, Object param1, Object param2) {
/*  537 */     super.andBetweenOptionIf(bool, field1, field2, param1, param2);
/*  538 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBetweenOptionIf(boolean bool, String field1, String field2, String param1, String param2) {
/*  543 */     super.andBetweenOptionIf(bool, field1, field2, param1, param2);
/*  544 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIn(String field, List<?> params) {
/*  549 */     super.andIn(field, params);
/*  550 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIn(String field, Sql sql) {
/*  555 */     super.andIn(field, sql);
/*  556 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andInIf(boolean bool, String field, List<?> params) {
/*  561 */     super.andInIf(bool, field, params);
/*  562 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andInIf(boolean bool, String field, LazyParam<List<?>> params) {
/*  567 */     super.andInIf(bool, field, params);
/*  568 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andInIf(boolean bool, String field, LazySql<Sql> sql) {
/*  573 */     super.andInIf(bool, field, sql);
/*  574 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andInIfNotEmpty(String field, List<?> params) {
/*  579 */     super.andInIfNotEmpty(field, params);
/*  580 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andInIfNotEmpty(String field, List<?> params, LazyParam<List<?>> lazyParam) {
/*  585 */     super.andInIfNotEmpty(field, params, lazyParam);
/*  586 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andInIfNotEmpty(String field, List<?> params, LazySql<Sql> lazySql) {
/*  591 */     super.andInIfNotEmpty(field, params, lazySql);
/*  592 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotIn(String field, List<?> params) {
/*  597 */     super.andNotIn(field, params);
/*  598 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotIn(String field, Sql sql) {
/*  603 */     super.andNotIn(field, sql);
/*  604 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotInIf(boolean bool, String field, List<?> params) {
/*  609 */     super.andNotInIf(bool, field, params);
/*  610 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotInIf(boolean bool, String field, LazyParam<List<?>> params) {
/*  615 */     super.andNotInIf(bool, field, params);
/*  616 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotInIf(boolean bool, String field, LazySql<Sql> sql) {
/*  621 */     super.andNotInIf(bool, field, sql);
/*  622 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotInIfNotEmpty(String field, List<?> params) {
/*  627 */     super.andNotInIfNotEmpty(field, params);
/*  628 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotInIfNotEmpty(String field, List<?> params, LazyParam<List<?>> lazyParam) {
/*  633 */     super.andNotInIfNotEmpty(field, params, lazyParam);
/*  634 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotInIfNotEmpty(String field, List<?> params, LazySql<Sql> lazySql) {
/*  639 */     super.andNotInIfNotEmpty(field, params, lazySql);
/*  640 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLike(String field, String params) {
/*  645 */     super.andBLike(field, params);
/*  646 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeIf(boolean bool, String field, String params) {
/*  651 */     super.andBLikeIf(bool, field, params);
/*  652 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeIfNotBlank(String field, String params) {
/*  657 */     super.andBLikeIfNotBlank(field, params);
/*  658 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/*  663 */     super.andBLikeIfNotBlank(field, params, lazyParam);
/*  664 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/*  669 */     super.andBLikeIfNotNull(field, params, lazyParam);
/*  670 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByAnd(String field, List<String> params) {
/*  675 */     super.andBLikeJoinByAnd(field, params);
/*  676 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/*  681 */     super.andBLikeJoinByAndIf(bool, field, params);
/*  682 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/*  687 */     super.andBLikeJoinByAndIfNotEmpty(field, params);
/*  688 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/*  693 */     super.andBLikeJoinByAndIfNotEmpty(field, params, lazyParam);
/*  694 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/*  699 */     super.andBLikeJoinByAndIfNotBlank(field, params, lazyParam);
/*  700 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/*  705 */     super.andBLikeJoinByAndIfNotNull(field, params, lazyParam);
/*  706 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByOr(String field, List<String> params) {
/*  711 */     super.andBLikeJoinByOr(field, params);
/*  712 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/*  717 */     super.andBLikeJoinByOrIf(bool, field, params);
/*  718 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/*  723 */     super.andBLikeJoinByOrIfNotEmpty(field, params);
/*  724 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/*  729 */     super.andBLikeJoinByOrIfNotEmpty(field, params, lazyParam);
/*  730 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/*  735 */     super.andBLikeJoinByOrIfNotBlank(field, params, lazyParam);
/*  736 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/*  741 */     super.andBLikeJoinByOrIfNotNull(field, params, lazyParam);
/*  742 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeFieldsJoinByOr(String params, String... fields) {
/*  747 */     super.andBLikeFieldsJoinByOr(params, fields);
/*  748 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeFieldsJoinByOr(String params, List<String> fields) {
/*  753 */     super.andBLikeFieldsJoinByOr(params, fields);
/*  754 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/*  759 */     super.andBLikeFieldsJoinByOrIf(bool, params, fields);
/*  760 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/*  765 */     super.andBLikeFieldsJoinByOrIf(bool, params, fields);
/*  766 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/*  771 */     super.andBLikeFieldsJoinByOrIfNotBlank(params, fields);
/*  772 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andBLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/*  777 */     super.andBLikeFieldsJoinByOrIfNotBlank(params, fields);
/*  778 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotBLike(String field, String params) {
/*  783 */     super.andNotBLike(field, params);
/*  784 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotBLikeIf(boolean bool, String field, String params) {
/*  789 */     super.andNotBLikeIf(bool, field, params);
/*  790 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotBLikeIfNotBlank(String field, String params) {
/*  795 */     super.andNotBLikeIfNotBlank(field, params);
/*  796 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotBLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/*  801 */     super.andNotBLikeIfNotBlank(field, params, lazyParam);
/*  802 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotBLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/*  807 */     super.andNotBLikeIfNotNull(field, params, lazyParam);
/*  808 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLike(String field, String params) {
/*  813 */     super.andLLike(field, params);
/*  814 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeIf(boolean bool, String field, String params) {
/*  819 */     super.andLLikeIf(bool, field, params);
/*  820 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeIfNotBlank(String field, String params) {
/*  825 */     super.andLLikeIfNotBlank(field, params);
/*  826 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/*  831 */     super.andLLikeIfNotBlank(field, params, lazyParam);
/*  832 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/*  837 */     super.andLLikeIfNotNull(field, params, lazyParam);
/*  838 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByAnd(String field, List<String> params) {
/*  843 */     super.andLLikeJoinByAnd(field, params);
/*  844 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/*  849 */     super.andLLikeJoinByAndIf(bool, field, params);
/*  850 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/*  855 */     super.andLLikeJoinByAndIfNotEmpty(field, params);
/*  856 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/*  861 */     super.andLLikeJoinByAndIfNotEmpty(field, params, lazyParam);
/*  862 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/*  867 */     super.andLLikeJoinByAndIfNotBlank(field, params, lazyParam);
/*  868 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/*  873 */     super.andLLikeJoinByAndIfNotNull(field, params, lazyParam);
/*  874 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByOr(String field, List<String> params) {
/*  879 */     super.andLLikeJoinByOr(field, params);
/*  880 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/*  885 */     super.andLLikeJoinByOrIf(bool, field, params);
/*  886 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/*  891 */     super.andLLikeJoinByOrIfNotEmpty(field, params);
/*  892 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/*  897 */     super.andLLikeJoinByOrIfNotEmpty(field, params, lazyParam);
/*  898 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/*  903 */     super.andLLikeJoinByOrIfNotBlank(field, params, lazyParam);
/*  904 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/*  909 */     super.andLLikeJoinByOrIfNotNull(field, params, lazyParam);
/*  910 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeFieldsJoinByOr(String params, String... fields) {
/*  915 */     super.andLLikeFieldsJoinByOr(params, fields);
/*  916 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeFieldsJoinByOr(String params, List<String> fields) {
/*  921 */     super.andLLikeFieldsJoinByOr(params, fields);
/*  922 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/*  927 */     super.andLLikeFieldsJoinByOrIf(bool, params, fields);
/*  928 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/*  933 */     super.andLLikeFieldsJoinByOrIf(bool, params, fields);
/*  934 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/*  939 */     super.andLLikeFieldsJoinByOrIfNotBlank(params, fields);
/*  940 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/*  945 */     super.andLLikeFieldsJoinByOrIfNotBlank(params, fields);
/*  946 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLLike(String field, String params) {
/*  951 */     super.andNotLLike(field, params);
/*  952 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLLikeIf(boolean bool, String field, String params) {
/*  957 */     super.andNotLLikeIf(bool, field, params);
/*  958 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLLikeIfNotBlank(String field, String params) {
/*  963 */     super.andNotLLikeIfNotBlank(field, params);
/*  964 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/*  969 */     super.andNotLLikeIfNotBlank(field, params, lazyParam);
/*  970 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/*  975 */     super.andNotLLikeIfNotNull(field, params, lazyParam);
/*  976 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLike(String field, String params) {
/*  981 */     super.andRLike(field, params);
/*  982 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeIf(boolean bool, String field, String params) {
/*  987 */     super.andRLikeIf(bool, field, params);
/*  988 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeIfNotBlank(String field, String params) {
/*  993 */     super.andRLikeIfNotBlank(field, params);
/*  994 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/*  999 */     super.andRLikeIfNotBlank(field, params, lazyParam);
/* 1000 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1005 */     super.andRLikeIfNotNull(field, params, lazyParam);
/* 1006 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByAnd(String field, List<String> params) {
/* 1011 */     super.andRLikeJoinByAnd(field, params);
/* 1012 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 1017 */     super.andRLikeJoinByAndIf(bool, field, params);
/* 1018 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 1023 */     super.andRLikeJoinByAndIfNotEmpty(field, params);
/* 1024 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1029 */     super.andRLikeJoinByAndIfNotEmpty(field, params, lazyParam);
/* 1030 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1035 */     super.andRLikeJoinByAndIfNotBlank(field, params, lazyParam);
/* 1036 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1041 */     super.andRLikeJoinByAndIfNotNull(field, params, lazyParam);
/* 1042 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByOr(String field, List<String> params) {
/* 1047 */     super.andRLikeJoinByOr(field, params);
/* 1048 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 1053 */     super.andRLikeJoinByOrIf(bool, field, params);
/* 1054 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 1059 */     super.andRLikeJoinByOrIfNotEmpty(field, params);
/* 1060 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1065 */     super.andRLikeJoinByOrIfNotEmpty(field, params, lazyParam);
/* 1066 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1071 */     super.andRLikeJoinByOrIfNotBlank(field, params, lazyParam);
/* 1072 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1077 */     super.andRLikeJoinByOrIfNotNull(field, params, lazyParam);
/* 1078 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeFieldsJoinByOr(String params, String... fields) {
/* 1083 */     super.andRLikeFieldsJoinByOr(params, fields);
/* 1084 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeFieldsJoinByOr(String params, List<String> fields) {
/* 1089 */     super.andRLikeFieldsJoinByOr(params, fields);
/* 1090 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 1095 */     super.andRLikeFieldsJoinByOrIf(bool, params, fields);
/* 1096 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 1101 */     super.andRLikeFieldsJoinByOrIf(bool, params, fields);
/* 1102 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 1107 */     super.andRLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1108 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andRLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 1113 */     super.andRLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1114 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotRLike(String field, String params) {
/* 1119 */     super.andNotRLike(field, params);
/* 1120 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotRLikeIf(boolean bool, String field, String params) {
/* 1125 */     super.andNotRLikeIf(bool, field, params);
/* 1126 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotRLikeIfNotBlank(String field, String params) {
/* 1131 */     super.andNotRLikeIfNotBlank(field, params);
/* 1132 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotRLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1137 */     super.andNotRLikeIfNotBlank(field, params, lazyParam);
/* 1138 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotRLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1143 */     super.andNotRLikeIfNotNull(field, params, lazyParam);
/* 1144 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLike(String field, String params) {
/* 1149 */     super.andLike(field, params);
/* 1150 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeIf(boolean bool, String field, String params) {
/* 1155 */     super.andLikeIf(bool, field, params);
/* 1156 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeIfNotBlank(String field, String params) {
/* 1161 */     super.andLikeIfNotBlank(field, params);
/* 1162 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1167 */     super.andLikeIfNotBlank(field, params, lazyParam);
/* 1168 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1173 */     super.andLikeIfNotNull(field, params, lazyParam);
/* 1174 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByAnd(String field, List<String> params) {
/* 1179 */     super.andLikeJoinByAnd(field, params);
/* 1180 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 1185 */     super.andLikeJoinByAndIf(bool, field, params);
/* 1186 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 1191 */     super.andLikeJoinByAndIfNotEmpty(field, params);
/* 1192 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1197 */     super.andLikeJoinByAndIfNotEmpty(field, params, lazyParam);
/* 1198 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1203 */     super.andLikeJoinByAndIfNotBlank(field, params, lazyParam);
/* 1204 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1209 */     super.andLikeJoinByAndIfNotNull(field, params, lazyParam);
/* 1210 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByOr(String field, List<String> params) {
/* 1215 */     super.andLikeJoinByOr(field, params);
/* 1216 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 1221 */     super.andLikeJoinByOrIf(bool, field, params);
/* 1222 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 1227 */     super.andLikeJoinByOrIfNotEmpty(field, params);
/* 1228 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1233 */     super.andLikeJoinByOrIfNotEmpty(field, params, lazyParam);
/* 1234 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1239 */     super.andLikeJoinByOrIfNotBlank(field, params, lazyParam);
/* 1240 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1245 */     super.andLikeJoinByOrIfNotNull(field, params, lazyParam);
/* 1246 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeFieldsJoinByOr(String params, String... fields) {
/* 1251 */     super.andLikeFieldsJoinByOr(params, fields);
/* 1252 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeFieldsJoinByOr(String params, List<String> fields) {
/* 1257 */     super.andLikeFieldsJoinByOr(params, fields);
/* 1258 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 1263 */     super.andLikeFieldsJoinByOrIf(bool, params, fields);
/* 1264 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 1269 */     super.andLikeFieldsJoinByOrIf(bool, params, fields);
/* 1270 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 1275 */     super.andLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1276 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 1281 */     super.andLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1282 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLike(String field, String params) {
/* 1287 */     super.andNotLike(field, params);
/* 1288 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLikeIf(boolean bool, String field, String params) {
/* 1293 */     super.andNotLikeIf(bool, field, params);
/* 1294 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLikeIfNotBlank(String field, String params) {
/* 1299 */     super.andNotLikeIfNotBlank(field, params);
/* 1300 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1305 */     super.andNotLikeIfNotBlank(field, params, lazyParam);
/* 1306 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andNotLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1311 */     super.andNotLikeIfNotNull(field, params, lazyParam);
/* 1312 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsNull(String field) {
/* 1317 */     super.andIsNull(field);
/* 1318 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsNullIf(boolean bool, String field) {
/* 1323 */     super.andIsNullIf(bool, field);
/* 1324 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsNotNull(String field) {
/* 1329 */     super.andIsNotNull(field);
/* 1330 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsNotNullIf(boolean bool, String field) {
/* 1335 */     super.andIsNotNullIf(bool, field);
/* 1336 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsEmpty(String field) {
/* 1341 */     super.andIsEmpty(field);
/* 1342 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsEmptyIf(boolean bool, String field) {
/* 1347 */     super.andIsEmptyIf(bool, field);
/* 1348 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsNotEmpty(String field) {
/* 1353 */     super.andIsNotEmpty(field);
/* 1354 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsNotEmptyIf(boolean bool, String field) {
/* 1359 */     super.andIsNotEmptyIf(bool, field);
/* 1360 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsBlank(String field) {
/* 1365 */     super.andIsBlank(field);
/* 1366 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsBlankIf(boolean bool, String field) {
/* 1371 */     super.andIsBlankIf(bool, field);
/* 1372 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsNotBlank(String field) {
/* 1377 */     super.andIsNotBlank(field);
/* 1378 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIsNotBlankIf(boolean bool, String field) {
/* 1383 */     super.andIsNotBlankIf(bool, field);
/* 1384 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere and(Sql sql) {
/* 1389 */     super.and(sql);
/* 1390 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere and(String sql) {
/* 1395 */     super.and(sql);
/* 1396 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIf(boolean bool, LazySql<Sql> lazySql) {
/* 1401 */     super.andIf(bool, lazySql);
/* 1402 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIf(boolean bool, String sql) {
/* 1407 */     super.andIf(bool, sql);
/* 1408 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIf(boolean bool, LazySql<Sql> trueLazySql, LazySql<Sql> falseLazySql) {
/* 1413 */     super.andIf(bool, trueLazySql, falseLazySql);
/* 1414 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIf(boolean bool, String trueSql, String falseSql) {
/* 1419 */     super.andIf(bool, trueSql, falseSql);
/* 1420 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIfNotNull(Object params, LazySql<Sql> lazySql) {
/* 1425 */     super.andIfNotNull(params, lazySql);
/* 1426 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIfNotNull(Object params, String sql) {
/* 1431 */     super.andIfNotNull(params, sql);
/* 1432 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIfNotBlank(String params, LazySql<Sql> lazySql) {
/* 1437 */     super.andIfNotBlank(params, lazySql);
/* 1438 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIfNotBlank(String params, String sql) {
/* 1443 */     super.andIfNotBlank(params, sql);
/* 1444 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIfNotEmpty(List<?> params, LazySql<Sql> lazySql) {
/* 1449 */     super.andIfNotEmpty(params, lazySql);
/* 1450 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andIfNotEmpty(List<?> params, String sql) {
/* 1455 */     super.andIfNotEmpty(params, sql);
/* 1456 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andJoinByOr(Sql... sqls) {
/* 1461 */     super.andJoinByOr(sqls);
/* 1462 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andJoinByOr(List<Sql> sqls) {
/* 1467 */     super.andJoinByOr(sqls);
/* 1468 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andJoinByOrIf(boolean bool, LazySqls<Sql> lazySqls) {
/* 1473 */     super.andJoinByOrIf(bool, lazySqls);
/* 1474 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere or(Sql sql) {
/* 1479 */     super.or(sql);
/* 1480 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere or(String sql) {
/* 1485 */     super.or(sql);
/* 1486 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere orIf(boolean bool, String sql) {
/* 1491 */     super.orIf(bool, sql);
/* 1492 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere orIf(boolean bool, LazySql<Sql> lazySql) {
/* 1497 */     super.orIf(bool, lazySql);
/* 1498 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere orJoinByAnd(Sql... sqls) {
/* 1503 */     super.orJoinByAnd(sqls);
/* 1504 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere orJoinByAnd(List<Sql> sqls) {
/* 1509 */     super.orJoinByAnd(sqls);
/* 1510 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere orJoinByAndIf(boolean bool, LazySqls<Sql> lazySqls) {
/* 1515 */     super.orJoinByAndIf(bool, lazySqls);
/* 1516 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andTreeFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelIdTagField, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 1521 */     super.andTreeFilter(form, table, levelsField, levelIdField, levelIdTagField, levelNumField, filterSql);
/* 1522 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andTreeFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelIdTagField, String levelNumField) {
/* 1527 */     super.andTreeFilter(form, table, levelsField, levelIdField, levelIdTagField, levelNumField);
/* 1528 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField) {
/* 1533 */     super.andTreeMysqlFilter(form, table, levelsField, levelIdField);
/* 1534 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, Function<SelectWhere, Sql> filterSql) {
/* 1539 */     super.andTreeMysqlFilter(form, table, levelsField, levelIdField, filterSql);
/* 1540 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelNumField) {
/* 1545 */     super.andTreeMysqlFilter(form, table, levelsField, levelIdField, levelNumField);
/* 1546 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectWhere andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 1551 */     super.andTreeMysqlFilter(form, table, levelsField, levelIdField, levelNumField, filterSql);
/* 1552 */     return this;
/*      */   }
/*      */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/SelectWhere.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */