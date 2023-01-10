package View.Warehouse;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import Controller.WareHouse.WareHouse;
import View.Admin.PnlAddClient;
import View.Admin.PnlAddProduct;
import View.Admin.PnlAddSupplier;
import View.Admin.PnlAgentManagment;
import View.Admin.PnlCreateAdminOrLogIn;
import View.Admin.PnlLogIn;
import View.Admin.PnlStock;
import View.Admin.PnlToCreateAdmin;

public class FrmStartWarehouse extends JFrame implements WindowFocusListener,WindowListener{    

    private String warehouse;
    private JPanel son = new JPanel();

    public FrmStartWarehouse (){

        this.warehouse="";       
        setType(Type.UTILITY);
        addWindowListener(this);
        setTitle("Warehouse Manager");
        setSize( 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);        
        addWindowFocusListener(this);
        ShowChoice();

    }
    public void ChangePanel (JPanel newP){
        getContentPane().removeAll();
        setContentPane(newP);
        setSize(getWidth()+1,getHeight()+1);
        setSize(getWidth()-1,getHeight()-1);
    }
    public String getWarehouse(){
        return warehouse;
    }
    public void setWarehouse(String warehouse){
        this.warehouse=warehouse;
    }

    public void resetSon() {
    
        remove(son);
		
		setSize(this.getWidth(),getHeight()-1);	
		setSize(this.getWidth(),getHeight()+1);

    }

    public void ShowChoice() {

        resetSon();
        son = new PnlChoice(this);
        add(son);
        
    }

    public void ShowCreateOrLog() {

        resetSon();
        son = new PnlCreateAdminOrLogIn(this);
        add(son);
        
    }

    public void ShowCreateAdmin() {

        resetSon();
        son = new PnlToCreateAdmin(this);
        add(son);
        
    }
     

    public void ShowLogin() {

        resetSon();
        son = new PnlLogIn(this);
        add(son);
        
    }

    public void ShowWarehouseOptions(int index, ArrayList<WareHouse> warehouses) {

        resetSon();
        son = new OptionPanel(this,index);
        ((OptionPanel) son).getWarehouseLabel().setText(warehouses.get(index).getName());
        add(son);
        
    }

    public void ShowWarehouseConsultation() {

        resetSon();
        son = new WarehousePanel(this);
        add(son);
        
    }

    public void ShowWareHouseConsultation() {

        resetSon();
        son = new WarehousePanel(this);
        add(son);
        
    }

    public void ShowAgentManagment(int index) {

        resetSon();
        son = new PnlAgentManagment(this, index);
        add(son);
        
    }

    public void ShowAddClient(PnlAgentManagment panel) {

        resetSon();
        son = new PnlAddClient(this, panel);
        add(son);
        
    }

    public void ShowAddSupplier(PnlAgentManagment panel) {

        resetSon();
        son = new PnlAddSupplier(this, panel);
        add(son);
        
    }

    public void ShowStock(int index) {

        resetSon();
        son = new PnlStock(this, index);
        add(son);
        
    }

    public void ShowAddProduct(PnlStock panel, ArrayList<WareHouse> warehouses, int index) {

        resetSon();
        son = new PnlAddProduct(this, panel, warehouses, index);
        add(son);
        
    }

    public void ShowGetInSupplier() {

        resetSon();
        son = new PnlGetInSupplier(this);
        add(son);
        
    }

    public void windowGainedFocus(WindowEvent e) {
        setEnabled(true);
    }
    public void windowLostFocus(WindowEvent e) {
        
    }
    
    public void windowOpened(WindowEvent e) {  
    }
    
    public void windowClosing(WindowEvent e) {
    }
    
    public void windowClosed(WindowEvent e) {
    }
    
    public void windowIconified(WindowEvent e) {
       
    }
    
    public void windowDeiconified(WindowEvent e) {  
    }
  
    public void windowActivated(WindowEvent e) {
       
    }
    
    public void windowDeactivated(WindowEvent e) {   
    }
        
}