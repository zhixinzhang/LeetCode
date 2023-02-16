package Company.Square;
import java.util.*;

//https://leetcode.com/discuss/interview-question/2790463/Square-Block-or-Phone-or-Features-with-Tags
public class _FindWithTags_Set {
    public static void main(String[] args) {
        String message = "feature1 : string categorical\nfeature2 : numeric\nfeature3 : numeric categorical\nfeature4 : string splittable\nfeature5 : string";
        String[] features = storeFeature(message);
        findOneFeature(features, "string");
        findFeatureEither(features, "categorical", "splittable");
        findAllFeatures(features, "categorical", "string"); 
 
     }
 
     private static String[] storeFeature(String message){
       String[] ans = message.split("\n");
       for (String f : ans){
         System.out.println(f);
       }
       return ans;
     }


     static String[] names = null;
     static List<Set<String>> tags = new ArrayList<>();
     private static void storeFeatureSet(String message){
        String[] ans = message.split("\n");
        for (String f : ans){
          System.out.println(f);
        }
        names = ans;
      }
 // O(n * m)  n is the number of features,  m is the number of tags 
     private static List<String> findOneFeature(String[] features, String attribue){
       List<String> ans = new ArrayList<>();
       for (String f : features){
         String[] info = f.trim().split(" ");
         String featureName = info[0];
         for (int i = 1; i < info.length; i++){
            if (info[i].equals(attribue)) {
               ans.add(featureName);
               break;
            }
         }
       }
 
       System.out.println("Write a function that accepts a tag and returnsall features that match it.   : \n");
       for (String s : ans){
         System.out.println(s);
       }
       return ans;
 }
 
     private static List<String> findFeatureEither(String[] features, String attribue, String attribue2){
       List<String> ans = new ArrayList<>();
       for (String f : features){
         String[] info = f.trim().split(" ");
         String featureName = info[0];
         for (int i = 1; i < info.length; i++){
            if (info[i].equals(attribue) || info[i].equals(attribue2)) {
               ans.add(featureName);
               break;
            }
         }
       }
 
       System.out.println("Write a function that accepts tags and returns all features that can have any one of them.   : \n");
       for (String s : ans){
         System.out.println(s);
       }
       return ans;
     }
 
 
     private static List<String> findAllFeatures(String[] features, String attribue, String attribue2){
       List<String> ans = new ArrayList<>();
       for (String f : features){
         String[] info = f.trim().split(" ");
         String featureName = info[0];
         boolean at1 = false;
         boolean at2 = false;
         for (int i = 1; i < info.length; i++){
            if (info[i].equals(attribue)) {
                at1 = true;
            } else if (info[i].equals(attribue2)){
                 at2 = true;
            }
         }
         if (at1 && at2) {
           ans.add(featureName);
         }
       }
 
       System.out.println("Write a function that accepts tags and returns all features that can have all of them.  :  \n");
       for (String s : ans){
         System.out.println(s);
       }
       return ans;
     }
}
