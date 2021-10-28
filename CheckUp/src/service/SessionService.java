/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import reclamation.User;

/**
 *
 * @author houss
 */
public class SessionService {
    User currentUser;
    Boolean state;

    public SessionService(User currentUser, Boolean state) {
        this.currentUser = currentUser;
        this.state = state;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    
    
}
