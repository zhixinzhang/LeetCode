package Company.Square.OOP;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CrossRiverGame {
    static class RiverObj {
        String[] pos = new String[]{"river left", "river right"};
        Map<String, Object> objInfo;
        String curStatus;                   // 输出时要显示的信息
        String history;

        public RiverObj(){
            this.curStatus = "";
            this.history = "";
            this.objInfo = new HashMap<>();
        }

        public String printRiverStatus(){
            // curStatus = "";
            String left = "";
            String right = "";
            // String ans = "";
            for (String s : objInfo.keySet()){ 
                int index = objInfo.get(s).position;
                if (index == 0) {
                    left += s + " ";
                } else {
                    right += s + " ";
                }
                // ans += s + " on "  + pos[riverInfo.get(s).position] + "   ";
            }
            curStatus = left + " | " + right;
            // curStatus = left + " | " + right  + "    " + ans;
            return curStatus;
        }
    }
    static abstract class Object {
        int position;           // -1 on river left, 1 on river right
        public abstract void printPosition();
        
    }

    static class Farmer extends Object {
        public Farmer(int pos){
            super.position = pos;
        }
        public void printPosition() {
            // The body of animalSound() is provided here
            System.out.println("Currently Farmer position is : " + position);
        }
    }

    static class Chicken extends Object {
        public Chicken(int pos){
            super.position = pos;
        }
        public void printPosition() {
            // The body of animalSound() is provided here
            System.out.println("Currently Chicken position is : " + position);
        }
    }
    static class Wolf extends Object {
        public Wolf(int pos){
            super.position = pos;
        }
        public void printPosition() {
            // The body of animalSound() is provided here
            System.out.println("Currently Wolf position is : " + position);
        }
    }

    static class Rice extends Object {
        public Rice(int pos){
            super.position = pos;
        }
        public void printPosition() {
            // The body of animalSound() is provided here
            System.out.println("Currently Rice position is : " + position);
        }
    }

    public static void main(String[] args) {
        RiverObj riverObj = new RiverObj();
        initialRiverInfo(riverObj);
        System.out.println("test 1 ******************");
        boolean ans11 = crossRiver(riverObj, Arrays.asList("Farmer", "Chicken"));
        boolean ans22 = crossRiver(riverObj, Arrays.asList("Farmer", "Chicken"));
        boolean ans33 = crossRiver(riverObj, Arrays.asList("Farmer", "Wolf"));
        
        System.out.println(ans11);
        System.out.println(ans22);
        System.out.println(ans33);
        System.out.println(riverObj.history);
        System.out.println("test 2 ******************");
        initialRiverInfo(riverObj);
        boolean ans1 = crossRiver(riverObj, Arrays.asList("Farmer", "Chicken"));
        boolean ans2 = crossRiver(riverObj, Arrays.asList("Farmer"));
        boolean ans3 = crossRiver(riverObj, Arrays.asList("Farmer", "Wolf"));
        boolean ans4 = crossRiver(riverObj, Arrays.asList("Farmer", "Chicken"));
        boolean ans5 = crossRiver(riverObj, Arrays.asList("Farmer", "Rice"));
        boolean ans6 = crossRiver(riverObj, Arrays.asList("Farmer"));
        boolean ans7 = crossRiver(riverObj, Arrays.asList("Farmer", "Chicken"));
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
        System.out.println(ans5);
        System.out.println(ans6);
        System.out.println(ans7);
        System.out.println(riverObj.history);

        System.out.println("test 3 ******************");
        RiverObj riverObj2 = new RiverObj();
        initialRiverInfo(riverObj2);
        autoCrossRiver(riverObj2);

    }

    private static void initialRiverInfo(RiverObj riverObj){
        riverObj.objInfo.put("Farmer", new Farmer(0));
        riverObj.objInfo.put("Chicken", new Chicken(0));
        riverObj.objInfo.put("Wolf", new Wolf(0));
        riverObj.objInfo.put("Rice", new Rice(0));
        riverObj.history = "";
        riverObj.curStatus = "";
        System.out.println(riverObj.printRiverStatus());
    }

    private static boolean crossRiver(RiverObj riverObj, List<String> objects){
        Map<String, Object> cache = new HashMap<>();
        cache.putAll(riverObj.objInfo);
        if (!objects.contains("Farmer"))
            return false;
        
        String objectTypes = "";
        String dir = "";
        for (String obj : objects){
            int newPos = cache.get(obj).position == 0 ? 1 : 0;
            if (dir == "")
                dir =  " move from " + riverObj.pos[cache.get(obj).position] +  " to " + riverObj.pos[newPos] ;
            cache.get(obj).position = newPos;
            objectTypes += obj + " , ";
        }
        boolean ans = judge(cache);
        if (!ans) {
            return ans;
        }

        riverObj.objInfo = cache;
        
        riverObj.history += objectTypes + dir + "\n";
        System.out.println(riverObj.printRiverStatus());
        return true;
    }

    private static boolean judge(Map<String, Object> cache){
        int wP = cache.get("Wolf").position;
        int cP = cache.get("Chicken").position;
        int fP = cache.get("Farmer").position;
        int rP = cache.get("Rice").position;
        // farmer and wolf 
        if (wP == cP && fP != wP) {
            return false;
        } else if (cP == rP && fP != cP){
            return false;
        }
        return true;
    }

    static List<String[]> options = Arrays.asList(
        new String[]{"Farmer", "Wolf"},
        new String[]{"Farmer", "Chicken"},
        new String[]{"Farmer", "Rice"},
        new String[]{"Farmer"}
    );

    private static void autoCrossRiver(RiverObj riverObj){
        Set<String> visited = new HashSet<>();
        visited.add(riverObj.printRiverStatus());

        Queue<RiverObj> queue = new ArrayDeque<>();
        queue.add(riverObj);

        int step = 1;
        while(!queue.isEmpty()){
            int level = queue.size();
            for (int i = 0; i < level; i++){
                RiverObj curRiverObj = new RiverObj();
                curRiverObj = queue.poll();
                
                for (String[] opt : options){
                    RiverObj tempRiver = new RiverObj();
                    tempRiver.objInfo = deepCopy(curRiverObj);
                    boolean ans = false;

                    if (opt.length == 2) {
                        ans = crossRiver(tempRiver, Arrays.asList(opt[0], opt[1]));
                    } else {
                        ans = crossRiver(tempRiver, Arrays.asList(opt[0]));
                    }

                    String tempRiverStatus = tempRiver.printRiverStatus();
                    if (allCrossRiver(tempRiver)) {
                        System.out.println("autoCrossRiver : " + tempRiverStatus);
                        System.out.println("autoCrossRiver shortest step : " + step);
                        return;
                    }
                    
                    if (ans && !visited.contains(tempRiverStatus)) {
                        queue.add(tempRiver);
                        visited.add(tempRiverStatus);
                    }
                }
            }
            step ++;
        }
    }

    private static boolean allCrossRiver(RiverObj riverObj){
        for (String obj : riverObj.objInfo.keySet()) {
            if (riverObj.objInfo.get(obj).position == 0) {
                return false;
            }
        }

        return true;
    }

    private static Map<String, Object> deepCopy(RiverObj riverObj){
        Map<String, Object> deepCopy = new HashMap<>();
        for (String obj : riverObj.objInfo.keySet()) {
            Object newObj = riverObj.objInfo.get(obj);
            if (obj.equals("Farmer"))
                deepCopy.put(obj, new Farmer(newObj.position));
            if (obj.equals("Wolf"))
            deepCopy.put(obj, new Wolf(newObj.position));
            if (obj.equals("Chicken"))
            deepCopy.put(obj, new Chicken(newObj.position));
            if (obj.equals("Rice"))
            deepCopy.put(obj, new Rice(newObj.position));
        }

        return deepCopy;
    }
}
