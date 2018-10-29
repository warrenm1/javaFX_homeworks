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
    private Button btMinus = new Button("-");
    private Button btMultiply = new Button("*");
    private Button btDivide = new Button("/");


    public void start(Stage myStage) {
        GridPane grid1 = new GridPane();

        grid1.setHgap(10);
        grid1.setVgap(10);

        grid1.add(t1, 0, 0);
        grid1.add(t2, 0, 1);
        grid1.add(btAdd, 1, 0);
        grid1.add(btMinus, 1, 1);
        grid1.add(btMultiply, 1, 2);
        grid1.add(btDivide, 1, 3);
        grid1.add(answer, 0, 2);

        btMinus.setOnAction(e -> subtract());
        btAdd.setOnAction(e -> add());
        btMultiply.setOnAction(e -> multiply());
        btDivide.setOnAction(e -> divide());
        Scene scene = new Scene(grid1, 400, 250);
        myStage.setTitle("LoanCalculator"); // Set title
        myStage.setScene(scene); // Place the scene in the stage
        myStage.show(); // Display the stage
    }

    private void add() {
        double x = Double.parseDouble(t1.getText());
        double y = Double.parseDouble(t2.getText());

        answer.setText(Double.toString(x+y));

    }

    private void subtract() {
        double x = Double.parseDouble(t1.getText());
        double y = Double.parseDouble(t2.getText());

        answer.setText(Double.toString(x-y));
    }

    private void multiply() {
        double comeToClassAustin = Double.parseDouble(t1.getText());
        double y = Double.parseDouble(t2.getText());

        answer.setText(Double.toString(comeToClassAustin*y));
    }

    private void divide()
    {
        double x = Double.parseDouble(t1.getText());
        double y = Double.parseDouble(t2.getText());

        answer.setText(Double.toString(x / y));
    }

}
