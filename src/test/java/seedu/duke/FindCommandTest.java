package seedu.duke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindCommandTest {
    private final PrintStream originalOut = System.out;

    @AfterEach
    public void restoreSystemStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void execute_matchingRecords_printsMatches() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RecordList recordList = new RecordList();
        recordList.add(new Record("Java project"));
        recordList.add(new Record("Python internship"));
        recordList.add(new Record("Full stack Java app"));

        FindCommand findCommand = new FindCommand("java");
        findCommand.execute(recordList);

        String lineSeparator = System.lineSeparator();
        String expectedOutput = "--------------------" + lineSeparator
                + "Matching records:" + lineSeparator
                + "1. Java project" + lineSeparator
                + "2. Full stack Java app" + lineSeparator
                + "--------------------" + lineSeparator;

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void execute_noMatchingRecords_printsNoMatchMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RecordList recordList = new RecordList();
        recordList.add(new Record("Java project"));
        recordList.add(new Record("Python internship"));

        FindCommand findCommand = new FindCommand("golang");
        findCommand.execute(recordList);

        String lineSeparator = System.lineSeparator();
        String expectedOutput = "--------------------" + lineSeparator
                + "Matching records:" + lineSeparator
                + "No matching records found for keyword: golang" + lineSeparator
                + "--------------------" + lineSeparator;

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void execute_caseInsensitiveKeyword_printsMatches() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RecordList recordList = new RecordList();
        recordList.add(new Record("JAVA capstone"));

        FindCommand findCommand = new FindCommand("java");
        findCommand.execute(recordList);

        String lineSeparator = System.lineSeparator();
        String expectedOutput = "--------------------" + lineSeparator
                + "Matching records:" + lineSeparator
                + "1. JAVA capstone" + lineSeparator
                + "--------------------" + lineSeparator;

        assertEquals(expectedOutput, outputStream.toString());
    }
}