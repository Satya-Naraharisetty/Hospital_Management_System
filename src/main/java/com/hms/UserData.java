package com.hms;

public class UserData {
    private int Id;
    private String Full_Name;
    private String Role;
    private String Email;
    private String Password;

    public UserData() {
        super();
    }

    public UserData(String full_Name, String role, String email, String password) {
        Full_Name = full_Name;
        Role = role;
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

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
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
