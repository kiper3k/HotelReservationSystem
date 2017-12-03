package reservationsystem;

import java.util.Calendar;


class SeasonPrice 
{
       private Calendar start;
       private Calendar end;
       private int price;
       
       public SeasonPrice(Calendar start, Calendar end, int price){
           this.start = start;
           this.end = end;
           this.price = price;
       }
       
       public Calendar start(){
           return this.start;
       }
       public Calendar end(){
           return this.end;
       }
       
       public int price(){ return this.price; }

    public boolean isPresent(Calendar data) 
    {
        if(data.equals(this.start)) return true;
        if(data.after(this.start) && data.before(this.end)) return true;
        return false;
    }
    
}
