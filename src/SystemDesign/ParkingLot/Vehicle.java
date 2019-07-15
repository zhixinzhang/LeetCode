package SystemDesign.ParkingLot;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/17/19
 * Time: 3:44 PM
 * Description:
 */


public abstract class Vehicle {
    private String vehicleID;
    private final VehicleType type;

    public Vehicle(VehicleType type){
        this.type = type;
    }

    public class MotorCycle extends Vehicle{
        public MotorCycle(){
            super(VehicleType.MOTORCYCLE);
        }
    }

    public class Car extends Vehicle{
        public Car(){
            super(VehicleType.CAR);
        }
    }

    public class Bus extends Vehicle{
        public Bus(){
            super(VehicleType.BUS);
        }
    }
}
