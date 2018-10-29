package week7.fri;

//2
//discuss listeners vs bindings vs events
//https://www.dummies.com/programming/java/javafx-how-to-use-property-events/
//GOTO ShowCircleCentered

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ObservablePropertyDemo {
    public static void main(String[] args) {
        DoubleProperty balance = new SimpleDoubleProperty();
        balance.addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                System.out.println("The new value is " +
                        balance.doubleValue());
            }
        });

        balance.set(4.5);
    }
}
