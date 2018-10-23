package week5.fri;
//Demo Line color, width
//Demo Removing each Property
//make a square with Lines

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class ShowLine extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(new LinePane(), 200, 200);
        primaryStage.setTitle("ShowLine"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

class LinePane extends Pane {
    public LinePane() {
        Line line1 = new Line(10, 10, 10, 10);
        line1.endXProperty().bind(widthProperty().subtract(10));
        //line1.endYProperty().bind(heightProperty().subtract(10));
        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);
        getChildren().add(line1);

        Line line2 = new Line(10, 10, 10, 10);
        line2.startXProperty().bind(widthProperty().subtract(10));
        line2.endYProperty().bind(heightProperty().subtract(10));
        line2.endXProperty().bind(widthProperty().subtract(10));
        line2.setStrokeWidth(5);
        line2.setStroke(Color.web("#0F2439"));
        getChildren().add(line2);

        Line line3 = new Line(10, 10, 10, 10);
        line3.startXProperty().bind(widthProperty().subtract(10));
        line3.startYProperty().bind(heightProperty().subtract(10));
        line3.endYProperty().bind(heightProperty().subtract(10));
        line3.setStrokeWidth(5);
        line3.setStroke(Color.RED);
        getChildren().add(line3);

        Line line4 = new Line(10, 10, 10, 10);
        line4.startYProperty().bind(heightProperty().subtract(10));
        line4.setStrokeWidth(5);
        line4.setStroke(Color.ORANGE);
        getChildren().add(line4);

    }
}
