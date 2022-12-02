package org.example;

import java.util.Scanner;

import static org.example.Cell.Ocean1;

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
        Ocean1 = this;
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
            x = (int) (Math.random()*68);//rand.nextIntBetween(0, numCols - 1);
            y = (int) (Math.random()*25);//rand.nextIntBetween(0, numRows - 1);
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
                        cells[row][col].process();
                    }
                }
                displayStats(iter);
                displayCells();
                displayBorder();
            }
            Thread.sleep(1000);
        }
        System.out.println();
        System.out.println();
        System.out.println("End of Simulations");


    }
}
