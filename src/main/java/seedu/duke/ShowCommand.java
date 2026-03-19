package seedu.duke;

import seedu.duke.recordtype.Record;
import java.util.logging.Logger;

public class ShowCommand extends Command{
    private static final Logger logger = Logger.getLogger(ShowCommand.class.getName());
    int index;
    public ShowCommand(int index){
        this.index = index;
    }

    public static void printRecord(RecordList records, int index) {
        System.out.println(records.getRecord(index));
    }

    @Override
    public void execute(RecordList list) {
        logger.info("Executing ShowCommand with Index " + index);

        //Assert preconditions
        assert list != null : "RecordList should not be null";

        try {
            // Ensures index int is within bounds
            if (index < 0 || index >= list.getSize()) {
                logger.warning("Invalid Index");
                throw new IndexOutOfBoundsException("Invalid record index: " + index
                        + "\n Record List Size: " + list.getSize());
            }
            System.out.println(list.getRecord(index));
        } catch (Exception e) {
            logger.severe("Error executing ShowCommand: " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }

    }
}
