package Company.Google.String;

/**
 * Created by zhang on 2018/6/24.
 */
public class _551_StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int maxA = 0;
        int maxL = 0;
        if(s.length() <2) return true;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) != 'L') maxL = 0;
            if(s.charAt(i) == 'A'){
                maxA++;
                if(maxA > 1) return false;
            }
            if(s.charAt(i) == 'L' ){
                maxL++;
                if(maxL >2) return false;
            }

        }
        return true;
    }
}
