package io.mycat.mycat2.sqlparser.byteArrayInterface.dynamicAnnotation;

import io.mycat.mycat2.sqlparser.BufferSQLContext;
import io.mycat.mycat2.sqlparser.byteArrayInterface.dynamicAnnotation.impl.DynamicAnnotation;
import io.mycat.mycat2.sqlparser.byteArrayInterface.dynamicAnnotation.impl.DynamicAnnotationKeyRoute;
import io.mycat.mycat2.sqlparser.byteArrayInterface.dynamicAnnotation.impl.SQLType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jamie on 2017/9/19.
 */
public interface DynamicAnnotationManager {


    public Runnable process(int schema, int sqltype, int[] tables,BufferSQLContext context) throws Exception ;
    /**
     * 动态注解先匹配chema的名字,再sql类型，在匹配表名，在匹配条件
     *
     * @param
     * @return
     */
    //public void processNow(int schema, int sqltype, int[] tables, BufferSQLContext context) throws Exception ;

    public default Runnable process(String schema, SQLType sqltype, int[] tables, BufferSQLContext context) throws Exception {

        return process(schema.hashCode(), sqltype.getValue(), tables, context);
    }
    public default Runnable process(String schema, SQLType sqltype, String[] tables, BufferSQLContext context) throws Exception {
        return process(schema.hashCode(), sqltype.getValue(), DynamicAnnotationKeyRoute.stringArray2HashArray(tables), context);
    }
}
