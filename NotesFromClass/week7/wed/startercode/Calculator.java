package week7.wed;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    private TextField t1 = new TextField();
    private TextField t2 = new TextField();
    private Button btAdd = new Button ("+");
    private Label answer = new Label();

    public void start(Stage myStage) {
        GridPane grid1 = new GridPane();

        grid1.setHgap(10);
        grid1.setVgap(10);

        grid1.add(t1, 0, 0);
        grid1.add(t2, 2, 0);
        grid1.add(btAdd, 1, 0);
        grid1.add(answer, 1, 1);

        btAdd.setOnAction(e -> calculate());
        Scene scene = new Scene(grid1, 400, 250);
        myStage.setTitle("LoanCalculator"); // Set title
        myStage.setScene(scene); // Place the scene in the stage
        myStage.show(); // Display the stage
    }

    private void calculate() {
        double x = Double.parseDouble(t1.getText());
        double y = Double.parseDouble(t2.getText());

        answer.setText(Double.toString(x+y));
    }

}
