import java.util.Scanner;

/**
 * Main application class for the Sleep Tracker program.
 * This program collects sleep data for 7 days and provides analysis
 * with recommendations for improving sleep on the user's worst sleep night.
 * 
 * @author Student
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
        System.out.println("Average sleep per night: " + String.format("%.2f", sleepData.getAverage()) + " hours");
        System.out.println("Maximum sleep: " + sleepData.getMax() + " hours");
        System.out.println("Minimum sleep: " + sleepData.getMin() + " hours");
        
        System.out.println("\n===== All Daily Values =====");
        System.out.print(sleepData.toString());
        
        int leastSleepDay = sleepData.getMinDay();
        double leastSleepHours = sleepData.getMin();
        
        System.out.println("\nYour worst sleep night was: " + days[leastSleepDay]);
        System.out.println("You got only " + leastSleepHours + " hours of sleep.");
        
        System.out.println("\n--- Tips to Improve Sleep on " + days[leastSleepDay] + " ---");
        if (leastSleepHours < 4) {
            System.out.println("• You had severe sleep deprivation. Prioritize:");
            System.out.println("  - Go to bed 30 minutes earlier");
            System.out.println("  - Eliminate all distractions 1 hour before bed");
            System.out.println("  - Avoid caffeine after 2 PM");
            System.out.println("  - Try melatonin or consult a sleep specialist");
        } else if (leastSleepHours < 6) {
            System.out.println("• You need more sleep. Try these strategies:");
            System.out.println("  - Establish a consistent bedtime routine");
            System.out.println("  - Reduce screen time 30 minutes before bed");
            System.out.println("  - Keep your bedroom cool and dark");
            System.out.println("  - Avoid large meals close to bedtime");
        } else if (leastSleepHours < 7) {
            System.out.println("• You're close to the recommended amount. Small improvements:");
            System.out.println("  - Try going to bed 15 minutes earlier");
            System.out.println("  - Practice relaxation techniques like deep breathing");
            System.out.println("  - Limit interruptions during sleep hours");
        } else {
            System.out.println("• You're meeting healthy sleep recommendations!");
            System.out.println("  - Keep up this sleep schedule on other nights too");
        }

        // Close the scanner
        scanner.close();

    }
}
