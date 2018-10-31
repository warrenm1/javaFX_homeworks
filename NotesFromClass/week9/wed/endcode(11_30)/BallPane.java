package week9.wed;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
    public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private Circle hole = new Circle(x, y, radius);
    private Timeline animation;

    public BallPane() {
        circle.setFill(Color.GREEN); // Set ball color
        hole.setCenterX(200);
        hole.setCenterY(100);
        hole.setFill(Color.BLACK);

        getChildren().add(circle); // Place a ball into this pane
        getChildren().add(hole);

        // Create an animation for moving the ball
        animation = new Timeline(
                new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        this.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                hole.setCenterX(e.getX());
                hole.setCenterY(e.getY());
            }
        });
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(
                animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    protected void moveBall() {
        // Check boundaries
        if (x < radius || x > getWidth() - radius) {
            dx *= -1; // Change ball move direction
        }
        if (y < radius || y > getHeight() - radius) {
            dy *= -1; // Change ball move direction
        }

        // Adjust ball position
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);

        if(circle.getCenterX() >= hole.getCenterX() - radius && circle.getCenterX() <= hole.getCenterX() + radius && circle.getCenterY() >= hole.getCenterY() - radius && circle.getCenterY() <= hole.getCenterY() + radius ){
            System.out.println("If statement is true.");
            dy=0;
            dx=0;
        }

    }

    protected void changeBall() {
        //ADD CLICK LOGIC

    }
}
