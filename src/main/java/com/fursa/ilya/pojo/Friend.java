package com.fursa.ilya.pojo;

public class Friend {
    private int uid;
    private String firstName;
    private String lastName;
    private int sex;

    public Friend(int uid, String firstName, String lastName, int sex) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public Friend() {

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                '}';
    }
}