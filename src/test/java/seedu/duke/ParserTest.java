package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.duke.RecordType.*;
import seedu.duke.RecordType.Record;

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
    public void parse_findInput_returnsFindCommand() {
        Command command = Parser.parse("find java");
        assertInstanceOf(FindCommand.class, command);
        assertEquals("java", ((FindCommand) command).getKeyword());
    }

    @Test
    public void parse_findInputWithExtraSpaces_returnsFindCommand() {
        Command command = Parser.parse("find    java");
        assertInstanceOf(FindCommand.class, command);
        assertEquals("java", ((FindCommand) command).getKeyword());
    }

    @Test
    public void parse_findWithoutKeyword_returnsNull() {
        Command command = Parser.parse("find");
        assertNull(command);
    }

    @Test
    public void parse_unknownCommandInput_returnsNull() {
        Command command = Parser.parse("hello");
        assertNull(command);
    }

    @Test
    public void parse_validProjectInput() {
        Command command = Parser.parse(
                "project Capo CLI /role Developer /tech Java /from 2026-01 /to 2026-03"
        );

        assertInstanceOf(AddCommand.class, command);

        RecordList list = new RecordList();
        command.execute(list);

        Record record = list.getRecord(0);
        assertEquals("Capo CLI", record.toString());

    }
}