package com.example.mosque;

import java.io.Serializable;

public class Staff implements Serializable {


    private static final long serialVersionUID = 1L;
    public int id;
    public String staffName;
    public String staffPhone;
    public String staffUsername;
    public String staffPassword;
    public String staffPic;
    public String staffRole;

    public Staff() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffPic() {
        return staffPic;
    }

    public void setStaffPic(String staffPic) {
        this.staffPic = staffPic;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }
}