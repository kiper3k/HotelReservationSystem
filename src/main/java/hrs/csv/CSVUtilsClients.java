/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs.csv;

import hrs.features.client.Client;
//import hrs.features.user.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiper
 */
public class CSVUtilsClients {
    BufferedReader br = null;
    
    String csvFile;
    String cvsSplitBy;
    
    String line;
    List list;
    
    
    BufferedWriter bw;
    
    public CSVUtilsClients(){
        this.csvFile = "/home/kiper/Dokumenty/UJ/Projektowanie obiektowe/HotelReservationSystem/src/test/resources/clients.csv";
        this.cvsSplitBy = ",";
    }
    
    public List readCSV(){
        List<Client> clients = new ArrayList<>();
        
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
                String[] client = line.split(cvsSplitBy);
                id = Integer.parseInt(client[0]);
                firstName = client[1];
                lastName = client[2];
                birthDate = LocalDate.parse(client[3]);
                login = client[4];
                password = client[5];
//                System.out.println(new Room(Integer.parseInt(room[0]),
//                        Integer.parseInt(room[1]), 
//                        Float.parseFloat(room[2])));
                
                clients.add(new Client(id, firstName, lastName, birthDate,
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
        
        return clients;
        
    }
    
    
    public void saveCSV(List<Client> clients){
        
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
            for (int i=0; i<clients.size(); i++){
                id = clients.get(i).getId();
                firstName = clients.get(i).getFirstName();
                lastName = clients.get(i).getLastName();
                birthDate = clients.get(i).getBirthDate();
                login = clients.get(i).getLogin();
                password = clients.get(i).getPassword();
                
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
