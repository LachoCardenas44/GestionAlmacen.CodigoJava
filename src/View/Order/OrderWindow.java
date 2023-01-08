package View.Order;

import java.awt.*;
import java.util.ArrayList;
import Model.*;
import View.Warehouse.FrmStartWarehouse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class OrderWindow extends JFrame{

    private FrmStartWarehouse grandpa;

    public OrderWindow(FrmStartWarehouse grandpa){

        this.grandpa=grandpa;
        setTitle("Orders");
        setSize(790, 490);
        setLocationRelativeTo(null); 
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        add(new ShowOrderPanel(this,grandpa));

    } 

public NewOrderPanel getNewOrderPanel(){
    return new NewOrderPanel(this,grandpa);
}
public void ChangePanel (JPanel newP){
    getContentPane().removeAll();
    setContentPane(newP);
    setSize(getWidth()+1,getHeight()+1);
    setSize(getWidth()-1,getHeight()-1);
}

public ShowOrderPanel getShowOrderPanel(){
    return new ShowOrderPanel(this,grandpa);
}

}
