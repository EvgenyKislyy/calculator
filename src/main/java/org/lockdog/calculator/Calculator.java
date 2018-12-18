package org.lockdog.calculator;

import java.util.Optional;
import java.util.Scanner;

public class Calculator {


    private static final String QUIT_COMMAND = "q";

    public static void main(String[] args) {


        (new Calculator()).calculate();

    }

    private void calculate() {
        NumbersService numbersService = new NumbersService();

        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals(QUIT_COMMAND)) {
            System.out.print(">");
            if (inputScanner.hasNext()) {
                userInput = inputScanner.nextLine().trim();

                if (!userInput.isBlank()) {
                    try {
                        Double number = Double.valueOf(userInput);
                        numbersService.add(number);
                        System.out.println(userInput);
                        continue;
                    } catch (NumberFormatException e) {
                        //e.printStackTrace();
                        //not a number, maybe it's sign
                    }

                    if (userInput.length() == 1) {
                        Optional<Operation> operation = Operation.fromCharacter(userInput.charAt(0));
                        if (operation.isPresent()) {


                            Double number1 = numbersService.getCurrent();
                            Double number2 = numbersService.getPrevious();

                            if (operation.get().equals(Operation.DIVIDE) && number2.equals(0.0)) {
                                System.err.println("Not possible to divide 0");
                                return;
                            }

                            Double result = operation.get().execute(number1, number2);
                            numbersService.add(result);
                            System.out.println(result);
                        }
                    }
                }
            } else {
                exit();
            }

        }
        exit();
    }

    private void exit() {
        System.out.println("Thanks for being with us");
        System.exit(0);
    }
}
