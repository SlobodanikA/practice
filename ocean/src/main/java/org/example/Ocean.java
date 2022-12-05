package org.example;

import java.util.Scanner;

public class Ocean implements CONSTANTA{
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
        addEmtyCells();

        System.out.println();
        System.out.println();
        System.out.print("Enter number of obstacles(default = 75):  ");
        numObstacles = scanner.nextInt();
        if(numObstacles >= size) { //                             В примере было = поменял на >=
            numObstacles = size;
        }
        System.out.println();
        System.out.println("Number of obstacles accepted = " + numObstacles);
        System.out.println();
        System.out.print("Enter number of predators (default = 20): ");
        numPredators = scanner.nextInt();
        if(numPredators >= (size-numObstacles)){
            numPredators = size-numObstacles;
        }
        System.out.println();
        System.out.println("Number of predators accepted = " + numPredators);
        System.out.println();
        System.out.print("Enter number of prey (default = 150): ");
        numPrey = scanner.nextInt();
        if(numPrey >= (size-numObstacles-numPredators)){
            numPrey = size - numObstacles - numPredators;
        }
        System.out.println();
        System.out.println("Number of prey accepted = " + numPrey);
        System.out.println();
        addObstacles();
        addPredators();
        addPrey();
        displayStats(-1);
        displayCells();
        displayBorder();
        for(int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                cells[row][col].Viewer = this;
            }
        }
    }
    private void addEmtyCells(){
        for(int row = 0; row<numRows;row++){
            for(int col = 0; col <numCols; col++){
                cells[row][col] = new Cell(new Coordinate(col, row));               // В координате переменные перевернуты посмотреть
            }
        }
    }
    private void addObstacles(){
        Coordinate empty;
        for(int count = 0; count < numObstacles; count++){
            empty = getEmptyCellCoord();
            cells[empty.getY()][empty.getX()] = new Obstacle(empty);
        }
    }
    private void addPredators(){
        Coordinate empty;
        for(int count = 0; count < numPredators; count++){
            empty = getEmptyCellCoord();
            cells[empty.getY()][empty.getX()] = new Predator(empty);
        }
    }
    private void addPrey(){
        Coordinate empty;
        for(int count = 0; count < numPrey; count++){
            empty = getEmptyCellCoord();
            cells[empty.getY()][empty.getX()] = new Prey(empty);
        }
    }
    private Coordinate getEmptyCellCoord(){
        int x, y;
        Coordinate empty;
        do{
            x = rand.nextIntBetween(0, numCols - 1);
            y = rand.nextIntBetween(0, numRows - 1);
        }while(cells[y][x].getImage() != DefaultImage);
        empty = cells[y][x].getOffset();
        //finalize                                                                  на будещее поменять
        return empty;
    }
    private void displayBorder(){
        for(int col = 0; col < numCols; col++){
            System.out.print("*");
        }
        System.out.println();
    }
    private void displayCells(){
        for(int row = 0; row < numRows;row++){
            for(int col = 0; col < numCols; col++){
                cells[row][col].display();
            }
            System.out.println();
        }
    }
    private void displayStats(int iteration){
        System.out.println();
        System.out.println();
        System.out.print("Iteration number: "+ ++iteration);
        System.out.print(" Obstacles: "+ numObstacles);
        System.out.print(" Predators: "+ numPredators);
        System.out.println(" Prey: "+ numPrey);
        displayBorder();
    }


    public int getNumPrey() {
        return numPrey;
    }


    public int getNumPredator() {
        return numPredators;
    }


    public void setNumPrey(int num) {
        numPrey = num;
    }


    public void setNumPredators(int num) {
        numPredators = num;
    }


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


    public void run() throws InterruptedException {
        int numIterations = DefaultNumIterations;
        System.out.println();
        System.out.println();
        System.out.print("Enter number of iterations (default max = 1000): ");
        numIterations = scanner.nextInt();
        if(numIterations > 1000){
            numIterations = 1000;
        }
        System.out.println();
        System.out.println("Number of iterations = " + numIterations);
        System.out.println("begin run...");
        for(int iter = 0; iter < numIterations; iter++){
            if(numPredators > 0&&numPrey>0){
                for(int row = 0; row < numRows; row++){
                    for(int col = 0; col < numCols; col++){
                        if(!cells[row][col].isProcess) {
                            cells[row][col].process();
                        }
                    }
                }
                for(int row = 0; row < numRows; row++) {
                    for (int col = 0; col < numCols; col++) {
                        cells[row][col].isProcess = false;
                    }
                }
                displayStats(iter);
                displayCells();
                displayBorder();
                Thread.sleep(2000);
            }
            Thread.sleep(2000);
        }
        System.out.println();
        System.out.println();
        System.out.println("End of Simulations");


    }
}
