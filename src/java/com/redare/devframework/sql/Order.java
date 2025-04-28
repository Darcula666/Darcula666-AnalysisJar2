/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Order
/*     */   extends BaseSql
/*     */ {
/*     */   private final List<String> orders;
/*     */   private boolean hasCreate = false;
/*     */   private boolean addOrderBy = true;
/*     */   private String limit;
/*     */   
/*     */   public static Order by() {
/*  23 */     return new Order();
/*     */   }
/*     */   
/*     */   protected Order(BaseSql sql) {
/*  27 */     super(sql);
/*  28 */     this.addOrderBy = true;
/*  29 */     this.orders = new ArrayList<>();
/*     */   }
/*     */ 
/*     */   
/*     */   private Order() {
/*  34 */     this.addOrderBy = false;
/*  35 */     this.orders = new ArrayList<>();
/*     */   }
/*     */   
/*     */   private Order createSql() {
/*  39 */     if (this.hasCreate) {
/*  40 */       return this;
/*     */     }
/*  42 */     this.hasCreate = true;
/*  43 */     if (this.orders.isEmpty()) {
/*  44 */       if (StringUtils.isNotBlank(this.limit)) {
/*  45 */         addSql(this.limit, new Object[0]);
/*     */       }
/*  47 */       return this;
/*     */     } 
/*  49 */     if (this.addOrderBy) {
/*  50 */       addSql("order by", new Object[0]);
/*     */     }
/*  52 */     addSql(StringUtils.join(this.orders, ","), new Object[0]);
/*  53 */     if (StringUtils.isNotBlank(this.limit)) {
/*  54 */       addSql(this.limit, new Object[0]);
/*     */     }
/*  56 */     this.orders.clear();
/*  57 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public StringBuilder getSql() {
/*  62 */     createSql();
/*  63 */     return super.getSql();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order asc(String... fields) {
/*  73 */     if (ArrayUtils.isEmpty((Object[])fields)) {
/*  74 */       return this;
/*     */     }
/*  76 */     for (String field : fields) {
/*  77 */       this.orders.add(String.format("%s asc", new Object[] { field }));
/*     */     } 
/*  79 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order asc(List<String> fields) {
/*  89 */     if (CollectionUtils.isEmpty(fields)) {
/*  90 */       return this;
/*     */     }
/*  92 */     for (String field : fields) {
/*  93 */       this.orders.add(String.format("%s asc", new Object[] { field }));
/*     */     } 
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order ascIf(boolean bool, String... fields) {
/* 106 */     if (!bool) {
/* 107 */       return this;
/*     */     }
/* 109 */     return asc(fields);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order ascIf(boolean bool, List<String> fields) {
/* 120 */     if (!bool) {
/* 121 */       return this;
/*     */     }
/* 123 */     return asc(fields);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order desc(String... fields) {
/* 133 */     if (ArrayUtils.isEmpty((Object[])fields)) {
/* 134 */       return this;
/*     */     }
/* 136 */     for (String field : fields) {
/* 137 */       this.orders.add(String.format("%s desc", new Object[] { field }));
/*     */     } 
/* 139 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order desc(List<String> fields) {
/* 149 */     if (CollectionUtils.isEmpty(fields)) {
/* 150 */       return this;
/*     */     }
/* 152 */     for (String field : fields) {
/* 153 */       this.orders.add(String.format("%s desc", new Object[] { field }));
/*     */     } 
/* 155 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order descIf(boolean bool, String... fields) {
/* 166 */     if (!bool) {
/* 167 */       return this;
/*     */     }
/* 169 */     return desc(fields);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order descIf(boolean bool, List<String> fields) {
/* 180 */     if (!bool) {
/* 181 */       return this;
/*     */     }
/* 183 */     return desc(fields);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order order(Order order) {
/* 193 */     if (order == null) {
/* 194 */       return this;
/*     */     }
/* 196 */     this.orders.addAll(order.orders);
/* 197 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order orderIf(boolean bool, Order order) {
/* 208 */     if (!bool) {
/* 209 */       return this;
/*     */     }
/* 211 */     return order(order);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order sql(String sql) {
/* 221 */     if (StringUtils.isBlank(sql)) {
/* 222 */       return this;
/*     */     }
/* 224 */     this.orders.add(sql);
/* 225 */     return this;
/*     */   }
/*     */   
/*     */   public Order limit(int offset, int count) {
/* 229 */     this.limit = String.format("limit %s , %s", new Object[] { Integer.valueOf(offset), Integer.valueOf(count) });
/* 230 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Order sqlIf(boolean bool, String sql) {
/* 241 */     if (!bool) {
/* 242 */       return this;
/*     */     }
/* 244 */     return sql(sql);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Order ifAsc(boolean bool, String... fields) {
/* 250 */     if (!bool) {
/* 251 */       return this;
/*     */     }
/* 253 */     return asc(fields);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public Order ifDesc(boolean bool, String... fields) {
/* 258 */     if (!bool) {
/* 259 */       return this;
/*     */     }
/* 261 */     return desc(fields);
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Order.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */