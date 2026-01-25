/**
 * The WeeklyData class stores and analyzes a week’s worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * or any other measurable daily value.
 * 
 * The class provides methods to calculate and retrieve statistical information
 * about the weekly data, including total, average, minimum, and maximum values.
 * @author Salem Kiar
 * @Collaborators: Copilot
 */
public class WeeklyData {

    // =====================================================================
    // Instance Variables
    // =====================================================================
    
    /**
     * Array storing the weekly data values.
     * Contains 7 elements representing data for each day of the week.
     */
    private double[] array;
    

    // =====================================================================
    // Constructor
    // =====================================================================
    
    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     * 
     * This constructor ensures data independence by copying values rather
     * than storing a reference to the input array, preventing external
     * modifications from affecting the stored data.
     *
     * @param input an array representing 7 days of data
     */
    public WeeklyData(double[] input) {
        // Create a new array with the same length as the input array
        // This ensures we have our own independent copy of the data
        array = new double[input.length];
        
        /**
         * Deep Copy Loop: Copy each value from the input array
         * to the internal array element-by-element.
         * This prevents aliasing (where both variables point to the same array).
         */
        for (int i = 0; i < input.length; i++) {
            // Copy the value at index i from input to our internal array
            array[i] = input[i];
        }
    }


    // =====================================================================
    // getTotal
    // =====================================================================
    
    /**
     * Calculates and returns the total (sum) of all values in the week.
     * 
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        /**
         * Initialize a total variable to accumulate the sum.
         * Starting at 0 ensures we add all values without any prior offset.
         */
        int total = 0;
        
        /**
         * Summation Loop: Iterate through each element in the array
         * and add its value to the running total.
         */
        for (int i = 0; i < array.length; i++) {
            // Add the current element's value to the total
            total += array[i];
        }
        
        // Return the calculated sum of all values
        return total;
    }


    // =====================================================================
    // getAverage
    // =====================================================================
    
    /**
     * Calculates and returns the average (mean) value for the week.
     * 
     * The average is calculated by dividing the total sum by the number
     * of data points. If the array is empty, returns 0.0.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        /**
         * Edge Case Check: If the array is empty, return 0.0.
         * This prevents a division by zero error that would occur
         * when trying to calculate average with no data points.
         */
        if (array.length == 0) {
            return 0.0;
        }

        // Initialize a sum variable to accumulate all values
        int sum = 0;
        
        /**
         * Summation Loop: Iterate through all elements and calculate the total.
         * This is the numerator for our average calculation.
         */
        for (int i = 0; i < array.length; i++) {
            // Add the current element's value to the running sum
            sum += array[i];
        }
        
        /**
         * Average Calculation: Divide the sum by the number of elements.
         * Cast sum to double to ensure floating-point division
         * (not integer division, which would lose decimal places).
         */
        double average = (double) sum / array.length;
        
        // Return the calculated average value
        return average;
    }


    // =====================================================================
    // getMax
    // =====================================================================
    
    /**
     * Finds and returns the highest (maximum) value in the data array.
     * 
     * Iterates through all values in the array to find and return the
     * largest value stored.
     *
     * @return the maximum value in the data array
     */
    public double getMax() {
        /**
         * Initialize max with the smallest possible double value.
         * This ensures that any real value in the array will be larger
         * and will replace this initial value.
         */
        double max = Integer.MIN_VALUE; 
        
        /**
         * Maximum Finding Loop: Compare each element against the current maximum.
         * If the current element is greater than max, update max to that value.
         */
        for (int i = 0; i < array.length; i++) {
            // If the current element is larger than max, update max
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        // Return the largest value found in the array
        return max;
    }


    // =====================================================================
    // getMin
    // =====================================================================
    
    /**
     * Finds and returns the lowest (minimum) value in the data array.
     * 
     * Iterates through all values in the array to find and return the
     * smallest value stored.
     *
     * @return the minimum value in the data array
     */
    public double getMin() {
        /**
         * Initialize min with the largest possible double value.
         * This ensures that any real value in the array will be smaller
         * and will replace this initial value.
         */
        double min = Integer.MAX_VALUE; 
        
        /**
         * Minimum Finding Loop: Compare each element against the current minimum.
         * If the current element is less than min, update min to that value.
         */
        for (int i = 0; i < array.length; i++) {
            // If the current element is smaller than min, update min
            if (array[i] < min) {
                min = array[i];
            }
        }
        
        // Return the smallest value found in the array
        return min;
    }


    // =====================================================================
    // getMinDay
    // =====================================================================
    
    /**
     * Finds and returns the index (day number) of the day with the minimum value.
     * 
     * This method identifies which day of the week had the smallest data value
     * and returns its zero-indexed position (0 = first day, 6 = last day).
     *
     * @return the index (0-6) of the day with the minimum value,
     *         or -1 if the array is empty
     */
    public int getMinDay() {
        /**
         * Edge Case Check: If the array is empty, return -1.
         * This indicates that no valid index exists.
         */
        if (array.length == 0) {
            return -1;
        }
        
        /**
         * Initialize minIndex to 0, assuming the first element
         * is at the minimum value. We'll update this as we find smaller values.
         */
        int minIndex = 0;
        
        /**
         * Minimum Day Finding Loop: Start from index 1 and compare
         * each element against the element at minIndex.
         * When we find a smaller value, update minIndex to that position.
         */
        for (int i = 1; i < array.length; i++) {
            // If the current element is smaller than the value at minIndex,
            // update minIndex to point to the current element
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        
        // Return the index of the day with the minimum value
        return minIndex;
    }

    // =====================================================================
    // toString
    // =====================================================================
    
    /**
     * Returns a formatted, multi-line String showing each day's data value.
     * 
     * Each line displays a day number (1-7) followed by its corresponding
     * data value. This is useful for displaying all weekly data in a
     * readable format.
     *
     * Example output:
     * <pre>
     * Day 1: 8.5
     * Day 2: 7.0
     * Day 3: 6.5
     * Day 4: 9.0
     * Day 5: 7.5
     * Day 6: 8.0
     * Day 7: 7.0
     * 
     *
     * @return a formatted String representing the week's data with each
     *         day on a separate line
     */
    @Override
    public String toString() {
        /**
         * Initialize an empty String to accumulate the formatted output.
         * We'll append each day's information to this string.
         */
        String dayFormat = "";
        
        /**
         * String Building Loop: Iterate through each element in the array
         * and format it with the day number and corresponding value.
         */
        for (int i = 0; i < array.length; i++) {
            // Append a line with format "Day X: Y" where X is the day number (1-7)
            // and Y is the value.
            dayFormat += "Day " + (i + 1) + ": " + array[i] + "\n";
        }
        
        // Return the complete formatted string with all days and values
        return dayFormat;
    }
}
