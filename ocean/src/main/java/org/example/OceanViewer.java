package org.example;

import java.util.Scanner;

public class OceanViewer {
    private static Scanner scanner = new Scanner(System.in);
    protected static void displayCells(int numRows, int numCols, Ocean l){
        for(int row = 0; row < numRows;row++){
            for(int col = 0; col < numCols; col++){
                System.out.print(l.getCellImage(row,col));
            }
            System.out.println();
        }
    }
    protected static int enterIterations(){
        System.out.println();
        System.out.println();
        System.out.print("Enter number of iterations (default max = 1000): ");
        int numIt = scanner.nextInt();
        if(numIt > 1000){
            numIt = 1000;
        }
        return numIt;
    }
    protected static void displayStats(int iteration, int numObstacles, int numPredators, int numPrey){
        System.out.println();
        System.out.println();
        System.out.print("Iteration number: "+iteration);
        System.out.print(" Obstacles: "+ numObstacles);
        System.out.print(" Predators: "+ numPredators);
        System.out.println(" Prey: "+ numPrey);
    }

    protected static void displayBorder(int numCols){
        for(int col = 0; col < numCols; col++){
            System.out.print("*");
        }
        System.out.println();
    }
    protected static void endSim(){
        System.out.println();
        System.out.println();
        System.out.println("End of Simulations");
    }
    protected static void startSim(int numIterations){
        System.out.println();
        System.out.println("Number of iterations = " + numIterations);
        System.out.println("begin run...");
    }
}
