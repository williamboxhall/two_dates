package williamboxhall.domain;

public class DateFactory {
    public Date createWith(int day, int month, int year) {
        return new Date(day, month, year);
    }
}
