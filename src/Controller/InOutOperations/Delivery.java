package Controller.InOutOperations;

import Controller.ProductsStock.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Delivery implements Serializable {
    
    private ArrayList<Order> orderList;
    private double transportationCost;
    private double tax;
    private double discount;
    private String client;

    public Delivery(ArrayList<Order> orderList,double transportationCost,double tax,double discount,String client){
        
        this.orderList=orderList;
        this.transportationCost=transportationCost;
        this.tax=tax;
        this.discount=discount;
        this.client=client;
        

    }
    public void setOrderList(ArrayList<Order> orderList){
        this.orderList=orderList;
    }
    public ArrayList<Order> getOrderList(){
        return orderList;
    }
    public void setTransportationCost(int transportationCost){
        this.transportationCost=transportationCost;
    }
    public double getTransportationCost(){
        return transportationCost;
    }
    public void setTax(double tax){
        this.tax=tax;
    }
    public double getTax(){
        return tax;
    }
    public void setDiscount(double discount){
        this.discount=discount;
    }
    public double getDiscount(){
        return discount;
    }
    public void setClient(String client){
        this.client=client;
    }
    public String getClient(){
        return client;
    }
    public double DeliveryCost(){
        double totalCost = 0;
        for(int i = 0;i<orderList.size();i++){
           totalCost += orderList.get(i).getAmount()*Integer.parseInt(orderList.get(i).getProduct().getSellPrice());
        }
        totalCost+=transportationCost+tax-discount;
        return totalCost;
    }
}

