import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("===== Sleep Tracker =====");
        System.out.println("Track your sleep hours for the past 7 days.");
        System.out.println();

        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------
        double[] weekData = new double[7];
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------
        for (int i = 0; i < 7; i++) {
            double sleepHours = -1;
            while (sleepHours < 0) {
                System.out.print("Enter hours of sleep for " + days[i] + ": ");
                if (scanner.hasNextDouble()) {
                    sleepHours = scanner.nextDouble();
                    if (sleepHours < 0) {
                        System.out.println("Error: Sleep hours cannot be negative. Please try again.");
                    }
                } else {
                    System.out.println("Error: Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // clear invalid input
                    sleepHours = -1;
                }
            }
            weekData[i] = sleepHours;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------
        WeeklyData sleepData = new WeeklyData(weekData);

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------
        System.out.println("\n===== Sleep Analysis =====");
        System.out.println("Total sleep for the week: " + sleepData.getTotal() + " hours");
        System.out.println("Average sleep per night: " + sleepData.getAverage() + " hours");
        System.out.println("Maximum sleep: " + sleepData.getMax() + " hours");
        System.out.println("Minimum sleep: " + sleepData.getMin() + " hours");


// still need to finish results display, need to include specific insights and recommendations
        System.out.println("\n===== Insights =====");

        // Close the scanner
        scanner.close();

    }
}
