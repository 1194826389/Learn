package com.learn.basicthread.concurrency.synchronize.sampletwo;

/**
 * Created by hechao on 2017/5/9.
 */
public class Pair {
    private int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void increamentX() {
        x++;
    }

    public void increamentY() {
        y++;
    }

    @Override
    public String toString() {
        return "x:" + x + ", y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}
