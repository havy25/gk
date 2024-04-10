/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Vehicle implements ICar {
        private String ID;
    private String Brand;
    private int PublishYear;
    private int Price;
    private String Color;

    // Constructor
    public Vehicle(String ID, String Brand, int PublishYear, int Price, String Color) {
        this.ID = ID;
        this.Brand = Brand;
        this.PublishYear = PublishYear;
        this.Price = Price;
        this.Color = Color;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public int getPublishYear() {
        return PublishYear;
    }

    public void setPublishYear(int PublishYear) {
        this.PublishYear = PublishYear;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    

    public void showInfo() {
        System.out.println("ID: " + ID + ", Brand: " + Brand + ", Year: " + PublishYear + ", Price: " + Price + ", Color: " + Color);
    }
     ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
    private Connection getConnect(){
        String user="sa";
        String pass="123456";
        
        String url="jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url,user,pass);
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
        return null;
        
    }
    private void LoadDataToArrayList() {
        
        arr.clear();
        try{
            String user="sa";
            String pass="123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=QLPhuongTien";
            Connection con=DriverManager.getConnection(url,user,pass);
            String sql="select* from Vehicle";
            Statement st=con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String ID=rs.getString(1);
                String Brand=rs.getString(2);
                String publishYear=rs.getString(2);
                String price=rs.getString(2);
                String Color=rs.getString(2);
                int PublishYear=Integer.parseInt(publishYear);
                int Price=Integer.parseInt(price);
                Vehicle pt=new Vehicle(ID,Brand,PublishYear,Price,Color);
                arr.add(pt);
            }
            con.close();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    
    } 
    private void xoa(Vehicle pt){
        
        String sql="DELETE FROM Vehicle WHERE ID='"+pt.getID()+"'";
        try {
            
            Connection con = getConnect();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Xoa thanh cong.");
            LoadDataToArrayList();
            
       
    } 
    

   catch (SQLException e) {
        System.out.println("Xoa that bai.");
        e.printStackTrace();
    }
    }
    public void them(Vehicle pt){
        try {
            String sql = "INSERT INTO Vehicle (ID,brand,publishYear,price,color) " +
                 "VALUES (N'" + pt.getID()+ "', N'" +pt.getBrand()  + "', N'" + pt.getPublishYear() + "', N'" + pt.getPrice() + "', N'" + pt.getColor() + "')";
           
            Connection con = getConnect();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Them thanh cong.");
            LoadDataToArrayList();
        
       
    } 
    

   catch (SQLException e) {
        System.out.println("Them that bai.");
        
    }
        
    }
    private void update(Vehicle pt){
        //String sql="UPDATE KH SET TENKHACHHANG = N'"+hoten+"', GIOITINH = N'"+gioitinh+"',DIACHI = N'"+diachi+"', SDT = '"+sdt+"'WHERE MAKH = '"+makh+"'";
        String sql="";
        try {
            
        Connection con = getConnect();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        System.out.println("Cap nhat thanh cong.");
        LoadDataToArrayList();
        
       
    } 
    

   catch (SQLException e) {
        System.out.println("Cap nhat that bai.");
        e.printStackTrace(); 
    }
    }
    private void read(Vehicle pt){
        pt.showInfo();

        
    }
    private void readFile() throws IOException{
        String path="C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\gk\\src\\gk\\kq.txt";
        try{
            FileOutputStream f=new FileOutputStream(path);
            String message="Hello world\nTest";
             for(Vehicle KH:arr){
            
        }
            f.write(message.getBytes());
            f.close();

        } catch (FileNotFoundException e){
            System.out.println("Find not found");
        } catch (IOException e){
            System.out.println("Loi ghi file");
        }
    }

    
}
