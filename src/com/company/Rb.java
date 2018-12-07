package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

class Rb  extends JFrame {

    public String res;
    Rb (String a) {
        res = a;
        JPanel jp = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JRadioButton first = new JRadioButton("6A");
        first.setActionCommand("6A");
        JRadioButton second = new JRadioButton("3A");
        second.setActionCommand("3A");
        JRadioButton third = new JRadioButton("16");
        third.setActionCommand("16");
        JRadioButton fourth = new JRadioButton("53");
        fourth.setActionCommand("53");

        JRadioButton btn2a = new JRadioButton("2A");
        btn2a.setActionCommand("2A");
        JRadioButton btn1a = new JRadioButton("1A");
        btn1a.setActionCommand("1A");
        JRadioButton btn31 = new JRadioButton("31");
        btn31.setActionCommand("31");

        JButton jb = new JButton("OK");

        ButtonGroup bG = new ButtonGroup();
        bG.add(first);
        bG.add(second);
        bG.add(third);
        bG.add(fourth);

        bG.add(btn2a);
        bG.add(btn1a);
        bG.add(btn31);

        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                res = bG.getSelection().getActionCommand();

                setVisible(false);

                Rb frame = new Rb(res);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        App app = new App(res);
        this.add(app);
        c.gridx = 0;
        c.gridy = 1;
        jp.add(first, c);
        c.gridx = 0;
        c.gridy = 2;
        jp.add(second, c);
        c.gridx = 0;
        c.gridy = 3;
        jp.add(third, c);
        c.gridx = 0;
        c.gridy = 4;
        jp.add(fourth, c);

        c.gridx = 0;
        c.gridy = 5;
        jp.add(btn2a, c);

        c.gridx = 0;
        c.gridy = 6;
        jp.add(btn1a, c);

        c.gridx = 0;
        c.gridy = 7;
        jp.add(btn31, c);

        c.gridx = 0;
        c.gridy = 8;
        jp.add(jb, c);

        this.setSize(100, 200);
        this.setLayout(new FlowLayout());
        this.add(jp);
        //showMessageDialog(null, app.vehicles.get(0).route);

        String str = "";
        if (app.vehicles.size() > 0) {
            str = "\t" + app.vehicles.get(0).id + "\n";
            for (int i = 0; i < app.vehicles.get(0).route.size(); ++i) {
                String text = app.vehicles.get(0).route.get(i).getName();
                if (text != "")
                    str += text + "\n";
            }
        }
        if (res != "") {
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            JTextArea ja = new JTextArea(str);
            ja.setBorder(BorderFactory.createCompoundBorder(border,
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            this.add(ja);
        }

        //  first.setSelected(true);
    }
}