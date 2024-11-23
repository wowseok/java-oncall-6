package oncall.domain.date;

public enum MonthInfo {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private final int month;
    private final int lastDay;

    MonthInfo(int month, int lastDay) {
        this.month = month;
        this.lastDay = lastDay;
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay() {
        return lastDay;
    }

    public static MonthInfo fromMonth(int month) {
        for (MonthInfo info : MonthInfo.values()) {
            if (info.getMonth() == month) {
                return info;
            }
        }
        throw new IllegalArgumentException("Invalid month: " + month);
    }
}
