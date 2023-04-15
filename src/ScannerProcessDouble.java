/**
 * Creates methods for validating and converting user input
 * strings to double
 *
 */

import java.util.Scanner;

public class ScannerProcessDouble implements Helpable {

    /**
     * @param inputString the string to be parsed
     * @return the input string as a double, null
     */
    public static String confirmDouble(String inputString) {

        String doubleToStringReturnValue = "";
        try {
            double parseDoubleResult = Double.parseDouble(inputString);
            doubleToStringReturnValue = Double.toString(parseDoubleResult);
        } catch (NullPointerException e) {
            doubleToStringReturnValue = null;
        } catch (NumberFormatException e) {
            doubleToStringReturnValue = null;
        } catch (Exception e) {
            doubleToStringReturnValue = null;
        }
        return doubleToStringReturnValue;
    }

    /**
     * @param calculatorInput pi, e, help, validated double, loops until valid
     * @return valid double including pi and e, help information
     */
    public static String getString(Scanner calculatorInput) {
        String confirmDoubleResult = "";
        ScannerProcessDouble scannerHelp = new ScannerProcessDouble();
        while (true) {
            String preNumberString = calculatorInput.nextLine();
            if (preNumberString.trim().equalsIgnoreCase("PI")) {
                confirmDoubleResult = String.valueOf(Math.PI);
                break;
            } else if (preNumberString.trim().equalsIgnoreCase("E")) {
                confirmDoubleResult = String.valueOf(Math.E);
                break;
            } else if (preNumberString.trim().equalsIgnoreCase("help")) {
                scannerHelp.printHelp();
            } else {
                confirmDoubleResult = confirmDouble(preNumberString);
                if (confirmDoubleResult != null) {
                    break;
                } else {
                    System.out.println("You have entered an invalid entry, please try again.");
                }
            }
        }
        return confirmDoubleResult;
    }
    @Override
    public void printHelp() {

        System.out.println("MathWiz Help");
        System.out.println("Supported operations: +, -, *, /, ^, r, %");
        System.out.println("To use Pi, enter 'pi'");
        System.out.println("To use e as a number, enter 'e'");
        System.out.println("To display this help message again, enter 'help'");
        System.out.println();

    }
}