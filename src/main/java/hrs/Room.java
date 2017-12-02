/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

/**
 *
 * @author kiper
 */
public class Room {
    
    private int id;
    private int nbOfPeople;
    private float price;
    
    Room(int id, int nbOfPeople, float Price){
        this.id = id;
        this.nbOfPeople = nbOfPeople;
        this.price = price;
    }
    
    public int getId(){
        return id;
    }
    
    public int getNbOfPeople(){
        return nbOfPeople;
    }
    
    public float getPrice(){
        return price;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNbOfPeople(int nbOfPeople){
        this.nbOfPeople = nbOfPeople;
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    
    public String toString(){
        return "Id: " + this.id + "\nNumber of people: " + this.nbOfPeople
                + "\nPrice: " + this.price;
    }
    
}
