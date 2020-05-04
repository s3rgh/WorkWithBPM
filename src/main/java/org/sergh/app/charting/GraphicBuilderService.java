package org.sergh.app.charting;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import org.sergh.app.execution.ExecutorCallsService;

import java.util.List;

public class GraphicBuilderService extends Application implements GraphicBuilder {

    private List<Integer> listOfTimesForRequest = ExecutorCallsService.getListOfTimesForRequest();

    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(new Group());
        stage.setTitle("Times for requests");
        stage.setWidth(500);
        stage.setHeight(500);

        int max = GraphicBuilderService.maxTimeForRequest(listOfTimesForRequest);
        int min = GraphicBuilderService.minTimeForRequest(listOfTimesForRequest);
        double average = GraphicBuilderService.averageTimeForRequest(listOfTimesForRequest);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("maxTime = " + max + "ms", max),
                        new PieChart.Data("minTime = " + min + "ms", min),
                        new PieChart.Data("averageTime = " + average + "ms", average));


        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Times for requests");
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    private static int maxTimeForRequest(List<Integer> list) {

        return list.stream().mapToInt(number -> number).max().orElse(Integer.MIN_VALUE);

    }

    private static int minTimeForRequest(List<Integer> list) {

        return list.stream().mapToInt(number -> number).min().orElse(Integer.MAX_VALUE);

    }

    private static double averageTimeForRequest(List<Integer> list) {
        long sum = 0;
        for (Integer integer : list) {
            sum = sum + integer;
        }
        return (double) sum / list.size();
    }
}