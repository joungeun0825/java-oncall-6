package oncall.global.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void checkBound(int value, int min, int max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkForDuplicates(List<String> items, String errorMessage) {
        Set<String> uniqueItems = new HashSet<>();
        for (String item : items) {
            if (!uniqueItems.add(item)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
