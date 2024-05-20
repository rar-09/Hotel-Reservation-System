/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
//import javax.swing.border.*;

public class TitleBar extends JPanel
{

        public TitleBar()
        {
            setPreferredSize(new Dimension(1000, 60));

            ImageIcon icon1 = new ImageIcon(TitleBar.class.getClassLoader().getResource("logo_1.png"));
//                Border blackBorder = BorderFactory.createLineBorder(Color.black);
            setBorder(new MatteBorder(0,0,5,0, Color.black));
            
            Image image1 = icon1.getImage();
            Image new_image1 = image1.getScaledInstance(400, 30, java.awt.Image.SCALE_SMOOTH);
            Icon favIcon = new ImageIcon(new_image1);
     
            JPanel panel = new JPanel();

            JLabel lblTitle = new JLabel();
            lblTitle.setIcon(favIcon);
            lblTitle.setBackground(Color.white);

            panel.add(lblTitle);      
            
            add(panel);
        }
}