package oncall.domain.date;

import java.util.Arrays;
import java.util.List;

public enum Date {
    ONE(1, 31, null),
    TWO(2, 28, null),
    THREE(3, 31, null),
    FOUR(4, 30, null),
    FIVE(5, 31, null),
    SIX(6, 30, null),
    SEVEN(7, 31, null),
    EIGHT(8, 31, null),
    NINE(9, 30, null),
    TEN(10, 31, null),
    ELEVEN(11, 30, null),
    TWELVE(12, 31, null);

    private final int month;
    private final int lastDay;
    private String startDay;
    private static final List<String> DAYS = Arrays.asList("월", "화", "수", "목", "금", "토", "일");


    Date(int month, int lastDay, String startDay) {
        this.month = month;
        this.lastDay = lastDay;

        this.startDay = startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public void setNextDay(String day) {

        this.startDay = DAYS.get((DAYS.indexOf(day) + 1) % DAYS.size());
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay() {
        return lastDay;
    }

    public String getStartDay() {
        return startDay;
    }

    public static Date fromMonth(int month, String day) {
        for (Date date : Date.values()) {
            if (date.getMonth() == month && isValidDay(day)) {
                date.setStartDay(day);
                System.out.println(date);
                System.out.println(date.getStartDay());
                return date;
            }
        }
        throw new IllegalArgumentException("월이 올바르지 않습니다.");
    }

    public static boolean isValidDay(String input) {
        if (!DAYS.contains(input)) {
            throw new IllegalArgumentException("요일이 올바르지 않습니다.");
        }
        return true;
    }


    /*
    public static void printCalendar(int month, String startDay) {
        int lastDay = getLastDayOfMonth(month);

        // 입력된 요일의 인덱스를 계산
        int startIndex = -1;
        for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].equals(startDay)) {
                startIndex = i;
                break;
            }
        }

        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start day: " + startDay);
        }

        // 달력 출력
        System.out.println("Month: " + month);
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%2d일 (%s)%n", i, DAYS[(startIndex + (i - 1)) % DAYS.length]);
        }
    }
*/

    // //1,3,5,7,8,10,12 는 31일이고, 4,6,9,11월은 30일로 끝납니다. 2월은 28
}


