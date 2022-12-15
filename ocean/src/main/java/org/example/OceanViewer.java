package org.example;

import java.util.Scanner;
public class OceanViewer extends CONSTANTA {
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
        if(numIt > DefaultNumIterations){
            numIt = DefaultNumIterations;
        }
        return numIt;
    }
    protected static int enterObstacles() {
        boolean flag = false;
        //String Word = "Слово";
        int numObstacles = 0;
        System.out.println();
        System.out.print("Enter number of obstacles(default = 75):  ");
        try {
            numObstacles = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            flag = true;
        }
        try {
            if (numObstacles >= MaxRows * MaxCols || numObstacles < 0 ||flag) {
                throw new IncorrectNumberException("Incorrect number. Changed to default",DefaultNumObstacles);
            }
        }
        catch(IncorrectNumberException e){
            e.getMessage();
            numObstacles = e.getDefaultValue();
        }

        System.out.println();
        System.out.println("Number of obstacles accepted = " + numObstacles);
        return numObstacles;
    }
    protected static int enterPredators(Ocean l){
        boolean flag = false;
        int numPredators = 0;
        System.out.println();
        System.out.print("Enter number of predators (default = 20): ");
        try {
            numPredators = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            flag = true;
        }
        try {
            if (numPredators >= MaxRows * MaxCols - l.getNumObstacles() || numPredators < 0 ||flag) {
                throw new IncorrectNumberException("Incorrect number. Changed to default",DefaultNumPredators);
            }
        }
        catch(IncorrectNumberException e){
            e.getMessage();
            numPredators = e.getDefaultValue();
        }
        System.out.println();
        System.out.println("Number of predators accepted = " + numPredators);
        return numPredators;
    }
    protected static int enterPrey(Ocean l){
        boolean flag = false;
        int numPrey = 0;
        System.out.println();
        System.out.print("Enter number of prey (default = 150): ");
        try {
            numPrey= Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            flag = true;
        }
        try {
            if (numPrey >= MaxRows * MaxCols - l.getNumPredator() - l.getNumObstacles()|| numPrey < 0 ||flag) {
                throw new IncorrectNumberException("Incorrect number. Changed to default",DefaultNumPrey);
            }
        }
        catch(IncorrectNumberException e){
            e.getMessage();
            numPrey = e.getDefaultValue();
        }
        System.out.println();
        System.out.println("Number of prey accepted = " + numPrey);
        return numPrey;
    }
    protected static void displayStats(Ocean l, int iter){
        System.out.println();
        System.out.println();
        String k = "sdfsdfs";

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
