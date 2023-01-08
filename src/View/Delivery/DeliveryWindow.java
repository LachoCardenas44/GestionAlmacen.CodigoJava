package View.Delivery;


import java.awt.*;
import java.util.ArrayList;
import Model.*;
import View.*;
import View.Warehouse.FrmStartWarehouse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class DeliveryWindow extends JFrame{

    private FrmStartWarehouse grandpa;
    

    public DeliveryWindow(FrmStartWarehouse grandpa){
        this.grandpa=grandpa;
        setTitle("DeliveryMaker");
        setSize(790, 490);
        setLocationRelativeTo(null); 
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        add(new ShowDeliveryPanel(this,grandpa));   

    } 

public NewDeliveryPanel getNewDeliveryPanel(){
    return new NewDeliveryPanel(this,grandpa);
}
public void ChangePanel (JPanel newP){
    getContentPane().removeAll();
    setContentPane(newP);
    setSize(getWidth()+1,getHeight()+1);
    setSize(getWidth()-1,getHeight()-1);
}

public ShowDeliveryPanel getShowDeliveryPanel(){
    return new ShowDeliveryPanel(this,grandpa);
}

}

