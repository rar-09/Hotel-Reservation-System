/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.hotelreservationsystem;

//import static com.mycompany.hotelreservationsystem.TitleBar.displayPanel;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class MainWindow extends JFrame {

        private JPanel panelMain;
        private TitleBar title;
        private MainContent mainContent;
        private StatusBar statusBar;
        
        

        public MainWindow() {
            setPreferredSize(new Dimension(1000, 600));
            setResizable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelMain = new JPanel(new BorderLayout());
            panelMain.setBackground(Color.WHITE);
                title = new TitleBar();
                panelMain.add(title, BorderLayout.NORTH);
                
                mainContent = new MainContent();
                panelMain.add(mainContent, BorderLayout.CENTER);
                
               
                statusBar = new StatusBar();
                panelMain.add(statusBar, BorderLayout.SOUTH);
                
            add(panelMain);

            pack();
        }

}