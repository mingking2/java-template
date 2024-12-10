package template;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    public static int getInteger() {
        String input = Console.readLine();
        return parseInt(input);
    }

    private static int parseInt(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static String getString() {
        return Console.readLine();
    }

    public static List<String> getStringsUsingDelimiter(String delimiter) {
        String input = Console.readLine();
        validateNotEndDelimiter(input, delimiter);
        List<String> inputs = Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
        inputs.forEach(Reader::validateNotBlank);
        return inputs;
    }

    private static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNotEndDelimiter(String input, String delimiter) {
        if (input.endsWith(delimiter)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean getBoolean(String trueMessage, String falseMessage) {
        String input = Console.readLine();
        if (trueMessage.equals(input)) {
            return true;
        }
        if (falseMessage.equals(input)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

}
