package com.montana.viewmodels.home;

/**
 * Created by alext on 10/20/2015.
 */
public class ProfileViewModel {

    private String firstName;

    private String lastName;

    private String userName;

    public String getFirstName() {
        return firstName;
    }


    public ProfileViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ProfileViewModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfileViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
