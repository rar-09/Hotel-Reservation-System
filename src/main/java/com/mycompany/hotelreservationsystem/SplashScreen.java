/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.lang.Math;

public class SplashScreen {
   
    
//    JButton btnSeggs = new JButton("LOADING");
    int track = 0, max = 80, min = 50;
    int range = max - min + 1;
    JProgressBar loading = new JProgressBar(0, 200);
//    UIManager.put("ProgressBar.background", Color.ORANGE);
//    UIManager.put("ProgressBar.foreground", Color.BLUE);
//    UIManager.put("ProgressBar.selectionBackground", Color.RED);
//    UIManager.put("ProgressBar.selectionForeground", Color.GREEN);
    public static JFrame frmSplashScreen = new JFrame();
    
    public void move()
    {
        while(track <= 200)
        {
            
            
            int rand = (int) (Math.random() * range);
            track = track + rand;
            System.out.println(rand);
            loading.setValue(track);
            try
            {
                Thread.sleep(300);
            } catch (Exception e)
            {
                
            }
        }
        
        if (track > 200)
        {

            HotelReservationSystem.loginFrame.setVisible(true);
            frmSplashScreen.setVisible(false);
            HotelReservationSystem.frame.setVisible(false);
        }
    }
    
    public SplashScreen()
    {
        ImageIcon icon1 = new ImageIcon(SplashScreen.class.getClassLoader().getResource("splashRed.png"));
        Image image1 = icon1.getImage();
        Image new_image1 = image1.getScaledInstance(1000, 600, java.awt.Image.SCALE_SMOOTH);
        Icon imgSplashLogo = new ImageIcon(new_image1);
        
        JLabel lblLogo = new JLabel();
            lblLogo.setIcon(imgSplashLogo);
            lblLogo.setBounds(0, 0, 1000, 600);
        
        frmSplashScreen.add(lblLogo);
            
        frmSplashScreen.setLayout(null);
        
        loading.setBounds(200, 500, 600, 20);
        
        frmSplashScreen.setBackground(Color.DARK_GRAY);
        frmSplashScreen.add(loading);
        
//        frmSplashScreen.setUndecorated(true);
        frmSplashScreen.setUndecorated(true);
        frmSplashScreen.setShape(new RoundRectangle2D.Double(0, 0, 1000, 600, 50, 50));
        frmSplashScreen.setSize(1000,600);
        frmSplashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSplashScreen.setLocationRelativeTo(null);
        frmSplashScreen.setVisible(true);
        
        move();
    }
    

    
   
}
