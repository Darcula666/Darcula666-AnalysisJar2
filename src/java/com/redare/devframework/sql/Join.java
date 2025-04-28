/*      */ package com.redare.devframework.sql;
/*      */ 
/*      */ import com.redare.devframework.common.pojo.LevelTreeQuery;
/*      */ import com.redare.devframework.sql.lazy.LazyParam;
/*      */ import com.redare.devframework.sql.lazy.LazySql;
/*      */ import com.redare.devframework.sql.lazy.LazySqls;
/*      */ import java.util.List;
/*      */ import java.util.function.Function;
/*      */ 
/*      */ public class Join
/*      */   extends SelectWhere
/*      */ {
/*      */   boolean join;
/*      */   
/*      */   protected Join(Sql sql, boolean join, String type, String table, String alias) {
/*   16 */     super(sql);
/*   17 */     this.join = join;
/*   18 */     addJoinKey(type, table, alias);
/*      */   }
/*      */   
/*      */   protected Join(Sql sql, String type, Sql table, String alias) {
/*   22 */     super(sql);
/*   23 */     this.join = true;
/*   24 */     addJoinKey(type, table, alias);
/*      */   }
/*      */   
/*      */   private Join addJoinKey(String type, String table, String alias) {
/*   28 */     if (this.join)
/*   29 */     { switch (type)
/*      */       { case "left":
/*   31 */           addSql("left join", new Object[0]).addSql(table, new Object[0]).addSql(alias, new Object[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*   41 */           return this;case "right": addSql("right join", new Object[0]).addSql(table, new Object[0]).addSql(alias, new Object[0]); return this; }  addSql("join", new Object[0]).addSql(table, new Object[0]).addSql(alias, new Object[0]); }  return this;
/*      */   }
/*      */   
/*      */   private Join addJoinKey(String type, Sql sql, String alias) {
/*   45 */     if (this.join) {
/*   46 */       addJoinKey(type, String.format("(%s)", new Object[] { sql.toString() }), alias);
/*   47 */       addParams(sql.getParams());
/*      */     } 
/*   49 */     return this;
/*      */   }
/*      */   
/*      */   protected String whereKey() {
/*   53 */     return "and";
/*      */   }
/*      */   
/*      */   protected boolean canAddWhere() {
/*   57 */     return this.join;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Join on(String field1, String field2) {
/*   68 */     if (this.join) {
/*   69 */       addSql("on", new Object[0]).addSql(field1, new Object[0]).addSql("=", new Object[0]).addSql(field2, new Object[0]);
/*      */     }
/*   71 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Join on(Sql sql) {
/*   81 */     if (this.join) {
/*   82 */       addSql("on", new Object[0]).addSql(sql);
/*      */     }
/*   84 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Join on(String sql) {
/*   94 */     if (this.join) {
/*   95 */       addSql("on", new Object[0]).addSql(sql, new Object[0]);
/*      */     }
/*   97 */     return this;
/*      */   }
/*      */   
/*      */   public Join join(String table, String alias) {
/*  101 */     return joinIf(true, table, alias);
/*      */   }
/*      */   
/*      */   public Join join(Sql table, String alias) {
/*  105 */     return join("inner", table, alias);
/*      */   }
/*      */   
/*      */   public Join joinIf(boolean bool, String table, String alias) {
/*  109 */     return joinIf(bool, "inner", table, alias);
/*      */   }
/*      */   
/*      */   public Join joinIf(boolean bool, LazySql<Sql> sql, String alias) {
/*  113 */     return joinIf(bool, "inner", sql, alias);
/*      */   }
/*      */   
/*      */   public Join joinIf(boolean bool, Sql sql, String alias) {
/*  117 */     return joinIf(bool, "inner", sql, alias);
/*      */   }
/*      */   
/*      */   public Join leftJoin(String table, String alias) {
/*  121 */     return leftJoinIf(true, table, alias);
/*      */   }
/*      */   
/*      */   public Join leftJoin(Sql table, String alias) {
/*  125 */     return join("left", table, alias);
/*      */   }
/*      */   
/*      */   public Join leftJoinIf(boolean bool, String table, String alias) {
/*  129 */     return joinIf(bool, "left", table, alias);
/*      */   }
/*      */   
/*      */   public Join leftJoinIf(boolean bool, LazySql<Sql> sql, String alias) {
/*  133 */     return joinIf(bool, "left", sql, alias);
/*      */   }
/*      */   
/*      */   public Join leftJoinIf(boolean bool, Sql sql, String alias) {
/*  137 */     return joinIf(bool, "left", sql, alias);
/*      */   }
/*      */   
/*      */   public Join rightJoin(String table, String alias) {
/*  141 */     return rightJoinIf(true, table, alias);
/*      */   }
/*      */   
/*      */   public Join rightJoin(Sql table, String alias) {
/*  145 */     return join("right", table, alias);
/*      */   }
/*      */   
/*      */   public Join rightJoinIf(boolean bool, String table, String alias) {
/*  149 */     return joinIf(bool, "right", table, alias);
/*      */   }
/*      */   
/*      */   public Join rightJoinIf(boolean bool, LazySql<Sql> sql, String alias) {
/*  153 */     return joinIf(bool, "right", sql, alias);
/*      */   }
/*      */   
/*      */   public Join rightJoinIf(boolean bool, Sql sql, String alias) {
/*  157 */     return joinIf(bool, "right", sql, alias);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Join endJoinIf() {
/*  166 */     if (this.join) {
/*  167 */       createSql(false);
/*      */     }
/*  169 */     this.join = true;
/*  170 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SelectWhere where() {
/*  179 */     if (this.join) {
/*  180 */       createSql(false);
/*      */     }
/*  182 */     return new SelectWhere(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SelectWhere whereIf(boolean bool) {
/*  192 */     if (this.join) {
/*  193 */       createSql(false);
/*      */     }
/*  195 */     return new SelectWhere(this, !bool);
/*      */   }
/*      */   
/*      */   private Join joinIf(boolean bool, String type, LazySql<Sql> lazySql, String alias) {
/*  199 */     if (this.join) {
/*  200 */       createSql(false);
/*      */     }
/*  202 */     this.join = bool;
/*  203 */     if (!bool) {
/*  204 */       return this;
/*      */     }
/*  206 */     addJoinKey(type, lazySql.getSql(), alias);
/*  207 */     return this;
/*      */   }
/*      */   
/*      */   private Join joinIf(boolean bool, String type, Sql sql, String alias) {
/*  211 */     if (this.join) {
/*  212 */       createSql(false);
/*      */     }
/*  214 */     this.join = bool;
/*  215 */     if (!bool) {
/*  216 */       return this;
/*      */     }
/*  218 */     addJoinKey(type, sql, alias);
/*  219 */     return this;
/*      */   }
/*      */   
/*      */   private Join join(String type, Sql sql, String alias) {
/*  223 */     if (this.join) {
/*  224 */       createSql(false);
/*      */     }
/*  226 */     this.join = true;
/*  227 */     addJoinKey(type, sql, alias);
/*  228 */     return this;
/*      */   }
/*      */   
/*      */   private Join joinIf(boolean bool, String type, String table, String alias) {
/*  232 */     if (this.join) {
/*  233 */       createSql(false);
/*      */     }
/*  235 */     this.join = bool;
/*  236 */     return addJoinKey(type, table, alias);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Join throwRunExceptionWhenCriteriaCountLess(int count) {
/*  242 */     if (!this.join) {
/*  243 */       return this;
/*      */     }
/*  245 */     super.throwRunExceptionWhenCriteriaCountLess(count);
/*  246 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqs(String... fields) {
/*  251 */     if (!this.join) {
/*  252 */       return this;
/*      */     }
/*  254 */     super.andEqs(fields);
/*  255 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqs(String... fields) {
/*  260 */     if (!this.join) {
/*  261 */       return this;
/*      */     }
/*  263 */     super.andNotEqs(fields);
/*  264 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLts(String... fields) {
/*  269 */     if (!this.join) {
/*  270 */       return this;
/*      */     }
/*  272 */     super.andLts(fields);
/*  273 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGts(String... fields) {
/*  278 */     if (!this.join) {
/*  279 */       return this;
/*      */     }
/*  281 */     super.andGts(fields);
/*  282 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqs(String... fields) {
/*  287 */     if (!this.join) {
/*  288 */       return this;
/*      */     }
/*  290 */     super.andLtEqs(fields);
/*  291 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqs(String... fields) {
/*  296 */     if (!this.join) {
/*  297 */       return this;
/*      */     }
/*  299 */     super.andGtEqs(fields);
/*  300 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqField(String field1, String field2) {
/*  305 */     if (!this.join) {
/*  306 */       return this;
/*      */     }
/*  308 */     super.andEqField(field1, field2);
/*  309 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqFieldIf(boolean bool, String field1, String field2) {
/*  314 */     if (!this.join) {
/*  315 */       return this;
/*      */     }
/*  317 */     super.andEqFieldIf(bool, field1, field2);
/*  318 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEq(String field, Object params) {
/*  323 */     if (!this.join) {
/*  324 */       return this;
/*      */     }
/*  326 */     super.andEq(field, params);
/*  327 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEq(String field, Sql sql) {
/*  332 */     if (!this.join) {
/*  333 */       return this;
/*      */     }
/*  335 */     super.andEq(field, sql);
/*  336 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIf(boolean bool, String field, Object params) {
/*  341 */     if (!this.join) {
/*  342 */       return this;
/*      */     }
/*  344 */     super.andEqIf(bool, field, params);
/*  345 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  350 */     if (!this.join) {
/*  351 */       return this;
/*      */     }
/*  353 */     super.andEqIf(bool, field, lazyParam);
/*  354 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  359 */     if (!this.join) {
/*  360 */       return this;
/*      */     }
/*  362 */     super.andEqIf(bool, field, lazySql);
/*  363 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIfNotNull(String field, Object params) {
/*  368 */     if (!this.join) {
/*  369 */       return this;
/*      */     }
/*  371 */     super.andEqIfNotNull(field, params);
/*  372 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  377 */     if (!this.join) {
/*  378 */       return this;
/*      */     }
/*  380 */     super.andEqIfNotNull(field, params, lazyParam);
/*  381 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  386 */     if (!this.join) {
/*  387 */       return this;
/*      */     }
/*  389 */     super.andEqIfNotNull(field, params, lazySql);
/*  390 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIfNotBlank(String field, String params) {
/*  395 */     if (!this.join) {
/*  396 */       return this;
/*      */     }
/*  398 */     super.andEqIfNotBlank(field, params);
/*  399 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  404 */     if (!this.join) {
/*  405 */       return this;
/*      */     }
/*  407 */     super.andEqIfNotBlank(field, params, lazyParam);
/*  408 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  413 */     if (!this.join) {
/*  414 */       return this;
/*      */     }
/*  416 */     super.andEqIfNotBlank(field, params, lazySql);
/*  417 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEq(String field, Object params) {
/*  422 */     if (!this.join) {
/*  423 */       return this;
/*      */     }
/*  425 */     super.andNotEq(field, params);
/*  426 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEq(String field, Sql sql) {
/*  431 */     if (!this.join) {
/*  432 */       return this;
/*      */     }
/*  434 */     super.andNotEq(field, sql);
/*  435 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIf(boolean bool, String field, Object params) {
/*  440 */     if (!this.join) {
/*  441 */       return this;
/*      */     }
/*  443 */     super.andNotEqIf(bool, field, params);
/*  444 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  449 */     if (!this.join) {
/*  450 */       return this;
/*      */     }
/*  452 */     super.andNotEqIf(bool, field, lazyParam);
/*  453 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIf(boolean bool, String field, LazySql<Sql> sql) {
/*  458 */     if (!this.join) {
/*  459 */       return this;
/*      */     }
/*  461 */     super.andNotEqIf(bool, field, sql);
/*  462 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIfNotNull(String field, Object params) {
/*  467 */     if (!this.join) {
/*  468 */       return this;
/*      */     }
/*  470 */     super.andNotEqIfNotNull(field, params);
/*  471 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  476 */     if (!this.join) {
/*  477 */       return this;
/*      */     }
/*  479 */     super.andNotEqIfNotNull(field, params, lazyParam);
/*  480 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  485 */     if (!this.join) {
/*  486 */       return this;
/*      */     }
/*  488 */     super.andNotEqIfNotNull(field, params, lazySql);
/*  489 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIfNotBlank(String field, String params) {
/*  494 */     if (!this.join) {
/*  495 */       return this;
/*      */     }
/*  497 */     super.andNotEqIfNotBlank(field, params);
/*  498 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  503 */     if (!this.join) {
/*  504 */       return this;
/*      */     }
/*  506 */     super.andNotEqIfNotBlank(field, params, lazyParam);
/*  507 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  512 */     if (!this.join) {
/*  513 */       return this;
/*      */     }
/*  515 */     super.andNotEqIfNotBlank(field, params, lazySql);
/*  516 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLt(String field, Object params) {
/*  521 */     if (!this.join) {
/*  522 */       return this;
/*      */     }
/*  524 */     super.andLt(field, params);
/*  525 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLt(String field, Sql sql) {
/*  530 */     if (!this.join) {
/*  531 */       return this;
/*      */     }
/*  533 */     super.andLt(field, sql);
/*  534 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIf(boolean bool, String field, Object params) {
/*  539 */     if (!this.join) {
/*  540 */       return this;
/*      */     }
/*  542 */     super.andLtIf(bool, field, params);
/*  543 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  548 */     if (!this.join) {
/*  549 */       return this;
/*      */     }
/*  551 */     super.andLtIf(bool, field, lazyParam);
/*  552 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  557 */     if (!this.join) {
/*  558 */       return this;
/*      */     }
/*  560 */     super.andLtIf(bool, field, lazySql);
/*  561 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIfNotNull(String field, Object params) {
/*  566 */     if (!this.join) {
/*  567 */       return this;
/*      */     }
/*  569 */     super.andLtIfNotNull(field, params);
/*  570 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  575 */     if (!this.join) {
/*  576 */       return this;
/*      */     }
/*  578 */     super.andLtIfNotNull(field, params, lazyParam);
/*  579 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  584 */     if (!this.join) {
/*  585 */       return this;
/*      */     }
/*  587 */     super.andLtIfNotNull(field, params, lazySql);
/*  588 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIfNotBlank(String field, String params) {
/*  593 */     if (!this.join) {
/*  594 */       return this;
/*      */     }
/*  596 */     super.andLtIfNotBlank(field, params);
/*  597 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  602 */     if (!this.join) {
/*  603 */       return this;
/*      */     }
/*  605 */     super.andLtIfNotBlank(field, params, lazyParam);
/*  606 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  611 */     if (!this.join) {
/*  612 */       return this;
/*      */     }
/*  614 */     super.andLtIfNotBlank(field, params, lazySql);
/*  615 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEq(String field, Object params) {
/*  620 */     if (!this.join) {
/*  621 */       return this;
/*      */     }
/*  623 */     super.andLtEq(field, params);
/*  624 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEq(String field, Sql sql) {
/*  629 */     if (!this.join) {
/*  630 */       return this;
/*      */     }
/*  632 */     super.andLtEq(field, sql);
/*  633 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIf(boolean bool, String field, Object params) {
/*  638 */     if (!this.join) {
/*  639 */       return this;
/*      */     }
/*  641 */     super.andLtEqIf(bool, field, params);
/*  642 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  647 */     if (!this.join) {
/*  648 */       return this;
/*      */     }
/*  650 */     super.andLtEqIf(bool, field, lazyParam);
/*  651 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  656 */     if (!this.join) {
/*  657 */       return this;
/*      */     }
/*  659 */     super.andLtEqIf(bool, field, lazySql);
/*  660 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIfNotNull(String field, Object params) {
/*  665 */     if (!this.join) {
/*  666 */       return this;
/*      */     }
/*  668 */     super.andLtEqIfNotNull(field, params);
/*  669 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  674 */     if (!this.join) {
/*  675 */       return this;
/*      */     }
/*  677 */     super.andLtEqIfNotNull(field, params, lazyParam);
/*  678 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  683 */     if (!this.join) {
/*  684 */       return this;
/*      */     }
/*  686 */     super.andLtEqIfNotNull(field, params, lazySql);
/*  687 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIfNotBlank(String field, String params) {
/*  692 */     if (!this.join) {
/*  693 */       return this;
/*      */     }
/*  695 */     super.andLtEqIfNotBlank(field, params);
/*  696 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  701 */     if (!this.join) {
/*  702 */       return this;
/*      */     }
/*  704 */     super.andLtEqIfNotBlank(field, params, lazyParam);
/*  705 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLtEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  710 */     if (!this.join) {
/*  711 */       return this;
/*      */     }
/*  713 */     super.andLtEqIfNotBlank(field, params, lazySql);
/*  714 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGt(String field, Object params) {
/*  719 */     if (!this.join) {
/*  720 */       return this;
/*      */     }
/*  722 */     super.andGt(field, params);
/*  723 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGt(String field, Sql sql) {
/*  728 */     if (!this.join) {
/*  729 */       return this;
/*      */     }
/*  731 */     super.andGt(field, sql);
/*  732 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIf(boolean bool, String field, Object params) {
/*  737 */     if (!this.join) {
/*  738 */       return this;
/*      */     }
/*  740 */     super.andGtIf(bool, field, params);
/*  741 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  746 */     if (!this.join) {
/*  747 */       return this;
/*      */     }
/*  749 */     super.andGtIf(bool, field, lazyParam);
/*  750 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  755 */     if (!this.join) {
/*  756 */       return this;
/*      */     }
/*  758 */     super.andGtIf(bool, field, lazySql);
/*  759 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIfNotNull(String field, Object params) {
/*  764 */     if (!this.join) {
/*  765 */       return this;
/*      */     }
/*  767 */     super.andGtIfNotNull(field, params);
/*  768 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  773 */     if (!this.join) {
/*  774 */       return this;
/*      */     }
/*  776 */     super.andGtIfNotNull(field, params, lazyParam);
/*  777 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  782 */     if (!this.join) {
/*  783 */       return this;
/*      */     }
/*  785 */     super.andGtIfNotNull(field, params, lazySql);
/*  786 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIfNotBlank(String field, String params) {
/*  791 */     if (!this.join) {
/*  792 */       return this;
/*      */     }
/*  794 */     super.andGtIfNotBlank(field, params);
/*  795 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  800 */     if (!this.join) {
/*  801 */       return this;
/*      */     }
/*  803 */     super.andGtIfNotBlank(field, params, lazyParam);
/*  804 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  809 */     if (!this.join) {
/*  810 */       return this;
/*      */     }
/*  812 */     super.andGtIfNotBlank(field, params, lazySql);
/*  813 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEq(String field, Object params) {
/*  818 */     if (!this.join) {
/*  819 */       return this;
/*      */     }
/*  821 */     super.andGtEq(field, params);
/*  822 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEq(String field, Sql sql) {
/*  827 */     if (!this.join) {
/*  828 */       return this;
/*      */     }
/*  830 */     super.andGtEq(field, sql);
/*  831 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIf(boolean bool, String field, Object params) {
/*  836 */     if (!this.join) {
/*  837 */       return this;
/*      */     }
/*  839 */     super.andGtEqIf(bool, field, params);
/*  840 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIf(boolean bool, String field, LazyParam<Object> lazyParam) {
/*  845 */     if (!this.join) {
/*  846 */       return this;
/*      */     }
/*  848 */     super.andGtEqIf(bool, field, lazyParam);
/*  849 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIf(boolean bool, String field, LazySql<Sql> lazySql) {
/*  854 */     if (!this.join) {
/*  855 */       return this;
/*      */     }
/*  857 */     super.andGtEqIf(bool, field, lazySql);
/*  858 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIfNotNull(String field, Object params) {
/*  863 */     if (!this.join) {
/*  864 */       return this;
/*      */     }
/*  866 */     super.andGtEqIfNotNull(field, params);
/*  867 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIfNotNull(String field, Object params, LazyParam<Object> lazyParam) {
/*  872 */     if (!this.join) {
/*  873 */       return this;
/*      */     }
/*  875 */     super.andGtEqIfNotNull(field, params, lazyParam);
/*  876 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIfNotNull(String field, Object params, LazySql<Sql> lazySql) {
/*  881 */     if (!this.join) {
/*  882 */       return this;
/*      */     }
/*  884 */     super.andGtEqIfNotNull(field, params, lazySql);
/*  885 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIfNotBlank(String field, String params) {
/*  890 */     if (!this.join) {
/*  891 */       return this;
/*      */     }
/*  893 */     super.andGtEqIfNotBlank(field, params);
/*  894 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIfNotBlank(String field, String params, LazyParam<Object> lazyParam) {
/*  899 */     if (!this.join) {
/*  900 */       return this;
/*      */     }
/*  902 */     super.andGtEqIfNotBlank(field, params, lazyParam);
/*  903 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andGtEqIfNotBlank(String field, String params, LazySql<Sql> lazySql) {
/*  908 */     if (!this.join) {
/*  909 */       return this;
/*      */     }
/*  911 */     super.andGtEqIfNotBlank(field, params, lazySql);
/*  912 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetween(String field, Object param1, Object param2) {
/*  917 */     if (!this.join) {
/*  918 */       return this;
/*      */     }
/*  920 */     super.andBetween(field, param1, param2);
/*  921 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenIf(boolean bool, String field, Object param1, Object param2) {
/*  926 */     if (!this.join) {
/*  927 */       return this;
/*      */     }
/*  929 */     super.andBetweenIf(bool, field, param1, param2);
/*  930 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenOption(String field, Object param1, Object param2) {
/*  935 */     if (!this.join) {
/*  936 */       return this;
/*      */     }
/*  938 */     super.andBetweenOption(field, param1, param2);
/*  939 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenOption(String field, String param1, String param2) {
/*  944 */     if (!this.join) {
/*  945 */       return this;
/*      */     }
/*  947 */     super.andBetweenOption(field, param1, param2);
/*  948 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenOptionIf(boolean bool, String field, Object param1, Object param2) {
/*  953 */     if (!this.join) {
/*  954 */       return this;
/*      */     }
/*  956 */     super.andBetweenOptionIf(bool, field, param1, param2);
/*  957 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenOptionIf(boolean bool, String field, String param1, String param2) {
/*  962 */     if (!this.join) {
/*  963 */       return this;
/*      */     }
/*  965 */     super.andBetweenOptionIf(bool, field, param1, param2);
/*  966 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenOption(String field1, String field2, Object param1, Object param2) {
/*  971 */     if (!this.join) {
/*  972 */       return this;
/*      */     }
/*  974 */     super.andBetweenOption(field1, field2, param1, param2);
/*  975 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenOption(String field1, String field2, String param1, String param2) {
/*  980 */     if (!this.join) {
/*  981 */       return this;
/*      */     }
/*  983 */     super.andBetweenOption(field1, field2, param1, param2);
/*  984 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenOptionIf(boolean bool, String field1, String field2, Object param1, Object param2) {
/*  989 */     if (!this.join) {
/*  990 */       return this;
/*      */     }
/*  992 */     super.andBetweenOptionIf(bool, field1, field2, param1, param2);
/*  993 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBetweenOptionIf(boolean bool, String field1, String field2, String param1, String param2) {
/*  998 */     if (!this.join) {
/*  999 */       return this;
/*      */     }
/* 1001 */     super.andBetweenOptionIf(bool, field1, field2, param1, param2);
/* 1002 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIn(String field, List<?> params) {
/* 1007 */     if (!this.join) {
/* 1008 */       return this;
/*      */     }
/* 1010 */     super.andIn(field, params);
/* 1011 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIn(String field, Sql sql) {
/* 1016 */     if (!this.join) {
/* 1017 */       return this;
/*      */     }
/* 1019 */     super.andIn(field, sql);
/* 1020 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andInIf(boolean bool, String field, List<?> params) {
/* 1025 */     if (!this.join) {
/* 1026 */       return this;
/*      */     }
/* 1028 */     super.andInIf(bool, field, params);
/* 1029 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andInIf(boolean bool, String field, LazyParam<List<?>> params) {
/* 1034 */     if (!this.join) {
/* 1035 */       return this;
/*      */     }
/* 1037 */     super.andInIf(bool, field, params);
/* 1038 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andInIf(boolean bool, String field, LazySql<Sql> sql) {
/* 1043 */     if (!this.join) {
/* 1044 */       return this;
/*      */     }
/* 1046 */     super.andInIf(bool, field, sql);
/* 1047 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andInIfNotEmpty(String field, List<?> params) {
/* 1052 */     if (!this.join) {
/* 1053 */       return this;
/*      */     }
/* 1055 */     super.andInIfNotEmpty(field, params);
/* 1056 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andInIfNotEmpty(String field, List<?> params, LazyParam<List<?>> lazyParam) {
/* 1061 */     if (!this.join) {
/* 1062 */       return this;
/*      */     }
/* 1064 */     super.andInIfNotEmpty(field, params, lazyParam);
/* 1065 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andInIfNotEmpty(String field, List<?> params, LazySql<Sql> lazySql) {
/* 1070 */     if (!this.join) {
/* 1071 */       return this;
/*      */     }
/* 1073 */     super.andInIfNotEmpty(field, params, lazySql);
/* 1074 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotIn(String field, List<?> params) {
/* 1079 */     if (!this.join) {
/* 1080 */       return this;
/*      */     }
/* 1082 */     super.andNotIn(field, params);
/* 1083 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotIn(String field, Sql sql) {
/* 1088 */     if (!this.join) {
/* 1089 */       return this;
/*      */     }
/* 1091 */     super.andNotIn(field, sql);
/* 1092 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotInIf(boolean bool, String field, List<?> params) {
/* 1097 */     if (!this.join) {
/* 1098 */       return this;
/*      */     }
/* 1100 */     super.andNotInIf(bool, field, params);
/* 1101 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotInIf(boolean bool, String field, LazyParam<List<?>> params) {
/* 1106 */     if (!this.join) {
/* 1107 */       return this;
/*      */     }
/* 1109 */     super.andNotInIf(bool, field, params);
/* 1110 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotInIf(boolean bool, String field, LazySql<Sql> sql) {
/* 1115 */     if (!this.join) {
/* 1116 */       return this;
/*      */     }
/* 1118 */     super.andNotInIf(bool, field, sql);
/* 1119 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotInIfNotEmpty(String field, List<?> params) {
/* 1124 */     if (!this.join) {
/* 1125 */       return this;
/*      */     }
/* 1127 */     super.andNotInIfNotEmpty(field, params);
/* 1128 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotInIfNotEmpty(String field, List<?> params, LazyParam<List<?>> lazyParam) {
/* 1133 */     if (!this.join) {
/* 1134 */       return this;
/*      */     }
/* 1136 */     super.andNotInIfNotEmpty(field, params, lazyParam);
/* 1137 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotInIfNotEmpty(String field, List<?> params, LazySql<Sql> lazySql) {
/* 1142 */     if (!this.join) {
/* 1143 */       return this;
/*      */     }
/* 1145 */     super.andNotInIfNotEmpty(field, params, lazySql);
/* 1146 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLike(String field, String params) {
/* 1151 */     if (!this.join) {
/* 1152 */       return this;
/*      */     }
/* 1154 */     super.andBLike(field, params);
/* 1155 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeIf(boolean bool, String field, String params) {
/* 1160 */     if (!this.join) {
/* 1161 */       return this;
/*      */     }
/* 1163 */     super.andBLikeIf(bool, field, params);
/* 1164 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeIfNotBlank(String field, String params) {
/* 1169 */     if (!this.join) {
/* 1170 */       return this;
/*      */     }
/* 1172 */     super.andBLikeIfNotBlank(field, params);
/* 1173 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1178 */     if (!this.join) {
/* 1179 */       return this;
/*      */     }
/* 1181 */     super.andBLikeIfNotBlank(field, params, lazyParam);
/* 1182 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1187 */     if (!this.join) {
/* 1188 */       return this;
/*      */     }
/* 1190 */     super.andBLikeIfNotNull(field, params, lazyParam);
/* 1191 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByAnd(String field, List<String> params) {
/* 1196 */     if (!this.join) {
/* 1197 */       return this;
/*      */     }
/* 1199 */     super.andBLikeJoinByAnd(field, params);
/* 1200 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 1205 */     if (!this.join) {
/* 1206 */       return this;
/*      */     }
/* 1208 */     super.andBLikeJoinByAndIf(bool, field, params);
/* 1209 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 1214 */     if (!this.join) {
/* 1215 */       return this;
/*      */     }
/* 1217 */     super.andBLikeJoinByAndIfNotEmpty(field, params);
/* 1218 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1223 */     if (!this.join) {
/* 1224 */       return this;
/*      */     }
/* 1226 */     super.andBLikeJoinByAndIfNotEmpty(field, params, lazyParam);
/* 1227 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1232 */     if (!this.join) {
/* 1233 */       return this;
/*      */     }
/* 1235 */     super.andBLikeJoinByAndIfNotBlank(field, params, lazyParam);
/* 1236 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1241 */     if (!this.join) {
/* 1242 */       return this;
/*      */     }
/* 1244 */     super.andBLikeJoinByAndIfNotNull(field, params, lazyParam);
/* 1245 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByOr(String field, List<String> params) {
/* 1250 */     if (!this.join) {
/* 1251 */       return this;
/*      */     }
/* 1253 */     super.andBLikeJoinByOr(field, params);
/* 1254 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 1259 */     if (!this.join) {
/* 1260 */       return this;
/*      */     }
/* 1262 */     super.andBLikeJoinByOrIf(bool, field, params);
/* 1263 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 1268 */     if (!this.join) {
/* 1269 */       return this;
/*      */     }
/* 1271 */     super.andBLikeJoinByOrIfNotEmpty(field, params);
/* 1272 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1277 */     if (!this.join) {
/* 1278 */       return this;
/*      */     }
/* 1280 */     super.andBLikeJoinByOrIfNotEmpty(field, params, lazyParam);
/* 1281 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1286 */     if (!this.join) {
/* 1287 */       return this;
/*      */     }
/* 1289 */     super.andBLikeJoinByOrIfNotBlank(field, params, lazyParam);
/* 1290 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1295 */     if (!this.join) {
/* 1296 */       return this;
/*      */     }
/* 1298 */     super.andBLikeJoinByOrIfNotNull(field, params, lazyParam);
/* 1299 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeFieldsJoinByOr(String params, String... fields) {
/* 1304 */     if (!this.join) {
/* 1305 */       return this;
/*      */     }
/* 1307 */     super.andBLikeFieldsJoinByOr(params, fields);
/* 1308 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeFieldsJoinByOr(String params, List<String> fields) {
/* 1313 */     if (!this.join) {
/* 1314 */       return this;
/*      */     }
/* 1316 */     super.andBLikeFieldsJoinByOr(params, fields);
/* 1317 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 1322 */     if (!this.join) {
/* 1323 */       return this;
/*      */     }
/* 1325 */     super.andBLikeFieldsJoinByOrIf(bool, params, fields);
/* 1326 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 1331 */     if (!this.join) {
/* 1332 */       return this;
/*      */     }
/* 1334 */     super.andBLikeFieldsJoinByOrIf(bool, params, fields);
/* 1335 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 1340 */     if (!this.join) {
/* 1341 */       return this;
/*      */     }
/* 1343 */     super.andBLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1344 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andBLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 1349 */     if (!this.join) {
/* 1350 */       return this;
/*      */     }
/* 1352 */     super.andBLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1353 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotBLike(String field, String params) {
/* 1358 */     if (!this.join) {
/* 1359 */       return this;
/*      */     }
/* 1361 */     super.andNotBLike(field, params);
/* 1362 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotBLikeIf(boolean bool, String field, String params) {
/* 1367 */     if (!this.join) {
/* 1368 */       return this;
/*      */     }
/* 1370 */     super.andNotBLikeIf(bool, field, params);
/* 1371 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotBLikeIfNotBlank(String field, String params) {
/* 1376 */     if (!this.join) {
/* 1377 */       return this;
/*      */     }
/* 1379 */     super.andNotBLikeIfNotBlank(field, params);
/* 1380 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotBLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1385 */     if (!this.join) {
/* 1386 */       return this;
/*      */     }
/* 1388 */     super.andNotBLikeIfNotBlank(field, params, lazyParam);
/* 1389 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotBLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1394 */     if (!this.join) {
/* 1395 */       return this;
/*      */     }
/* 1397 */     super.andNotBLikeIfNotNull(field, params, lazyParam);
/* 1398 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLike(String field, String params) {
/* 1403 */     if (!this.join) {
/* 1404 */       return this;
/*      */     }
/* 1406 */     super.andLLike(field, params);
/* 1407 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeIf(boolean bool, String field, String params) {
/* 1412 */     if (!this.join) {
/* 1413 */       return this;
/*      */     }
/* 1415 */     super.andLLikeIf(bool, field, params);
/* 1416 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeIfNotBlank(String field, String params) {
/* 1421 */     if (!this.join) {
/* 1422 */       return this;
/*      */     }
/* 1424 */     super.andLLikeIfNotBlank(field, params);
/* 1425 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1430 */     if (!this.join) {
/* 1431 */       return this;
/*      */     }
/* 1433 */     super.andLLikeIfNotBlank(field, params, lazyParam);
/* 1434 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1439 */     if (!this.join) {
/* 1440 */       return this;
/*      */     }
/* 1442 */     super.andLLikeIfNotNull(field, params, lazyParam);
/* 1443 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByAnd(String field, List<String> params) {
/* 1448 */     if (!this.join) {
/* 1449 */       return this;
/*      */     }
/* 1451 */     super.andLLikeJoinByAnd(field, params);
/* 1452 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 1457 */     if (!this.join) {
/* 1458 */       return this;
/*      */     }
/* 1460 */     super.andLLikeJoinByAndIf(bool, field, params);
/* 1461 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 1466 */     if (!this.join) {
/* 1467 */       return this;
/*      */     }
/* 1469 */     super.andLLikeJoinByAndIfNotEmpty(field, params);
/* 1470 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1475 */     if (!this.join) {
/* 1476 */       return this;
/*      */     }
/* 1478 */     super.andLLikeJoinByAndIfNotEmpty(field, params, lazyParam);
/* 1479 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1484 */     if (!this.join) {
/* 1485 */       return this;
/*      */     }
/* 1487 */     super.andLLikeJoinByAndIfNotBlank(field, params, lazyParam);
/* 1488 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1493 */     if (!this.join) {
/* 1494 */       return this;
/*      */     }
/* 1496 */     super.andLLikeJoinByAndIfNotNull(field, params, lazyParam);
/* 1497 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByOr(String field, List<String> params) {
/* 1502 */     if (!this.join) {
/* 1503 */       return this;
/*      */     }
/* 1505 */     super.andLLikeJoinByOr(field, params);
/* 1506 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 1511 */     if (!this.join) {
/* 1512 */       return this;
/*      */     }
/* 1514 */     super.andLLikeJoinByOrIf(bool, field, params);
/* 1515 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 1520 */     if (!this.join) {
/* 1521 */       return this;
/*      */     }
/* 1523 */     super.andLLikeJoinByOrIfNotEmpty(field, params);
/* 1524 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1529 */     if (!this.join) {
/* 1530 */       return this;
/*      */     }
/* 1532 */     super.andLLikeJoinByOrIfNotEmpty(field, params, lazyParam);
/* 1533 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1538 */     if (!this.join) {
/* 1539 */       return this;
/*      */     }
/* 1541 */     super.andLLikeJoinByOrIfNotBlank(field, params, lazyParam);
/* 1542 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1547 */     if (!this.join) {
/* 1548 */       return this;
/*      */     }
/* 1550 */     super.andLLikeJoinByOrIfNotNull(field, params, lazyParam);
/* 1551 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeFieldsJoinByOr(String params, String... fields) {
/* 1556 */     if (!this.join) {
/* 1557 */       return this;
/*      */     }
/* 1559 */     super.andLLikeFieldsJoinByOr(params, fields);
/* 1560 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeFieldsJoinByOr(String params, List<String> fields) {
/* 1565 */     if (!this.join) {
/* 1566 */       return this;
/*      */     }
/* 1568 */     super.andLLikeFieldsJoinByOr(params, fields);
/* 1569 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 1574 */     if (!this.join) {
/* 1575 */       return this;
/*      */     }
/* 1577 */     super.andLLikeFieldsJoinByOrIf(bool, params, fields);
/* 1578 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 1583 */     if (!this.join) {
/* 1584 */       return this;
/*      */     }
/* 1586 */     super.andLLikeFieldsJoinByOrIf(bool, params, fields);
/* 1587 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 1592 */     if (!this.join) {
/* 1593 */       return this;
/*      */     }
/* 1595 */     super.andLLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1596 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 1601 */     if (!this.join) {
/* 1602 */       return this;
/*      */     }
/* 1604 */     super.andLLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1605 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLLike(String field, String params) {
/* 1610 */     if (!this.join) {
/* 1611 */       return this;
/*      */     }
/* 1613 */     super.andNotLLike(field, params);
/* 1614 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLLikeIf(boolean bool, String field, String params) {
/* 1619 */     if (!this.join) {
/* 1620 */       return this;
/*      */     }
/* 1622 */     super.andNotLLikeIf(bool, field, params);
/* 1623 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLLikeIfNotBlank(String field, String params) {
/* 1628 */     if (!this.join) {
/* 1629 */       return this;
/*      */     }
/* 1631 */     super.andNotLLikeIfNotBlank(field, params);
/* 1632 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1637 */     if (!this.join) {
/* 1638 */       return this;
/*      */     }
/* 1640 */     super.andNotLLikeIfNotBlank(field, params, lazyParam);
/* 1641 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1646 */     if (!this.join) {
/* 1647 */       return this;
/*      */     }
/* 1649 */     super.andNotLLikeIfNotNull(field, params, lazyParam);
/* 1650 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLike(String field, String params) {
/* 1655 */     if (!this.join) {
/* 1656 */       return this;
/*      */     }
/* 1658 */     super.andRLike(field, params);
/* 1659 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeIf(boolean bool, String field, String params) {
/* 1664 */     if (!this.join) {
/* 1665 */       return this;
/*      */     }
/* 1667 */     super.andRLikeIf(bool, field, params);
/* 1668 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeIfNotBlank(String field, String params) {
/* 1673 */     if (!this.join) {
/* 1674 */       return this;
/*      */     }
/* 1676 */     super.andRLikeIfNotBlank(field, params);
/* 1677 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1682 */     if (!this.join) {
/* 1683 */       return this;
/*      */     }
/* 1685 */     super.andRLikeIfNotBlank(field, params, lazyParam);
/* 1686 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1691 */     if (!this.join) {
/* 1692 */       return this;
/*      */     }
/* 1694 */     super.andRLikeIfNotNull(field, params, lazyParam);
/* 1695 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByAnd(String field, List<String> params) {
/* 1700 */     if (!this.join) {
/* 1701 */       return this;
/*      */     }
/* 1703 */     super.andRLikeJoinByAnd(field, params);
/* 1704 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 1709 */     if (!this.join) {
/* 1710 */       return this;
/*      */     }
/* 1712 */     super.andRLikeJoinByAndIf(bool, field, params);
/* 1713 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 1718 */     if (!this.join) {
/* 1719 */       return this;
/*      */     }
/* 1721 */     super.andRLikeJoinByAndIfNotEmpty(field, params);
/* 1722 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1727 */     if (!this.join) {
/* 1728 */       return this;
/*      */     }
/* 1730 */     super.andRLikeJoinByAndIfNotEmpty(field, params, lazyParam);
/* 1731 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1736 */     if (!this.join) {
/* 1737 */       return this;
/*      */     }
/* 1739 */     super.andRLikeJoinByAndIfNotBlank(field, params, lazyParam);
/* 1740 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1745 */     if (!this.join) {
/* 1746 */       return this;
/*      */     }
/* 1748 */     super.andRLikeJoinByAndIfNotNull(field, params, lazyParam);
/* 1749 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByOr(String field, List<String> params) {
/* 1754 */     if (!this.join) {
/* 1755 */       return this;
/*      */     }
/* 1757 */     super.andRLikeJoinByOr(field, params);
/* 1758 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 1763 */     if (!this.join) {
/* 1764 */       return this;
/*      */     }
/* 1766 */     super.andRLikeJoinByOrIf(bool, field, params);
/* 1767 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 1772 */     if (!this.join) {
/* 1773 */       return this;
/*      */     }
/* 1775 */     super.andRLikeJoinByOrIfNotEmpty(field, params);
/* 1776 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1781 */     if (!this.join) {
/* 1782 */       return this;
/*      */     }
/* 1784 */     super.andRLikeJoinByOrIfNotEmpty(field, params, lazyParam);
/* 1785 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1790 */     if (!this.join) {
/* 1791 */       return this;
/*      */     }
/* 1793 */     super.andRLikeJoinByOrIfNotBlank(field, params, lazyParam);
/* 1794 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1799 */     if (!this.join) {
/* 1800 */       return this;
/*      */     }
/* 1802 */     super.andRLikeJoinByOrIfNotNull(field, params, lazyParam);
/* 1803 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeFieldsJoinByOr(String params, String... fields) {
/* 1808 */     if (!this.join) {
/* 1809 */       return this;
/*      */     }
/* 1811 */     super.andRLikeFieldsJoinByOr(params, fields);
/* 1812 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeFieldsJoinByOr(String params, List<String> fields) {
/* 1817 */     if (!this.join) {
/* 1818 */       return this;
/*      */     }
/* 1820 */     super.andRLikeFieldsJoinByOr(params, fields);
/* 1821 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 1826 */     if (!this.join) {
/* 1827 */       return this;
/*      */     }
/* 1829 */     super.andRLikeFieldsJoinByOrIf(bool, params, fields);
/* 1830 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 1835 */     if (!this.join) {
/* 1836 */       return this;
/*      */     }
/* 1838 */     super.andRLikeFieldsJoinByOrIf(bool, params, fields);
/* 1839 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 1844 */     if (!this.join) {
/* 1845 */       return this;
/*      */     }
/* 1847 */     super.andRLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1848 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andRLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 1853 */     if (!this.join) {
/* 1854 */       return this;
/*      */     }
/* 1856 */     super.andRLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 1857 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotRLike(String field, String params) {
/* 1862 */     if (!this.join) {
/* 1863 */       return this;
/*      */     }
/* 1865 */     super.andNotRLike(field, params);
/* 1866 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotRLikeIf(boolean bool, String field, String params) {
/* 1871 */     if (!this.join) {
/* 1872 */       return this;
/*      */     }
/* 1874 */     super.andNotRLikeIf(bool, field, params);
/* 1875 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotRLikeIfNotBlank(String field, String params) {
/* 1880 */     if (!this.join) {
/* 1881 */       return this;
/*      */     }
/* 1883 */     super.andNotRLikeIfNotBlank(field, params);
/* 1884 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotRLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1889 */     if (!this.join) {
/* 1890 */       return this;
/*      */     }
/* 1892 */     super.andNotRLikeIfNotBlank(field, params, lazyParam);
/* 1893 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotRLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1898 */     if (!this.join) {
/* 1899 */       return this;
/*      */     }
/* 1901 */     super.andNotRLikeIfNotNull(field, params, lazyParam);
/* 1902 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLike(String field, String params) {
/* 1907 */     if (!this.join) {
/* 1908 */       return this;
/*      */     }
/* 1910 */     super.andLike(field, params);
/* 1911 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeIf(boolean bool, String field, String params) {
/* 1916 */     if (!this.join) {
/* 1917 */       return this;
/*      */     }
/* 1919 */     super.andLikeIf(bool, field, params);
/* 1920 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeIfNotBlank(String field, String params) {
/* 1925 */     if (!this.join) {
/* 1926 */       return this;
/*      */     }
/* 1928 */     super.andLikeIfNotBlank(field, params);
/* 1929 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 1934 */     if (!this.join) {
/* 1935 */       return this;
/*      */     }
/* 1937 */     super.andLikeIfNotBlank(field, params, lazyParam);
/* 1938 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 1943 */     if (!this.join) {
/* 1944 */       return this;
/*      */     }
/* 1946 */     super.andLikeIfNotNull(field, params, lazyParam);
/* 1947 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByAnd(String field, List<String> params) {
/* 1952 */     if (!this.join) {
/* 1953 */       return this;
/*      */     }
/* 1955 */     super.andLikeJoinByAnd(field, params);
/* 1956 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByAndIf(boolean bool, String field, List<String> params) {
/* 1961 */     if (!this.join) {
/* 1962 */       return this;
/*      */     }
/* 1964 */     super.andLikeJoinByAndIf(bool, field, params);
/* 1965 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByAndIfNotEmpty(String field, List<String> params) {
/* 1970 */     if (!this.join) {
/* 1971 */       return this;
/*      */     }
/* 1973 */     super.andLikeJoinByAndIfNotEmpty(field, params);
/* 1974 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByAndIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 1979 */     if (!this.join) {
/* 1980 */       return this;
/*      */     }
/* 1982 */     super.andLikeJoinByAndIfNotEmpty(field, params, lazyParam);
/* 1983 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByAndIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 1988 */     if (!this.join) {
/* 1989 */       return this;
/*      */     }
/* 1991 */     super.andLikeJoinByAndIfNotBlank(field, params, lazyParam);
/* 1992 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByAndIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 1997 */     if (!this.join) {
/* 1998 */       return this;
/*      */     }
/* 2000 */     super.andLikeJoinByAndIfNotNull(field, params, lazyParam);
/* 2001 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByOr(String field, List<String> params) {
/* 2006 */     if (!this.join) {
/* 2007 */       return this;
/*      */     }
/* 2009 */     super.andLikeJoinByOr(field, params);
/* 2010 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByOrIf(boolean bool, String field, List<String> params) {
/* 2015 */     if (!this.join) {
/* 2016 */       return this;
/*      */     }
/* 2018 */     super.andLikeJoinByOrIf(bool, field, params);
/* 2019 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByOrIfNotEmpty(String field, List<String> params) {
/* 2024 */     if (!this.join) {
/* 2025 */       return this;
/*      */     }
/* 2027 */     super.andLikeJoinByOrIfNotEmpty(field, params);
/* 2028 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByOrIfNotEmpty(String field, List<?> params, LazyParam<List<String>> lazyParam) {
/* 2033 */     if (!this.join) {
/* 2034 */       return this;
/*      */     }
/* 2036 */     super.andLikeJoinByOrIfNotEmpty(field, params, lazyParam);
/* 2037 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByOrIfNotBlank(String field, String params, LazyParam<List<String>> lazyParam) {
/* 2042 */     if (!this.join) {
/* 2043 */       return this;
/*      */     }
/* 2045 */     super.andLikeJoinByOrIfNotBlank(field, params, lazyParam);
/* 2046 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeJoinByOrIfNotNull(String field, Object params, LazyParam<List<String>> lazyParam) {
/* 2051 */     if (!this.join) {
/* 2052 */       return this;
/*      */     }
/* 2054 */     super.andLikeJoinByOrIfNotNull(field, params, lazyParam);
/* 2055 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeFieldsJoinByOr(String params, String... fields) {
/* 2060 */     if (!this.join) {
/* 2061 */       return this;
/*      */     }
/* 2063 */     super.andLikeFieldsJoinByOr(params, fields);
/* 2064 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeFieldsJoinByOr(String params, List<String> fields) {
/* 2069 */     if (!this.join) {
/* 2070 */       return this;
/*      */     }
/* 2072 */     super.andLikeFieldsJoinByOr(params, fields);
/* 2073 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeFieldsJoinByOrIf(boolean bool, String params, String... fields) {
/* 2078 */     if (!this.join) {
/* 2079 */       return this;
/*      */     }
/* 2081 */     super.andLikeFieldsJoinByOrIf(bool, params, fields);
/* 2082 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeFieldsJoinByOrIf(boolean bool, String params, List<String> fields) {
/* 2087 */     if (!this.join) {
/* 2088 */       return this;
/*      */     }
/* 2090 */     super.andLikeFieldsJoinByOrIf(bool, params, fields);
/* 2091 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeFieldsJoinByOrIfNotBlank(String params, String... fields) {
/* 2096 */     if (!this.join) {
/* 2097 */       return this;
/*      */     }
/* 2099 */     super.andLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 2100 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andLikeFieldsJoinByOrIfNotBlank(String params, List<String> fields) {
/* 2105 */     if (!this.join) {
/* 2106 */       return this;
/*      */     }
/* 2108 */     super.andLikeFieldsJoinByOrIfNotBlank(params, fields);
/* 2109 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLike(String field, String params) {
/* 2114 */     if (!this.join) {
/* 2115 */       return this;
/*      */     }
/* 2117 */     super.andNotLike(field, params);
/* 2118 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLikeIf(boolean bool, String field, String params) {
/* 2123 */     if (!this.join) {
/* 2124 */       return this;
/*      */     }
/* 2126 */     super.andNotLikeIf(bool, field, params);
/* 2127 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLikeIfNotBlank(String field, String params) {
/* 2132 */     if (!this.join) {
/* 2133 */       return this;
/*      */     }
/* 2135 */     super.andNotLikeIfNotBlank(field, params);
/* 2136 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLikeIfNotBlank(String field, String params, LazyParam<String> lazyParam) {
/* 2141 */     if (!this.join) {
/* 2142 */       return this;
/*      */     }
/* 2144 */     super.andNotLikeIfNotBlank(field, params, lazyParam);
/* 2145 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andNotLikeIfNotNull(String field, Object params, LazyParam<String> lazyParam) {
/* 2150 */     if (!this.join) {
/* 2151 */       return this;
/*      */     }
/* 2153 */     super.andNotLikeIfNotNull(field, params, lazyParam);
/* 2154 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsNull(String field) {
/* 2159 */     if (!this.join) {
/* 2160 */       return this;
/*      */     }
/* 2162 */     super.andIsNull(field);
/* 2163 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsNullIf(boolean bool, String field) {
/* 2168 */     if (!this.join) {
/* 2169 */       return this;
/*      */     }
/* 2171 */     super.andIsNullIf(bool, field);
/* 2172 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsNotNull(String field) {
/* 2177 */     if (!this.join) {
/* 2178 */       return this;
/*      */     }
/* 2180 */     super.andIsNotNull(field);
/* 2181 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsNotNullIf(boolean bool, String field) {
/* 2186 */     if (!this.join) {
/* 2187 */       return this;
/*      */     }
/* 2189 */     super.andIsNotNullIf(bool, field);
/* 2190 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsEmpty(String field) {
/* 2195 */     if (!this.join) {
/* 2196 */       return this;
/*      */     }
/* 2198 */     super.andIsEmpty(field);
/* 2199 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsEmptyIf(boolean bool, String field) {
/* 2204 */     if (!this.join) {
/* 2205 */       return this;
/*      */     }
/* 2207 */     super.andIsEmptyIf(bool, field);
/* 2208 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsNotEmpty(String field) {
/* 2213 */     if (!this.join) {
/* 2214 */       return this;
/*      */     }
/* 2216 */     super.andIsNotEmpty(field);
/* 2217 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsNotEmptyIf(boolean bool, String field) {
/* 2222 */     if (!this.join) {
/* 2223 */       return this;
/*      */     }
/* 2225 */     super.andIsNotEmptyIf(bool, field);
/* 2226 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsBlank(String field) {
/* 2231 */     if (!this.join) {
/* 2232 */       return this;
/*      */     }
/* 2234 */     super.andIsBlank(field);
/* 2235 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsBlankIf(boolean bool, String field) {
/* 2240 */     if (!this.join) {
/* 2241 */       return this;
/*      */     }
/* 2243 */     super.andIsBlankIf(bool, field);
/* 2244 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsNotBlank(String field) {
/* 2249 */     if (!this.join) {
/* 2250 */       return this;
/*      */     }
/* 2252 */     super.andIsNotBlank(field);
/* 2253 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIsNotBlankIf(boolean bool, String field) {
/* 2258 */     if (!this.join) {
/* 2259 */       return this;
/*      */     }
/* 2261 */     super.andIsNotBlankIf(bool, field);
/* 2262 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join and(Sql sql) {
/* 2267 */     if (!this.join) {
/* 2268 */       return this;
/*      */     }
/* 2270 */     super.and(sql);
/* 2271 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join and(String sql) {
/* 2276 */     if (!this.join) {
/* 2277 */       return this;
/*      */     }
/* 2279 */     super.and(sql);
/* 2280 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIf(boolean bool, LazySql<Sql> lazySql) {
/* 2285 */     if (!this.join) {
/* 2286 */       return this;
/*      */     }
/* 2288 */     super.andIf(bool, lazySql);
/* 2289 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIf(boolean bool, String sql) {
/* 2294 */     if (!this.join) {
/* 2295 */       return this;
/*      */     }
/* 2297 */     super.andIf(bool, sql);
/* 2298 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIf(boolean bool, LazySql<Sql> trueLazySql, LazySql<Sql> falseLazySql) {
/* 2303 */     if (!this.join) {
/* 2304 */       return this;
/*      */     }
/* 2306 */     super.andIf(bool, trueLazySql, falseLazySql);
/* 2307 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIf(boolean bool, String trueSql, String falseSql) {
/* 2312 */     if (!this.join) {
/* 2313 */       return this;
/*      */     }
/* 2315 */     super.andIf(bool, trueSql, falseSql);
/* 2316 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIfNotNull(Object params, LazySql<Sql> lazySql) {
/* 2321 */     if (!this.join) {
/* 2322 */       return this;
/*      */     }
/* 2324 */     super.andIfNotNull(params, lazySql);
/* 2325 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIfNotNull(Object params, String sql) {
/* 2330 */     if (!this.join) {
/* 2331 */       return this;
/*      */     }
/* 2333 */     super.andIfNotNull(params, sql);
/* 2334 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIfNotBlank(String params, LazySql<Sql> lazySql) {
/* 2339 */     if (!this.join) {
/* 2340 */       return this;
/*      */     }
/* 2342 */     super.andIfNotBlank(params, lazySql);
/* 2343 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIfNotBlank(String params, String sql) {
/* 2348 */     if (!this.join) {
/* 2349 */       return this;
/*      */     }
/* 2351 */     super.andIfNotBlank(params, sql);
/* 2352 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIfNotEmpty(List<?> params, LazySql<Sql> lazySql) {
/* 2357 */     if (!this.join) {
/* 2358 */       return this;
/*      */     }
/* 2360 */     super.andIfNotEmpty(params, lazySql);
/* 2361 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andIfNotEmpty(List<?> params, String sql) {
/* 2366 */     if (!this.join) {
/* 2367 */       return this;
/*      */     }
/* 2369 */     super.andIfNotEmpty(params, sql);
/* 2370 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andJoinByOr(Sql... sqls) {
/* 2375 */     if (!this.join) {
/* 2376 */       return this;
/*      */     }
/* 2378 */     super.andJoinByOr(sqls);
/* 2379 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andJoinByOr(List<Sql> sqls) {
/* 2384 */     if (!this.join) {
/* 2385 */       return this;
/*      */     }
/* 2387 */     super.andJoinByOr(sqls);
/* 2388 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andJoinByOrIf(boolean bool, LazySqls<Sql> lazySqls) {
/* 2393 */     if (!this.join) {
/* 2394 */       return this;
/*      */     }
/* 2396 */     super.andJoinByOrIf(bool, lazySqls);
/* 2397 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join or(Sql sql) {
/* 2402 */     if (!this.join) {
/* 2403 */       return this;
/*      */     }
/* 2405 */     super.or(sql);
/* 2406 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join or(String sql) {
/* 2411 */     if (!this.join) {
/* 2412 */       return this;
/*      */     }
/* 2414 */     super.or(sql);
/* 2415 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join orIf(boolean bool, String sql) {
/* 2420 */     if (!this.join) {
/* 2421 */       return this;
/*      */     }
/* 2423 */     super.orIf(bool, sql);
/* 2424 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join orIf(boolean bool, LazySql<Sql> lazySql) {
/* 2429 */     if (!this.join) {
/* 2430 */       return this;
/*      */     }
/* 2432 */     super.orIf(bool, lazySql);
/* 2433 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join orJoinByAnd(Sql... sqls) {
/* 2438 */     if (!this.join) {
/* 2439 */       return this;
/*      */     }
/* 2441 */     super.orJoinByAnd(sqls);
/* 2442 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join orJoinByAnd(List<Sql> sqls) {
/* 2447 */     if (!this.join) {
/* 2448 */       return this;
/*      */     }
/* 2450 */     super.orJoinByAnd(sqls);
/* 2451 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join orJoinByAndIf(boolean bool, LazySqls<Sql> lazySqls) {
/* 2456 */     if (!this.join) {
/* 2457 */       return this;
/*      */     }
/* 2459 */     super.orJoinByAndIf(bool, lazySqls);
/* 2460 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andTreeFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelIdTagField, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 2465 */     if (!this.join) {
/* 2466 */       return this;
/*      */     }
/* 2468 */     super.andTreeFilter(form, table, levelsField, levelIdField, levelIdTagField, levelNumField, filterSql);
/* 2469 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andTreeFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelIdTagField, String levelNumField) {
/* 2474 */     if (!this.join) {
/* 2475 */       return this;
/*      */     }
/* 2477 */     super.andTreeFilter(form, table, levelsField, levelIdField, levelIdTagField, levelNumField);
/* 2478 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField) {
/* 2483 */     if (!this.join) {
/* 2484 */       return this;
/*      */     }
/* 2486 */     super.andTreeMysqlFilter(form, table, levelsField, levelIdField);
/* 2487 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, Function<SelectWhere, Sql> filterSql) {
/* 2492 */     if (!this.join) {
/* 2493 */       return this;
/*      */     }
/* 2495 */     super.andTreeMysqlFilter(form, table, levelsField, levelIdField, filterSql);
/* 2496 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelNumField) {
/* 2501 */     if (!this.join) {
/* 2502 */       return this;
/*      */     }
/* 2504 */     super.andTreeMysqlFilter(form, table, levelsField, levelIdField, levelNumField);
/* 2505 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Join andTreeMysqlFilter(LevelTreeQuery form, String table, String levelsField, String levelIdField, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 2510 */     if (!this.join) {
/* 2511 */       return this;
/*      */     }
/* 2513 */     super.andTreeMysqlFilter(form, table, levelsField, levelIdField, levelNumField, filterSql);
/* 2514 */     return this;
/*      */   }
/*      */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Join.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */