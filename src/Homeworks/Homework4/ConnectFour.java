package Homeworks.Homework4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

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
    int highlightr1;
    int highlightc1;
    int highlightr2;
    int highlightc2;
    int highlightr3;
    int highlightc3;
    int highlightr4;
    int highlightc4;

    Circle p1_turn = new Circle(5,Color.RED);
    Circle p2_turn = new Circle(5,Color.TRANSPARENT);

    char[][] matrix = new char[7][6];

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        for(int i = 0; i < 7; i++){ for(int j = 0; j < 6; j++){ matrix[i][j] = ' '; } }

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

        if (player1){ matrix[0][col1_available] = 'R'; }
        else { matrix[0][col1_available] = 'Y'; }

        dropPiece(col1, col1_available);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol2() {
        if (col2_available == 0){ return; }
        col2_available -= 1;

        if (player1){ matrix[1][col2_available] = 'R'; }
        else { matrix[1][col2_available] = 'Y'; }

        dropPiece(col2,col2_available);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol3() {
        if (col3_available == 0){ return; }
        col3_available -= 1;

        if (player1) { matrix[2][col3_available] = 'R'; }
        else { matrix[2][col3_available] = 'Y'; }

        dropPiece(col3,col3_available);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol4() {
        if (col4_available == 0){ return; }
        col4_available -= 1;

        if (player1) { matrix[3][col4_available] = 'R'; }
        else { matrix[3][col4_available] = 'Y'; }

        dropPiece(col4,col4_available);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol5() {
        if (col5_available == 0){ return; }
        col5_available -= 1;

        if (player1) { matrix[4][col5_available]= 'R'; }
        else { matrix[4][col5_available] = 'Y'; }

        dropPiece(col5,col5_available);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol6() {
        if (col6_available == 0){ return; }
        col6_available -= 1;

        if (player1) { matrix[5][col6_available] = 'R'; }
        else { matrix[5][col6_available] = 'Y'; }

        dropPiece(col6,col6_available);
        checkWin();

        if (win == true || tie == true){ gameOver(); }
        else{ NextPlayer(); return;}
    }

    private void handleMouseClickCol7() {
        if (col7_available == 0){ return; }
        col7_available -= 1;

        if (player1) { matrix[6][col7_available] = 'R'; }
        else { matrix[6][col7_available] = 'Y'; }

        dropPiece(col7,col7_available);
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
    }//Crunch Wrap

    private void checkWin(){
        if(col1_available == 0 && col2_available == 0 && col3_available == 0 && col4_available == 0 && col5_available == 0 && col6_available == 0 && col7_available == 0){ tie = true; }
        for( int row = 0; row < 6; row++){
            for (int col = 0; col < 4; col++){
                if(matrix[col][row] == ' '){ dummy += 0; }
                else if (matrix[col][row] == matrix[col+1][row] && matrix[col][row] == matrix[col+2][row] && matrix[col][row] == matrix[col+3][row]){
                    win = true;

                    highlightr1 = row;
                    highlightr2 = row;
                    highlightr3 = row;
                    highlightr4 = row;

                    highlightc1 = col;
                    highlightc2 = col+1;
                    highlightc3 = col+2;
                    highlightc4 = col+3;

                    highlight();
                }//if horizontal win
            }//column for loop
        }//row for loop

        for (int col = 0; col < 7; col++){
            for (int row = 0; row < 3; row++){
                if(matrix[col][row] == ' '){ dummy += 0; }
                else if(matrix[col][row] == matrix[col][row+1] && matrix[col][row] == matrix[col][row+2] && matrix[col][row] == matrix[col][row+3]){
                    win = true;

                    highlightr1 = row;
                    highlightr2 = row+1;
                    highlightr3 = row+2;
                    highlightr4 = row+3;

                    highlightc1 = col;
                    highlightc2 = col;
                    highlightc3 = col;
                    highlightc4 = col;

                    highlight();
                }//if vertical win
            }//row for loop
        }//column for loop

        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 4; col++){
                if(matrix[col][row] == ' '){ dummy += 0; }
                else if (matrix[col][row] == matrix[col+1][row+1] && matrix[col][row] == matrix[col+2][row+2] && matrix[col][row] == matrix[col+3][row+3]){
                    win = true;

                    highlightr1 = row;
                    highlightr2 = row+1;
                    highlightr3 = row+2;
                    highlightr4 = row+3;

                    highlightc1 = col;
                    highlightc2 = col+1;
                    highlightc3 = col+2;
                    highlightc4 = col+3;

                    highlight();
                }//if \ diagonal win
            }//column for loop
        }//row for loop

        for(int row = 0; row < 3; row++){
            for(int col = 3; col < 7; col ++){
                if(matrix[col][row] == ' '){ dummy += 0;}
                else if (matrix[col][row] == matrix[col-1][row+1] && matrix[col][row] == matrix[col-2][row+2] && matrix[col][row] == matrix[col-3][row+3]){
                    win = true;

                    highlightr1 = row;
                    highlightr2 = row+1;
                    highlightr3 = row+2;
                    highlightr4 = row+3;

                    highlightc1 = col;
                    highlightc2 = col-1;
                    highlightc3 = col-2;
                    highlightc4 = col-3;

                    highlight();
                }//if / diagonal win
            }//column for loop
        }//row for loop
    }

    private void highlight() {
        ArrayList<Circle> col = col1;
        if(highlightc1 == 0){ col = col1; }
        else if (highlightc1 == 1){ col = col2; }
        else if (highlightc1 == 2){ col = col3; }
        else if (highlightc1 == 3){ col = col4; }
        else if (highlightc1 == 4){ col = col5; }
        else if (highlightc1 == 5){ col = col6; }
        else if (highlightc1 == 6){ col = col7; }

        col.get(highlightr1).setFill(Color.PLUM);

        if(highlightc2 == 0){ col = col1; }
        else if (highlightc2 == 1){ col = col2; }
        else if (highlightc2 == 2){ col = col3; }
        else if (highlightc2 == 3){ col = col4; }
        else if (highlightc2 == 4){ col = col5; }
        else if (highlightc2 == 5){ col = col6; }
        else if (highlightc2 == 6){ col = col7; }

        col.get(highlightr2).setFill(Color.PLUM);

        if(highlightc3 == 0){ col = col1; }
        else if (highlightc3 == 1){ col = col2; }
        else if (highlightc3 == 2){ col = col3; }
        else if (highlightc3 == 3){ col = col4; }
        else if (highlightc3 == 4){ col = col5; }
        else if (highlightc3 == 5){ col = col6; }
        else if (highlightc3 == 6){ col = col7; }

        col.get(highlightr3).setFill(Color.PLUM);

        if(highlightc4 == 0){ col = col1; }
        else if (highlightc4 == 1){ col = col2; }
        else if (highlightc4 == 2){ col = col3; }
        else if (highlightc4 == 3){ col = col4; }
        else if (highlightc4 == 4){ col = col5; }
        else if (highlightc4 == 5){ col = col6; }
        else if (highlightc4 == 6){ col = col7; }

        col.get(highlightr4).setFill(Color.PLUM);
    } //Crunch Wrap

    private void dropPiece(ArrayList<Circle> col, int available) {
        if (available < 0){ return; }
        if (player1){ col.get(available).setFill(Color.RED); }
        else { col.get(available).setFill(Color.YELLOW); }
    }//Crunch Wrap
}