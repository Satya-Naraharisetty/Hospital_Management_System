package com.hms.entity;

public class Appointment {
    private int Id;
    private int UserId;
    private String Full_Name;
    private String Gender;
    private String Age;
    private String appoint_date;
    private String Email;
    private String PhNo;
    private String Disease;
    private int Doctor_Id;
    private String Address;
    private String Status;

    public Appointment() {
        super();
    }

    public Appointment(int userId, String full_Name, String gender, String age, String appoint_date, String email, String phNo, String disease, int doctor_Id, String address, String status) {
        this.UserId = userId;
        this.Full_Name = full_Name;
        this.Gender = gender;
        this.Age = age;
        this.appoint_date = appoint_date;
        this.Email = email;
        this.PhNo = phNo;
        this.Disease = disease;
        this.Doctor_Id = doctor_Id;
        this.Address = address;
        this.Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getAppoint_date() {
        return appoint_date;
    }

    public void setAppoint_date(String appoint_date) {
        this.appoint_date = appoint_date;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhNo() {
        return PhNo;
    }

    public void setPhNo(String phNo) {
        PhNo = phNo;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public int getDoctor_Id() {
        return Doctor_Id;
    }

    public void setDoctor_Id(int doctor_Id) {
        Doctor_Id = doctor_Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}