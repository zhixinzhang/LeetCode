package Company.Square.OOP;
import java.util.*;

// Credit card information
// https://leetcode.com/discuss/interview-question/1962033/SquareBlock-or-Phone-or-Credit-card-information
public class _CreditScore_Map {
        static Map<String,CreditCard> map = new HashMap<>();
        
        private static void store(String binNumber, String cardType, String cardName, int trustScore) {
            CreditCard cc = new CreditCard(binNumber, cardType, cardName, trustScore);
            map.put(binNumber,cc);
        }
        
        // Part I
        private static List<String> lookup(String binNumber) {
            List<String> output = new ArrayList<>();
            if(map.containsKey(binNumber)) {
                CreditCard cc = map.get(binNumber);
                output.add(cc.cardType);
                output.add(cc.cardName);
            }
            return output;
        }
        
        static class CreditCard {
            String binNumber;
            String cardType;
            String cardName;
            int trustScore;
            public CreditCard(String binNumber, String cardType, String cardName, int trustScore){
                this.binNumber = binNumber;
                this.cardType = cardType;
                this.cardName = cardName;
                this.trustScore = trustScore;
            }
        }
        
        public static void main(String[] args) {
            store("1","credit","bofa",5);
            System.out.println(lookup("1"));
            store("2","visa","chase",7);
            System.out.println(lookup("2"));
            store("2","mastercard","wells Fargo",4);
            System.out.println(lookup("2"));
        }

        // Part 2
        // static Map<String,CreditCard> map = new HashMap<>();
    
        // private static void store(String binNumber, String cardType, String cardName, int trustScore) {
        //     CreditCard cc = new CreditCard(binNumber, cardType, cardName, trustScore);
        //     // only below 4 lines changed for part 2
        //     if(map.containsKey(binNumber)) {
        //         CreditCard oldcc = map.get(binNumber);
        //         if(trustScore >= oldcc.trustScore) map.put(binNumber, cc);
        //     } else {
        //         map.put(binNumber,cc);   
        //     }
        // }
        
        // private static List<String> lookup(String binNumber) {
        //     List<String> output = new ArrayList<>();
        //     if(map.containsKey(binNumber)) {
        //         CreditCard cc = map.get(binNumber);
        //         output.add(cc.cardType);
        //         output.add(cc.cardName);
        //     }
        //     return output;
        // }
        
        // static class CreditCard {
        //     String binNumber;
        //     String cardType;
        //     String cardName;
        //     int trustScore;
        //     public CreditCard(String binNumber, String cardType, String cardName, int trustScore){
        //         this.binNumber = binNumber;
        //         this.cardType = cardType;
        //         this.cardName = cardName;
        //         this.trustScore = trustScore;
        //     }
        // }

        // public static void main(String[] args) {
        //     store("1","credit","bofa",5);
        //     System.out.println(lookup("1"));
        //     store("2","visa","chase",7);
        //     System.out.println(lookup("2"));
        //     store("2","mastercard","wells Fargo",4);
        //     System.out.println(lookup("2"));
        //     store("2","mastercard","wells Fargo",8);
        //     System.out.println(lookup("2"));
        // }

        // part 3
        // static Map<String,CreditCard> map = new HashMap<>();
    
        // private static void store(String binNumber, String cardType, String cardName, int trustScore) {
        //     CreditCard cc = new CreditCard(binNumber, cardType, cardName, trustScore);
        //     if(map.containsKey(binNumber)) {
        //         CreditCard oldcc = map.get(binNumber);
        //         if(trustScore > oldcc.trustScore) {
        //             map.put(binNumber, cc);
        //             return;
        //         }
        //         if(cardType != null && oldcc.cardType == null) oldcc.cardType = cardType;
        //         if(cardName != null && oldcc.cardName == null) oldcc.cardName = cardName;
        //         map.put(binNumber, oldcc);
        //     } else {
        //         map.put(binNumber,cc);   
        //     }
        // }
        
        // private static List<String> lookup(String binNumber) {
        //     List<String> output = new ArrayList<>();
        //     if(map.containsKey(binNumber)) {
        //         CreditCard cc = map.get(binNumber);
        //         output.add(cc.cardType);
        //         output.add(cc.cardName);
        //     }
        //     return output;
        // }
        
        // static class CreditCard {
        //     String binNumber;
        //     String cardType;
        //     String cardName;
        //     int trustScore;
        //     public CreditCard(String binNumber, String cardType, String cardName, int trustScore){
        //         this.binNumber = binNumber;
        //         this.cardType = cardType;
        //         this.cardName = cardName;
        //         this.trustScore = trustScore;
        //     }
        // }
        
        // public static void main(String[] args) {
        //     store("1","credit","bofa",5);
        //     System.out.println(lookup("1"));
        //     store("2","visa","chase",7);
        //     System.out.println(lookup("2"));
        //     store("2","mastercard","wells Fargo",4);
        //     System.out.println(lookup("2"));
        //     store("2","mastercard","wells Fargo",8);
        //     System.out.println(lookup("2"));
        //     store("3",null,"wells Fargo",8);
        //     System.out.println(lookup("3"));
        //     store("3","visa","wells Fargo",3);
        //     System.out.println(lookup("3"));
        //     store("4","visa","wells Fargo",3);
        //     System.out.println(lookup("4"));
        //     store("4","credit","chase",7);
        //     System.out.println(lookup("4"));
        //     store("4",null,null,8);
        //     System.out.println(lookup("4"));
        // }
    
}
