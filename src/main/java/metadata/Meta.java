package metadata;
 
import announcement.*;
import user.*;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Meta implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String ISBN;
    private String content;
    private String topic;
    
    

 
    // Constructors:
    public Meta() {
    }
 
    public Meta(String ISBN,String topic,String content) {
        this.ISBN = ISBN;
        this.topic = topic;
        this.content = content;
       
    }
 
    // String Representation:
    @Override
    public String toString() {
        return "ISBN is: "+ ISBN+"; Topic is: "+topic + "; Content is: "+ content;
    }
}