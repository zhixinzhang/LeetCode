package Company.Google;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 2/6/19
 * Time: 4:52 PM
 * Description:
 */

//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=474461

public class file_abc_blacklist {

        public static void main(String[] args){
                HashSet<String> blacklist = new HashSet<>();
                blacklist.add("apple");
                blacklist.add("abc");

                List<String> sentences = new ArrayList<>();
                sentences.add(".... 6666");
                sentences.add(".... apple   ...");
                sentences.add("...apple and abc and 666");
                System.out.println(filter(blacklist, sentences));
        }

        private static List<String> filter(HashSet<String> blacklist, List<String> sentences){
                try {
                        FileReader fr = new FileReader("test.txt");
                        BufferedReader br = new BufferedReader(fr);
                        while (br.readLine() != null){

                        }
                }catch (Exception e){

                }
                List<String> filec = new ArrayList<>();
                for(String s : sentences){
                        for (String b : blacklist){
                                if(s.contains(b)){
                                        s = s.replaceAll(b, "REDA");
                                }
                        }
                        filec.add(s);
                }
                return filec;
        }
}
