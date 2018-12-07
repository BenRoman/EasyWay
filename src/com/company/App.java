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
        new Stop("", new Point(15,586)),
        new Stop("Городоцька-Кільцева", new Point(183 + 0,538)),
        new Stop("вул. Ряшівська", new Point(180 + 0,558)),
        new Stop("", new Point(317 + 0,584)),
        new Stop("вул. Люблінська-Виговського", new Point(328 + 0,606)),
        new Stop("", new Point(423 + 0,539)),
        new Stop("вул. Антоновича", new Point(471 + 0, 561)),
        new Stop("вул. Степана Бандери", new Point(589 + 0, 457)),
        new Stop("", new Point(632 + 0, 423)),
        new Stop("Собор Святого Юра", new Point(646 + 0, 426)),
        new Stop("", new Point(669 + 0, 446)),
        new Stop("", new Point(701 + 0, 416)),
        new Stop("вул. Листопадового Чину", new Point(685 + 0, 394)),
        new Stop("", new Point(643 + 0, 426)),
        new Stop("", new Point(628 + 0, 427)),
        new Stop("", new Point(577 + 0, 447)),
        new Stop("", new Point(476 + 0, 523)),
        new Stop("", new Point(457 + 0, 513)),
        new Stop("", new Point(423 + 0, 539)),
        new Stop("", new Point(328 + 0, 606)),
        new Stop("", new Point(317 + 0, 584)),
        new Stop("", new Point(180 + 0,558)),
        new Stop("", new Point(183 + 0, 538)),
        new Stop("", new Point(15, 586))
    ));

    ArrayList<Stop> route1Adef = new ArrayList<>(Arrays.asList(
            new Stop("ринок \"Галицьке перехрестя\"", new Point(966, 30)),
            new Stop("Автостанція №2", new Point(909, 132)),
            new Stop("вул. Бетховена", new Point(817, 134)),
            new Stop("вул. Замарстинівська", new Point(749,161)),
            new Stop("Шевченківська райадміністрація", new Point(692, 219)),
            new Stop("вул. Пантелеймона Куліша", new Point(716, 292)),
            new Stop("пр. В'ячеслава Чорновола", new Point(728, 351)),
            new Stop("пл. Галицька", new Point(743, 404)),
            new Stop("", new Point(794, 396)),
            new Stop("вул. Підвальна", new Point(778,356)),
            //
            new Stop("", new Point(728,351)),
            new Stop("", new Point(716,292)),
            new Stop("", new Point(692, 219)),
            new Stop("", new Point(749, 161)),
            new Stop("", new Point(817,134)),
            new Stop("", new Point(909,132)),
            new Stop("", new Point(966,30))
    ));

    ArrayList<Stop> route31def = new ArrayList<>(Arrays.asList(
            new Stop("Залізничний вокзал", new Point(508,411)),
            new Stop("пл. Кропивницького", new Point(559,430)),
            new Stop("Церква святої Анни", new Point(670,369)),
            new Stop("пр. В'ячеслава Чорновола", new Point(730, 349)),
            new Stop("Шевченківська райадміністрація", new Point(693, 219)),
            new Stop("вул. Варшавська", new Point(657,109)),
            new Stop("Замарстинів", new Point(673,69)),
            new Stop("вул. Гетьмана Мазепи", new Point(708,86)),
            new Stop("вул. Грінченка", new Point(879, 45)),
            new Stop("вул. Чигиринська", new Point(941,77)),
            new Stop("ринок \"Галицьке перехрестя\"", new Point(974,15)),
            //
            new Stop("", new Point(941,77)),
            new Stop("", new Point(879,45)),
            new Stop("", new Point(708,86)),
            new Stop("", new Point(673,69)),
            new Stop("", new Point(657,109)),
            new Stop("", new Point(693,219)),
            new Stop("", new Point(730,349)),
            new Stop("", new Point(670,369)),
            new Stop("", new Point(559,430)),
            new Stop("", new Point(508,411))
    ));

    ArrayList<Stop> GetRouteFrom(ArrayList<Stop> route)
    {
        ArrayList<Stop> new_route = new ArrayList<>();
        Random r = new Random();
        int rand = r.nextInt(route.size() - 2) + 1;

        for (int i = rand; i != rand - 1;i++ )
        {
            if(i == route.size()) i = 0;
            new_route.add(route.get(i));
        }

        return new_route;
    }

    Vehicle Create2A(int idx, int speed, String name)
    {
        Vehicle v = new Vehicle("2A m" + idx, name, speed);
        v.route.addAll(GetRouteFrom(route2Adef));
        v.buildWay();
        vehicles.add(v);
        return v;
    }

    Vehicle Create1A(int idx, int speed, String name)
    {
        Vehicle v = new Vehicle("1A m" + idx, name, speed);
        v.route.addAll(GetRouteFrom(route1Adef));
        v.buildWay();
        vehicles.add(v);
        return v;
    }
    Vehicle Create31(int idx, int speed, String name)
    {
        Vehicle v = new Vehicle("31 m" + idx, name, speed);
        v.route.addAll(GetRouteFrom(route31def));
        v.buildWay();
        vehicles.add(v);
        return v;
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

                vehicles.add(Create2A(1,90, "Bohdan"));
                vehicles.add(Create2A(2,75, "Bohdan"));
                vehicles.add(Create2A(3,60, "Bohdan"));
                vehicles.add(Create2A(4,50, "Bohdan"));
                vehicles.add(Create2A(5,70, "Bohdan"));

                break;
            }

            case("1A"):
            {
                vehicles.add(Create1A(1,90, "Bohdan"));
                vehicles.add(Create1A(2,82, "Bohdan"));
                vehicles.add(Create1A(3,75, "Bohdan"));
                vehicles.add(Create1A(4,63, "Bohdan"));

                break;
            }

            case("31"):
            {
                vehicles.add(Create31(1,90, "Bohdan"));
                vehicles.add(Create31(2,86, "Bohdan"));
                vehicles.add(Create31(3,74, "Bohdan"));
                vehicles.add(Create31(4,68, "Bohdan"));
                vehicles.add(Create31(5,64, "Bohdan"));

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
            g.fillOval( vehicles.get(0).route.get(i).getLocation().getX() + 15 - min_X , vehicles.get(0).route.get(i).getLocation().getY() + 15 - min_Y, 10, 10);
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
