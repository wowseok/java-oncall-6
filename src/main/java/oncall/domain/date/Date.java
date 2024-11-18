package oncall.domain.date;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private static String[] DAYS = {"월", "화", "수", "목", "금", "토", "일"};


    Date(int month, int lastDay){
        this.month = month;
        this.lastDay = lastDay;
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay(){
        return lastDay;
    }

    public static Date fromMonth(int month) {
        for (Date date : Date.values()) {
            if (date.getMonth() == month) {
                return date;
            }
        }
        throw new IllegalArgumentException("월이 올바르지 않습니다.");
    }

    public static void isValidDay(String input) {
        List<String> Days = new ArrayList<>(Arrays.asList(DAYS));
        if (!Days.contains(input)) {
            throw new IllegalArgumentException("요일이 올바르지 않습니다.");
        }
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


