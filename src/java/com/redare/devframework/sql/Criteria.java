/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import com.redare.devframework.sql.lazy.LazyParam;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Criteria
/*     */   extends BaseSql
/*     */ {
/*     */   public static Criteria isNull(String field) {
/*  19 */     return new Criteria(field, "isNull");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria isNotNull(String field) {
/*  29 */     return new Criteria(field, "isNotNull");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria isEmpty(String field) {
/*  39 */     return new Criteria(field, "isEmpty");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria isNotEmpty(String field) {
/*  49 */     return new Criteria(field, "isNotEmpty");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria isBlank(String field) {
/*  59 */     return new Criteria(field, "isBlank");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria isNotBlank(String field) {
/*  69 */     return new Criteria(field, "isNotBlank");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria eq(String field, Object params) {
/*  80 */     return new Criteria(field, "eq", Arrays.asList(new Object[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria eq(String field, Sql sql) {
/*  91 */     return new Criteria(field, "eq", sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria eqField(String field1, String field2) {
/* 102 */     return new Criteria(field1, "eq", field2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria notEq(String field, Object params) {
/* 113 */     return new Criteria(field, "notEq", Arrays.asList(new Object[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria notEq(String field, Sql sql) {
/* 124 */     return new Criteria(field, "notEq", sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria notEqField(String field1, String field2) {
/* 135 */     return new Criteria(field1, "notEq", field2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria like(String field, String params) {
/* 146 */     return new Criteria(field, "like", Arrays.asList((Object[])new String[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria bLike(String field, String params) {
/* 157 */     return new Criteria(field, "bLike", Arrays.asList((Object[])new String[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria lLike(String field, String params) {
/* 168 */     return new Criteria(field, "lLike", Arrays.asList((Object[])new String[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria rLike(String field, String params) {
/* 179 */     return new Criteria(field, "rLike", Arrays.asList((Object[])new String[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria notLike(String field, String params) {
/* 190 */     return new Criteria(field, "notLike", Arrays.asList((Object[])new String[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria bNotLike(String field, String params) {
/* 201 */     return new Criteria(field, "bNotLike", Arrays.asList((Object[])new String[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria lNotLike(String field, String params) {
/* 212 */     return new Criteria(field, "lNotLike", Arrays.asList((Object[])new String[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria rNotLike(String field, String params) {
/* 223 */     return new Criteria(field, "rNotLike", Arrays.asList((Object[])new String[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria lt(String field, Object params) {
/* 234 */     return new Criteria(field, "lt", Arrays.asList(new Object[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria lt(String field, Sql sql) {
/* 245 */     return new Criteria(field, "lt", sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria ltField(String field1, String field2) {
/* 256 */     return new Criteria(field1, "lt", field2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria ltEq(String field, Object params) {
/* 267 */     return new Criteria(field, "ltEq", Arrays.asList(new Object[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria ltEq(String field, Sql sql) {
/* 278 */     return new Criteria(field, "ltEq", sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria ltEqField(String field1, String field2) {
/* 289 */     return new Criteria(field1, "ltEq", field2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria gt(String field, Object params) {
/* 300 */     return new Criteria(field, "gt", Arrays.asList(new Object[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria gt(String field, Sql sql) {
/* 311 */     return new Criteria(field, "gt", sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria gtField(String field1, String field2) {
/* 322 */     return new Criteria(field1, "gt", field2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria gtEq(String field, Object params) {
/* 333 */     return new Criteria(field, "gtEq", Arrays.asList(new Object[] { params }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria gtEq(String field, Sql sql) {
/* 344 */     return new Criteria(field, "gtEq", sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria gtEqField(String field1, String field2) {
/* 355 */     return new Criteria(field1, "gtEq", field2);
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
/*     */   public static Criteria between(String field, Object param1, Object param2) {
/* 367 */     return new Criteria(field, "between", Arrays.asList(new Object[] { param1, param2 }));
/*     */   }
/*     */   
/*     */   public static Criteria ifBetween(String field, Object param1, Object param2) {
/* 371 */     return new Criteria(field, "ifBetween", Arrays.asList(new Object[] { param1, param2 }));
/*     */   }
/*     */   
/*     */   public static Criteria ifBetween(String field1, String field2, Object param1, Object param2) {
/* 375 */     return new Criteria(field1, field2, "ifBetween2", Arrays.asList(new Object[] { param1, param2 }));
/*     */   }
/*     */   
/*     */   public static Criteria ifTimeStatus(Integer status, String timeField1, String timeField2) {
/* 379 */     return new Criteria(timeField1, timeField2, "ifTimeStatus", Arrays.asList((Object[])new Integer[] { status }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria in(String field, List<?> params) {
/* 390 */     return new Criteria(field, "in", params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria in(String field, Sql sql) {
/* 401 */     return new Criteria(field, "in", sql);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria notIn(String field, List<?> params) {
/* 412 */     return new Criteria(field, "notIn", params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Criteria notIn(String field, Sql sql) {
/* 423 */     return new Criteria(field, "notIn", sql);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static Criteria inSql(String field, Sql sql) {
/* 428 */     return new Criteria(field, "inSql", sql);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static Criteria notInSql(String field, Sql sql) {
/* 433 */     return new Criteria(field, "notInSql", sql);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isCreate = false;
/*     */   private final String op;
/*     */   private final String field1;
/*     */   private String field2;
/*     */   private List<?> params;
/*     */   private Sql sql;
/*     */   
/*     */   private Criteria(String field1, String op, String field2) {
/* 445 */     this.field1 = field1;
/* 446 */     this.field2 = field2;
/* 447 */     this.op = op;
/*     */   }
/*     */ 
/*     */   
/*     */   private Criteria(String field1, String op) {
/* 452 */     this.field1 = field1;
/* 453 */     this.op = op;
/*     */   }
/*     */ 
/*     */   
/*     */   private Criteria(String field1, String op, Sql sql) {
/* 458 */     this.field1 = field1;
/* 459 */     this.op = op;
/* 460 */     this.sql = sql;
/*     */   }
/*     */ 
/*     */   
/*     */   private Criteria(String field1, String op, List<?> params) {
/* 465 */     this.field1 = field1;
/* 466 */     this.op = op;
/* 467 */     this.params = params;
/*     */   }
/*     */ 
/*     */   
/*     */   private Criteria(String field1, String field2, String op, List<?> params) {
/* 472 */     this.field1 = field1;
/* 473 */     this.field2 = field2;
/* 474 */     this.op = op;
/* 475 */     this.params = params;
/*     */   }
/*     */   
/*     */   private Object convertParam(Object param) {
/* 479 */     if (param == null) {
/* 480 */       return null;
/*     */     }
/* 482 */     if (param instanceof LazyParam) {
/* 483 */       return ((LazyParam)param).getParam();
/*     */     }
/* 485 */     return param; } public StringBuilder getSql() { Object param1, param2;
/*     */     Integer status;
/*     */     Date now;
/*     */     String value;
/* 489 */     if (this.isCreate) {
/* 490 */       return super.getSql();
/*     */     }
/* 492 */     this.isCreate = true;
/* 493 */     String sqlOp = null;
/* 494 */     switch (this.op) {
/*     */       case "isNull":
/* 496 */         addSql(this.field1, new Object[0]).addSql("is null", new Object[0]);
/* 497 */         return super.getSql();
/*     */       case "isNotNull":
/* 499 */         addSql(this.field1, new Object[0]).addSql("is not null", new Object[0]);
/* 500 */         return super.getSql();
/*     */       case "isEmpty":
/* 502 */         addSql(this.field1, new Object[0]).addSql("= ''", new Object[0]);
/* 503 */         return super.getSql();
/*     */       case "isNotEmpty":
/* 505 */         addSql(this.field1, new Object[0]).addSql("<> ''", new Object[0]);
/* 506 */         return super.getSql();
/*     */       case "isBlank":
/* 508 */         addSql("(", new Object[0])
/* 509 */           .addSql(this.field1, new Object[0]).addSql("is null or", new Object[0])
/* 510 */           .addSql(this.field1, new Object[0]).addSql("= ''", new Object[0])
/* 511 */           .addSql(")", new Object[0]);
/* 512 */         return super.getSql();
/*     */       case "isNotBlank":
/* 514 */         addSql("(", new Object[0])
/* 515 */           .addSql(this.field1, new Object[0]).addSql("is not null and", new Object[0])
/* 516 */           .addSql(this.field1, new Object[0]).addSql("<> ''", new Object[0])
/* 517 */           .addSql(")", new Object[0]);
/* 518 */         return super.getSql();
/*     */       case "between":
/* 520 */         param1 = convertParam(this.params.get(0));
/* 521 */         param2 = convertParam(this.params.get(1));
/* 522 */         addSql(this.field1, new Object[0]).addSql("between ? and ?", new Object[0]);
/* 523 */         addParams(new Object[] { param1, param2 });
/* 524 */         return super.getSql();
/*     */       case "ifBetween":
/* 526 */         param1 = convertParam(this.params.get(0));
/* 527 */         param2 = convertParam(this.params.get(1));
/* 528 */         if (param1 != null && param2 != null) {
/* 529 */           addSql(this.field1, new Object[0]).addSql("between ? and ?", new Object[0]);
/* 530 */           addParams(new Object[] { param1, param2 });
/* 531 */           return super.getSql();
/* 532 */         }  if (param1 != null) {
/* 533 */           addSql(this.field1, new Object[0]).addSql(">= ?", new Object[0]);
/* 534 */           addParams(new Object[] { param1 });
/* 535 */           return super.getSql();
/* 536 */         }  if (param2 != null) {
/* 537 */           addSql(this.field1, new Object[0]).addSql("<= ?", new Object[0]);
/* 538 */           addParams(new Object[] { param2 });
/* 539 */           return super.getSql();
/*     */         } 
/* 541 */         return null;
/*     */       case "ifBetween2":
/* 543 */         param1 = convertParam(this.params.get(0));
/* 544 */         param2 = convertParam(this.params.get(1));
/* 545 */         if (param1 != null && param2 != null) {
/* 546 */           addSql("(", new Object[0])
/* 547 */             .addSql(this.field1, new Object[0]).addSql("<=? and", new Object[0])
/* 548 */             .addSql(this.field2, new Object[0]).addSql(">= ?", new Object[0])
/* 549 */             .addSql(")", new Object[0]);
/* 550 */           addParams(new Object[] { param2, param1 });
/* 551 */           return super.getSql();
/* 552 */         }  if (param1 != null) {
/* 553 */           addSql(this.field2, new Object[0]).addSql(">= ?", new Object[0]);
/* 554 */           addParams(new Object[] { param1 });
/* 555 */           return super.getSql();
/* 556 */         }  if (param2 != null) {
/* 557 */           addSql(this.field1, new Object[0]).addSql("<= ?", new Object[0]);
/* 558 */           addParams(new Object[] { param2 });
/* 559 */           return super.getSql();
/*     */         } 
/* 561 */         return null;
/*     */       case "ifTimeStatus":
/* 563 */         status = (Integer)this.params.get(0);
/* 564 */         if (status == null) {
/* 565 */           return null;
/*     */         }
/* 567 */         now = new Date();
/* 568 */         switch (status.intValue()) {
/*     */           case 0:
/* 570 */             addSql(this.field1, new Object[0]).addSql("> ?", new Object[0]);
/* 571 */             addParams(new Object[] { now });
/* 572 */             return super.getSql();
/*     */           case 1:
/* 574 */             addSql("(", new Object[0])
/* 575 */               .addSql(this.field1, new Object[0]).addSql("<= ? and", new Object[0])
/* 576 */               .addSql(this.field2, new Object[0]).addSql("> ?", new Object[0])
/* 577 */               .addSql(")", new Object[0]);
/* 578 */             addParams(new Object[] { now, now });
/* 579 */             return super.getSql();
/*     */           case 2:
/* 581 */             addSql(this.field2, new Object[0]).addSql("<= ?", new Object[0]);
/* 582 */             addParams(new Object[] { now });
/* 583 */             return super.getSql();
/*     */           case 3:
/* 585 */             addSql(this.field2, new Object[0]).addSql("> ?", new Object[0]);
/* 586 */             addParams(new Object[] { now });
/* 587 */             return super.getSql();
/*     */         } 
/* 589 */         return null;
/*     */       case "bLike":
/* 591 */         value = (String)convertParam(this.params.get(0));
/* 592 */         addSql(this.field1, new Object[0]).addSql("like ?", new Object[] { "%" + value + "%" });
/* 593 */         return super.getSql();
/*     */       case "rLike":
/* 595 */         value = (String)convertParam(this.params.get(0));
/* 596 */         addSql(this.field1, new Object[0]).addSql("like ?", new Object[] { value + "%" });
/* 597 */         return super.getSql();
/*     */       case "lLike":
/* 599 */         value = (String)convertParam(this.params.get(0));
/* 600 */         addSql(this.field1, new Object[0]).addSql("like ?", new Object[] { "%" + value });
/* 601 */         return super.getSql();
/*     */       case "bNotLike":
/* 603 */         value = (String)convertParam(this.params.get(0));
/* 604 */         addSql(this.field1, new Object[0]).addSql("not like ?", new Object[] { "%" + value + "%" });
/* 605 */         return super.getSql();
/*     */       case "rNotLike":
/* 607 */         value = (String)convertParam(this.params.get(0));
/* 608 */         addSql(this.field1, new Object[0]).addSql("not like ?", new Object[] { value + "%" });
/* 609 */         return super.getSql();
/*     */       case "lNotLike":
/* 611 */         value = (String)convertParam(this.params.get(0));
/* 612 */         addSql(this.field1, new Object[0]).addSql("not like ?", new Object[] { "%" + value });
/* 613 */         return super.getSql();
/*     */       case "inSql":
/* 615 */         addSql(this.field1, new Object[0]).addSql("in (", new Object[0]).addSql(this.sql.getSql().toString(), new Object[0]).addSql(")", new Object[0]);
/* 616 */         addParams(this.sql.getParams());
/* 617 */         return super.getSql();
/*     */       case "notInSql":
/* 619 */         addSql(this.field1, new Object[0]).addSql("not in (", new Object[0]).addSql(this.sql.getSql().toString(), new Object[0]).addSql(")", new Object[0]);
/* 620 */         addParams(this.sql.getParams());
/* 621 */         return super.getSql();
/*     */       case "like":
/* 623 */         sqlOp = "like";
/*     */         break;
/*     */       case "notLike":
/* 626 */         sqlOp = "not like";
/*     */         break;
/*     */       case "eq":
/* 629 */         sqlOp = "=";
/*     */         break;
/*     */       case "notEq":
/* 632 */         sqlOp = "<>";
/*     */         break;
/*     */       case "lt":
/* 635 */         sqlOp = "<";
/*     */         break;
/*     */       case "ltEq":
/* 638 */         sqlOp = "<=";
/*     */         break;
/*     */       case "gt":
/* 641 */         sqlOp = ">";
/*     */         break;
/*     */       case "gtEq":
/* 644 */         sqlOp = ">=";
/*     */         break;
/*     */       case "in":
/* 647 */         sqlOp = "in";
/*     */         break;
/*     */       case "notIn":
/* 650 */         sqlOp = "not in";
/*     */         break;
/*     */     } 
/*     */     
/* 654 */     if (this.sql != null) {
/* 655 */       addSql(this.field1, new Object[0]).addSql(sqlOp, new Object[0]).addSql("(", new Object[0]).addSql(this.sql.getSql().toString(), new Object[0]).addSql(")", new Object[0]);
/* 656 */       addParams(this.sql.getParams());
/* 657 */       return super.getSql();
/*     */     } 
/*     */     
/* 660 */     if (StringUtils.isNotBlank(this.field1) && StringUtils.isNotBlank(this.field2)) {
/* 661 */       addSql(this.field1, new Object[0]).addSql(sqlOp, new Object[0]).addSql(this.field2, new Object[0]);
/* 662 */       return super.getSql();
/*     */     } 
/*     */     
/* 665 */     if ("in".equals(this.op) || "notIn".equals(this.op)) {
/* 666 */       addSql(this.field1, new Object[0]).addSql(sqlOp, new Object[0]).addSql("(", new Object[0]);
/* 667 */       for (int i = 0; i < this.params.size(); i++) {
/* 668 */         if (i > 0) {
/* 669 */           addSql(",", new Object[0]);
/*     */         }
/* 671 */         addSql("?", new Object[0]);
/*     */       } 
/* 673 */       addSql(")", new Object[0]);
/* 674 */       addParams(this.params.toArray());
/* 675 */       return super.getSql();
/*     */     } 
/*     */     
/* 678 */     addSql(this.field1, new Object[0]).addSql(sqlOp, new Object[0]).addSql("?", new Object[] { convertParam(this.params.get(0)) });
/* 679 */     return super.getSql(); }
/*     */ 
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Criteria.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */