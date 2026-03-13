package seedu.duke;

public abstract class Command {
    public abstract void execute(RecordList list);

    public boolean isExit() {
        return false;
    }
}
