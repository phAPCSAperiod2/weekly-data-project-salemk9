import java.util.Scanner;

/**
 * Main application class for the Sleep Tracker program.
 * This program collects sleep data for 7 days and provides analysis
 * with recommendations for improving sleep on the user's worst sleep night.
 * 
 * @author Salem Kiar
 * @Collaborators: Copilot
 */
public class App {

    /**
     * Main entry point for the Sleep Tracker application.
     * 
     * This method performs the following operations:
     * 1. Initializes a Scanner for user input
     * 2. Displays program information to the user
     * 3. Creates arrays to store sleep data for each day of the week
     * 4. Collects sleep hours from the user with input validation
     * 5. Creates a WeeklyData object to analyze the collected data
     * 6. Displays analysis results (total, average, min, max sleep)
     * 7. Provides personalized sleep improvement recommendations
     *
     * 
     */
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

        // =====================================================================
        // Input Collection Loop: Collect sleep data for each day of the week
        // =====================================================================
        /**
         * Loops through each day of the week (0-6) to collect sleep hours.
         * For each day, uses input validation to ensure the user enters
         * a valid number between 0 and 24 hours.
         */
        for (int i = 0; i < 7; i++) {
            // Initialize sleepHours to -1 to force entry into the while loop
            double sleepHours = -1;
            
            /**
             * Input Validation Loop: Continues prompting until valid input is received.
             * The loop keeps running (sleepHours < 0) until a valid value (0-24) is entered.
             * This prevents invalid data from being stored in the weekData array.
             */
            while (sleepHours < 0) {
                // Prompt the user to enter sleep hours for the current day
                System.out.print("Enter hours of sleep for " + days[i] + ": ");
                
                // Check if the next input is a valid double (floating-point number)
                if (scanner.hasNextDouble()) {
                    // Read the double value from the scanner
                    sleepHours = scanner.nextDouble();
                    
                    /**
                     * Validate that sleepHours is non-negative (>= 0).
                     * If negative, set error message and keep sleepHours negative
                     * to force another loop iteration.
                     */
                    if (sleepHours < 0) {
                        System.out.println("Error: Sleep hours cannot be negative. Please try again.");
                    } 
                    /**
                     * Validate that sleepHours does not exceed 24 hours.
                     * If > 24, set error message and reset sleepHours to -1
                     * to force another loop iteration.
                     */
                    else if (sleepHours > 24) {
                        System.out.println("Error: Sleep hours cannot exceed 24. Please try again.");
                        sleepHours = -1;
                    }
                    // If sleepHours is between 0 and 24 (inclusive), it's valid
                    // and the while loop will exit
                } else {
                    /**
                     * Handle non-numeric input:
                     * If the input is not a valid number, display error message,
                     * clear the invalid input from the scanner buffer with nextLine(),
                     * and reset sleepHours to -1 to force another loop iteration.
                     */
                    System.out.println("Error: Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input from the scanner buffer
                    sleepHours = -1;
                }
            }
            // Store the validated sleep hours into the array at index i
            weekData[i] = sleepHours;
        }

        // =====================================================================
        // Create WeeklyData Object: Initialize with validated user input
        // =====================================================================
        /**
         * Instantiate a new WeeklyData object with the collected sleep data.
         * The WeeklyData constructor will make a deep copy of the weekData array,
         * 
         */
        WeeklyData sleepData = new WeeklyData(weekData);

        // =====================================================================
        // Display Sleep Analysis Results
        // =====================================================================
        /**
         * Display the statistical analysis of the user's sleep data.
         * This section outputs the total, average, maximum, and minimum
         * values calculated by the WeeklyData object.
         */
        System.out.println("\n===== Sleep Analysis =====");
        // Display total hours of sleep for the entire week
        System.out.println("Total sleep for the week: " + sleepData.getTotal() + " hours");
        // Display average sleep per night, formatted to 2 decimal places
        System.out.println("Average sleep per night: " + String.format("%.2f", sleepData.getAverage()) + " hours");
        // Display the maximum (best) sleep night
        System.out.println("Maximum sleep: " + sleepData.getMax() + " hours");
        // Display the minimum (worst) sleep night
        System.out.println("Minimum sleep: " + sleepData.getMin() + " hours");
        
        // =====================================================================
        // Display All Daily Sleep Values
        // =====================================================================
        /**
         * Output all individual daily sleep values using the toString()
         * method, which formats each day and its corresponding value.
         */
        System.out.println("\n===== All Daily Values =====");
        System.out.print(sleepData.toString());
        
        // =====================================================================
        // Find and Display the Worst Sleep Night
        // =====================================================================
        /**
         * Identify the day with the least amount of sleep.
         * getMinDay() returns the index (0-6) of the day with minimum sleep.
         * getMin() returns the actual number of hours slept that night.
         */
        int leastSleepDay = sleepData.getMinDay();
        double leastSleepHours = sleepData.getMin();
        
        // Display the day of the week with the worst sleep
        System.out.println("\nYour worst sleep night was: " + days[leastSleepDay]);
        // Display the number of hours slept that night
        System.out.println("You got only " + leastSleepHours + " hours of sleep.");
        
        // =====================================================================
        // Personalized Sleep Improvement Recommendations
        // =====================================================================
        /**
         * Provide targeted sleep improvement advice based on the worst
         * night's sleep duration. The recommendations are categorized by
         * severity level (severe deprivation, need more sleep, close to goal,
         * or already meeting recommendations).
         */
        System.out.println("\n--- Tips to Improve Sleep on " + days[leastSleepDay] + " ---");
        
        /**
         * CATEGORY 1: Severe Sleep Deprivation (< 4 hours)
         * If the user slept less than 4 hours, they experienced severe
         * sleep deprivation. Provide urgent recommendations.
         */
        if (leastSleepHours < 4) {
            System.out.println("• You had severe sleep deprivation. Prioritize:");
            System.out.println("  - Go to bed 30 minutes earlier");
            System.out.println("  - Eliminate all distractions 1 hour before bed");
            System.out.println("  - Avoid caffeine after 2 PM");
            System.out.println("  - Try melatonin or consult a sleep specialist");
        } 
        /**
         * CATEGORY 2: Need More Sleep (4-6 hours)
         * If the user slept 4-6 hours, they need more sleep.
         * Provide practical strategies to improve sleep consistency.
         */
        else if (leastSleepHours < 6) {
            System.out.println("• You need more sleep. Try these strategies:");
            System.out.println("  - Establish a consistent bedtime routine");
            System.out.println("  - Reduce screen time 30 minutes before bed");
            System.out.println("  - Keep your bedroom cool and dark");
            System.out.println("  - Avoid large meals close to bedtime");
        } 
        /**
         * CATEGORY 3: Close to Recommended Amount (6-7 hours)
         * If the user slept 6-7 hours, they're approaching the
         * recommended 7-9 hours. Small tweaks can help reach the goal.
         */
        else if (leastSleepHours < 7) {
            System.out.println("• You're close to the recommended amount. Small improvements:");
            System.out.println("  - Try going to bed 15 minutes earlier");
            System.out.println("  - Practice relaxation techniques like deep breathing");
            System.out.println("  - Limit interruptions during sleep hours");
        } 
        /**
         * CATEGORY 4: Meeting Recommendations (7+ hours)
         * If the user slept 7 or more hours, they're meeting
         * healthy sleep recommendations. Encourage consistency.
         */
        else {
            System.out.println("• You're meeting healthy sleep recommendations!");
            System.out.println("  - Keep up this sleep schedule on other nights too");
        }

        // =====================================================================
        // Close the Scanner Resource
        // =====================================================================
        /**
         * Close the Scanner to release the associated system resources.
         *
         */
        scanner.close();

    }
}
