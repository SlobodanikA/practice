package org.example;

public class Prey extends Cell {
    protected int timeToReproduce;
    protected void moveFrom(Coordinate from,Coordinate to){
        --timeToReproduce;
        if(to != from){
            setOffset(to);
            assignCellAt(to, this);
            if(timeToReproduce <= 0){
                timeToReproduce = TimeToReproduce;
                assignCellAt(from, reproduce(from));
            }
            else{
                assignCellAt(from, new Cell(from, this.Viewer));
            }
        }
    }
    protected Cell reproduce(Coordinate anOffset){
        Prey temp = new Prey(anOffset, this.Viewer);
        Viewer.setNumPrey(Viewer.getNumPrey()+1);
        return temp;
    }
    public Prey(Coordinate aCoord,Ocean l){
        super(aCoord, l);
        timeToReproduce= Random.nextIntBetween(4,8); //Допускаються числа
        image = DefaultPreyImage;
    }
    public void process(){
        Coordinate toCoord;
        toCoord = getEmptyNeighborCoord();
        moveFrom(offset, toCoord);
    }
}
