package Homeworks.Homework3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DualRectangles extends Application {
    //Rectangle 1
    private TextField tfR1CenterX = new TextField("0");
    private TextField tfR1CenterY = new TextField("0");
    private TextField tfR1Width = new TextField("0");
    private TextField tfR1Height = new TextField("0");

    //Rectangle 2
    private TextField tfR2CenterX = new TextField("0");
    private TextField tfR2CenterY = new TextField("0");
    private TextField tfR2Width = new TextField("0");
    private TextField tfR2Height = new TextField("0");

    //Compute
    private Button btDrawRectangles = new Button("Draw Rectangles");

    //Compare
    private Text rectangleRelations = new Text(" ");


    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        //Setup UI
        GridPane input = new GridPane();
        input.setHgap(5);
        input.setVgap(5);
        input.add(new Label("Rectangle 1"),1,0);
        input.add(new Label("Rectangle 2"),2,0);
        input.add(new Label("Center X-axis"),0,1);
        input.add(new Label("Center Y-axis"),0,2);
        input.add(new Label("Width"),0,3);
        input.add(new Label("Height"),0,4);
        input.add(tfR1CenterX,1,1);
        input.add(tfR2CenterX,2,1);
        input.add(tfR1CenterY,1,2);
        input.add(tfR2CenterY,2,2);
        input.add(tfR1Width,1,3);
        input.add(tfR2Width,2,3);
        input.add(tfR1Height,1,4);
        input.add(tfR2Height,2,4);
        input.add(btDrawRectangles,2,5);

        //Properties for UI
        tfR1CenterX.setAlignment(Pos.BOTTOM_RIGHT);
        tfR1CenterY.setAlignment(Pos.BOTTOM_RIGHT);
        tfR1Width.setAlignment(Pos.BOTTOM_RIGHT);
        tfR1Height.setAlignment(Pos.BOTTOM_RIGHT);
        tfR2CenterX.setAlignment(Pos.BOTTOM_RIGHT);
        tfR2CenterY.setAlignment(Pos.BOTTOM_RIGHT);
        tfR2Width.setAlignment(Pos.BOTTOM_RIGHT);
        tfR2Height.setAlignment(Pos.BOTTOM_RIGHT);

        //Setup Rectangles
        Pane shapes = new Pane();

        Rectangle r1 = new Rectangle(0,0,0,0);
        r1.setStroke(Color.web("#0f2439"));
        r1.setFill(Color.TRANSPARENT);

        Rectangle r2 = new Rectangle(0,0,0,0);
        r2.setStroke(Color.web("#0f2439"));
        r2.setFill(Color.TRANSPARENT);

        shapes.getChildren().addAll(r1,r2);

        btDrawRectangles.setOnAction(e -> {

            r1.setHeight(Double.parseDouble(tfR1Height.getText()));
            r1.setWidth(Double.parseDouble(tfR1Width.getText()));
            r1.setX(Double.parseDouble(tfR1CenterX.getText()) - r1.getWidth()/2);
            r1.setY(Double.parseDouble(tfR1CenterY.getText()) - r1.getHeight()/2);

            r2.setHeight(Double.parseDouble(tfR2Height.getText()));
            r2.setWidth(Double.parseDouble(tfR2Width.getText()));
            r2.setX(Double.parseDouble(tfR2CenterX.getText()) - r2.getWidth()/2);
            r2.setY(Double.parseDouble(tfR2CenterY.getText()) - r2.getHeight()/2);

            //Comparator Operations
            if((r1.getHeight() == r2.getHeight()) && (r1.getWidth() == r2.getWidth()) && (r1.getX() == r2.getX()) && (r1.getY() == r2.getY())){
                rectangleRelations.setText("The rectangles are equal");
                rectangleRelations.setFont(Font.font("Old English Text MT",24));
            }

            else if(r2.getX() >= r1.getX() && r2.getY() >= r1.getY()){
                if(r2.getX() > (r1.getX() + r1.getWidth()) || r2.getY() > (r1.getY() + r1.getHeight())){
                    rectangleRelations.setText("The rectangles do not overlap");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
                else if((r2.getX() + r2.getWidth()) < (r1.getX() + r1.getWidth()) && (r2.getY() + r2.getHeight()) < (r1.getY() + r1.getHeight())){
                    rectangleRelations.setText("One rectangle is contained in another");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
                else if(r2.getX() <= (r1.getX() + r1.getWidth()) && r2.getY() <= (r1.getX() + r1.getHeight())) {
                    rectangleRelations.setText("The rectangles overlap");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
            }

            else if(r2.getX() <= r1.getX() && r2.getY() >= r1.getY()){
                if(r1.getX() > (r2.getX() + r2.getWidth()) || r2.getY() > (r1.getY() + r1.getHeight())){
                    rectangleRelations.setText("The rectangles do not overlap");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
                else if(r1.getX() <= (r2.getX() + r2.getWidth()) && r2.getY() >= (r1.getY() + r1.getHeight())){
                    rectangleRelations.setText("The rectangles overlap");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
            }

            else if(r2.getX() <= r1.getX() && r2.getY() <= r1.getY()){
                if(r1.getX() > (r2.getX() + r2.getWidth()) || r1.getY() > (r2.getY() + r2.getHeight())){
                    rectangleRelations.setText("The rectangles do not overlap");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
                else if((r1.getX() + r1.getWidth()) < (r2.getX() + r2.getWidth()) && (r1.getY() + r1.getHeight()) < (r2.getY() + r2.getHeight())){
                    rectangleRelations.setText("One rectangle is contained in another");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
                else if(r1.getX() <= (r2.getX() + r2.getWidth()) && r1.getY() <= (r2.getY() + r2.getHeight())){
                    rectangleRelations.setText("The rectangles overlap");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
            }

            else if(r2.getX() >= r1.getX() && r2.getY() <= r1.getY()){
                if(r2.getX() > (r1.getX() + r1.getWidth()) || r1.getY() > (r2.getY() + r2.getHeight())){
                    rectangleRelations.setText("The rectangles do not overlap");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
                else if(r2.getX() <= (r1.getX() + r1.getWidth()) && r1.getY() <= (r1.getY() + r1.getHeight())){
                    rectangleRelations.setText("The rectangles overlap");
                    rectangleRelations.setFont(Font.font("Old English Text MT",24));
                }
            }
        });

        //Border Pane Layout
        borderPane.setLeft(input);
        borderPane.setCenter(shapes);
        borderPane.setBottom(rectangleRelations);
        borderPane.setStyle("-fx-padding: 10;" +
                "-fx-border-color: #0f2439;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;");
        borderPane.setPrefSize(300,650);

        //Stage
        Scene scene = new Scene(borderPane,1000,400);
        primaryStage.setTitle("Rectangles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

