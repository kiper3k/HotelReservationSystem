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

import hrs.features.user.User;

/**
 *
 * @author kiper
 */
public class CSVUtilsUsers {
    
    String csvFile;
    BufferedReader br;
    String line;
    String cvsSplitBy;
    List list;
    
    CSVUtilsUsers(){
        this.csvFile = "/home/kiper/Dokumenty/UJ/Projektowanie obiektowe/HotelReservationSystem/src/test/resources/users.csv";
        this.br = null;
        this.cvsSplitBy = ",";
    }
    
    public List readCSV(){
        List<User> users = new ArrayList<User>();
        String name;
        String login;
        String password;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // reads the header line
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] user = line.split(cvsSplitBy);
                name = user[2];
                login = user[3];
                password = user[4];
//                System.out.println(new Room(Integer.parseInt(room[0]),
//                        Integer.parseInt(room[1]), 
//                        Float.parseFloat(room[2])));
                
                users.add(new User(name, login, password));

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
        
        return users;
        
    }
    
}
