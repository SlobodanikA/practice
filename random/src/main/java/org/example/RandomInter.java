package org.example;

public interface RandomInter {
    public void initialize();

    void init(int s1, int s2);

    public long randReal();
    public int nextIntBetween(int low, int high);
}
