package com.company;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
//ww  w  .  j av a2s  . com
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.company.utils.Point;
import com.company.utils.Stop;
import com.company.utils.Vehicle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;


//region GUI
/*class GUI extends JFrame{
    private JButton but = new JButton("Button");
    private  JLabel lab= new JLabel("lable");

    public GUI(){
        super("simple");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(but);
        container.add(lab);
        App app = new App();
        app.setBackground(Color.blue);
        container.add(app);
        container.add(new JLabel(new ImageIcon("C:\\Users\\romas\\OneDrive\\Робочий стіл\\Elements-Free-PNG-Image-1.png")));


    }

   *//* public void PaintComponent(Graphics g){
        ImageIcon ii= new ImageIcon("C:\\Users\\romas\\OneDrive\\Робочий стіл\\Elements-Free-PNG-Image-1.png");
        Image i = ii.getImage();
        g.drawImage(i , 0 ,0, this.getSize().width , this.getSize().height , this);

    }*//*
}*/
//endregion

//region ImagePanel
/*class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}*/
//endregion


public class App extends JPanel {
    private static final int D_W = 500;
    private static final int D_H = 300;
    private BufferedImage city;

    {
        try {
            city = ImageIO.read( new File("/easyWayDown/src/com/company/IMG/LvivMap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Vehicle> vehicles = new ArrayList<>();

    public App( String res){
        if(res == null || res.isEmpty()) {
            res="6A";
        }

        switch(res) {

            case("6A"): {

                Vehicle v1 = new Vehicle("6A", "Bohdan", 80);
                v1.addStop(new Stop("Личаківська", new Point(40, 40)));
                v1.addStop(new Stop("Підвальна", new Point(40, 240)));
                v1.addStop(new Stop("пл.Ринок", new Point(340, 240)));
                v1.addStop(new Stop("Приміський Вокзвл", new Point(340, 40)));
                v1.buildWay();
                vehicles.add(v1);
                break;
            }
            case("3A"): {

                Vehicle v1 = new Vehicle("3A", "Bohdan", 80);
                v1.addStop(new Stop("A", new Point(80, 290)));
                v1.addStop(new Stop("B", new Point(50, 20)));
                //v1.addStop(new Stop("C", new Point(540, 80)));
                v1.addStop(new Stop("D", new Point(390, 140)));
                v1.buildWay();
                vehicles.add(v1);
                Vehicle v2 = new Vehicle("3A", "Bohdan", 70);
                //v1.addStop(new Stop("C", new Point(540, 80)));
                v2.addStop(new Stop("D", new Point(390, 140)));
                v2.addStop(new Stop("A", new Point(80, 290)));
                v2.addStop(new Stop("B", new Point(50, 20)));

                v2.buildWay();
                vehicles.add(v2);
                break;
            }
        }

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for (Vehicle vehicle : vehicles) {
                    Thread thread = new Thread(){
                        public void run(){
                            vehicle.animate();
                       }
                   };
                    thread.start();
                }
                repaint();
            }
        });
        timer.start();

    }

    @Override
   protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawImage(city , 0 , 0, city.getWidth(), city.getHeight(), null);
        for(int i = 0 ; i < vehicles.get(0).route.size(); ++i){
            //g.drawLine(vehicles.get(0).route.get(i).getLocation().getX() , vehicles.get(0).route.get(i).getLocation().getY() , vehicles.get(0).route.get(i+1).getLocation().getX() , vehicles.get(0).route.get(i+1).getLocation().getY()  );
            g.setColor(Color.red);
            g.fillOval( vehicles.get(0).route.get(i).getLocation().getX()-5 , vehicles.get(0).route.get(i).getLocation().getY()-5, 10, 10);
        }
        for (Vehicle vehicle : vehicles) {
            vehicle.drawVehicle(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public static void main(String[] args) {
        Rb frame = new Rb("");

        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);


    }
}
