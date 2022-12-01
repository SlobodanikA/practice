package org.example;
import org.example.OceanInter;

public interface CellInter extends CONSTANTA{
    Coordinate getOffset();
    void setOffset(Coordinate anOffset);
    char getImage();
    void display();
    void process();
}
