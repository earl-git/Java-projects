// Pearl De Mello
import java.util.Scanner;

public class PresentValueCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for future value
        System.out.print("What is the desired future value? ");
        double future_value = input.nextDouble();

        // annual interest rate
        System.out.print("What is the annual interest rate? ");
        double annual_interest_rate = input.nextDouble();

        // number of years
        System.out.print("For how many years? ");
        int years = input.nextInt();

        // Calculate present value
        double present_value = presentValue(future_value, annual_interest_rate, years);

        System.out.printf("You need to invest $%.2f%n", present_value);

        // Close the scanner
        input.close();
    }

    // Method to calc present value
    public static double presentValue(double future_value, double annual_interest_rate, int years) {
        return future_value / Math.pow(1 + annual_interest_rate, years);
    }
}