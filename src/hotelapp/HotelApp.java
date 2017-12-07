/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiper
 */
public class HotelApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerImpl());
        
        HotelImpl hotel = new HotelImpl();
        
        CSVUtilsRooms csvUtilsRooms = new CSVUtilsRooms();
//        rooms = csvUtilsRooms.readCSV();
        hotel.loadRooms(csvUtilsRooms);
        
        List<RoomInfo> rooms = new ArrayList<>();
        rooms = hotel.getRooms();
        for(int i=0; i<rooms.size(); i++){ 
            System.out.println(rooms.get(i));
        }
        
        rooms = hotel.getRooms();
        for(int i=0; i<rooms.size(); i++){ 
            System.out.println(rooms.get(i));
        }
        
        hotel.saveRooms(csvUtilsRooms);
        
        

//        CSVUtilsUsers csvUtilsUsers = new CSVUtilsUsers();
//        users = csvUtilsUsers.readCSV();
        
//        List<User> users = new ArrayList<User>();
//        users = csvUtilsUsers.readCSV();
//        for(int i=0; i<users.size(); i++){
//            System.out.println(users.get(i));
//        }
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (true) {
            input = br.readLine();
            
            if (input == "add"){
                //collect info
                hotel.addRoom("Room4", 3, 500);
            }
            else if (input == "list") {
                rooms = hotel.getRooms();
                for(int i=0; i<rooms.size(); i++){ 
                    System.out.println(rooms.get(i));
                }
            }
        }
    }
    
}
