package oncall.domain.constant;

import oncall.global.exception.CustomException;
import oncall.global.exception.ErrorMessage;

import java.util.Arrays;

public enum Month {
    JAN("1"), FEB("2"), MARCH("3"), APRIL("4"), MAY("5"), JUNE("6"), JULY("7"),
    AUGUST("8"), SEP("9"), OCT("10"), NOV("11"), DEC("12");

    private final String name;

    Month(String name) {
        this.name = name;
    }

    public static Month from(String month) {
        return Arrays.stream(Month.values())
                .filter(element -> element.name().equals(month))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_INPUT_ERROR));
    }
}
