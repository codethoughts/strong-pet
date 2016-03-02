package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends Person {

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min = 6, max = 20)
    private String password;

    protected User() { }

    protected User(String username, String password, String ic_number) {
        super(ic_number);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + ", "
                + getFirstName() + ", "
                + getLastName() + ", "
                + getGender() + ", "
                + getICNumber() + ", "
                + getDob() + ", "
                + getUsername() + ", "
                + getPassword();
    }
}
