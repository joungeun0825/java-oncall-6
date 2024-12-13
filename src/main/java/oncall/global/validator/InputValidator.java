package oncall.global.validator;

public class InputValidator {
    public static void checkBound(int value, int min, int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
