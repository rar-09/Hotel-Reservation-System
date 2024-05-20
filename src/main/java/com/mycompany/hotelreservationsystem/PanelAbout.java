/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import javax.swing.*;
import java.awt.*;

public class PanelAbout extends JPanel {
    JPanel pnlBoys;
    JPanel pnlCenter;
    JPanel pnlGirls;
    
    JPanel pnlOther;
    
    int biW = 150;
    int biH = 150;
    
    ImageIcon icon1 = new ImageIcon(PanelAbout.class.getClassLoader().getResource("yvan.png"));
    Image image1 = icon1.getImage();
    Image new_image1 = image1.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgYvan = new ImageIcon(new_image1);
    
    ImageIcon icon2 = new ImageIcon(MainContent.class.getClassLoader().getResource("lovely.png"));
    Image image2 = icon2.getImage();
    Image new_image2 = image2.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgLovely = new ImageIcon(new_image2);
    
//    String pathImg3 = "C:\\resources\\images\\admin.jpg";
    ImageIcon icon3 = new ImageIcon(MainContent.class.getClassLoader().getResource("aina.jpeg"));
    Image image3 = icon3.getImage();
    Image new_image3 = image3.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgAina = new ImageIcon(new_image3);
    
//    String pathImg4 = "C:\\resources\\images\\about.jpg";
    ImageIcon icon4 = new ImageIcon(MainContent.class.getClassLoader().getResource("kyle.png"));
    Image image4 = icon4.getImage();
    Image new_image4 = image4.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgKyle = new ImageIcon(new_image4);

//    String pathImg5 = "C:\\resources\\images\\sign-out.jpg";
    ImageIcon icon5 = new ImageIcon(MainContent.class.getClassLoader().getResource("ra2.jpg"));
    Image image5 = icon5.getImage();
    Image new_image5 = image5.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgRA = new ImageIcon(new_image5);
    
    ImageIcon icon6 = new ImageIcon(MainContent.class.getClassLoader().getResource("info.png"));
    Image image6 = icon6.getImage();
    Image new_image6 = image6.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    Icon imgInfo = new ImageIcon(new_image6);
    
    PanelAbout() {
        setLayout(new GridLayout(2, 1));
        setBackground(Color.WHITE);
        
        
            
        
        pnlCenter = new JPanel();
        pnlOther = new JPanel();
//        BoxLayout boxLayout3 = new BoxLayout(pnlCenter, BoxLayout.Y_AXIS);
//            pnlCenter.setLayout(boxLayout3);
        
            JLabel lblYvan = new JLabel();
            lblYvan.setIcon(imgYvan);
            JLabel lblLovely = new JLabel();
            lblLovely.setIcon(imgLovely);
            JLabel lblAina = new JLabel();
            lblAina.setIcon(imgAina);
            JLabel lblKyle = new JLabel();
            lblKyle.setIcon(imgKyle);
            JLabel lblRA = new JLabel();
            lblRA.setIcon(imgRA);
            
            JLabel lblInfo = new JLabel();
            lblInfo.setIcon(imgInfo);
        
//        pnlCenter.add(lblYvan);    
//            
//        pnlBoys = new JPanel();
//        BoxLayout boxLayout4 = new BoxLayout(pnlBoys, BoxLayout.Y_AXIS);
//            pnlCenter.setLayout(boxLayout4);
//        
//            pnlBoys.add(lblKyle);
//            pnlBoys.add(lblRA);
//            
//        pnlGirls = new JPanel();
//        BoxLayout boxLayout5 = new BoxLayout(pnlGirls, BoxLayout.Y_AXIS);
//            pnlGirls.setLayout(boxLayout5);
//        
//            pnlGirls.add(lblLovely);
//            pnlGirls.add(lblAina);
//       
//        
//        add(pnlBoys);
//        add(pnlCenter);
//        add(pnlGirls);

        
        pnlCenter.add(lblLovely);
        pnlCenter.add(lblAina);
        pnlCenter.add(lblYvan);
        pnlCenter.add(lblKyle);
        pnlCenter.add(lblRA);
        
        pnlOther.add(lblInfo);
        
        add(pnlCenter);
        add(pnlOther);
    }
}
