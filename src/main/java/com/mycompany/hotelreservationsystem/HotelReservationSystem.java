/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelreservationsystem;

/**
 *
 * @author Lowell
 */
public class HotelReservationSystem {
    
    public static loginWindow loginFrame;
    public static MainWindow frame;
    
    public static SplashScreen frm;

    public static void main(String[] args) {
        loginFrame = new loginWindow();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(false);
        loginFrame.setTitle("LOGIN FORM");
        
        frame = new MainWindow();
        
        frame.setTitle("Black Bean Hotel and Resort");
        frame.setLocationRelativeTo(null);
        
        frm = new SplashScreen();
//        frame.setVisible(true);
        
    }
}
