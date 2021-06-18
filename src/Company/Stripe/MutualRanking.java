package Company.Stripe;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/17/2021 10:13 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class MutualRanking {
    static HashMap<String, List<String>> relationMap;
    public static void main(String[] args){
        relationMap = new HashMap<>();

        relationMap.put("a", Arrays.asList(new String[]{"b", "c", "d"}));
        relationMap.put("b", Arrays.asList(new String[]{"a", "c", "d"}));
        relationMap.put("c", Arrays.asList(new String[]{"d", "a"}));
        relationMap.put("d", Arrays.asList(new String[]{"a", "c"}));

//        boolean a = hasMutualRanking("a", 0);
//        boolean b = hasMutualRanking("a", 1);
//        boolean c = hasMutualRanking("a", 2);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        hasMutualRanking_changePair("a", 1);
    }

    private static boolean has_mutual_first_choice(String user){
        if (relationMap.containsKey(user)) {
            if (relationMap.get(user).isEmpty())
                return false;
            String friend = relationMap.get(user).get(0);

            List<String> friends = relationMap.get(friend);
            if(friends.isEmpty())
                return false;

            return friends.get(0).equals(friend);
        }

        return false;
    }

    private static boolean hasMutualRanking(String user, int index){
        if (relationMap.containsKey(user) && relationMap.containsKey(relationMap.get(user).get(index))) {
            String friend = relationMap.get(user).get(index);

            int friendIndex = -1;
            List<String> friends = relationMap.get(friend);
            for (int i = 0; i < friends.size(); i++){
                if (friends.get(i).equals(user)){
                    friendIndex = i;
                    break;
                }
            }

            return friendIndex == index;
        }

        return false;
    }

//    a, [b,c,d]
//    b, [a,c,d]
//    c, [d,a]
//    d, [a,c]
    private static List<String> hasMutualRanking_changePair(String user, int index){
        List<String> ans = new ArrayList<>();
        if (relationMap.containsKey(user)) {
            List<String> newFriendsList = new ArrayList<>(relationMap.get(user));
            for (int i = 0; i < newFriendsList.size(); i++){
                if (hasMutualRanking(user, i)) {
                    ans.add(newFriendsList.get(i));
                }
            }
            // swap relation
            String temp = newFriendsList.get(index);
            newFriendsList.set(index, newFriendsList.get(index - 1));
            newFriendsList.set(index - 1, temp);

            for (int i = 0; i < newFriendsList.size(); i++){
                if (hasMutualRanking(user, i)) {
                    ans.add(newFriendsList.get(i));
                }
            }

        }

        return ans;
    }

}
