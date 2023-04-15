/**
 The ConsoleCalculator class creates a console calculator object that allows users to perform basic math operations.
 */

import java.util.Scanner;

public class ConsoleCalculator implements Helpable {
    /**
     The calculator() method runs the calculator, prompting the user for input and outputting the result of the calculation.
     The user can continue to perform calculations until they choose to exit the program.
     */
    public void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the MathWiz!");
        System.out.println("Enter 'help' for help at any time: ");

        //Boolean to continue
        boolean continueCalculating = true;
        while (continueCalculating) {

            System.out.print("Enter the first number: ");
            String operandNumberString = ScannerProcessDouble.getString(scanner);
            if (operandNumberString.equalsIgnoreCase("help")) {
                this.printHelp();
                continue;
            }

            String operatorString = "";
            while (true) {
                System.out.print("Enter an operation (+, -, *, /, ^, r, %): ");
                operatorString = scanner.nextLine().trim();
                if (operatorString.equalsIgnoreCase("help")) {
                    this.printHelp();
                    continue;
                }
                try {
                    Operators op = Operators.onlySymbol(operatorString);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid operator, please try again.");
                }
            }

            System.out.print("Enter a second number: ");
            String secondNumberString = ScannerProcessDouble.getString(scanner);

            if (operandNumberString == null || operatorString.isEmpty() || secondNumberString == null) {
                continue;
            }
            else if (secondNumberString.equalsIgnoreCase("help")) {
                this.printHelp();
            }
            double operandNumber = Double.parseDouble(operandNumberString);
            double operatorNumber = Double.parseDouble(secondNumberString);

            //handling operators from enum with switch and case

            Operators operators;
            switch (operatorString) {
                case "+":
                    operators = Operators.ADD;
                    break;
                case "-":
                    operators = Operators.SUBTRACT;
                    break;
                case "*":
                    operators = Operators.MULTIPLY;
                    break;
                case "/":
                    operators = Operators.DIVIDE;
                    break;
                case "^":
                    operators = Operators.POWER;
                    break;
                case "r":
                    operators = Operators.ROOT;
                    break;
                case "%":
                    operators = Operators.MODULUS;
                    break;
                default:
                    System.out.println("Invalid operator, please try again.");
                    return;
            }
            double result = operators.calculate(operandNumber, operatorNumber);
            System.out.println("The result is: " + result);
            System.out.println();

            System.out.print("Would you like to continue? (y/n): ");
            String continueString = scanner.nextLine().trim();
            if (!continueString.equalsIgnoreCase("y")) {
                continueCalculating = false;
            }
        }

        scanner.close();
    }

public void printHelp() {

 System.out.println("MathWiz Help");
 System.out.println("Supported operations: +, -, *, /, ^, r, %");
 System.out.println("To use Pi, enter 'pi'");
 System.out.println("To use e as a number, enter 'e'");
 System.out.println("To display this help message again, enter 'help'");
 System.out.println();

 }
}