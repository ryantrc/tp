package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.YearMonth;
import seedu.duke.RecordType.*;
import seedu.duke.RecordType.Record;

public class EditCommandTest {

    @Test
    public void execute_validIndex_recordDescriptionUpdated() {
        RecordList recordList = new RecordList();
        Record record = new Record(
                "Resumake CLI",
                "Developer",
                "Java",
                YearMonth.parse("2026-01"),
                YearMonth.parse("2026-03")
        );
        recordList.add(record);

        EditCommand editCommand = new EditCommand(0, "New description");
        editCommand.execute(recordList);

        assertEquals("New description", record.toString());
    }

    @Test
    public void execute_validIndexOnlyTargetRecordUpdated() {
        RecordList recordList = new RecordList();
        Record firstRecord = new Record(
                "firstRecord",
                "Developer",
                "Java",
                YearMonth.parse("2026-01"),
                YearMonth.parse("2026-03")
        );
        Record secondRecord = new Record(
                "secondRecord",
                "Developer",
                "Java",
                YearMonth.parse("2026-01"),
                YearMonth.parse("2026-03")
        );
        recordList.add(firstRecord);
        recordList.add(secondRecord);

        EditCommand editCommand = new EditCommand(1, "Updated second record");
        editCommand.execute(recordList);

        assertEquals("First record", firstRecord.toString());
        assertEquals("Updated second record", secondRecord.toString());
    }

    @Test
    public void execute_validIndex_sizeRemainsSame() {
        RecordList recordList = new RecordList();
        recordList.add(
                new Record(
                "secondRecord",
                "Developer",
                "Java",
                YearMonth.parse("2026-01"),
                YearMonth.parse("2026-03")
                )
        );

        EditCommand editCommand = new EditCommand(0, "Edited record one");
        editCommand.execute(recordList);

        assertEquals(1, recordList.getSize());
    }
}