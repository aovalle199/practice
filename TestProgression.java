package HW2;
// written by Andrea Ovalle
public class TestProgression {
    public TestProgression() {
    }

    public static void main(String[] var0) {
        System.out.print("The following sequence is created with the default value : " );
        // Creates a new object from the Hw2Progression class with default one
        Hw2Progression var1 = new Hw2Progression();
        // Defines the number of times the new object should be executed
        var1.printProgression(10);
        System.out.print("The following sequence is created with value of 5 : ");
        Hw2Progression var2 = new Hw2Progression(5);
        var2.printProgression(10);


    }
}
