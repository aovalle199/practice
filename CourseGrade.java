package HW2;



public class CourseGrade {
    // Instance variables
    private String name ;
    private int homework ;
    private int project ;
    private int midterm ;
    private int finalExam ;
    private double average;
    private String grade ;

    // Creates the getters
    public String getName(){
        return name;
    }
    public Integer getHomework(){
        return homework;
    }
    public Integer getProject(){
        return project;
    }
    public Integer getMidterm(){
        return midterm;
    }
    public Integer getFinalExam(){
        return finalExam;
    }
    // computes the average
    public  Double getAverage(){
        return (getHomework() * 0.30) + (getProject() * 0.10) + (getMidterm() * 0.25) + (getFinalExam() * 0.35);
    }
    public String getGrade(){
        double wa = getAverage();

        if (wa >= 94) {
            return "The Average is " + wa + ", Grade is A";
        }
        else if (wa >= 90) {
            return "The Average is " + wa + ",  Grade is A-";
        }
        else if (wa >= 87) {
           return "The Average is " + wa + ", Grade is B+";
        }
        else if (wa >= 83) {
            return "The Average is " + wa + ", Grade is B";
        }
        else if (wa >= 80) {
            return "The Average is "+ wa + ", Grade is B-";
        }
        else if (wa >= 77){
            return "The Average is " + wa + ", Grade is C+";
        }
        else if (wa >= 73){
            return "The Average is " + wa + ", Grade is C";
        }
        else if (wa >= 70) {
            return "The Average is " + wa + ", Grade is C-";
        }
        else {
            return " The Average is " + wa + ", Grade is D";
        }

    }
    //Setters

    public void setName(String name){
        this.name = name;
    }
    public void setHomework(int homework){
        this.homework = homework ;
    }
    public void setProject(int project){
        this.project = project;
    }
    public void setMidterm(int midterm){
        this.midterm = midterm;
    }
    public void setFinalExam(int finalExam){
        this.finalExam = finalExam;
    }
    public void setAverage(double average){
        this.average = average;
    }
    public void setString(String grade){
        this.grade = grade;
    }


}