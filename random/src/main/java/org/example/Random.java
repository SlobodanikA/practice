package org.example;


public class Random implements RandomInter{
    private static boolean first = true;
    private final int MAX = 32767;
    private int seed1;
    private int seed2;

    @Override
    public void initialize(){
        seed1 = 3797;
        seed2 = 2117;
    }

    @Override
    public void init(int s1, int s2){
        seed1 = s1;
        seed2 = s2;
    }

    @Override
    public long randReal() {
        int c;
        if(first){
            seed1 *= 2;
            seed2 *= 2;
            if(seed1 > MAX){
                seed1 -= MAX;
            }
            if(seed2 > MAX){
                seed2 -= MAX;
            }
            first = false;
            for(int i = 1; i <= 30; i++){
                randReal();
            }
        }
        c = seed1 + seed2;
        if(c > MAX){
            c -= MAX;
        }
        c *= 2;
        if(c > MAX){
            c -= MAX;
        }
        seed1 = seed2;
        seed2 = c;
        return c/3267;
    }

    @Override
    public int nextIntBetween(int low, int high) {
        float r, t;
        int c;

        r = (float) (high - low + 1.0);
        t = r * randReal();
        c = (int) t;
        return (low + c);
    }

}
