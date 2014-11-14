package research;
 
import research.*;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Research implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String number;
    private String name;        
    private String type;
    private String date;
    private String author;
    private String publisher;
    private Date signingDate;
 
    // Constructors:
    public Research() {
    }
// number,type,date,author,publisher
    public Research(String number, String name, String type, String date,String author,String publisher) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.date = date;
        this.author = author;
        this.publisher = publisher;
        this.signingDate = new Date(System.currentTimeMillis());
    }
    
//    public Research(String title) {
//        this.title = title;
//        this.publisher = "Null";
//        this.signingDate = new Date(System.currentTimeMillis());
//    }
 
    // String Representation:
    @Override
    public String toString() {
        return number + name + publisher +" (signed on " + signingDate + ")";
    }
}