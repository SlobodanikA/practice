package org.example;

public class Cell implements CellInter{
    protected static Ocean Ocean1 = new Ocean();
    protected Coordinate offset;
    protected char image;

    protected Cell getCallAt(Coordinate aCord) {
        return Ocean1.cells[aCord.getY()][aCord.getX()];
    }
    protected Cell getNeighborWithImage(char anImage){
        Cell neighbors[] = new Cell[4];
        int count = 0;
        if(north().getImage() == anImage){
            neighbors[count++] = north();
        }
        if(south().getImage() == anImage){
            neighbors[count++] = south();
        }
        if(east().getImage() == anImage){
            neighbors[count++] = east();
        }
        if(west().getImage() == anImage){
            neighbors[count++] = west();
        }
        if(count == 0){
            return this;
        }
        else{
            return neighbors[Ocean1.rand.nextIntBetween(0,count-1)];
        }
    }
    protected void assignCellAt(Coordinate aCord, Cell aCell){
        Ocean1.cells[aCord.getY()][aCord.getX()] = aCell;
    }
    protected Coordinate getEmptyNeighborCoord(){
        return getNeighborWithImage(DefaultImage).getOffset();
    }
    protected Coordinate getPreyNeighborCoord(){
        return getNeighborWithImage(DefaultPredImage).getOffset();
    }
    protected Cell north(){
        int yValue;
        yValue = (offset.getY()>0) ? (offset.getY()-1):(Ocean1.numRows-1);
        return Ocean1.cells[yValue][offset.getX()];
    }
    protected Cell south(){
        int yValue;
        yValue = (offset.getY()+1) % Ocean1.numRows;
        return Ocean1.cells[yValue][offset.getX()];
    }
    protected Cell east(){
        int xValue;
        xValue = (offset.getX()+1) % Ocean1.numCols;
        return Ocean1.cells[offset.getY()][xValue];
    }
    protected Cell west(){
        int xValue;
        xValue = (offset.getX()>0)?(offset.getX()-1):(Ocean1.numCols - 1);
        return Ocean1.cells[offset.getY()][xValue];
    }
    protected Cell reproduce(Coordinate anOffset){
        Cell temp = new Cell(anOffset);
        return temp;
    }
    public Cell(Coordinate aCord) {
        offset = new Coordinate(aCord);
        image = DefaultImage;
    }
    public Cell(){
    }

    @Override
    public Coordinate getOffset() {
        return offset;
    }

    @Override
    public void setOffset(Coordinate anOffset) {
        offset = anOffset;
    }

    @Override
    public char getImage() {
        return image;
    }

    @Override
    public void display() {
        System.out.print(image);
    }

    @Override
    public void process() {

    }
}
