package org.example;
import org.example.RandomInter;
import org.example.Coordinate;
import org.example.CellInter;
import org.example.CONSTANTA;
public interface OceanInter{
    int getNumPrey();
    int getNumPredator();
    void setNumPrey(int num);
    void setNumPredators(int num);
    void initialize();
    void run();
}
