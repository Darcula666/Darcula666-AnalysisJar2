/*      */ package com.redare.devframework.sql.db.base;
/*      */ import com.redare.devframework.sql.Select;
/*      */ import com.redare.devframework.sql.SelectWhere;
/*      */ import com.redare.devframework.sql.Sql;
/*      */ import com.redare.devframework.sql.Where;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.Optional;
/*      */ import java.util.Set;
/*      */ import java.util.function.Consumer;
/*      */ import java.util.function.Function;
/*      */ import org.apache.commons.collections.CollectionUtils;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ 
/*      */ public abstract class TreeJdbcDaoSupport extends BaseJdbcDaoSupport {
/*      */   public static class SyncLevelField {
/*      */     private String levelNumField;
/*      */     private String levelIdTagField;
/*      */     
/*      */     public String getLevelNumField() {
/*   24 */       return this.levelNumField;
/*      */     }
/*      */     private String leafField; private Map<String, String> otherLevelFieldsMap;
/*      */     public SyncLevelField setLevelNumField(String levelNumField) {
/*   28 */       this.levelNumField = levelNumField;
/*   29 */       return this;
/*      */     }
/*      */     
/*      */     public String getLevelIdTagField() {
/*   33 */       return this.levelIdTagField;
/*      */     }
/*      */     
/*      */     public SyncLevelField setLevelIdTagField(String levelIdTagField) {
/*   37 */       this.levelIdTagField = levelIdTagField;
/*   38 */       return this;
/*      */     }
/*      */     
/*      */     public String getLeafField() {
/*   42 */       return this.leafField;
/*      */     }
/*      */     
/*      */     public SyncLevelField setLeafField(String leafField) {
/*   46 */       this.leafField = leafField;
/*   47 */       return this;
/*      */     }
/*      */     
/*      */     public Map<String, String> getOtherLevelFieldsMap() {
/*   51 */       return this.otherLevelFieldsMap;
/*      */     }
/*      */     
/*      */     public SyncLevelField setOtherLevelFieldsMap(Map<String, String> otherLevelFieldsMap) {
/*   55 */       this.otherLevelFieldsMap = otherLevelFieldsMap;
/*   56 */       return this;
/*      */     }
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
/*      */   public int[] resetTreeSiblingNodeOrder(Object parentId, String table, String orderField, String idField, String parentIdField, Order order) {
/*   72 */     return resetTreeSiblingNodeOrder(parentId, table, orderField, idField, parentIdField, (Consumer<Where>)null, order);
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
/*      */   public int[] resetTreeSiblingNodeOrder(Object parentId, String table, String orderField, String idField, String parentIdField, Consumer<Where> filterSql, Order order) {
/*      */     // Byte code:
/*      */     //   0: invokestatic select : ()Lcom/redare/devframework/sql/Select;
/*      */     //   3: aload #4
/*      */     //   5: invokevirtual field : (Ljava/lang/String;)Lcom/redare/devframework/sql/Select;
/*      */     //   8: aload_2
/*      */     //   9: invokevirtual from : (Ljava/lang/String;)Lcom/redare/devframework/sql/From;
/*      */     //   12: invokevirtual where : ()Lcom/redare/devframework/sql/SelectWhere;
/*      */     //   15: aload #5
/*      */     //   17: aload_1
/*      */     //   18: invokevirtual andEq : (Ljava/lang/String;Ljava/lang/Object;)Lcom/redare/devframework/sql/SelectWhere;
/*      */     //   21: astore #8
/*      */     //   23: aload #6
/*      */     //   25: ifnull -> 40
/*      */     //   28: aload #6
/*      */     //   30: aload #8
/*      */     //   32: checkcast com/redare/devframework/sql/Where
/*      */     //   35: invokeinterface accept : (Ljava/lang/Object;)V
/*      */     //   40: aload #8
/*      */     //   42: checkcast com/redare/devframework/sql/SelectWhere
/*      */     //   45: invokevirtual orderBy : ()Lcom/redare/devframework/sql/Order;
/*      */     //   48: aload #7
/*      */     //   50: ifnull -> 57
/*      */     //   53: iconst_1
/*      */     //   54: goto -> 58
/*      */     //   57: iconst_0
/*      */     //   58: aload #7
/*      */     //   60: invokevirtual orderIf : (ZLcom/redare/devframework/sql/Order;)Lcom/redare/devframework/sql/Order;
/*      */     //   63: astore #8
/*      */     //   65: aload_0
/*      */     //   66: aload #8
/*      */     //   68: invokevirtual queryForListMap : (Lcom/redare/devframework/sql/Sql;)Ljava/util/List;
/*      */     //   71: astore #9
/*      */     //   73: aload #9
/*      */     //   75: invokestatic isEmpty : (Ljava/util/Collection;)Z
/*      */     //   78: ifeq -> 89
/*      */     //   81: iconst_1
/*      */     //   82: newarray int
/*      */     //   84: dup
/*      */     //   85: iconst_0
/*      */     //   86: iconst_0
/*      */     //   87: iastore
/*      */     //   88: areturn
/*      */     //   89: aload #9
/*      */     //   91: invokeinterface size : ()I
/*      */     //   96: iconst_1
/*      */     //   97: iadd
/*      */     //   98: i2l
/*      */     //   99: lstore #10
/*      */     //   101: new java/util/ArrayList
/*      */     //   104: dup
/*      */     //   105: invokespecial <init> : ()V
/*      */     //   108: astore #12
/*      */     //   110: aload #9
/*      */     //   112: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   117: astore #13
/*      */     //   119: aload #13
/*      */     //   121: invokeinterface hasNext : ()Z
/*      */     //   126: ifeq -> 185
/*      */     //   129: aload #13
/*      */     //   131: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   136: checkcast java/util/Map
/*      */     //   139: astore #14
/*      */     //   141: aload #14
/*      */     //   143: aload #4
/*      */     //   145: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   150: astore #15
/*      */     //   152: aload #12
/*      */     //   154: iconst_2
/*      */     //   155: anewarray java/lang/Object
/*      */     //   158: dup
/*      */     //   159: iconst_0
/*      */     //   160: lload #10
/*      */     //   162: dup2
/*      */     //   163: lconst_1
/*      */     //   164: lsub
/*      */     //   165: lstore #10
/*      */     //   167: invokestatic valueOf : (J)Ljava/lang/Long;
/*      */     //   170: aastore
/*      */     //   171: dup
/*      */     //   172: iconst_1
/*      */     //   173: aload #15
/*      */     //   175: aastore
/*      */     //   176: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   181: pop
/*      */     //   182: goto -> 119
/*      */     //   185: aload_2
/*      */     //   186: invokestatic update : (Ljava/lang/String;)Lcom/redare/devframework/sql/Update;
/*      */     //   189: aload_3
/*      */     //   190: ldc ''
/*      */     //   192: invokevirtual set : (Ljava/lang/String;Ljava/lang/Object;)Lcom/redare/devframework/sql/Update;
/*      */     //   195: invokevirtual where : ()Lcom/redare/devframework/sql/Where;
/*      */     //   198: aload #4
/*      */     //   200: ldc ''
/*      */     //   202: invokevirtual andEq : (Ljava/lang/String;Ljava/lang/Object;)Lcom/redare/devframework/sql/Where;
/*      */     //   205: astore #8
/*      */     //   207: aload_0
/*      */     //   208: aload #8
/*      */     //   210: aload #12
/*      */     //   212: invokevirtual batchUpdate : (Lcom/redare/devframework/sql/Sql;Ljava/util/List;)[I
/*      */     //   215: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #88	-> 0
/*      */     //   #89	-> 5
/*      */     //   #90	-> 9
/*      */     //   #91	-> 12
/*      */     //   #92	-> 18
/*      */     //   #93	-> 23
/*      */     //   #94	-> 28
/*      */     //   #96	-> 40
/*      */     //   #97	-> 65
/*      */     //   #98	-> 73
/*      */     //   #99	-> 81
/*      */     //   #101	-> 89
/*      */     //   #102	-> 101
/*      */     //   #103	-> 110
/*      */     //   #104	-> 141
/*      */     //   #105	-> 152
/*      */     //   #106	-> 182
/*      */     //   #107	-> 185
/*      */     //   #108	-> 207
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   152	30	15	levelId	Ljava/lang/Object;
/*      */     //   141	41	14	data	Ljava/util/Map;
/*      */     //   0	216	0	this	Lcom/redare/devframework/sql/db/base/TreeJdbcDaoSupport;
/*      */     //   0	216	1	parentId	Ljava/lang/Object;
/*      */     //   0	216	2	table	Ljava/lang/String;
/*      */     //   0	216	3	orderField	Ljava/lang/String;
/*      */     //   0	216	4	idField	Ljava/lang/String;
/*      */     //   0	216	5	parentIdField	Ljava/lang/String;
/*      */     //   0	216	6	filterSql	Ljava/util/function/Consumer;
/*      */     //   0	216	7	order	Lcom/redare/devframework/sql/Order;
/*      */     //   23	193	8	sql	Lcom/redare/devframework/sql/Sql;
/*      */     //   73	143	9	list	Ljava/util/List;
/*      */     //   101	115	10	count	J
/*      */     //   110	106	12	params	Ljava/util/List;
/*      */     // Local variable type table:
/*      */     //   start	length	slot	name	signature
/*      */     //   141	41	14	data	Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;
/*      */     //   0	216	6	filterSql	Ljava/util/function/Consumer<Lcom/redare/devframework/sql/Where;>;
/*      */     //   73	143	9	list	Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;>;
/*      */     //   110	106	12	params	Ljava/util/List<[Ljava/lang/Object;>;
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
/*      */   public int[] sortTreeSiblingNodeDesc(Object id, boolean up, String table, String orderField, String idField, String parentIdField) {
/*  123 */     return sortTreeSiblingNodeDesc(id, (Object)null, up, table, orderField, idField, parentIdField, (Consumer<Where>)null);
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
/*      */   public int[] sortTreeSiblingNodeDesc(Object id, boolean up, String table, String orderField, String idField, String parentIdField, Consumer<Where> filterSql) {
/*  139 */     return sortTreeSiblingNodeDesc(id, (Object)null, up, table, orderField, idField, parentIdField, filterSql);
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
/*      */   public int[] sortTreeSiblingNodeDesc(Object id, Object siblingId, boolean up, String table, String orderField, String idField, String parentIdField) {
/*  155 */     return sortTreeSiblingNodeDesc(id, siblingId, up, table, orderField, idField, parentIdField, (Consumer<Where>)null);
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
/*      */   public int[] sortTreeSiblingNodeDesc(Object id, Object siblingId, boolean up, String table, String orderField, String idField, String parentIdField, Consumer<Where> filterSql) {
/*  172 */     SelectWhere selectWhere1 = Sql.select().field(parentIdField).from(table).where().andEq(idField, id);
/*  173 */     if (filterSql != null) {
/*  174 */       filterSql.accept((Where)selectWhere1);
/*      */     }
/*      */     
/*  177 */     SelectWhere selectWhere2 = Sql.select().field(idField).from(table).where().andEq(parentIdField, (Sql)selectWhere1).andNotEq(idField, id);
/*  178 */     if (filterSql != null) {
/*  179 */       filterSql.accept((Where)selectWhere2);
/*      */     }
/*  181 */     Order order = selectWhere2.orderBy().desc(new String[] { orderField });
/*  182 */     List<Map<String, Object>> list = queryForListMap((Sql)order);
/*  183 */     List<Object[]> params = new ArrayList();
/*      */     
/*  185 */     if (CollectionUtils.isEmpty(list))
/*  186 */     { params.add(new Object[] { Integer.valueOf(1), id }); }
/*      */     else
/*  188 */     { long count = (list.size() + 1);
/*  189 */       if (siblingId == null && up) {
/*  190 */         params.add(new Object[] { Long.valueOf(count--), id });
/*      */       }
/*  192 */       Iterator<Map<String, Object>> iterator = list.iterator(); if (iterator.hasNext()) { Map<String, Object> data = iterator.next();
/*  193 */         Object levelId = data.get(idField);
/*      */ 
/*      */         
/*  196 */         params.add(new Object[] { Long.valueOf(count--), id });
/*  197 */         params.add(new Object[] { Long.valueOf(count--), levelId });
/*      */         
/*  199 */         params.add(new Object[] { Long.valueOf(count--), levelId });
/*  200 */         params.add(new Object[] { Long.valueOf(count--), id });
/*      */ 
/*      */ 
/*      */         
/*  204 */         params.add(new Object[] { Long.valueOf(count--), levelId }); }
/*      */       else
/*  206 */       { if (siblingId == null && !up) {
/*  207 */           params.add(new Object[] { Long.valueOf(count), id });
/*      */         }
/*      */         
/*  210 */         Where where1 = Sql.update(table).set(orderField).where().andEqs(new String[] { idField });
/*  211 */         return batchUpdate((Sql)where1, params); }  }  Where where = Sql.update(table).set(orderField).where().andEqs(new String[] { idField }); return batchUpdate((Sql)where, params);
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
/*      */   public <T> T addTreeNodes(String rootParentId, String table, String idField, String parentIdField, String idLevelsField, ITreeAddAction<T> iAction) {
/*  227 */     iAction.onAddBefore();
/*      */     
/*  229 */     T id = iAction.action();
/*      */     
/*  231 */     iAction.onAddAfter(id);
/*      */     
/*  233 */     if (iAction.isNeedSyncLevel())
/*      */     {
/*  235 */       if (id != null && StringUtils.isNotBlank(id.toString())) {
/*      */         
/*  237 */         iAction.onSyncLevelBefore(id);
/*  238 */         Objects.requireNonNull(iAction); syncTreeNodeLevels(rootParentId, id, table, idField, parentIdField, idLevelsField, iAction::addSyncLevelWhereSql, iAction.getSyncLevelFieldInfo());
/*      */         
/*  240 */         iAction.onSyncLevelAfter(id);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  245 */     iAction.onActionFinish(id);
/*  246 */     return id;
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
/*      */   public <T> T modifyTreeNodes(Object id, String rootParentId, String table, String idField, String parentIdField, String idLevelsField, ITreeModifyAction<T> iAction) {
/*  262 */     iAction.onModifyBefore();
/*      */     
/*  264 */     T t = iAction.action();
/*  265 */     iAction.onModifyAfter();
/*      */     
/*  267 */     if (iAction.isNeedSyncLevel()) {
/*  268 */       iAction.onSyncLevelBefore();
/*  269 */       Objects.requireNonNull(iAction); syncTreeNodeLevels(rootParentId, id, table, idField, parentIdField, idLevelsField, iAction::addSyncLevelWhereSql, iAction.getSyncLevelFieldInfo());
/*  270 */       iAction.onSyncLevelAfter();
/*      */     } 
/*  272 */     iAction.onActionFinish();
/*  273 */     return t;
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
/*      */   public <T> T delTreeNodes(String rootParentId, String table, String idField, String parentIdField, ITreeDelAction<T> iAction) {
/*  287 */     return delTreeNodes(rootParentId, table, idField, parentIdField, (String)null, iAction);
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
/*      */   public <T> T delTreeNodes(String rootParentId, String table, String idField, String parentIdField, String leafField, ITreeDelAction<T> iAction) {
/*      */     SelectWhere selectWhere;
/*  302 */     T returnData = null;
/*  303 */     boolean isNeedSyncLevel = (iAction.isNeedSyncLevel() && StringUtils.isNotBlank(leafField));
/*  304 */     String[] selectFields = iAction.getSelectFields();
/*  305 */     boolean isQuery = iAction.queryWaitingDelRecords();
/*      */     
/*  307 */     List<Map<String, Object>> delRecords = null;
/*  308 */     Set<Object> parentIdSet = null;
/*      */     
/*  310 */     iAction.onDelBefore();
/*      */ 
/*      */     
/*  313 */     if (isQuery) {
/*  314 */       Set<String> selFieldSet = new HashSet<>();
/*  315 */       selFieldSet.add(idField);
/*  316 */       selFieldSet.add(parentIdField);
/*  317 */       if (StringUtils.isNotBlank(leafField)) {
/*  318 */         selFieldSet.add(leafField);
/*      */       }
/*  320 */       if (ArrayUtils.isNotEmpty((Object[])selectFields)) {
/*  321 */         for (String field : selectFields) {
/*  322 */           selFieldSet.add(field);
/*      */         }
/*      */       }
/*  325 */       SelectWhere selectWhere1 = Sql.select().fields(selFieldSet.<String>toArray(new String[0])).from(table).where();
/*  326 */       iAction.addDelWhereSql((Where)selectWhere1);
/*  327 */       delRecords = queryForListMap((Sql)selectWhere1);
/*  328 */       if (isNeedSyncLevel && 
/*  329 */         CollectionUtils.isNotEmpty(delRecords)) {
/*  330 */         Set<Object> tmpParentSet = new HashSet();
/*  331 */         delRecords.forEach(r -> {
/*      */               Object pId = r.get(parentIdField);
/*      */               if (pId == null || StringUtils.isBlank(pId.toString()) || pId.toString().equals(rootParentId)) {
/*      */                 return;
/*      */               }
/*      */               tmpParentSet.add(pId);
/*      */             });
/*  338 */         parentIdSet = tmpParentSet;
/*      */       }
/*      */     
/*  341 */     } else if (isNeedSyncLevel) {
/*  342 */       selectWhere = Sql.select().field(String.format("distinct %s", new Object[] { parentIdField })).from(table).where();
/*  343 */       iAction.addDelWhereSql((Where)selectWhere);
/*  344 */       List<Object> parentIds = queryListByFirstColumn((Sql)selectWhere);
/*  345 */       if (CollectionUtils.isNotEmpty(parentIds)) {
/*  346 */         Set<Object> tmpParentSet = new HashSet();
/*  347 */         parentIds.forEach(pId -> {
/*      */               if (pId == null || StringUtils.isBlank(pId.toString()) || pId.toString().equals(rootParentId)) {
/*      */                 return;
/*      */               }
/*      */               tmpParentSet.add(pId);
/*      */             });
/*  353 */         parentIdSet = tmpParentSet;
/*      */       } 
/*      */     } 
/*      */     
/*  357 */     returnData = iAction.action(delRecords);
/*      */     
/*  359 */     iAction.onDelAfter(delRecords);
/*      */     
/*  361 */     if (!isNeedSyncLevel || CollectionUtils.isEmpty(parentIdSet) || StringUtils.isBlank(leafField)) {
/*  362 */       iAction.onActionFinish(delRecords, parentIdSet);
/*  363 */       return returnData;
/*      */     } 
/*      */     
/*  366 */     Select select = Sql.select().field(String.format("count(%s)", new Object[] { idField }), leafField);
/*      */     
/*  368 */     if (parentIdSet.size() == 1) {
/*  369 */       Object pId = parentIdSet.iterator().next();
/*  370 */       selectWhere = select.field("?", idField, new Object[] { pId }).from(table).where().andEq(parentIdField, pId);
/*  371 */       iAction.addSyncLevelWhereSql((Where)selectWhere);
/*      */     } else {
/*  373 */       selectWhere = ((Select)selectWhere).field(parentIdField, idField).from(table).where().andIn(parentIdField, new ArrayList(parentIdSet));
/*  374 */       iAction.addSyncLevelWhereSql((Where)selectWhere);
/*  375 */       selectWhere.groupBy(new String[] { parentIdField });
/*      */     } 
/*      */     
/*  378 */     List<Map<String, Object>> records = queryForListMap((Sql)selectWhere);
/*      */     
/*  380 */     if (CollectionUtils.isEmpty(records)) {
/*  381 */       iAction.onActionFinish(delRecords, parentIdSet);
/*  382 */       return returnData;
/*      */     } 
/*      */     
/*  385 */     iAction.onSyncLevelBefore(delRecords, parentIdSet, records);
/*      */     
/*  387 */     Where where = Sql.update(table).set(leafField).where().andEq(idField, "");
/*  388 */     List<Object[]> params = new ArrayList();
/*  389 */     records.forEach(r -> {
/*      */           List<Object> param = new ArrayList();
/*      */           
/*      */           param.add(Boolean.valueOf((((Number)r.get(leafField)).intValue() == 0)));
/*      */           param.add(r.get(idField));
/*      */           params.add(param.toArray());
/*      */         });
/*  396 */     batchUpdate((Sql)where, params);
/*  397 */     iAction.onSyncLevelAfter(delRecords, parentIdSet, records);
/*  398 */     iAction.onActionFinish(delRecords, parentIdSet);
/*  399 */     return returnData;
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
/*      */   public <T> T moveTreeNodes(Object parentId, String rootParentId, String table, String idField, String parentIdField, String idLevelsField, ITreeMoveAction<T> iAction) {
/*  415 */     return moveTreeNodes(parentId, rootParentId, table, idField, parentIdField, idLevelsField, (String)null, iAction);
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
/*      */   public <T> T moveTreeNodes(final Object parentId, final String rootParentId, final String table, final String idField, final String parentIdField, final String idLevelsField, final String leafField, final ITreeMoveAction<T> iAction) {
/*  433 */     return delTreeNodes(rootParentId, table, idField, parentIdField, leafField, new ITreeDelAction<T>()
/*      */         {
/*      */           public void addDelWhereSql(Where sql)
/*      */           {
/*  437 */             iAction.addMoveWhereSql(sql);
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean isNeedSyncLevel() {
/*  442 */             return iAction.isNeedSyncOldParentLevel();
/*      */           }
/*      */ 
/*      */           
/*      */           public T action(List<Map<String, Object>> waitingDelRecords) {
/*  447 */             Function<List<Map<String, Object>>, T> action = iAction.getAction();
/*  448 */             T returnData = null;
/*  449 */             if (action == null) {
/*      */               
/*  451 */               Update update = Sql.update(table).set(parentIdField, parentId);
/*  452 */               iAction.addMoveUpdateSql(update);
/*  453 */               Where where = update.where();
/*  454 */               iAction.addMoveWhereSql(where);
/*  455 */               int num = TreeJdbcDaoSupport.this.update((Sql)where);
/*  456 */               Integer integer = Integer.valueOf(num);
/*      */             } else {
/*  458 */               returnData = action.apply(waitingDelRecords);
/*      */             } 
/*  460 */             return returnData;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean queryWaitingDelRecords() {
/*  465 */             boolean isRoot = (parentId == null || StringUtils.isBlank(parentId.toString()) || parentId.toString().equals(rootParentId));
/*  466 */             return (iAction.queryWaitingMoveRecords() || isRoot);
/*      */           }
/*      */ 
/*      */           
/*      */           public void addSyncLevelWhereSql(Where sql) {
/*  471 */             iAction.addSyncLevelWhereSql(sql);
/*      */           }
/*      */ 
/*      */           
/*      */           public String[] getSelectFields() {
/*  476 */             return iAction.getSelectFields();
/*      */           }
/*      */ 
/*      */           
/*      */           public void onActionFinish(List<Map<String, Object>> records, Set<Object> parentIdSet) {
/*  481 */             if (!iAction.isNeedSyncNewParentLevel()) {
/*  482 */               iAction.onActionFinish(records);
/*      */               
/*      */               return;
/*      */             } 
/*      */             
/*  487 */             TreeJdbcDaoSupport.SyncLevelField tslf = iAction.getSyncLevelFieldInfo();
/*  488 */             if (tslf == null) {
/*      */               
/*  490 */               tslf = (new TreeJdbcDaoSupport.SyncLevelField()).setLeafField(leafField);
/*      */             }
/*  492 */             else if (StringUtils.isNotBlank(leafField)) {
/*  493 */               tslf.setLeafField(leafField);
/*      */             } 
/*      */             
/*  496 */             TreeJdbcDaoSupport.SyncLevelField tslf2 = tslf;
/*  497 */             if (parentId == null || StringUtils.isBlank(parentId.toString()) || parentId.toString().equals(rootParentId)) {
/*  498 */               if (CollectionUtils.isNotEmpty(records)) {
/*  499 */                 iAction.onSyncNewParentLevelBefore(records);
/*  500 */                 records.forEach(r -> {
/*      */                       Object id = r.get(idField); Objects.requireNonNull(iAction);
/*      */                       TreeJdbcDaoSupport.this.syncTreeNodeLevels(rootParentId, id, table, idField, parentIdField, idLevelsField, iAction::addSyncLevelWhereSql, tslf2);
/*      */                     });
/*      */               } 
/*      */             } else {
/*  506 */               iAction.onSyncNewParentLevelBefore(records);
/*  507 */               Objects.requireNonNull(iAction); TreeJdbcDaoSupport.this.syncTreeNodeLevels(rootParentId, parentId, table, idField, parentIdField, idLevelsField, iAction::addSyncLevelWhereSql, tslf2);
/*      */             } 
/*      */             
/*  510 */             iAction.onSyncNewParentLevelAfter(records);
/*      */ 
/*      */             
/*  513 */             iAction.onActionFinish(records);
/*      */           }
/*      */ 
/*      */           
/*      */           public void onDelBefore() {
/*  518 */             iAction.onMoveBefore();
/*      */           }
/*      */ 
/*      */           
/*      */           public void onDelAfter(List<Map<String, Object>> moveRecords) {
/*  523 */             iAction.onMoveAfter(moveRecords);
/*      */           }
/*      */ 
/*      */           
/*      */           public void onSyncLevelBefore(List<Map<String, Object>> moveRecords, Set<Object> parentIdSet, List<Map<String, Object>> syncRecords) {
/*  528 */             iAction.onSyncOldParentLevelBefore(moveRecords, parentIdSet, syncRecords);
/*      */           }
/*      */ 
/*      */           
/*      */           public void onSyncLevelAfter(List<Map<String, Object>> moveRecords, Set<Object> parentIdSet, List<Map<String, Object>> syncRecords) {
/*  533 */             iAction.onSyncOldParentLevelAfter(moveRecords, parentIdSet, syncRecords);
/*      */           }
/*      */         });
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
/*      */   public int[] syncTreeNodeDirectChildrenInfo(List<?> ids, String table, String idField, String parentIdField, Map<String, String> aggregateFieldMap) {
/*  551 */     return syncTreeNodeDirectChildrenInfo(ids, false, table, idField, parentIdField, aggregateFieldMap, (Consumer<Where>)null);
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
/*      */   public int[] syncTreeNodeDirectChildrenInfo(List<?> ids, String table, String idField, String parentIdField, Map<String, String> aggregateFieldMap, Consumer<Where> filterSql) {
/*  566 */     return syncTreeNodeDirectChildrenInfo(ids, false, table, idField, parentIdField, aggregateFieldMap, filterSql);
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
/*      */   public int[] syncTreeNodeDirectChildrenInfo(List<?> ids, boolean idIsChildren, String table, String idField, String parentIdField, Map<String, String> aggregateFieldMap) {
/*  581 */     return syncTreeNodeDirectChildrenInfo(ids, idIsChildren, table, idField, parentIdField, aggregateFieldMap, (Consumer<Where>)null);
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
/*      */   public int[] syncTreeNodeDirectChildrenInfo(List<?> ids, boolean idIsChildren, String table, String idField, String parentIdField, Map<String, String> aggregateFieldMap, Consumer<Where> filterSql) {
/*      */     SelectWhere selectWhere;
/*  598 */     Select select1 = Sql.select().field(parentIdField);
/*  599 */     Select select2 = select1;
/*  600 */     List<String> upFields = new ArrayList<>();
/*  601 */     aggregateFieldMap.forEach((k, v) -> {
/*      */           ((Select)tmpSql).field(k, v);
/*      */           
/*      */           upFields.add(v);
/*      */         });
/*  606 */     if (idIsChildren) {
/*      */       
/*  608 */       selectWhere = select1.from(table).where().andIn(parentIdField, 
/*  609 */           (Sql)Sql.select()
/*  610 */           .field(String.format("distinct %s", new Object[] { parentIdField
/*  611 */               })).from(table)
/*  612 */           .where()
/*  613 */           .andIn(idField, ids));
/*      */     }
/*      */     else {
/*      */       
/*  617 */       selectWhere = ((Select)selectWhere).from(table).where().andIn(parentIdField, ids);
/*      */     } 
/*      */     
/*  620 */     if (filterSql != null) {
/*  621 */       filterSql.accept((Where)selectWhere);
/*      */     }
/*      */     
/*  624 */     Group group = selectWhere.groupBy(new String[] { parentIdField });
/*      */     
/*  626 */     List<Map<String, Object>> list = queryForListMap((Sql)group);
/*  627 */     if (CollectionUtils.isEmpty(list)) {
/*  628 */       return new int[] { 0 };
/*      */     }
/*      */     
/*  631 */     Where where = Sql.update(table).set(upFields.<String>toArray(new String[0])).where().andEq(idField, "");
/*  632 */     List<Object[]> params = new ArrayList();
/*  633 */     list.forEach(m -> {
/*      */           List<Object> param = new ArrayList();
/*      */           
/*      */           upFields.forEach(());
/*      */           
/*      */           param.add(m.get(parentIdField));
/*      */           params.add(param.toArray());
/*      */         });
/*  641 */     return batchUpdate((Sql)where, params);
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
/*      */   public int syncTreeNodeDirectChildrenInfoFromCurToUp(Object id, String rootParentId, String table, String idField, String parentIdField, ITreeSyncToUpAction iAction) {
/*  656 */     int rows = 0;
/*  657 */     if (iAction.incSelf()) {
/*  658 */       Objects.requireNonNull(iAction); rows += syncTreeNodeDirectChildrenInfo(Arrays.asList((T[])new Object[] { id }, ), false, table, idField, parentIdField, iAction.getSyncAggregateFieldMap(), iAction::addSyncWhereSql)[0];
/*      */     } 
/*      */     
/*  661 */     if (iAction.toRoot()) {
/*  662 */       SelectWhere selectWhere = Sql.select().field(parentIdField).from(table).where().andEq(idField, id);
/*      */       
/*  664 */       Object parentId = id; Map<String, Object> parent;
/*  665 */       while ((parent = queryForMap(selectWhere.toString(), new Object[] { parentId })) != null) {
/*  666 */         parentId = parent.get(parentIdField);
/*  667 */         if (parentId == null || parentId.toString().equals(rootParentId)) {
/*      */           break;
/*      */         }
/*  670 */         Objects.requireNonNull(iAction); rows += syncTreeNodeDirectChildrenInfo(Arrays.asList((T[])new Object[] { parentId }, ), false, table, idField, parentIdField, iAction.getSyncAggregateFieldMap(), iAction::addSyncWhereSql)[0];
/*      */       } 
/*  672 */     } else if (iAction.toParent()) {
/*  673 */       Objects.requireNonNull(iAction); rows += syncTreeNodeDirectChildrenInfo(Arrays.asList((T[])new Object[] { id }, ), true, table, idField, parentIdField, iAction.getSyncAggregateFieldMap(), iAction::addSyncWhereSql)[0];
/*      */     } 
/*  675 */     return rows;
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
/*      */   public int syncTreeTableInfoFromDownToUp(String rootParentId, String table, String idField, String parentIdField, String idLevelsField, String numLevelField, String leafField, ITreeSyncDownToUpAction iAction) {
/*  692 */     return syncTreeNodeInfoFromDownToUp((Object)null, rootParentId, table, idField, parentIdField, idLevelsField, numLevelField, leafField, iAction);
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
/*      */   public int syncTreeNodeInfoFromDownToUp(Object id, String rootParentId, String table, String idField, String parentIdField, String idLevelsField, String numLevelField, String leafField, ITreeSyncDownToUpAction iAction) {
/*  711 */     boolean toParent = iAction.toParent();
/*  712 */     boolean toRoot = iAction.toRoot();
/*  713 */     boolean incSelf = iAction.incSelf();
/*  714 */     boolean incAllChildren = iAction.incAllChildren();
/*      */     
/*  716 */     if (id != null && !toParent && !toRoot && !incSelf && !incAllChildren) {
/*  717 */       return 0;
/*      */     }
/*      */     
/*  720 */     if (StringUtils.isBlank(rootParentId)) {
/*  721 */       rootParentId = "";
/*      */     }
/*      */     
/*  724 */     Set<String> selFieldSet = new HashSet<>();
/*  725 */     selFieldSet.add(idField);
/*  726 */     selFieldSet.add(parentIdField);
/*  727 */     selFieldSet.add(numLevelField);
/*  728 */     selFieldSet.add(leafField);
/*      */     
/*  730 */     if (ArrayUtils.isNotEmpty((Object[])iAction.getSelectFields())) {
/*  731 */       for (String field : iAction.getSelectFields()) {
/*  732 */         selFieldSet.add(field);
/*      */       }
/*      */     }
/*      */     
/*  736 */     Map<Object, Map<String, Object>> updateMap = new HashMap<>();
/*      */     
/*  738 */     String[] selFields = selFieldSet.<String>toArray(new String[0]);
/*  739 */     if (id == null || StringUtils.isBlank(id.toString())) {
/*      */       
/*  741 */       SelectWhere selectWhere = Sql.select().fields(selFields).from(table).where();
/*  742 */       iAction.addSyncWhereSql((Where)selectWhere);
/*  743 */       List<Map<String, Object>> list = queryForListMap((Sql)selectWhere);
/*  744 */       if (CollectionUtils.isEmpty(list)) {
/*  745 */         return 0;
/*      */       }
/*  747 */       Map<String, Map<String, Object>> objMap = new HashMap<>();
/*  748 */       List<Map<String, Object>> hasChildrenList = new ArrayList<>();
/*  749 */       List<Map<String, Object>> rootLeafList = new ArrayList<>();
/*  750 */       for (Map<String, Object> r : list) {
/*  751 */         String rId = r.get(idField).toString();
/*  752 */         Object pId = r.get(parentIdField);
/*  753 */         objMap.put(rId, r);
/*      */         
/*  755 */         int leaf = ((Number)r.get(leafField)).intValue();
/*  756 */         if (leaf == 0) {
/*  757 */           r.put("__children", new ArrayList());
/*  758 */           hasChildrenList.add(r); continue;
/*  759 */         }  if (pId == null || pId.toString().equals(rootParentId)) {
/*  760 */           rootLeafList.add(r);
/*      */         }
/*      */       } 
/*  763 */       if (!hasChildrenList.isEmpty()) {
/*  764 */         for (Map<String, Object> r : list) {
/*  765 */           String pId = Optional.<T>of((T)r.get(parentIdField)).orElse((T)"").toString();
/*  766 */           Map<String, Object> pr = objMap.get(pId);
/*  767 */           if (pr != null) {
/*  768 */             ((List<Map<String, Object>>)pr.get("__children")).add(r);
/*      */           }
/*      */         } 
/*      */         
/*  772 */         Collections.sort(hasChildrenList, (o1, o2) -> {
/*      */               int levelNum1 = ((Number)Optional.<Number>ofNullable((Number)o1.get(numLevelField)).orElse(Integer.valueOf(0))).intValue();
/*      */               
/*      */               int levelNum2 = ((Number)Optional.<Number>ofNullable((Number)o2.get(numLevelField)).orElse(Integer.valueOf(0))).intValue();
/*      */               return levelNum2 - levelNum1;
/*      */             });
/*  778 */         for (Map<String, Object> pr : hasChildrenList) {
/*  779 */           Object prId = pr.get(idField);
/*  780 */           List<Map<String, Object>> children = (List<Map<String, Object>>)pr.get("__children");
/*  781 */           ITreeSyncDownToUpAction.UpdateInfo update = iAction.aggregateAction(pr, children);
/*  782 */           if (update != null) {
/*  783 */             if (update.getParent() != null) {
/*  784 */               pr.putAll(update.getParent());
/*  785 */               updateMap.put(prId, update.getParent());
/*      */             } 
/*  787 */             if (MapUtils.isNotEmpty(update.getChildren())) {
/*  788 */               updateMap.putAll(update.getChildren());
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  794 */       if (!rootLeafList.isEmpty()) {
/*  795 */         ITreeSyncDownToUpAction.UpdateInfo update = iAction.aggregateAction(null, rootLeafList);
/*  796 */         if (update != null && 
/*  797 */           MapUtils.isNotEmpty(update.getChildren())) {
/*  798 */           updateMap.putAll(update.getChildren());
/*      */         }
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  804 */       SelectWhere selectWhere = Sql.select().fields(selFields).from(table).where().andEq(idField, id);
/*  805 */       iAction.addSyncWhereSql((Where)selectWhere);
/*  806 */       Map<String, Object> treeNode = queryForMap((Sql)selectWhere);
/*  807 */       if (treeNode == null) {
/*  808 */         return 0;
/*      */       }
/*      */       
/*  811 */       if (incAllChildren) {
/*  812 */         selectWhere = Sql.select().fields(selFields).from(table).where().andBLike(idLevelsField, String.format(",%s,", new Object[] { id }));
/*  813 */         iAction.addSyncWhereSql((Where)selectWhere);
/*  814 */         List<Map<String, Object>> list = queryForListMap((Sql)selectWhere);
/*  815 */         if (CollectionUtils.isEmpty(list)) {
/*  816 */           ITreeSyncDownToUpAction.UpdateInfo update = iAction.aggregateAction(treeNode, null);
/*  817 */           if (update != null && 
/*  818 */             update.getParent() != null) {
/*  819 */             treeNode.putAll(update.getParent());
/*  820 */             updateMap.put(id, update.getParent());
/*      */           } 
/*      */         } else {
/*      */           
/*  824 */           Map<String, Map<String, Object>> objMap = new HashMap<>();
/*  825 */           List<Map<String, Object>> hasChildrenList = new ArrayList<>();
/*  826 */           for (Map<String, Object> r : list) {
/*  827 */             String rId = r.get(idField).toString();
/*  828 */             objMap.put(rId, r);
/*      */             
/*  830 */             int leaf = ((Number)r.get(leafField)).intValue();
/*  831 */             if (leaf == 0) {
/*  832 */               r.put("__children", new ArrayList());
/*  833 */               hasChildrenList.add(r);
/*      */             } 
/*      */           } 
/*  836 */           if (!hasChildrenList.isEmpty()) {
/*  837 */             for (Map<String, Object> r : list) {
/*  838 */               String pId = Optional.<T>of((T)r.get(parentIdField)).orElse((T)"").toString();
/*  839 */               Map<String, Object> pr = objMap.get(pId);
/*  840 */               if (pr != null) {
/*  841 */                 ((List<Map<String, Object>>)pr.get("__children")).add(r);
/*      */               }
/*      */             } 
/*      */             
/*  845 */             Collections.sort(hasChildrenList, (o1, o2) -> {
/*      */                   int levelNum1 = ((Number)Optional.<Number>ofNullable((Number)o1.get(numLevelField)).orElse(Integer.valueOf(0))).intValue();
/*      */                   
/*      */                   int levelNum2 = ((Number)Optional.<Number>ofNullable((Number)o2.get(numLevelField)).orElse(Integer.valueOf(0))).intValue();
/*      */                   return levelNum2 - levelNum1;
/*      */                 });
/*  851 */             for (Map<String, Object> pr : hasChildrenList) {
/*  852 */               Object prId = pr.get(idField);
/*  853 */               List<Map<String, Object>> children = (List<Map<String, Object>>)pr.get("__children");
/*  854 */               ITreeSyncDownToUpAction.UpdateInfo updateInfo = iAction.aggregateAction(pr, children);
/*  855 */               if (updateInfo != null) {
/*  856 */                 if (updateInfo.getParent() != null) {
/*  857 */                   pr.putAll(updateInfo.getParent());
/*  858 */                   updateMap.put(prId, updateInfo.getParent());
/*      */                 } 
/*  860 */                 if (MapUtils.isNotEmpty(updateInfo.getChildren())) {
/*  861 */                   updateMap.putAll(updateInfo.getChildren());
/*      */                 }
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/*  867 */           ITreeSyncDownToUpAction.UpdateInfo update = iAction.aggregateAction(treeNode, list);
/*  868 */           if (update != null) {
/*  869 */             if (update.getParent() != null) {
/*  870 */               treeNode.putAll(update.getParent());
/*  871 */               updateMap.put(id, update.getParent());
/*      */             } 
/*  873 */             if (MapUtils.isNotEmpty(update.getChildren())) {
/*  874 */               updateMap.putAll(update.getChildren());
/*      */             }
/*      */           } 
/*      */         } 
/*  878 */       } else if (incSelf) {
/*  879 */         selectWhere = Sql.select().fields(selFields).from(table).where().andEq(parentIdField, id);
/*  880 */         iAction.addSyncWhereSql((Where)selectWhere);
/*  881 */         List<Map<String, Object>> list = queryForListMap((Sql)selectWhere);
/*  882 */         ITreeSyncDownToUpAction.UpdateInfo update = iAction.aggregateAction(treeNode, list);
/*  883 */         if (update != null) {
/*  884 */           if (update.getParent() != null) {
/*  885 */             treeNode.putAll(update.getParent());
/*  886 */             updateMap.put(id, update.getParent());
/*      */           } 
/*  888 */           if (MapUtils.isNotEmpty(update.getChildren())) {
/*  889 */             updateMap.putAll(update.getChildren());
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  894 */       Object parentId = treeNode.get(parentIdField);
/*  895 */       if ((toRoot || toParent) && parentId != null && !parentId.toString().equals(rootParentId)) {
/*  896 */         if (toRoot)
/*      */         {
/*  898 */           parentId = findRootParentIdByParentId(rootParentId, parentId, table, idField, parentIdField);
/*      */         }
/*  900 */         int levelNum = ((Number)treeNode.get(numLevelField)).intValue();
/*  901 */         selectWhere = Sql.select().fields(selFields).from(table).where().and(
/*  902 */             (Sql)CriteriaGroup.or(new Sql[] {
/*  903 */                 (Sql)CriteriaGroup.and(new Sql[] {
/*  904 */                     (Sql)Criteria.bLike(idLevelsField, String.format(",%s,", new Object[] { parentId
/*  905 */                         })), (Sql)Criteria.ltEq(numLevelField, Integer.valueOf(levelNum))
/*      */                   
/*  907 */                   }), (Sql)Criteria.eq(idField, parentId)
/*      */               }));
/*      */         
/*  910 */         iAction.addSyncWhereSql((Where)selectWhere);
/*      */         
/*  912 */         List<Map<String, Object>> list = queryForListMap((Sql)selectWhere);
/*  913 */         if (CollectionUtils.isNotEmpty(list)) {
/*  914 */           Map<String, Map<String, Object>> objMap = new HashMap<>();
/*  915 */           List<Map<String, Object>> hasChildrenList = new ArrayList<>();
/*  916 */           for (Map<String, Object> r : list) {
/*  917 */             String rId = r.get(idField).toString();
/*  918 */             objMap.put(rId, r);
/*      */             
/*  920 */             if (rId.equals(id.toString())) {
/*  921 */               r.putAll(treeNode);
/*      */             }
/*      */             
/*  924 */             int leaf = ((Number)r.get(leafField)).intValue();
/*  925 */             if (leaf == 0) {
/*  926 */               r.put("__children", new ArrayList());
/*  927 */               hasChildrenList.add(r);
/*      */             } 
/*      */           } 
/*  930 */           if (!hasChildrenList.isEmpty()) {
/*  931 */             for (Map<String, Object> r : list) {
/*  932 */               String pId = Optional.<T>of((T)r.get(parentIdField)).orElse((T)"").toString();
/*  933 */               Map<String, Object> pr = objMap.get(pId);
/*  934 */               if (pr != null) {
/*  935 */                 ((List<Map<String, Object>>)pr.get("__children")).add(r);
/*      */               }
/*      */             } 
/*  938 */             Collections.sort(hasChildrenList, (o1, o2) -> {
/*      */                   int levelNum1 = ((Number)Optional.<Number>ofNullable((Number)o1.get(numLevelField)).orElse(Integer.valueOf(0))).intValue();
/*      */                   
/*      */                   int levelNum2 = ((Number)Optional.<Number>ofNullable((Number)o2.get(numLevelField)).orElse(Integer.valueOf(0))).intValue();
/*      */                   return levelNum2 - levelNum1;
/*      */                 });
/*  944 */             for (Map<String, Object> pr : hasChildrenList) {
/*  945 */               Object prId = pr.get(idField);
/*  946 */               List<Map<String, Object>> children = (List<Map<String, Object>>)pr.get("__children");
/*  947 */               ITreeSyncDownToUpAction.UpdateInfo update = iAction.aggregateAction(pr, children);
/*  948 */               if (update != null) {
/*  949 */                 if (update.getParent() != null) {
/*  950 */                   pr.putAll(update.getParent());
/*  951 */                   updateMap.put(prId, update.getParent());
/*      */                 } 
/*  953 */                 if (MapUtils.isNotEmpty(update.getChildren())) {
/*  954 */                   updateMap.putAll(update.getChildren());
/*      */                 }
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  963 */     if (updateMap.isEmpty()) {
/*  964 */       return 0;
/*      */     }
/*      */     
/*  967 */     Map<String, Sql> sqlMap = new HashMap<>();
/*  968 */     Map<String, List<Object[]>> paramsMap = new HashMap<>();
/*  969 */     for (Object key : updateMap.keySet()) {
/*  970 */       Map<String, Object> r = updateMap.get(key);
/*  971 */       Set<String> fieldSet = r.keySet();
/*  972 */       String sqlKey = StringUtils.join(fieldSet, ",");
/*  973 */       List<Object[]> params = paramsMap.get(sqlKey);
/*  974 */       if (params == null) {
/*  975 */         params = new ArrayList();
/*  976 */         paramsMap.put(sqlKey, params);
/*  977 */         Where where = Sql.update(table).set(fieldSet.<String>toArray(new String[0])).where().andEq(idField, "");
/*  978 */         sqlMap.put(sqlKey, where);
/*      */       } 
/*      */       
/*  981 */       List<Object> param = new ArrayList();
/*  982 */       for (String field : fieldSet) {
/*  983 */         param.add(r.get(field));
/*      */       }
/*  985 */       param.add(key);
/*  986 */       params.add(param.toArray());
/*      */     } 
/*      */     
/*  989 */     sqlMap.forEach((k, sql) -> batchUpdate(sql, (List<Object[]>)paramsMap.get(k)));
/*      */ 
/*      */ 
/*      */     
/*  993 */     return updateMap.size();
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
/*      */   public int[] syncTreeTableLevels(String rootParentId, String table, String idField, String parentIdField, String idLevelsField) {
/* 1007 */     return syncTreeLevels(rootParentId, (Object)null, false, table, idField, parentIdField, idLevelsField, (Consumer<Where>)null, (SyncLevelField)null);
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
/*      */   public int[] syncTreeTableLevels(String rootParentId, String table, String idField, String parentIdField, String idLevelsField, Consumer<Where> filterSql) {
/* 1022 */     return syncTreeLevels(rootParentId, (Object)null, false, table, idField, parentIdField, idLevelsField, filterSql, (SyncLevelField)null);
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
/*      */   public int[] syncTreeTableLevels(String rootParentId, String table, String idField, String parentIdField, String idLevelsField, SyncLevelField syncField) {
/* 1037 */     return syncTreeLevels(rootParentId, (Object)null, false, table, idField, parentIdField, idLevelsField, (Consumer<Where>)null, syncField);
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
/*      */   public int[] syncTreeTableLevels(String rootParentId, String table, String idField, String parentIdField, String idLevelsField, Consumer<Where> filterSql, SyncLevelField syncField) {
/* 1053 */     return syncTreeLevels(rootParentId, (Object)null, false, table, idField, parentIdField, idLevelsField, filterSql, syncField);
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
/*      */   public int[] syncTreeNodeLevels(String rootParentId, Object levelId, String table, String idField, String parentIdField, String idLevelsField) {
/* 1068 */     return syncTreeLevels(rootParentId, levelId, false, table, idField, parentIdField, idLevelsField, (Consumer<Where>)null, (SyncLevelField)null);
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
/*      */   public int[] syncTreeNodeLevels(String rootParentId, Object levelId, String table, String idField, String parentIdField, String idLevelsField, SyncLevelField syncField) {
/* 1084 */     return syncTreeLevels(rootParentId, levelId, false, table, idField, parentIdField, idLevelsField, (Consumer<Where>)null, syncField);
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
/*      */   public int[] syncTreeNodeLevels(String rootParentId, Object levelId, String table, String idField, String parentIdField, String idLevelsField, Consumer<Where> filterSql) {
/* 1100 */     return syncTreeLevels(rootParentId, levelId, false, table, idField, parentIdField, idLevelsField, filterSql, (SyncLevelField)null);
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
/*      */   public int[] syncTreeNodeLevels(String rootParentId, Object levelId, String table, String idField, String parentIdField, String idLevelsField, Consumer<Where> filterSql, SyncLevelField syncField) {
/* 1117 */     return syncTreeLevels(rootParentId, levelId, false, table, idField, parentIdField, idLevelsField, filterSql, syncField);
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
/*      */   public int[] syncTreeNodeLevels(String rootParentId, Object levelId, boolean fromRoot, String table, String idField, String parentIdField, String idLevelsField, Consumer<Where> filterSql, SyncLevelField syncField) {
/* 1135 */     return syncTreeLevels(rootParentId, levelId, fromRoot, table, idField, parentIdField, idLevelsField, filterSql, syncField);
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
/*      */   private int[] syncTreeLevels(String rootParentId, Object levelId, boolean incUp, String table, final String idField, final String parentIdField, String idLevelsField, Consumer<Where> filterSql, SyncLevelField syncField) {
/* 1153 */     String _rootParentId = rootParentId;
/* 1154 */     if (StringUtils.isBlank(table) || 
/* 1155 */       StringUtils.isBlank(idField) || 
/* 1156 */       StringUtils.isBlank(parentIdField) || 
/* 1157 */       StringUtils.isBlank(idLevelsField)) {
/* 1158 */       throw new RuntimeException("table or idField or parentIdField or idLevelsField is blank ");
/*      */     }
/*      */     
/* 1161 */     String separator = ",";
/* 1162 */     String levelNumField = null;
/* 1163 */     String levelIdTagField = null;
/* 1164 */     String leafField = null;
/* 1165 */     Map<String, String> otherLevelsMap = null;
/* 1166 */     if (syncField != null) {
/* 1167 */       levelNumField = syncField.getLevelNumField();
/* 1168 */       levelIdTagField = syncField.getLevelIdTagField();
/* 1169 */       leafField = syncField.getLeafField();
/* 1170 */       otherLevelsMap = syncField.getOtherLevelFieldsMap();
/*      */     } 
/*      */ 
/*      */     
/* 1174 */     Set<String> selField = new HashSet<>();
/* 1175 */     selField.add(parentIdField);
/*      */ 
/*      */     
/* 1178 */     Map<String, String> mapFields = new HashMap<>();
/* 1179 */     mapFields.put(idField, idLevelsField);
/* 1180 */     if (otherLevelsMap != null) {
/* 1181 */       otherLevelsMap.forEach((k, v) -> {
/*      */             if (StringUtils.isNotBlank(k) && StringUtils.isNotBlank(v)) {
/*      */               mapFields.put(k, v);
/*      */             }
/*      */           });
/*      */     }
/*      */     
/* 1188 */     List<String> updateFields = new ArrayList<>();
/* 1189 */     mapFields.forEach((k, v) -> {
/*      */           selField.add(k);
/*      */           selField.add(v);
/*      */           updateFields.add(v);
/*      */         });
/* 1194 */     if (StringUtils.isNotBlank(levelNumField)) {
/* 1195 */       updateFields.add(levelNumField);
/*      */     }
/* 1197 */     if (StringUtils.isNotBlank(levelIdTagField)) {
/* 1198 */       updateFields.add(levelIdTagField);
/*      */     }
/* 1200 */     if (StringUtils.isNotBlank(leafField)) {
/* 1201 */       updateFields.add(leafField);
/*      */     }
/*      */ 
/*      */     
/* 1205 */     String[] fields = selField.<String>toArray(new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1210 */     SelectWhere selectWhere = Sql.select().fields(fields).from(table).where().andEqIfNotNull(idField, levelId);
/* 1211 */     if (filterSql != null) {
/* 1212 */       filterSql.accept((Where)selectWhere);
/*      */     }
/*      */     
/* 1215 */     List<Map<String, Object>> list = queryForListMap((Sql)selectWhere);
/*      */     
/* 1217 */     if (CollectionUtils.isEmpty(list)) {
/* 1218 */       return new int[] { 0 };
/*      */     }
/*      */     
/* 1221 */     Map<String, Object> parentData = null;
/* 1222 */     if (levelId != null) {
/*      */       
/* 1224 */       if (list.size() > 1) {
/* 1225 */         throw new RuntimeException(String.format("select %s by levelId[%s] must return only one row", new Object[] { table, levelId }));
/*      */       }
/* 1227 */       Map<String, Object> levelData = list.get(0);
/* 1228 */       Object parentId = levelData.get(parentIdField);
/*      */ 
/*      */       
/* 1231 */       rootParentId = levelId.toString();
/*      */       
/* 1233 */       if (parentId != null && !StringUtils.isBlank(parentId.toString()) && !parentId.toString().equals(_rootParentId))
/*      */       {
/* 1235 */         if (incUp) {
/*      */           
/* 1237 */           Object parentRootId = syncTreeLevelsAddAllParent(_rootParentId, list, (Object)null, parentId, table, fields, idField, parentIdField, filterSql);
/* 1238 */           if (parentRootId != null) {
/* 1239 */             rootParentId = parentRootId.toString();
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */         else {
/*      */           
/* 1246 */           selectWhere = Sql.select().fields(fields).from(table).where().andEq(idField, parentId);
/* 1247 */           if (filterSql != null) {
/* 1248 */             filterSql.accept((Where)selectWhere);
/*      */           }
/* 1250 */           List<Map<String, Object>> parentList = queryForListMap((Sql)selectWhere);
/* 1251 */           if (CollectionUtils.isNotEmpty(parentList)) {
/* 1252 */             if (parentList.size() > 1) {
/* 1253 */               throw new RuntimeException(String.format("select %s by levelId[%s] must return only one row", new Object[] { table, parentId }));
/*      */             }
/* 1255 */             parentData = new HashMap<>();
/* 1256 */             parentData.putAll(parentList.get(0));
/* 1257 */             for (String v : mapFields.values()) {
/* 1258 */               List<String> levelsValue = Arrays.asList(StringUtils.split(Optional.<T>ofNullable((T)parentData.get(v)).orElse((T)"").toString(), separator));
/* 1259 */               parentData.put(v, levelsValue);
/*      */             } 
/*      */             
/* 1262 */             if (StringUtils.isNotBlank(leafField)) {
/* 1263 */               int leaf = ((Number)Optional.<Number>ofNullable((Number)parentData.get(leafField)).orElse(Integer.valueOf(1))).intValue();
/* 1264 */               if (leaf == 1)
/*      */               {
/* 1266 */                 update((Sql)Sql.update(table).set(leafField, Integer.valueOf(0)).where().andEq(idField, parentId));
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1275 */       syncTreeLevelsAddAllChildren(list, levelId, table, fields, idField, parentIdField, filterSql);
/*      */     } 
/*      */     
/* 1278 */     List<Map<String, Object>> treeList = LevelTreeQuery.sortDownToTree(rootParentId, list, new LevelTreeQuery.SortAction<Map<String, Object>>()
/*      */         {
/*      */           public String getId(Map<String, Object> data) {
/* 1281 */             return data.get(idField).toString();
/*      */           }
/*      */ 
/*      */           
/*      */           public String getParentId(Map<String, Object> data) {
/* 1286 */             return Optional.<T>ofNullable((T)data.get(parentIdField)).orElse((T)"").toString();
/*      */           }
/*      */ 
/*      */           
/*      */           public void initChildList(Map<String, Object> data) {
/* 1291 */             data.put("__child", new ArrayList());
/*      */           }
/*      */ 
/*      */           
/*      */           public void addChild(Map<String, Object> parent, Map<String, Object> data) {
/* 1296 */             List<Map<String, Object>> childList = (List<Map<String, Object>>)parent.get("__child");
/* 1297 */             childList.add(data);
/*      */           }
/*      */ 
/*      */           
/*      */           public void setChildList(Map<String, Object> data, List<Map<String, Object>> list) {
/* 1302 */             data.put("__child", list);
/*      */           }
/*      */ 
/*      */           
/*      */           public void removeChild(Map<String, Object> data) {
/* 1307 */             data.remove("__child");
/*      */           }
/*      */ 
/*      */           
/*      */           public List<Map<String, Object>> getChildList(Map<String, Object> data) {
/* 1312 */             return (List<Map<String, Object>>)data.get("__child");
/*      */           }
/*      */         });
/*      */     
/* 1316 */     if (CollectionUtils.isEmpty(treeList)) {
/* 1317 */       return new int[] { 0 };
/*      */     }
/*      */     
/* 1320 */     List<Object[]> params = new ArrayList();
/*      */     
/* 1322 */     syncTreeLevelsInitUpdateParams(params, idField, idLevelsField, syncField, mapFields, parentData, treeList, separator);
/*      */     
/* 1324 */     Where where = Sql.update(table).set(updateFields).where().andEqs(new String[] { idField });
/*      */     
/* 1326 */     return batchUpdate((Sql)where, params);
/*      */   }
/*      */ 
/*      */   
/*      */   private void syncTreeLevelsInitUpdateParams(List<Object[]> params, String idField, String idLevelsField, SyncLevelField syncField, Map<String, String> mapFields, Map<String, Object> parentData, List<Map<String, Object>> list, String separator) {
/* 1331 */     if (CollectionUtils.isEmpty(list)) {
/*      */       return;
/*      */     }
/*      */     
/* 1335 */     String levelNumField = null;
/* 1336 */     String levelIdTagField = null;
/* 1337 */     String leafField = null;
/* 1338 */     if (syncField != null) {
/* 1339 */       levelNumField = syncField.getLevelNumField();
/* 1340 */       levelIdTagField = syncField.getLevelIdTagField();
/* 1341 */       leafField = syncField.getLeafField();
/*      */     } 
/*      */     
/* 1344 */     for (Map<String, Object> d : list) {
/* 1345 */       List<Object> param = new ArrayList();
/* 1346 */       for (String k : mapFields.keySet()) {
/* 1347 */         String v = mapFields.get(k);
/* 1348 */         List<String> list1 = new ArrayList<>();
/* 1349 */         if (parentData == null) {
/* 1350 */           param.add("");
/*      */         } else {
/* 1352 */           list1 = new ArrayList<>((List)parentData.get(v));
/* 1353 */           list1.add(Optional.<T>ofNullable((T)parentData.get(k)).orElse((T)"").toString());
/* 1354 */           param.add(String.format("%s%s%s", new Object[] { separator, StringUtils.join(list1, separator), separator }));
/*      */         } 
/* 1356 */         d.put(v, list1);
/*      */       } 
/* 1358 */       List<String> levels = (List<String>)d.get(idLevelsField);
/* 1359 */       List<Map<String, Object>> childList = (List<Map<String, Object>>)d.get("__child");
/* 1360 */       if (StringUtils.isNotBlank(levelNumField)) {
/* 1361 */         param.add(Integer.valueOf(levels.size()));
/*      */       }
/* 1363 */       if (StringUtils.isNotBlank(levelIdTagField)) {
/* 1364 */         param.add("%" + String.format("%s%s%s", new Object[] { separator, d.get(idField).toString(), separator }) + "%");
/*      */       }
/* 1366 */       if (StringUtils.isNotBlank(leafField)) {
/* 1367 */         param.add(Boolean.valueOf(CollectionUtils.isEmpty(childList)));
/*      */       }
/*      */       
/* 1370 */       param.add(d.get(idField));
/* 1371 */       params.add(param.toArray());
/* 1372 */       syncTreeLevelsInitUpdateParams(params, idField, idLevelsField, syncField, mapFields, d, childList, separator);
/*      */     } 
/*      */   }
/*      */   
/*      */   private Object syncTreeLevelsAddAllParent(String _rootParentId, List<Map<String, Object>> list, Object rootId, Object parentId, String table, String[] fields, String idField, String parentIdField, Consumer<Where> filterSql) {
/* 1377 */     if (parentId == null || parentId.toString().equals(_rootParentId)) {
/* 1378 */       return rootId;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1384 */     SelectWhere selectWhere = Sql.select().fields(fields).from(table).where().andEq(idField, parentId);
/* 1385 */     if (filterSql != null) {
/* 1386 */       filterSql.accept((Where)selectWhere);
/*      */     }
/* 1388 */     List<Map<String, Object>> parentList = queryForListMap((Sql)selectWhere);
/* 1389 */     if (CollectionUtils.isEmpty(parentList)) {
/* 1390 */       return rootId;
/*      */     }
/* 1392 */     if (parentList.size() > 1) {
/* 1393 */       throw new RuntimeException(String.format("select %s by levelId[%s] must return only one row", new Object[] { table, parentId }));
/*      */     }
/* 1395 */     Map<String, Object> data = parentList.get(0);
/* 1396 */     list.add(data);
/*      */     
/* 1398 */     Object nextParentId = data.get(parentIdField);
/* 1399 */     rootId = data.get(idField);
/* 1400 */     return syncTreeLevelsAddAllParent(_rootParentId, list, rootId, nextParentId, table, fields, idField, parentIdField, filterSql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void syncTreeLevelsAddAllChildren(List<Map<String, Object>> list, Object parentId, String table, String[] fields, String idField, String parentIdField, Consumer<Where> filterSql) {
/* 1407 */     SelectWhere selectWhere = Sql.select().fields(fields).from(table).where().andEq(parentIdField, parentId);
/* 1408 */     if (filterSql != null) {
/* 1409 */       filterSql.accept((Where)selectWhere);
/*      */     }
/* 1411 */     List<Map<String, Object>> childList = queryForListMap((Sql)selectWhere);
/* 1412 */     if (CollectionUtils.isEmpty(childList)) {
/*      */       return;
/*      */     }
/* 1415 */     childList.forEach(data -> {
/*      */           list.add(data);
/*      */           Object nextParentId = data.get(idField);
/*      */           syncTreeLevelsAddAllChildren((List)list, nextParentId, table, fields, idField, parentIdField, filterSql);
/*      */         });
/*      */   }
/*      */   
/*      */   private Object findRootParentIdByParentId(String rootId, Object parentId, String table, String idField, String parentIdField) {
/* 1423 */     if (rootId == null) {
/* 1424 */       rootId = "";
/*      */     }
/* 1426 */     if (parentId == null || parentId.toString().equals(rootId)) {
/* 1427 */       return null;
/*      */     }
/* 1429 */     SelectWhere selectWhere = Sql.select().fields(new String[] { idField, parentIdField }).from(table).where().andEq(idField, parentId);
/* 1430 */     Map<String, Object> parent = queryForMap((Sql)selectWhere);
/* 1431 */     if (parent == null) {
/* 1432 */       return null;
/*      */     }
/* 1434 */     Object nextParentId = parent.get(parentIdField);
/* 1435 */     return findRootParentId(rootId, parentId, nextParentId, table, idField, parentIdField);
/*      */   }
/*      */   
/*      */   private Object findRootParentIdById(String rootId, Object id, String table, String idField, String parentIdField) {
/* 1439 */     SelectWhere selectWhere = Sql.select().fields(new String[] { idField, parentIdField }).from(table).where().andEq(idField, 
/* 1440 */         (Sql)Sql.select().field(parentIdField).from(table).where().andEq(idField, id));
/* 1441 */     Map<String, Object> parent = queryForMap((Sql)selectWhere);
/* 1442 */     if (parent == null) {
/* 1443 */       return null;
/*      */     }
/* 1445 */     Object parentId = parent.get(idField);
/* 1446 */     Object nextParentId = parent.get(parentIdField);
/* 1447 */     return findRootParentId(rootId, parentId, nextParentId, table, idField, parentIdField);
/*      */   }
/*      */   
/*      */   private Object findRootParentId(String rootId, Object prevParentId, Object parentId, String table, String idField, String parentIdField) {
/* 1451 */     if (rootId == null) {
/* 1452 */       rootId = "";
/*      */     }
/* 1454 */     if (parentId == null || parentId.toString().equals(rootId)) {
/* 1455 */       return prevParentId;
/*      */     }
/*      */     
/* 1458 */     SelectWhere selectWhere = Sql.select().fields(new String[] { idField, parentIdField }).from(table).where().andEq(idField, parentId);
/* 1459 */     Map<String, Object> parent = queryForMap((Sql)selectWhere);
/* 1460 */     if (parent == null) {
/* 1461 */       return prevParentId;
/*      */     }
/* 1463 */     Object nextParentId = parent.get(parentIdField);
/* 1464 */     return findRootParentId(rootId, parentId, nextParentId, table, idField, parentIdField);
/*      */   }
/*      */   
/*      */   public static interface ITreeSyncToUpAction
/*      */   {
/*      */     default boolean toParent() {
/* 1470 */       return true;
/*      */     }
/*      */     
/*      */     default boolean toRoot() {
/* 1474 */       return false;
/*      */     }
/*      */     
/*      */     default boolean incSelf() {
/* 1478 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     Map<String, String> getSyncAggregateFieldMap();
/*      */ 
/*      */     
/*      */     default void addSyncWhereSql(Where sql) {}
/*      */   }
/*      */ 
/*      */   
/*      */   public static interface ITreeSyncDownToUpAction
/*      */   {
/*      */     public static class UpdateInfo
/*      */     {
/* 1494 */       private final Map<String, Object> parent = new HashMap<>();
/* 1495 */       private final Map<Object, Map<String, Object>> children = new HashMap<>();
/*      */       
/*      */       public Map<String, Object> getParent() {
/* 1498 */         return this.parent;
/*      */       }
/*      */       
/*      */       public Map<Object, Map<String, Object>> getChildren() {
/* 1502 */         return this.children;
/*      */       }
/*      */     }
/*      */     
/*      */     default boolean toParent() {
/* 1507 */       return false;
/*      */     }
/*      */     
/*      */     default boolean toRoot() {
/* 1511 */       return true;
/*      */     }
/*      */     
/*      */     default boolean incSelf() {
/* 1515 */       return false;
/*      */     }
/*      */     
/*      */     default boolean incAllChildren() {
/* 1519 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     UpdateInfo aggregateAction(Map<String, Object> param1Map, List<Map<String, Object>> param1List);
/*      */ 
/*      */     
/*      */     default void addSyncWhereSql(Where sql) {}
/*      */ 
/*      */     
/*      */     default String[] getSelectFields() {
/* 1530 */       return null;
/*      */     } } public static class UpdateInfo { private final Map<String, Object> parent; private final Map<Object, Map<String, Object>> children; public UpdateInfo() {
/*      */       this.parent = new HashMap<>();
/*      */       this.children = new HashMap<>();
/*      */     } public Map<String, Object> getParent() {
/*      */       return this.parent;
/*      */     } public Map<Object, Map<String, Object>> getChildren() {
/*      */       return this.children;
/*      */     } }
/*      */   public static interface ITreeAddAction<T> { T action();
/*      */     default boolean isNeedSyncLevel() {
/* 1541 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     default void addSyncLevelWhereSql(Where sql) {}
/*      */ 
/*      */     
/*      */     default TreeJdbcDaoSupport.SyncLevelField getSyncLevelFieldInfo() {
/* 1550 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     default void onAddBefore() {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onAddAfter(T id) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onSyncLevelBefore(T id) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onSyncLevelAfter(T id) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onActionFinish(T id) {} }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface ITreeModifyAction<T>
/*      */   {
/*      */     T action();
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isNeedSyncLevel();
/*      */ 
/*      */     
/*      */     default void addSyncLevelWhereSql(Where sql) {}
/*      */ 
/*      */     
/*      */     default TreeJdbcDaoSupport.SyncLevelField getSyncLevelFieldInfo() {
/* 1589 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     default void onModifyBefore() {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onModifyAfter() {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onSyncLevelBefore() {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onSyncLevelAfter() {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onActionFinish() {}
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface ITreeMoveAction<T>
/*      */   {
/*      */     default void addMoveWhereSql(Where sql) {}
/*      */ 
/*      */     
/*      */     default boolean queryWaitingMoveRecords() {
/* 1621 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     default String[] getSelectFields() {
/* 1626 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     default boolean isNeedSyncOldParentLevel() {
/* 1631 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     default boolean isNeedSyncNewParentLevel() {
/* 1636 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     default Function<List<Map<String, Object>>, T> getAction() {
/* 1641 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     default void addSyncLevelWhereSql(Where sql) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void addMoveUpdateSql(Update sql) {}
/*      */ 
/*      */     
/*      */     default TreeJdbcDaoSupport.SyncLevelField getSyncLevelFieldInfo() {
/* 1654 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     default void onMoveBefore() {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onMoveAfter(List<Map<String, Object>> moveRecords) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onActionFinish(List<Map<String, Object>> moveRecords) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onSyncOldParentLevelBefore(List<Map<String, Object>> moveRecords, Set<Object> parentIdSet, List<Map<String, Object>> syncRecords) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onSyncOldParentLevelAfter(List<Map<String, Object>> moveRecords, Set<Object> parentIdSet, List<Map<String, Object>> syncRecords) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onSyncNewParentLevelBefore(List<Map<String, Object>> moveRecords) {}
/*      */ 
/*      */ 
/*      */     
/*      */     default void onSyncNewParentLevelAfter(List<Map<String, Object>> moveRecords) {}
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface ITreeDelAction<T>
/*      */   {
/*      */     default void addDelWhereSql(Where sql) {}
/*      */ 
/*      */     
/*      */     default boolean queryWaitingDelRecords() {
/* 1694 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     default String[] getSelectFields() {
/* 1699 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     default boolean isNeedSyncLevel() {
/* 1704 */       return true;
/*      */     }
/*      */     
/*      */     T action(List<Map<String, Object>> param1List);
/*      */     
/*      */     default void addSyncLevelWhereSql(Where sql) {}
/*      */     
/*      */     default void onDelBefore() {}
/*      */     
/*      */     default void onDelAfter(List<Map<String, Object>> delRecords) {}
/*      */     
/*      */     default void onSyncLevelBefore(List<Map<String, Object>> delRecords, Set<Object> parentIdSet, List<Map<String, Object>> syncRecords) {}
/*      */     
/*      */     default void onSyncLevelAfter(List<Map<String, Object>> delRecords, Set<Object> parentIdSet, List<Map<String, Object>> syncRecords) {}
/*      */     
/*      */     default void onActionFinish(List<Map<String, Object>> delRecords, Set<Object> parentIdSet) {}
/*      */   }
/*      */ }


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/db/base/TreeJdbcDaoSupport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */