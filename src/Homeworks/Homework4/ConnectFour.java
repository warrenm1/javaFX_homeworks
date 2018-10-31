package Homeworks.Homework4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ConnectFour extends Application {
    Pane board = new Board();

    ArrayList<Circle> col1 = ((Board) board).col1Circles();
    ArrayList<Circle> col2 = ((Board) board).col2Circles();
    ArrayList<Circle> col3 = ((Board) board).col3Circles();
    ArrayList<Circle> col4 = ((Board) board).col4Circles();
    ArrayList<Circle> col5 = ((Board) board).col5Circles();
    ArrayList<Circle> col6 = ((Board) board).col6Circles();
    ArrayList<Circle> col7 = ((Board) board).col7Circles();

    boolean player1 = true;
    boolean win = false;
    boolean tie = false;

    int col1_available = 6;
    int col2_available = 6;
    int col3_available = 6;
    int col4_available = 6;
    int col5_available = 6;
    int col6_available = 6;
    int col7_available = 6;
    int dummy = 0;
    int highlighti1;
    int highlightj1;
    int highlighti2;
    int highlightj2;
    int highlighti3;
    int highlightj3;
    int highlighti4;
    int highlightj4;

    Circle p1_turn = new Circle(5,Color.RED);
    Circle p2_turn = new Circle(5,Color.TRANSPARENT);

    char[][] matrix = new char[6][7];

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        for(int i = 0; i < 6; i++){ for(int j = 0; j < 7; j++){ matrix[i][j] = ' '; } }

        ((Board) board).getColumn1().setOnMouseClicked(e -> handleMouseClickCol1());
        ((Board) board).getColumn2().setOnMouseClicked(e -> handleMouseClickCol2());
        ((Board) board).getColumn3().setOnMouseClicked(e -> handleMouseClickCol3());
        ((Board) board).getColumn4().setOnMouseClicked(e -> handleMouseClickCol4());
        ((Board) board).getColumn5().setOnMouseClicked(e -> handleMouseClickCol5());
        ((Board) board).getColumn6().setOnMouseClicked(e -> handleMouseClickCol6());
        ((Board) board).getColumn7().setOnMouseClicked(e -> handleMouseClickCol7());

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.add(p1_turn,3,0);
        gridPane.add(new Label("Player 1"),4,0);
        gridPane.add(p2_turn,23,0);
        gridPane.add(new Label("Player 2"),24,0);

        borderPane.setCenter(board);
        borderPane.setBottom(gridPane);
        borderPane.setPrefSize(400,400);

        Scene scene = new Scene(borderPane, 400, 375);
        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void handleMouseClickCol1() {
        if (col1_available == 0){ return; }
        col1_available -= 1;

        if (player1){ matrix[col1_available][0] = 'R'; }
        else { matrix[col1_available][0] = 'Y'; }

        dropPiece(col1);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol2() {
        if (col2_available == 0){ return; }
        col2_available -= 1;

        if (player1){ matrix[col2_available][1] = 'R'; }
        else { matrix[col2_available][1] = 'Y'; }

        dropPiece(col2);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol3() {
        if (col3_available == 0){ return; }
        col3_available -= 1;

        if (player1) { matrix[col3_available][2] = 'R'; }
        else { matrix[col3_available][2] = 'Y'; }

        dropPiece(col3);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol4() {
        if (col4_available == 0){ return; }
        col4_available -= 1;

        if (player1) { matrix[col4_available][3] = 'R'; }
        else { matrix[col4_available][3] = 'Y'; }

        dropPiece(col4);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol5() {
        if (col5_available == 0){ return; }
        col5_available -= 1;

        if (player1) { matrix[col5_available][4] = 'R'; }
        else { matrix[col5_available][4] = 'Y'; }

        dropPiece(col5);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol6() {
        if (col6_available == 0){ return; }
        col6_available -= 1;

        if (player1) { matrix[col6_available][5] = 'R'; }
        else { matrix[col6_available][5] = 'Y'; }

        dropPiece(col6);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol7() {
        if (col7_available == 0){ return; }
        col7_available -= 1;

        if (player1) { matrix[col7_available][6] = 'R'; }
        else { matrix[col7_available][6] = 'Y'; }

        dropPiece(col7);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void gameOver() {
        Button bt = new Button("Exit");
        Text text = new Text();
        Text text2 = new Text("Congratumalations!");

        FlowPane flowPane = new FlowPane(10,5);
        flowPane.getChildren().add(0, text);
        flowPane.getChildren().add(1,text2);
        flowPane.getChildren().add(2,bt);

        System.out.println("Got to this point");

        Scene newScene = new Scene(flowPane,250,50);
        Stage ng = new Stage();
        ng.setTitle("Game Over");
        if (tie == true){ text.setText("CAT"); }
        else if (player1){ text.setText("Player 1 Wins"); }
        else { text.setText("Player 2 Wins"); }

        ng.setScene(newScene);
        ng.show();

        bt.setOnAction(e -> Platform.exit());
    }

    private void NextPlayer() {
        if (player1){
            player1 = false;
            p1_turn.setFill(Color.TRANSPARENT);
            p2_turn.setFill(Color.YELLOW);
        }
        else {
            player1 = true;
            p1_turn.setFill(Color.RED);
            p2_turn.setFill(Color.TRANSPARENT);
        }
        return;
    }

    private void checkWin(){
        //Checking if the game is a tie
        if(col1_available == 0 && col2_available == 0 && col3_available == 0 && col4_available == 0 && col5_available == 0 && col6_available == 0 && col7_available == 0){
            tie = true;
        }
        //check win
        //horizontal win
        for( int i = 0; i < 6; i++){
            for(int j = 0; j < 4; j++) {
                if (matrix[i][j] == ' ') {
                    dummy += 0;
                } else if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j] == matrix[i][j + 2] && matrix[i][j] == matrix[i][j + 3]) {
                    win = true;
                    //highlight elements
                    highlighti1 = i;
                    highlighti2 = i;
                    highlighti3 = i;
                    highlighti4 = i;

                    highlightj1 = j;
                    highlightj2 = j+1;
                    highlightj3 = j+2;
                    highlightj4 = j+3;

                    highlight();
                }
            }
        }

        //vertical win
        for( int j = 0; j < 7; j++){
            for (int i = 0; i < 3; i++){
                if (matrix[i][j] == ' '){ dummy += 0; }
                else if (matrix[i][j] == matrix[i+1][j] && matrix[i][j] == matrix [i+2][j] && matrix[i][j] == matrix[i+3][j]){
                    win = true;
                    //highlight elements
                    highlighti1 = i;
                    highlighti2 = i+1;
                    highlighti3 = i+2;
                    highlighti4 = i+3;

                    highlightj1 = j;
                    highlightj2 = j;
                    highlightj3 = j;
                    highlightj4 = j;

                    highlight();
                }
            }
        }

        // diagonal \ win
        for( int i = 0; i < 3; i++){
            for (int j = 0; j < 4; j++){
                if (matrix[i][j] == ' '){ dummy += 0; }
                else if (matrix[i][j] == matrix[i+1][j+1] && matrix[i][j] == matrix[i+2][j+2] && matrix[i][j] == matrix[i+3][j+3]){
                    win = true;
                    //highlight elements
                    highlighti1 = i;
                    highlighti2 = i+1;
                    highlighti3 = i+2;
                    highlighti4 = i+3;

                    highlightj1 = j;
                    highlightj2 = j+1;
                    highlightj3 = j+2;
                    highlightj4 = j+3;

                    highlight();
                }
            }
        }

        // diagonal / win
        for(  int i = 0; i < 3; i++){
            for( int j = 4; j < 7; j++){
                if (matrix[i][j] == ' '){ dummy += 0; }
                else if (matrix[i][j] == matrix[i+1][j-1] && matrix[i][j] == matrix[i+2][j-2] && matrix[i][j] == matrix[i+3][j-3]){
                    win = true;
                    //highlight elements
                    highlighti1 = i;
                    highlighti2 = i+1;
                    highlighti3 = i+2;
                    highlighti4 = i+3;

                    highlightj1 = j;
                    highlightj2 = j-1;
                    highlightj3 = j-2;
                    highlightj4 = j-3;

                    highlight();
                }
            }
        }
        return;
    }

    private void highlight() {
    }

    private void dropPiece(ArrayList<Circle> col) {
    }
}


