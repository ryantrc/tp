package seedu.duke;

public class Parser {
    public static Command parse(String userInput) {
        String trimmedInput = userInput.trim();

        if (trimmedInput.isEmpty()) {
            return null;
        }

        String[] split = trimmedInput.split("\\s+", 2);
        String keyword = split[0].toLowerCase();

        switch (keyword) {
        case "bye":
            return new ExitCommand();

        case "find":
            if (split.length < 2 || split[1].trim().isEmpty()) {
                return null;
            }
            return new FindCommand(split[1]);

        default:
            return null;
        }
    }
}