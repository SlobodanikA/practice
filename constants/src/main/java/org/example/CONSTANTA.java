package org.example;

public abstract class CONSTANTA {
    public static final int MaxRows = 25;
    public static final int MinRows = 10;
    public static final int MaxCols = 70;
    public static final int MinCols = 10;
    public static final int MaxIterations = 10000;
    public static final int MinIterations = 10;
    public static final int MaxNumObstacles = MaxRows*MaxCols;
    public static final int MinNumObstacles = 0;
    public static final int DefaultNumObstacles = 75;
    public static final int DefaultNumPredators = 20;
    public static final int DefaultNumPrey = 150;
    public static final int DefaultNumIterations = 1000;
    public static final String DefaultImage = "\uD83C\uDFFF";
    public static final String DefaultPreyImage = "\uD83D\uDC1F";
    public static final String DefaultPredatorImage = "\uD83E\uDD88";
    public static final String ObstacleImage = "\uD83E\uDEB8";
    public static final String BorderImage = "\uD83D\uDFE8";

    public static final int TimeToFeed = 6;
    public static final int TimeToReproduce = 6;
    public static final int NumOfNeighbors = 4;
    public static final int NumBetweenIterations = 2000; //1000 = 1 second
}
// TODO Подивитись ЛайтВейгхт Патерн https://refactoring.guru/design-patterns/flyweight     UPDATE Не вийшло реалізувати через координати в клітині

// TODO Подивитись методи String    UPDATE Використав превентивний контроль введення даних
// TODO Накидать постановку

//FIXME:
// - Додати візуалізацію в вікні
