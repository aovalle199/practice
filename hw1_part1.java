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
