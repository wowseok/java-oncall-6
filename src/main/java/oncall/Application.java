package oncall;

import oncall.controller.Maincontroller;
import oncall.service.OnCallService;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Maincontroller maincontroller = new Maincontroller(new OnCallService(), new OutputView());
        maincontroller.run();
    }
}
