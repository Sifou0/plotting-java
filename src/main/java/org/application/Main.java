package org.application;

import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Data data = DataUtils.getFunctionResultData(new Vector<>(List.of(0, 1, 2, 3, 4)), x -> x * x);
        Window.runWindow(data);
    }
}