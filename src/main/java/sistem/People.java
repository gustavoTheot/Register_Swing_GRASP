package sistem;

import java.io.Serializable;

public class People implements Serializable {
    private String name;
    private String email;
    private String password;
    private int age;

    public People(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nName: " + this.name + "\nEmail: " + this.email + "\n";
    }
}
