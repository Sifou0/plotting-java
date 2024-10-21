package org.example;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class Window extends JFrame {

    private final Plot plot;
    private final Coordonates windowSize;

    public Window() {
        this.windowSize = new Coordonates(400,400);
        this.plot = new Plot(this.windowSize,new Data(new Vector<>(List.of(1,2)),new Vector<>(List.of(1,2))));
        initWindow();
    }

    private void initWindow() {
        setTitle("Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.windowSize.getX(), this.windowSize.getY());
        add(this.plot);
    }

    public static void runWindow() {
        SwingUtilities.invokeLater(() -> new Window().setVisible(true));
    }

}
