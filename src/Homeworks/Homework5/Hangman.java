package Homeworks.Homework5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Hangman extends Application {

    public HangingMan man = new HangingMan();
    public Board board = new Board();
    public Pane guessedLetters = new Pane();
    public Text guessedLettersText = new Text("\t\t\t\t\t\t\t\t\t\tWrong Letters:\t");
    public List<String> GameMusic = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        Gallows gallows = new Gallows();

        GameMusic.add("src\\music\\Epic Boss Battle.mp3");
        GameMusic.add("src\\music\\Epic Game Reverb Challenge.mp3");
        GameMusic.add("src\\music\\Percussionary Beats.mp3");

        int rand = (int)(Math.random()*GameMusic.size());

        Media media = new Media(new File(GameMusic.get(rand)).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(14.0);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mediaView = new MediaView(mediaPlayer);
        Pane pane = new Pane(mediaView);

        guessedLettersText.setFont(Font.font("Times New Roman",24));
        guessedLettersText.setFill(Color.BLACK);
        guessedLetters.getChildren().add(guessedLettersText);

        //board.getBtCheck().setOnAction(e -> checkingHandler());
        board.getTfguess().setOnKeyPressed(e ->  enter(e.getCode()));

        //Finished Product
        gallows.getChildren().add(man);
        borderPane.setCenter(gallows);
        borderPane.setRight(board);
        borderPane.setTop(pane);
        borderPane.setBottom(guessedLetters);

        Scene scene = new Scene(borderPane,850,600);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void enter(KeyCode code) {
        if (code == KeyCode.ENTER)
            checkingHandler();
    }

    private void checkingHandler() {
        if (!board.beenGuessed(board.getTfguess().getText().charAt(0))) {
            if (board.CheckCorrect(board.getTfguess().getText())) { man.correct(); }
            else {
                man.incrementError();
                board.addGuessedLetters(board.getTfguess().getText());
                guessedLettersText.setText(guessedLettersText.getText() + " " + board.getTfguess().getText());
            }
        }

        board.getTfguess().clear();

        if(man.getError() == 6){
            board.displayRemainingLetters();
            GameOver("Epic Fail");
        }

        boolean checkCorrect = board.checkIfComplete();

        if (checkCorrect){
            man.win();
            GameOver(new String("Victory"));
        }
    }

    public void GameOver(String message){
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        DropShadow ds = new DropShadow();

        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Button button = new Button("Exit");
        Button ngButton = new Button("New Game");
        Text text = new Text(message);

        text.setEffect(ds);
        text.setCache(true);
        text.setX(10.0f);
        text.setY(270.0f);
        text.setFill(Color.RED);
        text.setFont(Font.font(null, FontWeight.BOLD, 32));

        gridPane.setVgap(5);
        gridPane.setHgap(15);
        gridPane.add(ngButton, 3,0);
        gridPane.add(button,5,0);

        borderPane.setCenter(text);
        borderPane.setBottom(gridPane);

        Scene newScene = new Scene(borderPane,225,100);
        Stage ng = new Stage();
        ng.setX(450);
        ng.setY(250);
        ng.setTitle("Game Over");
        ng.setScene(newScene);
        ng.show();

        button.setOnAction(e -> Platform.exit());
        ngButton.setOnAction(e -> {
            ng.close();
            man.reset();
            board.reset();
            guessedLettersText.setText("\t\t\t\t\t\t\t\t\t\tWrong Letters:\t");
        });
    }
}