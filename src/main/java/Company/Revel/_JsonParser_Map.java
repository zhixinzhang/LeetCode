package Company.Revel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _JsonParser_Map {

    private final static String jsonString
        = "{'name':'user','id':1234,'marks':[{'english':85,'physics':80,'chemistry':75,'a':[{'b':1,'c':2}]}]}";    
 
    private final static String jsonString2
        = "{'name':'user','id':1234,'marks':[{'english':85,'physics':80,'chemistry':75,'a':[{'b':1,'c':2}]}],'cities':[{'CA':LA,'WA':Seattle}]}";  

    public static void main(String[] args)
    {
 
        // Parse json object for user data
        JSONObject user = new JSONObject(jsonString2);
 
        // Get json array for user's marks
        JSONArray marks = user.getJSONArray("marks");
 
        // Get json object for subject's marks
        JSONObject subjects = marks.getJSONObject(0);

        JSONArray aMarks = subjects.getJSONArray("a");
 
        // Get json object for subject's marks
        JSONObject aSubjects = aMarks.getJSONObject(0);

        JSONArray cityMarks = user.getJSONArray("cities");
 
        // Get json object for subject's marks
        JSONObject citySubjects = cityMarks.getJSONObject(0);
 
        // Print and display commands
        System.out.println(
            String.format("English marks - %s",
                          subjects.getValue("english")));
        System.out.println(
            String.format("Physics marks - %s",
                          subjects.getValue("physics")));
        System.out.println(
            String.format("Chemistry marks - %s",
                          subjects.getValue("chemistry")));
        System.out.println(String.format("b marks - %s", aSubjects.getValue("b")));
        System.out.println(String.format("WA marks - %s", citySubjects.getValue("WA")));
        System.out.println(String.format("non marks - %s", citySubjects.getValue("non")));

    }
}


 
// Class 1
// To parse json object
class JSONObject {
    private final static String openCurlyBracket = "{";
    private final static String closeCurlyBracket = "}";
    private final static String openSqureBracket = "[";
    private final static String closeSqureBracket = "]";
    private final static String colon = ":";
    private final static String comma = ",";
    private final static char special = '|';

    private HashMap<String, String> objects;   
 
    // Constructor if this class
    public JSONObject(String arg) { getJSONObjects(arg); }
 
    // Method 1
    // Storing json objects as key value pair in hash map
    public void getJSONObjects(String arg){
 
        objects = new HashMap<String, String>();
 
        if (arg.startsWith(openCurlyBracket)&& arg.endsWith(closeCurlyBracket)) {
 
            StringBuilder builder = new StringBuilder(arg);
            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length() - 1);
            String a = builder.toString();
            builder = replaceCOMMA(builder);
            String b = builder.toString();
            System.out.println(b);
            for (String objects : builder.toString().split(comma)) {
 
                String[] objectValue = objects.split(colon, 2);
 
                if (objectValue.length == 2)
                    this.objects.put(
                        objectValue[0]
                            .replace("'", "")
                            .replace("\"", ""),
                        objectValue[1]
                            .replace("'", "")
                            .replace("\"", ""));
            }
        }
    }
 
    // Method 2
    public StringBuilder replaceCOMMA(StringBuilder arg)
    {
 
        boolean isJsonArray = false;
 
        for (int i = 0; i < arg.length(); i++) {
            char a = arg.charAt(i);
 
            if (isJsonArray) {
 
                if (String.valueOf(a).compareTo(comma) == 0) {
                    arg.setCharAt(i, special);
                }
            }
 
            if (String.valueOf(a).equals(openSqureBracket))
                isJsonArray = true;
            if (String.valueOf(a).equals(closeSqureBracket))
                isJsonArray = false;
        }
 
        return arg;
    }
 
    // Method 3
    // Getting json object value by key from hash map
    public String getValue(String key){
        if (!objects.containsKey(key)){
            return "Key doesn't exist in Json dictionary";
        }
        if (objects != null) {
            return objects.get(key).replace('|', ',');
        }
        return null;
    }
 
    // Method 4
    // Getting json array by key from hash map
    public JSONArray getJSONArray(String key)
    {
        if (objects != null)
            return new JSONArray(
                objects.get(key).replace('|', ','));
        return null;
    }
}
 
// Class 2
// To parse json array
class JSONArray {
    private final static String openCurlyBracket = "{";
    private final static String closeCurlyBracket = "}";
    private final static String openSqureBracket = "[";
    private final static String closeSqureBracket = "]";
    private final static String colon = ":";
    private final static String comma = ",";
    private final static char special = '|';

 
    private ArrayList<String> objects;
 
 
    // Constructor of this class
    public JSONArray(String arg) { getJSONObjects(arg); }
 
    // Method 1
    // Storing json objects in array list
    public void getJSONObjects(String arg){
 
        objects = new ArrayList<String>();
 
        if (arg.startsWith(openSqureBracket) && arg.endsWith(closeSqureBracket)) {
 
            StringBuilder builder = new StringBuilder(arg);
 
            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length() - 1);
 
            builder = replaceCOMMA(builder);
 
            // Adding all elements
            // using addAll() method of Collections class
            Collections.addAll(
                objects,
                builder.toString().split(comma));
        }
    }
 
    // Method 2
    public StringBuilder replaceCOMMA(StringBuilder arg)
    {
        boolean isArray = false;
 
        for (int i = 0; i < arg.length(); i++) {
            char a = arg.charAt(i);
            if (isArray) {
 
                if (String.valueOf(a).equals(comma)) {
                    arg.setCharAt(i, '|');
                }
            }
 
            if (String.valueOf(a).equals(openCurlyBracket))
                isArray = true;
 
            if (String.valueOf(a).equals(closeCurlyBracket))
                isArray = false;
        }
 
        return arg;
    }
 
    // Method  3
    // Getting json object by index from array list
    public String getObject(int index)
    {
        if (objects != null) {
            return objects.get(index).replace('|', ',');
        }
 
        return null;
    }
 
    // Method 4
    // Getting json object from array list
    public JSONObject getJSONObject(int index)
    {
 
        if (objects != null) {
            return new JSONObject(
                objects.get(index).replace('|', ','));
        }
 
        return null;
    }
}
