package org.application;

import java.util.Objects;
import java.util.Vector;

public class PlotUtils {
    // we choose to check the validity of data when it is passed to a Plot
    public static boolean checkDataInput(Data input) {
        Vector<Number> x = input.getHorizontal();
        Vector<Number> y = input.getVertical();
        // x & y must not be null or empty
        if (Objects.isNull(x) || Objects.isNull(y)) {
            return false;
        }
        if (x.isEmpty() || y.isEmpty()) {
            return false;
        }
        // x must be sorted in ascending order
        if (!x.stream().sorted().toList().equals(x)) {
            return false;
        }
        // x & y must have the same size (each element of x must match with one element of y)
        if (x.size() != y.size()) {
            return false;
        }
        return true;
    }

    // Using Coordinates as WindowSize since it is 2 values
    public static Coordonates[] getAbscissa(Data input, Coordonates windowSize) {
        Coordonates[] coords = new Coordonates[2];
        coords[0] = new Coordonates((int) (windowSize.getX() * 0.1), (int) (windowSize.getY() * 0.9));
        coords[1] = new Coordonates((int) (windowSize.getX() * 0.9), (int) (windowSize.getY() * 0.9));
        return coords;
    }

    // Using Coordinates as WindowSize since it is 2 values
    public static Coordonates[] getOrdinate(Data input, Coordonates windowSize) {
        Coordonates[] coords = new Coordonates[2];
        coords[0] = new Coordonates((int) (windowSize.getX() * 0.1), (int) (windowSize.getY() * 0.1));
        coords[1] = new Coordonates((int) (windowSize.getX() * 0.1), (int) (windowSize.getY() * 0.9));
        return coords;
    }

}
