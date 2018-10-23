import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

/**
 * Created by John on 7/19/2014.
 */
public class RotatingText extends Pane {
    private double circleSize;
    private double textRotate;
    private String phrase;
    private double startDegree;
    private double letterSpacing;
    private double pointX;
    private double pointY;
    private double rotate;

    // Objects and properties
    ArrayList<String> phraseList;
    private Text text;
    private Font textFont;
    private Color textColor;

    /** Default Constructor */
    public RotatingText() {
        this.circleSize = 100;
        this.textFont = new Font("Courier New", 15);
        this.phrase = "Default";
        this.startDegree = 220;
        this.letterSpacing = 21;
        this.textRotate = 100;
        this.textColor = Color.BLACK;
        paintText(this.phrase);
    }

    /** Constructor for setting phrase, starting degree, and the font */
    public RotatingText(String phrase, double startDegree, Font font) {
        this.circleSize = 100;
        this.textFont = font;
        this.textRotate = 90;
        this.textColor = Color.BLACK;
        this.phrase = phrase;
        this.startDegree = startDegree;
        this.letterSpacing = 21;
        paintText(this.phrase);
    }

    /** Get the color of Font */
    public Color getTextColor() {
        return this.textColor;
    }

    /** Set the color of Font */
    public void setTextColor(Color color) {
        this.textColor = color;
        paintText(this.phrase);
    }

    /** Get the Font */
    public Font getTextFont() {
        return this.textFont;
    }

    /** Set the Font */
    public void setTextFont(Font font) {
        this.textFont = font;
        paintText(this.phrase);
    }

    /** Get the size of the circle */
    public double getCircleSize() {
        return this.circleSize;
    }

    /** Set the size of the circle */
    public void setCircleSize(double circleSize) {
        this.circleSize = circleSize;
        paintText(this.phrase);
    }

    /** Get the rotation setting of the text */
    public double getTextRotate() {
        return this.textRotate;
    }

    /** Set the rotation setting of the text */
    public void setTextRotate(double textRotate) {
        this.textRotate = textRotate;
        paintText(this.phrase);
    }

    /** Get the spacing between letters */
    public double getLetterSpacing() {
        return this.letterSpacing;
    }

    /** Set the spacing between letters */
    public void setLetterSpacing(double letterSpacing) {
        this.letterSpacing = letterSpacing;
        paintText(this.phrase);
    }

    /** Paint's the text in a circular fashion */
    private void paintText(String phrase) {
        getChildren().clear();
        // Create ArrayList and store each letter as a string
        this.phraseList = new ArrayList<>(phrase.length());
        for (int i = 0; i < phrase.length(); i++) {
            phraseList.add(i, String.valueOf(phrase.charAt(i)));
        }

        // Create letters and place them around the circle
        for (int i = 0; i < phrase.length(); i++) {
            addLetter(this.textFont, this.textColor,
                    phraseList.get(i), startDegree);
            getChildren().add(this.text);
            startDegree += letterSpacing;
        }
    }

    /** Create letter and add it to pane */
    public void addLetter(Font font, Color color, String letter,
                          double startDegree) {
        getCoordinates(startDegree);
        text = new Text(this.pointX, this.pointY, letter);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(font);
        text.setFill(color);
        text.setRotate(this.rotate);
    }

    /** Sets letter coordinates based on degree */
    public void getCoordinates(double degree) {
        this.pointX = (this.getWidth() / 2) + circleSize *
                Math.cos(Math.toRadians(degree));
        this.pointY = (this.getHeight() / 2) + circleSize *
                Math.sin(Math.toRadians(degree));
        this.pointX -= (this.textFont.getSize() / 3);
        this.pointY += (this.textFont.getSize() / 3);
        this.rotate = degree + this.textRotate;
    }
}