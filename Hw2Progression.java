// This part is a practice of defining and using a subclass.

// Create a file named Hw2Progression.java that defines the Hw2Progression class as a subclass of
// the Progression class. This progression generates a sequence of natural numbers and the next value
// is determined as follows:

//  If the current value x is an even number, the next value is 2x – 1.
//  If the current value x is an odd number, the next value is x + 1.
// For example,
// If the first value of the sequence is 1 (default value), the following sequence is created:
// 1 2 3 4 7 8 15 16 31 32
// If the first value of the sequence is 4, the following sequence is created: 4 7 8 15 16 31 32 63 64 127
//  The class definition must include: 
//  A default constructor that starts with 1.
//  A parameterized constructor that starts with a specified natural number.
//  An advance( ) method that determines the next value.
// Then, modify the main method of the TestProgression.java file by adding a code segment that
// performs the following test:
//  Create an Hw2Progression object with a default constructor and print the first 10 values
// on the screen.
//  Create an Hw2Progression object with 5 as the start value and print the first 10 values on
// the screen.





package HW2;

// written by Andrea Ovalle

public class Hw2Progression extends Progression {

        // variable that will be modified by the advanced method
        protected long first ;
        protected long next ;

        // defines the subclass
        public Hw2Progression(long var1) {
            super(var1);
            this.first = var1;
        }
        // Constructor of the subclass
        public  Hw2Progression() {this(1); }

        // advanced method that has been override from the superclass
        protected void advance() {
            // If the current value is even
            if ((this.current % 2) == 0) {
                // multiply by 2 and substract 1
                this.next = ((this.current * 2) - 1);
                current = this.next;
            } else {
                // if the current value is not even the next value will be the sum
                // sum of the current value and one
                this.next = this.current + 1;
                // Sets the current value to the next value
            }   current = this.next;

        }
}
