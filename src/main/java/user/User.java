package user;
 
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Date signingDate;
 
    // Constructors:
    public User() {
    }
 
    public User(String firstname,String lastname,String email,String username,String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;

    }
 
    // String Representation:
    @Override
    public String toString() {
        return "Firstname: "+ firstname + ", Lastname: " +lastname+ ", Email: " +email+ ", Username: " +username;
    }
    

}