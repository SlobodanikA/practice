package org.example;

public class Predator extends Prey {
    protected Cell reproduce(Coordinate anOffset){ //               Не дает сделать приватным
        Predator temp = new Predator(anOffset);
        Viewer.setNumPredators(Viewer.getNumPredator()+1);
        return temp;
    }
    protected int timeToFeed;
    public Predator(Coordinate aCoord) {
        super(aCoord);
        timeToFeed = TimeToFeed;
        image = DefaultPredatorImage;
    }



    public void process() {
        Coordinate toCoord;
        --timeToFeed;
        if (timeToFeed <= 0){
            assignCellAt(offset, new Cell(offset));
            Viewer.setNumPredators(Viewer.getNumPredator()-1);
            //finalize();                                          Как удалять и нужно ли вообще?
        }
        else{
            toCoord = getPreyNeighborCoord();
            if(toCoord != this.offset){
                Viewer.setNumPrey(Viewer.getNumPrey()-1);
                timeToFeed = TimeToFeed;
                moveFrom(offset,toCoord);
            }
            else {
                super.process();
            }
        }
        afterProcess();
    }
    public void afterProcess() {
        super.afterProcess();
    }
}
