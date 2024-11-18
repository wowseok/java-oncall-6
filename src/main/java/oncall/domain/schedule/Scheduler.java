package oncall.domain.schedule;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.date.Date;

public class Scheduler {
    private static Scheduler instance; // 유일한 인스턴스
    private Date date;
    private List<String> weekdayMembers;
    private List<String> weekendMembers;

    // private 생성자: 외부에서 객체 생성 불가
    private Scheduler() {
        this.date = null;
        this.weekdayMembers = new ArrayList<>();
        this.weekendMembers = new ArrayList<>();
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
        this.weekdayMembers = members;
    }

    public void addWeekendMembers(List<String> members) {
        SchedulerValidator.weekendMembersValidate(members, this.weekdayMembers);
        this.weekendMembers = members;
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


}
