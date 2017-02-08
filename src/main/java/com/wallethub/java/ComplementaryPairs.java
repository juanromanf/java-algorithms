package com.wallethub.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by juanroman on 6/02/17.
 */
public class ComplementaryPairs {

    private List<Pair> pairs;

    private List<Integer> input;

    private Integer k;

    /**
     * Helper class for collection pair info
     */
    class Pair {

        private int i;

        private int j;

        private int sum;

        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public int getSum() {
            return sum;
        }
    }

    /**
     * Constructor.
     *
     * @param input the integers input
     * @param k the K value
     */
    public ComplementaryPairs(List<Integer> input, Integer k) {
        this.input =  input;
        this.k = k;
        pairs = new ArrayList<>();
    }

    /**
     * Find all K-Complementary pairs in the input array
     */
    public void findKComplementaryPairs() {

        Collections.sort(input);
        getNextPair(0, input.size() - 1);
    }

    /**
     * Prints all found pairs
     */
    public void printPairs() {

        for(Pair p : pairs) {

            System.out.println("[" + p.getI() + " + " + p.getJ() + "] = " + p.getSum());
        }
    }

    /**
     * Find the next pair thought the array
     * @param i the array left position
     * @param j the array right position
     */
    private void getNextPair(int i, int j) {

        if ( i != j) {
            Integer sum = input.get(i) + input.get(j);

            if (sum == k) {

                pairs.add(new Pair(input.get(i), input.get(j), sum));
                getNextPair(i + 1, j - 1);

            } else if (sum < k) {

                getNextPair(i + 1, j);

            } else {

                getNextPair(i, j - 1);
            }
        }
    }

    /**
     * The main method
     * @param args
     */
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(7, 1, 5, 6, 9, 3, 11, -1);

        ComplementaryPairs cp = new ComplementaryPairs(numbers, 10);
        cp.findKComplementaryPairs();
        cp.printPairs();
    }
}
