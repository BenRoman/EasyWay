package com.company.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;


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
    private BufferedImage image;
    private BufferedImage city;

    {
        try {
            image = ImageIO.read( new File("/easyWayDown/src/com/company/IMG/icon_sets_school_outline_hand_drawn_colored_iconfinder-18-512.png"));
            city = ImageIO.read( new File("/easyWayDown/src/com/company/IMG/LvivMap.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        int STEPX;
        int STEPY;
        Point start;
        Point end;
        int dx, startX;
        int dy, startY;
        for(int i=0; i<route.size(); i++){
            start = route.get(i).getLocation();
            end = route.get((i+1)%route.size()).getLocation();

            dx = (end.getX() - start.getX())/10;
            dy = (end.getY() - start.getY())/10;

            startX = start.getX();
            startY = start.getY();

            while( Math.signum(dx)*(end.getX()- startX) > 0 || Math.signum(dy) *(end.getY() - startY) > 0){
                way.add(new Point(startX, startY));
                startX += dx;
                startY += dy;
            }

            way.add(new Point(end.getX(), end.getY()));
        }

        currentPosition = 0;
    }

    public void move(){
        currentPosition = (currentPosition+1)%way.size();
        int tmp = currentPosition;

        showMessageDialog(null, route.get(tmp).getName());
    }

    public void animate(){
        move();
    }


    public void drawVehicle(Graphics g) {
        g.setColor(color);
        g.drawImage(city , 0 , 0, city.getWidth(), city.getHeight(), null);
        g.drawImage(image , (int)(way.get(currentPosition).getX() - radius) ,(int)(way.get(currentPosition).getY() - radius) , image.getWidth()/10, image.getHeight()/10, null);
    }
}
