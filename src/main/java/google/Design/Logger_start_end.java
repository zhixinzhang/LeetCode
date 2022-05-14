package google.Design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/7/3.
 */
class Logger{
    String id;
    List<Request>  RequestList;
    Logger(){
        this.RequestList = new ArrayList<>();
    }
}
class Request{
    String id;
    int start;
    int end;
    Request(String id, int start, int end){
        this.id = id;
        this.start = start;
        this.end = end;
    }
}
public class Logger_start_end {
    public static List<Request> solution(Logger logger){
        List<Request> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args){
        Logger logger = new Logger();
        Request r1 = new Request("1",1,5);
        solution(logger);
    }
}
