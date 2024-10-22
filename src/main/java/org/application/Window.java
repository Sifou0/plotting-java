package org.application;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class Window extends JFrame {

    private final Plot plot;
    private final Coordonates windowSize;

    public Window(Data data) {
        this.windowSize = new Coordonates(400, 400);
        this.plot = new Plot(this.windowSize, data);
        initWindow();
    }

    private void initWindow() {
        setTitle("Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.windowSize.getX(), this.windowSize.getY());
        add(this.plot);
    }

    public static void runWindow(Data data) {
        SwingUtilities.invokeLater(() -> new Window(data).setVisible(true));
    }

}
