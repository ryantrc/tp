package seedu.duke;

import seedu.duke.RecordType.Record;

public class AddCommand extends Command{
    private final Record r;
    private final Ui ui = new Ui();

    public AddCommand(Record r) {
        this.r = r;
    }

    @Override
    public void execute(RecordList list) {
        list.add(r);
        ui.showLine();
        System.out.println(r.toString() + " added");
        ui.showLine();
    }
}
