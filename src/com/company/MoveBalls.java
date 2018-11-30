/*
package com.company;

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

public class MoveBalls extends JPanel {

    private static final int D_W = 500;
    private static final int D_H = 300;

    private List<Ball> balls;

    public MoveBalls() {
        Random rand = new Random();
        balls = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            int randX = rand.nextInt(D_W);
            int randY = rand.nextInt(D_H);
            // balls.add(new Ball(randX, randY));
            balls.add(new Ball(40, 40));
        }

        Timer timer = new Timer(15000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Ball ball : balls) {
                    ball.animate();
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.drawBall(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public class Ball {

        int x = 0;
        int y = 0; // Current ball position
        int dx = 4; // Increment on ball's x-coordinate
        int dy = 4; // Increment on ball's y-coordinate
        int radius = 15; // Ball radius

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Color color = new Color((int) (Math.random() * 256),
                (int) (Math.random() * 256), (int) (Math.random() * 256));

        public void drawBall(Graphics g) {
            g.setColor(color);
            g.fillOval(x - radius, y - radius,
                    radius * 2, radius * 2);
        }

        public void animate() {
            if (x < 0 || x > getWidth()) {
                dx = -dx;
            }
            if (y < 0 || y > getHeight()) {
                dy = -dy;
            }
            // Adjust ball position
            x += dx;
            y += dy;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new MoveBalls());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}*/
