/**
 Name: Khavar Baghirova
 Project: Assignment 1 - Random Number Generator
 Class: CSCI-3612 - 20964
 Date: 09.02.2026
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {  

    private Random rand = new Random(); 

 
    public ArrayList<Double> populate(int n, int randNumGen) {
        ArrayList<Double> numbers = new ArrayList<>();
        
        //Creates and returns an ArrayList of n random numbers using one of the three random number generators
        for (int i = 0; i < n; i++) {
        double val = 0;

            if (randNumGen == 1) {
                val = rand.nextDouble(); // java.util.Random
            } 
            else if (randNumGen == 2) {
                val = Math.random(); // Math.random()
            } 
            else if (randNumGen == 3) {
                val = ThreadLocalRandom.current().nextDouble(); // ThreadLocalRandom
            }

            numbers.add(val);
        }

        return numbers;
    }

   
    public ArrayList<Double> statistics(ArrayList<Double> randomValues) {
        ArrayList<Double> results = new ArrayList<>();
        
        //Calculates the number of elements (n), mean, sample standard deviation, minimum, and maximum, and returns the results
        
        
        int n = randomValues.size();         
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        //find sum, min, max
        for (double value : randomValues) {
            sum += value;

            if (value < min) min = value;
            if (value > max) max = value;
        }

        double mean = sum / n;

        //compute sample standard deviation
        double varSum = 0;
        for (double value : randomValues) {
            varSum += Math.pow(value - mean, 2);
        }

        double stddev = Math.sqrt(varSum / (n - 1)); 

        //store results in required order
        results.add((double) n);
        results.add(mean);
        results.add(stddev);
        results.add(min);
        results.add(max);
        return results;
    }

    public void display(ArrayList<Double> results, boolean headerOn) {

        //Displays the results in a tabular format in the system console, with or without a header
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

    public void execute() {
        
        //Calls the populate, statistics, and display methods for all combinations of n values and random number generators (total 9 results)
    
        int[] sampleSizes = {10, 1000, 100000};

        //loop through generator types: 1 = Random, 2 = Math.random, 3 = ThreadLocalRandom
        for (int gen = 1; gen <= 3; gen++) {

            //print generator type header
            String genName = (gen == 1) ? "java.util.Random" :
                            (gen == 2) ? "Math.random()" :
                                        "ThreadLocalRandom";
            System.out.println("\nGenerator: " + genName);

            boolean headerOn = true; //print table header once per generator

            for (int n : sampleSizes) {

                //generate numbers
                ArrayList<Double> data = populate(n, gen);

                //compute statistics
                ArrayList<Double> stats = statistics(data);

                //display results
                display(stats, headerOn);

                headerOn = false; //only print header once per generator
        }
    }
        
    }

    public static void main(String[] args) {
        Generator g = new Generator(); 
        g.execute();
    }
}
