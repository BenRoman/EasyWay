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
import java.net.URI;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

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
    public int D_W = 500;
    public int D_H = 300;
    public int min_X = 1000;
    public int max_X = 0;
    public int min_Y = 1000;
    public int max_Y = 0;
    public BufferedImage city;

    {
        try {
            File fpic =  new File("src\\com\\company\\IMG\\LvivMap.png");
            city = ImageIO.read(fpic);
            //city = ImageIO.read( new File("/easyWayDown/src/com/company/IMG/LvivMap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Stop> route2Adef = new ArrayList<>(Arrays.asList(
            //new Stop("2A", new Point(0,590)),
        new Stop("Городоцька-Кільцева", new Point(183,538)),
        new Stop("вул. Ряшівська", new Point(180,558)),
        new Stop("", new Point(317,584)),
        new Stop("вул. Люблінська-Виговського", new Point(328,606)),
        new Stop("", new Point(423,539)),
        new Stop("вул. Антоновича", new Point(471, 561)),
        new Stop("вул. Степана Бандери", new Point(589, 457)),
        new Stop("", new Point(632, 423)),
        new Stop("Собор Святого Юра", new Point(646, 426)),
        new Stop("", new Point(669, 446)),
        new Stop("", new Point(701, 416)),
        new Stop("вул. Листопадового Чину", new Point(685, 394)),
        new Stop("", new Point(643, 426)),
        new Stop("", new Point(628, 427)),
        new Stop("", new Point(577, 447)),
        new Stop("", new Point(476, 523)),
        new Stop("", new Point(457, 513)),
        new Stop("", new Point(423, 539)),
        new Stop("", new Point(328, 606)),
        new Stop("", new Point(317, 584)),
        new Stop("", new Point(180,558)),
        new Stop("", new Point(183, 538)),
        new Stop("", new Point(0, 590))
    ));

    ArrayList<Stop> Get2ARoute()
    {
        ArrayList<Stop> route2A = new ArrayList<>();
        Random r = new Random();
        int rand = r.nextInt(route2Adef.size() - 2) + 1;

        for (int i = rand; i != rand - 1;i++ )
        {
            if(i == route2Adef.size()) i = 0;
            route2A.add(route2Adef.get(i));
        }
        /*
        for (Stop stop : route2A)
            stop.getLocation().setX(stop.getLocation().getX() - 20);
            */

        return route2A;
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
            case("16"): {

                Vehicle v1 = new Vehicle("16", "Bohdan", 80);
                v1.addStop(new Stop("Личаківська", new Point(950, 240)));
                //v1.addStop(new Stop("Підвальна", new Point(40, 240)));
                v1.addStop(new Stop("пл.Ринок", new Point(340, 240)));
                v1.addStop(new Stop("Приміський Вокзвл", new Point(340, 850)));
                v1.buildWay();
                vehicles.add(v1);
                break;
            }

            case("2A"):{

                Vehicle v1 = new Vehicle("2A m1", "Bohdan", 90);
                v1.route.addAll(Get2ARoute());
                v1.buildWay();
                vehicles.add(v1);

                Vehicle v2 = new Vehicle("2A m2", "Bohdan", 75);
                v2.route.addAll(Get2ARoute());
                v2.buildWay();
                vehicles.add(v2);

                Vehicle v3 = new Vehicle("2A m3", "Bohdan", 60);
                v3.route.addAll(Get2ARoute());
                v3.buildWay();
                vehicles.add(v3);

                Vehicle v4 = new Vehicle("2A m3", "Bohdan", 50);
                v4.route.addAll(Get2ARoute());
                v4.buildWay();
                vehicles.add(v4);

                Vehicle v5 = new Vehicle("2A m3", "Bohdan", 70);
                v5.route.addAll(Get2ARoute());
                v5.buildWay();
                vehicles.add(v5);

                break;
            }
        }

        if(vehicles.size() > 0 && vehicles.get(0).route.size()>0) {
            for (int i = 0; i < vehicles.get(0).route.size(); ++i) {
                if(vehicles.get(0).route.get(i).getLocation().getX() < min_X )
                    min_X = vehicles.get(0).route.get(i).getLocation().getX();
                if(vehicles.get(0).route.get(i).getLocation().getY() < min_Y )
                    min_Y = vehicles.get(0).route.get(i).getLocation().getY();
                if(vehicles.get(0).route.get(i).getLocation().getY() > max_Y )
                    max_Y = vehicles.get(0).route.get(i).getLocation().getY();
                if(vehicles.get(0).route.get(i).getLocation().getX() > max_X )
                    max_X = vehicles.get(0).route.get(i).getLocation().getX();
            }
        }
        D_W = max_X-min_X+40;
        D_H = max_Y-min_Y+40;
       /* showMessageDialog(null, city.getWidth());
        showMessageDialog(null, city.getHeight());*/
/*        showMessageDialog(null, min_X);
        showMessageDialog(null, max_X);
        showMessageDialog(null, min_Y);
        showMessageDialog(null, max_Y);*/
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for (Vehicle vehicle : vehicles) {
                    Thread thread = new Thread(() -> vehicle.animate());
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

        int x_pos = min_X - 20; if(x_pos < 0) x_pos = 0;
        int y_pos = min_Y - 20; if(y_pos < 0) y_pos = 0;
        int width = max_X - min_X + 40;
        int height = max_Y - min_Y + 40;
        BufferedImage copyOfImage = city.getSubimage(x_pos, y_pos, width, height);
/*        showMessageDialog(null, copyOfImage.getWidth());
        showMessageDialog(null, copyOfImage.getHeight());*/
        g.setColor(Color.BLACK);
        g.drawImage(copyOfImage , 0 , 0, copyOfImage.getWidth(), copyOfImage.getHeight(), null);
        for(int i = 0 ; i < vehicles.get(0).route.size(); ++i){
            //g.drawLine(vehicles.get(0).route.get(i).getLocation().getX() , vehicles.get(0).route.get(i).getLocation().getY() , vehicles.get(0).route.get(i+1).getLocation().getX() , vehicles.get(0).route.get(i+1).getLocation().getY()  );
            g.setColor(Color.red);
            g.fillOval( vehicles.get(0).route.get(i).getLocation().getX()+15 - min_X , vehicles.get(0).route.get(i).getLocation().getY()+15 - min_Y, 10, 10);
        }
        for (Vehicle vehicle : vehicles) {
            vehicle.drawVehicle(g , min_X , min_Y);
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
