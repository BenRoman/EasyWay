package com.company.utils;

import java.awt.*;
import java.util.ArrayList;


public class Vehicle {
    // temp
    Color color = new Color((int) (Math.random() * 256),
            (int) (Math.random() * 256), (int) (Math.random() * 256));
    int radius = 15; // Ball radius
    //

    private ArrayList<Stop> route;
    private ArrayList<Point> way;
    private String name;
    private String id;
    private int currentPosition;


    public Vehicle(String id, String name){
        this.id = id;
        this.name = name;
        route = new ArrayList<>();
        way = new ArrayList<>();
    }

    public void addStop(Stop stop){
        route.add(stop);
    }

    public void removeStop(int idx){
        route.remove(idx);
    }

    public void buildWay(){
        double STEP = 0.1;
        Point start;
        Point end;
        double dx, startX;
        double dy, startY;
        for(int i=0; i<route.size(); i++){
            start = route.get(i).getLocation();
            end = route.get((i+1)%route.size()).getLocation();

            dx = end.getX() - start.getX();
            dy = end.getY() - start.getY();

            startX = start.getX();
            startY = start.getY();

            while(startX < end.getX() && startY < end.getY()){
                way.add(new Point(startX, startY));
                startX += STEP*dx;
                startY += STEP*dy;
            }

            way.add(new Point(end.getX(), end.getY()));
        }

        currentPosition = 0;
    }

    public void move(){
        currentPosition = (currentPosition+1)%way.size();
    }

    public void animate(){
        move();
    }


    public void drawVehicle(Graphics g) {
        g.setColor(color);
        g.fillOval((int)(way.get(currentPosition).getX() - radius), (int)(way.get(currentPosition).getY() - radius),
                radius * 2, radius * 2);
    }
}
