/**
 Name: Khavar Baghirova
 Project: Assignment 1 - Random Number Generator
 Class: CSCI-3612 - 20964
 Date: 09.02.2026
 */

import java.util.ArrayList;
import java.util.Random;

public class Generator {  

    private Random rand = new Random(); 

 
    public ArrayList<Double> populate(int n, int randNumGen) {
        ArrayList<Double> numbers = new ArrayList<>();
        
        //Creates and returns an ArrayList of n random numbers using one of the three random number generators

        return numbers;
    }

   
    public ArrayList<Double> statistics(ArrayList<Double> randomValues) {
        ArrayList<Double> results = new ArrayList<>();
        
        //Calculates the number of elements (n), mean, sample standard deviation, minimum, and maximum, and returns the results
        
        return results;
    }

    public void display(ArrayList<Double> results, boolean headerOn) {

        //Displays the results in a tabular format in the system console, with or without a header
        
    }

    public void execute() {
        
        //Calls the populate, statistics, and display methods for all combinations of n values and random number generators (total 9 results)
        
    }

    public static void main(String[] args) {
        Generator g = new Generator(); 
        g.execute();
    }
}
