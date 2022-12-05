package org.example;

public class Prey extends Cell {
    protected int timeToReproduce;
    protected void moveFrom(Coordinate from,Coordinate to){
        Cell workCell;//                              тут не используется?
        --timeToReproduce;
        if(to != from){
            //toCell=getCallAt(to);                 тут удалить финал?
            workCell = this;
            setOffset(to);
            assignCellAt(to, this);
            if(timeToReproduce <= 0){
                timeToReproduce = TimeToReproduce;
                assignCellAt(from, reproduce(from));
            }
            else{
                assignCellAt(from, new Cell(from));
            }
        }
    }
    protected Cell reproduce(Coordinate anOffset){
        Prey temp = new Prey(anOffset);
        Viewer.setNumPrey(Viewer.getNumPrey()+1);
        return temp;
    }
    public Prey(Coordinate aCoord){
        super(aCoord);
        timeToReproduce=TimeToReproduce;
        image = DefaultPreyImage;
    }
    public void process(){
        Coordinate toCoord;
        toCoord = getEmptyNeighborCoord();
        moveFrom(offset, toCoord);
        afterProcess();
    }
    public void afterProcess(){
        super.afterProcess();
    }
}
