/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import hrs.exception.UncaughtExceptionHandlerImpl;

/**
 *
 * @author kiper
 */
public class HotelReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerImpl());
        // TODO code application logic here
    }
    
}
