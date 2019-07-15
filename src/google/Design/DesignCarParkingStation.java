package google.Design;

/**
 * Created by zhang on 2018/6/25.
 */
/***
 *       parking station  max sum  100    30  40  30
 *       station different 3 parking size small normal bigger
 *       fullSize()
 *       park(small), change(small, station) leave(small)
 *
 * ***/
public class DesignCarParkingStation {
    class ParkingStation{
        int maxNum;
        int smallNum;
        int normalNum;
        int bigNum;
        int curNum;
        public ParkingStation(int maxNum, int smallNum, int normalNum, int bigNum, int curNum){
            this.maxNum = maxNum;
            this.smallNum = smallNum;
            this.bigNum = bigNum;
            this.normalNum = normalNum;
            this.curNum = 0;
        }
        public boolean fullSize(){
            return curNum == maxNum;
        }
    }

    public void solution(){
        ParkingStation ps = new ParkingStation(100,30, 40, 30,0);
        //small vehicle  but small size full
        //--small to normal  DataStructure.Integer cal

    }
}
