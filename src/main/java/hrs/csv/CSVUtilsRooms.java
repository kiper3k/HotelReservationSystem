/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiper
 */
public class CSVUtilsRooms {
//        implements CSVUtils {
    
    String csvFile;
    BufferedReader br;
    String line;
    String cvsSplitBy;
    List list;
    
    CSVUtilsRooms(){
        this.csvFile = "/home/kiper/Dokumenty/UJ/Projektowanie obiektowe/HotelReservationSystem/src/test/resources/rooms.csv";
        this.br = null;
        this.cvsSplitBy = ",";
    }
    
    public List readCSV(){
        List<Room> rooms = new ArrayList<Room>();
        int id;
        int nbOfPeople;
        float price;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // reads the header line
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] room = line.split(cvsSplitBy);
                id = Integer.parseInt(room[0]);
                nbOfPeople = Integer.parseInt(room[1]);
                price = Float.parseFloat(room[2]);
//                System.out.println(new Room(Integer.parseInt(room[0]),
//                        Integer.parseInt(room[1]), 
//                        Float.parseFloat(room[2])));
                
                rooms.add(new Room(id, nbOfPeople, price));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return rooms;
        
    }
    
}
