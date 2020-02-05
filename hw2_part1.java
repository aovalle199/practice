// You must define a class named CourseGrade in a separate CourseGrade.java file. The class
// definition must include at least the following:
//  A constructor (you may define multiple constructors if you want)
//  The following instance variables
// private String name;
// private int homework;
// private int project;
// private int midterm;
// private int finalExam;
// private double average;
// private String grade;
//  All necessary getter and setter methods.
// Then, your program must (within the main method of Hw2_part1.java):
//  Read the input file, one line at a time
//  Parse a line (or separate tokens)
//  Calculate the weighted average and determine the letter grade of the student
//  Create an object of CourseGrade class
//  Add the object to an ArrayList
//  Repeat the above until all lines in the input file are read
//  Print all students’ grades in the following format:
// Number of students is: 5
// John: Average = 94.85, Grade = A
// Susan: Average = 83.45, Grade = B
// Molly: Average = 92.85, Grade = A‐ 
// Lindsey: Average = 83.25, Grade = B
// Jake: Average = 79.0, Grade = C+
// Technically, you don’t need to store students’ information in an ArrayList. When you read each
// line from the input file, you can determine the grade and print the necessary information without
// storing that information. However, since one of the goals of this assignment is a practice of using
// an ArrayList, you must store students’ information in an ArrayList. 




package HW2;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
// written by Andrea Ovalle
public class hw2_part1 {
    public static void main(String[] args) throws IOException {

        // Array where the class objects will be saved
        ArrayList<CourseGrade> arrayCourseGrade = new ArrayList<>();

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

                // Adds all the objects created to an array
                arrayCourseGrade.add(stu1);

                }

            }

        // Prints the name of the student by getting the value from the CourseGrade
        // instance created above and gets the final letter Grade and the average
        for (CourseGrade s : arrayCourseGrade) {
            String n = s.getName();
            String m = s.getGrade();
            System.out.println(n + ": " + m);

        }
        // Reads from the array created with all the objects and counts how many objects were created
        System.out.print("Number of Students Graded : " + arrayCourseGrade.size());
    }
}
