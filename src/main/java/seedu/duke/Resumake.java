package seedu.duke;

public class Resumake {
    private RecordList list;
    private final Ui ui;

    public Resumake() {
        ui = new Ui();
        list = new RecordList();
    }

    public void run() {
        ui.greetings();
        boolean isExit = false;
        while(!isExit) {
            String fullCommand = ui.readCommand();
            Command c = Parser.parse(fullCommand);
            c.execute(list);
            isExit = c.isExit();
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Resumake().run();
    }
}
