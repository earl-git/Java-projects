// Pearl De Mello
import java.util.Scanner;

public class TestAvgandGrade {
    // return average of test scores
    public static double calcAverage(double s1, double s2, double s3, double s4, double s5) {
        return (s1 + s2 + s3 + s4 + s5) / 5;
    }

    // determine letter grade based on score
    public static String determineGrade(double score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // input for 5 test scores
        System.out.print("Enter the first test score: ");
        int score1 = input.nextInt();
        System.out.print("Enter the second test score: ");
        int score2 = input.nextInt();
        System.out.print("Enter the third test score: ");
        int score3 = input.nextInt();
        System.out.print("Enter the fourth test score: ");
        int score4 = input.nextInt();
        System.out.print("Enter the fifth test score: ");
        int score5 = input.nextInt();

        double average = calcAverage(score1, score2, score3, score4, score5);

        System.out.println("Here are the grades and the average:");
        System.out.printf("Test 1: %s%n", determineGrade(score1));
        System.out.printf("Test 2: %s%n", determineGrade(score2));
        System.out.printf("Test 3: %s%n", determineGrade(score3));
        System.out.printf("Test 4: %s%n", determineGrade(score4));
        System.out.printf("Test 5: %s%n", determineGrade(score5));
        System.out.printf("Average score: %.2f%n", average);
        System.out.println("Average Letter Grade: " + determineGrade(average));
        
        // gives me a resource leak error if i dont close scanner input
        input.close();
    }

}
