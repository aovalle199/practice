package HW5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HW5 {
    // Finds the counts of different byte in two arrays
    public static int recursiveDifference(char[] m, char[] m2, int index) {

        if ( index > m.length - 1) {
            return 0;
        }
        // if index is different in the other array, add a value to the index and count
        else if (m[index] != m2[index]){ return recursiveDifference(m, m2, index + 1) + 1 ; }
        // otherwise continue going through the index
        return  recursiveDifference(m, m2, index + 1) ;
    }
    
    public static double recursiveAverage(double[] m, int index) {
        // declare the type for average
        double avg ;
        // total counts for each index is added to index
        avg = m[index] / m.length;
        if (index == 0) {
            return avg ;
        }
        // will return when doesn't reach cero and will add the result of average
        return recursiveAverage(m, index - 1) + avg ;
    }


    public static void main(String[] args) {

        char[] bitPattern1 = {'0', '0', '1', '0', '1', '1', '0', '1'};
        char[] bitPattern2 = {'0', '1', '1', '1', '1', '0', '0', '1'};

        int d = recursiveDifference(bitPattern1, bitPattern2, 0);

        System.out.println("Bit pattern 1: " + Arrays.toString(bitPattern1));
        System.out.println("Bit pattern 2: " + Arrays.toString(bitPattern2));
        System.out.println("Difference between the two bit patterns is: " + d);


        char[] bitPattern3 = {'1', '0', '1', '0', '0', '1', '1', '1', '0', '0', '1'};
        char[] bitPattern4 = {'0', '0', '0', '0', '1', '1', '0', '0', '1', '1', '1'};

        d = recursiveDifference(bitPattern3, bitPattern4, 0);

        System.out.println();
        System.out.println("Bit pattern 3: " + Arrays.toString(bitPattern3));
        System.out.println("Bit pattern 4: " + Arrays.toString(bitPattern4));
        System.out.println("Difference between the two bit patterns is: " + d);

        double[] numbers1 = {15.0, 3.0, 12.0, 27.0, 48.0};
        double[] numbers2 = {10.0, 31.0, 68.0, 72.0, 56.0, 90.0, 82.0};
        double avg1 = recursiveAverage(numbers1,  4);
        double avg2 = recursiveAverage(numbers2, 6);

        System.out.println();
        System.out.println("Number array 1: " + Arrays.toString(numbers1));
        System.out.println("Number array 2: " + Arrays.toString(numbers2));
        System.out.println("Average of numbers in number array 1 is: " + avg1);
        System.out.println("Average of numbers in number array 2 is: " + avg2);

    }
}
