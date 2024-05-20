/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author RA
 */
public class loginLayout extends JPanel implements ActionListener{
        
        public static Color temp = Color.decode("#ee4b2b");
    
        JPanel panelMain; 
            
        JPanel panelLogo = new JPanel();
                JLabel lblLogo = new JLabel();
                ImageIcon logo = new ImageIcon(loginLayout.class.getClassLoader().getResource("logo_2.png"));
                Image loginLogo2 = logo.getImage();
                Image newLoginLogo2 = loginLogo2.getScaledInstance(390, 135, java.awt.Image.SCALE_SMOOTH);
                Icon imgLoginLogo = new ImageIcon(newLoginLogo2);
                
//        JPanel panelCenter = new JPanel(new GridLayout(2,1));
                JPanel panelWelcome = new JPanel();
                    JLabel welcome = new JLabel("WELCOME");
                   
            
//                JPanel panelInfo = new welcome.setForeground(Color.white);JPanel(new GridLayout(4,1));
        JPanel pnlUsername;
        JPanel pnlUsernameInput;
        JPanel pnlPassword;
        JPanel pnlPasswordInput;
        JPanel pnlBtn;
        
        JButton btnLogin;
        String username = "1";
        String password = "1";
                        
          JPasswordField tfPassword;               
          JTextField tfUsername;   
                
        JPanel panelBottom = new JPanel();
        
        
    loginLayout(){
        
        BoxLayout boxLayoutt = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayoutt);
        
        panelMain = new JPanel();
        
        panelLogo.setPreferredSize(new Dimension(400, 150));
        
        setSize(400,600);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
        
        panelWelcome.setPreferredSize(new Dimension(400, 45));
        
        lblLogo.setIcon(imgLoginLogo);
        panelLogo.add(lblLogo);
            
        
        panelWelcome.add(welcome);
        panelWelcome.setBackground(temp);
            welcome.setFont(new Font("Verdana", Font.BOLD, 18));
            welcome.setForeground(Color.white);
            
        pnlUsername = new JPanel();
            pnlUsername.setLayout(new FlowLayout(FlowLayout.LEFT));
            pnlUsername.setPreferredSize(new Dimension(350, 30));
            JLabel lblUsername = new JLabel("Username:");
            lblUsername.setFont(new Font("Verdana", Font.BOLD, 14));
            
            pnlUsername.add(lblUsername);
        pnlUsernameInput = new JPanel();
            pnlUsernameInput.setPreferredSize(new Dimension(400, 30));
                tfUsername = new JTextField();
                tfUsername.setPreferredSize(new Dimension(300, 30));
            
            pnlUsernameInput.add(tfUsername);
        pnlPassword = new JPanel();
              pnlPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
            pnlPassword.setPreferredSize(new Dimension(350, 30));
            JLabel lblPassword = new JLabel("Password:");
            lblPassword.setFont(new Font("Verdana", Font.BOLD, 14));
            
            pnlPassword.add(lblPassword);
        pnlPasswordInput = new JPanel();
            pnlPasswordInput.setPreferredSize(new Dimension(400, 30));
                tfPassword = new JPasswordField();
                tfPassword.setEchoChar('*');
                tfPassword.setPreferredSize(new Dimension(300, 40));
            
            pnlPasswordInput.add(tfPassword);
            
        pnlBtn = new JPanel();
            btnLogin = new JButton("Login");
            btnLogin.setFont(new Font("Verdana", Font.BOLD, 14));
            btnLogin.setForeground(Color.white);
            btnLogin.setBackground(Color.DARK_GRAY);
            btnLogin.setPreferredSize(new Dimension(100,40));
            pnlBtn.setPreferredSize(new Dimension(400, 50));
            pnlBtn.add(btnLogin);
            
            btnLogin.addActionListener(this);
            tfUsername.addActionListener(this);
            tfPassword.addActionListener(this);
            
        add(panelMain);
        panelMain.add(panelLogo);
         panelMain.add(panelWelcome);
//         panelCenter.add(panelWelcome);
//         panelCenter.add(panelInfo);
        panelMain.add(pnlUsername);
        panelMain.add(pnlUsernameInput);
        panelMain.add(pnlPassword);
        panelMain.add(pnlPasswordInput);
          panelMain.add(panelBottom);
        panelMain.add(pnlBtn);
        
        add(panelMain);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin){
            boolean usernameDoesntExist = true;
            for (int ctr = 0; ctr < Database.tblStaffData.length; ctr++ ) {
                if(tfUsername.getText().equals(Database.tblStaffData[ctr][0])){
                    usernameDoesntExist = false;
                    if (tfPassword.getText().equals(Database.tblStaffData[ctr][1])) {
                        Database.numOfAttempts = 0;
                        
                        tfUsername.setText("");
                        tfPassword.setText("");
                        
                        Database.currentUser = Database.tblStaffData[ctr][0];
                        Database.currentPermission = Database.tblStaffData[ctr][2];
                        
                        HotelReservationSystem.loginFrame.setVisible(false);
                        HotelReservationSystem.frame.setVisible(true);
                        
                        StatusBar.lblCurrentUser.setText("Hi, " + Database.currentUser + ".");
                    }
                    else {
                        tfUsername.setText("");
                        tfPassword.setText("");
                        Database.numOfAttempts += 1;
                        
                        JOptionPane.showMessageDialog(this, "Incorrect Password");
                        if (Database.numOfAttempts >= 3) 
                            System.exit(0);
                        break;
                    }
                }
            }
            if (usernameDoesntExist) {
                tfUsername.setText("");
                    tfPassword.setText("");
                    Database.numOfAttempts += 1;
                    
                    JOptionPane.showMessageDialog(this, "Username Not Found");
                    if (Database.numOfAttempts >= 3) 
                        System.exit(0);
            }
            
        }
    }
}
