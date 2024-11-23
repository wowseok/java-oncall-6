package oncall.domain.date;

public enum PublicHolidays {

    NEW_YEARS_DAY(1,1),
    INDEPENDENCE_MOVEMENT_DAY(3,1),
    CHILDREN_DAY(5,5),
    MEMORIAL_DAY(6,6),
    LIBERATION_DAY(8,15),
    NATIONAL_FOUNDATION_DAY(10,3),
    HANGUL_DAY(10,9),
    CHRISTMAS_DAY(12,25);

    private final int month;
    private final int day;

    PublicHolidays(int month, int day){
    this.month = month;
    this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        for (PublicHolidays holiday : PublicHolidays.values()) {
            if (holiday.getMonth() == month && holiday.getDay() == day) {
                return true;
            }
        }
        return false;
    }

    public int getMonth(){
        return this.month;
    }
    public int getDay(){
        return this.day;
    }
}
