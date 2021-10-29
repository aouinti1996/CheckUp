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
    private User user;
    private Reponse reponse;
    private String username;
    private String object;
    private String status;
    private String description;
    private String screenshot;
    private String email;

   
        public Reclamation(User user, String object, String status, String description, String screenshot, String email) {
       
        this.user = user;
        this.object = object;
        this.status = status;
        this.description = description;
        this.screenshot = screenshot;
        this.email = email;
    }

    public Reclamation(String object, String status, String description, String screenshot) {
        this.object = object;
        this.status = status;
        this.description = description;
        this.screenshot = screenshot;
    }

    public Reponse getReponse() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", user =" + user + ", object=" + object + ", status=" + status + ", description=" + description + ", screenshot=" + screenshot + ", email=" + email + '}';
    }

   public Reclamation getReclamation(){
       return this;
   }

}


