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
public class Reponse {
    
    private int id;
    private String text;

    public Reponse(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", text=" + text + '}';
    }
    
    
}
