package com.company;

import com.company.utils.Point;
import com.company.utils.Stop;
import com.company.utils.Vehicle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class App extends JPanel {
    private static final int D_W = 500;
    private static final int D_H = 300;

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public App(){
        Vehicle v1 = new Vehicle("1111", "Bohdan");
        v1.addStop(new Stop("Личаківська", new Point(40, 40)));
        v1.addStop(new Stop("Підвальна", new Point(40, 240)));
        v1.addStop(new Stop("пл.Ринок", new Point(340, 240)));
        v1.addStop(new Stop("Приміський Вокзвл", new Point(340, 40)));
        v1.buildWay();

        vehicles.add(v1);

        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.animate();
                }
                repaint();
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new App());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
