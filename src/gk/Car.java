/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gk;

/**
 *
 * @author Lenovo
 */
public class Car extends Vehicle{
    private int slots;
    private String engineType;

    public Car(String ID, String Brand, int PublishYear, int Price, String Color) {
        super(ID, Brand, PublishYear, Price, Color);
    }
    
     public void showInfo() {
        super.showInfo();
        System.out.println("So cho ngoi: "+slots+"\nKieu dong co"+engineType);
        
    
}
     
     
    
}
