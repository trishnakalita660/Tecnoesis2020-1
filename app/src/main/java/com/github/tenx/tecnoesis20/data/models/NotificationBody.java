package com.github.tenx.tecnoesis20.data.models;

public class NotificationBody {

    String senderName;
    String title;
    String message;
    String image;


    public NotificationBody(String senderName, String title, String message, String image) {
        this.senderName = senderName;
        this.title = title;
        this.message = message;
        this.image = image;
    }

    public NotificationBody(String senderName, String title, String message) {
        this.senderName = senderName;
        this.title = title;
        this.message = message;
    }

    public NotificationBody() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
