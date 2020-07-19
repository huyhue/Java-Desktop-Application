package Employee;
public class Employee {
    private String empID;
    private String lastName;
    private String firstName;
    private String gender;
    private String email;

    public Employee() {
    }

    public Employee(String empID, String lastName, String firstName, String gender, String email) {
        this.empID = empID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
