package com.hms;

public class User {
    private int Id;
    private String Full_Name;
    private String Email;
    private String Password;

    public User() {
        super();
    }

    public User(String full_Name, String email, String password) {
        Full_Name = full_Name;
        Email = email;
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
