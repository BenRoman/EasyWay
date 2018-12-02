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

    int radius = 15; // Ball radius
    //

    public ArrayList<Stop> route;
    public ArrayList<Point> way;
    public String name;
    public String id;
    private int speed;
    private int currentPosition;
    private BufferedImage image;
    {
        try {
            image = ImageIO.read( new File("/easyWayDown/src/com/company/IMG/transportation__bus-512.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vehicle(String id, String name , int speed){
        this.id = id;
        this.name = name;
        this.speed = speed;
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

            dx = (end.getX() - start.getX())/(speed/10);
            dy = (end.getY() - start.getY())/(speed/10);



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
       //showMessageDialog(null, route.get(tmp).getName());
    }

    public void animate(){
        move();
    }


    public void drawVehicle(Graphics g , int a , int b ) {
      /*  try {
            Thread.sleep(speed*20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        g.drawImage(image , (int)(way.get(currentPosition).getX() - radius )+27 -a,(int)(way.get(currentPosition).getY() - radius)+27 - b , image.getWidth()/30, image.getHeight()/30, null);

    }
}
