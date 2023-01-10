package View.Admin;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import Controller.ExternalAgents.Client;
import Controller.ExternalAgents.Supplier;
import Controller.WareHouse.WareHouse;
import Model.GuardarCargarDatos;
import View.Warehouse.FrmStartWarehouse;

import java.awt.event.*;

public class PnlAgentManagment extends JPanel implements ActionListener, MouseInputListener{

    private FrmStartWarehouse pater;    
    private int index;   


    private JButton btnAddClient;
    private JButton btnAddSupplier;
    private JButton btnDeleteClient;
    private JButton btnDeleteSupplier;   
    private JButton btnBack;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JList<String> jlClient;
    private JList<String> jlSupplier;
    private JLabel lbAgents;
    private JLabel lbClients;
    private JLabel lbSupplier;
    private JLabel lbCISupplier;
    private JLabel lbCiClients;    
    private JLabel lbNumberCISupplier;
    private JLabel lbNumberCiClients;
    private ArrayList<WareHouse> warehouses = new ArrayList<>(){};
    private ArrayList<Client> clients = new ArrayList<>(){};
    private ArrayList<Supplier> suppliers = new ArrayList<>(){};   


    public PnlAgentManagment(FrmStartWarehouse pater, int index) {

        this.pater = pater;
        this.index = index;
       
        lbSupplier = new JLabel();
        jScrollPane2 = new JScrollPane();
        jlSupplier = new JList<>();
        jScrollPane3 = new JScrollPane();
        jlClient = new JList<>();
        lbAgents = new JLabel();
        lbClients = new JLabel();
        lbNumberCISupplier = new JLabel();
        lbNumberCiClients = new JLabel();
        lbCISupplier = new JLabel();
        lbCiClients = new JLabel();        
        btnDeleteSupplier = new JButton();
        btnAddClient = new JButton();
        btnDeleteClient = new JButton();
        btnAddSupplier = new JButton();  
        btnBack = new JButton();      
        

        warehouses = GuardarCargarDatos.LoadObject(warehouses,"src/data/wareh.dat");
        clients = GuardarCargarDatos.LoadObject(clients,"src/data/"+ warehouses.get(index).getName() +"client.dat" );               
        suppliers = GuardarCargarDatos.LoadObject(suppliers, "src/data/"+ warehouses.get(index).getName() +"supplier.dat");

        setBackground(new java.awt.Color(52, 52, 52));
        setForeground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(800, 600));        
        setLayout(null);
       

        lbSupplier.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); 
        lbSupplier.setForeground(new java.awt.Color(153, 153, 153));
        lbSupplier.setText("Suppliers"); 
        lbSupplier.setBounds(530, 140, 110, 30);
        add(lbSupplier);
        
        
        jlSupplier.setBackground(new java.awt.Color(204, 204, 204));
        jlSupplier.setForeground(new java.awt.Color(51, 51, 51));
        jlSupplier.setModel(new AbstractListModel<String>() {           
            private ArrayList<Supplier> strings = suppliers;
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i).getName(); }
        });
        jlSupplier.addMouseListener(this);
        add(jlSupplier);


        jScrollPane2.setViewportView(jlSupplier);
        jScrollPane2.setBounds(480, 180, 210, 160);
        add(jScrollPane2);



        jlClient.setBackground(new java.awt.Color(204, 204, 204));
        jlClient.setForeground(new java.awt.Color(51, 51, 51));
        jlClient.setModel(new javax.swing.AbstractListModel<String>() {
            private ArrayList<Client> strings = clients;
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i).getName(); }
        });
        jlClient.addMouseListener(this);
        add(jlClient);


        jScrollPane3.setViewportView(jlClient);
        jScrollPane3.setBounds(110, 180, 210, 160);
        add(jScrollPane3);


        lbAgents.setBackground(new java.awt.Color(255, 255, 255));
        lbAgents.setFont(new java.awt.Font("Comic Sans MS", 0, 48));
        lbAgents.setForeground(new java.awt.Color(255, 255, 255));
        lbAgents.setText("Agents");        
        lbAgents.setBounds(320, 40, 157, 70);
        add(lbAgents);


        lbClients.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); 
        lbClients.setForeground(new java.awt.Color(153, 153, 153));
        lbClients.setText("Clients");
        lbClients.setBounds(170, 140, 76, 30);
        add(lbClients);
        

        lbCISupplier.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbCISupplier.setForeground(new java.awt.Color(153, 153, 153));
        lbCISupplier.setText("CI:");
        lbCISupplier.setBounds(490, 350, 30, 30);
        add(lbCISupplier);



        lbCiClients.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbCiClients.setForeground(new java.awt.Color(153, 153, 153));
        lbCiClients.setText("CI:");
        lbCiClients.setBounds(120, 350, 30, 30);
        add(lbCiClients);



        lbNumberCiClients.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbNumberCiClients.setForeground(new java.awt.Color(0, 0, 0));
        lbNumberCiClients.setText("...");
        lbNumberCiClients.setBounds(160, 350, 150, 30);        
        add(lbNumberCISupplier);



        lbNumberCISupplier.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lbNumberCISupplier.setForeground(new java.awt.Color(0, 0, 0));
        lbNumberCISupplier.setText("...");
        lbNumberCISupplier.setBounds(530, 350, 150, 30);        
        add(lbNumberCiClients);



        btnDeleteSupplier.setBackground(new java.awt.Color(28, 28, 28));
        btnDeleteSupplier.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); 
        btnDeleteSupplier.setForeground(new java.awt.Color(204, 204, 204));
        btnDeleteSupplier.setText("Delete");
        btnDeleteSupplier.setBorder(null);
        btnDeleteSupplier.setBounds(610, 400, 80, 50);
        btnDeleteSupplier.addActionListener(this);
        add(btnDeleteSupplier);


        btnAddClient.setBackground(new java.awt.Color(28, 28, 28));
        btnAddClient.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); 
        btnAddClient.setForeground(new java.awt.Color(204, 204, 204));
        btnAddClient.setText("Add");
        btnAddClient.setBorder(null);
        btnAddClient.setBounds(110, 400, 80, 50);
        btnAddClient.addActionListener(this);
        add(btnAddClient);



        btnDeleteClient.setBackground(new java.awt.Color(28, 28, 28));
        btnDeleteClient.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); 
        btnDeleteClient.setForeground(new java.awt.Color(204, 204, 204));
        btnDeleteClient.setText("Delete");
        btnDeleteClient.setBorder(null);
        btnDeleteClient.setBounds(240, 400, 80, 50);
        btnDeleteClient.addActionListener(this);
        add(btnDeleteClient);


        btnAddSupplier.setBackground(new java.awt.Color(28, 28, 28));
        btnAddSupplier.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); 
        btnAddSupplier.setForeground(new java.awt.Color(204, 204, 204));
        btnAddSupplier.setText("Add");
        btnAddSupplier.setBorder(null);
        btnAddSupplier.setBounds(480, 400, 80, 50);        
        btnAddSupplier.addActionListener(this);
        add(btnAddSupplier);

        
        btnBack.setBackground(new java.awt.Color(28, 28, 28));
        btnBack.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(204, 204, 204));
        btnBack.setText("Back");
        btnBack.setActionCommand("Back");
        btnBack.setBorder(null);
        btnBack.setBounds(0, 510, 800, 50);
        btnBack.addActionListener(this);
        add(btnBack);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }


    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }


    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }


    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public ArrayList<WareHouse> getWarehouses() {
        return warehouses;
    }

    public int getIndex() {
        return index;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnBack) {
            
            pater.ShowWarehouseOptions(index, warehouses);

        }  else if (e.getSource() == btnAddClient) {

            pater.ShowAddClient(this);
            
        } else if (e.getSource() == btnDeleteClient) {

            if (clients.size() == 0) {
				
			} else {

                clients.remove(jlClient.getSelectedIndex());
                GuardarCargarDatos.SaveObject(clients, "src/data/"+ warehouses.get(index).getName() +"client.dat");
                pater.ShowAgentManagment(index);

			}
                       
            
        } else if (e.getSource() == btnAddSupplier) {

            pater.ShowAddSupplier(this);
            
        } else if (e.getSource() == btnDeleteSupplier) {

            if (suppliers.size() == 0) {
				
			} else {

                suppliers.remove(jlSupplier.getSelectedIndex());
                GuardarCargarDatos.SaveObject(suppliers, "src/data/"+ warehouses.get(index).getName() +"supplier.dat");
                pater.ShowAgentManagment(index);

			}            
            
        } else {

            pater.ShowWarehouseOptions(index, warehouses);
            
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        if (e.getSource() == jlClient) {

            if (clients.size() == 0) {
				
			} else {

                lbNumberCiClients.setText(clients.get(jlClient.getSelectedIndex()).getId());

			}                        
            
        } else {

            if (suppliers.size() == 0) {
				
			} else {

                lbNumberCISupplier.setText(suppliers.get(jlSupplier.getSelectedIndex()).getId()); 

			}                      
            
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    
}

