/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinhm.controller;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class SignUpError implements Serializable{
    private String usernameLengthError;
    private String passwordLengthError;
    private String confirmNoMatch;
    private String fullNameLengthError;
    private String usernameIsExisted;

    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public String getConfirmNoMatch() {
        return confirmNoMatch;
    }

    public void setConfirmNoMatch(String confirmNoMatch) {
        this.confirmNoMatch = confirmNoMatch;
    }

    public String getFullNameLengthError() {
        return fullNameLengthError;
    }

    public void setFullNameLengthError(String fullNameLengthError) {
        this.fullNameLengthError = fullNameLengthError;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }
    
    
    
}
