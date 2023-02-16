package Company.Square;
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
    
}
