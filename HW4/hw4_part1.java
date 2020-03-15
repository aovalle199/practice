package HW4;

public class hw4_part1 {

    public static int example1(int[] arr) {
    int n = arr.length, total = 0;  //C1
    for (int j=0; j < n; j++) // n
    total += arr[j];
    return total; // C2
    // The for loop runs n times and thus f(n) = O(n)
    // C1 + C2 + n  = O(n)
    // f(n) = O(n)

}

    public static int example2(int[] arr) {
        int n = arr.length, total = 0; // C1
        for (int j=0; j < n; j += 2) // n
            total += arr[j];
        return total; // C2
        // There is one iteration of this function
        // The for loop runs n times and increments by two
        // C1 + C2 + n
        // f(n) = O(n)

    }

    public static int example3(int[] arr) {
        int n = arr.length, total = 0; // C1
        for (int j=0; j < n; j++) // n
            for (int k=0; k <= j; k++) // n
                total += arr[j];
        return total;  // C2
        // There are two nested operations thus thus this loops
        // runs n^2 times and thus f(n) = O(n^2)
        // C1 + n + n  + C2 = O(n^2)
        // f(n) = O(n^2)
    }

    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;  // C1
        for (int j=0; j < n; j++) { // n
            prefix += arr[j];
            total += prefix;
        }
        return total; //C2
        // Iterates n times.
        // The run times is n  , there is only one iteration of this function
        // C1+ (n) + C2  = O(n)
    }


    public static int example5(int[] first, int[] second) { // assume equal‐length arrays
        int n = first.length, count = 0; // C1
        for (int i=0; i < n; i++) { // n
            int total = 0;
            for (int j=0; j < n; j++) // n
                for (int k=0; k <= j; k++) //n
                    total += first[k];
            if (second[i] == total) count++; // C2
        }
        return count; //C3

        // There are three nested operations thus :
        // C1 + n-1 + n-2 + n-3 + C3 = O(n^3)
        // f(n) = O(n^3)
    }


    public static void main(String[]  args) {
        int[] arr1 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int[] arr2 = new int[] {1,2,3,4,5,6,7,8,9,10 };
        final long startTime = System.currentTimeMillis();
        final long startTime2 = System.nanoTime();

        int total_example = example5(arr1, arr2);

        final long duration = System.currentTimeMillis() - startTime;
        final long duration2 = System.nanoTime() - startTime2;
        System.out.println("Time in milliseconds: " + duration);
        System.out.println("Time in nanoseconds: " + duration2);

    }

}
