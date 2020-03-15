package HW3;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class hw3_part2 {
    public static void sortStudents(CourseGrade[] gradeArray) {

        int n = gradeArray.length;

        for (int k = 0; k < n ; k ++) {
            CourseGrade current = gradeArray[k];
            current.getAverage();

            int j = k ;
            // Loops through the averages in the array and inserts them in a
            // new location
            while(j > 0 && gradeArray[j-1].getAverage() > current.getAverage()) {
                gradeArray[j] =  gradeArray[j-1];
                j--;
            }

            gradeArray[j] = current;
        }
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
        // Creates and array that will contain CourseGrade elements
        CourseGrade[] GradeArray = new CourseGrade[5];

        for (int i = 0; i < LinkedCourseGrade.size(); i++) {
            GradeArray[i] = LinkedCourseGrade.get(i);
        }

        // Will loop through the array and print the elements from that
        //List
        for (CourseGrade s : GradeArray) {
            String n = s.getName();
            String m = s.getGrade();
            System.out.println(n + ": " + m);

        }
        System.out.println();
        System.out.println();

        // sorts the elements in the array
         sortStudents(GradeArray);

        // Loops through the grade array and prints the sorted values
        for (CourseGrade m7 : GradeArray) {
            String name  = m7.getName();
            String grade = m7.getGrade();
            System.out.println(name + ": " + grade);

         }
        }

    }
