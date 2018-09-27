package Homeworks.Homework1;

public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(){
        name = "Bruce";
        address = "Behind you";
        phoneNumber = "555-0123";
        emailAddress = "never.give.your.email.to.strangers123@yesterdaysurviver.net";
    }

    public Person(String na, String add, String phone, String email){
        name = na;
        address = add;
        phoneNumber = phone;
        emailAddress = email;
    }

    public String getName() {return name;}
    public String getAddress() {return address;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmailAddress() {return emailAddress;}

    public void setName(String n){name = n; return;}
    public void setAddress(String a){address = a; return;}
    public void setPhoneNumber(String p){phoneNumber = p; return;}
    public void setEmailAddress(String e){emailAddress = e; return;}

    public String toString(){ return ("A Person named " + getName() + ", \naddress: " + this.getAddress() + ", \nphone: " + this.getPhoneNumber() + ",\nemail: " + this.getEmailAddress()); }
}

