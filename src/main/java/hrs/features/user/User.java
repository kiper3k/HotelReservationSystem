package hrs.features.user;

/**
 * @author Marta Motyka
 * @since 21.11.2017
 */
public class User {
    private String name;
    private String login;
    private String password;
    private Privileges privileges;

    private User() {
    }
    
    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.privileges = privileges;
    }

    public User(String name, String login, String password, Privileges privileges) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.privileges = privileges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setLogin(String login){
        this.login = login;
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
