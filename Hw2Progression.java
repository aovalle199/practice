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