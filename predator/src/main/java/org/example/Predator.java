package org.example;

public class Predator extends Prey {
    protected Cell reproduce(Coordinate anOffset){ //               Не дает сделать приватным
        Predator temp = new Predator(anOffset);
        Ocean1.setNumPredators(Ocean1.getNumPredator()+1);
        return temp;
    }
    protected int timeToFeed;
    public Predator(Coordinate aCoord) {
        super(aCoord);
        timeToFeed = TimeToFeed*2;
        image = DefaultPredatorImage;
    }



    public void process() {
        Coordinate toCoord;
        --timeToFeed;
        if (timeToFeed <= 0){
            assignCellAt(offset, new Cell(offset));
            Ocean1.setNumPredators(Ocean1.getNumPredator()-1);
            //finalize();                                          Как удалять и нужно ли вообще?
        }
        else{
            toCoord = getPreyNeighborCoord();
            if(toCoord != this.offset){
                Ocean1.setNumPrey(Ocean1.getNumPrey()-1);
                timeToFeed = TimeToFeed;
                moveFrom(offset,toCoord);
            }
            else {
                super.process();
            }
        }
    }
}
