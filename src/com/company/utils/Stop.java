package com.company.utils;

public class Stop {
    private String name;
    private Point location;

    public Stop(String name, Point location){
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Point getLocation() {
        return location;
    }
}
