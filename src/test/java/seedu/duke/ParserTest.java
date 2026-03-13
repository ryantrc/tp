package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    public void parse_byeInput_returnsExitCommand() {
        Command command = Parser.parse("bye");
        assertInstanceOf(ExitCommand.class, command);
        assertTrue(command.isExit());
    }

    @Test
    public void parse_mixedCaseByeInput_returnsExitCommand() {
        Command command = Parser.parse("ByE");
        assertInstanceOf(ExitCommand.class, command);
    }

    @Test
    public void parse_unknownCommandInput_returnsNull() {
        Command command = Parser.parse("hello");
        assertNull(command);
    }
}
