import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by John on 7/17/2014.
 */
public class MouseEventDemo extends Application {
    public double rotateImage;
    Pane pane = new Pane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Set pane's properties
        pane.setStyle("-fx-background-color: black");

        // Create and add objects
        setMouseTrail();
        setCenterObject();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("MouseTrailDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /** Set mouse trail */
    public void setMouseTrail() {
        // Create image for cursor
        ImageView imageView = new ImageView(new Image("/image/anon5.jpg"));
        imageView.setBlendMode(BlendMode.SCREEN);
        imageView.setCache(true);
        pane.getChildren().add(imageView);

        // Create a new RotatingText object
        Font font = Font.font("Courier New", FontWeight.BOLD, 12);
        RotatingText circlePane = new RotatingText("We Are Anonymous",
                220, font);
        circlePane.setCircleSize(36);
        circlePane.setTextColor(Color.LIME);
        circlePane.relocate(imageView.getX(), imageView.getY());
        pane.getChildren().add(circlePane);

        // Rotation transform for animation counter clockwise
        final Rotate rotationTransform = new Rotate(360, 0, 0);
        circlePane.getTransforms().add(rotationTransform);

        // Animate the RotatingText object
        Timeline rotatingText = new Timeline(new KeyFrame(
                Duration.seconds(5),
                new KeyValue(rotationTransform.angleProperty(), 0)));
        rotatingText.setCycleCount(Timeline.INDEFINITE);
        rotatingText.play();

        // Set text to circle image and image to follow mouse
        pane.setOnMouseMoved(e -> {
            imageView.setX(e.getX() - 10);
            imageView.setY(e.getY() + 30);
            circlePane.relocate(imageView.getX() + 34,
                    imageView.getY() + 29.5);
        });
    }

    /** Set center object and animate it */
    public void setCenterObject() {
        // Create circular text
        Font font2 = Font.font("Courier New", FontWeight.BOLD, 12);
        CircularText circularText = new CircularText("We Are Anonymous",
                325, 325);
        circularText.setTextFill(Color.LIME);
        circularText.setTextSize(12, 1.3, 1.1);
        circularText.setFont(font2);
        circularText.setTextRotate(90, 360);
        circularText.setGapSpacing(0.95);
        circularText.setTextStartDegree(360);
        circularText.relocate(300, 300);
        pane.getChildren().add(circularText);

        // Rotation transform for circular text animation and image
        final Rotate rotationTransform = new Rotate(360, 0, 0);
        circularText.getTransforms().add(rotationTransform);


        // Animate the RotatingText object
        Timeline rotatingText = new Timeline(new KeyFrame(
                Duration.seconds(10),
                new KeyValue(rotationTransform.angleProperty(), 0)));
        rotatingText.setCycleCount(Timeline.INDEFINITE);
        rotatingText.play();

        // Load image for center
        ImageView imageView2 = new ImageView(new Image("/image/anon3.jpg"));
        imageView2.setBlendMode(BlendMode.SCREEN);
        imageView2.setCache(true);
        imageView2.setX(circularText.getLayoutX() - 145);
        imageView2.setY(circularText.getLayoutY() - 125);
        pane.getChildren().add(imageView2);

        // Create EventHandler for image
        rotateImage = 0;
        EventHandler<ActionEvent> eventHandler = e -> {
            if (rotateImage == 360)
                rotateImage = 0;
            rotateImage += 1;
            imageView2.setRotate(rotateImage);
        };

        // Animate the image rotation
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(35), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}