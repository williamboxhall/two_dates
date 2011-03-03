package williamboxhall.domain;

public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31), APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);
    private final int length;

    Month(int length) {
        this.length = length;
    }

    public int asNumber() {
        return ordinal() + 1;
    }

    static Month fromNumber(int month) {
        return Month.values()[month-1];
    }

    int differenceInDaysFrom(Month later) {
        if (later == this) {
            return 0;
        } else if (earlierThan(later)) {
            return -later.differenceInDaysFrom(this);
        }
        return daysByTraversalFromEarlierToLater(this, later);
    }

    private int daysByTraversalFromEarlierToLater(Month earlier, Month month) {
        int days = 0;
        while (month.earlierThan(earlier)) {
            days += earlier.length;
            earlier = earlier.next();
        }
        return days;
    }

    private boolean earlierThan(Month later) {
        return later.ordinal() < this.ordinal();
    }

    private Month next() {
        return Month.fromNumber(this.asNumber() + 1);
    }

    public int length() {
        return length;
    }
}
