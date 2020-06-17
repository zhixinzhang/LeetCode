package XianQiao.StudyJava;

/**
 * @Author: Xianqiao
 * @Date: 6/16/20 21:52
 */
public class Church {
    public String location;
    public int capacity;

    public Church () {
        this.location = "davis";
        this.capacity = 100;
    }

    public Church (String location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public Church buildChurch (String location, int capacity) {
        Church a = new Church();
        a.location = location;
        a.capacity = capacity;
        return a;
    }

    public String changeLocation (String location) {
        this.location = location;
        return location;
    }
    public int changeCapacity (int number) {
        this.capacity = capacity + number;
        return capacity;
    }
}
