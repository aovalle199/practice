package HW1;


import java.awt.*;
// written by Andrea Ovalle
public class hw1_part2 {

    public static void stats(int[] numbers) {
        double mean=0;
        double median=0;
        double add=0;
        int mode=numbers[0];
        int maxCount=0;

        // checks if the numbers in the array are between 0-9
        for (int i: numbers){
            if (i >= 10) {
                System.out.println("Numbers in array are larger than 9, each number in the array must " +
                        "be between 0-9");
                // if the conditions are not met the mode, median and mean will not be computed
                System.exit(0);

            }
            // check if the numbers in the array are between 0-9 , if the number is negative
            else if (i < 0) {
                System.out.println("Numbers is less than cero");
                // if the conditions are not met the mode, median and mean will not be computed for the array
                System.exit(0);
            }}
        // Checks if th length of the array is not divisible by two, if this is true the median will be computed
        // by pulling the middle value of the array.
        if ((numbers.length % 2) != 0) {
            median = (numbers[numbers.length / 2]);
            System.out.printf("The Median of the array is:  %.1f %n", median);
        }
        else {
            // else if the length of the array is divisible by 2, then (n1 + n2 ) / 2.
            // n1 = middle_index /2 - 1, and n2 = middle_index / 2
            median = (numbers[(numbers.length / 2) -1] + numbers[numbers.length /2]) / 2.0;
            System.out.printf("The Median of the array is: %.1f %n", median);
        }
        // iterates through the array and adds the numbers
        for (int i: numbers) {
            add = add + i;
        }
        // computes the mean
        mean = add / numbers.length;
        System.out.printf("The Mean of the array is:  %.3f %n", mean);

        //  Iterates through the array numbers and tags each element with the variable 'value'
        for (int value : numbers) {
            // starts a count of the value in the array numbers
            int count = 1;
            // iterates through numbers an tags each element in the array with the variable 'number'
            for (int number : numbers) {
                // compares each 'number' in the array with the parent 'value' and counts them (count++)
                if (number == value) count++;
                // checks if the count is greater than maxCount
                if (count > maxCount) {
                    // when the count is greater than the maxCount, the mode will be set to value
                    mode = value;
                    // The maxCount is then set to count
                    maxCount = count;
                }
            }
        }

        System.out.println("The Mode of the arrays is:  " + mode);

        }


    public static void main(String[] args){
        int[] a = {2, 5, 5, 5, 7, 8, 8};
        int[] b = {2,2,4,4,4,7,8,8,8,8};
        // added an additional array to test if the conditions of the array are being met
        int[] c = {2, 5, 5, 5, 7, 8, 8, 9, 9, 8, 27};
        System.out.println();
        System.out.println("Array A");
        System.out.println();
        stats(a);

        System.out.println();
        System.out.println("Array B");
        System.out.println();
        stats(b);

        System.out.println();
        System.out.println("Array C");
        System.out.println();
        stats(c);
    }
}
