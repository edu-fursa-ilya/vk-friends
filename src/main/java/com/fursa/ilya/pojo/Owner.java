package com.fursa.ilya.pojo;

public class Owner {
    private int uid;

    public Owner(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "uid=" + uid +
                '}';
    }
}
