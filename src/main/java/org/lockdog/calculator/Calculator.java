package org.lockdog.calculator;

import java.util.Optional;

public class Calculator {

    private InputReader inputReader = new ConsoleInputReader();
    private NumbersService numbersService = new NumbersService();

    public static void main(String[] args) {
        (new Calculator()).calculate();
    }

    private void calculate() {
        System.out.println("Start calculator");

        while (inputReader.hasNext()) {
            //continue until quit command or eof

            String newInput = inputReader.readNext();

            if (!newInput.isBlank()) {
                if (tryToParseTheNumber(newInput)) {
                    //ok, it was number, let's read the next line
                } else {
                    //lets try maybe it's the math sign
                    //if yes - do calculation
                    tryToParseMathSign(newInput);
                }
            }


        }
        exit();
    }

    private void tryToParseMathSign(String userInput) {
        if (userInput.length() == 1) {
            Optional<Operation> operation = Operation.fromCharacter(userInput.charAt(0));
            if (operation.isPresent()) {
                //if it's math sign, then do calculation, if not - do nothing, waiting for next user input


                Double number2 = numbersService.getPrevious();

                if (operation.get().equals(Operation.DIVIDE) && number2.equals(0.0)) {
                    System.err.println("Not possible to divide 0");
                    return;
                }

                Double number1 = numbersService.getCurrent();

                Double result = operation.get().execute(number1, number2);
                numbersService.add(result);
                System.out.println(result);
                //calculating result, writing it to our numbers history, and printing to the console
            }
        }

    }

    private boolean tryToParseTheNumber(String userInput) {
        try {
            //trying to parse the number
            Double number = Double.valueOf(userInput);
            numbersService.add(number);
            System.out.println(userInput);
            return true;
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            //not a number, maybe it's math sign
        }
        return false;
    }

    private void exit() {
        System.out.println("Thanks for being with us");
        System.exit(0);
    }
}
