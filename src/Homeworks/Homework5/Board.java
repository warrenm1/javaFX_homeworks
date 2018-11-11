package Homeworks.Homework5;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
    private List<Vector<Text>> chosenPhrase = new ArrayList<>();
    private ArrayList<boolean[]> correctLetters = new ArrayList<>();
    //private List<Character> guessedLetters = new ArrayList<>();
    private TextField tfguess = new TextField();
    private Button btCheck = new Button("Submit");
    private Label dummy = new Label();

    public int numWords() { return chosenPhrase.size(); }

    public Board(){
        if(file.isFile()){
            try(Stream<String> stream = Files.lines(Paths.get(String.valueOf(file)))){
                phrases = stream.collect(Collectors.toList());
            } catch (IOException e) { e.printStackTrace(); }
        }
        else{ System.exit(1); }

        selectPhrase();
        initLetters();
        guessesSetup();
        build();
    }

    private void build() {
        tfguess.setFont(Font.font(14));
        tfguess.setTextFormatter(new TextFormatter<String>(e -> {
            String newText = e.getControlNewText();
            if(newText.length() > 1) { return null; }
            else { return e; }
        }));
        tfguess.setMaxWidth(30);

        super.setVgap(5);
        super.setHgap(5);
        super.setAlignment(Pos.CENTER);

        int temp = 0;
        for(int word = 0; word < chosenPhrase.size(); word++){
            for(int letter = 0; letter < chosenPhrase.get(word).size(); letter++){
                super.add(chosenPhrase.get(word).get(letter),letter,word);
                if (letter > temp){ temp = letter; }
            }
        }
        super.add(tfguess,temp+1,numWords() + 10);
        super.add(btCheck,temp+1,numWords()+11);

        super.add(dummy,temp + 14,0);
    }

    //separates each word, then each letter into a List<Vector<Text>>
    private void selectPhrase() {
        int rand = (int)(Math.random()*phrases.size());

        //initialize a List<Vector<Text>> for a separation of each word and letter
        String[] tempWords = phrases.get(rand).split(" ");
        for (int i = 0; i < tempWords.length; i++){
            Vector<Text> tempLetters = new Vector<>();
            char[] temp = tempWords[i].toCharArray();
            for(int j = 0; j < temp.length; j++) {
                Text set = new Text(Character.toString(temp[j]));
                tempLetters.add(set);
            }
            chosenPhrase.add(tempLetters);
        }
    }

    //sets all letters to Transparent until guessed or game is over
    private void initLetters() {
        for(int i = 0; i < chosenPhrase.size(); i++){
            for(int j = 0; j < chosenPhrase.get(i).size(); j++){
                chosenPhrase.get(i).get(j).setFill(Color.TRANSPARENT);
                chosenPhrase.get(i).get(j).setFont(Font.font(24));
            }
        }
    }

    //sets up an ArrayList<boolean[]> of the same sizes to account for guessed letters
    private void guessesSetup() {
        for(int i = 0; i < chosenPhrase.size(); i++){
            boolean[] temp = new boolean[chosenPhrase.get(i).size()];
            Arrays.fill(temp,Boolean.FALSE);
            correctLetters.add(temp);
        }

        //guessedLetters.clear();
    }

    public boolean beenGuessed(char letter){ return false;}

    //if a guess is correct, calls displayLetter for each instance of that letter
    ////returns true for annimation purposes
    //else returns false
    public boolean CheckCorrect(char check){
        boolean correct = false;
        for(int word = 0; word < chosenPhrase.size(); word++){
            for(int letter = 0; letter < chosenPhrase.get(word).size(); letter++){
                String temp = chosenPhrase.get(word).get(letter).getText();
                if(Character.toString(check).toLowerCase() == temp.toLowerCase()){
                    displayLetter(word,letter);
                    correct = true;
                }
            }
        }

        return correct;
    }

    //displays the given letter in Aggie Blue and sets the coresponding ArrayList<boolean[]> value to true
    public void displayLetter(int word, int letter){
        chosenPhrase.get(word).get(letter).setFill(Color.web("0f2439"));
        correctLetters.get(word)[letter] = Boolean.TRUE;
    }

    //at game loss, displays the remaining letters in red
    public void displayRemainingLetters(){
        for(int word = 0; word < correctLetters.size(); word++){
            for(int letter = 0; letter < correctLetters.get(word).length; letter++){
                if(!correctLetters.get(word)[letter]){
                    chosenPhrase.get(word).get(letter).setFill(Color.RED);
                }
            }
        }
    }

    public void newGame(){}

    public void reset(){}
}
