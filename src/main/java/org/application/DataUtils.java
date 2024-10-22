package org.application;

import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataUtils {

    @SuppressWarnings("unchecked")
    public static <K extends Number, T extends Number> Data getFunctionResultData(Vector<K> inputs, Function<K,T> function) {
        Vector<T> results = inputs.stream().map(function).collect(Collectors.toCollection(Vector::new));
        return new Data((Vector<Number>) inputs, (Vector<Number>) results);
    }
}
