/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gk;

/**
 *
 * @author Lenovo
 */
public class Motorbike extends Vehicle{
    private int capacity;

    public Motorbike(String ID, String Brand, int PublishYear, int Price, String Color) {
        super(ID, Brand, PublishYear, Price, Color);
    }
    

    public void showInfo() {
        super.showInfo();
        System.out.println("Cong suat: "+capacity);
        
    
}
    
}
