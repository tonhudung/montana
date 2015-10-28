package com.montana.models.nodes;

import com.montana.models.Gender;
import com.montana.models.relationships.FriendRequest;
import com.montana.models.relationships.ProfilePicture;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.*;

public class User {


    private Long id;

    private String email;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    @DateLong
    private Date dateOfBirth;

    private Gender gender;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean enabled;

    private Boolean credentialsNonExpired;

    @CreatedDate
    @DateLong
    private Date createdDate;

    @LastModifiedDate
    @DateLong
    private Date lastModifiedDate;

    @Relationship(type = "UPLOADED")
    private Set<Photo> photos;

    @Relationship(type = "UPLOADED")
    private Set<Video> videos;

    @Relationship(type = "POSTED")
    private Set<Post> posts;

    @Relationship(type = "HAS_PROFILE_PICTURE")
    private ProfilePicture profilePicture;

    @Relationship(type = "FRIENDS", direction = Relationship.UNDIRECTED)
    private Set<User> friends;

    @Relationship(type = "FRIEND_REQUEST", direction = Relationship.OUTGOING)
    private Set<FriendRequest> sentFriendRequests;

    @Relationship(type = "FRIEND_REQUEST", direction = Relationship.INCOMING)
    private Set<FriendRequest> receivedFriendRequests;

    public User() {
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
        createdDate = new Date();
    }


    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public User setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public Boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public User setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public User setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public User setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public User setFriends(Set<User> friends) {
        this.friends = friends;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public User setPhotos(Set<Photo> photos) {
        this.photos = photos;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public User setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public User setPosts(Set<Post> posts) {
        this.posts = posts;
        return this;
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public User setVideos(Set<Video> videos) {
        this.videos = videos;
        return this;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public User setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public ProfilePicture getProfilePicture() {
        return profilePicture;
    }

    public User setProfilePicture(ProfilePicture profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public Set<FriendRequest> getSentFriendRequests() {
        return sentFriendRequests;
    }

    public void setSentFriendRequests(Set<FriendRequest> sentFriendRequests) {
        this.sentFriendRequests = sentFriendRequests;
    }

    public Set<FriendRequest> getReceivedFriendRequests() {
        return receivedFriendRequests;
    }

    public void setReceivedFriendRequests(Set<FriendRequest> receivedFriendRequests) {
        this.receivedFriendRequests = receivedFriendRequests;
    }
}