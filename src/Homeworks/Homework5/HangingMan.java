package Homeworks.Homework5;

import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HangingMan extends Gallows {
    private int error;

    private Circle head = new Circle(350,150,50,Color.TRANSPARENT);
    private Line body = new Line(350,200,350,400);
    private Line armL = new Line(325,195,225,295);
    private Line armR = new Line(375,195,475,295);
    private Line legL = new Line(350,400,250,500);
    private Line legR = new Line(350,400,450,500);

    private Circle eyeL = new Circle(360,150,5,Color.BLACK);
    private Circle eyeR = new Circle(340,150,5,Color.BLACK);
    private Circle tear = new Circle(363.5,156,3,Color.POWDERBLUE);
    private Circle wowFace = new Circle(350,175,15,Color.BLACK);
    private Arc bigSmile = new Arc(350,155,30,30,200,140);
    private Arc smile = new Arc(350,150,30,30, 200,140);
    private Arc frown = new Arc(350,200,30,30,30,120);

    private Text school = new Text(350,285,"Y");
    private Circle circle = new Circle(360,275,20);

    private Text right = new Text(225,30,"Correct");
    private Text wrong = new Text(220,80,"Incorrect");

    private List<String> LosingSounds = new ArrayList<>();
    private List<String> WinningSounds = new ArrayList<>();
    private List<String> CorrectSounds = new ArrayList<>();
    private List<String> WrongSounds = new ArrayList<>();

    public int getError() { return error; }

    public HangingMan(){
        error = 0;

        head.setStroke(Color.BLACK);
        head.setStrokeWidth(5);

        smile.setType(ArcType.OPEN);
        smile.setStroke(Color.BLACK);
        smile.setStrokeWidth(5);
        smile.setFill(Color.TRANSPARENT);

        bigSmile.setType(ArcType.OPEN);
        bigSmile.setFill(Color.BLACK);

        frown.setType(ArcType.OPEN);
        frown.setStroke(Color.BLACK);
        frown.setStrokeWidth(5);
        frown.setFill(Color.TRANSPARENT);

        body.setStroke(Color.BLACK);
        body.setStrokeWidth(5);
        circle.setFill(Color.web("#002255"));
        school.setFont(Font.font("Times New Roman",30));
        school.setFill(Color.WHITE);

        armL.setStroke(Color.BLACK);
        armL.setStrokeWidth(5);

        armR.setStroke(Color.BLACK);
        armR.setStrokeWidth(5);

        legL.setStroke(Color.BLACK);
        legL.setStrokeWidth(5);

        legR.setStroke(Color.BLACK);
        legR.setStrokeWidth(5);

        right.setFont(Font.font("Old English Text MT",20));
        right.setFill(Color.web("#0f2439"));

        wrong.setFont(Font.font("Old English Text MT",20));
        wrong.setFill(Color.DARKRED);

        LosingSounds.add("src\\music\\skyclad_sound_breath_exhale_sigh_ascend_reverb_eerie_113.mp3");
        LosingSounds.add("src\\music\\scaredScream.mp3");
        LosingSounds.add("src\\music\\Wilhelm-Scream.mp3");
        CorrectSounds.add("src\\music\\zapsplat_human_male_shout_woo_whoo_happy_14414.mp3");
        CorrectSounds.add("src\\music\\zapsplat_human_male_shout_yeah_happy_celebrate_14415.mp3");
        CorrectSounds.add("src\\music\\reitanna_human_female_funny_says_yay.mp3");
        CorrectSounds.add("src\\music\\zapsplat_human_male_shout_oh_yeah_happy_celebrate_003_14413.mp3");
        WinningSounds.add("src\\music\\human_crowd_25_people_cheer_shout_yay.mp3");
    }

    //adds a shocked face and ends game when last limb is drawn
    public void incrementError(){
        error++;

        incorrect();

        if(error == 6) { lose(); }
    }

    //adds a shocked face and incorrect caption if guessed incorrectly and draws a limb
    public void incorrect(){
        drawFigure();

        if(error < 7){
            if(super.getChildren().contains(wowFace)){ super.getChildren().remove(wowFace); }
            if(super.getChildren().contains(smile)){ super.getChildren().remove(smile); }
            if(super.getChildren().contains(right)){ super.getChildren().remove(right); }
            if(super.getChildren().contains(wrong)){ super.getChildren().remove(wrong); }
            super.getChildren().addAll(wowFace, wrong);
        }
    }

    //adds a smile and correct caption if guessed correctly
    public void correct(){
        int rand = (int)(Math.random()*CorrectSounds.size());

        AudioClip sound = new AudioClip(new File(CorrectSounds.get(rand)).toURI().toString());
        sound.setVolume(7.0);
        sound.play();

        if (error > 0) {
            if (super.getChildren().contains(smile)) { super.getChildren().remove(smile); }
            if (super.getChildren().contains(wowFace)) { super.getChildren().remove(wowFace); }
            if (super.getChildren().contains(wrong)) { super.getChildren().remove(wrong); }
            if (super.getChildren().contains(right)) { super.getChildren().remove(right); }
            super.getChildren().addAll(smile, right);
        }

        else{
            if(super.getChildren().contains(right)){ super.getChildren().remove(right); }
            super.getChildren().add(right);
        }
    }

    //adds a big smile if the game is won
    public void win(){
        if( super.getChildren().contains(wowFace)) { super.getChildren().remove(wowFace); }
        else if( super.getChildren().contains(smile)){ super.getChildren().remove(smile); }
        if(error > 0) super.getChildren().add(bigSmile);

        int rand = (int)(Math.random()*WinningSounds.size());

        AudioClip sound = new AudioClip(new File(WinningSounds.get(rand)).toURI().toString());
        sound.setVolume(7.0);
        sound.play();
    }

    //adds a sad face if the game is lost
    private void lose() {
        if(super.getChildren().contains(smile)){ super.getChildren().remove(smile); }
        else if(super.getChildren().contains(wowFace)){ super.getChildren().remove(wowFace); }
        super.getChildren().addAll(frown,tear);

        int rand = (int)(Math.random()*LosingSounds.size());

        AudioClip sound = new AudioClip(new File(LosingSounds.get(rand)).toURI().toString());
        sound.setVolume(7.0);
        sound.play();
    }

    //draws the hanging man limb by limb
    public void drawFigure(){
        //draws Head and face
        if (error == 1){
            super.getChildren().addAll(head,eyeL,eyeR);

            AudioClip sound = new AudioClip(new File("src\\music\\zapsplat_office_marker_pen_highlighter_luminous_draw_circle_on_cardboard_001_22929.mp3").toURI().toString());
            sound.setVolume(7.0);
            sound.play();
        }

        //draws body and BYU pin
        else if (error == 2){
            super.getChildren().addAll(body,circle,school);

            AudioClip sound = new AudioClip(new File("src\\music\\zapsplat_office_marker_pen_highlighter_luminous_draw_diagram_on_paper_001_22935.mp3").toURI().toString());
            sound.setVolume(7.0);
            sound.play();
        }

        //draws left arm
        else if (error == 3){
            super.getChildren().add(armL);

            AudioClip sound = new AudioClip(new File("src\\music\\zapsplat_office_felt_marker_draw_line_short_fast_thick_cardboard_004_22535.mp3").toURI().toString());
            sound.setVolume(7.0);
            sound.play();
        }

        //draws right arm
        else if (error == 4){
            super.getChildren().add(armR);

            AudioClip sound = new AudioClip(new File("src\\music\\zapsplat_office_felt_marker_draw_line_short_fast_thick_cardboard_004_22535.mp3").toURI().toString());
            sound.setVolume(7.0);
            sound.play();
        }

        //draws left leg
        else if (error == 5){
            super.getChildren().add(legL);

            AudioClip sound = new AudioClip(new File("src\\music\\zapsplat_office_felt_marker_draw_line_short_fast_thick_cardboard_004_22535.mp3").toURI().toString());
            sound.play();
        }

        //draws right leg
        else if (error == 6){
            super.getChildren().add(legR);

            AudioClip sound = new AudioClip(new File("src\\music\\zapsplat_office_felt_marker_draw_line_short_fast_thick_cardboard_004_22535.mp3").toURI().toString());
            sound.setVolume(7.0);
            sound.play();
        }

        else { return; }
    }

    //sets up the game to defaults for a new game
    public void reset(){
        error = 0;

        if(super.getChildren().contains(head)){ super.getChildren().remove(head); }
        if(super.getChildren().contains(body)){ super.getChildren().remove(body); }
        if(super.getChildren().contains(armL)){ super.getChildren().remove(armL); }
        if(super.getChildren().contains(armR)){ super.getChildren().remove(armR); }
        if(super.getChildren().contains(legL)){ super.getChildren().remove(legL); }
        if(super.getChildren().contains(legR)){ super.getChildren().remove(legR); }
        if(super.getChildren().contains(eyeL)){ super.getChildren().remove(eyeL); }
        if(super.getChildren().contains(eyeR)){ super.getChildren().remove(eyeR); }
        if(super.getChildren().contains(tear)){ super.getChildren().remove(tear); }
        if(super.getChildren().contains(wowFace)){ super.getChildren().remove(wowFace); }
        if(super.getChildren().contains(bigSmile)){ super.getChildren().remove(bigSmile); }
        if(super.getChildren().contains(smile)){ super.getChildren().remove(smile); }
        if(super.getChildren().contains(frown)){ super.getChildren().remove(frown); }
        if(super.getChildren().contains(school)){ super.getChildren().remove(school); }
        if(super.getChildren().contains(circle)){ super.getChildren().remove(circle); }
        if(super.getChildren().contains(right)){ super.getChildren().remove(right); }
        if(super.getChildren().contains(wrong)){ super.getChildren().remove(wrong); }
    }
}