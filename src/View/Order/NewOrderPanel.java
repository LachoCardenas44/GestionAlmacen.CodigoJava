package View.Order;

import java.awt.*;
import java.util.ArrayList;
import Model.*;
import View.Warehouse.FrmStartWarehouse;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import Controller.InOutOperations.Order;
import Controller.ProductsStock.Product;

public class NewOrderPanel extends JPanel implements ActionListener{

    private OrderWindow daddy;
    private Image image;
    private FrmStartWarehouse grandpa;
    private JTextField amoF;
    private JLabel amoL;
    private JButton endB;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextField prodF;
    private JLabel prodL;
    private JLabel tittleL;
    private JButton doneB;
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    public NewOrderPanel(OrderWindow daddy,FrmStartWarehouse grandpa){
        this.grandpa=grandpa;
        this.daddy=daddy;
        setLayout(null);
        initComponents();
    }
    public void initComponents(){

        products = GuardarCargarDatos.LoadObject(products, "src/data/"+grandpa.getWarehouse()+"product.dat");
        orders = GuardarCargarDatos.LoadObject(orders, "src/data/"+grandpa.getWarehouse()+"order.dat");
        System.out.println(grandpa.getWarehouse());
        tittleL = new JLabel();
        prodL = new JLabel();
        prodF = new JTextField();
        amoL = new JLabel();
        amoF = new JTextField();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        endB = new JButton();
        doneB = new JButton();

        tittleL.setFont(new Font("Comic Sans MS", 2, 28)); 
        tittleL.setForeground(new Color(255, 255, 255));
        tittleL.setText("New Order");
        add(tittleL);
        tittleL.setBounds(330, 10, 145, 34);

        prodL.setText("Product :");
        prodL.setFont(new Font("Comic Sans MS", 2, 24));
        prodL.setForeground(new Color(255, 255, 255));
        add(prodL);
        prodL.setBounds(90, 120, 190, 22);
        add(prodF);
        prodF.setBounds(40, 260, 190, 22);

        amoL.setText("Amount :");
        amoL.setFont(new Font("Comic Sans MS", 2, 24));
        amoL.setForeground(new Color(255, 255, 255));
        add(amoL);
        amoL.setBounds(580, 120, 190, 22);
        add(amoF);
        amoF.setBounds(525, 260, 190, 22);
        amoF.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(c > '9' || c < '0' ){
                    e.consume();
                }
            }
        });

        add(jSeparator1);
        jSeparator1.setBounds(0, 200, 770, 140);
        add(jSeparator2);
        jSeparator2.setBounds(0, 60, 770, 140);

        endB.setBackground(new Color(52, 52, 52));
        endB.setFont(new Font("Comic Sans MS", 2, 24)); 
        endB.setForeground(new Color(255, 255, 255));
        endB.setText("Back");
        add(endB);
        endB.setBounds(55, 375, 180, 60);
        endB.addActionListener(this);

        doneB.setBackground(new Color(52, 52, 52));
        doneB.setFont(new Font("Comic Sans MS", 2, 24)); 
        doneB.setForeground(new Color(255, 255, 255));
        doneB.setText("Done");
        add(doneB);
        doneB.setBounds(535, 375, 180, 60);
        doneB.addActionListener(this);

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
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==endB){
            daddy.ChangePanel(new ShowOrderPanel(daddy, grandpa));
        }else if(e.getSource()==doneB){
            int num = 0;
            for(int j = 0;j<amoF.getText().length();j++){
                num = (num*10)+(int)amoF.getText().charAt(j)-48;
                
            }
            
            for(int i = 0; i < products.size();i++){
                System.out.println(products.get(i).getName());
                if(amoF.getText().isEmpty()==false && prodF.getText().trim().equalsIgnoreCase(products.get(i).getName().trim())){
                    Order newo = new Order(products.get(i),num,false);
                    orders.add(newo);
                    GuardarCargarDatos.SaveObject(orders, "src/data/"+grandpa.getWarehouse()+"order.dat");
                    daddy.ChangePanel(new ShowOrderPanel(daddy, grandpa));
                }else if(amoF.getText().isEmpty() || prodF.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all the blanks", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
            JOptionPane.showMessageDialog(null, "The product you want to buy needs to be log in the system,"+"\n"+"please go to stock options and log the product first", "Warning", JOptionPane.WARNING_MESSAGE);
                }      
        
             }
        }
    }
}