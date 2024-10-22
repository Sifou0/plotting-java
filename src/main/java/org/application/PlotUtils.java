package org.application;

import java.util.ArrayList;
import java.util.List;
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

    public static List<Coordonates> getAllCoordinates(Data input, Coordonates windowSize) {
        List<Coordonates> coords = new ArrayList<>();
        // Horizontal and Vertical from input have the same size
        // Define the size of 1 and scale from it
        int unitX = (int) (windowSize.getX() * 0.008);
        int unitY = (int) (windowSize.getY() * 0.008);
        System.out.println(unitX + " " + unitY);
        for (int i = 0; i < input.getHorizontal().size(); i++) {
            coords.add(new Coordonates(unitX * input.getHorizontal().get(i).intValue(), unitY * input.getVertical().get(i).intValue()));
        }
        coords.stream().forEach(System.out::println);
        return coords;
    }

}
