package reservationsystem;

import java.util.*;

public class Hotel 
{
    public Hotel(){}
    
    private List<Room> rooms = new ArrayList<>();
    
    public void add(Room room){ this.rooms.add(room); }
    
    public Room room(String name)
    {
        for(Room room : this.rooms)
            if(room.name() == name)
                return room;
        return null;
    }
    
    public void addSesonPrice(Calendar start, Calendar end, int price, String room_name)
    {
        this.room(room_name).addSesonPrice(start, end, price);
    }
    
    public void setOutOfSeasonPrice(int price, String room_name)
    {
        this.room(room_name).setOutOfSeasonPrice(price);
    }
    
    public void reserve(Calendar start, Calendar end, QueryResult result, Person person) {
        List<Room> rooms = result.rooms();
        for (Room room : rooms) {
            room.reserve(start, end, person);
        }
    } 
    
    public List<QueryResult> findFreeRooms(Calendar start, Calendar end, int n_persons)
    {
        List<QueryResult> qr = new ArrayList<>();
        
        if(this.rooms.size() == 0) return qr;
        
        List<Room> l_rooms = getAllFreeRooms(start,end);
        
        Collections.sort(l_rooms);
        
        qr = findAllCombinationsRooms(l_rooms, n_persons);
        
        for(QueryResult lqr : qr)
        {
            lqr.setTime(start,end);
        }
        
        qr = findAllCheapestCombinationsRooms(qr);
        
        return qr;
    }
    
    private List<QueryResult> findAllCheapestCombinationsRooms(List<QueryResult> listQR)
    {
        if(listQR.isEmpty())
        {
            return listQR;
        }
        
        Collections.sort(listQR);
        
        int index = listQR.size();
        double cheapestPrice = listQR.get(0).price();
        for(QueryResult qr : listQR)
        {
            if(cheapestPrice != qr.price())
            {
                index = listQR.indexOf(qr);
                break;
            }
        }
        
        listQR = listQR.subList(0, index);
        
        return listQR;
    }
    
    private List<Room> getAllFreeRooms(Calendar start, Calendar end)
    {
        List<Room> l_listRooms = new ArrayList<>();
        for (Room room : this.rooms) {
            if (room.isFree(start, end)) {
                l_listRooms.add(room);
            }
        }
        return l_listRooms;
    }
    
    private List<Room> getAllRoomsAbove(int p_numberOfPersons, List<Room> p_rooms)
    {
        List<Room> l_listRooms = new ArrayList<>();
        for(Room room : p_rooms)
            if(room.n_persons() > p_numberOfPersons)
                l_listRooms.add(room);
        return l_listRooms;
    }
    
    private void deleteAllRoomsAbove(int p_numberOfPersons, List<Room> p_listRooms)
    {
        for(int i = 0; i < p_listRooms.size();)
            if(p_numberOfPersons < p_listRooms.get(i).n_persons())
                p_listRooms.remove(p_listRooms.get(i));
            else
                i++;
    }
    
    private List<QueryResult> findAllCombinationsRooms(List<Room> p_rooms, int n_persons)
    {
        List<QueryResult> l_qr = new ArrayList<>();
        
        List<Room> temp_room = getAllRoomsAbove(n_persons-1, p_rooms);
        for(Room room : temp_room)
        {
            QueryResult qr = new QueryResult();
            qr.add(room);
            l_qr.add(qr);
        }
        
        
        deleteAllRoomsAbove(n_persons-1, p_rooms);
        
        while(p_rooms.size() > 0)
        {  
            List<Room> second_rooms = new ArrayList<>(p_rooms);
            Room room = p_rooms.get(p_rooms.size()-1);
            second_rooms.remove(room);
            
            while(second_rooms.size() > 0)
            {
                QueryResult qr = new QueryResult();
                qr.add(room);
                int lastIdx = second_rooms.size()-1;
                
                for(int j = lastIdx; j >= 0; j--)
                {
                    Room second_room = second_rooms.get(j);
                    
                    if(qr.n_person() + second_room.n_persons() < n_persons)
                    {
                        qr.add(second_room);
                        continue;
                    }
                    
                    if(qr.n_person() + second_room.n_persons() == n_persons)
                    {
                        qr.add(second_room);
                        l_qr.add(qr);
                    }
                    break;
                }
                second_rooms.remove(lastIdx);   
            }
            
            p_rooms.remove(room);
        }
        
        return l_qr;
    }
}
