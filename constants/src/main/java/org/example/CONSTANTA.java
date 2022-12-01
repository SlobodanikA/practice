package org.example;

public abstract interface CONSTANTA {
    public static final int MaxRows = 25;
    public static final int MaxCols = 70;

    public static final int DefaultNumObstacles = 75;
    public static final int DefaultNumPredators = 20;
    public static final int DefaultNumPrey = 150;
    public static final int DefaultNumIterations = 1000;

    public static final char DefaultImage = '-';
    public static final char DefaultPreyImage = 'f';
    public static final char DefaultPredImage = 'S';
    public static final char ObstacleImage = '#';

    public static final int TimeToFeed = 6;
    public static final int TimeToReproduce = 6;
}
