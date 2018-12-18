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
            parseInput(inputOutput.readNext());
        }
        exit();
    }

    protected void parseInput(String inputString) {
        //receive the input string, and trying to split into the different arguments
        String[] newInput = inputString.trim().split(" ");
        for (String argument : newInput) {
            if (argument.isBlank()) {
                continue;
            }
            //lets try to parse the number, and print it if it's the only one argument in input
            if (!tryToParseTheNumber(argument, newInput.length == 1)) {
                //  if no - lets try to parse math sign
                tryToParseMathSign(argument);
                // and if it was math sign - lets do the calculation
            }
        }
    }

    protected boolean tryToParseMathSign(String input) {
        if (input.length() == 1) {
            Optional<Operation> operation = Operation.fromCharacter(input.charAt(0));
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
     * @param input
     * @param printBack should it print back the number?
     * @return
     */
    protected boolean tryToParseTheNumber(String input, boolean printBack) {
        try {
            //trying to parse the number
            Double number = Double.valueOf(input);
            numbersService.add(number);
            if (printBack) {
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


    public void setNumbersService(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

}
