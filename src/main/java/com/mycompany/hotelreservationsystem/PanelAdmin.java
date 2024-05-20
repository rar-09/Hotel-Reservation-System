/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelAdmin extends JPanel implements ActionListener, ItemListener {
        
    
    JPanel pnlAdmin;
        public static JTable tblStaff;
        
    JPanel pnl1;
        JLabel lblUsername;
        JTextField tfUsername;
    JPanel pnl2;
        JLabel lblNewUsername;
        JTextField tfNewUsername;
    JPanel pnl3;
        JLabel lblPassword;
        JTextField tfPassword;
    JPanel pnl4;
        JComboBox cboPermission;
        JCheckBox chbUpdatePermission;
    JPanel pnl5;
        JButton btnRegister;
        JButton btnUpdate;
        JButton btnDelete;
        JButton btnClear;
    JPanel pnlReport;
        public static JTable tblReport;
    
    PanelAdmin() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(1,2));
        
        pnlAdmin = new JPanel();
            BoxLayout boxLayout3 = new BoxLayout(pnlAdmin, BoxLayout.Y_AXIS);
            pnlAdmin.setLayout(boxLayout3);
        
        tblStaff = new JTable(Database.tblStaffData, Database.columnNames3);  
        JScrollPane sp = new JScrollPane(tblStaff);
//            sp.setBackground(Database.LIGHTGRAY_1);

        pnl1 = new JPanel();
        pnl2 = new JPanel();
        pnl3 = new JPanel();
        pnl4 = new JPanel();
        pnl5 = new JPanel();

        lblUsername = new JLabel("Username: ");
        tfUsername = new JTextField();
            tfUsername.setPreferredSize(new Dimension(220, 30));
        lblNewUsername = new JLabel("New Username: ");
        tfNewUsername = new JTextField();
            tfNewUsername.setPreferredSize(new Dimension(220, 30));
        lblPassword = new JLabel("Password: ");
        tfPassword = new JTextField();
            tfPassword.setPreferredSize(new Dimension(220, 30));
        cboPermission = new JComboBox();
            cboPermission.addItem("staff");
            cboPermission.addItem("admin");
        chbUpdatePermission = new JCheckBox("Change Level of Access");
            chbUpdatePermission.addItemListener(this);
        btnRegister = new JButton("Register");
            btnRegister.addActionListener(this);
        btnUpdate = new JButton("Update");
            btnUpdate.addActionListener(this);
        btnDelete = new JButton("Delete");
            btnDelete.addActionListener(this);
        btnClear = new JButton("Clear");
            btnClear.addActionListener(this);
        
        pnl1.add(lblUsername);
        pnl1.add(tfUsername);
        pnl2.add(lblNewUsername);
        pnl2.add(tfNewUsername);
        pnl3.add(lblPassword);
        pnl3.add(tfPassword);
        pnl4.add(cboPermission);
        pnl4.add(chbUpdatePermission);
        pnl5.add(btnClear);
        pnl5.add(btnRegister);
        pnl5.add(btnUpdate);
        pnl5.add(btnDelete);
        
        pnlAdmin.add(sp);
        pnlAdmin.add(pnl1);
        pnlAdmin.add(pnl2);
        pnlAdmin.add(pnl3);
        pnlAdmin.add(pnl4);
        pnlAdmin.add(pnl5);
        
        pnlReport = new JPanel();
            BoxLayout boxLayout4 = new BoxLayout(pnlReport, BoxLayout.Y_AXIS);
            pnlReport.setLayout(boxLayout4);
        
        tblReport = new JTable(Database.tblReportData, Database.columnNames4);  
        JScrollPane sp2 = new JScrollPane(tblReport);
            sp2.setPreferredSize(new Dimension(400, 400));
//            sp.setBackground(Database.LIGHTGRAY_1);
        pnlReport.add(sp2);
        
        add(pnlAdmin);
        add(pnlReport);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        
        if (Database.currentPermission.equals("staff")) {
            JOptionPane.showMessageDialog(null, "Such operations are not allowed for a staff.");
        }
        else {
        if (e.getSource() == btnRegister) {
            System.out.println("Register");
            
            boolean usernameExists = false;
            
            for (int ctr = 0; ctr < Database.tblStaffData.length; ctr++ ) {
                if (!(Database.tblStaffData[ctr][0] == null)) {
                    if (Database.tblStaffData[ctr][0].equals(tfUsername.getText())) {
                        usernameExists = true;
                    }
                }
            }
            
            if (!usernameExists) {
                Database.tblStaffData[Database.numOfAccounts][0] = tfUsername.getText(); 
                        Database.tblStaffData[Database.numOfAccounts][1] = tfPassword.getText();
                        Database.tblStaffData[Database.numOfAccounts][2] = String.valueOf(cboPermission.getSelectedItem());

                        Database.numOfAccounts++;

                        Database.updateAdminTable();
                        clearInputs();
            }
            else {
                JOptionPane.showMessageDialog(null, "Username already exists.");
            }
            
            
        }
        else if (e.getSource() == btnUpdate) {
            System.out.println("Update");
            
            for (int ctr = 0; ctr < Database.tblStaffData.length; ctr++ ) {
                if (!(Database.tblStaffData[ctr][0] == null)) {
                    if (Database.tblStaffData[ctr][0].equals(tfUsername.getText())) {
                        String strNewUsername = Database.tblStaffData[ctr][0];
                        String strNewPassword = Database.tblStaffData[ctr][1];
                        if (!(tfNewUsername.getText().isEmpty())) {
                            strNewUsername = tfNewUsername.getText();
                        }
                        if (!(tfPassword.getText().isEmpty())) {
                            strNewPassword = tfPassword.getText();
                        }
                        
                        Database.tblStaffData[ctr][0] = strNewUsername;
                        Database.tblStaffData[ctr][1] = strNewPassword;
                        
                        if (chbUpdatePermission.isSelected()) {
                            if (Database.tblStaffData[ctr][2].equals("staff")) {
                                Database.tblStaffData[ctr][2] = "admin";
                            }
                            else if (Database.tblStaffData[ctr][2].equals("admin")) {
                                Database.tblStaffData[ctr][2] = "staff";
                            }
                        }
                        
                        Database.updateAdminTable();
                        clearInputs();
                    }
                }
            }
        }
        else if (e.getSource() == btnDelete) {
            boolean usernameExists = false;
            for (int ctr = 0; ctr < Database.tblStaffData.length; ctr++ ) {
                if (!(Database.tblStaffData[ctr][0] == null)) {
                    if (Database.tblStaffData[ctr][0].equals(tfUsername.getText())) {
                        Database.tblStaffData[ctr][0] = "";
                        Database.tblStaffData[ctr][1] = "";
                        Database.tblStaffData[ctr][2] = "";

                        Database.numOfAccounts--;
                        
                        for (int j = ctr; j < Database.tblStaffData.length - ctr; j++) {
                            Database.tblStaffData[j][0] = Database.tblStaffData[j+1][0];
                            Database.tblStaffData[j][1] = Database.tblStaffData[j+1][1];
                            Database.tblStaffData[j][2] = Database.tblStaffData[j+1][2];
                        }
                        
                        Database.updateAdminTable();
                        clearInputs();
                    }
                }
            }
            
            System.out.println("Delete");
        }
        }
        if (e.getSource() == btnClear) {
            clearInputs();
        }
    }
    
    

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void clearInputs() {
        tfUsername.setText("");
        tfNewUsername.setText("");
        tfPassword.setText("");
        cboPermission.setSelectedItem("staff");
        chbUpdatePermission.setSelected(false);
    }
}
