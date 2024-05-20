/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class PanelRecords extends JPanel implements ActionListener, ItemListener {
    Database db = new Database();
    
    String currentSelectedClass = "Tourist Class";
    
    public static String[] columnNames = {"Status", "Class", "Name", "Days", "Balance"};
    public static String tblData[][];
    
    public static String[] columnNames2 = {"Tourist Class", "Qty", "Cost"};
    public static String tblPerClassData[][];
    
    JPanel pnlLeft, pnlRight;
    
    JPanel pnlClass;
        public static JComboBox cboClass;
        public static JLabel lblRoomStatus;
    JLabel lblAdtlOptions;
    JPanel pnlAdtlOptions1;
        JLabel lblExtraBed;
        JComboBox cboExtraBed;
        JLabel lblPillow;
        JComboBox cboPillow;
        JLabel lblTowel;
        JComboBox cboTowel;
    JPanel pnlAdtlOptions2;
        JLabel lblReadingLight;
        JComboBox cboReadingLight;
        JLabel lblBooks;
        JComboBox cboBooks;
        JLabel lblToiletries;
        JComboBox cboToiletries;
    JPanel pnlAdtlOptions3;
        JLabel lblLuggageRack;
        JComboBox cboLuggageRack;
    JLabel lblFood;
        JComboBox cboBreakfast;
        JLabel lblBreakfast;
        JComboBox cboLunch;
        JLabel lblLunch;
        JComboBox cboDinner;
        JLabel lblDinner;
    JPanel pnlFood1;
    JPanel pnlFood2;
        JComboBox cboDrink;
        JLabel lblDrink;
        JComboBox cboSnack;
        JLabel lblSnack;
    JLabel lblDiscount;
    JPanel pnlDiscount;
        JCheckBox chbSenior;
        JCheckBox chbPWD;
    JPanel pnlButtons;
        JButton btnClear;
        JButton btnAdd;
        JButton btnCheckOut;
    
    public static JTable tbl;
    JPanel pnlDateTime;
        public static JLabel lblCheckInDate;
        public static JLabel lblDaysLeft;
        public static JLabel lblStayingStatus;
    public static JTable tblPerClass;
       
    PanelRecords() {
//        setBackground(Color.WHITE);
        setLayout(new GridLayout(1, 2));
        
        /***** LEFT PANEL *****/
        
        pnlLeft = new JPanel();
        pnlLeft.setBackground(Color.WHITE);
            BoxLayout boxLayout = new BoxLayout(pnlLeft, BoxLayout.Y_AXIS);
            pnlLeft.setLayout(boxLayout);
            
        pnlClass = new JPanel();
            cboClass = new JComboBox(Database.classTypes);
                cboClass.addItemListener(this);
                 
            lblRoomStatus = new JLabel("Room Status: " + Database.roomStatus[0]);
            
            pnlClass.add(cboClass);
            pnlClass.add(lblRoomStatus);
            
        pnlLeft.add(pnlClass);
            
        lblAdtlOptions = new JLabel("Additional Options");
            lblAdtlOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
         
        pnlAdtlOptions1 = new JPanel();
            pnlAdtlOptions1.setBackground(Color.WHITE);
            lblExtraBed = new JLabel("Extra Bed: ");
            cboExtraBed = new JComboBox();
            lblPillow = new JLabel("Pillow: ");
            cboPillow = new JComboBox();
            lblTowel = new JLabel("Towel: ");
            cboTowel = new JComboBox();
            
            pnlAdtlOptions1.add(lblExtraBed);
            pnlAdtlOptions1.add(cboExtraBed);
            pnlAdtlOptions1.add(lblPillow);
            pnlAdtlOptions1.add(cboPillow);
            pnlAdtlOptions1.add(lblTowel);
            pnlAdtlOptions1.add(cboTowel);
            
        pnlAdtlOptions2 = new JPanel();
            pnlAdtlOptions2.setBackground(Color.WHITE);
            lblReadingLight = new JLabel("Reading light: ");
            cboReadingLight = new JComboBox();
            lblBooks = new JLabel("Books/Magazines: ");
            cboBooks = new JComboBox();
            
            pnlAdtlOptions2.add(lblReadingLight);
            pnlAdtlOptions2.add(cboReadingLight);
            pnlAdtlOptions2.add(lblBooks);
            pnlAdtlOptions2.add(cboBooks);
        
        pnlAdtlOptions3 = new JPanel();
            pnlAdtlOptions3.setBackground(Color.WHITE);
            lblLuggageRack = new JLabel("Luggage Rack: ");
            cboLuggageRack = new JComboBox();
            lblToiletries = new JLabel("Toiletries: ");
            cboToiletries = new JComboBox();
            
            pnlAdtlOptions3.add(lblToiletries);
            pnlAdtlOptions3.add(cboToiletries);
            pnlAdtlOptions3.add(lblLuggageRack);
            pnlAdtlOptions3.add(cboLuggageRack);
        
        for (int i = 0; i <= 366; i++) {
            cboExtraBed.addItem(i);
            cboPillow.addItem(i);
            cboTowel.addItem(i);
            cboReadingLight.addItem(i);
            cboBooks.addItem(i);
            cboToiletries.addItem(i);
            cboLuggageRack.addItem(i);
        }
        
        lblFood = new JLabel("Food: per serving");
            lblFood.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        pnlFood1 = new JPanel();
            pnlFood1.setBackground(Color.WHITE);
            lblBreakfast = new JLabel("Breakfast");
            cboBreakfast = new JComboBox();
            lblLunch = new JLabel("Lunch");
            cboLunch = new JComboBox();
            lblDinner = new JLabel("Dinner");
            cboDinner = new JComboBox();
            
        pnlFood2 = new JPanel();
            pnlFood2.setBackground(Color.WHITE);
            lblDrink = new JLabel("Drink");
            cboDrink = new JComboBox();
            lblSnack = new JLabel("Snack");
            cboSnack = new JComboBox();
            
            pnlFood1.add(lblBreakfast);
            pnlFood1.add(cboBreakfast);
            pnlFood1.add(lblLunch);
            pnlFood1.add(cboLunch);
            pnlFood1.add(lblDinner);
            pnlFood1.add(cboDinner);
            pnlFood2.add(lblDrink);
            pnlFood2.add(cboDrink);
            pnlFood2.add(lblSnack);
            pnlFood2.add(cboSnack);
            
        for (int i = 0; i <= 366; i++) {
            cboBreakfast.addItem(i);
            cboLunch.addItem(i);
            cboDinner.addItem(i);
            cboDrink.addItem(i);
            cboSnack.addItem(i);
        }
        
        lblDiscount = new JLabel(""); // Discount
            lblDiscount.setAlignmentX(Component.CENTER_ALIGNMENT);
//            lblDiscount.setVisible(false);
        pnlDiscount = new JPanel();
            pnlDiscount.setBackground(Color.WHITE);
            chbSenior = new JCheckBox("Senior Citizen");
                chbSenior.setVisible(false);
                chbSenior.setBackground(Color.WHITE);
            chbPWD = new JCheckBox("PWD");
                chbPWD.setVisible(false);
                chbPWD.setBackground(Color.WHITE);
            
            pnlDiscount.add(chbSenior);
            pnlDiscount.add(chbPWD);
            
        pnlButtons = new JPanel();
            pnlButtons.setBackground(Color.WHITE);
            btnClear = new JButton("Clear");
                btnClear.addActionListener(this);
            btnAdd = new JButton("Add to Bill");
                btnAdd.addActionListener(this);
            btnCheckOut = new JButton("Checkout");
                btnCheckOut.addActionListener(this);
            
            pnlButtons.add(btnClear);
            pnlButtons.add(btnAdd);
            pnlButtons.add(btnCheckOut);
        
        updateComponentFonts();
        
        pnlLeft.add(lblAdtlOptions);
        pnlLeft.add(pnlAdtlOptions1);
        pnlLeft.add(pnlAdtlOptions2);
        pnlLeft.add(pnlAdtlOptions3);
        pnlLeft.add(lblFood);
        pnlLeft.add(pnlFood1);
        pnlLeft.add(pnlFood2);
        pnlLeft.add(lblDiscount);
        pnlLeft.add(pnlDiscount);
        pnlLeft.add(pnlButtons);
            
        /***** RIGHT PANEL *****/
        pnlRight = new JPanel();
//            pnlLeft.setBackground(Color.WHITE);
            BoxLayout boxLayout2 = new BoxLayout(pnlRight, BoxLayout.Y_AXIS);
            pnlRight.setLayout(boxLayout2);
            

        
        tblData = new String[][]{
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
        };

        for (int i = 0; i < 6; i++) {   
            tblData[i][0] = Database.roomStatus[i];
            tblData[i][1] = Database.classTypes[i];
            tblData[i][2] = Database.names[i];
            tblData[i][3] = String.valueOf(Database.days[i]);
            tblData[i][4] = String.valueOf(Database.balances[i]);
        }
        
        tbl = new JTable(tblData, columnNames);  
        JScrollPane sp = new JScrollPane(tbl);
            sp.setBackground(Database.LIGHTGRAY_1);
            
        pnlDateTime = new JPanel();
            lblCheckInDate = new JLabel("Checked-In Date: ");
            lblDaysLeft = new JLabel("Days Left: ");
            lblStayingStatus = new JLabel("(Not Staying)");
            
            pnlDateTime.add(lblCheckInDate);
            pnlDateTime.add(lblDaysLeft);
            pnlDateTime.add(lblStayingStatus);
        

            
        Timer SimpleTimer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBalanceInRecords();
                
                if (cboClass.getSelectedItem().equals("Tourist Class")) {
                    int y = 0;
                    updateDataInRecords(y);
                }
                else if (cboClass.getSelectedItem().equals("Deluxe Class")) {
                    int y = 1;
                    updateDataInRecords(y);
                }
                else if (cboClass.getSelectedItem().equals("Ambassador Class")) {
                    int y = 2;
                    updateDataInRecords(y);
                }
                else if (cboClass.getSelectedItem().equals("Corporate Class")) {
                    int y = 3;
                    updateDataInRecords(y);
                }
                else if (cboClass.getSelectedItem().equals("Annex Room (Good for 5)")) {
                    int y = 4;
                    updateDataInRecords(y);
                }
                else if (cboClass.getSelectedItem().equals("Annex Room (Good for 3)")) {
                    int y = 5;
                    updateDataInRecords(y);
                }
            }
        });
        SimpleTimer.start();
        
        tblPerClassData = new String[][]{
            {"Extra Bed", "", ""},
            {"Pillow", "", ""},
            {"Towel", "", ""},
            {"Reading Light", "", ""},
            {"Books/Magazines", "", ""},
            {"Toiletries", "", ""},
            {"Luggage Rack", "", ""},
            {"Breakfast", "", ""},
            {"Lunch", "", ""},
            {"Dinner", "", ""},
            {"Drink", "", ""},
            {"Snack", "", ""}
        };

        for (int i = 0; i < 12; i++) {   
            tblPerClassData[i][1] = String.valueOf(Database.touristQtys.get(i));
            tblPerClassData[i][2] = "";
        }    
        
        tblPerClass = new JTable(tblPerClassData, columnNames2);
        JScrollPane sp2 = new JScrollPane(tblPerClass);
            sp2.setBackground(Database.LIGHTGRAY_1);
            
        pnlRight.add(sp);
        pnlRight.add(pnlDateTime);
        pnlRight.add(sp2);
        
        
        add(pnlLeft);
        add(pnlRight);
        
    }
    
    public void updateBalanceInRecords () {
        
        for (int ctr = 0; ctr < 6; ctr++) {
            if (!Database.checkInDates[ctr].equals("")) {
                long daysLeft = Database.getDaysBetweenDates(Database.getStrCurrentDate(), 
                    Database.checkOutDatesSched[ctr]);

                if (daysLeft < 0) {
                    int intDaysLeft = Math.abs((int) daysLeft);
                    Database.daysOverstayed[ctr] = intDaysLeft;
                    double adtlBalanceFromOverstay = Database.daysOverstayed[ctr] * Database.fullPrices[ctr];

                    double tempNewBalance = Database.balances[ctr] + adtlBalanceFromOverstay;

                    tblData[ctr][4] = String.valueOf(tempNewBalance);

                    tbl.setModel(new DefaultTableModel(tblData, columnNames));
                }
            }
        }
    }
    
    public void updateDataInRecords(int y) {
        System.out.println("Updating Dates in Records");
        if (!Database.checkInDates[y].equals("")) {
            
            long daysLeft = Database.getDaysBetweenDates(Database.getStrCurrentDate(), 
                    Database.checkOutDatesSched[y]);
            
            Database.checkOutDatesSched[y] = Database.getStrDateAfterNDays(Database.checkInDates[y], Database.days[y]);
            String strDaysLeft = String.valueOf(daysLeft);
            Database.daysLeft[y] = Integer.parseInt(strDaysLeft);

            if(Database.roomStatus[y].equals("Occupied")) {
                if (LocalDate.now().isAfter(Database.getDateFromStr(Database.checkOutDatesSched[y]))) {
                    Database.stayingStatuses[y] = "(Overstaying)";
                }
                else {
                    Database.stayingStatuses[y] = "(Staying)";
                }
            }
            else {
                Database.stayingStatuses[y] = "(Not Staying)";
            }
            
            System.out.println("Dates in Records Updated");
        }
        lblCheckInDate.setText("Checked-In Date: " + Database.checkInDates[y]);
        lblDaysLeft.setText("Days Left: " + Database.daysLeft[y]);
        lblStayingStatus.setText(Database.stayingStatuses[y]);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == btnAdd) {
            if (currentSelectedClass.equals("Tourist Class")) {
                if (Database.roomStatus[0].equals("Reserved") || Database.roomStatus[0].equals("Occupied")) {
                    System.out.println("Room is occupied");
                    
                    addQtysToTable(Database.touristQtys);
                    updateCostColumn(0, Database.touristQtys, Database.adtlFeesTourist);
                    
                } else if (Database.roomStatus[0].equals("Not Occupied")) {
                    System.out.println("Room is not occupied.");
                    JOptionPane.showMessageDialog(null, "Room is not occupied.");
                }
            } // END - tourist class selected
            else if (currentSelectedClass.equals("Deluxe Class")) {
                if (Database.roomStatus[1].equals("Reserved") || Database.roomStatus[1].equals("Occupied")) {
                    System.out.println("Room is occupied");
                    
                    addQtysToTable(Database.deluxeQtys);
                    updateCostColumn(1, Database.deluxeQtys, Database.adtlFeesDeluxe);
                } else if (Database.roomStatus[1].equals("Not Occupied")) {
                    System.out.println("Room is not occupied.");
                    JOptionPane.showMessageDialog(null, "Room is not occupied.");
                }
            } // END - deluxe class selected
            else if (currentSelectedClass.equals("Ambassador Class")) {
                if (Database.roomStatus[2].equals("Reserved") || Database.roomStatus[2].equals("Occupied")) {
                    System.out.println("Room is occupied");
                    
                    addQtysToTable(Database.ambassadorQtys);
                    updateCostColumn(2, Database.ambassadorQtys, Database.adtlFeesAmbassador);
                } else if (Database.roomStatus[2].equals("Not Occupied")) {
                    System.out.println("Room is not occupied.");
                    JOptionPane.showMessageDialog(null, "Room is not occupied.");
                }
            } // END - ambassador class selected
            else if (currentSelectedClass.equals("Corporate Class")) {
                if (Database.roomStatus[3].equals("Reserved") || Database.roomStatus[3].equals("Occupied")) {
                    System.out.println("Room is occupied");
                    
                    addQtysToTable(Database.corporateQtys);
                    updateCostColumn(3, Database.corporateQtys, Database.adtlFeesCorporate);
                } else if (Database.roomStatus[3].equals("Not Occupied")) {
                    System.out.println("Room is not occupied.");
                    JOptionPane.showMessageDialog(null, "Room is not occupied.");
                }
            } // END - ambassador class selected
            else if (currentSelectedClass.equals("Annex Room (Good for 5)")) {
                if (Database.roomStatus[4].equals("Reserved") || Database.roomStatus[4].equals("Occupied")) {
                    System.out.println("Room is occupied");
                    
                    addQtysToTable(Database.annex5Qtys);
                    updateCostColumn(4, Database.annex5Qtys, Database.adtlFeesAnnex5);
                } else if (Database.roomStatus[4].equals("Not Occupied")) {
                    System.out.println("Room is not occupied.");
                    JOptionPane.showMessageDialog(null, "Room is not occupied.");
                }
            } // END - ambassador class selected
            else if (currentSelectedClass.equals("Annex Room (Good for 3)")) {
                if (Database.roomStatus[5].equals("Reserved") || Database.roomStatus[5].equals("Occupied")) {
                    System.out.println("Room is occupied");
                    
                    addQtysToTable(Database.annex3Qtys);
                    updateCostColumn(5, Database.annex3Qtys, Database.adtlFeesAnnex3);
                    
                } else if (Database.roomStatus[5].equals("Not Occupied")) {
                    System.out.println("Room is not occupied.");
                    JOptionPane.showMessageDialog(null, "Room is not occupied.");
                }
            } // END - ambassador class selected
        } // END - if btnAdd to Bill
        else if (e.getSource() == btnClear) {
            clearInputs();
        }
        else if (e.getSource() == btnCheckOut) {
            if (currentSelectedClass.equals("Tourist Class")) {
                if (Database.roomStatus[0].equals("Occupied")) {
                    int i = 0;

                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to check-out?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
                    if(a==JOptionPane.YES_OPTION) {
                        if (i == 0)
                            processCheckOut(i, Database.touristQtys);
                        else if (i == 1)
                            processCheckOut(i, Database.deluxeQtys);
                        else if (i == 2)
                            processCheckOut(i, Database.ambassadorQtys);
                        else if (i == 3)
                            processCheckOut(i, Database.corporateQtys);
                        else if (i == 4)
                            processCheckOut(i, Database.annex5Qtys);
                        else if (i == 5)
                            processCheckOut(i, Database.annex3Qtys);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please occupy the room first.\nGo to reserve panel and check-in.");
                }
            }
            else if (currentSelectedClass.equals("Deluxe Class")) {
                if (Database.roomStatus[1].equals("Occupied")) {
                    int i = 1;

                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to check-out?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
                    if(a==JOptionPane.YES_OPTION) {
                        if (i == 0)
                            processCheckOut(i, Database.touristQtys);
                        else if (i == 1)
                            processCheckOut(i, Database.deluxeQtys);
                        else if (i == 2)
                            processCheckOut(i, Database.ambassadorQtys);
                        else if (i == 3)
                            processCheckOut(i, Database.corporateQtys);
                        else if (i == 4)
                            processCheckOut(i, Database.annex5Qtys);
                        else if (i == 5)
                            processCheckOut(i, Database.annex3Qtys);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please occupy the room first.\nGo to reserve panel and check-in.");
                }
            }
            else if (currentSelectedClass.equals("Ambassador Class")) {
                if (Database.roomStatus[2].equals("Occupied")) {
                    int i = 2;

                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to check-out?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
                    if(a==JOptionPane.YES_OPTION) {
                        if (i == 0)
                            processCheckOut(i, Database.touristQtys);
                        else if (i == 1)
                            processCheckOut(i, Database.deluxeQtys);
                        else if (i == 2)
                            processCheckOut(i, Database.ambassadorQtys);
                        else if (i == 3)
                            processCheckOut(i, Database.corporateQtys);
                        else if (i == 4)
                            processCheckOut(i, Database.annex5Qtys);
                        else if (i == 5)
                            processCheckOut(i, Database.annex3Qtys);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please occupy the room first.\nGo to reserve panel and check-in.");
                }
            }
            else if (currentSelectedClass.equals("Corporate Class")) {
                if (Database.roomStatus[3].equals("Occupied")) {
                    int i = 3;

                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to check-out?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
                    if(a==JOptionPane.YES_OPTION) {
                        if (i == 0)
                            processCheckOut(i, Database.touristQtys);
                        else if (i == 1)
                            processCheckOut(i, Database.deluxeQtys);
                        else if (i == 2)
                            processCheckOut(i, Database.ambassadorQtys);
                        else if (i == 3)
                            processCheckOut(i, Database.corporateQtys);
                        else if (i == 4)
                            processCheckOut(i, Database.annex5Qtys);
                        else if (i == 5)
                            processCheckOut(i, Database.annex3Qtys);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please occupy the room first.\nGo to reserve panel and check-in.");
                }
            }
            else if (currentSelectedClass.equals("Annex Room (Good for 5)")) {
                if (Database.roomStatus[4].equals("Occupied")) {
                    int i = 4;

                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to check-out?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
                    if(a==JOptionPane.YES_OPTION) {
                        if (i == 0)
                            processCheckOut(i, Database.touristQtys);
                        else if (i == 1)
                            processCheckOut(i, Database.deluxeQtys);
                        else if (i == 2)
                            processCheckOut(i, Database.ambassadorQtys);
                        else if (i == 3)
                            processCheckOut(i, Database.corporateQtys);
                        else if (i == 4)
                            processCheckOut(i, Database.annex5Qtys);
                        else if (i == 5)
                            processCheckOut(i, Database.annex3Qtys);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please occupy the room first.\nGo to reserve panel and check-in.");
                }
            }
            else if (currentSelectedClass.equals("Annex Room (Good for 3)")) {
                if (Database.roomStatus[5].equals("Occupied")) {
                    int i = 5;

                    int a = JOptionPane.showConfirmDialog(null,"Are you sure you want to check-out?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
                    if(a==JOptionPane.YES_OPTION) {
                        if (i == 0)
                            processCheckOut(i, Database.touristQtys);
                        else if (i == 1)
                            processCheckOut(i, Database.deluxeQtys);
                        else if (i == 2)
                            processCheckOut(i, Database.ambassadorQtys);
                        else if (i == 3)
                            processCheckOut(i, Database.corporateQtys);
                        else if (i == 4)
                            processCheckOut(i, Database.annex5Qtys);
                        else if (i == 5)
                            processCheckOut(i, Database.annex3Qtys);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please occupy the room first.\nGo to reserve panel and check-in.");
                }
            }
        } // END - if btnCheckOut
    } 
    @Override
    public void itemStateChanged (ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            clearInputs();
            if (e.getItem() == "Tourist Class") {
                currentSelectedClass = "Tourist Class";
                columnNames2[0] = currentSelectedClass;
                lblRoomStatus.setText("Room Status: " + Database.roomStatus[0]);
                
                int[] tempArrTableAdtl = {0,0,0,0,0,0,0,0,0,0,0,0};
                for (int ctr = 0; ctr < 12; ctr++) {
                    tempArrTableAdtl[ctr] = Database.touristQtys.get(ctr);
                }
                Database.updateRecordsTableAdtl(tempArrTableAdtl);
           
                Database.updateRecordsTableAdtlCost(Database.adtlFeesTourist);
                
                lblCheckInDate.setText("Checked-In Date: " + Database.checkInDates[0]);
                
            }
            else if (e.getItem() == "Deluxe Class") {
                currentSelectedClass = "Deluxe Class";
                columnNames2[0] = currentSelectedClass;
                lblRoomStatus.setText("Room Status: " + Database.roomStatus[1]);
                
                int[] tempArrTableAdtl = {0,0,0,0,0,0,0,0,0,0,0,0};
                for (int ctr = 0; ctr < 12; ctr++) {
                    tempArrTableAdtl[ctr] = Database.deluxeQtys.get(ctr);
                }
                Database.updateRecordsTableAdtl(tempArrTableAdtl);
           
                Database.updateRecordsTableAdtlCost(Database.adtlFeesDeluxe);
                
                lblCheckInDate.setText("Checked-In Date: " + Database.checkInDates[1]);
            }
            else if (e.getItem() == "Ambassador Class") {
                currentSelectedClass = "Ambassador Class";
                columnNames2[0] = currentSelectedClass;
                lblRoomStatus.setText("Room Status: " + Database.roomStatus[2]);
                
                int[] tempArrTableAdtl = {0,0,0,0,0,0,0,0,0,0,0,0};
                for (int ctr = 0; ctr < 12; ctr++) {
                    tempArrTableAdtl[ctr] = Database.ambassadorQtys.get(ctr);
                }
                Database.updateRecordsTableAdtl(tempArrTableAdtl);
           
                Database.updateRecordsTableAdtlCost(Database.adtlFeesAmbassador);
                
                lblCheckInDate.setText("Checked-In Date: " + Database.checkInDates[2]);
            }
            else if (e.getItem() == "Corporate Class") {
                currentSelectedClass = "Corporate Class";
                columnNames2[0] = currentSelectedClass;
                lblRoomStatus.setText("Room Status: " + Database.roomStatus[3]);
                
                int[] tempArrTableAdtl = {0,0,0,0,0,0,0,0,0,0,0,0};
                for (int ctr = 0; ctr < 12; ctr++) {
                    tempArrTableAdtl[ctr] = Database.corporateQtys.get(ctr);
                }
                Database.updateRecordsTableAdtl(tempArrTableAdtl);
           
                Database.updateRecordsTableAdtlCost(Database.adtlFeesCorporate);
                
                lblCheckInDate.setText("Checked-In Date: " + Database.checkInDates[3]);
            }
            else if (e.getItem() == "Annex Room (Good for 5)") {
                currentSelectedClass = "Annex Room (Good for 5)";
                columnNames2[0] = currentSelectedClass;
                lblRoomStatus.setText("Room Status: " + Database.roomStatus[4]);
                
                int[] tempArrTableAdtl = {0,0,0,0,0,0,0,0,0,0,0,0};
                for (int ctr = 0; ctr < 12; ctr++) {
                    tempArrTableAdtl[ctr] = Database.annex5Qtys.get(ctr);
                }
                Database.updateRecordsTableAdtl(tempArrTableAdtl);
           
                Database.updateRecordsTableAdtlCost(Database.adtlFeesAnnex5);
                
                lblCheckInDate.setText("Checked-In Date: " + Database.checkInDates[4]);
            }
            else if (e.getItem() == "Annex Room (Good for 3)") {
                currentSelectedClass = "Annex Room (Good for 3)";
                columnNames2[0] = currentSelectedClass;
                lblRoomStatus.setText("Room Status: " + Database.roomStatus[5]);
                
                int[] tempArrTableAdtl = {0,0,0,0,0,0,0,0,0,0,0,0};
                for (int ctr = 0; ctr < 12; ctr++) {
                    tempArrTableAdtl[ctr] = Database.annex3Qtys.get(ctr);
                }
                Database.updateRecordsTableAdtl(tempArrTableAdtl);
           
                Database.updateRecordsTableAdtlCost(Database.adtlFeesAnnex3);
                
                lblCheckInDate.setText("Checked-In Date: " + Database.checkInDates[5]);
            }
            tblPerClass.setModel(new DefaultTableModel(tblPerClassData, columnNames2));
        }
    }
    public void processCheckOut(int i, Vector<Integer> dbVector) {
//        updateCostColumn(i, dbVector, Database.adtlFees[i]);
        
        String receiptFullText = "";
        receiptFullText = "================RECEIPT================";
        receiptFullText += "\nClass: " + Database.classTypes[i];
        receiptFullText += "\nPaid by: " + Database.receipts[i][0];
        receiptFullText += "\nPayment Type: " + Database.receipts[i][1];
        receiptFullText += "\n=======================================";
        receiptFullText += "\nNo. of Days : " + Database.receipts[i][2];
        receiptFullText += "\nDays Overstayed : " + Database.daysOverstayed[i];
        receiptFullText += "\n+Extra: ₱" + String.valueOf(Database.daysOverstayed[i] * Database.fullPrices[i]);
        receiptFullText += "\n=======================================";
        receiptFullText += "\nPrice:-----------------------------₱" + Database.receipts[i][3];
        receiptFullText += "\n-20% Senior Citizen:---------------₱" + Database.receipts[i][4];
        receiptFullText += "\n-10% PWD---------------------------₱" + Database.receipts[i][5];
        receiptFullText += "\n+12% VAT---------------------------₱" + Database.receipts[i][6];
        receiptFullText += "\nTotal Price:-----------------------₱" + Database.receipts[i][7];
        receiptFullText += "\n=======================================";
        if (Database.paymentTypes[i].equals("Half Payment")) {
             receiptFullText += "\n(PAID)Pending:-----------------------------₱" + Database.pendings[i];
        }
        receiptFullText += "\n"+Database.adtlTemplate[0]+" ("+ dbVector.get(0)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[0]);
        receiptFullText += "\n"+Database.adtlTemplate[1]+" ("+ dbVector.get(1)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[1]);
        receiptFullText += "\n"+Database.adtlTemplate[2]+" ("+ dbVector.get(2)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[2]);
        receiptFullText += "\n"+Database.adtlTemplate[3]+" ("+ dbVector.get(3)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[3]);
        receiptFullText += "\n"+Database.adtlTemplate[4]+" ("+ dbVector.get(4)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[4]);
        receiptFullText += "\n"+Database.adtlTemplate[5]+" ("+ dbVector.get(5)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[5]);
        receiptFullText += "\n"+Database.adtlTemplate[6]+" ("+ dbVector.get(6)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[6]);
        receiptFullText += "\n"+Database.adtlTemplate[7]+" ("+ dbVector.get(7)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[7]);
        receiptFullText += "\n"+Database.adtlTemplate[8]+" ("+ dbVector.get(8)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[8]);
        receiptFullText += "\n"+Database.adtlTemplate[9]+" ("+ dbVector.get(9)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[9]);
        receiptFullText += "\n"+Database.adtlTemplate[10]+" ("+ dbVector.get(10)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[10]);
        receiptFullText += "\n"+Database.adtlTemplate[11]+" ("+ dbVector.get(11)+"x)"+": ";
        receiptFullText += "--------------------------₱";
        receiptFullText += String.valueOf(Database.adtlFeesTourist[11]);
        receiptFullText += "\n=======================================";
        receiptFullText += "\nTotal:----------------------------₱" + String.valueOf(Database.balances[i]);

        // STORE IN REPORT
        Database.tblReportData[Database.numOfCheckOuts][0] = Database.getStrCurrentDate();
        Database.tblReportData[Database.numOfCheckOuts][1] = Database.names[i];
        Database.tblReportData[Database.numOfCheckOuts][2] = Database.classTypes[i];
        Database.tblReportData[Database.numOfCheckOuts][3] = String.valueOf(Database.balances[i] + Database.pendings[i]);
        
        Database.numOfCheckOuts++;
        
        
        // RESET
        
        Database.roomStatus[i] = "Not Occupied";
        Database.names[i] = "";
        Database.days[i] = 0;
        Database.balances[i] = 0.00;
        for (int ctr = 0; ctr < 12; ctr++) {
            Database.adtlFees[i][ctr] = 0.00;
        }
        Database.adtlFeesSums[i] = 0.00;
        Database.receipts[i][0] = "";
        Database.receipts[i][1] = "";
        Database.receipts[i][2] = 0;
        Database.receipts[i][3] = 0.00;
        Database.receipts[i][4] = 0.00;
        Database.receipts[i][5] = 0.00;
        Database.receipts[i][6] = 0.00;
        Database.receipts[i][7] = 0.00;
        
        Database.pendings[i] = 0.00;
        
        Database.paymentTypes[i] = "";
        Database.seniorDiscounts[i] = false;
        Database.pwdDiscounts[i] = false;
        
        Database.checkInDates[i] = "";
        Database.checkOutDatesSched[i] = "";
        Database.daysLeft[i] = 0;
        Database.stayingStatuses[i] = "";
        Database.daysOverstayed[i] = 0;
        
        for (int ctr = 0; ctr < 12; ctr++){
            dbVector.set(ctr, 0);
        }
        
        Database.updateRecordsTable();
        
        cboClass.setSelectedItem("Deluxe Class");
        cboClass.setSelectedItem("Tourist Class");
        
        clearInputs();
        
        JOptionPane.showConfirmDialog(null, receiptFullText, "Receipt",
                JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE);
    }
    
    private void updateComponentFonts() {
        Database.adtlLabels.add(lblAdtlOptions);
        Database.adtlLabels.add(lblExtraBed);
        Database.adtlLabels.add(lblPillow);
        Database.adtlLabels.add(lblTowel);
        Database.adtlLabels.add(lblReadingLight);
        Database.adtlLabels.add(lblBooks);
        Database.adtlLabels.add(lblToiletries);
        Database.adtlLabels.add(lblLuggageRack);
        Database.adtlLabels.add(lblFood);
        Database.adtlLabels.add(lblDiscount);
        Database.adtlLabels.add(lblBreakfast);
        Database.adtlLabels.add(lblLunch);
        Database.adtlLabels.add(lblDinner);
        Database.adtlLabels.add(lblDrink);
        Database.adtlLabels.add(lblSnack);
        
        for (JLabel label : Database.adtlLabels) {
            label.setFont(Database.fontCG_3);
        }
        
        lblAdtlOptions.setFont(Database.fontCG_2);
        lblFood.setFont(Database.fontCG_2);
        lblDiscount.setFont(Database.fontCG_2);
        
        Database.comboboxes.add(cboExtraBed);
        Database.comboboxes.add(cboPillow);
        Database.comboboxes.add(cboTowel);
        Database.comboboxes.add(cboReadingLight);
        Database.comboboxes.add(cboBooks);
        Database.comboboxes.add(cboToiletries);
        Database.comboboxes.add(cboLuggageRack);
        Database.comboboxes.add(cboBreakfast);
        Database.comboboxes.add(cboLunch);
        Database.comboboxes.add(cboDinner);
        Database.comboboxes.add(cboDrink);
        Database.comboboxes.add(cboSnack);
        
        for (JComboBox combobox : Database.comboboxes) {
            combobox.setFont(Database.fontCG_3);
        }
        Database.checkboxes.add(chbSenior);
        Database.checkboxes.add(chbPWD);
        
        for (JCheckBox checkbox : Database.checkboxes) {
            checkbox.setFont(Database.fontCG_3);
        }
        
        lblRoomStatus.setFont(Database.fontCG_4);
        cboClass.setFont(Database.fontCG_4);
    }
    public int convertObjToInt(Object cboItem) {
        String x = String.valueOf(cboItem);
        return Integer.parseInt(x);
    }
    
    private void clearInputs() {
        cboExtraBed.setSelectedIndex(0);
        cboPillow.setSelectedIndex(0);
        cboTowel.setSelectedIndex(0);
        cboReadingLight.setSelectedIndex(0);
        cboBooks.setSelectedIndex(0);
        cboToiletries.setSelectedIndex(0);
        cboLuggageRack.setSelectedIndex(0);
        cboBreakfast.setSelectedIndex(0);
        cboLunch.setSelectedIndex(0);
        cboDinner.setSelectedIndex(0);
        cboDrink.setSelectedIndex(0);
        cboSnack.setSelectedIndex(0);
        
        chbSenior.setSelected(false);
        chbPWD.setSelected(false);
    }
    
    private void addQtysToTable(Vector<Integer> dbVector) {
        int numExtraBed = dbVector.get(0) + convertObjToInt(cboExtraBed.getSelectedItem());
        dbVector.set(0, numExtraBed);
        int numPillow = dbVector.get(1) + convertObjToInt(cboPillow.getSelectedItem());
        dbVector.set(1, numPillow);
        int numTowel = dbVector.get(2) + convertObjToInt(cboTowel.getSelectedItem());
        dbVector.set(2, numTowel);
        int numReadingLight = dbVector.get(3) + convertObjToInt(cboReadingLight.getSelectedItem());
        dbVector.set(3, numReadingLight);
        int numBooks = dbVector.get(4) + convertObjToInt(cboBooks.getSelectedItem());
        dbVector.set(4, numBooks);
        int numToiletries = dbVector.get(5) + convertObjToInt(cboToiletries.getSelectedItem());
        dbVector.set(5, numToiletries);
        int numLuggageRack = dbVector.get(6) + convertObjToInt(cboLuggageRack.getSelectedItem());
        dbVector.set(6, numLuggageRack);
        int numBreakfast = dbVector.get(7) + convertObjToInt(cboBreakfast.getSelectedItem());
        dbVector.set(7, numBreakfast);
        int numLunch = dbVector.get(8) + convertObjToInt(cboLunch.getSelectedItem());
        dbVector.set(8, numLunch);
        int numDinner = dbVector.get(9) + convertObjToInt(cboDinner.getSelectedItem());
        dbVector.set(9, numDinner);
        int numDrink = dbVector.get(10) + convertObjToInt(cboDrink.getSelectedItem());
        dbVector.set(10, numDrink);
        int numSnack = dbVector.get(11) + convertObjToInt(cboSnack.getSelectedItem());
        dbVector.set(11, numSnack);
                            
        for (int i = 0; i < 12; i++) {
        System.out.println(dbVector.get(i));
        }
        
        int[] tempArrayAddQtys = {numExtraBed, numPillow, numTowel, numReadingLight, numBooks, numToiletries, 
        numLuggageRack, numBreakfast, numLunch, numDinner, numDrink, numSnack};
        Database.updateRecordsTableAdtl(tempArrayAddQtys);
    }
    
    private void updateCostColumn (int i, Vector<Integer> dbVector, double[] costArr) {
        double arrNewPrices[] = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
        for (int ctr = 0; ctr < 12; ctr++) {
            arrNewPrices[ctr] = Database.adtlPrices[ctr];
        }
        
        
        if (Database.seniorDiscounts[i] && Database.pwdDiscounts[i]) {
            for (int ctr = 0; ctr < 12; ctr++) {
                arrNewPrices[ctr] = Database.adtlPrices[ctr] - (Database.adtlPrices[ctr] * 0.30);
            }
        }
        else {
            if (Database.seniorDiscounts[i]) {
                for (int ctr = 0; ctr < 12; ctr++) {
                    arrNewPrices[ctr] = Database.adtlPrices[ctr] - (Database.adtlPrices[ctr] * 0.20);
                }
            }
            else if (Database.pwdDiscounts[i]) {
                for (int ctr = 0; ctr < 12; ctr++) {
                    arrNewPrices[ctr] = Database.adtlPrices[ctr] - (Database.adtlPrices[ctr] * 0.10);
                }
            }
        }
        
        for (int ctr = 0; ctr < 12; ctr++) {
            double x = arrNewPrices[ctr];
            arrNewPrices[ctr] = x + (x * 0.12);
        }
        
        for (int ctr = 0; ctr < 12; ctr++) {
            System.out.println("i went here");
            double computed = dbVector.get(ctr) * arrNewPrices[ctr];
            costArr[ctr] = computed;
            tblPerClassData[ctr][2] = String.valueOf(computed);
            tblPerClass.setModel(new DefaultTableModel(tblPerClassData, columnNames2));
            System.out.println("cost column updated");
        }
        
        double value = Double.parseDouble(tblData[i][4]) + Database.returnSumOfArray(costArr);
        Database.balances[i] = value;
        tblData[i][4] = String.valueOf(Database.balances[i]);
        
        tbl.setModel(new DefaultTableModel(tblData, columnNames));
    }
}
