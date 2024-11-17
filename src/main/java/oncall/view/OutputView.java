package oncall.view;

public class OutputView {

    public static final String ERROR_FORM = "[ERROR] %s%n";

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage());
        System.out.println();
    }

    public void printIntroMessage() {
        System.out.printf("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void printWeekdayWork(){
        System.out.printf("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printWeekendWork(){
        System.out.printf("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }
}
