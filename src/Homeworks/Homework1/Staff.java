package Homeworks.Homework1;

public class Staff extends Employee {
    private String title;

    public Staff(){
        title = "New Guy";
    }

    public Staff(String na, String add, String phone, String email, String off, String sal, int mo, int da, int yr, String t){
        super(na, add, phone, email, off, sal, mo, da, yr);
        title = t;
    }

    public String getTitle(){return title;}

    public void setTitle(String t){title = t; return;}

    public String toString(){ return "A Staff named " + getName() + ", \naddress: " + this.getAddress() + ", \nphone: " + this.getPhoneNumber() + ",\nemail: " + this.getEmailAddress() + ",\noffice: " + this.getOffice() + ",\nsalary: " + this.getSalary() + ",\ndate hired: " + this.getDateHired() + "\ntitle: " + this.getTitle(); }

}
