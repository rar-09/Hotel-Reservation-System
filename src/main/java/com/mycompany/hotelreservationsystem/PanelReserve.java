/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.border.*;

public class PanelReserve extends JPanel implements ActionListener, ItemListener {
//    Database db = new Database();
    
    boolean rdoIsSelected = false;
    boolean rdoPaymentIsSelected = false;
    
    JPanel pnlReserve, pnlReserveInfo;
    
    JPanel pnlTitle;
        JLabel lblTitle;
    JPanel pnlName;
        JLabel lblName;
        JTextField tfName;
        JLabel lblNumOfDays;
        JTextField tfNumOfDays;
    JPanel pnlClass;
        JLabel lblClass;
    JPanel pnlClass1;
        JRadioButton rdoTourist;
        JRadioButton rdoDeluxe;
        JRadioButton rdoAmbassador;
    JPanel pnlClass2;
        JRadioButton rdoCorporate;
        JRadioButton rdoAnnex5;
        JRadioButton rdoAnnex3; 
    JPanel pnlPayment;
        JLabel lblPayment;
    JPanel pnlPayment1;
        JRadioButton rdoFullPayment;
        JRadioButton rdoHalfPayment;
        JCheckBox chbSenior;
        JCheckBox chbPWD;
    
    JPanel pnlButtons;
        JButton btnClear;
        JButton btnReserve;
        JButton btnCheckIn;
    
        
    ButtonGroup grpClass = new ButtonGroup();
    ButtonGroup grpPayment = new ButtonGroup();
    
    PanelReserve() {
//        setLayout(new BorderLayout());
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        setBackground(Color.WHITE);
        
        /*****  RESERVE INFORMATION - START *****/
        pnlReserve = new JPanel();          
            
        
        pnlTitle = new JPanel();
            pnlTitle.setPreferredSize(new Dimension(850, 50));
            pnlTitle.setBackground(Database.RED_1);
            pnlTitle.setBorder(new MatteBorder(0,0,1,0, Color.black));
            
            lblTitle = new JLabel("Reservation / Check-In Form");
                lblTitle.setFont(Database.fontCG_0);
                lblTitle.setForeground(Color.WHITE);
            pnlTitle.add(lblTitle);
        
        pnlName = new JPanel();
            pnlName.setPreferredSize(new Dimension(850, 50));
            lblName = new JLabel("Name: ");  
            tfName = new JTextField();
                tfName.setPreferredSize(new Dimension(300, 30));
            lblNumOfDays = new JLabel("No. of Days: ");
            tfNumOfDays = new JTextField();
                tfNumOfDays.setPreferredSize(new Dimension(150, 30));
            
            pnlName.add(lblName);
            pnlName.add(tfName);
            pnlName.add(lblNumOfDays);
            pnlName.add(tfNumOfDays);

        pnlClass = new JPanel();
            pnlClass.setPreferredSize(new Dimension(850, 30));
            lblClass = new JLabel("Room Class:");
                lblClass.setAlignmentX(Component.CENTER_ALIGNMENT);
            pnlClass.add(lblClass);
        
        pnlClass1 = new JPanel();
            rdoTourist = new JRadioButton("Tourist Class");
            rdoDeluxe = new JRadioButton("Deluxe Class");
            rdoAmbassador = new JRadioButton("Ambassador Class");
            
            pnlClass1.add(rdoTourist);
            pnlClass1.add(rdoDeluxe);
            pnlClass1.add(rdoAmbassador);
            

        pnlClass2 = new JPanel();
            rdoCorporate = new JRadioButton("Corporate Class");
            rdoAnnex5 = new JRadioButton("Annex Room (Good for 5)");
            rdoAnnex3 = new JRadioButton("Annex Room (Good for 3)");
            
            pnlClass2.add(rdoCorporate);
            pnlClass2.add(rdoAnnex5);
            pnlClass2.add(rdoAnnex3);
            
        pnlPayment = new JPanel();
            pnlPayment.setPreferredSize(new Dimension(850, 30));
            lblPayment = new JLabel("Payment");
            
            pnlPayment.add(lblPayment);
            
        pnlPayment1 = new JPanel();
            pnlPayment1.setPreferredSize(new Dimension(850, 50));
            rdoFullPayment = new JRadioButton("Full Payment");
                rdoFullPayment.addItemListener(this);
            rdoHalfPayment = new JRadioButton("Half Payment");
                rdoHalfPayment.addItemListener(this);
            chbSenior = new JCheckBox("Senior Citizen");
            chbPWD = new JCheckBox("PWD");
            
            pnlPayment1.add(rdoFullPayment);
            pnlPayment1.add(rdoHalfPayment);
            
            pnlPayment1.add(chbSenior);
            pnlPayment1.add(chbPWD);
            
            
        pnlButtons = new JPanel();
            pnlButtons.setPreferredSize(new Dimension(850, 50));
            btnClear = new JButton("Clear");
                btnClear.addActionListener(this);
            btnReserve = new JButton("Reserve");
                btnReserve.addActionListener(this);
            btnCheckIn = new JButton("Check-In");
                btnCheckIn.addActionListener(this);
            
            pnlButtons.add(btnClear);
            pnlButtons.add(btnReserve);
            pnlButtons.add(btnCheckIn);
        

        pnlReserve.add(pnlTitle);
        pnlReserve.add(pnlName);
        pnlReserve.add(pnlClass);
        pnlReserve.add(pnlClass1);
        pnlReserve.add(pnlClass2);
        pnlReserve.add(pnlPayment);
        pnlReserve.add(pnlPayment1);
        pnlReserve.add(pnlButtons);

        rdoTourist.addItemListener(this);
        rdoDeluxe.addItemListener(this);
        rdoAmbassador.addItemListener(this);
        rdoCorporate.addItemListener(this);
        rdoAnnex5.addItemListener(this);
        rdoAnnex3.addItemListener(this);
        
        grpClass.add(rdoTourist);
        grpClass.add(rdoDeluxe);
        grpClass.add(rdoAmbassador);
        grpClass.add(rdoCorporate);
        grpClass.add(rdoAnnex5);
        grpClass.add(rdoAnnex3);
        
        grpPayment.add(rdoFullPayment);
        grpPayment.add(rdoHalfPayment);
        
        updateComponentFonts();
        
        add(pnlReserve);

        /*****  RESERVE CHECKOUT - START *****/
//        pnlReserveInfo = new JPanel();
//            pnlReserveInfo.setBackground(Database.LIGHTGRAY_1);
//            pnlReserveInfo.setPreferredSize(new Dimension(850, 50));
        
//        add(pnlReserveInfo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReserve) {
            String getName = tfName.getText();
            String getDays = tfNumOfDays.getText();
            if (getName.trim().isEmpty() || getDays.trim().isEmpty()) {
                System.out.println("Empty");
                
                JOptionPane.showMessageDialog(null, "Please fill out the text fields.");
            }
            else {
                if (rdoIsSelected && rdoPaymentIsSelected) {
                    System.out.println("reserve");
                    if (rdoTourist.isSelected()) {
                        if (Database.roomStatus[0].equals("Occupied")) {          
                            JOptionPane.showMessageDialog(null, "Room already occupied");
                        }
                        else if (Database.roomStatus[0].equals("Reserved")) {
                            JOptionPane.showMessageDialog(null, "Room already reserved");
                        }
                        else {
                            int i = 0;
                            System.out.println(Database.roomStatus[i]);
                            System.out.println(Database.roomStatus[i]);
                            
                            
                            Database.names[i] = tfName.getText().trim();
                            Database.days[i] = Integer.parseInt(tfNumOfDays.getText().trim());
                            
                            payReservation(i, Database.receiptTourist);
                            Database.roomStatus[i] = "Reserved";
                            JOptionPane.showMessageDialog(null, "Room has been reserved.");
                            clearInputs();
                        }
                    }
                    else if (rdoDeluxe.isSelected()) {
                        if (Database.roomStatus[1].equals("Occupied")) {          
                            JOptionPane.showMessageDialog(null, "Room already occupied");
                        }
                        else if (Database.roomStatus[1].equals("Reserved")) {
                            JOptionPane.showMessageDialog(null, "Room already reserved");
                        }
                        else {
                            int i = 1;
                            System.out.println(Database.roomStatus[i]);
                            System.out.println(Database.roomStatus[i]);
                            
                            
                            Database.names[i] = tfName.getText().trim();
                            Database.days[i] = Integer.parseInt(tfNumOfDays.getText().trim());
                           
                            payReservation(i, Database.receiptDeluxe);
                            Database.roomStatus[i] = "Reserved";
                            JOptionPane.showMessageDialog(null, "Room has been reserved.");
                            clearInputs();
                        }
                    }
                    else if (rdoAmbassador.isSelected()) {
                        if (Database.roomStatus[2].equals("Occupied")) {          
                            JOptionPane.showMessageDialog(null, "Room already occupied");
                        }
                        else if (Database.roomStatus[2].equals("Reserved")) {
                            JOptionPane.showMessageDialog(null, "Room already reserved");
                        }
                        else {
                            int i = 2;
                            System.out.println(Database.roomStatus[i]);
                            System.out.println(Database.roomStatus[i]);
                            
                            
                            Database.names[i] = tfName.getText().trim();
                            Database.days[i] = Integer.parseInt(tfNumOfDays.getText().trim());
                            Database.roomStatus[i] = "Reserved";
                            
                            payReservation(i, Database.receiptAmbassador);
                            JOptionPane.showMessageDialog(null, "Room has been reserved.");
                            clearInputs();
                        }
                    }
                    else if (rdoCorporate.isSelected()) {
                        if (Database.roomStatus[3].equals("Occupied")) {          
                            JOptionPane.showMessageDialog(null, "Room already occupied");
                        }
                        else if (Database.roomStatus[3].equals("Reserved")) {
                            JOptionPane.showMessageDialog(null, "Room already reserved");
                        }
                        else {
                            int i = 3;
                            System.out.println(Database.roomStatus[i]);
                            System.out.println(Database.roomStatus[i]);
                            
                            
                            Database.names[i] = tfName.getText().trim();
                            Database.days[i] = Integer.parseInt(tfNumOfDays.getText().trim());
                            
                            payReservation(i, Database.receiptCorporate);
                            Database.roomStatus[i] = "Reserved";
                            JOptionPane.showMessageDialog(null, "Room has been reserved.");
                            clearInputs();
                        }
                    }
                    else if (rdoAnnex5.isSelected()) {
                        if (Database.roomStatus[4].equals("Occupied")) {          
                            JOptionPane.showMessageDialog(null, "Room already occupied");
                        }
                        else if (Database.roomStatus[4].equals("Reserved")) {
                            JOptionPane.showMessageDialog(null, "Room already reserved");
                        }
                        else {
                            int i = 4;
                            System.out.println(Database.roomStatus[i]);
                            System.out.println(Database.roomStatus[i]);
                            
                            
                            Database.names[i] = tfName.getText().trim();
                            Database.days[i] = Integer.parseInt(tfNumOfDays.getText().trim());
                            Database.roomStatus[i] = "Reserved";
                            
                            payReservation(i, Database.receiptAnnex5);
                            JOptionPane.showMessageDialog(null, "Room has been reserved.");
                            clearInputs();
                        }
                    }
                    else if (rdoAnnex3.isSelected()) {
                        if (Database.roomStatus[5].equals("Occupied")) {          
                            JOptionPane.showMessageDialog(null, "Room already occupied");
                        }
                        else if (Database.roomStatus[5].equals("Reserved")) {
                            JOptionPane.showMessageDialog(null, "Room already reserved");
                        }
                        else {
                            int i = 5;
                            System.out.println(Database.roomStatus[i]);
                            System.out.println(Database.roomStatus[i]);
                            
                            
                            Database.names[i] = tfName.getText().trim();
                            Database.days[i] = Integer.parseInt(tfNumOfDays.getText().trim());
                            
                            payReservation(i, Database.receiptAnnex3);
                            Database.roomStatus[i] = "Reserved";
                            JOptionPane.showMessageDialog(null, "Room has been reserved.");
                            clearInputs();
                        }
                    }
                    Database.updateRecordsTable();
                } // END - if (rdoIsSelected)
                else {
                    JOptionPane.showMessageDialog(null, "Please select class and payment options.");
                }
            } // END - if - else - check if name / days is empty
        } // END - btnReserve
        else if (e.getSource() == btnCheckIn) {
            if (rdoIsSelected) {
                if (rdoTourist.isSelected()) {
                    int i = 0;
                    if (Database.roomStatus[i].equals("Occupied")) {          
                        JOptionPane.showMessageDialog(null, "Room already occupied.");
                    }
                    else if (Database.roomStatus[i].equals("Not Occupied")) {
                        JOptionPane.showMessageDialog(null, "Room not reserved. Please make a reservation.");
                    }
                    else {
                        processCheckIn(i);
                    }
                }
                else if (rdoDeluxe.isSelected()) {
                    int i = 1;
                    if (Database.roomStatus[i].equals("Occupied")) {          
                        JOptionPane.showMessageDialog(null, "Room already occupied.");
                    }
                    else if (Database.roomStatus[i].equals("Not Occupied")) {
                        JOptionPane.showMessageDialog(null, "Room not reserved. Please make a reservation.");
                    }
                    else {
                        processCheckIn(i);
                    }
                }
                else if (rdoAmbassador.isSelected()) {
                    int i = 2;
                    if (Database.roomStatus[i].equals("Occupied")) {          
                        JOptionPane.showMessageDialog(null, "Room already occupied.");
                    }
                    else if (Database.roomStatus[i].equals("Not Occupied")) {
                        JOptionPane.showMessageDialog(null, "Room not reserved. Please make a reservation.");
                    }
                    else {
                        processCheckIn(i);
                    }
                }
                else if (rdoCorporate.isSelected()) {
                    int i = 3;
                    if (Database.roomStatus[i].equals("Occupied")) {          
                        JOptionPane.showMessageDialog(null, "Room already occupied.");
                    }
                    else if (Database.roomStatus[i].equals("Not Occupied")) {
                        JOptionPane.showMessageDialog(null, "Room not reserved. Please make a reservation.");
                    }
                    else {
                        processCheckIn(i);
                    }
                }
                else if (rdoAnnex5.isSelected()) {
                    int i = 4;
                    if (Database.roomStatus[i].equals("Occupied")) {          
                        JOptionPane.showMessageDialog(null, "Room already occupied.");
                    }
                    else if (Database.roomStatus[i].equals("Not Occupied")) {
                        JOptionPane.showMessageDialog(null, "Room not reserved. Please make a reservation.");
                    }
                    else {
                        processCheckIn(i);
                    }
                }
                else if (rdoAnnex3.isSelected()) {
                    int i = 5;
                    if (Database.roomStatus[i].equals("Occupied")) {          
                        JOptionPane.showMessageDialog(null, "Room already occupied.");
                    }
                    else if (Database.roomStatus[i].equals("Not Occupied")) {
                        JOptionPane.showMessageDialog(null, "Room not reserved. Please make a reservation.");
                    }
                    else {
                        processCheckIn(i);
                    }
                }
                else {
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please select a class.");
            }
        } // END - btnCheckIn
        else if (e.getSource() == btnClear) {
            clearInputs();
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (rdoTourist.isSelected() || rdoDeluxe.isSelected() || rdoAmbassador.isSelected() || 
                rdoCorporate.isSelected() || rdoAnnex5.isSelected() || rdoAnnex3.isSelected()) {
            rdoIsSelected = true;
        } else {
            rdoIsSelected = false;
        }
        
        if (rdoFullPayment.isSelected() || rdoHalfPayment.isSelected()) {
            rdoPaymentIsSelected = true;
        } else {
            rdoPaymentIsSelected = false;
        }
    }
    
    private void updateComponentFonts() {
        Database.labels.add(lblName);
        Database.labels.add(lblNumOfDays);
        Database.labels.add(lblClass);
        Database.labels.add(lblPayment);
        
        for (JLabel label : Database.labels) {
            label.setFont(Database.fontCG_1);
        }
        lblClass.setFont(Database.fontCG_2);
        lblPayment.setFont(Database.fontCG_2);
        
        Database.textfields.add(tfName);
        Database.textfields.add(tfNumOfDays);
        
        for (JTextField textfield : Database.textfields) {
            textfield.setFont(Database.fontCG_1);
        }
        
        Database.radiobuttons.add(rdoTourist);
        Database.radiobuttons.add(rdoDeluxe);
        Database.radiobuttons.add(rdoAmbassador);
        Database.radiobuttons.add(rdoCorporate);
        Database.radiobuttons.add(rdoAnnex5);
        Database.radiobuttons.add(rdoAnnex3);
        Database.radiobuttons.add(rdoFullPayment);
        Database.radiobuttons.add(rdoHalfPayment);
        
        for (JRadioButton radiobutton : Database.radiobuttons) {
            radiobutton.setFont(Database.fontCG_1);
        }
        
        chbSenior.setFont(Database.fontCG_1);
        chbPWD.setFont(Database.fontCG_1);
    }
    
    private void payReservation(int i, Object[] receiptArray) {
        if (rdoFullPayment.isSelected()) {
             Database.paymentTypes[i] = "Full Payment";
        }
        else if (rdoHalfPayment.isSelected()) {
             Database.paymentTypes[i] = "Half Payment";
        }
        
        if (chbSenior.isSelected()) {
             Database.seniorDiscounts[i] = true;
        }
        if (chbPWD.isSelected()) {
             Database.pwdDiscounts[i] = true;
        }
                                    
        if (Database.paymentTypes[i].equals("Full Payment")) {
             double price = Double.valueOf(Database.days[i]) * Database.promoPrices[i];
             long creditCard;
             creditCard = Integer.parseInt(JOptionPane.showInputDialog("You chose " + 
                  Database.paymentTypes[i] + ".\nThe price is " + 
                  String.valueOf(price) + 
                  ".\nPlease input your credit card *numbers*: "));
             receiptArray[0] = Database.names[i];
             receiptArray[1] = Database.paymentTypes[i];
             receiptArray[2] = Database.days[i];
             receiptArray[3] = price;
             
             double discountedPrice = price;
             if (Database.seniorDiscounts[i] && Database.pwdDiscounts[i]) {
                 receiptArray[4] = price - (price * 0.2);
                 receiptArray[5] = price - (price * 0.1);
                 
                 discountedPrice = price - (price * 0.3);
             }
             else {
                 if (Database.seniorDiscounts[i]) {
                     discountedPrice = price - (price * 0.2);
                     receiptArray[4] = price - (price * 0.2);
                     receiptArray[5] = price - (price * 0.2);
                 }
                 if (Database.pwdDiscounts[i]) {
                     discountedPrice = price - (price * 0.1);
                     receiptArray[4] = price - (price * 0.1);
                     receiptArray[5] = price - (price * 0.1);
                 }
             }
             
             // ADD VAT
             double taxedPrice = discountedPrice + (discountedPrice * 0.12);
             receiptArray[6] = taxedPrice;
             
             receiptArray[7] = taxedPrice;
             
             Database.balances[i] += taxedPrice;
                                        
             JOptionPane.showMessageDialog(null, "You paid with " + String.valueOf(creditCard) + ".");
        }
        else if (Database.paymentTypes[i].equals("Half Payment")) {
             receiptArray[0] = Database.names[i];
             receiptArray[1] = Database.paymentTypes[i];
             receiptArray[2] = Database.days[i];
            
             double price = Double.valueOf(Database.days[i]) * Database.fullPrices[i];
             System.out.println(price);
             receiptArray[3] = price;
             receiptArray[4] = price;
             receiptArray[5] = price;
             
             // DEDUCT DISCOUNTS
             
             double discountedPrice = price;
             if (Database.seniorDiscounts[i] && Database.pwdDiscounts[i]) {
                 receiptArray[4] = price - (price * 0.2);
                 receiptArray[5] = price - (price * 0.1);
                 
                 discountedPrice = price - (price * 0.3);
             }
             else {
                 if (Database.seniorDiscounts[i]) {
                     discountedPrice = price - (price * 0.2);
                     receiptArray[4] = price - (price * 0.2);
                     receiptArray[5] = price - (price * 0.2);
                 }
                 if (Database.pwdDiscounts[i]) {
                     discountedPrice = price - (price * 0.1);
                     receiptArray[4] = price - (price * 0.1);
                     receiptArray[5] = price - (price * 0.1);
                 }
             }
             
             // ADD VAT
             double taxedPrice = discountedPrice + (discountedPrice * 0.12);
             receiptArray[6] = taxedPrice;
             
             double paidPrice = taxedPrice / 2;
             double balancedPrice = taxedPrice / 2;
             Database.pendings[i] = balancedPrice;
             receiptArray[7] = taxedPrice;
             
             // ASK FOR CREDIT CARD
             long creditCard;
             creditCard = Integer.parseInt(JOptionPane.showInputDialog("You chose " + 
                  Database.paymentTypes[i] + ".\nThe price is " + 
                  String.valueOf(price) + 
                  ".\nPlease input your credit card *numbers*: "));
                                        
             Database.balances[i] += balancedPrice;
                                        
             Database.updateRecordsTable();
        }
    }
    
    public void processCheckIn(int i) {
        Database.checkInDates[i] = Database.getStrCurrentDate();
        Database.checkOutDatesSched[i] = Database.getStrDateAfterNDays(Database.checkInDates[i], Database.days[i]);
        PanelRecords.lblCheckInDate.setText("Checked-In Date: " + Database.checkInDates[i]);
        Database.roomStatus[i] = "Occupied";
        PanelRecords.lblRoomStatus.setText(Database.roomStatus[i]);
        
        JOptionPane.showMessageDialog(null, "You have checked-in.");
        Database.updateRecordsTable();
    }
    
    private void clearInputs() {
        tfName.setText("");
        tfNumOfDays.setText("");
        grpClass.clearSelection();
        grpPayment.clearSelection();
        chbSenior.setSelected(false);
        chbPWD.setSelected(false);
        
        PanelRecords.cboClass.setSelectedIndex(0);
        PanelRecords.lblRoomStatus.setText("Room Status: " + Database.roomStatus[0]);
    }
}
