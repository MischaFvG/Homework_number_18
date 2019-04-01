package com.cat;

public class Posts {
    private int userId;
    private int id;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "Posts{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
