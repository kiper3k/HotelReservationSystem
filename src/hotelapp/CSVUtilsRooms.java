/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiper
 */
public class CSVUtilsRooms {
//        implements CSVUtils {
    
    BufferedReader br = null;
    
    String csvFile;
    String cvsSplitBy;
    
    String line;
    List list;
    
    
    BufferedWriter bw;
    
    public CSVUtilsRooms(){
        this.csvFile = "/home/kiper/Dokumenty/UJ/Projektowanie obiektowe/HotelReservationSystem/src/test/resources/rooms.csv";
        this.cvsSplitBy = ",";
    }
    
    public List readCSV(){
        List<RoomInfo> rooms = new ArrayList<>();
//        int id;
        String roomName;
        int nbOfBeds;
        float price;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // reads the header line
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] room = line.split(cvsSplitBy);
                roomName = room[0];
                nbOfBeds = Integer.parseInt(room[1]);
                price = Float.parseFloat(room[2]);
//                System.out.println(new Room(Integer.parseInt(room[0]),
//                        Integer.parseInt(room[1]), 
//                        Float.parseFloat(room[2])));
                
                rooms.add(new RoomInfoImpl(roomName, nbOfBeds, price));

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
    
    public void saveCSV(List<RoomInfo> rooms){
        
        String roomName;
        int nbOfBeds;
        float price;
        
        String line;
        
        try {

            bw = new BufferedWriter(new FileWriter(csvFile));
            line = "roomName,nbOfBeds,price";
            bw.write(line, 0, line.length());
            bw.newLine();
            for (int i=0; i<rooms.size(); i++){
                roomName = rooms.get(i).getRoomName();
                nbOfBeds = rooms.get(i).getNumberOfBeds();
                price = rooms.get(i).getPrice();
                
                line = roomName + "," + Integer.toString(nbOfBeds)
                        + "," + Float.toString(price);
                
                bw.write(line, 0, line.length());
                bw.newLine();
            }
            bw.close();
            

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
        
    }
    
}
