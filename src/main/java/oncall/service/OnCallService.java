package oncall.service;

import static java.lang.Integer.parseInt;

import oncall.domain.Date;

public class OnCallService {

    public void setUp(String input) {
        String [] data = input.split(",",-1);
        int month = parseInt(data[0]);
        int lastDay = Date.getLastDayOfMonth(parseInt(data[0]));
    }

    public void setUpMembers(String input){
        String [] members = input.split(",",-1);
        //return members;
    }


}
