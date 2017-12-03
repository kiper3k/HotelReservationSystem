package reservationsystem;

public class Person 
{
    private String firstName;
    private String name;
    private String email;
    private String address;
    
    public Person(String firstName, String name, String email, String address)
    {
        this.firstName = firstName;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String firstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String name() {
        return name;
    }
    
    public String email() {
        return email;
    }
    
    public String address() {
        return address;
    }
}
