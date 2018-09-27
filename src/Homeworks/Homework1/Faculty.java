package Homeworks.Homework1;

public class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(){
        officeHours = "tomorrow";
        rank = "grunt";
    }

    public Faculty(String na, String add, String phone, String email, String off, String sal, int mo, int da, int yr, String hours, String ra){
        super(na, add, phone, email, off, sal, mo, da, yr);
        officeHours = hours;
        rank = ra;
    }

    public String getOfficeHours(){return officeHours;}
    public String getRank(){return rank;}

    public void setOfficeHours(String office){officeHours = office; return;}
    public void setRank(String r){rank = r; return;}

    public String toString(){ return "A Faculty named " + getName() + ", \naddress: " + this.getAddress() + ", \nphone: " + this.getPhoneNumber() + ",\nemail: " + this.getEmailAddress() + ",\noffice: " + this.getOffice() + ",\nsalary: " + this.getSalary() + ",\ndate hired: " + this.getDateHired() + "\noffice hours: " + this.getOfficeHours() + "\nrank: " + this.getRank(); }

    }

