/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;


public class StatusBar extends JPanel implements ActionListener {
    JLabel lblCurrentDate;
    public static JLabel lblCurrentUser;
    public static JLabel lblCurrentPanel;
    
    StatusBar() {
        setPreferredSize(new Dimension(1000, 20));
        setBackground(Color.BLACK);
        
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        lblCurrentDate = new JLabel();
            lblCurrentDate.setForeground(Color.WHITE);
            
        lblCurrentUser = new JLabel();
            lblCurrentUser.setText("Hi, " + Database.currentUser + ".        ");
            lblCurrentUser.setForeground(Color.WHITE);
            
        lblCurrentPanel = new JLabel();
            lblCurrentPanel.setText("Accessing " + Database.currentPanel + "!          ");
            lblCurrentPanel.setForeground(Color.WHITE);
       
        String date1 = Database.getStrCurrentDate();
                

        Timer SimpleTimer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
    //            System.out.print("Current date: "+str);
                lblCurrentDate.setText("It's currently " + Database.getStrCurrentDate());
                
            }
        });
        SimpleTimer.start();
        
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        String date2 = "2023/05/19";
//
//        LocalDate d1 = LocalDate.parse(date1,dtf);
//        LocalDate d2 = LocalDate.parse(date2,dtf);
//
//        long ndays = d1.datesUntil(d2).count();
//        System.out.println(ndays);
        
        
        add(lblCurrentDate);
        add(lblCurrentUser);
        add(lblCurrentPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
