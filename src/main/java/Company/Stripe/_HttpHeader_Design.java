package Company.Stripe;

import javafx.util.Pair;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/16/2021 11:19 PM
 * <p>
 * Source Link:
 * <p> https://www.1point3acres.com/bbs/thread-709534-1-1.html
 * Description:
 * <p>Part 1
 *
 * In an HTTP request, the Accept-Language header describes the list of
 * languages that the requester would like content to be returned in. The header
 * takes the form of a comma-separated list of language tags. For example:
 *
 *   Accept-Language: en-US, fr-CA, fr-FR
 *
 * means that the reader would accept:
 *
 *   1. English as spoken in the United States (most preferred)
 *   2. French as spoken in Canada
 *   3. French as spoken in France (least preferred)
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _HttpHeader_Design {

    // part one
    public List<String> parse_accept_language(String httpHeader, String[] supported){
        List<String> ans = new ArrayList<>();
        if (httpHeader == null || httpHeader.length() == 0 || supported == null || supported.length == 0) {
            return ans;
        }


        String[] splitted = httpHeader.split(",");
        Set<String> cache = new HashSet<>(Arrays.asList(splitted));

        for (String language : supported){
            if (cache.contains(language)) {
                ans.add(language);
            }
        }

        return ans;
    }

    // part two

    public List<String> parse_accept_language_without_region(String httpHeader, String[] supported){
        List<String> ans = new ArrayList<>();
        if (httpHeader == null || httpHeader.length() == 0 || supported == null || supported.length == 0) {
            return ans;
        }


        String[] splitted = httpHeader.split(",");
        Set<String> cache = new HashSet<>(Arrays.asList(splitted));

        for (String language : supported){
            if (cache.contains(language)) {
                ans.add(language);
            } else if (language.contains("-")){
                String pre = language.split("-")[0];
                if (cache.contains(pre)) {
                    ans.add(language);
                }
            }
        }

        return ans;
    }

    public List<String> parse_accept_language_asterisk(String httpHeader, String[] supported) {
        List<String> ans = new ArrayList<>();
        if (httpHeader == null || httpHeader.length() == 0 || supported == null || supported.length == 0) {
            return ans;
        }


        String[] splitted = httpHeader.split(",");
        Set<String> cache = new HashSet<>(Arrays.asList(splitted));

        if (cache.contains("*"))
            return Arrays.asList(supported);

        for (String language : supported){
            if (cache.contains(language)) {
                ans.add(language);
            } else if (language.contains("-")){
                String pre = language.split("-")[0];
                if (cache.contains(pre)) {
                    ans.add(language);
                }
            }
        }

        return ans;
    }

    // part 4
    // "fr-FR;q=1, fr-CA;q=0, fr;q=0.5"
    public static List<String> parse_accept_language_order(String httpHeader, String[] supported) {
        List<String> ans = new ArrayList<>();
        String[] header = httpHeader.split(",");
        HashMap<String, Double> map = new HashMap<>();
        for (String head : header){
            String h = head.split(";")[0];
            String val = head.split(";")[1].split("=")[1];
            map.put(h.trim(), Double.valueOf(val));
        }


        TreeMap<Double, List<String>> minHeap = new TreeMap<>(Collections.reverseOrder());
        for (String sup : supported){

            if (map.containsKey(sup)) {
                double val = map.get(sup);
                minHeap.putIfAbsent(val, new ArrayList<>());
                minHeap.get(val).add(sup);
            } else if (sup.contains("-")) {
                String pre = sup.split("-")[0];
                if (map.containsKey(pre)){
                    double val = map.get(pre);
                    minHeap.putIfAbsent(val, new ArrayList<>());
                    minHeap.get(val).add(sup);
                }
            } else if (map.containsKey("*")){
                double val = map.get("*");
                minHeap.putIfAbsent(val, new ArrayList<>());
                minHeap.get(val).add(sup);
            }
        }

        for (Map.Entry<Double, List<String>> entry : minHeap.entrySet()){
            ans.addAll(entry.getValue());
        }

        for (String s : ans)
            System.out.println(s);

        return ans;
    }

    public static void main(String[] args){
//        String header = "fr-FR;q=1, fr-CA;q=0, *;q=0.5";
//        String[] sup = new String[]{"fr-FR", "fr-CA", "fr-BG", "en-US"};

        String header = "fr-FR;q=1, fr-CA;q=0, fr;q=0.5";
        String[] sup = new String[]{"fr-FR", "fr-CA", "fr-BG"};
        parse_accept_language_order(header, sup);
    }
}
