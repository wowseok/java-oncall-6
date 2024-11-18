package oncall.service;

import static java.lang.Integer.parseInt;

import oncall.domain.date.Date;
import oncall.util.Utility;

public class OnCallService {
    private Date date;
    private String [] weekdayMembers;
    private String [] weekendMembers;
    public void setMonthAndStartDay(String input) {
        String [] data = input.split(",",-1);
        Date.isValidDay(data[1]);
        this.date = Date.fromMonth(parseInt(data[0])); // 객체 가져오기.
    }

    public void setUpWeekdayMembers(String input){
        String [] weekdayMembers = Utility.commaSplit(input);
        for(String str : weekdayMembers){
            
        }
    }

    public void setUpWeekendMembers(String input){
        String [] weekendMembers = Utility.commaSplit(input);

    }




}
