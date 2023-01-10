package View.Warehouse;
import View.Delivery.*;
import View.Order.OrderWindow;
import Model.*;import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import Controller.WareHouse.*;
import java.io.*;
import java.util.ArrayList;

public class OptionPanel extends JPanel implements ActionListener {

    private JButton deliveryButton;
    private JButton stockButton;
    private JButton agentsMButton;
    private JLabel  warehosueLabel;
    private JScrollPane scroll;
    private JButton orderButton;
    private JButton infoB;
    private FrmStartWarehouse daddy;
    private ArrayList<WareHouse> warehouses = new ArrayList<>(){};
    private int indexx ;
    private Image delivery;
    private Image order;
    private Image agents;
    private Image background;
    private Image stock;
    
    public OptionPanel(FrmStartWarehouse daddy,int index){
        
        
        this.daddy=daddy;
        this.indexx=index;
        setLayout(null);
        initComponents();
        setSize(getWidth()+1,getHeight()+1);
        setSize(getWidth()-1,getHeight()-1);
        
    }

    public void initComponents() {
        System.out.println(daddy.getWarehouse());
        infoB = new JButton();
        deliveryButton = new JButton();
        orderButton = new JButton();
        stockButton = new JButton();
        agentsMButton = new JButton();
        warehosueLabel = new JLabel();
        scroll = new JScrollPane();
        
       warehouses = GuardarCargarDatos.LoadObject(warehouses, "src/data/wareh.dat");

        infoB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        infoB.setBackground(new Color(52, 52, 52));
        infoB.setFont(new Font("Comic Sans MS", 3, 15)); 
        infoB.setForeground(new Color(255, 255, 255));
        infoB.setText("Info");
        infoB.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        infoB.setBounds(0, 110, 785, 60);
        infoB.addActionListener(this);
        add(infoB);

        deliveryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deliveryButton.setBackground(new Color(52, 52, 52));
        deliveryButton.setFont(new Font("Comic Sans MS", 3, 15)); 
        deliveryButton.setForeground(new Color(255, 255, 255));
        deliveryButton.setText("Deliveries");
        deliveryButton.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        deliveryButton.setBounds(0, 360, 193, 80);
        deliveryButton.addActionListener(this);            
        add(deliveryButton);

        orderButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        orderButton.setBackground(new Color(52, 52, 52));
        orderButton.setFont(new Font("Comic Sans MS", 3, 15)); 
        orderButton.setForeground(new Color(255, 255, 255));
        orderButton.setText("Orders");
        orderButton.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        orderButton.setBounds(585, 360, 200, 80);
        orderButton.addActionListener(this);            
        add(orderButton);

        stockButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stockButton.setBackground(new Color(52, 52, 52));
        stockButton.setFont(new Font("Comic Sans MS", 3, 15)); 
        stockButton.setForeground(new Color(255, 255, 255));
        stockButton.setText("Stock");
        stockButton.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        stockButton.setBounds(385, 360, 200, 80);
        stockButton.addActionListener(this);
        add(stockButton);
    
        agentsMButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        agentsMButton.setBackground(new Color(52, 52, 52));
        agentsMButton.setFont(new Font("Comic Sans MS", 3, 15)); 
        agentsMButton.setForeground(new Color(255, 255, 255));
        agentsMButton.setText("Agents Management");
        agentsMButton.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        agentsMButton.setBounds(193, 360, 192, 80);
        agentsMButton.addActionListener(this);
        add(agentsMButton);
        agentsMButton.setOpaque(true);
        

        
        scroll.setBounds(0, 0, 785, 110);
        scroll.setBorder(new LineBorder(new Color(255, 255, 255)));
        warehosueLabel.setFont(new Font("Comic Sans MS", 3, 48)); 
        warehosueLabel.setForeground(new Color(52, 52, 52));
        warehosueLabel.setText("Warehouse Name");
        scroll.setViewportView(warehosueLabel);
        add(scroll);

        if(PnlChoice.agent.equals("Client")){
            agentsMButton.setVisible(false);
            orderButton.setVisible(false);
            deliveryButton.setSize(deliveryButton.getWidth()+192, deliveryButton.getHeight());
            stockButton.setSize(stockButton.getWidth()+200,stockButton.getHeight());
        }else if(PnlChoice.agent.equals("Supplier")){
            agentsMButton.setVisible(false);
            deliveryButton.setVisible(false);
            stockButton.setVisible(false);
            orderButton.setBounds(0, 360, 785, 80);
        }

}

public void paintComponent(Graphics g){
    super.paintComponent(g);
    try{
        delivery = ImageIO.read(new File("src/img/delivery.png")); 
        order = ImageIO.read(new File("src/img/order.png")); 
        background = ImageIO.read(new File("src/img/background.jpg")); 
        agents = ImageIO.read(new File("src/img/agents.png")); 
        stock = ImageIO.read(new File("src/img/stock.png")); 
    }catch(IOException e){
        System.out.println("La imagen no se encuentra");
    }
    
    g.drawImage(background,0 , 0, null);
    g.drawImage(delivery, 35, 480, 156, 560, 0, 250, 1071, 1071, null);
    g.drawImage(order, 630, 480, 751, 560, 0, 250, 1071, 1071, null);
    g.drawImage(stock, 390, 450, 580, 580, 0, 0, 768, 614, null);
    g.drawImage(agents, 210, 470, 375, 550, 0, 0, 819, 614, null);

}

public void actionPerformed(ActionEvent e) {
    if(e.getSource()==deliveryButton){
    
    DeliveryWindow dw = new DeliveryWindow(daddy);
    daddy.setEnabled(false);
    

   }else if(e.getSource()==stockButton){

    daddy.ShowStock(indexx);
    
   }else if(e.getSource()==agentsMButton){

    daddy.ShowAgentManagment(indexx);
    
   }else if (e.getSource()==infoB){

    JOptionPane.showMessageDialog(null,warehouses.get(indexx).toString(), "Warehouse Information", JOptionPane.INFORMATION_MESSAGE);
 
}else if(e.getSource()==orderButton){
    new OrderWindow(daddy);
    daddy.setEnabled(false);
}
}
public JLabel getWarehouseLabel(){
    return warehosueLabel;
}

    
}

