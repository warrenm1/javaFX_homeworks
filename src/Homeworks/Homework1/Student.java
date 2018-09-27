package Homeworks.Homework1;

public class Student extends Person {
    private String classStatus;

    public Student(){
        classStatus = "Freshman";
    }

    public Student(String na, String add, String phone, String email, String status){
        super(na, add, phone, email);
        classStatus = status;
    }

    public String getClassStatus(){return classStatus;}

    public void setClassStatus(String c){classStatus = c; return;}

    public String toString(){ return ("A Student named " + getName() + ", \naddress: " + this.getAddress() + ", \nphone: " + this.getPhoneNumber() + ",\nemail: " + this.getEmailAddress() + ",\nclass status: " + this.getClassStatus());
    }
}

