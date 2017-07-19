package com.fursa.ilya.pojo;

public class Mutual {
    private int user1;
    private int user2;
    private int mutualId;

    public Mutual(int user1, int user2, int mutualId) {
        this.user1 = user1;
        this.user2 = user2;
        this.mutualId = mutualId;
    }

    public Mutual() {

    }

    @Override
    public String toString() {
        return "Mutual{" +
                "user1=" + user1 +
                ", user2=" + user2 +
                ", mutualId=" + mutualId +
                '}';
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }

    public int getMutualId() {
        return mutualId;
    }

    public void setMutualId(int mutualId) {
        this.mutualId = mutualId;
    }
}
