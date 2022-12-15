package org.example;

public abstract class CONSTANTA {
    public static final int MaxRows = 25;
    public static final int MaxCols = 70;

    public static final int DefaultNumObstacles = 75;
    public static final int DefaultNumPredators = 20;
    public static final int DefaultNumPrey = 150;
    public static final int DefaultNumIterations = 1000;
    public static final char DefaultImage = '-';
    public static final char DefaultPreyImage = 'f';
    public static final char DefaultPredatorImage = 'S';
    public static final char ObstacleImage = '#';

    public static final int TimeToFeed = 6;
    public static final int TimeToReproduce = 6;
    public static final int NumOfNeighbors = 4;
    public static final int NumBetweenIterations = 2000; //1000 = 1 second
}

// TODO Подивитись патерн Визитор https://refactoring.guru/uk/design-patterns/visitor       UPDATE Продивився
// TODO Подивитись ЛайтВейгхт Патерн https://refactoring.guru/design-patterns/flyweight     UPDATE Продивився

// TODO Подивитись методи String    UPDATE Подивитись додатково
// TODO Додати нове виключення      UPDATE Перенести виклик в Ocean
// TODO Виділити інші константи     UPDATE иділяв текстові константи

//FIXME:
// - Перенести перевірку на введені дані з OceanViewer до Ocean
// - Додати візуалізацію
