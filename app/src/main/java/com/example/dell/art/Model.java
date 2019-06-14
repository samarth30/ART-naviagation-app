package com.example.dell.art;

public class Model {
    String Title;
    String Description;
    int icon;

    public Model(String title, int icon) {
        Title = title;
        this.icon = icon;
    }

    public Model(String title, String description, int icon) {
        this.Title = title;
        this.Description = description;
        this.icon = icon;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getDescription() {
        return this.Description;
    }

    public int getIcon() {
        return this.icon;
    }
}
