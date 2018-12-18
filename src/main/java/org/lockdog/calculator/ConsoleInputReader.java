package org.lockdog.calculator;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    private static final String QUIT_COMMAND = "q";

    private Scanner inputScanner = new Scanner(System.in);

    private String currentLine;

    public String readNext() {
        return currentLine;
    }

    public Boolean hasNext() {
        System.out.print(">");
        if (inputScanner.hasNext()) {
            currentLine = inputScanner.nextLine().trim();
            return (!currentLine.equals(QUIT_COMMAND));
        } else {
            return false;
        }
    }
}
