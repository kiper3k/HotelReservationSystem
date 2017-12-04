/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.csv;

import hrs.features.shared.RoomInfo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hrs.features.user.User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

/**
 *
 * @author kiper
 */
public class CSVUtilsUsers {
    
    BufferedReader br = null;
    
    String csvFile;
    String cvsSplitBy;
    
    String line;
    List list;
    
    
    BufferedWriter bw;
    
    public CSVUtilsUsers(){
        this.csvFile = "/home/kiper/Dokumenty/UJ/Projektowanie obiektowe/HotelReservationSystem/src/test/resources/users.csv";
        this.cvsSplitBy = ",";
    }
    
    public List readCSV(){
        List<User> users = new ArrayList<>();
        
        int id;
        String firstName;
        String lastName;
        LocalDate birthDate;
        String login;
        String password;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // reads the header line
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] user = line.split(cvsSplitBy);
                id = Integer.parseInt(user[0]);
                firstName = user[1];
                lastName = user[2];
                birthDate = LocalDate.parse(user[3]);
                login = user[4];
                password = user[5];
//                System.out.println(new Room(Integer.parseInt(room[0]),
//                        Integer.parseInt(room[1]), 
//                        Float.parseFloat(room[2])));
                
                users.add(new User(id, firstName, lastName, birthDate,
                        login, password));

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
    
    
    public void saveCSV(List<User> users){
        
        int id;
        String firstName;
        String lastName;
        LocalDate birthDate;
        String login;
        String password;
        
        String line;
        
        try {

            bw = new BufferedWriter(new FileWriter(csvFile));
            line = "id,firstName,lastName,birthDate,login,password";
            bw.write(line, 0, line.length());
            bw.newLine();
            for (int i=0; i<users.size(); i++){
                id = users.get(i).getId();
                firstName = users.get(i).getFirstName();
                lastName = users.get(i).getLastName();
                birthDate = users.get(i).getBirthDate();
                login = users.get(i).getLogin();
                password = users.get(i).getPassword();
                
                line = Integer.toString(id) + "," + firstName + "," + lastName
                        + "," + birthDate + "," + login + "," + password;
                
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
