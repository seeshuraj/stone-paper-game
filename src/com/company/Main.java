package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;


public class Main extends JFrame {
    JLabel l, l1, l2,l3;
    JTextArea t,t1, t2;
    JButton btn;
    int tot = 0,hscore=0;
    static Scanner s=new Scanner(System.in);
    static String user;

    Main() throws IOException {
        setLayout(new FlowLayout());

        l = new JLabel("Player");
        l.setBounds(150, 50, 100, 50);
        add(l);
        t = new JTextArea(1, 7);
        add(t);
        btn = new JButton("play");
        btn.setBounds(200, 150, 100, 20);
        add(btn);

        l1 = new JLabel("Bot");
        l1.setBounds(150, 90, 100, 50);
        add(l1);

        t1 = new JTextArea(1, 7);
        add(t1);

        l2 = new JLabel("TOTAL");
        l2.setBounds(150, 195, 100, 50);
        add(l2);
        t2 = new JTextArea(2, 10);
        add(t2);
        l3=new JLabel();
        add(l3);

        JLabel ax = new JLabel(new ImageIcon("C:\\Users\\HP\\Desktop\\r.png"));
        add(ax);

        event e = new event();
        btn.addActionListener(e);
    }

    class event implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            String m = e.getActionCommand();


            String con = t.getText();
            Random r = new Random();
            String[] arr={"stone","paper","scissor"};
            //int max = 3, min = 0;
            int s1 = r.nextInt(3);
            if (arr[s1].equalsIgnoreCase(con)) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\face.txt"));
                    String st;
                    String line = null;
                    while ((st = br.readLine()) != null){
                        line=st;
                    }
                    String num[]=line.split(" ");
                    hscore=Integer.parseInt(num[1]);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if(hscore<tot){
                     hscore=tot;
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\face.txt", true));
                        writer.write(user);
                        writer.write(tot);
                        writer.close();
                    } catch (IOException ex) {
                        System.out.println("An error occurred.");
                        ex.printStackTrace();
                    }
                    }
                    l3.setText("Game over\ntotal score="+tot+"\nhigh score="+hscore);




            } else {
                t1.setText(arr[s1] + "");
                tot+=1;
                t2.setText("Not out\ntotal score=" + tot);
            }


        }

    }

    public static void main(String[] args) throws IOException {

        user=s.nextLine();
        Main c=new Main();
        c.setTitle("stone-paper");
        c.setSize(600, 500);
        c.getContentPane().setBackground(Color.LIGHT_GRAY);
        c.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setVisible(true);
    }

}