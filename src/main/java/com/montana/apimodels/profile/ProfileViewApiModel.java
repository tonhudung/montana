package com.montana.apimodels.profile;

import com.montana.models.FriendRequestStatus;

/**
 * Created by alext on 10/20/2015.
 */
public class ProfileViewApiModel {
    private String firstName;
    private String lastName;
    private String profilePictureUrl;
    private Boolean isFriend;
    private FriendRequestStatus friendRequestStatus;

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

    public FriendRequestStatus getFriendRequestStatus() {
        return friendRequestStatus;
    }

    public void setFriendRequestStatus(FriendRequestStatus friendRequestStatus) {
        this.friendRequestStatus = friendRequestStatus;
    }

    public Boolean getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Boolean isFriend) {
        this.isFriend = isFriend;
    }
}
