package seedu.duke;

import java.util.logging.Logger;
import seedu.duke.recordtype.Record;

public class ListCommand extends Command{
    private static final Logger logger = Logger.getLogger(ListCommand.class.getName());

    public ListCommand(){
    }


    @Override
    public void execute(RecordList list) {
        int indexCount = 0;

        //Assert preconditions
        assert list != null : "RecordList should not be null";

        System.out.println("Here is a list of all your records.");
        for (Record record : list){
            indexCount += 1;
            System.out.println(indexCount + ". " + record);
        }
    }
}
