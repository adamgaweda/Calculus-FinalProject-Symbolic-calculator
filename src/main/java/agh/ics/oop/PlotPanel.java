package agh.ics.oop;

import javax.swing.*;
import java.awt.*;

class PlotPanel extends JPanel {

    private final double[][] data;

    PlotPanel(double[][] data) {
        this.data = data;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();
        int margin = 50;

        // osie
        g2.drawLine(margin, h - margin, w - margin, h - margin);
        g2.drawLine(margin, margin, margin, h - margin);

        double xmin = data[0][0];
        double xmax = data[data.length - 1][0];
        double ymin = Double.MAX_VALUE;
        double ymax = -Double.MAX_VALUE;

        for (double[] p : data) {
            ymin = Math.min(ymin, p[1]);
            ymax = Math.max(ymax, p[1]);
        }
        ymin-=0.2;
        ymax+=0.2;

        // wykres
        for (int i = 0; i < data.length - 1; i++) {
            int x1 = margin + (int) ((data[i][0] - xmin) / (xmax - xmin) * (w - 2 * margin));
            int y1 = h - margin - (int) ((data[i][1] - ymin) / (ymax - ymin) * (h - 2 * margin));

            int x2 = margin + (int) ((data[i + 1][0] - xmin) / (xmax - xmin) * (w - 2 * margin));
            int y2 = h - margin - (int) ((data[i + 1][1] - ymin) / (ymax - ymin) * (h - 2 * margin));

            g2.drawLine(x1, y1, x2, y2);
        }
    }
}
