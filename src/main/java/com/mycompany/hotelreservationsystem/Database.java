/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelreservationsystem;

import java.awt.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import static java.util.concurrent.TimeUnit.DAYS;
import javax.swing.*;
import javax.swing.table.*;

public class Database {
    
    public static String currentPanel = "Reservation Panel";
    
    public static int numOfAttempts = 0;
    
    Database() {
        
        for (int i = 0; i < 12; i++) {
            touristQtys.add(0);
            deluxeQtys.add(0);
            ambassadorQtys.add(0);
            corporateQtys.add(0);
            annex5Qtys.add(0);
            annex3Qtys.add(0);
        }
        System.out.println("DATABASE CONSTRUCTED");
        
  
        // ADMIN
        
        tblStaffData[numOfAccounts][0] = "1";
        tblStaffData[numOfAccounts][1] = "1";
        tblStaffData[numOfAccounts][2] = "admin";
        
        numOfAccounts++;
        
        tblStaffData[numOfAccounts][0] = "Lowell";
        tblStaffData[numOfAccounts][1] = "123";
        tblStaffData[numOfAccounts][2] = "admin";
        
        numOfAccounts++;
    }

    public static Font fontCG_0 = new Font("Century Gothic", Font.BOLD, 25);
    public static Font fontCG_1 = new Font("Century Gothic", Font.PLAIN, 15);
    public static Font fontCG_2 = new Font("Century Gothic", Font.BOLD, 15);
    public static Font fontCG_3 = new Font("Century Gothic", Font.PLAIN, 12);
    public static Font fontCG_4 = new Font("Century Gothic", Font.BOLD, 13);
    
    public static Color RED_1 = Color.decode("#EE4B2B");
    public static Color LIGHTGRAY_1 = Color.decode("#dadada");
    
    public static Vector<JLabel> labels = new Vector<>();
    public static Vector<JLabel> adtlLabels = new Vector<>();
    public static Vector<JTextField> textfields = new Vector<>();
    public static Vector<JRadioButton> radiobuttons = new Vector<>();
    public static Vector<JComboBox> comboboxes = new Vector<>();
    public static Vector<JCheckBox> checkboxes = new Vector<>();
    
    public static String[] classTypes = {"Tourist Class", "Deluxe Class", "Ambassador Class"
            , "Corporate Class", "Annex Room (Good for 5)", "Annex Room (Good for 3)"};
    public static String[] roomStatus = {"Not Occupied", "Not Occupied", "Not Occupied"
            , "Not Occupied", "Not Occupied", "Not Occupied"};
    public static String[] names = {"", "", "", "", "", "", ""};
    public static int[] days = {0, 0, 0, 0, 0, 0};
    public static double[] balances = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    
    
    
    public static double[] adtlFeesTourist = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static double[] adtlFeesDeluxe = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static double[] adtlFeesAmbassador = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static double[] adtlFeesCorporate = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static double[] adtlFeesAnnex5 = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static double[] adtlFeesAnnex3 = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    
    public static double[][] adtlFees = {adtlFeesTourist, adtlFeesDeluxe, adtlFeesAmbassador,
        adtlFeesCorporate, adtlFeesAnnex5, adtlFeesAnnex3};
    
    public static double[] adtlFeesSums = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    
    public static double[] fullPrices = {1000.00, 1200.00, 1300.00, 1500.00, 1500.00, 900.00};
    public static double[] promoPrices = {900.00, 930.00, 1030.00, 1300.00, 1500.00, 900.00};
    public static double[] adtlPrices = {300.00, 150.00, 150.00, 200.00, 100.00, 300.00, 300.00,
        400.00, 600.00, 600.00, 100.00, 300.00
    };
    
    public static String[] adtlTemplate = {"Extra Bed", "Pillow", "Towel", "Reading Light",
        "Books/Magazines", "Toiletries", "Luggage Rack", "Breakfast", "Lunch", "Dinner",
        "Drink", "Snack"};
    
    public static String[] receiptTemplate =  {"Name:", "Payment Type:", "No. of Days:", 
        "Price:", "-20% Senior Citizen:", "-10% PWD:", "+12% VAT:", "Total Price:"};
    public static Object[] receiptTourist = {"", "", 0, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static Object[] receiptDeluxe = {"", "", 0, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static Object[] receiptAmbassador = {"", "", 0, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static Object[] receiptCorporate = {"", "", 0, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static Object[] receiptAnnex5 = {"", "", 0, 0.00, 0.00, 0.00, 0.00, 0.00};
    public static Object[] receiptAnnex3 = {"", "", 0, 0.00, 0.00, 0.00, 0.00, 0.00};
    
    public static double[] pendings = {0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    
    public static Object[][] receipts = {receiptTourist, receiptDeluxe, receiptAmbassador, 
        receiptCorporate, receiptAnnex5, receiptAnnex3};
    
    public static String[] paymentTypes = {"", "", "", "", "", ""};
    public static boolean[] seniorDiscounts = {false, false, false, false, false, false};
    public static boolean[] pwdDiscounts = {false, false, false, false, false, false};
    
    public static String[] checkInDates = {"", "", "", "", "", ""};
    public static String[] checkOutDatesSched = {"", "", "", "", "", ""};
    public static int[] daysLeft = {0, 0, 0, 0, 0, 0};
    public static String[] stayingStatuses = {"", "", "", "", "", ""};
    public static int[] daysOverstayed = {0, 0, 0, 0, 0, 0};
    
//    Object touristInfos = new Object[6];
    
    public static Vector<Integer> touristQtys = new Vector<>(12);
    public static Vector<Integer> deluxeQtys = new Vector<>(12);
    public static Vector<Integer> ambassadorQtys = new Vector<>(12);
    public static Vector<Integer> corporateQtys = new Vector<>(12);
    public static Vector<Integer> annex5Qtys = new Vector<>(12);
    public static Vector<Integer> annex3Qtys = new Vector<>(12);
    
//    public static Vector<
    
    public static void updateRecordsTable() {
        for (int i = 0; i < 6; i++) {   
            PanelRecords.tblData[i][0] = Database.roomStatus[i];
            PanelRecords.tblData[i][1] = Database.classTypes[i];
            PanelRecords.tblData[i][2] = Database.names[i];
            PanelRecords.tblData[i][3] = String.valueOf(Database.days[i]);
            PanelRecords.tblData[i][4] = String.valueOf(Database.balances[i]);
        }
        
        PanelRecords.tbl.setModel(new DefaultTableModel(PanelRecords.tblData, PanelRecords.columnNames));
    }
    
    public static void updateRecordsTableAdtl(int[] arr) { 
        for (int ctr = 0; ctr < 12; ctr++) {
            PanelRecords.tblPerClassData[ctr][1] = String.valueOf(arr[ctr]);
        }
                        
        PanelRecords.tblPerClass.setModel(new DefaultTableModel(PanelRecords.tblPerClassData, PanelRecords.columnNames2));
    }
    public static void updateRecordsTableAdtlCost(double[] arr) { 
        for (int ctr = 0; ctr < 12; ctr++) {
            PanelRecords.tblPerClassData[ctr][2] = String.valueOf(arr[ctr]);
        }

        PanelRecords.tblPerClass.setModel(new DefaultTableModel(PanelRecords.tblPerClassData, PanelRecords.columnNames2));
    }
                    
    public static String getStrCurrentDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String formattedString = date.format(formatter);
        
        return formattedString;
    }
    public static String getStrDateAfterNDays(String startDate, int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate oldDate = LocalDate.parse(startDate, formatter);
        LocalDate newDate = oldDate.plusDays(n);

        String formattedString = newDate.format(formatter);
        return formattedString;
    }
    public static long getDaysBetweenDates(String strDate1, String strDate2) {
        LocalDate dateBefore = getDateFromStr(strDate1);
        LocalDate dateAfter = getDateFromStr(strDate2);
        
        long days = dateBefore.until(dateAfter, ChronoUnit.DAYS);

        return days;
    }
     
    public static LocalDate getDateFromStr(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate convertedDate = LocalDate.parse(date, formatter);
        
        
        return convertedDate;
    }
    
    public static double returnSumOfArray(double[] arr) {
        double x = 0.00;
        for (int i = 0; i < arr.length; i++) {
            x += arr[i];
        }
        return x;
    }
    
    // ADMIN
    
    public static String[] usernames = new String[5];
    
    public static String[] passwords = new String[5];
    public static String[] permissions = new String[5];
    
//    public static String[] usernames = new String[100];
//    public static String[] passwords = new String[100];
//    public static String[] encryptedPasswords = new String[100];
//    public static String[] permissions = new String[100];
       
    
    public static String encrypt(int n) {
        byte[] array = new byte[n]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }
    public static Object[][] to2DArray(Vector v) {
        Object[][] out = new Object[v.size()][0];
        for (int i = 0; i < out.length; i++) {
            out[i] = ((Vector) v.get(i)).toArray();
        }
        return out;
    }
    
    // ADMIN
    
    public static int numOfAccounts = 0;
    
    
    
   
    
//    Vector<String[]> tblStaffData = new Vector<>();
    public static String[][] tblStaffData = new String[100][3];
    public static String columnNames3[] = {"Username", "Password", "Permission"};
    
    public static void updateAdminTable() {
        PanelAdmin.tblStaff.setModel(new DefaultTableModel(tblStaffData, columnNames3));
    }
    
    public static String currentUser = "";
    public static String currentPermission = "";
    
    
    // REPORT
    
    public static int numOfCheckOuts = 0;
    
    public static String columnNames4[] = {"Check-out", "Class", "Name", "Earnings"};
    public static String[][] tblReportData = new String[100][4];
}
