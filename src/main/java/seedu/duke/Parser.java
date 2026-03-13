package seedu.duke;

public class Parser {
    public static Command parse (String userInput) {
        String[] split = userInput.split(" ");
        String keyword = split[0].toLowerCase();
        Record r;

        switch(keyword) {
        case "bye":
            return new ExitCommand();
        default:
            return null;
        }
    }
}
