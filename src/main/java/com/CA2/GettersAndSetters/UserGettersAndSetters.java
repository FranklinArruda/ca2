package com.CA2.GettersAndSetters;

public class UserGettersAndSetters {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    public UserGettersAndSetters(String username, String password, String firstName, String lastName) {
    	super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserGettersAndSetters [firstName=" + firstName + ", lastName=" + lastName + ", email=" + username + ", password=" + password + "]";
    }
}
