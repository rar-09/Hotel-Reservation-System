/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MainContent extends JPanel implements ActionListener {
    
    JButton btnReserve, btnRecords, btnAdmin, btnAbout, btnSignOut;
    PanelReserve pnlReserve;
    PanelRecords pnlRecords;
    PanelAdmin pnlAdmin;
    PanelAbout pnlAbout;
    
    int biW = 160;
    int biH = 100;
    
//    String pathImg1 = "C:\\resources\\images\\reserve.jpg";
    ImageIcon icon1 = new ImageIcon(MainContent.class.getClassLoader().getResource("reserve.png"));
    Image image1 = icon1.getImage();
    Image new_image1 = image1.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgReserve = new ImageIcon(new_image1);
    
//    String pathImg2 = "C:\\resources\\images\\records.jpg";
    ImageIcon icon2 = new ImageIcon(MainContent.class.getClassLoader().getResource("records.png"));
    Image image2 = icon2.getImage();
    Image new_image2 = image2.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgRecords = new ImageIcon(new_image2);
    
//    String pathImg3 = "C:\\resources\\images\\admin.jpg";
    ImageIcon icon3 = new ImageIcon(MainContent.class.getClassLoader().getResource("admin.png"));
    Image image3 = icon3.getImage();
    Image new_image3 = image3.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgAdmin = new ImageIcon(new_image3);
    
//    String pathImg4 = "C:\\resources\\images\\about.jpg";
    ImageIcon icon4 = new ImageIcon(MainContent.class.getClassLoader().getResource("about.png"));
    Image image4 = icon4.getImage();
    Image new_image4 = image4.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgAbout = new ImageIcon(new_image4);

//    String pathImg5 = "C:\\resources\\images\\sign-out.jpg";
    ImageIcon icon5 = new ImageIcon(MainContent.class.getClassLoader().getResource("sign-out.png"));
    Image image5 = icon5.getImage();
    Image new_image5 = image5.getScaledInstance(biW, biH, java.awt.Image.SCALE_SMOOTH);
    Icon imgSignOut = new ImageIcon(new_image5);
    
    
    public MainContent() {    
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 800));

        JPanel pnlSidebar = new JPanel();
            pnlSidebar.setLayout(new GridLayout(5,0));
            pnlSidebar.setPreferredSize(new Dimension(150, 800));
            pnlSidebar.setBorder(new MatteBorder(0,0,0,5, Color.black));
            
            btnReserve = new JButton("RESERVE");
                btnReserve.setIcon(imgReserve);
                btnReserve.addActionListener(this);

            btnRecords = new JButton("RECORDS");
                btnRecords.setIcon(imgRecords);
                btnRecords.addActionListener(this);
            btnAdmin = new JButton("ADMIN");
                btnAdmin.setIcon(imgAdmin);
                btnAdmin.addActionListener(this);
            btnAbout = new JButton("ABOUT");
                btnAbout.setIcon(imgAbout);
                btnAbout.addActionListener(this);
            btnSignOut = new JButton("SIGN-OUT");
                btnSignOut.setIcon(imgSignOut);
                btnSignOut.addActionListener(this);

            pnlSidebar.add(btnReserve); 
            pnlSidebar.add(btnRecords); 
            pnlSidebar.add(btnAdmin);
            pnlSidebar.add(btnAbout); 
            pnlSidebar.add(btnSignOut);

            add(pnlSidebar, BorderLayout.WEST);
       
        int spW = 850;
        int spH = 600;
        
        pnlReserve = new PanelReserve();
            pnlReserve.setPreferredSize(new Dimension(spW, spH));
        pnlRecords = new PanelRecords();
            pnlRecords.setPreferredSize(new Dimension(spW, spH));
        pnlAdmin = new PanelAdmin();
            pnlAdmin.setPreferredSize(new Dimension(spW, spH));
        pnlAbout = new PanelAbout();
            pnlAbout.setPreferredSize(new Dimension(spW, spH));
    
        pnlReserve.setVisible(true);
        pnlRecords.setVisible(false);
        pnlAdmin.setVisible(false);
        pnlAbout.setVisible(false);

        
        add(pnlReserve, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReserve) {
            System.out.println("btn reserve");
            pnlReserve.setVisible(true);
            pnlRecords.setVisible(false);
            pnlAdmin.setVisible(false);
            pnlAbout.setVisible(false);
            
            Database.currentPanel = "Reservation Panel";
            StatusBar.lblCurrentPanel.setText("Accessing " + Database.currentPanel + "!          ");
            this.add(pnlReserve);
            
        }
        if (e.getSource() == btnRecords) {
            System.out.println("btn records");
            pnlReserve.setVisible(false);
            pnlRecords.setVisible(true);
            pnlAdmin.setVisible(false);
            pnlAbout.setVisible(false);
            
            Database.currentPanel = "Records Panel";
            StatusBar.lblCurrentPanel.setText("Accessing " + Database.currentPanel + "!          ");
            this.add(pnlRecords);
        }
        if (e.getSource() == btnAdmin) {
            System.out.println("btn admin");
            pnlReserve.setVisible(false);
            pnlRecords.setVisible(false);
            pnlAdmin.setVisible(true);
            pnlAbout.setVisible(false);
            
            Database.currentPanel = "Admin Panel";
            StatusBar.lblCurrentPanel.setText("Accessing " + Database.currentPanel + "!          ");
            this.add(pnlAdmin);
        }
        if (e.getSource() == btnAbout) {
            System.out.println("btn about");
            pnlReserve.setVisible(false);
            pnlRecords.setVisible(false);
            pnlAdmin.setVisible(false);
            pnlAbout.setVisible(true);
            
            Database.currentPanel = "About Panel";
            StatusBar.lblCurrentPanel.setText("Accessing " + Database.currentPanel + "!          ");
            this.add(pnlAbout);
        }
        if (e.getSource() == btnSignOut) {
//            System.out.println("btn sign-out");
            
            int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to sign-out??", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
            if(a==JOptionPane.YES_OPTION) {
                pnlReserve.setVisible(true);
                pnlRecords.setVisible(false);
                pnlAdmin.setVisible(false);
                pnlAbout.setVisible(false);
                
                this.add(pnlReserve);
                
                HotelReservationSystem.loginFrame.setVisible(true);
                HotelReservationSystem.frame.setVisible(false);
            }
        }
    }
}
