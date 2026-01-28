package agh.ics.oop;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class PlotController {

    @FXML
    private LineChart<Number, Number> chart;

    public void initialize() {
        int n = 20;
        double[][] data = Calculus.mes(n);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("u(x)");

        for (double[] point : data) {
            series.getData().add(
                    new XYChart.Data<>(point[0], point[1])
            );
        }

        chart.getData().add(series);
    }
}
