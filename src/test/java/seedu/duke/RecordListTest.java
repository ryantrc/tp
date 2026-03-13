package seedu.duke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordListTest {
    @Test
    public void add_record_addedToList_sizeIncreases() {
        RecordList recordList = new RecordList();
        Record record = new Record("Test record");

        recordList.add(record);

        assertEquals(1,recordList.getSize());
        assertEquals(record, recordList.getRecord(0));
    }
}
