/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author RA
 */
public class loginWindow extends JFrame {
    private JPanel panelMain;
    private loginLayout loginlayout;
    
    public loginWindow() {
        setPreferredSize(new Dimension(400, 500));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panelMain = new JPanel(new BorderLayout());
//        panelMain.setBackground(Color.BLACK);
            loginlayout = new loginLayout();
            panelMain.add(loginlayout);
        
        add(panelMain);
        
        pack();
        
    }
}