package org.lockdog.calculator;

import java.util.Optional;
import java.util.Scanner;

public class Calculator {


    private static final String QUIT_COMMAND = "q";

    public static void main(String[] args) {


        (new Calculator()).calculate();

    }

    private void calculate() {
        NumbersService<Double> numbersService = new NumbersService<>();

        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals(QUIT_COMMAND)) {
            System.out.print(">");
            userInput = inputScanner.nextLine().trim();
            if (!userInput.isBlank()) {
                try {
                    Double number = Double.valueOf(userInput);
                    numbersService.add(number);
                    System.out.println(userInput);
                    continue;
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                    //not a number
                }

                if (userInput.length() == 1) {
                    Optional<Operation> operation = Operation.fromCharacter(userInput.charAt(0));
                    if (operation.isPresent()) {

                        Double number1 = numbersService.getCurrent().orElse(0.0);
                        Double number2 = numbersService.getPrevious().orElse(0.0);

                        Double result = operation.get().execute(number1, number2);
                        numbersService.add(result);
                        System.out.println(result);
                    }
                }
            }


        }
    }
}
