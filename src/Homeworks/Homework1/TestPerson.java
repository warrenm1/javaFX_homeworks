package Homeworks.Homework1;

public class TestPerson {
    public static void main(String args[]){
        //Person
        Person person = new Person();
        System.out.println(person.toString() + "\n=================================================\n\n");
        person.setAddress("over there");
        person.setEmailAddress("hackers666@evil.com");
        person.setName("My New Name");
        person.setPhoneNumber("+1 435 730 4026");
        System.out.println("setName, setAddress, setEmailAddress, and setPhoneNumber\n\n" + person.toString()+ "\n=================================================\n" + "\n=================================================\n\n");

        //Student
        Student student = new Student("Samson", "upstairs", "555-1234","your.email@email.com", "Senior");
        System.out.println(student.toString() + "\n=================================================\n\n");
        student.setClassStatus("Freshman");
        System.out.println("setClassStatus\n\n" + student.toString() + "\n=================================================" + "\n=================================================\n\n");

        //Employee
        Employee employee = new Employee("George", "outside", "544-2260", "person.me@king.email.gov", "Buckingham Palace", "England's Taxes", 0, 19, 1991);
        System.out.println(employee.toString() + "\n=================================================\n\n");
        employee.setOffice("Royal Cemetary");
        employee.setSalary("Worms and Dirt");
        employee.setDateHired(12,25,1993);
        System.out.println("setOffice, setSalary, and setDateHired\n\n" + employee.toString() + "\n=================================================" + "\n=================================================\n\n");

        //Faculty
        Faculty faculty = new Faculty("Snape", "Dungeon", "Owl", "half.blood.prince@i.love.lily.hogwards.en", "Dungeon", "less than the Defense Against the Dark Arts teachers...", 0, 12, 1492, "every bloody day", "Professor");
        System.out.println(faculty.toString() + "\n=================================================\n\n");
        faculty.setOfficeHours("Not on your life");
        faculty.setRank("Head Master");
        System.out.println("setOfficeHours and setRank\n\n" + faculty.toString() + "\n=================================================" + "\n=================================================\n\n");

        //Staff
        Staff staff = new Staff("Sulu", "Earth", "n/a, use com link", "no one uses email anymore", "bridge", "No one uses money anymore in the Federation", 3, 14, 2266, "Pilot");
        System.out.println(staff.toString() + "\n=================================================\n\n");
        staff.setTitle("Captain");
        System.out.println("setTitle\n\n" + staff.toString() + "\n=================================================" + "\n=================================================\n\n");

    }
}