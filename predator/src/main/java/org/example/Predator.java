package org.example;

public class Predator extends Prey {
    protected int timeToFeed;
    protected Cell reproduce(Coordinate anOffset){ //               Не дает сделать приватным
        Predator temp = new Predator(anOffset, this.Viewer);
        Viewer.setNumPredators(Viewer.getNumPredator()+1);
        return temp;
    }
    public Predator(Coordinate aCoord, Ocean l) {
        super(aCoord, l);
        timeToFeed = TimeToFeed;
        image = DefaultPredatorImage;
    }
    public void process() {
        Coordinate toCoord;
        --timeToFeed;
        if (timeToFeed <= 0){
            assignCellAt(offset, new Cell(offset, this.Viewer));
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
    }
}
