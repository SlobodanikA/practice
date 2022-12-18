package org.example;

public class Cell extends CONSTANTA {
    protected Ocean Viewer = null;
    protected Coordinate offset;
    protected String image;

    public Cell(Coordinate aCord, Ocean l) {
        Viewer = l;
        offset = new Coordinate(aCord);
        image = DefaultImage;
    }
    public String getImage() {
        return image;
    }
    public Cell(){
    }
    protected Cell getCallAt(Coordinate aCord) {
        return Viewer.getCell(aCord.getY(),aCord.getX());
    }
    protected Cell getNeighborWithImage(String anImage){
        Cell neighbors[] = new Cell[NumOfNeighbors];
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
            return neighbors[Random.nextIntBetween(0,count-1)];
        }
    }
    protected Coordinate getEmptyNeighborCoord(){
        return getNeighborWithImage(DefaultImage).getOffset();
    }
    protected Coordinate getPreyNeighborCoord(){
        return getNeighborWithImage(DefaultPreyImage).getOffset();
    }
    public Coordinate getOffset() {
        return offset;
    }
    protected void assignCellAt(Coordinate aCord, Cell aCell){
        Viewer.setCell(aCell,aCord);
    }
    protected Cell north(){
        int yValue;
        yValue = (offset.getY()>0) ? (offset.getY()-1):(Viewer.getNumRows()-1);
        return Viewer.getCell(yValue,offset.getX());
    }
    protected Cell south(){
        int yValue;
        yValue = (offset.getY()+1) % Viewer.getNumRows();
        return Viewer.getCell(yValue,offset.getX());
    }
    protected Cell east(){
        int xValue;
        xValue = (offset.getX()+1) % Viewer.getNumCols();
        return Viewer.getCell(offset.getY(),xValue);
    }
    protected Cell west(){
        int xValue;
        xValue = (offset.getX()>0)?(offset.getX()-1):(Viewer.getNumCols() - 1);
        return Viewer.getCell(offset.getY(),xValue);
    }
    protected Cell reproduce(Coordinate anOffset){
        Cell temp = new Cell(anOffset, this.Viewer);
        return temp;
    }
    public void setOffset(Coordinate anOffset) {
        offset = anOffset;
    }
    public void display() {
        System.out.print(image);
    }
    public void process() {

    }
}