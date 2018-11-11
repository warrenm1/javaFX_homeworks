package Homeworks.Homework5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
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

public class Hangman extends Application {

    public HangingMan man = new HangingMan();
    public String GameMusic = "src\\music\\The_Legend_of_Samukai.mp3";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        Gallows hangingStage = new Gallows();
        Board board = new Board();

        Media media = new Media(new File(GameMusic).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mediaView = new MediaView(mediaPlayer);
        Pane pane = new Pane(mediaView);


        //Finished Product
        borderPane.setCenter(hangingStage);
        borderPane.setRight(board);
        borderPane.setBottom(pane);

        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void GameOver(){
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        DropShadow ds = new DropShadow();

        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Button button = new Button("Exit");
        Button ngButton = new Button("New Game");
        Text text = new Text();

        text.setEffect(ds);
        text.setCache(true);
        text.setX(10.0f);
        text.setY(270.0f);
        text.setFill(Color.RED);
        text.setFont(Font.font(null, FontWeight.BOLD, 32));

        gridPane.setVgap(5);
        gridPane.setHgap(15);
        gridPane.add(button, 0,0);
        gridPane.add(ngButton,1,0);

        borderPane.setCenter(text);
        borderPane.setBottom(gridPane);

        Scene newScene = new Scene(borderPane,225,300);
        Stage ng = new Stage();
        ng.setTitle("Game Over");
        ng.setScene(newScene);
        ng.show();

        button.setOnAction(e -> Platform.exit());
        ngButton.setOnAction(e -> {man.reset(); ng.close();});
    }
}