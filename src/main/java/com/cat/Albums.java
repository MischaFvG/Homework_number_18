package com.cat;

public class Albums {
    private int userId;
    private int id;
    private String title;

    @Override
    public String toString() {
        return "Albums{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
