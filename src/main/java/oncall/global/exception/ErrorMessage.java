package oncall.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    INVALID_INPUT_ERROR("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    INVALID_INPUT_WEEK_ERROR("유효하지 않은 요일입니다. 다시 입력해 주세요."),
    INVALID_INPUT_MONTH_ERROR("유효하지 않은 달입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}