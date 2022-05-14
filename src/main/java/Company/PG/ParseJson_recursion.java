package Company.PG;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/1/27.
 *  你有json object  json object可能会包含其他json object 或者 json string 然后要求你把他转化成hashtable 给了json的一堆函数啥的 我花了很久才弄懂怎么回事……
 *  弄懂就不难写了 基本上recursion 解决。就是大家先去理解一下json object 是咋回事
 * https://github.com/new2500/PG-p/blob/master/JSON%20to%20DB.cs
 * //For next level, we always go through until we meet the JSON String => which is the end, so it's full DFS.
 //Since we go through all the branch until the end, it's a O(2^n) algorithm.
 */
public class ParseJson_recursion {
    public List<Json> parseJson(Json apiData, String[] columns){
        List<Json> res = new ArrayList<>();
        helper(apiData,columns,0,new StringBuilder(),res);
        return res;
    }

    public void helper(Json apiData, String[] columns, int index, StringBuilder sb, List<Json> res) {
        if (apiData.type().equals("JSONString")) {
            sb.append(columns[index]).append(":").append(apiData.value()).append("}");
            res.add(new Json(sb.toString()));
        } else {
            if (apiData.type().equals("JSONMapping")) {
                for (String key : apiData.keys()) {
                    String cur = columns[index] + ":" + key + ",";
                    sb.append(cur);
                    helper(apiData.get(key), columns, index + 1, sb, res);
                }
            }
        }
    }


    class Json {
        String json;
        public Json(){}
        public Json(String json) {this.json = json;}
        public String toString(){
            return "";
        }
        public String type() {
            return "";
        }
        public String value() {
            return "";
        }
        public Json get(String key) {return null;}
        public String[] keys() {return new String[2];}
    }
    class JSONString extends Json{
        public String value(){return "";}
        public String type(){return "";}
    }
}
