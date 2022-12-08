package org.example;

public class Cell implements CONSTANTA {
    protected Ocean Viewer = null; // Змінити назву
    protected Coordinate offset;
    protected char image;
    protected boolean isProcess = false;  // Перенести реалізацію в Океан

    protected Cell getCallAt(Coordinate aCord) {
        return Viewer.cells[aCord.getY()][aCord.getX()];
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
            return neighbors[Viewer.rand.nextIntBetween(0,count-1)];
        }
    }
    protected void assignCellAt(Coordinate aCord, Cell aCell){
        Viewer.cells[aCord.getY()][aCord.getX()] = aCell;
    }
    protected Coordinate getEmptyNeighborCoord(){
        return getNeighborWithImage(DefaultImage).getOffset();
    }
    protected Coordinate getPreyNeighborCoord(){
        return getNeighborWithImage(DefaultPreyImage).getOffset();
    }
    protected Cell north(){
        int yValue;
        yValue = (offset.getY()>0) ? (offset.getY()-1):(Viewer.numRows-1);
        return Viewer.cells[yValue][offset.getX()];
    }
    protected Cell south(){
        int yValue;
        yValue = (offset.getY()+1) % Viewer.numRows;
        return Viewer.cells[yValue][offset.getX()];
    }
    protected Cell east(){
        int xValue;
        xValue = (offset.getX()+1) % Viewer.numCols;
        return Viewer.cells[offset.getY()][xValue];
    }
    protected Cell west(){
        int xValue;
        xValue = (offset.getX()>0)?(offset.getX()-1):(Viewer.numCols - 1);
        return Viewer.cells[offset.getY()][xValue];
    }
    protected Cell reproduce(Coordinate anOffset){
        Cell temp = new Cell(anOffset, this.Viewer);
        return temp;
    }
    public Cell(Coordinate aCord, Ocean l) {
        Viewer = l;
        offset = new Coordinate(aCord);
        image = DefaultImage;
    }
    public Cell(){
    }

    public Coordinate getOffset() {
        return offset;
    }

    public void setOffset(Coordinate anOffset) {
        offset = anOffset;
    }


    public char getImage() {
        return image;
    }


    public void display() {
        System.out.print(image);
    }


    public void process() {

    }
    public void afterProcess(){
        isProcess = true;
    }
}
