package Model.Enums;

/**
 * Created by Eiger on 2/25/16.
 */

public enum WeekDay {
    Monday      ("Monday"),
    Tuesday     ("Tuesday"),
    Wednesday   ("Wednesday"),
    Thursday    ("Thursday"),
    Friday      ("Friday"),
    Saturday    ("Saturday"),
    Sunday      ("Sunday");

    private String day;

    private WeekDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day;
    }
}
