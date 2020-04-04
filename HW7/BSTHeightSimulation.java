package HW7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BSTHeightSimulation {

    public static Set<Integer> createUniqueSet(Random r1) {

        int e;
        Random r = new Random();

        // creates a unique set of random values
        HashSet<Integer> uniques = new HashSet<>();
        // makes sure that the sets is 1,000
        while (uniques.size() < 1000) {
            // adds each value to the unique set
            uniques.add(r.nextInt());
            // adds the next value to uniques set
            e = r.nextInt(1000000);
            uniques.add(e);

        }
        return uniques;
    }


    public static void main(String[] args) {
        // sets the seed once
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());

        int iteration = 0;
        int tree_height = 0;
        int sum = 0;
        // and array of all the 100 tree heights
        ArrayList<Integer> total_heights = new ArrayList<>();

        // got through 100 iterations and create 100 trees
        for (int j= 0; j < 100 ;  j ++) {
            // empty tree
            NodeBST<Integer> NewTree = new NodeBST<>();
            // get the random numbers
            Set<Integer> s = createUniqueSet(r);
            // for each of random number in the set adds a node with it
            for (int i : s) {
                // add a node with the random number
                NewTree.add(NewTree.root, i);
                // save the height of the tree in tree_height
                tree_height = NewTree.height(NewTree.root);
                // counts of iterations
                iteration++;

            }
            // adds the heights of the 100 trees to the array total_heights
            total_heights.add(tree_height);
            System.out.println(" Height = " + tree_height + ", Size = " + NewTree.size());


        }
        // adds the values in total_heights
        for (int i: total_heights){
            sum += i;
        }
        System.out.println("");
        System.out.println("Average: " + (sum/100) + "  --> This is the average of the height of 100 trees");
        }
    }



