package com.montana.apimodels.profile;

/**
 * Created by alext on 10/20/2015.
 */
public class ProfileViewApiModel {
    private String firstName;
    private String lastName;
    private String ProfilePictureUrl;

    public String getFirstName() {
        return firstName;
    }

    public ProfileViewApiModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfileViewApiModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getProfilePictureUrl() {
        return ProfilePictureUrl;
    }

    public ProfileViewApiModel setProfilePictureUrl(String profilePictureUrl) {
        ProfilePictureUrl = profilePictureUrl;
        return this;
    }
}
