/**
 Name: Khavar Baghirova
 Project: Assignment 1 - Random Number Generator
 Class: CSCI-3612 - 20964
 Date: 09.02.2026
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// CLASS DEFINITION
/**
 * generates random numbers using different Java random number generators
 * and analyzes the generated data using statistics
 */
public class Generator {  

    // CLASS ATTRIBUTE with private ACCESSIBILITY 
    /**
     * random number generator instance for java.util.Random approach
     */
    private Random rand = new Random(); 

    // METHOD DEFINITION
    /**
     * generates n random numbers using specified generator
     * @param n number of random values to generate
     * @param randNumGen generator type (1=Random, 2=Math.random, 3=ThreadLocalRandom)
     * @return ArrayList of random doubles in range [0, 1)
     */
    public ArrayList<Double> populate(int n, int randNumGen) {
        // OBJECT INSTANTIATION 
        ArrayList<Double> nums = new ArrayList<>();
      
        for (int i = 0; i < n; i++) {
            double val = 0;

            if (randNumGen == 1) {
                val = rand.nextDouble(); // java.util.Random
            } 
            else if (randNumGen == 2) {
                val = Math.random(); // Math.random
            } 
            else if (randNumGen == 3) {
                val = ThreadLocalRandom.current().nextDouble(); // ThreadLocalRandom
            }

            nums.add(val);
        }

        return nums;
    }

    /**
     * calculates descriptive statistics for the provided values
     * @param randomValues ArrayList of random double values
     * @return ArrayList containing [n, mean, stddev, min, max]
     */
    public ArrayList<Double> statistics(ArrayList<Double> randomValues) {
        ArrayList<Double> results = new ArrayList<>();
        
        int n = randomValues.size();         
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        // find sum, min, max
        for (double value : randomValues) {
            sum += value;

            if (value < min) min = value;
            if (value > max) max = value;
        }

        double mean = sum / n;

        // find sample standard deviation
        double varSum = 0;
        for (double value : randomValues) {
            varSum += Math.pow(value - mean, 2);
        }

        // handle edge case where n=1 to avoid division by zero
        double stddev = (n > 1) ? Math.sqrt(varSum / (n - 1)) : 0.0;

        // store results in required order
        results.add((double) n);
        results.add(mean);
        results.add(stddev);
        results.add(min);
        results.add(max);
        
        return results;
    }

    /**
     * displays statistical results in tabular format
     * @param results ArrayList containing [n, mean, stddev, min, max]
     * @param headerOn if true, displays column headers
     */
    public void display(ArrayList<Double> results, boolean headerOn) {
        
        if (headerOn) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s%n",
                    "n", "Mean", "StdDev", "Min", "Max");
        }

        System.out.printf("%-15.0f %-15.6f %-15.6f %-15.6f %-15.6f%n",
                results.get(0),  // n
                results.get(1),  // mean
                results.get(2),  // stddev
                results.get(3),  // min
                results.get(4)); // max
    }

    /**
     * executes the complete analysis for all combinations of sample sizes
     * and random number generators 
     */
    public void execute() {
        int[] sampleSizes = {10, 1000, 100000};

        // loop through generator types
        for (int gen = 1; gen <= 3; gen++) {

            // print generator type header
            String genName = (gen == 1) ? "java.util.Random" :
                            (gen == 2) ? "Math.random()" :
                                        "ThreadLocalRandom";
            System.out.println("\nGenerator: " + genName);
            
            // print table header once per generator
            boolean headerOn = true; 

            for (int n : sampleSizes) {

                // generate numbers
                ArrayList<Double> data = populate(n, gen);

                // compute statistics
                ArrayList<Double> stats = statistics(data);

                // display results
                display(stats, headerOn);

                // only print header once per generator
                headerOn = false; 
            }
        }
    }

    /**
     * main method
     * @param args command line arguments 
     */
    public static void main(String[] args) {
        // OBJECT INSTANTIATION 
        Generator g = new Generator(); 
        g.execute();
    }
}