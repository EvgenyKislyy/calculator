package org.lockdog.calculator;

import java.util.Optional;

public class Calculator {

    private InputOutput inputOutput = new ConsoleInputOutput();
    private NumbersService numbersService = new NumbersService();

    public static void main(String[] args) {
        (new Calculator()).calculate();
    }

    private void calculate() {
        System.out.println("Start calculator");

        while (inputOutput.hasNext()) {
            //continue until quit command or eof

            //receive the input string, and trying to split into the different arguments
            String[] newInput = inputOutput.readNext().trim().split(" ");

            for (int cnt = 0; cnt < newInput.length; cnt++) {
                if (!newInput[cnt].isBlank()) {
                    //lets try to parse the number,
                    if (!tryToParseTheNumber(newInput[cnt], newInput.length)) {
                        //  if no - lets try to parse math sign
                        tryToParseMathSign(newInput[cnt]);
                        // and if it was math sign - lets do the calculation
                    }
                }
            }

        }
        exit();
    }

    private boolean tryToParseMathSign(String userInput) {
        if (userInput.length() == 1) {
            Optional<Operation> operation = Operation.fromCharacter(userInput.charAt(0));
            if (operation.isPresent()) {
                //if it's math sign, then do calculation, if not - do nothing, waiting for next user input


                Double number2 = numbersService.getPrevious();

                if (operation.get().equals(Operation.DIVIDE) && number2.equals(0.0)) {
                    System.err.println("Not possible to divide 0");
                    return true;
                }

                Double number1 = numbersService.getCurrent();

                Double result = operation.get().execute(number1, number2);
                numbersService.add(result);
                inputOutput.print(result.toString());
                //calculating result, writing it to our numbers history, and printing to the console
                return true;
            }
        }
        return false;
    }

    /**
     * Try to parse the number from string
     *
     * @param userInput
     * @param length    prints the number if only it was the only one input
     * @return
     */
    private boolean tryToParseTheNumber(String userInput, int length) {
        try {
            //trying to parse the number
            Double number = Double.valueOf(userInput);
            numbersService.add(number);
            if (length == 1) {
                inputOutput.print(number.toString());
            }
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
