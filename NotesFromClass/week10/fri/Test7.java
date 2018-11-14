//output 11
package week10.fri;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Test7 {
          public static void main(String[] args) {
            DoubleProperty balance = new SimpleDoubleProperty();
            balance.addListener(ov ->
              System.out.println(2 * balance.doubleValue()));
            
            balance.set(5.5);
          }
        }
