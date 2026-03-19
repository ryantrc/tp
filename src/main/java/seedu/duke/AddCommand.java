package seedu.duke;

import seedu.duke.recordtype.Record;

public class AddCommand extends Command{
    private final Record r;
    private final Ui ui = new Ui();

    public AddCommand(Record r) {
        this.r = r;
    }

    @Override
    public void execute(RecordList list) {
        //Assert preconditions
        assert list != null : "RecordList should not be null";
        assert r != null : "Record should not be null";
        assert r.getTitle() != null && !r.getTitle().isEmpty()
                : "Record Title should not be empty";

        list.add(r);
        ui.showLine();
        System.out.println("[" + r.getRecordType() + "] "
                + r.getTitle() + " added");
        ui.showLine();
    }
}
