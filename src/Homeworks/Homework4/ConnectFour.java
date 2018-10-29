package Homeworks.Homework4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnectFour extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        Pane board = new Board();
        board.setStyle("-fx-background-color: #0f2439");

        //TODO: Add player logic
        //TODO: Add click command
        boolean player1 = true;

        int p1_num_wins = 0;
        int p2_num_wins = 0;
        int num_ties = 0;
        Text p1Wins = new Text();
        p1Wins.setText(Integer.toString(p1_num_wins));
        Text ties = new Text();
        ties.setText(Integer.toString(num_ties));
        Text p2Wins = new Text();
        p2Wins.setText(Integer.toString(p2_num_wins));


        Circle p1_turn = new Circle(5,Color.RED);
        Circle p2_turn = new Circle(5,Color.WHITE);

        //TODO: Add win logic
        //TODO: Add Graphic for win

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.add(p1_turn,3,0);
        gridPane.add(new Label("Player 1"),4,0);
        gridPane.add(new Label("Ties"),14,0);
        gridPane.add(p2_turn,23,0);
        gridPane.add(new Label("Player 2"),24,0);
        gridPane.add(p1Wins,4,1);
        gridPane.add(ties,14,1);
        gridPane.add(p2Wins,24,1);

        borderPane.setCenter(board);
        borderPane.setBottom(gridPane);
        borderPane.setPrefSize(400,400);

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
