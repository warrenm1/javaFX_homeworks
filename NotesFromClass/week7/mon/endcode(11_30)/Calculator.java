package week7.mon;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Calculator extends Application {
    private TextField num1 = new TextField();
    private TextField num2 = new TextField();
    private TextField answer = new TextField();
    private Button sum = new Button("+");
    private Label ansLbl = new Label("answer: ");

    public void start(Stage myStage) {
        ansLbl.setAlignment(Pos.BOTTOM_RIGHT);
        sum.setFont(Font.font(15));
        GridPane grid1 = new GridPane();
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.add(num1, 0, 0);
        grid1.add(num2, 1, 0);
        grid1.add(sum, 1, 1);
        grid1.add(answer, 1, 2);
        grid1.add(ansLbl, 0, 2);

        GridPane.setHalignment(sum, HPos.RIGHT);


        // Create a scene and place it in the stage
        Scene scene = new Scene(grid1, 400, 250);
        myStage.setTitle("LoanCalculator"); // Set title
        myStage.setScene(scene); // Place the scene in the stage
        myStage.show(); // Display the stage
    }

}
