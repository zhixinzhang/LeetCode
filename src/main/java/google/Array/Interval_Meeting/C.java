package google.Array.Interval_Meeting;
import java.util.NavigableSet;
import java.util.TreeSet;

public class C {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        NavigableSet<P> s = new TreeSet<P>();
        s.add(new P("a"));
        System.out.println("-------------");
        s.add(new P("c"));
        s.add(new P("b"));
        System.out.println(s);
        s.add(new P("d"));
        System.out.println("-------------");
        System.out.println(s);
        s.add(new P("e"));
        System.out.println(s);
        System.out.println(s.contains(new P("d")));
        s.remove(new P("a"));
        System.out.println(s);
    }
}

class P implements Comparable<P> {
    static int hit;
    String s;
    double a;
    double b;
    public P(String s) {
        super();
        this.a = a;
        this.s = s;
        P.hit++;
    }

//    @Override
//    public int hashCode() {
//        // TODO Auto-generated method stub
//        System.out.println("hashcode");
//        return P.hit;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        System.out.println("equals");
//        P p;
//        if (obj instanceof P) {
//            p = (P) obj;
//            return p.s.equals(this.s);
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public String toString() {
//        // TODO Auto-generated method stub
//        return s;
//    }

    @Override
    public int compareTo(P o) {
        System.out.println(s + " compareTo " + o.s);
//        return o.s.compareTo(s);
        return 0;
    }

}
