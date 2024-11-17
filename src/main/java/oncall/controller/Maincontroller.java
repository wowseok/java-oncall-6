package oncall.controller;

import oncall.service.OnCallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Maincontroller {
    private final OutputView outputView;
    private final OnCallService service;

    public Maincontroller(OnCallService service, OutputView outputView) {
        this.service = service;
        this.outputView = outputView;
    }

    public void run() {
        process(this::assignEmergencyWork);
        process(this::inputWeekdayWork);
        process(this::inputWeekendWork);
    }

    private void assignEmergencyWork() {
        outputView.printIntroMessage();
        service.setUp(InputView.readLine());
    }

    private void inputWeekdayWork(){
        outputView.printWeekdayWork();
        service.setUpMembers(InputView.readLine());
    }

    private void inputWeekendWork(){
        outputView.printWeekendWork();
        service.setUpMembers(InputView.readLine());
    }


    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            process(action);
        }
    }
}
