import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Luke Zhang
 * @Date 2020-12-17 22:55
 */
public class test {
    public static void main(String[] args){
        // String to be scanned to find the pattern.
//        String line = "This order was placed for QT3000! OK?";
        String line = "";
        String pattern = "\\P{C}*";
//        String pattern = "^\\\\s\\\\r\\\\n]{1,5}";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
        }else {
            System.out.println("NO MATCH");
        }
    }
}
