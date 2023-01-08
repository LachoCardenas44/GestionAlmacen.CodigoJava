package View.Delivery;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

import Model.*;
import javax.swing.*;
import View.*;
import View.Warehouse.FrmStartWarehouse;
import View.Warehouse.PnlChoice;

import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import Controller.InOutOperations.Delivery;

public  class ShowDeliveryPanel extends JPanel implements ActionListener,MouseListener{

    private JLabel headerL;
    private JTable table;
    private JButton newDeliveryB;
    private JButton backB;
    private JButton infoB;
    private JButton deleteB;
    private JTextField disF;
    private JLabel disL;
    private JScrollPane jScrollPane2;
    private JTable pTable;
    private JTextField taxF;
    private JLabel taxL;
    private JTextField transpF;
    private JLabel transpL;
    private DeliveryWindow daddy;
    private ArrayList<Delivery> deliveries = new ArrayList<>();
    private JScrollPane scrollPane;
    private FrmStartWarehouse grandpa;
    private Image image;
    private int index=-1;
    

    public ShowDeliveryPanel (DeliveryWindow daddy,FrmStartWarehouse grandpa){
        this.daddy=daddy;
        this.grandpa=grandpa;
        setVisible(true);
        setLayout(null);
        anitComponents();
    }
    public void anitComponents(){

        

        jScrollPane2 = new JScrollPane();
        pTable = new JTable();
        transpL = new JLabel();
        transpF = new JTextField();
        taxL = new JLabel();
        taxF = new JTextField();
        disL = new JLabel();
        disF = new JTextField();

        

        deliveries = GuardarCargarDatos.LoadObject(deliveries, "src/data/"+grandpa.getWarehouse()+"delivery.dat");
        
        headerL = new JLabel("Delivery List");
        newDeliveryB = new JButton("New Delivery");
        backB = new JButton("Back");

        headerL.setFont(new Font("Comic Sans MS", 2,30)); 
        headerL.setForeground(new Color(255,255,255));
        add(headerL);
        headerL.setBounds(280, 0, 180, 34);

        pTable.setBackground(new Color(242,242,242));
        jScrollPane2.setViewportView(pTable);
        jScrollPane2.setBounds(10, 50, 120, 110);
        add(jScrollPane2);

        transpL.setText("Transportation Cost");
        transpL.setForeground(new Color(255,255,255));
        add(transpL);
        transpL.setBounds(630, 50, 140, 20);

        transpF.setText("");
        add(transpF);
        transpF.setEditable(false);
        transpF.setBounds(630, 80, 120, 22);

        taxL.setText("Tax");
        taxL.setForeground(new Color(255,255,255));
        add(taxL);
        taxL.setBounds(630, 350, 100, 16);

        taxF.setText("");
        add(taxF);
        taxF.setEditable(false);
        taxF.setBounds(630, 380, 120, 22);

        disL.setText("Discount");
        disL.setForeground(new Color(255,255,255));
        add(disL);
        disL.setBounds(20, 350, 70, 16);

        disF.setText("");
        add(disF);
        disF.setEditable(false);
        disF.setBounds(20, 380, 110, 22);

        table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Client","Total Cost"},deliveries.size())
        {
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for(int i = 0;i<deliveries.size();i++){
            table.setValueAt(deliveries.get(i).getClient(), i, 0);
            table.setValueAt(deliveries.get(i).DeliveryCost(),i,1);
        }
        table.setBackground(new Color(242,242,242));
        table.addMouseListener(this);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(150, 45, 470, 370);
        add(scrollPane);

        
        deleteB=new JButton("Delete");
        deleteB.setBounds(50, 230, 70, 30);
        deleteB.setBackground(new Color(52,52,52));
        deleteB.setForeground(new Color(255,255,255));
        deleteB.addActionListener(this);
        add(deleteB);
        

        newDeliveryB.setBounds(150, 420, 235, 30);
        newDeliveryB.setBackground(new Color(52,52,52));
        newDeliveryB.setForeground(new Color(255,255,255));
        add(newDeliveryB);
        newDeliveryB.addActionListener(this);

        backB.setBounds(385, 420, 235, 30);
        backB.setBackground(new Color(52,52,52));
        backB.setForeground(new Color(255,255,255));
        add(backB);
        backB.addActionListener(this);

        if(PnlChoice.agent.equals("Client")){
            deleteB.setVisible(false);
            newDeliveryB.setVisible(false);
            backB.setBounds(150, 420, 470, 30);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backB){
        grandpa.toFront();
        daddy.dispose();
        }else if(e.getSource()==newDeliveryB){
            daddy.ChangePanel(new NewDeliveryPanel(daddy,grandpa));
        }else if(e.getSource()==deleteB){
            if(index!=-1){
            deliveries.remove(index);
            ReloadTable();
            this.index=-1;
            transpF.setText("");
            taxF.setText("");
            disF.setText("");
            pTable.setModel(new DefaultTableModel(new String[]{"Product","Amount"},0){
                public boolean isCellEditable(int row,int column){
                    return false;
                }
            });
            }
        }
        
    }
    public void ReloadTable(){
        table.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Client","Total Cost"},deliveries.size())
        {
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for(int i = 0;i<deliveries.size();i++){
            table.setValueAt(deliveries.get(i).getClient(), i, 0);
            table.setValueAt(deliveries.get(i).DeliveryCost(),i,1);
        }
    }
    public void LoadTable(){
        pTable.setModel(new DefaultTableModel(new String[]{"Product","Amount"},deliveries.get(index).getOrderList().size()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for(int i = 0;i<deliveries.get(index).getOrderList().size();i++){
            pTable.setValueAt(deliveries.get(index).getOrderList().get(i).getProduct().getName(), i, 0);
            pTable.setValueAt(deliveries.get(index).getOrderList().get(i).getAmount(), i, 1);
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
    
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==table){
            Point point = e.getPoint();
            this.index=table.rowAtPoint(point);
            transpF.setText(deliveries.get(index).getTransportationCost()+"");
            taxF.setText(deliveries.get(index).getTax()+"");
            disF.setText(deliveries.get(index).getDiscount()+"");
            LoadTable();
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
        }
    }
    
    public void mousePressed(MouseEvent e) {
        
        
    }
   
    public void mouseReleased(MouseEvent e) {
       
        
    }
    
    public void mouseEntered(MouseEvent e) {
        
        
    }
    
    public void mouseExited(MouseEvent e) {
        
        
    }
}