# Travelling Salesman Problem Solver

This project implements an exact solution to the Travelling Salesman Problem (TSP) using Dynamic Programming with Bitmasking in Java.  
It accepts a distance matrix as input and outputs the minimum travel cost along with the optimal visiting path.

## Features

- Iterative DP approach with bitmasking for efficiency.
- Reconstructs and displays the optimal path.
- Reads input distance matrix from a file for flexibility.

## Time Complexity

The time complexity of this solution is \(O(n^2 \times 2^n)\), where \(n\) is the number of cities.  
This is due to iterating over all possible subsets of cities and, for each, checking transitions between cities.

## Usage

1. Place your distance matrix in `input.txt` (first line: number of cities, following lines: distance matrix).
2. Compile the Java files:
javac TravellingSalesMan.java TravellingSalesmanTest.java
3. Run the test class:
java TravellingSalesmanTest

----

Feel free to contribute by opening issues or pull requests!