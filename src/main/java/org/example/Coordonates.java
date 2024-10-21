package org.example;

public class Coordonates {

    private int x;
    private int y;

    public Coordonates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordonates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
