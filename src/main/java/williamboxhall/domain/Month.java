package williamboxhall.domain;

@SuppressWarnings("unused")
public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);
    private final int length;

    private Month(int length) {
        this.length = length;
    }

    public int length() {
        return length;
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
        } else if (later.earlierThan(this)) {
            return -later.differenceInDaysFrom(this);
        }
        return daysByTraversalFromEarlierToLater(this, later);
    }

    private static int daysByTraversalFromEarlierToLater(Month earlier, Month later) {
        int days = 0;
        while (earlier.earlierThan(later)) {
            days += earlier.length;
            earlier = earlier.next();
        }
        return days;
    }

    private boolean earlierThan(Month later) {
        return this.ordinal() < later.ordinal();
    }

    private Month next() {
        return Month.fromNumber(this.asNumber() + 1);
    }
}
