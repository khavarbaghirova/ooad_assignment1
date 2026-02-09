# OOAD Assignment 1

## Description
This Java program generates random numbers using three different built-in Java random number generators and performs statistical analysis on the generated data. The code specifically compares the performance of `java.util.Random`, `Math.random()`, and `ThreadLocalRandom` across various sample sizes.

## Features
- Generates random double values in the range [0, 1) using three different methods
- Calculates statistics including:
  - Sample size (n)
  - Mean
  - Sample standard deviation
  - Minimum value
  - Maximum value
- Tests multiple sample sizes (10, 1000, 100000) for each generator
- Displays results in tables for easy comparison

## Program Structure
The program consists of a single `Generator` class with the following methods:

- `populate(int n, int randNumGen)` - Generates n random numbers using the specified generator
- `statistics(ArrayList<Double> randomValues)` - Computes statistical measures
- `display(ArrayList<Double> results, boolean headerOn)` - Displays results in tabular format
- `execute()` - Runs the complete analysis for all generator and sample size combinations

## Setup and Requirements
- **Java Version**: JDK 8 or higher

## How to Run

### 1. Compile the program
```bash
javac Generator.java
```

### 2. Run the program
```bash
java Generator
```

## Expected Output
The program produces 9 result sets (3 generators × 3 sample sizes). As the sample size increases:
- Mean converges toward 0.5
- Standard deviation approaches approximately 0.29
- Minimum approaches 0
- Maximum approaches 1



## Author
Khavar Baghirova 

CSCI-3612

CRN: 20964
