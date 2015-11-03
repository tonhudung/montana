package com.montana.models.nodes;

import com.montana.models.Gender;
import com.montana.models.relationships.FriendRequest;
import com.montana.models.relationships.Friendship;
import com.montana.models.relationships.LocalBusinessOwner;
import com.montana.models.relationships.ProfilePicture;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.neo4j.ogm.annotation.typeconversion.EnumString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;

    private String email;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    @DateLong
    private Date dateOfBirth;

    @EnumString(value = Gender.class)
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
    private Set<Photo> photos = new HashSet<Photo>();

    @Relationship(type = "UPLOADED")
    private Set<Video> videos = new HashSet<Video>();

    @Relationship(type = "HAS_PROFILE_PICTURE")
    private ProfilePicture profilePicture;

    @Relationship(type = "FRIENDS", direction = Relationship.UNDIRECTED)
    private Set<Friendship> friendships = new HashSet<Friendship>();

    @Relationship(type = "FRIEND_REQUEST")
    private Set<FriendRequest> friendRequests = new HashSet<FriendRequest>();

    @Relationship(type = "OWNS")
    private Set<LocalBusinessOwner> localBusinesses;

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

    public Set<Friendship> getFriendships() {
        return friendships;
    }

    public User setFriendships(Set<Friendship> friendships) {
        this.friendships = friendships;
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

    public Set<FriendRequest> getFriendRequests() {
        return friendRequests;
    }

    public User setFriendRequests(Set<FriendRequest> friendRequests) {
        this.friendRequests = friendRequests;
        return this;
    }

    public Set<LocalBusinessOwner> getLocalBusinesses() {
        return localBusinesses;
    }

    public User setLocalBusinesses(Set<LocalBusinessOwner> localBusinesses) {
        this.localBusinesses = localBusinesses;
        return this;
    }
}