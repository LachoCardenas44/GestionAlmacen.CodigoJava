package View.Delivery;

import java.awt.*;
import Model.*;
import java.util.ArrayList;
import java.util.Calendar;
import View.*;
import View.Warehouse.FrmStartWarehouse;
import Controller.InOutOperations.*;
import Controller.ProductsStock.*;
import Controller.ExternalAgents.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public  class NewDeliveryPanel extends JPanel implements ActionListener, MouseListener{

    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Delivery> deliveries = new ArrayList<>();
    private FrmStartWarehouse grandpa;
    private JButton addProductB;
    private JButton showCostB;
    private JButton backB;
    private JTextField amountF;
    private JLabel amountL;
    private JButton checkDiscountB;
    private JButton checkTaxB;
    private JButton checkTransportB;
    private JButton uncheckDiscountB;
    private JButton uncheckTaxB;
    private JButton uncheckTransportB;
    private JComboBox<String> clientBox;
    private JTextField discountF;
    private JLabel discountL;
    private JButton finishB;
    private JScrollPane jScrollPane1;
    private JTextField productF;
    private JLabel productL;
    private JTable table;
    private JTextField taxF;
    private JLabel taxL;
    private JLabel tittleL;
    private JLabel totalCostL;
    private JTextField transportationCostF;
    private JLabel transportationCostL;
    private double transpProd = 0;
    private double taxProd = 0;
    private double discountProd = 0;
    private JButton deleteB;
    private JButton modifyB;
    private JButton closeB;
    private DeliveryWindow daddy;
    private Image image;
    String clientDataPath = "";
    String productDataPath = "";
    String deliveryDataPath ="";
    int index = -1;
    Calendar calendar = Calendar.getInstance();



    public NewDeliveryPanel(DeliveryWindow daddy,FrmStartWarehouse grandpa){
        this.daddy=daddy;
        this.grandpa=grandpa;
        setLayout(null);
        initComponents();
    }
    public void initComponents(){

        clientDataPath = "src/data/"+grandpa.getWarehouse()+"client.dat";
        productDataPath = "src/data/"+grandpa.getWarehouse()+"product.dat";
        deliveryDataPath ="src/data/"+grandpa.getWarehouse()+"delivery.dat";
        tittleL = new JLabel();
        deleteB = new JButton("Delete");
        modifyB = new JButton("Modify");
        productL = new JLabel();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        productF = new JTextField();
        addProductB = new JButton();
        showCostB = new JButton("Show Cost");
        backB = new JButton("Back");
        amountL = new JLabel();
        amountF = new JTextField();
        checkTransportB = new JButton();
        checkDiscountB = new JButton();
        uncheckTransportB = new JButton();
        closeB = new JButton("Back");
        uncheckDiscountB = new JButton();
        transportationCostL = new JLabel();
        transportationCostF = new JTextField();
        taxL = new JLabel();
        taxF = new JTextField();
        discountL = new JLabel();
        discountF = new JTextField();
        checkTaxB = new JButton();
        uncheckTaxB = new JButton();
        totalCostL = new JLabel();
        clientBox = new JComboBox<>();
        finishB = new JButton();

        
        
        
        
        this.addMouseListener(this);
        
        clients = GuardarCargarDatos.LoadObject(clients, clientDataPath);
        products = GuardarCargarDatos.LoadObject(products, productDataPath);
        deliveries = GuardarCargarDatos.LoadObject(deliveries, deliveryDataPath);
    

        tittleL.setFont(new Font("Comic Sans MS", 2, 24)); 
        tittleL.setForeground(new Color(255,255,255));
        tittleL.setText("New Delivery ");
        add(tittleL);
        tittleL.setBounds(90, 0, 156, 34);

        productL.setFont(new Font("Comic Sans MS", 2, 12)); 
        productL.setText("Add Product");
        productL.setForeground(new Color(255,255,255));
        add(productL);
        productL.setBounds(40, 350, 70, 18);

        closeB.setBackground(new Color(52,52,52));
        closeB.setForeground(new Color(255,255,255));
        closeB.setBounds(400, 400, 130, 30);
        closeB.addActionListener(this);
        add(closeB);

        table.setBackground(new Color(242, 242, 242)); 
        table.addMouseListener(this);       
        jScrollPane1.setViewportView(table);
        
        add(jScrollPane1);
        jScrollPane1.setBounds(40, 50, 260, 280);
        add(productF);
        productF.setBounds(40, 370, 110, 22);

        addProductB.setBackground(new Color(52, 52, 52));
        addProductB.setForeground(new Color(255,255,255));
        addProductB.setText("✔");
        add(addProductB);
        addProductB.setBounds(40, 400, 260, 30);
        addProductB.addActionListener(this);

        amountL.setFont(new Font("Comic Sans MS", 2, 12)); 
        amountL.setText("Add Amount");
        amountL.setBounds(180, 350, 90, 21);
        amountL.setForeground(new Color(255,255,255));
        amountF.setBounds(180, 370, 120, 22);
        add(amountL);
        add(amountF);
        amountF.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(c > '9' || c < '0' ){
                    e.consume();
                }
            }
        });
       

        checkTransportB.setBackground(new Color(52, 52, 52));
        checkTransportB.setForeground(new Color(255,255,255));
        checkTransportB.setText("✔");
        add(checkTransportB);
        checkTransportB.setBounds(600, 100, 45, 30);
        checkTransportB.addActionListener(this);

        checkDiscountB.setBackground(new Color(52, 52, 52));
        checkDiscountB.setForeground(new Color(255,255,255));
        checkDiscountB.setText("✔");
        add(checkDiscountB);
        checkDiscountB.setBounds(600, 300, 45, 30);
        checkDiscountB.addActionListener(this);

        uncheckTransportB.setBackground(new Color(52, 52, 52));
        uncheckTransportB.setForeground(new Color(255,255,255));
        uncheckTransportB.setText("✖");
        uncheckTransportB.setBounds(600, 100, 45, 30);
        uncheckTransportB.addActionListener(this);

        uncheckDiscountB.setBackground(new Color(52, 52, 52));
        uncheckDiscountB.setForeground(new Color(255,255,255));
        uncheckDiscountB.setText("✖");
        uncheckDiscountB.setBounds(600, 300, 45, 30);
        uncheckDiscountB.addActionListener(this);

        deleteB.setFont(new Font("Comic Sans MS", 2, 30)); 
        deleteB.setBackground(new Color(52, 52, 52));
        deleteB.setForeground(new Color(255,255,255));
        deleteB.setBounds(325, 50, 400, 80);
        deleteB.addActionListener(this);

        modifyB.setFont(new Font("Comic Sans MS", 2, 30)); 
        modifyB.setBackground(new Color(52, 52, 52));
        modifyB.setForeground(new Color(255,255,255));
        modifyB.setBounds(325, 250, 400, 80);
        modifyB.addActionListener(this);

        transportationCostL.setFont(new Font("Comic Sans MS", 2, 12)); 
        transportationCostL.setText("Set Transportation Cost");
        transportationCostL.setForeground(new Color(255,255,255));
        add(transportationCostL);
        transportationCostL.setBounds(450, 80, 140, 18);
        add(transportationCostF);
        transportationCostF.setBounds(450, 100, 140, 30);
        transportationCostF.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(c > '9' || c < '0' ){
                    e.consume();
                }
            }
        });

        taxL.setFont(new Font("Comic Sans MS", 2, 12)); 
        taxL.setText("Set Tax");
        taxL.setForeground(new Color(255,255,255));
        add(taxL);
        taxL.setBounds(450, 180, 140, 18);
        add(taxF);
        taxF.setBounds(450, 200, 140, 30);
        taxF.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(c > '9' || c < '0' ){
                    e.consume();
                }
            }
        });

        discountL.setFont(new Font("Comic Sans MS", 2, 12)); 
        discountL.setText("Set Discount");
        discountL.setForeground(new Color(255,255,255));
        add(discountL);
        discountL.setBounds(450, 280, 140, 18);

        add(discountF);
        discountF.setBounds(450, 300, 140, 30);
        discountF.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(c > '9' || c < '0' ){
                    e.consume();
                }
            }
        });

        checkTaxB.setBackground(new Color(52, 52, 52));
        checkTaxB.setForeground(new Color(255,255,255));
        checkTaxB.setText("✔");
        add(checkTaxB);
        checkTaxB.setBounds(600, 200, 45, 30);
        checkTaxB.addActionListener(this);

        uncheckTaxB.setBackground(new Color(52, 52, 52));
        uncheckTaxB.setForeground(new Color(255,255,255));
        uncheckTaxB.setText("✖");
        uncheckTaxB.setBounds(600, 200, 45, 30);
        uncheckTaxB.addActionListener(this);
        

        totalCostL.setFont(new Font("Impact", 2, 24)); 
        totalCostL.setForeground(new Color(255,255,255));
        totalCostL.setText("0.00");
        add(totalCostL);
        totalCostL.setBounds(540, 340, 90, 50);

        clientBox.setMaximumRowCount(clients.size());
        clientBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        for(int j = 0;j<clients.size();j++){
            clientBox.addItem(clients.get(j).getName());
        }
        add(clientBox);
        clientBox.setBounds(450, 10, 170, 22);
        clientBox.setBackground(new Color(52, 52, 52));
        clientBox.setForeground(new Color(255,255,255));

        finishB.setBackground(new Color(52, 52, 52));
        finishB.setFont(new Font("Comic Sans MS", 2, 12)); 
        finishB.setForeground(new Color(255,255,255));
        finishB.setText("Finish");
        add(finishB);
        finishB.setBounds(680, 370, 80, 70);
        finishB.addActionListener(this);

        showCostB.setFont(new Font("Comic Sans MS", 2, 12)); 
        showCostB.setForeground(new Color(255,255,255));
        showCostB.setBackground(new Color(52, 52, 52));
        add(showCostB);
        showCostB.setBounds(400, 350, 130, 32);
        showCostB.addActionListener(this);       
       
       
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addProductB){
            int num1 = 0;
            for(int j = 0;j<amountF.getText().length();j++){
                num1 = (num1*10)+(int)amountF.getText().charAt(j)-48;
                
            }
             for(int i = 0; i < products.size();i++){
                
                if(amountF.getText().isEmpty()==false && productF.getText().trim().equalsIgnoreCase(products.get(i).getName().trim())){                 
                orders.add(new Order(products.get(i),num1,true));
                ReloadTable();
                } 
            }
        }else if(e.getSource()==checkTransportB && transportationCostF.getText().isEmpty()==false){
            remove(checkTransportB);
            add(uncheckTransportB);
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
            transportationCostF.setEditable(false);
            double num2 = 0;
            for(int j = 0;j<transportationCostF.getText().length();j++){
                num2 = (num2*10)+(double)transportationCostF.getText().charAt(j)-48;
                
            }
            this.transpProd=num2;
        }else if(e.getSource()==checkTaxB && taxF.getText().isEmpty()==false){

            remove(checkTaxB);
            add(uncheckTaxB);
            taxF.setEditable(false);
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
            int num3 = 0;
            for(int j = 0;j<taxF.getText().length();j++){
                num3 = (num3*10)+(int)taxF.getText().charAt(j)-48;
                
            }
            this.taxProd=num3;
        }else if(e.getSource()==checkDiscountB && discountF.getText().isEmpty()==false){
            remove(checkDiscountB);
            add(uncheckDiscountB);
            discountF.setEditable(false);
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
            double num4 = 0;
            for(int j = 0;j<discountF.getText().length();j++){
                num4 = (num4*10)+(double)discountF.getText().charAt(j)-48;
                
            }
            this.discountProd=num4;
        }else if(e.getSource()==uncheckTransportB){
            remove(uncheckTransportB);
            add(checkTransportB);
            transportationCostF.setEditable(true);
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
        }else if(e.getSource()==uncheckTaxB){
            remove(uncheckTaxB);
            add(checkTaxB);
            taxF.setEditable(true);
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
        }else if(e.getSource()==uncheckDiscountB){
            remove(uncheckDiscountB);
            add(checkDiscountB);
            discountF.setEditable(true);
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
        }else if(e.getSource()==finishB){
            
            if(transportationCostF.isEditable()==false && taxF.isEditable()==false && orders.size()!=0){
              
                Delivery newd = new Delivery(orders, transpProd, taxProd, discountProd,(String)clientBox.getSelectedItem());
                
                deliveries.add(newd);
                GuardarCargarDatos.SaveObject(deliveries, deliveryDataPath);
                daddy.ChangePanel(new ShowDeliveryPanel(daddy,grandpa));
        
                }
        }else if(e.getSource()== backB){
                daddy.dispose();
        }else if(e.getSource()==showCostB){
            if(transportationCostF.isEditable()==false && taxF.isEditable()==false && orders.size()!=0){
                Delivery newd = new Delivery(orders, transpProd, taxProd, discountProd,(String)clientBox.getSelectedItem());
                totalCostL.setText(newd.DeliveryCost()+"");
            }
        }else if(e.getSource()==deleteB){
          
            remove(deleteB);
            remove(modifyB);
            amountL.setBounds(180, 350, 90, 21);
            amountF.setBounds(180, 370, 120, 22);
            orders.remove(index);
            ReloadTable();
            this.index=-1;
            add(productL);add(productF);add(transportationCostF);add(transportationCostL);add(taxF);add(taxL);
            add(discountF);add(discountL);add(showCostB);add(totalCostL);add(finishB);add(addProductB);add(clientBox);add(amountF);add(amountL);add(closeB);
            checkDiscountB.setVisible(true);
            checkTaxB.setVisible(true);
            checkTransportB.setVisible(true);
            uncheckDiscountB.setVisible(true);
            uncheckTaxB.setVisible(true);
            uncheckTransportB.setVisible(true);
            tittleL.setText("New Delivery");
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
          
        }else if(e.getSource()==modifyB){
            int newA = 0;
            remove(deleteB);
            remove(modifyB);
            amountL.setBounds(180, 350, 90, 21);
            amountF.setBounds(180, 370, 120, 22);
            if(amountF.getText().isEmpty()){
                orders.get(index).setAmount(newA);
            }else{
                for(int j = 0;j<amountF.getText().length();j++){
                    newA = (newA*10)+(int)amountF.getText().charAt(j)-48;    
                }
                orders.get(index).setAmount(newA);
            }
            ReloadTable();
            this.index=-1;
            add(productL);add(productF);add(transportationCostF);add(transportationCostL);add(taxF);add(taxL);
            add(discountF);add(discountL);add(showCostB);add(totalCostL);add(finishB);add(addProductB);add(clientBox);add(amountF);add(amountL);add(closeB);
            checkDiscountB.setVisible(true);
            checkTaxB.setVisible(true);
            checkTransportB.setVisible(true);
            uncheckDiscountB.setVisible(true);
            uncheckTaxB.setVisible(true);
            uncheckTransportB.setVisible(true);
            tittleL.setText("New Delivery");
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);
          
        }else if(e.getSource()==closeB){
            daddy.ChangePanel(new ShowDeliveryPanel(daddy, grandpa));
        }
    }
        
    public void ReloadTable(){
        table.setModel(new DefaultTableModel(new String[]{"Product","Amount"},orders.size()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for(int i = 0;i<orders.size();i++){
            table.setValueAt(orders.get(i).getProduct().getName(), i, 0);
            table.setValueAt(orders.get(i).getAmount(), i, 1);
            
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
            remove(productL);
            remove(productF);
            remove(transportationCostF);
            remove(transportationCostL);
            remove(taxF);
            remove(taxL);
            remove(discountF);
            remove(discountL);
            remove(showCostB);
            remove(totalCostL);
            remove(closeB);
            remove(finishB);
            checkDiscountB.setVisible(false);
            checkTaxB.setVisible(false);
            checkTransportB.setVisible(false);
            uncheckDiscountB.setVisible(false);
            uncheckTaxB.setVisible(false);
            uncheckTransportB.setVisible(false);
            remove(addProductB);
            remove(clientBox);
            amountL.setBounds(192, 360, 192, 60);
            amountF.setBounds(386, 360, 192, 60);
            add(deleteB);
            add(modifyB);
            tittleL.setText("Modifying");
            setSize(getWidth()+1,getHeight()+1);
            setSize(getWidth()-1,getHeight()-1);



        }else if(e.getSource()==this){
            System.out.println("screen");
            this.index=-1;
            add(productL);
            add(productF);
            add(transportationCostF);
            add(transportationCostL);
            add(taxF);
            add(taxL);
            add(discountF);
            add(discountL);
            add(showCostB);
            add(totalCostL);
            add(finishB);
            checkDiscountB.setVisible(true);
            checkTaxB.setVisible(true);
            checkTransportB.setVisible(true);
            uncheckDiscountB.setVisible(true);
            uncheckTaxB.setVisible(true);
            uncheckTransportB.setVisible(true);
            add(addProductB);
            add(clientBox);
            amountL.setBounds(180, 350, 90, 21);
            amountF.setBounds(180, 370, 120, 22);
            remove(deleteB);
            remove(modifyB);
            tittleL.setText("New Delivery");
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