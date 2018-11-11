package Homeworks.Homework5;

import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.print.attribute.standard.Media;
import java.io.File;

public class Music extends Pane {
    private String curMusic;
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;

    public String getCurMusic(){ return curMusic; }
    public void setCurMusic(String path){ /*add check*/ curMusic = path; }

    public Music(){}

    public Music(String path){
        setCurMusic(path);
    }

}
