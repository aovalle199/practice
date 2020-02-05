// The first method receives the grades of all grading components of a student and calculates the
// weighted average, determines the letter grade of the student, and prints on the screen the weighted
// average and the letter grade. The grading components and their weights are:
// Homework: 30%
// Project: 10%
// Midterm: 25%
// Final: 35%
// The letter grade is determined as follows:
// 90 ≤ average < 94: A- 94 ≤ average: A,
// 80 ≤ average < 83: B- 83 ≤ average < 87: B 87 ≤ average < 90: B+
// 70 ≤ average < 73: C- 73 ≤ average < 77: C 77 ≤ average < 80: C+
// 60 ≤ average < 70: D
// The signature of the method is:
// public static void grade(int homework, int project, int midterm, int finalExam)
// The second method is the main method, which is used to test the grade method. The following
// shows two examples:
// If you run your program with:
// public static void main(String[] args) {
// grade(100, 90, 85, 95);
// }
// Your output should be: Average is 94.0, Grade is A
// If you run your program with:
// public static void main(String[] args) {   
// grade(100, 100, 90, 75);
// }
// Your output should be: Average is 88.75, Grade is B+







package HW1;

// written by Andrea Ovalle
public class hw1_part1 {
    // it accepts four arguments
    public static void grade(int homework,
                             int project,
                             int midterm,
                             int finalExam) {

        // sets the weight of the grades
        double hw = homework * 0.30;
        double pj = project * 0.10;
        double md = midterm * 0.25;
        double fe = finalExam * 0.35;

        // computes the weighted average
        double wa = hw + pj + md  + fe ;

        //  prints the grade corresponding to the weighted average
        if (wa >= 94) {
            System.out.println("The Average is " + wa + ", Grade is A");
        }
        else if (wa >= 90) {
            System.out.println("The Average is " + wa + ",  Grade is A-");
        }
        else if (wa >= 87) {
            System.out.println("The Average is " + wa + ", Grade is B+");
        }
        else if (wa >= 83) {
            System.out.println("The Average is " + wa + ", Grader is B");
        }
        else if (wa >= 80) {
            System.out.println("The Average is "+ wa + ", Grade is B-");
        }
        else if (wa >= 77){
            System.out.println("The Average is " + wa + ", Grade is C+");
        }
        else if (wa >= 73){
            System.out.println("The Average is " + wa + ", Grade is C");
        }
        else if (wa >= 70) {
            System.out.println("The Average is " + wa + ", Grade is C-");
        }
        else {
            System.out.println(" The Average is " + wa + ", Grade is D");
        }
    }


    public static void main(String[] args) {
        grade(100, 90, 85, 75);
    }

}
