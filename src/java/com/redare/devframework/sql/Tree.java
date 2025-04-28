/*     */ package com.redare.devframework.sql;
/*     */ 
/*     */ import java.util.function.Function;
/*     */ import org.apache.commons.lang.StringUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tree<T>
/*     */   extends BaseSql
/*     */ {
/*     */   public static Tree<?> up(Object id, String table, String levelsField, String levelIdField, String levelIdTagField) {
/*  39 */     return (new Tree())
/*  40 */       .setUp(true)
/*  41 */       .setLevelsField(levelsField)
/*  42 */       .setLevelNumField("")
/*  43 */       .setLevelIdTagField(levelIdTagField)
/*  44 */       .setLevelIdField(levelIdField)
/*  45 */       .setTable(table)
/*  46 */       .setId(id)
/*  47 */       .setLevelNum(0)
/*  48 */       .setLevelNumOnly(false)
/*  49 */       .setIncSelf(false)
/*  50 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static Tree<?> up(Object id, String table, String levelsField, String levelIdField, String levelIdTagField, Function<SelectWhere, Sql> filterSql) {
/*  54 */     return (new Tree())
/*  55 */       .setUp(true)
/*  56 */       .setLevelsField(levelsField)
/*  57 */       .setLevelNumField("")
/*  58 */       .setLevelIdTagField(levelIdTagField)
/*  59 */       .setLevelIdField(levelIdField)
/*  60 */       .setTable(table)
/*  61 */       .setId(id)
/*  62 */       .setLevelNum(0)
/*  63 */       .setLevelNumOnly(false)
/*  64 */       .setIncSelf(false)
/*  65 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> up(Object id, String table, String levelsField, String levelIdField, String levelIdTagField, Function<SelectWhere, Sql> filterSql, boolean incSelf) {
/*  69 */     return (new Tree())
/*  70 */       .setUp(true)
/*  71 */       .setLevelsField(levelsField)
/*  72 */       .setLevelNumField("")
/*  73 */       .setLevelIdTagField(levelIdTagField)
/*  74 */       .setLevelIdField(levelIdField)
/*  75 */       .setTable(table)
/*  76 */       .setId(id)
/*  77 */       .setLevelNum(0)
/*  78 */       .setLevelNumOnly(false)
/*  79 */       .setIncSelf(incSelf)
/*  80 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> up(Object id, String table, String levelsField, String levelIdField, String levelIdTagField, int levelNum, String levelNumField) {
/*  84 */     return (new Tree())
/*  85 */       .setUp(true)
/*  86 */       .setLevelsField(levelsField)
/*  87 */       .setLevelNumField(levelNumField)
/*  88 */       .setLevelIdTagField(levelIdTagField)
/*  89 */       .setLevelIdField(levelIdField)
/*  90 */       .setTable(table)
/*  91 */       .setId(id)
/*  92 */       .setLevelNum(levelNum)
/*  93 */       .setLevelNumOnly(false)
/*  94 */       .setIncSelf(false)
/*  95 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static Tree<?> up(Object id, String table, String levelsField, String levelIdField, String levelIdTagField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/*  99 */     return (new Tree())
/* 100 */       .setUp(true)
/* 101 */       .setLevelsField(levelsField)
/* 102 */       .setLevelNumField(levelNumField)
/* 103 */       .setLevelIdTagField(levelIdTagField)
/* 104 */       .setLevelIdField(levelIdField)
/* 105 */       .setTable(table)
/* 106 */       .setId(id)
/* 107 */       .setLevelNum(levelNum)
/* 108 */       .setLevelNumOnly(false)
/* 109 */       .setIncSelf(false)
/* 110 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> up(Object id, String table, String levelsField, String levelIdField, String levelIdTagField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly) {
/* 114 */     return (new Tree())
/* 115 */       .setUp(true)
/* 116 */       .setLevelsField(levelsField)
/* 117 */       .setLevelNumField(levelNumField)
/* 118 */       .setLevelIdTagField(levelIdTagField)
/* 119 */       .setLevelIdField(levelIdField)
/* 120 */       .setTable(table)
/* 121 */       .setId(id)
/* 122 */       .setLevelNum(levelNum)
/* 123 */       .setLevelNumOnly(levelNumOnly)
/* 124 */       .setIncSelf(false)
/* 125 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> up(Object id, String table, String levelsField, String levelIdField, String levelIdTagField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly, boolean incSelf) {
/* 129 */     return (new Tree())
/* 130 */       .setUp(true)
/* 131 */       .setLevelsField(levelsField)
/* 132 */       .setLevelNumField(levelNumField)
/* 133 */       .setLevelIdTagField(levelIdTagField)
/* 134 */       .setLevelIdField(levelIdField)
/* 135 */       .setTable(table)
/* 136 */       .setId(id)
/* 137 */       .setLevelNum(levelNum)
/* 138 */       .setLevelNumOnly(levelNumOnly)
/* 139 */       .setIncSelf(incSelf)
/* 140 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> down(Object id, String levelsField) {
/* 144 */     return (new Tree())
/* 145 */       .setUp(false)
/* 146 */       .setLevelsField(levelsField)
/* 147 */       .setLevelNumField("")
/* 148 */       .setLevelIdTagField("")
/* 149 */       .setLevelIdField("")
/* 150 */       .setTable("")
/* 151 */       .setId(id)
/* 152 */       .setLevelNum(0)
/* 153 */       .setLevelNumOnly(false)
/* 154 */       .setIncSelf(false)
/* 155 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static Tree<?> down(Object id, String levelsField, boolean incSelf, String levelIdField) {
/* 159 */     return (new Tree())
/* 160 */       .setUp(false)
/* 161 */       .setLevelsField(levelsField)
/* 162 */       .setLevelNumField("")
/* 163 */       .setLevelIdTagField("")
/* 164 */       .setLevelIdField(levelIdField)
/* 165 */       .setTable("")
/* 166 */       .setId(id)
/* 167 */       .setLevelNum(0)
/* 168 */       .setLevelNumOnly(false)
/* 169 */       .setIncSelf(incSelf)
/* 170 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static Tree<?> down(Object id, String levelsField, int levelNum, String table, String levelNumField, String levelIdField) {
/* 174 */     return (new Tree())
/* 175 */       .setUp(false)
/* 176 */       .setLevelsField(levelsField)
/* 177 */       .setLevelNumField(levelNumField)
/* 178 */       .setLevelIdTagField("")
/* 179 */       .setLevelIdField(levelIdField)
/* 180 */       .setTable(table)
/* 181 */       .setId(id)
/* 182 */       .setLevelNum(levelNum)
/* 183 */       .setLevelNumOnly(false)
/* 184 */       .setIncSelf(false)
/* 185 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static Tree<?> down(Object id, String levelsField, int levelNum, String table, String levelNumField, String levelIdField, Function<SelectWhere, Sql> filterSql) {
/* 189 */     return (new Tree())
/* 190 */       .setUp(false)
/* 191 */       .setLevelsField(levelsField)
/* 192 */       .setLevelNumField(levelNumField)
/* 193 */       .setLevelIdTagField("")
/* 194 */       .setLevelIdField(levelIdField)
/* 195 */       .setTable(table)
/* 196 */       .setId(id)
/* 197 */       .setLevelNum(levelNum)
/* 198 */       .setLevelNumOnly(false)
/* 199 */       .setIncSelf(false)
/* 200 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> down(Object id, String levelsField, int levelNum, String table, String levelNumField, String levelIdField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly) {
/* 204 */     return (new Tree())
/* 205 */       .setUp(false)
/* 206 */       .setLevelsField(levelsField)
/* 207 */       .setLevelNumField(levelNumField)
/* 208 */       .setLevelIdTagField("")
/* 209 */       .setLevelIdField(levelIdField)
/* 210 */       .setTable(table)
/* 211 */       .setId(id)
/* 212 */       .setLevelNum(levelNum)
/* 213 */       .setLevelNumOnly(levelNumOnly)
/* 214 */       .setIncSelf(false)
/* 215 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> down(Object id, String levelsField, int levelNum, String table, String levelNumField, String levelIdField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly, boolean incSelf) {
/* 219 */     return (new Tree())
/* 220 */       .setUp(false)
/* 221 */       .setLevelsField(levelsField)
/* 222 */       .setLevelNumField(levelNumField)
/* 223 */       .setLevelIdTagField("")
/* 224 */       .setLevelIdField(levelIdField)
/* 225 */       .setTable(table)
/* 226 */       .setId(id)
/* 227 */       .setLevelNum(levelNum)
/* 228 */       .setLevelNumOnly(levelNumOnly)
/* 229 */       .setIncSelf(incSelf)
/* 230 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, String levelIdTagField) {
/* 234 */     return (new Tree())
/* 235 */       .setUp(up)
/* 236 */       .setLevelsField(levelsField)
/* 237 */       .setLevelNumField("")
/* 238 */       .setLevelIdTagField(levelIdTagField)
/* 239 */       .setLevelIdField(levelIdField)
/* 240 */       .setTable(table)
/* 241 */       .setId(id)
/* 242 */       .setLevelNum(0)
/* 243 */       .setLevelNumOnly(false)
/* 244 */       .setIncSelf(false)
/* 245 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static Tree<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, String levelIdTagField, Function<SelectWhere, Sql> filterSql) {
/* 249 */     return (new Tree())
/* 250 */       .setUp(up)
/* 251 */       .setLevelsField(levelsField)
/* 252 */       .setLevelNumField("")
/* 253 */       .setLevelIdTagField(levelIdTagField)
/* 254 */       .setLevelIdField(levelIdField)
/* 255 */       .setTable(table)
/* 256 */       .setId(id)
/* 257 */       .setLevelNum(0)
/* 258 */       .setLevelNumOnly(false)
/* 259 */       .setIncSelf(false)
/* 260 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, String levelIdTagField, Function<SelectWhere, Sql> filterSql, boolean incSelf) {
/* 264 */     return (new Tree())
/* 265 */       .setUp(up)
/* 266 */       .setLevelsField(levelsField)
/* 267 */       .setLevelNumField("")
/* 268 */       .setLevelIdTagField(levelIdTagField)
/* 269 */       .setLevelIdField(levelIdField)
/* 270 */       .setTable(table)
/* 271 */       .setId(id)
/* 272 */       .setLevelNum(0)
/* 273 */       .setLevelNumOnly(false)
/* 274 */       .setIncSelf(incSelf)
/* 275 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, String levelIdTagField, int levelNum, String levelNumField) {
/* 279 */     return (new Tree())
/* 280 */       .setUp(up)
/* 281 */       .setLevelsField(levelsField)
/* 282 */       .setLevelNumField(levelNumField)
/* 283 */       .setLevelIdTagField(levelIdTagField)
/* 284 */       .setLevelIdField(levelIdField)
/* 285 */       .setTable(table)
/* 286 */       .setId(id)
/* 287 */       .setLevelNum(levelNum)
/* 288 */       .setLevelNumOnly(false)
/* 289 */       .setIncSelf(false)
/* 290 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static Tree<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, String levelIdTagField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 294 */     return (new Tree())
/* 295 */       .setUp(up)
/* 296 */       .setLevelsField(levelsField)
/* 297 */       .setLevelNumField(levelNumField)
/* 298 */       .setLevelIdTagField(levelIdTagField)
/* 299 */       .setLevelIdField(levelIdField)
/* 300 */       .setTable(table)
/* 301 */       .setId(id)
/* 302 */       .setLevelNum(levelNum)
/* 303 */       .setLevelNumOnly(false)
/* 304 */       .setIncSelf(false)
/* 305 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, String levelIdTagField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly) {
/* 309 */     return (new Tree())
/* 310 */       .setUp(up)
/* 311 */       .setLevelsField(levelsField)
/* 312 */       .setLevelNumField(levelNumField)
/* 313 */       .setLevelIdTagField(levelIdTagField)
/* 314 */       .setLevelIdField(levelIdField)
/* 315 */       .setTable(table)
/* 316 */       .setId(id)
/* 317 */       .setLevelNum(levelNum)
/* 318 */       .setLevelNumOnly(levelNumOnly)
/* 319 */       .setIncSelf(false)
/* 320 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static Tree<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, String levelIdTagField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly, boolean incSelf) {
/* 324 */     return (new Tree())
/* 325 */       .setUp(up)
/* 326 */       .setLevelsField(levelsField)
/* 327 */       .setLevelNumField(levelNumField)
/* 328 */       .setLevelIdTagField(levelIdTagField)
/* 329 */       .setLevelIdField(levelIdField)
/* 330 */       .setTable(table)
/* 331 */       .setId(id)
/* 332 */       .setLevelNum(levelNum)
/* 333 */       .setLevelNumOnly(levelNumOnly)
/* 334 */       .setIncSelf(incSelf)
/* 335 */       .setFilterSql(filterSql);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isCreate = false;
/*     */   
/*     */   private boolean up;
/*     */   
/*     */   private String levelsField;
/*     */   
/*     */   private String levelNumField;
/*     */   private String levelIdTagField;
/*     */   private String levelIdField;
/*     */   private int levelNum;
/*     */   private boolean levelNumOnly;
/*     */   private String table;
/*     */   private T id;
/*     */   private boolean incSelf;
/*     */   private Function<SelectWhere, Sql> filterSql;
/*     */   
/*     */   private String levelIdField() {
/* 356 */     return StringUtils.isBlank(this.levelIdField) ? "id" : this.levelIdField;
/*     */   }
/*     */   
/*     */   private String levelNumField() {
/* 360 */     return StringUtils.isBlank(this.levelNumField) ? "levelNum" : this.levelNumField;
/*     */   }
/*     */   
/*     */   private String levelIdTagField() {
/* 364 */     return StringUtils.isBlank(this.levelIdTagField) ? "levelIdTag" : this.levelIdTagField;
/*     */   }
/*     */   
/*     */   private String levelsField() {
/* 368 */     return StringUtils.isBlank(this.levelsField) ? "levels" : this.levelsField;
/*     */   }
/*     */   
/*     */   private String trimAlias(String field) {
/* 372 */     if (StringUtils.isBlank(field)) {
/* 373 */       return field;
/*     */     }
/* 375 */     int index = field.indexOf(".");
/* 376 */     if (index > 0) {
/* 377 */       return field.substring(index + 1);
/*     */     }
/* 379 */     return field;
/*     */   }
/*     */   
/*     */   private String levelNumOp() {
/* 383 */     return this.levelNumOnly ? "=" : "<=";
/*     */   }
/*     */   
/*     */   private Sql wrapperFilterSql(Sql sql) {
/* 387 */     if (this.filterSql == null) {
/* 388 */       return sql;
/*     */     }
/* 390 */     return this.filterSql.apply((SelectWhere)sql);
/*     */   }
/*     */   
/*     */   public StringBuilder getSql() {
/* 394 */     if (this.isCreate) {
/* 395 */       return super.getSql();
/*     */     }
/* 397 */     this.isCreate = true;
/* 398 */     BaseSql levelSql = null;
/* 399 */     BaseSql numSql = null;
/* 400 */     BaseSql incSql = null;
/*     */     
/* 402 */     if (this.up && this.id != null) {
/*     */ 
/*     */       
/* 405 */       levelSql = Sql.sql("(").addSql(wrapperFilterSql(Sql.select().field(trimAlias(levelsField())).from(this.table).where().andEq(trimAlias(levelIdField()), this.id))).addSql(String.format(") like %s", new Object[] { levelIdTagField() }), new Object[0]);
/* 406 */     } else if (this.id != null) {
/* 407 */       levelSql = Criteria.bLike(levelsField(), String.format(",%s,", new Object[] { this.id }));
/*     */     } 
/*     */     
/* 410 */     if (this.levelNum > 0) {
/* 411 */       if (this.up && this.id != null) {
/*     */ 
/*     */         
/* 414 */         numSql = Sql.sql("(").addSql(wrapperFilterSql(Sql.select().field(trimAlias(levelNumField())).from(this.table).where().andEq(trimAlias(levelIdField()), this.id))).addSql(String.format(") - %s %s ? ", new Object[] { levelNumField(), levelNumOp() }), new Object[] { Integer.valueOf(this.levelNum) });
/* 415 */       } else if (this.id != null) {
/*     */ 
/*     */         
/* 418 */         numSql = Sql.sql(String.format("%s - (", new Object[] { levelNumField() })).addSql(wrapperFilterSql(Sql.select().field(trimAlias(levelNumField())).from(this.table).where().andEq(trimAlias(levelIdField()), this.id))).addSql(String.format(") %s ? ", new Object[] { levelNumOp() }), new Object[] { Integer.valueOf(this.levelNum) });
/*     */       } else {
/* 420 */         numSql = Sql.sql(String.format("%s %s ? ", new Object[] { this.levelNumField, levelNumOp() }), new Object[] { Integer.valueOf(this.levelNum) });
/*     */       } 
/*     */     }
/*     */     
/* 424 */     if (this.incSelf && this.id != null) {
/* 425 */       incSql = Sql.sql(String.format("%s = ?", new Object[] { levelIdField() }), new Object[] { this.id });
/*     */     }
/*     */     
/* 428 */     BaseSql sql = null;
/*     */     
/* 430 */     if (levelSql != null && numSql != null) {
/* 431 */       sql = CriteriaGroup.and(new Sql[] { levelSql, numSql });
/* 432 */     } else if (levelSql != null) {
/* 433 */       sql = levelSql;
/* 434 */     } else if (numSql != null) {
/* 435 */       sql = numSql;
/*     */     } 
/*     */     
/* 438 */     if (sql != null && incSql != null) {
/* 439 */       sql = CriteriaGroup.or(new Sql[] { sql, incSql });
/* 440 */     } else if (sql == null && incSql != null) {
/* 441 */       sql = incSql;
/*     */     } 
/*     */     
/* 444 */     if (sql != null) {
/* 445 */       addSql(sql);
/*     */     }
/* 447 */     return super.getSql();
/*     */   }
/*     */ 
/*     */   
/*     */   private Tree<T> setUp(boolean up) {
/* 452 */     this.up = up;
/* 453 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setLevelsField(String levelsField) {
/* 457 */     this.levelsField = levelsField;
/* 458 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setLevelNumField(String levelNumField) {
/* 462 */     this.levelNumField = levelNumField;
/* 463 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setLevelIdTagField(String levelIdTagField) {
/* 467 */     this.levelIdTagField = levelIdTagField;
/* 468 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setLevelIdField(String levelIdField) {
/* 472 */     this.levelIdField = levelIdField;
/* 473 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setLevelNum(int levelNum) {
/* 477 */     this.levelNum = levelNum;
/* 478 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setTable(String table) {
/* 482 */     this.table = table;
/* 483 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setId(T id) {
/* 487 */     this.id = id;
/* 488 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setIncSelf(boolean incSelf) {
/* 492 */     this.incSelf = incSelf;
/* 493 */     return this;
/*     */   }
/*     */   
/*     */   public Tree<T> setFilterSql(Function<SelectWhere, Sql> filterSql) {
/* 497 */     this.filterSql = filterSql;
/* 498 */     return this;
/*     */   }
/*     */   
/*     */   private Tree<T> setLevelNumOnly(boolean levelNumOnly) {
/* 502 */     this.levelNumOnly = levelNumOnly;
/* 503 */     return this;
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/Tree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */