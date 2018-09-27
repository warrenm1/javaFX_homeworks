package com.company;

//exceptions 29 Aug 2018
/*import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;*/

public class Main {

    public static void main(String[] args) {
	// write your code here


        //Trade 29 Aug 2018
        /*boolean istrue = true;

        if (istrue) {
            System.out.println("yo");
        }

        Scanner inFile1;
        // create Scanner inFile1
        try {
            inFile1 = new Scanner(new File("nflx.csv"));
        }
        catch(FileNotFoundException ex2) {
            System.err.println("File not found exception!");
            inFile1 = null;

        }
        catch (Exception ex)
        {
            System.err.println("Are you kidding me?!!! That file doesn't exist!!!!");
            inFile1 = null;
        }

        // Original answer used LinkedList, but probably preferable to use ArrayList in most cases
        // List<Float> temps = new LinkedList<Float>();
        List<Float> temps = new ArrayList<Float>();

        // while loop
        while (inFile1.hasNext()) {
            // find next line
            float token1 = inFile1.nextFloat();
            temps.add(token1);
        }
        inFile1.close();

        Float[] prcs = temps.toArray(new Float[0]);

        int i =0;
        double av = 0.0;
        int lags = 7;
        double buy = 0.0;
        double sell = -1.0;
        double profit = 0.0;
        double initial = 0.0;
        for (Float p : prcs) {
            if (i > lags) {
                av = (prcs[i-1]+prcs[i-2]+prcs[i-3]+prcs[i-4]+prcs[i-5]+prcs[i-6]+prcs[i-7])/lags;
                if (p > av && buy == 0.0) {
                    buy = p;
                    System.out.println("Buying on day "+i+" at price: "+p);
                    sell = 0.0;
                    if (initial == 0.0) {
                        initial = p;
                    }
                }
                else if (p < av && sell == 0.0) {
                    sell = p;
                    profit += (sell - buy);
                    System.out.println("Selling on day "+i+" at price: "+p);
                    System.out.println("Trade profit: "+(sell - buy));
                    buy = 0.0;
                }
                else {
                    //pass
                }

            }
            i++;
        }
        System.out.println("Total Profit: "+profit);
        System.out.println("Total Returns: "+(profit/initial));*/


        //Loop 29 Aug 2018
        /*int age = 37;
        double gpa = 3.5;
        double bignum = 12345.678901;
        boolean havingFun = true;

        if (havingFun)
        {
            System.out.println("Hollar hollar, CS is awesome!");
        }
        else if (!havingFun)
        {
            System.out.println("board, heading to the quad!");
        }

        System.out.println("age: "+age);

        int[] data = {10,20,30,40,50,60,71,80,90,91};

        //or

        int[] data2;
        data2 = new int[]{10,20,30,40,50,60,71,80,90,91};

        for(int d : data) {
            System.out.println("d: " + d);
        }

        for(int i = 0; i < data.length; i++)
        {
            System.out.println("data[" + i + "]: " + data[i]);
        }*/
    }
}
