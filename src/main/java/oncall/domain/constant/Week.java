package oncall.domain.constant;

import oncall.global.exception.CustomException;
import oncall.global.exception.ErrorMessage;

import java.util.Arrays;

public enum Week {
    MONDAY("월"), TUESDAY("화"), WEDNESDAY("수"), THURSDAY("목"), FRIDAY("금"), SATURDAY("토"), SUNDAY("일");

    private final String name;

    Week(String name) {
        this.name = name;
    }

    public static Week from(String week) {
        return Arrays.stream(Week.values())
                .filter(element -> element.name().equals(week))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_INPUT_ERROR));
    }
}
