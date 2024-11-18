package oncall.domain.schedule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SchedulerValidator {

    public static void weekMembersValidate(List<String> weekMembers) {
        checkUniqueMembers(weekMembers);
    }

    public static void weekendMembersValidate(List<String> weekMembers, List<String> weekendMembers) {
        checkUniqueMembers(weekMembers);
        checkContainMembers(weekMembers, weekendMembers);
    }

    public static void checkUniqueMembers(List<String> members) {
        Set<String> uniqueSet = new HashSet<>();
        for (String member : members) {
            if (!uniqueSet.add(member)) {
                throw new IllegalArgumentException("중복된 멤버가 있습니다: " + member);
            }
        }
    }

    public static void checkContainMembers(List<String> weekMembers, List<String> weekendMembers) {
        for (String member : weekMembers) {
            if (!weekendMembers.contains(member)) {
                throw new IllegalArgumentException("비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되어야 합니다");
            }
        }
    }
}
