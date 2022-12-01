package org.example;
import org.example.CONSTANTA;

import java.util.Scanner;

public class Ocean implements OceanInter, CONSTANTA{
    Scanner scanner = new Scanner(System.in);
    public int numRows;//???????????
    public int numCols;//???????????              Дружественный класс
    private int size;
    private int numPrey;
    private int numPredators;
    private int numObstacles;
    public Random rand = new Random();//???????????
    public Cell cells[][] = new Cell[MaxRows][MaxCols];//???????????
    private void initCells(){
        System.out.println();
        System.out.println();
        System.out.print("Enter number of Obstacles(default = 75):  ");
        numPredators = scanner.nextInt();
        if(numPredators >= (size-numObstacles)) { //                             В примере было = поменял на >=
            numPredators = size - numObstacles;
        }
        System.out.println();
        System.out.println("Number predators accepted = " + numPredators);
        System.out.println();
    }
    private void addEmtyCells(){}
    private void addObstacles(){}
    private void addPredators(){}
    private void addPrey(){}
    private Coordinate getEmptyCellCoord(){
        return null;
    }
    private void displayBorder(){}
    private void displayCells(){}
    private void displayStats(int iteration){}

    @Override
    public int getNumPrey() {
        return numPrey;
    }

    @Override
    public int getNumPredator() {
        return numPredators;
    }

    @Override
    public void setNumPrey(int num) {
        numPrey = num;
    }

    @Override
    public void setNumPredators(int num) {
        numPredators = num;
    }

    @Override
    public void initialize() {
        rand.initialize();
        numRows = MaxRows;
        numCols = MaxCols;
        size = numCols * numRows;
        numObstacles = DefaultNumObstacles;
        numPredators = DefaultNumPredators;
        numPrey = DefaultNumPrey;
        initCells();
    }

    @Override
    public void run() {

    }
}
