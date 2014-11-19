package announcement;
 
import user.*;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Announcement implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String publisher;
    private String content;
    private String publish_time;
    private Date signingDate;

 
    // Constructors:
    public Announcement() {
    }
 
    public Announcement(String publisher,String content,String publish_time) {
        this.publisher = publisher;
        this.content = content;
        this.publish_time = publish_time;
        this.signingDate = new Date(System.currentTimeMillis());
    }
 
    // String Representation:
    @Override
    public String toString() {
        return "Publisher: "+ publisher+", Announcement: "+content + ", Publish Time: "+publish_time ;
    }
}