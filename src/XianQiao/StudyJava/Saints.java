package XianQiao.StudyJava;

/**
 * @Author: Xianqiao
 * @Date: 6/16/20 21:53
 */
public class Saints {
    public int spiritualYear;
    private String gender;
    public String legalName;
    public double salary;
    public boolean marriageStatus;

    public void Saints() {
        this.spiritualYear = 5;
        this.gender = "male";
        this.legalName = "GodsChildren";
        this.salary = 120000.00;
        this.marriageStatus = false;
    }

    public Saints portraySaints(int spiritualYear, String gender, String legalName, double salary, boolean marriageStatus) {
        Saints b = new Saints();
        b.spiritualYear = spiritualYear;
        b.gender = gender;
        b.legalName = legalName;
        b.salary = salary;
        b.marriageStatus = marriageStatus;
        return b;
    }


    public double changeSalary (double number) {
        this.salary = salary + number;
        return salary;
    }

    public void changeMarriageStatus (boolean marriageStatus) {
        this.marriageStatus = marriageStatus;
    }
}
