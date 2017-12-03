package reservationsystem;

import java.util.*;

public class Room implements Comparable<Room>
{
    private String name = "";
    private int n_persons = 0;
    
    public Room(String name, int n_persons)
    {
        this.n_persons = n_persons;
        this.name = name;
    }
    
    public int price(Calendar data)
    {
        for(SeasonPrice season_price : this.season_prices)
        {
            if(season_price.isPresent(data))
                return season_price.price();
        }
        return this.out_of_season_price;
    }
    
    public String name(){ return this.name; }
    public int n_persons(){ return this.n_persons; }
    
    @Override
    public int compareTo(Room room) {
        Integer myNPerson = this.n_persons;
        Integer oNPerson = room.n_persons();
        return myNPerson.compareTo(oNPerson);
    }
    
    private int out_of_season_price = 0;
    public void setOutOfSeasonPrice(int price){ this.out_of_season_price = price;}
    private List<SeasonPrice> season_prices = new ArrayList<>();
    public void addSesonPrice(Calendar start, Calendar end, int price)
    {
        SeasonPrice season_price  = new SeasonPrice(start,end, price);
        this.season_prices.add(season_price);
    }
    
    
    private List<Reservation> reservations = new ArrayList<>();
    
    public void reserve(Calendar start, Calendar end, Person person) {
        Reservation reservation = new Reservation(start, end, person);
        this.reservations.add(reservation);
    }

    public boolean isFree(Calendar start, Calendar end) 
    {
        for (Reservation reservation : this.reservations) 
        {
            Calendar s1 = reservation.start();
            Calendar e1 = reservation.end();
            
            if(s1.before(start) && (e1.before(start) || e1.equals(start))) {
                continue;
            }
            if(e1.after(end) && (s1.after(end) || s1.equals(end))) {
                continue;
            }
            return false;
        }
        return true;
    }
} 
