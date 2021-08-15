package access_mod.JNI.ajay.filedb;
import java.util.*;
public class Rows {
    private  Class TableName;
    private Set<String> Fields;
    private List<LinkedHashMap<String,Object>> OrderedRows = new ArrayList<>();

    /** 
     * Public constructor to create a Row Object
     * @param tableName the table name as the String
     * @param rowEntries takes the HashMaps Array with Key as Column name and Value as Column Value
     * @throws IllegalArguementException When the table name does not 
     */


    public Rows(String tableName,final HashMap<String,Object>[] rowEntries) throws IllegalArgumentException {
        /*
        for row Entries in the param create an LinkedHashMap in the correct order of columns
        as Id,Name,Age even the input in the form of Age,Id,Name
        
    }

    /**
     * 
     * @return status return the number of Rows aded to the table.
     */

    public int addToTable() throws Exception{
        //Add the data in the Hash Map to the Table here
        return 0; 
    }

    /**
     * 
     * @return Schema Name from the given JSON file for the given table
     */
    private String getSchemaName() {
        /*
        parse 
    }

}
