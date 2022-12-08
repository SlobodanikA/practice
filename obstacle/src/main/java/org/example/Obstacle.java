package org.example;

public class Obstacle extends Cell {
    public Obstacle(Coordinate aCoord, Ocean l){
        super(aCoord, l);
        image = ObstacleImage;
    }
}
