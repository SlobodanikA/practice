package org.example;

import java.util.Scanner;

public class OceanViewer implements CONSTANTA {
    private static Scanner scanner = new Scanner(System.in);
    protected static void displayCells(Ocean l){
        for(int row = 0; row < l.getNumRows(); row++){
            for(int col = 0; col < l.getNumCols(); col++){
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
    protected static int enterObstacles(){
        System.out.println();
        System.out.print("Enter number of obstacles(default = 75):  ");
        int numObstacles = scanner.nextInt();
        if (numObstacles >= MaxRows*MaxCols) {
            numObstacles = MaxRows*MaxCols;
        }
        System.out.println();
        System.out.println("Number of obstacles accepted = " + numObstacles);
        return numObstacles;
    }
    protected static int enterPredators(Ocean l){
        System.out.println();
        System.out.print("Enter number of predators (default = 20): ");
        int numPredators = scanner.nextInt();
        if (numPredators >= (MaxCols*MaxRows - l.getNumObstacles())) {
            numPredators = MaxCols*MaxRows - l.getNumObstacles();
        }
        System.out.println();
        System.out.println("Number of predators accepted = " + numPredators);
        return numPredators;
    }
    protected static int enterPrey(Ocean l){
        System.out.println();
        System.out.print("Enter number of prey (default = 150): ");
        int numPrey = scanner.nextInt();
        if (numPrey >= (MaxRows*MaxCols - l.getNumObstacles() - l.getNumPredator())) {
            numPrey = MaxCols*MaxRows - l.getNumObstacles() - l.getNumPredator();
        }
        System.out.println();
        System.out.println("Number of prey accepted = " + numPrey);
        return numPrey;
    }
    protected static void displayStats(Ocean l, int iter){
        System.out.println();
        System.out.println();
        System.out.print("Iteration number: "+ (iter+1));
        System.out.print(" Obstacles: "+ l.getNumObstacles());
        System.out.print(" Predators: "+ l.getNumPredator());
        System.out.println(" Prey: "+ l.getNumPrey());
    }
    protected static void displayBorder(int numCols){
        for(int col = 0; col < numCols; col++){
            System.out.print("*");
        }
        System.out.println();
    }
    protected static void startSim(int numIterations){
        System.out.println();
        System.out.println("Number of iterations = " + numIterations);
        System.out.println("begin run...");
    }
    protected static void endSim(){
        System.out.println();
        System.out.println();
        System.out.println("End of Simulations");
    }
}
