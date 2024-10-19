// Pearl De Mello
import java.util.Scanner;

public class ConversionProgram {
    // display the menu
    public static void menu() {
        System.out.println("1. Convert to kilometers");
        System.out.println("2. Convert to inches");
        System.out.println("3. Convert to feet");
        System.out.println("4. Quit the program");
    }

    // distance in kilometers
    public static void showKilometers(double meters) {
        double kilometers = meters * 0.001;
        System.out.printf("%.0f meters is %.1f kilometers.%n", meters, kilometers);
    }

    // distance in inches
    public static void showInches(double meters) {
        double inches = meters * 39.37;
        System.out.printf("%.0f meters is %.1f inches.%n", meters, inches);
    }

    // distance in feet
    public static void showFeet(double meters) {
        double feet = meters * 3.281;
        System.out.printf("%.0f meters is %.1f feet.%n", meters, feet);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double meters;
        int user_choice;

        // prompt user to enter distance in meters
        do {
            System.out.print("Enter a distance in meters: ");
            meters = input.nextDouble();

            // error check if negative for meters
            if (meters < 0) {
                System.out.println("Distance in meters must be non-negative.");
            }
        } while (meters < 0);

        // then display the menu
        do {
            menu();
            System.out.print("Enter your choice: ");
            user_choice = input.nextInt();
            
            // error check for user's input
            while (user_choice < 1 || user_choice > 4) {
                System.out.print("Invalid choice. Enter your choice: ");
                user_choice = input.nextInt();
            }

            // Process the user's choice
            switch (user_choice) {
                case 1:
                    showKilometers(meters);
                    break;
                case 2:
                    showInches(meters);
                    break;
                case 3:
                    showFeet(meters);
                    break;
                case 4:
                    System.out.println("Bye!");
                    break;
            }
        
        } while (user_choice != 4);

        // gives me a resource leak error if i dont close scanner input
        input.close();
    }
}

