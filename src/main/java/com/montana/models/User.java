package com.montana.models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NodeEntity
public class User {

    @GraphId Long id;
    String email;

    String userName;
    String password;
    String salt;
    String firstName;
    String lastName;
    Date dateOfBirth;
    Gender gender;
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean enabled;
    boolean credentialsNonExpired;

    @Relationship(type = "UPLOADED")
    List<Photo> photos;

    @Relationship(type = "HAS_PROFILE_PICTURE")
    Photo profilePicture;

    @Relationship(type = "FRIEND", direction = Relationship.UNDIRECTED)
    List<User> friends;

    public User() {
        salt = KeyGenerators.string().generateKey();
        accountNonExpired = true;
        accountNonLocked = true;
        accountNonExpired = true;
        credentialsNonExpired = true;
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
        this.password = new Md5PasswordEncoder().encodePassword(password, salt);
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

    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
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