package com.printx.imageserver;

public class Image {
    private String big;
    private String medium;
    private String small;

    public Image(String filename) {
        this.big = filename;
        this.medium = filename;
        this.small = filename;
    }

    public String getBig() {
        return big;
    }

    public String getMedium() {
        return medium;
    }

    public String getSmall() {
        return small;
    }
}
