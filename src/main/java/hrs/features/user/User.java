package hrs.features.user;

/**
 * @author Marta Motyka
 * @since 21.11.2017
 */
public class User {
    private String name;

    private String password;

    private Privileges privileges;

    private User() {
    }

    public User(String name, String password, Privileges privileges) {
        this.name = name;
        this.password = password;
        this.privileges = privileges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Privileges getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Privileges privileges) {
        this.privileges = privileges;
    }
}
