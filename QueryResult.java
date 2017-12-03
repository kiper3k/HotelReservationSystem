package reservationsystem;

import java.util.*;

public class QueryResult implements Comparable<QueryResult>
{
    private List<Room> rooms = new ArrayList<>();
    
    private Calendar start;
    private Calendar end;
    
    public List<Room> rooms(){ return this.rooms; }
    public int price() 
    { 
        int price = 0;
        for(Calendar day = new GregorianCalendar(start.get(Calendar.YEAR), 
                                                     start.get(Calendar.MONTH), 
                                                     start.get(Calendar.DAY_OF_MONTH));
                                    false == day.equals(end); 
                                    day.add(Calendar.DATE, 1))
        {
            for(Room room : this.rooms)
                price += room.price(day);
        }
        return price;
    }
    
    public QueryResult(){}
    public void add(Room room){ this.rooms.add(room); }
    
    public int n_person(){
        int n_person = 0;
        for(Room room : this.rooms)
            n_person += room.n_persons();
        return n_person;
    }
    
    @Override
    public int compareTo(QueryResult qr) {
        Integer myNPrice = this.price();
        Integer oNPrice = qr.price();
        return myNPrice.compareTo(oNPrice);
    }

    void setTime(Calendar start, Calendar end) 
    {
        this.start = start;
        this.end = end;
    }
}
