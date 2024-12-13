package oncall.view;

import oncall.domain.DayOffWorkers;
import oncall.domain.DayOnWorkers;
import oncall.domain.WorkDate;
import oncall.domain.Workers;
import oncall.global.exception.ErrorMessage;
import oncall.global.validator.InputValidator;
import oncall.view.console.ConsoleReader;
import oncall.view.console.ConsoleWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = ",";

    public WorkDate readDate() {
        ConsoleWriter.printMessage("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return processDate(ConsoleReader.enterMessage(), SEPARATOR);
    }

    public Workers readWorkers() {
        DayOnWorkers dayOnWorkers = new DayOnWorkers(readDayOnNames());
        DayOffWorkers dayOffWorkers = new DayOffWorkers(readDayOffNames());
        return new Workers(dayOnWorkers, dayOffWorkers);
    }

    private List<String> readDayOnNames() {
        ConsoleWriter.printMessage("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return processNames(ConsoleReader.enterMessage(), SEPARATOR);
    }

    private List<String> readDayOffNames() {
        ConsoleWriter.printMessage("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return processNames(ConsoleReader.enterMessage(), SEPARATOR);
    }

    private static WorkDate processDate(String message, String separator) {
        List<String> date = Arrays.asList(split(message, separator));
        InputValidator.checkBound(date.size(), 2, 2, "월과 요일만 입력하셔야 됩니다.");
        return new WorkDate(date);
    }

    private static List<String> processNames(String message, String separator) {
        List<String> persons = Arrays.stream(split(message, separator))
                .map(name -> {
                    InputValidator.checkBound(name.length(), 1, 5, ErrorMessage.INVALID_INPUT_ERROR.getMessage());
                    return name;
                })
                .collect(Collectors.toList());
        InputValidator.checkBound(persons.size(), 5, 35, ErrorMessage.INVALID_INPUT_ERROR.getMessage());
        InputValidator.checkForDuplicates(persons, ErrorMessage.INVALID_INPUT_ERROR.getMessage());
        return persons;
    }

    private static String[] split(String message, String separator) {
        return message.split(separator, -1);
    }
}
