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
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;


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

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public App(JFrame frame){
       /* ImagePanel panel = new ImagePanel(new ImageIcon("/easyWayDown/src/com/company/IMG/LvivMap.png").getImage());*/
        Vehicle v1 = new Vehicle("1111", "Bohdan");
        v1.addStop(new Stop("Личаківська", new Point(40, 40)));
        v1.addStop(new Stop("Підвальна", new Point(40, 240)));
        //v1.addStop(new Stop("пл.Ринок", new Point(340, 240)));
        v1.addStop(new Stop("Приміський Вокзвл", new Point(340, 40)));
        v1.buildWay();

        vehicles.add(v1);

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.animate();
                }

                repaint();
                /*  frame.getContentPane().add(panel);*/
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : vehicles) {
            vehicle.drawVehicle(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new App(frame));
        frame.pack();
        frame.setVisible(true);

        //region comments
       /* GUI gui = new GUI();
        gui.getContentPane().add(panel);
        gui.setVisible(true);*/
       /* SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();

                Container container = frame.getContentPane();
             //   container.add(new App());
                container.add(new JLabel(new ImageIcon("C:\\Users\\romas\\OneDrive\\Робочий стіл\\Elements-Free-PNG-Image-1.png")));

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });*/
        //endregion
    }
}
