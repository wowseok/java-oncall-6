package oncall.domain;

public enum Date {
    ONE(1,31),
    TWO(2,28),
    THREE(3,31),
    FOUR(4,30),
    FIVE(5,31),
    SIX(6,30),
    SEVEN(7,31),
    EIGHT(8,31),
    NINE(9,30),
    TEN(10,31),
    ELEVEN(11,30),
    TWELVE(12,31);

    private final int month;
    private final int lastDay;

    Date(int month, int lastDay){
        this.month = month;
        this.lastDay = lastDay;
    }

    public static int getLastDayOfMonth(int month) {
        for (Date lastDay : Date.values()) {
            if (lastDay.month == month) {
                return lastDay.lastDay;
            }
        }
        throw new IllegalArgumentException("Invalid month: " + month);
    }


    // //1,3,5,7,8,10,12 는 31일이고, 4,6,9,11월은 30일로 끝납니다. 2월은 28
}


