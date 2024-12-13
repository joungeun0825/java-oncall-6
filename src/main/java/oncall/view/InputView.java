package oncall.view;

import oncall.domain.WorkDate;
import oncall.global.exception.ErrorMessage;
import oncall.global.validator.InputValidator;
import oncall.view.console.ConsoleReader;
import oncall.view.console.ConsoleWriter;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String SEPARATOR = ",";

    public WorkDate readDate() {
        ConsoleWriter.printlnMessage("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
        return processDate(ConsoleReader.enterMessage(), SEPARATOR);
    }

    private static WorkDate processDate(String message, String separator) {
        List<String> date = Arrays.asList(split(message, separator));
        InputValidator.checkBound(date.size(),2,2, ErrorMessage.INVALID_INPUT_ERROR.getMessage());
        return new WorkDate(date);
    }

    private static String[] split(String message, String separator) {
        return message.split(separator, -1);
    }
}
