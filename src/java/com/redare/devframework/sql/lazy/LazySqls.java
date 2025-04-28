package com.redare.devframework.sql.lazy;

import java.util.List;

public interface LazySqls<T extends com.redare.devframework.sql.Sql> {
  List<T> getSqls();
}


/* Location:              /Users/tiankun/IdeaProjects/yc-wsfk-safemanager/.libs/redare-devframework-sql-1.3.0.jar!/com/redare/devframework/sql/lazy/LazySqls.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */