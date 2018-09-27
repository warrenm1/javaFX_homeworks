package Homeworks.Homework1;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(){
        year = 1991;
        month = 8;
        day = 17;
    }

    public MyDate(int y, int m, int d){
        year = y;
        month = m;
        day = d;
    }

    public int getYear(){return year;}
    public int getMonth(){return month;}
    public int getDay(){return day;}

    public void setYear(int ye){year = ye;}
    public void setMonth(int mo){month = mo;}
    public void setDay(int da){day = da;}

    public String toString(){ return "Month/Day/Year: " + getMonth() + "/" + getDay() + "/" + getYear(); }

}

