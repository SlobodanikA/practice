package org.example;
import org.example.CellInter;

public class Obstacle extends Cell {
    public Obstacle(Coordinate aCoord){
        super(aCoord);
        image = ObstacleImage;
    }
}
