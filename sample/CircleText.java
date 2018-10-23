/** Main */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by John on 7/11/2014.
 */
public class Prog14_05 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create Pane
        circularText phrase = new circularText("WE ARE ANONYMOUS ",
                480, 480);
        phrase.setFont("Matrix");
        phrase.setTextSize(30);

        // Place clock and label in border pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15, 30, 30, 0));
        pane.setStyle("-fx-background-color: black");
        pane.getChildren().add(phrase);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_05");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

/** circularText class */
import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Circle;
        import javafx.scene.text.Font;
        import javafx.scene.text.Text;

/**
 * Created by John on 7/11/2014.
 */
public class circularText extends Pane {
    double textSize = 30;
    String string = "";
    String fontName = "";
    Font font = new Font("Times Roman", textSize);
    // Pane's width and height
    private double w = 250, h = 250;

    /** Create Constructor */
    public circularText (String phrase, double w, double h) {
        this.w = w;
        this.h = h;
        this.string = phrase;
        textSize = (this.w / this.string.length()) * 2;
        paintText(this.string, this.font);
    }

    /** Set new font */
    public void setFont(String name) {
        Font font = new Font(name, textSize);
        this.font = font;
        this.fontName = name;
        paintText(this.string, this.font);
    }

    /** Return textSize */
    public double getTextSize() {
        return this.textSize;
    }

    /** Set textSize */
    public void setTextSize(double textSize) {
        this.textSize = textSize;
        Font font = new Font(fontName, textSize);
        this.font = font;
        paintText(this.string, this.font);
    }

    /** Return pane's width */
    public double getW() {
        return w;
    }

    /** Set pane's width */
    public void setW(double w) {
        this.w = w;
        textSize = (this.w / this.string.length()) * 2;
        paintText(this.string, this.font);
    }

    /** Return pane's height */
    public double getH() {
        return h;
    }

    /** Set pane's height */
    public void setH(double h) {
        this.h = h;
        textSize = (this.w / this.string.length()) * 2;
        paintText(this.string, this.font);
    }

    /** Paint the Letters */
    protected void paintText(String phrase, Font font) {
        // Initialize parameters
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;

        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(null);
        circle.setStroke(null);
        getChildren().clear();
        getChildren().add(circle);

        // Place text in a circular pattern
        int i = 0;
        double degree = 360 / phrase.length();
        for (double degrees = 0; i < phrase.length(); i++, degrees += degree) {
            double pointX = circle.getCenterX() + circle.getRadius() *
                    Math.cos(Math.toRadians(degrees));
            double pointY = circle.getCenterY() + circle.getRadius() *
                    Math.sin(Math.toRadians(degrees));
            Text letter = new Text(pointX, pointY, phrase.charAt(i) + "");
            letter.setFont(font);
            letter.setFill(Color.LIME);
            letter.setRotate(degrees + 90);
            getChildren().add(letter);
        }

    }
}