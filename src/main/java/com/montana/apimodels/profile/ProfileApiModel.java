package com.montana.apimodels.profile;

/**
 * Created by alext on 10/20/2015.
 */
public class ProfileApiModel {
    private String firstName;
    private String lastName;
    private String ProfilePictureUrl;

    public String getFirstName() {
        return firstName;
    }

    public ProfileApiModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfileApiModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getProfilePictureUrl() {
        return ProfilePictureUrl;
    }

    public ProfileApiModel setProfilePictureUrl(String profilePictureUrl) {
        ProfilePictureUrl = profilePictureUrl;
        return this;
    }
}
