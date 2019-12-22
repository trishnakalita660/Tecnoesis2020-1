package com.github.tenx.tecnoesis20.ui.main.home;

public class events {
    private String EventsNames;
    private String Description;
    private int images;

    public events(String eventsNames, String description, int images) {
        EventsNames = eventsNames;
        Description = description;
        this.images = images;
    }

    public String getEventsNames() {
        return EventsNames;
    }

    public void setEventsNames(String eventsNames) {
        EventsNames = eventsNames;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
