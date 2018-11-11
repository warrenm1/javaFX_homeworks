package Homeworks.Homework5;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board extends GridPane {
    private List<String> phrases = new ArrayList<>();
    private File file = new File("src\\Homeworks\\Homework5\\phrases.txt");
    private List<char[]> chosenPhrase = new ArrayList<>(){};
    //private Vector<Vector<Text>> correctLetters = new Vector<>();

    public Board(){
        if(file.isFile()){
            try(Stream<String> stream = Files.lines(Paths.get(String.valueOf(file)))){
                phrases = stream.collect(Collectors.toList());
            } catch (IOException e) { e.printStackTrace(); }
        }
        else{ System.exit(1); }

        selectPhrase();

    }

    private void selectPhrase() {
        int rand = (int)(Math.random()*phrases.size());

        String[] temp = phrases.get(rand).split(" ");
        //Vector<Text> temp1 = new Vector<>();
        for (int i = 0; i < temp.length; i++){
            chosenPhrase.add(temp[i].toCharArray());
            //for (int j = 0; j < chosenPhrase.get(i).length; j++){
            //    temp1.get(i).setText(" ");
            //}
            //correctLetters.add(temp1);
        }
    }

    public boolean CheckLeter(char check){
        boolean correct = false;
        for(int word = 0; word < chosenPhrase.size(); word++){
            for(int letter = 0; letter < chosenPhrase.get(word).length; letter++){
                if(check == letter){
                    displayLetter(word,letter);
                    correct = true;
                }
            }
        }

        return correct;
    }

    public void displayLetter(int word, int letter){

    }

    public void displayRemainingLetters(){
        /*for(int word = 0; word < correctLetters.size(); word++){
            for(int letter = 0; letter<correctLetters.get(word).capacity(); letter++){
                if(" " == correctLetters.get(word).get(letter)){
                    correctLetters.get(word).get(letter).charValue().setFill(Color.RED);
                }
            }
        }*/
    }

    public void newGame(){}

    public void reset(){}
}
