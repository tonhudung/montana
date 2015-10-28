package com.montana.apimodels.profile;

/**
 * Created by alext on 10/20/2015.
 */
public class ProfileViewApiModel {
    private String firstName;
    private String lastName;
    private String profilePictureUrl;
    private FriendButton friendButton;

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
        return profilePictureUrl;
    }

    public ProfileViewApiModel setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
        return this;
    }

    public FriendButton getFriendButton() {
        return friendButton;
    }

    public ProfileViewApiModel setFriendButton(FriendButton friendButton) {
        this.friendButton = friendButton;
        return this;
    }
}
