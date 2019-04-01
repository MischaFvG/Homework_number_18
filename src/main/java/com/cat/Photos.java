package com.cat;

public class Photos {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thubnailUrl;

    @Override
    public String toString() {
        return "Photos{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thubnailUrl='" + thubnailUrl + '\'' +
                '}';
    }
}
