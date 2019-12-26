package com.github.tenx.tecnoesis20.ui.main.events;

public class EventsModel {
    private int module_image;

    public EventsModel(int  image) {
        this.module_image = image;
    }

    public int  getImage() {
        return module_image;
    }

    public void setImage(int   image) {
        this.module_image = image;
    }
}
