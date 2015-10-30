package com.montana.apimodels;

/**
 * Created by alext on 10/20/2015.
 */
public class ProfileViewModel {

    private String firstName;
    private String lastName;
    private String profilePictureUrl;
    private FriendshipStatus friendshipStatus;
    private Long friendRequestId;
    private Long friendshipId;

    public String getFirstName() {
        return firstName;
    }

    public ProfileViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfileViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public ProfileViewModel setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
        return this;
    }

    public FriendshipStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    public ProfileViewModel setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
        return this;
    }

    public Long getFriendRequestId() {
        return friendRequestId;
    }

    public void setFriendRequestId(Long friendRequestId) {
        this.friendRequestId = friendRequestId;
    }

    public Long getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Long friendshipId) {
        this.friendshipId = friendshipId;
    }
}
