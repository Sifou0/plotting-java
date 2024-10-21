package org.example;

import java.util.Vector;

public class Data {
    private Vector<Number> horizontal;
    private Vector<Number> vertical;

    public Data(Vector<Number> horizontal, Vector<Number> vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public Vector<Number> getVertical() {
        return vertical;
    }

    public Vector<Number> getHorizontal() {
        return horizontal;
    }
}
