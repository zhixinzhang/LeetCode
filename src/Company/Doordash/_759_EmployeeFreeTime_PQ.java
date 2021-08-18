package Company.Doordash;

/**
 * @author Luke Zhang
 * @Date 2021-08-11 13:45
 *
 * https://leetcode.com/problems/employee-free-time/discuss/113134/Simple-Java-Sort-Solution-Using-(Priority-Queue)-or-Just-ArrayList
 */
public class _759_EmployeeFreeTime_PQ {
    // no PQ
//    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
//        List<Interval> result = new ArrayList<>();
//        List<Interval> timeLine = new ArrayList<>();
//        avails.forEach(e -> timeLine.addAll(e));
//        Collections.sort(timeLine, ((a, b) -> a.start - b.start));
//
//        Interval temp = timeLine.get(0);
//        for(Interval each : timeLine) {
//            if(temp.end < each.start) {
//                result.add(new Interval(temp.end, each.start));
//                temp = each;
//            }else{
//                temp = temp.end < each.end ? each : temp;
//            }
//        }
//        return result;
//    }

    // PQ
//    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
//        if(schedule == null || schedule.size() == 0){
//            return new ArrayList<>();
//        }
//
//        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.start - b.start));
//        schedule.forEach(e -> pq.addAll(e));
//
//        Interval temp = pq.poll();
//        List<Interval> result = new ArrayList<>();
//        while(!pq.isEmpty()){
//            if(temp.end < pq.peek().start) { // no intersect
//                result.add(new Interval(temp.end, pq.peek().start));
//                temp = pq.poll(); // becomes the next temp interval
//            }else { // intersect or sub merged
//                temp = temp.end < pq.peek().end ? pq.peek() : temp;
//                pq.poll();
//            }
//        }
//
//        return result;
//    }
}
