package oncall.service;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import oncall.domain.date.Date;
import oncall.domain.schedule.Scheduler;
import oncall.util.Utility;

public class OnCallService {

    private final Scheduler scheduler = Scheduler.getInstance();

    public void setMonthAndStartDay(String input) {
        String[] data = Utility.commaSplit(input);
        scheduler.setDate(Date.fromMonth(parseInt(data[0]), data[1]));
    }

    public void setUpWeekdayMembers(String input) {
        scheduler.addWeekdayMembers(Arrays.asList(Utility.commaSplit(input)));
    }

    public void setUpWeekendMembers(String input) {
        scheduler.addWeekendMembers(Arrays.asList(Utility.commaSplit(input)));

    }

}
