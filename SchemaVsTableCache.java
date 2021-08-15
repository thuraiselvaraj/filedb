package com.filedb;
import java.util.HashMap;
public class SchemaVsTableCache {
    private static HashMap<String,String> tableNames = new HashMap<>();
    /**
     * Dummy private constructor to make the class static.
     */
    private SchemaVsTableCache(){}

    public String getSchemaName(String tableName) throws NoSuchSchemaException  {
       String schema;
       if((schema = tableNames.get(tableName) != null))
    }

}
