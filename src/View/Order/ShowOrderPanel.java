package View.Order;

import Controller.ExternalAgents.Supplier;
import Controller.InOutOperations.*;
import java.awt.*;
import java.util.ArrayList;
import Model.*;
import View.Warehouse.FrmStartWarehouse;
import View.Warehouse.PnlChoice;
import View.Warehouse.PnlGetInSupplier;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.security.Guard;


public class ShowOrderPanel extends JPanel implements ActionListener,MouseListener{
    
    private OrderWindow daddy;
    private JButton cancelB;
    private JScrollPane jScrollPane1;
    private JTable table;
    private JLabel tittleL;
    private JButton valB;
    private FrmStartWarehouse grandpa;
    private Image image;
    private JButton orderB;
    private JButton closeB;
    int index = -1;
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Supplier> suppliers = new ArrayList<>();

    public ShowOrderPanel(OrderWindow daddy,FrmStartWarehouse grandpa){
        this.grandpa=grandpa;
        this.daddy=daddy;
        setLayout(null);
        initComponents();
    }

    public void initComponents(){


        orders = GuardarCargarDatos.LoadObject(orders, "src/data/"+grandpa.getWarehouse()+"order.dat");
        suppliers = GuardarCargarDatos.LoadObject(suppliers, "src/data/"+grandpa.getWarehouse()+"supplier.dat");

       
       
        tittleL = new JLabel();
        orderB = new JButton("New Order");
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        valB = new JButton();
        cancelB = new JButton();
        closeB = new JButton("Back");

        tittleL.setFont(new Font("Comic Sans MS", 2, 24));
        tittleL.setForeground(new Color(255, 255, 255));
        tittleL.setText("Order List");
        add(tittleL);
        tittleL.setBounds(340, 10, 130, 34);

        table.setBackground(new Color(242, 242, 242));
        table.addMouseListener(this);
        table.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Product","Supplier","Amount","Total Cost","Accepted"},orders.size())
        {
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for(int i = 0;i<orders.size();i++){
            table.setValueAt(orders.get(i).getProduct().getName(), i, 0);
            table.setValueAt(orders.get(i).getProduct().getSupplier(), i, 1);
            table.setValueAt(orders.get(i).getAmount(), i, 2);
            table.setValueAt(orders.get(i).CalculatedCost(), i, 3);
            if(orders.get(i).getValidate()){
                table.setValueAt("✔", i, 4);
            }else{
                table.setValueAt("✖", i, 4);
            }
           
        }
        
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 750, 290);

        valB.setText("Validate");
        valB.setForeground(new Color(255, 255, 255));
        valB.setBackground(new Color(52, 52, 52));
        add(valB);
        valB.setBounds(520, 380, 150, 40);
        valB.addActionListener(this);

        cancelB.setText("Cancel");
        cancelB.setForeground(new Color(255, 255, 255));
        cancelB.setBackground(new Color(52, 52, 52));
        add(cancelB);
        cancelB.setBounds(100, 380, 150, 40);
        cancelB.addActionListener(this);

        orderB.setBounds(285, 360, 200, 40);
        orderB.setBackground(new Color(52, 52, 52));
        orderB.setForeground(new Color(255,255,255));
        orderB.addActionListener(this);
        add(orderB);

        closeB.setBounds(285, 400, 200, 40);
        closeB.setBackground(new Color(52, 52, 52));
        closeB.setForeground(new Color(255,255,255));
        closeB.addActionListener(this);
        add(closeB);
        if(PnlChoice.agent=="Admin"){
            valB.setVisible(false);
            orderB.setBounds(520, 380, 150, 40);
        }else if(PnlChoice.agent=="Supplier"){
            orderB.setVisible(false);
            cancelB.setVisible(false);
            valB.setBounds(285, 360, 200, 40);
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try{
            image = ImageIO.read(new File("src/img/background.jpg")); 
        }catch(IOException e){
            System.out.println("La imagen no se encuentra");
        }
        
        g.drawImage(image, 0, 0, null);
        
    }
    public void ReloadTable(){
        table.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Product","Supplier","Amount","Total Cost","Accepted"},orders.size())
        {
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for(int i = 0;i<orders.size();i++){
            table.setValueAt(orders.get(i).getProduct().getName(), i, 0);
            table.setValueAt(orders.get(i).getProduct().getSupplier(), i, 1);
            table.setValueAt(orders.get(i).getAmount(), i, 2);
            table.setValueAt(orders.get(i).CalculatedCost(), i, 3);
            if(orders.get(i).getValidate()){
                table.setValueAt("✔", i, 4);
            }else{
                table.setValueAt("✖", i, 4);
            }
           
        }
        setSize(getWidth()+1,getHeight()+1);
        setSize(getWidth()-1,getHeight()-1);
    }


    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==orderB){
        daddy.ChangePanel(new NewOrderPanel(daddy,grandpa));
       }else if(e.getSource()==cancelB){
        if(index!=-1){
            orders.remove(index);
            GuardarCargarDatos.SaveObject(orders, "src/data/"+grandpa.getWarehouse()+"order.dat");
            ReloadTable();
            this.index=-1;
        }
       }else if(e.getSource()==valB){
        if(index!=-1){
            if(PnlGetInSupplier.supplier.equals(orders.get(index).getProduct().getSupplier())){

            orders.get(index).setValidate(true);
            GuardarCargarDatos.SaveObject(orders, "src/data/"+grandpa.getWarehouse()+"order.dat");
            ReloadTable();
            this.index=-1;

            }else{
            JOptionPane.showMessageDialog(null, "You can only validate the orders with your name", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
       }else if(e.getSource()==closeB){
        grandpa.toFront();
        daddy.dispose();
       }
        
    }

    public void mouseClicked(MouseEvent e) { 
    }
    public void mousePressed(MouseEvent e) {   
        if(e.getSource()==table){
            Point point = e.getPoint();
            this.index=table.rowAtPoint(point);
        }     
    }
    public void mouseReleased(MouseEvent e) {        
    }
    public void mouseEntered(MouseEvent e) {        
    }
    public void mouseExited(MouseEvent e) {        
    }
    
}
