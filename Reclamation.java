/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

/**
 *
 * @author houss
 */
public class Reclamation {

 public Reclamation(){};

    private int id;
    private String username;
    private String object;
    private String description;

public Reclamation(int id, String username, String object,String description)
{
this.id = id;
this.username = username;
this.object = object;
this.description = description;


}    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", username=" + username + ", object=" + object + ", description=" + description + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  

}


