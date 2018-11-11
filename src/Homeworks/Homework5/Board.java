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
    private List<Vector<Text>> chosenPhrase = new ArrayList<>();
    private ArrayList<boolean[]> correctLetters = new ArrayList<>();

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
    }

    //if a guess is correct, calls displayLetter for each instance of that letter
    ////returns true for annimation purposes
    //else returns false
    public boolean CheckLeter(char check){
        boolean correct = false;
        for(int word = 0; word < chosenPhrase.size(); word++){
            for(int letter = 0; letter < chosenPhrase.get(word).size(); letter++){
                if(check == letter){
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
