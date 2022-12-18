package org.example;

public class Ocean extends CONSTANTA {
    private int numIterations;
    private int numRows;
    private int numCols;
    private int size;
    private int numPrey;
    private int numPredators;
    private int numObstacles;
    private Cell cells[][] = new Cell[MaxRows][MaxCols];
    private boolean wasInProcess[][] = new boolean[MaxRows][MaxCols];
    private Cell emptyCell = new Cell();
    public Random rand = new Random();
    public Ocean() throws IncorrectNumberException{
        initialize();

    }
    public void initialize() throws IncorrectNumberException {
        numRows = MaxRows;
        numCols = MaxCols;
        size = numCols * numRows;
        numObstacles = DefaultNumObstacles;
        numPredators = DefaultNumPredators;
        numPrey = DefaultNumPrey;
        initCells();
    }
    private void initCells() throws IncorrectNumberException {
        addEmtyCells();
        setNumObstacles(OceanViewer.enterObstacles());
        setNumPredators(OceanViewer.enterPredators(this));
        setNumPrey(OceanViewer.enterPrey(this));
        addObstacles();
        addPredators();
        addPrey();
        OceanViewer.displayStats(this, -1);
        OceanViewer.displayBorder(numCols);
        OceanViewer.displayCells(this);
        OceanViewer.displayBorder(numCols);
    }
    public void setNumIterations(int numIt) {
        numIterations = numIt;
    }
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }
    public void setNumObstacles(int num){
        numObstacles = num;
    }
    public void setNumPrey(int num) {
        numPrey = num;
    }
    public void setNumPredators(int num) {
        numPredators = num;
    }
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }
    public void setCell(Cell cell, Coordinate aCoord) {
        cells[aCoord.getY()][aCoord.getX()] = cell;
    }
    public String getCellImage(int yCoord, int xCoord) {
        return cells[yCoord][xCoord].getImage();
    }
    public Cell getCell(int yCoord, int xCoord) {
        return cells[yCoord][xCoord];
    }
    private Coordinate getEmptyCellCoord() {
        int x, y;
        Coordinate empty;
        do {
            x = rand.nextIntBetween(0, numCols - 1);
            y = rand.nextIntBetween(0, numRows - 1);
        } while (cells[y][x].getImage() != DefaultImage);
        empty = cells[y][x].getOffset();
        //finalize                                                                  на будещее поменять
        return empty;
    }
    public int getNumIterations(){return numIterations;}
    public int getNumObstacles(){
        return numObstacles;
    }
    public int getNumPrey() {
        return numPrey;
    }
    public int getNumPredator() {
        return numPredators;
    }
    public int getNumRows(){
        return numRows;
    }
    public int getNumCols(){
        return numCols;
    }
    private void addEmtyCells() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                cells[row][col] = new Cell(new Coordinate(col, row), this);               // В координате переменные перевернуты посмотреть
            }
        }
    }
    private void addObstacles() {
        Coordinate empty;
        for (int count = 0; count < numObstacles; count++) {
            empty = getEmptyCellCoord();
            cells[empty.getY()][empty.getX()] = new Obstacle(empty, this);
        }
    }
    private void addPredators() {
        Coordinate empty;
        for (int count = 0; count < numPredators; count++) {
            empty = getEmptyCellCoord();
            cells[empty.getY()][empty.getX()] = new Predator(empty, this);
        }
    }
    private void addPrey() {
        Coordinate empty;
        for (int count = 0; count < numPrey; count++) {
            empty = getEmptyCellCoord();
            cells[empty.getY()][empty.getX()] = new Prey(empty, this);
        }
    }
    public void workMetod() throws InterruptedException {
        setNumIterations(OceanViewer.enterIterations());
        OceanViewer.startSim(numIterations);
        for (int iter = 0; iter < numIterations; iter++) {
            if (numPredators > 0 && numPrey > 0) {
                for (int row = 0; row < numRows; row++) {
                    for (int col = 0; col < numCols; col++) {
                        if (!wasInProcess[row][col]) {
                            Cell workCell = cells[row][col];
                            cells[row][col].process();
                            Coordinate workCoord = workCell.getOffset();
                            wasInProcess[workCoord.getY()][workCoord.getX()] = true;
                        }
                    }
                }
                for (int row = 0; row < numRows; row++) {
                    for (int col = 0; col < numCols; col++) {
                        wasInProcess[row][col] = false;
                    }
                }
                OceanViewer.displayStats(this, iter);
                OceanViewer.displayBorder(numCols);
                OceanViewer.displayCells(this);
                OceanViewer.displayBorder(numCols);
                Thread.sleep(NumBetweenIterations);
            }

        }
        OceanViewer.endSim();
    }
}
