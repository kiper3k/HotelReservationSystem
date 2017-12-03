package reservationsystem;

import java.util.*;

public class Reservation 
{
       private Calendar start;
       private Calendar end;
       private Person person;
       
       public Reservation(Calendar start, Calendar end, Person person){
           this.start = start;
           this.end = end;
           this.person = person;
       }
       
       public Calendar start(){
           return this.start;
       }
       public Calendar end(){
           return this.end;
       }
}
