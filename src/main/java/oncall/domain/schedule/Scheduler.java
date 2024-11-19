package oncall.domain.schedule;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import oncall.domain.date.Date;

public class Scheduler {
    private static Scheduler instance; // 유일한 인스턴스
    private Date date;
    private LinkedList<String> weekdayMembers;
    private LinkedList<String> weekendMembers;
    private final List<String> dates = Arrays.asList("월", "화", "수", "목", "금", "토", "일");

    // private 생성자: 외부에서 객체 생성 불가
    private Scheduler() {
        this.date = null;
        this.weekdayMembers = new LinkedList<>();
        this.weekendMembers = new LinkedList<>();

    }

    // 전역적으로 접근 가능한 인스턴스 제공
    public static Scheduler getInstance() {
        if (instance == null) {
            instance = new Scheduler();
        }
        return instance;
    }

    public void addWeekdayMembers(List<String> members) {
        SchedulerValidator.weekMembersValidate(members);
        this.weekdayMembers = new LinkedList<>((members));
    }

    public void addWeekendMembers(List<String> members) {
        SchedulerValidator.weekendMembersValidate(members, this.weekdayMembers);
        this.weekendMembers = new LinkedList<>((members));
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public List<String> getWeekdayMembers() {
        return weekdayMembers;
    }

    public List<String> getWeekendMembers() {
        return weekendMembers;
    }

    public Date getDate() {
        return date;
    }

    public void assignDutySchedule() {
        String lastAssigned = ""; // 마지막으로 근무한 사람을 추적

        int dateIndex = dates.indexOf(date.getStartDay()); // 날짜 리스트에서 순환적으로 접근하기 위한 인덱스

        for (int i = 1; i <= date.getLastDay(); i++) {
            String currentDay = dates.get(dateIndex); // 현재 날짜 선택

            LinkedList<String> currentList;

            // 주말인지 평일인지 확인
            if (isWeekend(currentDay)) {
                currentList = weekendMembers;
            } else {
                currentList = weekdayMembers;
            }
            // 현재 근무자 선정
            String currentMember = currentList.removeFirst(); // 첫 번째 사람 뽑음

            // 연속 근무 검사
            if (currentMember.equals(lastAssigned)) {
                // 연속 근무 발생: 다음 사람으로 대체
                String nextMember = currentList.removeFirst(); // 다음 사람 뽑음
                System.out.printf("%s: %s (대신 근무)%n", currentDay, nextMember);

                // 현재 근무자를 다음 사람 뒤에 삽입
                currentList.add(0, currentMember); // 다음 사람 바로 뒤에 추가
                lastAssigned = nextMember; // 대체 근무자를 기록
            } else {
                // 정상적으로 근무
                System.out.printf("%d월 %d일 %s %s%n", this.date.getMonth(), i, dates.get(dateIndex), currentMember);
                currentList.addLast(currentMember); // 근무를 마친 사람은 뒤로 이동
                lastAssigned = currentMember;
            }
            dateIndex = (dateIndex + 1) % dates.size(); // 다음 날짜로 이동, 리스트 순환
        }
    }

    //5월 1일 월 준팍
    // 주말 여부를 판단하는 메서드 (예시)
    private boolean isWeekend(String date) {
        // 간단히 날짜 문자열로 주말 판단 (예: "토요일" 포함 여부로 판단)
        return date.contains("토") || date.contains("일");
    }


}
