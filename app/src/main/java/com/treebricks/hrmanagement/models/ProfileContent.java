package com.treebricks.hrmanagement.models;

public class ProfileContent {
    private int contentIcon;
    private String contentValue;
    private String contentType;

    public ProfileContent(int contentIcon, String contentValue, String contentType) {
        this.contentIcon = contentIcon;
        this.contentValue = contentValue;
        this.contentType = contentType;
    }

    public int getContentIcon() {
        return contentIcon;
    }

    public void setContentIcon(int contentIcon) {
        this.contentIcon = contentIcon;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
