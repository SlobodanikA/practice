package org.example;

public abstract class Validator extends CONSTANTA{
    public static void validateIterationsNumber(int numOfIterations) throws IncorrectNumberException {
        if (numOfIterations > MaxIterations|| numOfIterations < MinIterations) {
            throw new IncorrectNumberException("Incorrect number of Iterations. Changed to default", DefaultNumIterations);
        }
    }
    public static void validateObstaclesNumber(int numOfObstacles) throws IncorrectNumberException {
        if (numOfObstacles > MaxNumObstacles|| numOfObstacles< MinNumObstacles) {
            throw new IncorrectNumberException("Incorrect number of Obstacles. Changed to default", DefaultNumObstacles);
        }
    }
    public static void validatePreyNumber(int numOfPrey, Ocean l) throws IncorrectNumberException {
        if (numOfPrey >  MaxRows * MaxCols - l.getNumPredator() - l.getNumObstacles()|| numOfPrey < 1) {
            throw new IncorrectNumberException("Incorrect number of Prey. Changed to default", DefaultNumPrey);
        }
    }
    public static void validatePredatorNumber(int numOfPredators, Ocean l ) throws IncorrectNumberException {
        if (numOfPredators > MaxRows * MaxCols - l.getNumObstacles() || numOfPredators < 1) {
            throw new IncorrectNumberException("Incorrect number of Predators. Changed to default", DefaultNumPredators);
        }
    }
}
