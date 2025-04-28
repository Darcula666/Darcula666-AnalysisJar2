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
/*     */ public class TreeMysql<T>
/*     */   extends BaseSql
/*     */ {
/*     */   public static TreeMysql<?> down(Object id, String levelsField) {
/*  58 */     return (new TreeMysql())
/*  59 */       .setUp(false)
/*  60 */       .setLevelsField(levelsField)
/*  61 */       .setLevelNumField("")
/*  62 */       .setLevelIdField("")
/*  63 */       .setTable("")
/*  64 */       .setId(id)
/*  65 */       .setLevelNum(0)
/*  66 */       .setLevelNumOnly(false)
/*  67 */       .setIncSelf(false)
/*  68 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> down(Object id, String levelsField, boolean incSelf, String levelIdField) {
/*  72 */     return (new TreeMysql())
/*  73 */       .setUp(false)
/*  74 */       .setLevelsField(levelsField)
/*  75 */       .setLevelNumField("")
/*  76 */       .setLevelIdField(levelIdField)
/*  77 */       .setTable("")
/*  78 */       .setId(id)
/*  79 */       .setLevelNum(0)
/*  80 */       .setLevelNumOnly(false)
/*  81 */       .setIncSelf(incSelf)
/*  82 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> down(Object id, String levelsField, int levelNum, String levelIdField) {
/*  86 */     return (new TreeMysql())
/*  87 */       .setUp(false)
/*  88 */       .setLevelsField(levelsField)
/*  89 */       .setLevelNumField("")
/*  90 */       .setLevelIdField(levelIdField)
/*  91 */       .setTable("")
/*  92 */       .setId(id)
/*  93 */       .setLevelNum(levelNum)
/*  94 */       .setLevelNumOnly(false)
/*  95 */       .setIncSelf(false)
/*  96 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> down(Object id, String levelsField, int levelNum, String levelIdField, boolean levelNumOnly) {
/* 100 */     return (new TreeMysql())
/* 101 */       .setUp(false)
/* 102 */       .setLevelsField(levelsField)
/* 103 */       .setLevelNumField("")
/* 104 */       .setLevelIdField(levelIdField)
/* 105 */       .setTable("")
/* 106 */       .setId(id)
/* 107 */       .setLevelNum(levelNum)
/* 108 */       .setLevelNumOnly(levelNumOnly)
/* 109 */       .setIncSelf(false)
/* 110 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> down(Object id, String levelsField, int levelNum, String levelIdField, boolean levelNumOnly, boolean incSelf) {
/* 114 */     return (new TreeMysql())
/* 115 */       .setUp(false)
/* 116 */       .setLevelsField(levelsField)
/* 117 */       .setLevelNumField("")
/* 118 */       .setLevelIdField(levelIdField)
/* 119 */       .setTable("")
/* 120 */       .setId(id)
/* 121 */       .setLevelNum(levelNum)
/* 122 */       .setLevelNumOnly(levelNumOnly)
/* 123 */       .setIncSelf(incSelf)
/* 124 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> down(Object id, String levelsField, int levelNum, String levelIdField, String levelNumField, String table) {
/* 128 */     return (new TreeMysql())
/* 129 */       .setUp(false)
/* 130 */       .setLevelsField(levelsField)
/* 131 */       .setLevelNumField(levelNumField)
/* 132 */       .setLevelIdField(levelIdField)
/* 133 */       .setTable(table)
/* 134 */       .setId(id)
/* 135 */       .setLevelNum(levelNum)
/* 136 */       .setLevelNumOnly(false)
/* 137 */       .setIncSelf(false)
/* 138 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> down(Object id, String levelsField, int levelNum, String levelIdField, String levelNumField, String table, Function<SelectWhere, Sql> filterSql) {
/* 142 */     return (new TreeMysql())
/* 143 */       .setUp(false)
/* 144 */       .setLevelsField(levelsField)
/* 145 */       .setLevelNumField(levelNumField)
/* 146 */       .setLevelIdField(levelIdField)
/* 147 */       .setTable(table)
/* 148 */       .setId(id)
/* 149 */       .setLevelNum(levelNum)
/* 150 */       .setLevelNumOnly(false)
/* 151 */       .setIncSelf(false)
/* 152 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> down(Object id, String levelsField, int levelNum, String levelIdField, String levelNumField, String table, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly) {
/* 156 */     return (new TreeMysql())
/* 157 */       .setUp(false)
/* 158 */       .setLevelsField(levelsField)
/* 159 */       .setLevelNumField(levelNumField)
/* 160 */       .setLevelIdField(levelIdField)
/* 161 */       .setTable(table)
/* 162 */       .setId(id)
/* 163 */       .setLevelNum(levelNum)
/* 164 */       .setLevelNumOnly(levelNumOnly)
/* 165 */       .setIncSelf(false)
/* 166 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> down(Object id, String levelsField, int levelNum, String levelIdField, String levelNumField, String table, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly, boolean incSelf) {
/* 170 */     return (new TreeMysql())
/* 171 */       .setUp(false)
/* 172 */       .setLevelsField(levelsField)
/* 173 */       .setLevelNumField(levelNumField)
/* 174 */       .setLevelIdField(levelIdField)
/* 175 */       .setTable(table)
/* 176 */       .setId(id)
/* 177 */       .setLevelNum(levelNum)
/* 178 */       .setLevelNumOnly(levelNumOnly)
/* 179 */       .setIncSelf(incSelf)
/* 180 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField) {
/* 184 */     return (new TreeMysql())
/* 185 */       .setUp(true)
/* 186 */       .setLevelsField(levelsField)
/* 187 */       .setLevelNumField("")
/* 188 */       .setLevelIdField(levelIdField)
/* 189 */       .setTable(table)
/* 190 */       .setId(id)
/* 191 */       .setLevelNum(0)
/* 192 */       .setLevelNumOnly(false)
/* 193 */       .setIncSelf(false)
/* 194 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, Function<SelectWhere, Sql> filterSql) {
/* 198 */     return (new TreeMysql())
/* 199 */       .setUp(true)
/* 200 */       .setLevelsField(levelsField)
/* 201 */       .setLevelNumField("")
/* 202 */       .setLevelIdField(levelIdField)
/* 203 */       .setTable(table)
/* 204 */       .setId(id)
/* 205 */       .setLevelNum(0)
/* 206 */       .setLevelNumOnly(false)
/* 207 */       .setIncSelf(false)
/* 208 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, Function<SelectWhere, Sql> filterSql, boolean incSelf) {
/* 212 */     return (new TreeMysql())
/* 213 */       .setUp(true)
/* 214 */       .setLevelsField(levelsField)
/* 215 */       .setLevelNumField("")
/* 216 */       .setLevelIdField(levelIdField)
/* 217 */       .setTable(table)
/* 218 */       .setId(id)
/* 219 */       .setLevelNum(0)
/* 220 */       .setLevelNumOnly(false)
/* 221 */       .setIncSelf(incSelf)
/* 222 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, int levelNum) {
/* 226 */     return (new TreeMysql())
/* 227 */       .setUp(true)
/* 228 */       .setLevelsField(levelsField)
/* 229 */       .setLevelNumField("")
/* 230 */       .setLevelIdField(levelIdField)
/* 231 */       .setTable(table)
/* 232 */       .setId(id)
/* 233 */       .setLevelNum(levelNum)
/* 234 */       .setLevelNumOnly(false)
/* 235 */       .setIncSelf(false)
/* 236 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, int levelNum, Function<SelectWhere, Sql> filterSql) {
/* 240 */     return (new TreeMysql())
/* 241 */       .setUp(true)
/* 242 */       .setLevelsField(levelsField)
/* 243 */       .setLevelNumField("")
/* 244 */       .setLevelIdField(levelIdField)
/* 245 */       .setTable(table)
/* 246 */       .setId(id)
/* 247 */       .setLevelNum(levelNum)
/* 248 */       .setLevelNumOnly(false)
/* 249 */       .setIncSelf(false)
/* 250 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, int levelNum, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly) {
/* 254 */     return (new TreeMysql())
/* 255 */       .setUp(true)
/* 256 */       .setLevelsField(levelsField)
/* 257 */       .setLevelNumField("")
/* 258 */       .setLevelIdField(levelIdField)
/* 259 */       .setTable(table)
/* 260 */       .setId(id)
/* 261 */       .setLevelNum(levelNum)
/* 262 */       .setLevelNumOnly(levelNumOnly)
/* 263 */       .setIncSelf(false)
/* 264 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, int levelNum, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly, boolean incSelf) {
/* 268 */     return (new TreeMysql())
/* 269 */       .setUp(true)
/* 270 */       .setLevelsField(levelsField)
/* 271 */       .setLevelNumField("")
/* 272 */       .setLevelIdField(levelIdField)
/* 273 */       .setTable(table)
/* 274 */       .setId(id)
/* 275 */       .setLevelNum(levelNum)
/* 276 */       .setLevelNumOnly(levelNumOnly)
/* 277 */       .setIncSelf(incSelf)
/* 278 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, int levelNum, String levelNumField) {
/* 282 */     return (new TreeMysql())
/* 283 */       .setUp(true)
/* 284 */       .setLevelsField(levelsField)
/* 285 */       .setLevelNumField(levelNumField)
/* 286 */       .setLevelIdField(levelIdField)
/* 287 */       .setTable(table)
/* 288 */       .setId(id)
/* 289 */       .setLevelNum(levelNum)
/* 290 */       .setLevelNumOnly(false)
/* 291 */       .setIncSelf(false)
/* 292 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 296 */     return (new TreeMysql())
/* 297 */       .setUp(true)
/* 298 */       .setLevelsField(levelsField)
/* 299 */       .setLevelNumField(levelNumField)
/* 300 */       .setLevelIdField(levelIdField)
/* 301 */       .setTable(table)
/* 302 */       .setId(id)
/* 303 */       .setLevelNum(levelNum)
/* 304 */       .setLevelNumOnly(false)
/* 305 */       .setIncSelf(false)
/* 306 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly) {
/* 310 */     return (new TreeMysql())
/* 311 */       .setUp(true)
/* 312 */       .setLevelsField(levelsField)
/* 313 */       .setLevelNumField(levelNumField)
/* 314 */       .setLevelIdField(levelIdField)
/* 315 */       .setTable(table)
/* 316 */       .setId(id)
/* 317 */       .setLevelNum(levelNum)
/* 318 */       .setLevelNumOnly(levelNumOnly)
/* 319 */       .setIncSelf(false)
/* 320 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> up(Object id, String table, String levelsField, String levelIdField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly, boolean incSelf) {
/* 324 */     return (new TreeMysql())
/* 325 */       .setUp(true)
/* 326 */       .setLevelsField(levelsField)
/* 327 */       .setLevelNumField(levelNumField)
/* 328 */       .setLevelIdField(levelIdField)
/* 329 */       .setTable(table)
/* 330 */       .setId(id)
/* 331 */       .setLevelNum(levelNum)
/* 332 */       .setLevelNumOnly(levelNumOnly)
/* 333 */       .setIncSelf(incSelf)
/* 334 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField) {
/* 338 */     return (new TreeMysql())
/* 339 */       .setUp(up)
/* 340 */       .setLevelsField(levelsField)
/* 341 */       .setLevelNumField("")
/* 342 */       .setLevelIdField(levelIdField)
/* 343 */       .setTable(table)
/* 344 */       .setId(id)
/* 345 */       .setLevelNum(0)
/* 346 */       .setLevelNumOnly(false)
/* 347 */       .setIncSelf(false)
/* 348 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, Function<SelectWhere, Sql> filterSql) {
/* 352 */     return (new TreeMysql())
/* 353 */       .setUp(up)
/* 354 */       .setLevelsField(levelsField)
/* 355 */       .setLevelNumField("")
/* 356 */       .setLevelIdField(levelIdField)
/* 357 */       .setTable(table)
/* 358 */       .setId(id)
/* 359 */       .setLevelNum(0)
/* 360 */       .setLevelNumOnly(false)
/* 361 */       .setIncSelf(false)
/* 362 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, Function<SelectWhere, Sql> filterSql, boolean incSelf) {
/* 366 */     return (new TreeMysql())
/* 367 */       .setUp(up)
/* 368 */       .setLevelsField(levelsField)
/* 369 */       .setLevelNumField("")
/* 370 */       .setLevelIdField(levelIdField)
/* 371 */       .setTable(table)
/* 372 */       .setId(id)
/* 373 */       .setLevelNum(0)
/* 374 */       .setLevelNumOnly(false)
/* 375 */       .setIncSelf(incSelf)
/* 376 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum) {
/* 380 */     return (new TreeMysql())
/* 381 */       .setUp(up)
/* 382 */       .setLevelsField(levelsField)
/* 383 */       .setLevelNumField("")
/* 384 */       .setLevelIdField(levelIdField)
/* 385 */       .setTable(table)
/* 386 */       .setId(id)
/* 387 */       .setLevelNum(levelNum)
/* 388 */       .setLevelNumOnly(false)
/* 389 */       .setIncSelf(false)
/* 390 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum, Function<SelectWhere, Sql> filterSql) {
/* 394 */     return (new TreeMysql())
/* 395 */       .setUp(up)
/* 396 */       .setLevelsField(levelsField)
/* 397 */       .setLevelNumField("")
/* 398 */       .setLevelIdField(levelIdField)
/* 399 */       .setTable(table)
/* 400 */       .setId(id)
/* 401 */       .setLevelNum(levelNum)
/* 402 */       .setLevelNumOnly(false)
/* 403 */       .setIncSelf(false)
/* 404 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly) {
/* 408 */     return (new TreeMysql())
/* 409 */       .setUp(up)
/* 410 */       .setLevelsField(levelsField)
/* 411 */       .setLevelNumField("")
/* 412 */       .setLevelIdField(levelIdField)
/* 413 */       .setTable(table)
/* 414 */       .setId(id)
/* 415 */       .setLevelNum(levelNum)
/* 416 */       .setLevelNumOnly(levelNumOnly)
/* 417 */       .setIncSelf(false)
/* 418 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly, boolean incSelf) {
/* 422 */     return (new TreeMysql())
/* 423 */       .setUp(up)
/* 424 */       .setLevelsField(levelsField)
/* 425 */       .setLevelNumField("")
/* 426 */       .setLevelIdField(levelIdField)
/* 427 */       .setTable(table)
/* 428 */       .setId(id)
/* 429 */       .setLevelNum(levelNum)
/* 430 */       .setLevelNumOnly(levelNumOnly)
/* 431 */       .setIncSelf(incSelf)
/* 432 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum, String levelNumField) {
/* 436 */     return (new TreeMysql())
/* 437 */       .setUp(up)
/* 438 */       .setLevelsField(levelsField)
/* 439 */       .setLevelNumField(levelNumField)
/* 440 */       .setLevelIdField(levelIdField)
/* 441 */       .setTable(table)
/* 442 */       .setId(id)
/* 443 */       .setLevelNum(levelNum)
/* 444 */       .setLevelNumOnly(false)
/* 445 */       .setIncSelf(false)
/* 446 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql) {
/* 450 */     return (new TreeMysql())
/* 451 */       .setUp(up)
/* 452 */       .setLevelsField(levelsField)
/* 453 */       .setLevelNumField(levelNumField)
/* 454 */       .setLevelIdField(levelIdField)
/* 455 */       .setTable(table)
/* 456 */       .setId(id)
/* 457 */       .setLevelNum(levelNum)
/* 458 */       .setLevelNumOnly(false)
/* 459 */       .setIncSelf(false)
/* 460 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly) {
/* 464 */     return (new TreeMysql())
/* 465 */       .setUp(up)
/* 466 */       .setLevelsField(levelsField)
/* 467 */       .setLevelNumField(levelNumField)
/* 468 */       .setLevelIdField(levelIdField)
/* 469 */       .setTable(table)
/* 470 */       .setId(id)
/* 471 */       .setLevelNum(levelNum)
/* 472 */       .setLevelNumOnly(levelNumOnly)
/* 473 */       .setIncSelf(false)
/* 474 */       .setFilterSql(filterSql);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum, boolean levelNumOnly, boolean incSelf) {
/* 478 */     return (new TreeMysql())
/* 479 */       .setUp(up)
/* 480 */       .setLevelsField(levelsField)
/* 481 */       .setLevelNumField("")
/* 482 */       .setLevelIdField(levelIdField)
/* 483 */       .setTable(table)
/* 484 */       .setId(id)
/* 485 */       .setLevelNum(levelNum)
/* 486 */       .setLevelNumOnly(levelNumOnly)
/* 487 */       .setIncSelf(incSelf)
/* 488 */       .setFilterSql(null);
/*     */   }
/*     */   
/*     */   public static TreeMysql<?> tree(Object id, boolean up, String table, String levelsField, String levelIdField, int levelNum, String levelNumField, Function<SelectWhere, Sql> filterSql, boolean levelNumOnly, boolean incSelf) {
/* 492 */     return (new TreeMysql())
/* 493 */       .setUp(up)
/* 494 */       .setLevelsField(levelsField)
/* 495 */       .setLevelNumField(levelNumField)
/* 496 */       .setLevelIdField(levelIdField)
/* 497 */       .setTable(table)
/* 498 */       .setId(id)
/* 499 */       .setLevelNum(levelNum)
/* 500 */       .setLevelNumOnly(levelNumOnly)
/* 501 */       .setIncSelf(incSelf)
/* 502 */       .setFilterSql(filterSql);
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
/*     */   private String levelIdField;
/*     */   private int levelNum;
/*     */   private boolean levelNumOnly;
/*     */   private String table;
/*     */   private T id;
/*     */   private boolean incSelf;
/*     */   private Function<SelectWhere, Sql> filterSql;
/*     */   
/*     */   private String levelIdField() {
/* 522 */     return StringUtils.isBlank(this.levelIdField) ? "id" : this.levelIdField;
/*     */   }
/*     */   
/*     */   private String levelsField() {
/* 526 */     return StringUtils.isBlank(this.levelsField) ? "levels" : this.levelsField;
/*     */   }
/*     */   
/*     */   private String levelNumOp() {
/* 530 */     return this.levelNumOnly ? "=" : "<=";
/*     */   }
/*     */   
/*     */   private String trimAlias(String field) {
/* 534 */     if (StringUtils.isBlank(field)) {
/* 535 */       return field;
/*     */     }
/* 537 */     int index = field.indexOf(".");
/* 538 */     if (index > 0) {
/* 539 */       return field.substring(index + 1);
/*     */     }
/* 541 */     return field;
/*     */   }
/*     */   
/*     */   private Sql wrapperFilterSql(Sql sql) {
/* 545 */     if (this.filterSql == null) {
/* 546 */       return sql;
/*     */     }
/* 548 */     return this.filterSql.apply((SelectWhere)sql);
/*     */   }
/*     */   
/*     */   public StringBuilder getSql() {
/* 552 */     if (this.isCreate) {
/* 553 */       return super.getSql();
/*     */     }
/* 555 */     this.isCreate = true;
/* 556 */     BaseSql levelSql = null;
/* 557 */     BaseSql numSql = null;
/* 558 */     BaseSql incSql = null;
/*     */     
/* 560 */     if (this.up && this.id != null) {
/*     */ 
/*     */ 
/*     */       
/* 564 */       levelSql = Sql.sql(String.format("find_in_set(%s, (", new Object[] { levelIdField() })).addSql(wrapperFilterSql(Sql.select().field(trimAlias(levelsField())).from(this.table).where().andEq(trimAlias(levelIdField()), this.id))).addSql("))", new Object[0]);
/* 565 */     } else if (this.id != null) {
/*     */       
/* 567 */       levelSql = Sql.sql(String.format("find_in_set(?,%s)", new Object[] { levelsField() }), new Object[] { this.id });
/*     */     } 
/*     */     
/* 570 */     if (this.levelNum > 0) {
/* 571 */       if (this.up && this.id != null) {
/* 572 */         if (StringUtils.isBlank(this.levelNumField)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 579 */           numSql = Sql.sql("find_in_set(?,(", new Object[] { this.id }).addSql(wrapperFilterSql(Sql.select().field(String.format("trim(',' from concat(trim(',' from %s),',',%s))", new Object[] { trimAlias(levelsField()), trimAlias(levelIdField()) })).from(this.table).where().andEq(trimAlias(levelIdField()), this.id))).addSql(String.format(")) - find_in_set(%s,trim(',' from concat(trim(',' from %s),',',%s)))", new Object[] { levelIdField(), levelsField(), levelIdField() }), new Object[0]).addSql(String.format(" %s ? ", new Object[] { levelNumOp() }), new Object[] { Integer.valueOf(this.levelNum) });
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 584 */           numSql = Sql.sql("(").addSql(wrapperFilterSql(Sql.select().field(trimAlias(this.levelNumField)).from(this.table).where().andEq(trimAlias(levelIdField()), this.id))).addSql(String.format(") - %s %s ? ", new Object[] { this.levelNumField, levelNumOp() }), new Object[] { Integer.valueOf(this.levelNum) });
/*     */         } 
/* 586 */       } else if (this.id != null) {
/* 587 */         if (StringUtils.isBlank(this.levelNumField)) {
/*     */           
/* 589 */           numSql = Sql.sql(String.format("find_in_set(%s,trim(',' from concat(trim(',' from %s),',',%s))) - find_in_set(?,trim(',' from %s)) %s ? ", new Object[] { levelIdField(), levelsField(), levelIdField(), levelsField(), levelNumOp() }), new Object[] { this.id, Integer.valueOf(this.levelNum) });
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 594 */           numSql = Sql.sql(String.format("%s - (", new Object[] { this.levelNumField })).addSql(wrapperFilterSql(Sql.select().field(trimAlias(this.levelNumField)).from(this.table).where().andEq(trimAlias(levelIdField()), this.id))).addSql(String.format(") %s ? ", new Object[] { levelNumOp() }), new Object[] { Integer.valueOf(this.levelNum) });
/*     */         } 
/*     */       } else {
/* 597 */         numSql = Sql.sql(String.format("%s %s ? ", new Object[] { this.levelNumField, levelNumOp() }), new Object[] { Integer.valueOf(this.levelNum) });
/*     */       } 
/*     */     }
/*     */     
/* 601 */     if (this.incSelf && this.id != null)
/*     */     {
/* 603 */       incSql = Sql.sql(String.format("%s = ?", new Object[] { levelIdField() }), new Object[] { this.id });
/*     */     }
/*     */     
/* 606 */     BaseSql sql = null;
/*     */     
/* 608 */     if (levelSql != null && numSql != null) {
/* 609 */       sql = CriteriaGroup.and(new Sql[] { levelSql, numSql });
/* 610 */     } else if (levelSql != null) {
/* 611 */       sql = levelSql;
/* 612 */     } else if (numSql != null) {
/* 613 */       sql = numSql;
/*     */     } 
/*     */     
/* 616 */     if (sql != null && incSql != null) {
/* 617 */       sql = CriteriaGroup.or(new Sql[] { sql, incSql });
/* 618 */     } else if (sql == null && incSql != null) {
/* 619 */       sql = incSql;
/*     */     } 
/*     */     
/* 622 */     if (sql != null) {
/* 623 */       addSql(sql);
/*     */     }
/* 625 */     return super.getSql();
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setUp(boolean up) {
/* 629 */     this.up = up;
/* 630 */     return this;
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setLevelsField(String levelsField) {
/* 634 */     this.levelsField = levelsField;
/* 635 */     return this;
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setLevelNumField(String levelNumField) {
/* 639 */     this.levelNumField = levelNumField;
/* 640 */     return this;
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setLevelIdField(String levelIdField) {
/* 644 */     this.levelIdField = levelIdField;
/* 645 */     return this;
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setLevelNum(int levelNum) {
/* 649 */     this.levelNum = levelNum;
/* 650 */     return this;
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setLevelNumOnly(boolean levelNumOnly) {
/* 654 */     this.levelNumOnly = levelNumOnly;
/* 655 */     return this;
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setTable(String table) {
/* 659 */     this.table = table;
/* 660 */     return this;
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setId(T id) {
/* 664 */     this.id = id;
/* 665 */     return this;
/*     */   }
/*     */   
/*     */   private TreeMysql<T> setIncSelf(boolean incSelf) {
/* 669 */     this.incSelf = incSelf;
/* 670 */     return this;
/*     */   }
/*     */   
/*     */   public TreeMysql<T> setFilterSql(Function<SelectWhere, Sql> filterSql) {
/* 674 */     this.filterSql = filterSql;
/* 675 */     return this;
/*     */   }
/*     */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/TreeMysql.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */