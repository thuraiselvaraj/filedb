import java.util.*;
import java.io.*;
public class GetTableDetails {
    private static String[] FIELDS = new String[]{"STRING","INT","LONG","DOUBLE","FLOAT","BOOLEAN"};
    private static final Set Fields = new HashSet<String>(Arrays.asList(FIELDS));
    private static HashMap<String,HashMap<String,Class>> tablesVsFieldDetails = new HashMap<>();

    public static void initialize(String path) throws IOException{
        Properties props = parseProps("/home/local/ZOHOCORP/chella-pt3956/Desktop/filedb/test/Tables.props");
        //Properties props = parseProps(path);
        createTablesVsFields(props);

    }

    private static Properties parseProps(String path) throws IOException{
        Properties p = new Properties();
        FileReader f = new FileReader(path);
        p.load(f);
        return p;
    }

    public static HashMap<String,Class> getFieldVsTypes(String tableName){
        return tablesVsFieldDetails.get(tableName);
    }

    private static void createTablesVsFields(Properties properties){

        for(String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            try {
                tablesVsFieldDetails.put(key,getFieldVsTypes_(value));
            }
            catch(ClassNotFoundException e){
                throw new RuntimeException(e);
            }
          }
    }

    private static HashMap<String,Class> getFieldVsTypes_(String tableBuffer)throws IllegalArgumentException,ClassNotFoundException{
        HashMap<String,Class> fieldVsTypes = new HashMap<String,Class>();
        String[] values = null ;
        for(String entry : tableBuffer.split(",")){
             values = entry.split(":");
             if(values!=null){
                if(values.length != 2 &&  !Fields.contains(values[1].toUpperCase())){
                    throw new IllegalArgumentException("Field "+values[0]+" has Invalid type "+values[1]);
                }
                else{
                    fieldVsTypes.put(values[0],getClassName(values[1])); 
                }
            }  
        }
        return fieldVsTypes;
    }

    private static Class getClassName(String str) throws ClassNotFoundException{
        String Capitalized = str.toLowerCase().substring(0, 1).toUpperCase() + str.substring(1);
        return Class.forName("java.lang."+Capitalized);
    }

   
}
