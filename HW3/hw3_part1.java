package HW3;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**  Allows to return two values or more */
final class Student{

    private String Name;
    private String Grade;

    public Student(String Name, String Grade) {
        this.Name = Name;
        this.Grade = Grade;
    }
    public String getName() {
        return Name;
    }
    public String getGrade() {
        return Grade;
    }
}


/**  Main class, returns and prints the Highest and lowest grade of the class, as well as the grades of
 * all students */
public class hw3_part1 {
    // Gets the highest grade
    public static Student HighestGrade(LinkedList<CourseGrade> LinkedCourseGrade){
        if (LinkedCourseGrade.isEmpty()) {return null;}

        String highGrade = null;
        CourseGrade l2 = null;
        CourseGrade name2 = null;
        String Name2 = null;

        double current = 0;
        // iterates through a linked list and compares each value to check for
        // the highest grade in the class
        for (int i=0; i<LinkedCourseGrade.size(); i++){

            // for each value in the linked list create get each CourseGrade element in the list
            // which will be used to get the average
            l2 = LinkedCourseGrade.get(i);

            // for each value value in the list, get the CourseGrade element in the list
            // which will be used to get the name
            name2 = LinkedCourseGrade.get(i);

            // from the l2 CourseGrade element get the the average
            double m = l2.getAverage();

            // check if the average is greater than the current value, for each iteration the current value
            // is assigned to the m, so every time it iterates it checks for if m > than the current which is x0
            if (m > current) {
                current = m;
                highGrade = l2.getGrade();
                Name2 = name2.getName(); }
        }
        // Calls the Student method to return both values
        return new Student(Name2, highGrade);
    }

    // gets the lowest grade
    public static Student LowestGrade(LinkedList<CourseGrade> LinkedCourseGrade) {
        if (LinkedCourseGrade.isEmpty()) {return null; }

        String lowGrade = null ;
        CourseGrade l = null ;
        CourseGrade name = null;
        String Name = null;

        // traverse the list using index

        double current = 0;
        // iterates through the linked course list
        for (int i=0; i<LinkedCourseGrade.size(); i++) {
                l = LinkedCourseGrade.get(i);
                name = LinkedCourseGrade.get(i);
                double m = l.getAverage();
                // checks that if the value is greater than the current
                if (m > current){ current = m ; }
                // if the value is not greater assigns the value to lowGrade and gets the value (grade)
                // from the element
                else  {
                    lowGrade = l.getGrade() ;
                    Name = name.getName();

                }
        }
        return new Student(Name, lowGrade);
    }


    public static void main(String[] args) throws IOException {

        // Linked list where the class objects will be saved
        LinkedList<CourseGrade> LinkedCourseGrade = new LinkedList<>();

        // Checks for the absolute path of where the scanner class should look for the file
        System.out.println(new File("student_grades.txt").getAbsolutePath());

        // Looks for the file and assigns it to the fileInput object
        Scanner fileInput = new Scanner(new File("student_grades.txt"));

        // checks if the fileInput is not empty and iterates through each line in the text
        while (fileInput.hasNextLine()) {
            String grades = fileInput.nextLine();
            Scanner gradeScanner = new Scanner(grades);
            gradeScanner.useDelimiter(", ");
            while (gradeScanner.hasNext()) {
                // Assigns the first value for the object student
                String student = gradeScanner.next();

                // Assigns the second value in the first row to the object hw
                String hw = gradeScanner.next();
                // Converts from string to integer
                int hw_int = Integer.parseInt(hw);

                // Assigns the next value to the object project
                String project = gradeScanner.next();
                int project_int = Integer.parseInt(project);

                // Assigns the next value in the row to the object midterm
                String midterm = gradeScanner.next();
                int midterm_int = Integer.parseInt(midterm);

                //  Assigns the next value to the object finalExam
                String finalExam = gradeScanner.next();
                int final_exam_int = Integer.parseInt(finalExam);

                // Creates a new instance of CourseGrade and sets
                // the new objects inside the class with the values read from the text file
                CourseGrade stu1;
                stu1 = new CourseGrade();
                stu1.setName(student);
                stu1.setHomework(hw_int);
                stu1.setProject(project_int);
                stu1.setMidterm(midterm_int);
                stu1.setFinalExam(final_exam_int);

                // Adds all the objects created to a linked list
                LinkedCourseGrade.add(stu1);

            }

        }

        // Prints the name of the student by getting the value from the CourseGrade
        // instance created above and gets the final letter Grade and the average
        for (CourseGrade s : LinkedCourseGrade) {
            String n = s.getName();
            String m = s.getGrade();
            System.out.println(n + ": " + m);

        }
        // Reads from the array created with all the objects and counts how many objects were created
        System.out.print("Number of Students Graded : " + LinkedCourseGrade.size());
        System.out.println();


        Iterator<CourseGrade> courseIterator = LinkedCourseGrade.iterator();
        System.out.println();
        while (courseIterator.hasNext()) {courseIterator.next();
        }

        // Use the lowestgrade method to get the LinkedCourseGrade and get the name and the grade
        System.out.println("Lowest Grade in the Class: ");
        System.out.println(LowestGrade(LinkedCourseGrade).getName() + ": " + LowestGrade(LinkedCourseGrade).getGrade());
        System.out.println();

        // Use the highest grade method to get the LinkedCourseGrade and the name and the grade
        System.out.println("Highest Grade in the Class: ");
        System.out.println(HighestGrade(LinkedCourseGrade).getName() + ": " + HighestGrade(LinkedCourseGrade).getGrade());
        System.out.println();

    }

}


