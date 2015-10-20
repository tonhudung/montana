package com.montana.models.nodes;

import com.montana.models.Gender;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NodeEntity
public class User {

    @GraphId
    private Long id;
    private String email;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Gender gender;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean credentialsNonExpired;

    @Relationship(type = "UPLOADED")
    private List<Photo> photos;

    @Relationship(type = "HAS_PROFILE_PICTURE")
    private Photo profilePicture;

    @Relationship(type = "FRIENDS", direction = Relationship.UNDIRECTED)
    private List<User> friends;

    public User() {
        accountNonExpired = true;
        accountNonLocked = true;
        accountNonExpired = true;
        credentialsNonExpired = true;
        enabled = true;
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

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public User setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public User setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public User setCredentialsNonExpired(boolean credentialsNonExpired) {
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

    public List<User> getFriends() {
        return friends;
    }

    public User setFriends(List<User> friends) {
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

    public List<Photo> getPhotos() {
        if (photos == null)
            photos = new ArrayList<Photo>();
        return photos;
    }

    public User setPhotos(List<Photo> photos) {
        this.photos = photos;
        return this;
    }

    public Photo getProfilePicture() {
        return profilePicture;
    }

    public User setProfilePicture(Photo profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }
}