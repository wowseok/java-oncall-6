package oncall.domain.schedule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SchedulerValidator {

    private static final int MINMUM_MEMBERS = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MAXIMUM_MEMBERS = 35;

    public static void weekMembersValidate(List<String> weekMembers) {
        checkUniqueMembers(weekMembers);
        checkMinimumMembers(weekMembers);
        checkMemberNameSize(weekMembers);
        checkMaximumMembers(weekMembers);
    }

    public static void weekendMembersValidate(List<String> weekMembers, List<String> weekendMembers) {
        checkUniqueMembers(weekendMembers);
        checkContainMembers(weekMembers, weekendMembers);
        checkMinimumMembers(weekendMembers);
        checkMemberNameSize(weekendMembers);
        checkMaximumMembers(weekendMembers);
    }

    public static void checkUniqueMembers(List<String> members) {
        Set<String> uniqueSet = new HashSet<>();
        for (String member : members) {
            if (!uniqueSet.add(member.trim())) {
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

    public static void checkMinimumMembers(List<String> members) {
        if (members.size() < MINMUM_MEMBERS) {
            throw new IllegalArgumentException("최소근무자는 5명 이상이어야 합니다.");
        }
    }

    public static void checkMemberNameSize(List<String> members) {
        for (String member : members) {
            if (member.length() > MAXIMUM_NAME_LENGTH) {
                throw new IllegalArgumentException("근무자의 닉네임 길이는 최대 5자입니다.");
            }
        }
    }

    public static void checkMaximumMembers(List<String> members) {
        if (members.size() > MAXIMUM_MEMBERS) {
            throw new IllegalArgumentException("최대 근무자는 35명이 넘지 않아야 합니다.");
        }
    }
}
