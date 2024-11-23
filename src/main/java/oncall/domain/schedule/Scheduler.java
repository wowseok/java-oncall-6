package oncall.domain.schedule;

import java.util.LinkedList;
import java.util.List;
import oncall.domain.date.DayOfWeek;
import oncall.domain.date.MonthInfo;
import oncall.domain.date.PublicHolidays;
import oncall.view.OutputView;

public class Scheduler {
    private static Scheduler instance; // 유일한 인스턴스
    private MonthInfo monthInfo;
    private DayOfWeek currentDay;
    private LinkedList<String> weekdayMembers;
    private LinkedList<String> weekendMembers;
    private String lastWorker;
    private OutputView outputView;

    // private 생성자: 외부에서 객체 생성 불가
    private Scheduler() {
        this.lastWorker = null;
        this.monthInfo = null;
        this.currentDay = null;
        this.weekdayMembers = new LinkedList<>();
        this.weekendMembers = new LinkedList<>();
        this.outputView = new OutputView();
    }


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

    public void setMonthInfo(MonthInfo monthInfo) {
        this.monthInfo = monthInfo;
    }

    public void setStartDay(DayOfWeek startDayOfWeek) {
        this.currentDay = startDayOfWeek;
    }


    public List<String> getWeekdayMembers() {
        return weekdayMembers;
    }

    public List<String> getWeekendMembers() {
        return weekendMembers;
    }

    public MonthInfo getMonthInfo() {
        return monthInfo;
    }

    public void assignDutySchedule() {
        for (int i = 1; i <= monthInfo.getLastDay(); i++) {
            // 현재 근무자 리스트 결정 (평일/주말)
            LinkedList<String> activeGroup = getActiveGroup(monthInfo, i);
            // 현재 근무자 선택
            String currentMember = activeGroup.removeFirst();
            // 일반 근무
            if (!currentMember.equals(lastWorker)) {
                isNormal(currentMember, activeGroup, i);
                continue;
            }
            //연속근무
            isConsecutive(currentMember, activeGroup, i);


        }

    }

    private void isNormal(String currentMember, LinkedList<String> activeGroup, int i) {

        // 정상 근무 처리
        outputView.printScheduler(currentMember, i, monthInfo, currentDay);
        activeGroup.addLast(currentMember); // 근무를 마친 사람은 리스트 뒤로 보냄
        lastWorker = currentMember;
        currentDay = currentDay.nextDay();

    }


    private void isConsecutive(String currentMember, LinkedList<String> activeGroup, int i) {
        if (currentMember.equals(lastWorker)) {
            String nextMember = activeGroup.removeFirst(); // 다음 근무자 선택
            outputView.printScheduler(nextMember, i, monthInfo, currentDay);
            // 현재 근무자를 다시 리스트에 추가
            activeGroup.addFirst(currentMember);
            lastWorker = nextMember;
            currentDay = currentDay.nextDay();
        }
    }

    private LinkedList<String> getActiveGroup(MonthInfo month, int day) {
        LinkedList<String> activeGroup = null;
        if (currentDay.isWeekend() || PublicHolidays.isHoliday(month.getMonth(), day)) {
            activeGroup = weekendMembers;
        }
        if (!currentDay.isWeekend() && !PublicHolidays.isHoliday(month.getMonth(), day)) {
            activeGroup = weekdayMembers;
        }
        return activeGroup;
    }
}
