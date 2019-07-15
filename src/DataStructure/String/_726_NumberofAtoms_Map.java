package DataStructure.String;
import java.util.*;
/**
 * Created by zhang on 2018/5/5.
 */
public class _726_NumberofAtoms_Map {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = countHelper(formula);

        List<String> atoms = new ArrayList<>(map.keySet());
        Collections.sort(atoms);
        StringBuilder sb = new StringBuilder();
        for (String atom : atoms) {
            sb.append(atom + (map.get(atom) > 1 ? map.get(atom) : ""));
        }

        return sb.toString();
    }

    private Map<String, Integer> countHelper(String formula) {
        Map<String, Integer> map = new HashMap<>();
        if (formula.isEmpty()) return map;

        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                int count = 0, j = i;
                for (; j < formula.length(); j++) {
                    if (formula.charAt(j) == '(') count++;
                    else if (formula.charAt(j) == ')') count--;
                    if (count == 0) break;
                }
                Map<String, Integer> subMap = countHelper(formula.substring(i + 1, j));

                j++;
                int n = 1, k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                if (k > j) {
                    n = Integer.parseInt(formula.substring(j, k));
                }

                for (String atom : subMap.keySet()) {
                    map.put(atom, subMap.get(atom) * n + map.getOrDefault(atom, 0));
                }

                i = k;
            } else {
                int j = i + 1;
                while (j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') j++;

                int n = 1, k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                if (k > j) {
                    n = Integer.parseInt(formula.substring(j, k));
                }

                String atom = formula.substring(i, j);
                map.put(atom, n + map.getOrDefault(atom, 0));

                i = k;
            }
        }

        return map;
    }
}
