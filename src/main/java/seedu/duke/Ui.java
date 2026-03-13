package seedu.duke;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showLine() {
        System.out.println("--------------------");
    }

    public void greetings() {
        showLine();
        System.out.println("Welcome to Resumake");
        showLine();
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLoadingError() {
        showLine();
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
