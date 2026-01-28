package agh.ics.oop;
import javax.swing.*;
import java.awt.*;

public class PlotFrame extends JFrame {

    public PlotFrame(double[][] data) {
        setTitle("Wykres u(x)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new PlotPanel(data));
        setVisible(true);
    }
}
