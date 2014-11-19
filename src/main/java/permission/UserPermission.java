/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permission;

/**
 *
 * @author aiolos404
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class UserPermission implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String group;
    private String create;
    private String read;
    private String update;
    private String delete;

    // Constructors:
    public UserPermission() {
    }
 
    public UserPermission(String group,String create,String read,String update,String delete) {
        this.group = group;
        this.create = create;
        this.read = read;
        this.update = update;
        this.delete = delete;
    }
 
    // String Representation:
    @Override
    public String toString() {
        return "Group: "+ group+"; Create: "+create +"; Read: "+read +"; Update: "+update +"; Delete: "+delete ;
    }
    

}