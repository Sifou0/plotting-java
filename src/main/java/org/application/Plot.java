package org.application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class Plot extends JPanel {

    private final Coordonates windowSize;
    private final Data data;
    private final Coordonates[] ordinate;
    private final Coordonates[] abscissa;
    private List<Coordonates> points;

    public Plot(Coordonates windowSize, Data data) {
        this.windowSize = windowSize;
        this.data = data;
        this.points = new ArrayList<Coordonates>();
        this.initPlot();
        this.ordinate = PlotUtils.getOrdinate(this.data, this.windowSize);
        this.abscissa = PlotUtils.getAbscissa(this.data, this.windowSize);
    }

    // All the Plot verification are done here
    private void initPlot() {
        if (!PlotUtils.checkDataInput(this.data)) {
            // TODO: throw an error
        }
        // TODO: data process so it can be plot-ed
        this.points = PlotUtils.getAllCoordinates(this.data, this.windowSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.drawLine(ordinate[0].getX(), ordinate[0].getY(), ordinate[1].getX(), ordinate[1].getY());
        g2d.drawLine(abscissa[0].getX(), abscissa[0].getY(), abscissa[1].getX(), abscissa[1].getY());
        this.points.stream().forEach(point -> g2d.drawLine(point.getX(), point.getY(), point.getX(), point.getY()));
    }
}
