package Homeworks.Homework1;

public class Employee extends Person {
    private String office;
    private String salary;
    private MyDate dateHired = new MyDate();

    public Employee(){
        office = "New Buisiness, Inc.";
        salary = "$1.8 million/year";
        MyDate dateHired2 = new MyDate(1830,4,6);
    }

    public Employee(String na, String add, String phone, String email, String off, String sal, int mo, int da, int yr){
        super(na, add, phone, email);
        office = off;
        salary = sal;
        dateHired.setYear(yr);
        dateHired.setDay(da);
        dateHired.setMonth(mo);
    }

    public String getOffice(){return office;}
    public String getSalary(){return salary;}
    public String getDateHired(){ return dateHired.toString();}

    public void setOffice(String o){office = o; return;}
    public void setSalary(String s){salary = s; return;}
    public void setDateHired(int m, int d, int y){
        dateHired.setMonth(m);
        dateHired.setDay(d);
        dateHired.setYear(y);

        return;
    }

    public String toString(){ return "An Employee named " + getName() + ", \naddress: " + this.getAddress() + ", \nphone: " + this.getPhoneNumber() + ",\nemail: " + this.getEmailAddress() + ",\noffice: " + this.getOffice() + ",\nsalary: " + this.getSalary() + ",\ndate hired: " + this.getDateHired(); }
}

