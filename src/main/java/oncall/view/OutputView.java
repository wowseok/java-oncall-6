package oncall.view;

import oncall.domain.date.DayOfWeek;
import oncall.domain.date.MonthInfo;
import oncall.domain.date.PublicHolidays;

public class OutputView {

    public static final String ERROR_FORM = "[ERROR] %s%n";

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage());
        System.out.println();
    }

    public void printIntroMessage() {
        System.out.printf("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void printWeekdayWork() {
        System.out.printf("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printWeekendWork() {
        System.out.printf("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printScheduler(String currentMember, int day, MonthInfo monthInfo, DayOfWeek currentDay) {
        if (PublicHolidays.isHoliday(monthInfo.getMonth(), day)) {
            System.out.printf("%d월 %d일 %s(휴일) %s%n",
                    monthInfo.getMonth(), day, currentDay.getName(), currentMember);
        }
        if (!PublicHolidays.isHoliday(monthInfo.getMonth(), day)) {
            System.out.printf("%d월 %d일 %s %s%n",
                    monthInfo.getMonth(), day, currentDay.getName(), currentMember);
        }
    }
}
