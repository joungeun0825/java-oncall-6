package oncall.controller;

import oncall.domain.WorkDate;
import oncall.view.InputView;
import oncall.view.OutputView;
import oncall.view.console.ConsoleWriter;

import java.util.function.Supplier;

public class OnCallController {
    private final InputView inputView;
    private final OutputView outputView;

    public OnCallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        WorkDate workDate = readDate();
    }

    private WorkDate readDate() {
        return retry(() -> {
            return inputView.readDate();
        });
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }

}
