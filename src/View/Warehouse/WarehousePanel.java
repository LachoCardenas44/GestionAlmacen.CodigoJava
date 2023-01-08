package View.Warehouse;

import Model.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import Controller.WareHouse.*;
import java.io.*;
import java.util.ArrayList;

public class WarehousePanel extends JPanel implements ActionListener, MouseListener, KeyListener{

    private JScrollPane tableScroll;
    private JTable table;
    private String path = "src/data/wareh.dat";
    private JTextField addressField;
    private JLabel addressLabel;
    private JTextField nameField;
    private JTextField adminField;
    private JLabel warehouseLabel;
    private JLabel adminLabel;
    private int index = -1;
    private JButton manageB;
    private JButton searchB;
    private JButton falseSearchB;
    private JButton falseSearchAdminB;
    private JButton searchAdminB;
    private ArrayList<Warehouse> warehouses = new ArrayList<>(){};
    private FrmStartWarehouse daddy;
    private Image image;
    
    

public WarehousePanel(FrmStartWarehouse daddy){
    this.daddy=daddy;
    onitComponents();
    
}
public void onitComponents(){
        setLayout(null);

        
        
        warehouseLabel = new JLabel();
        adminLabel = new JLabel();
        nameField = new JTextField();
        adminField = new JTextField();
        addressField = new JTextField();
        addressLabel = new JLabel();
        manageB = new JButton("Get In");
        searchB = new JButton("🔎");
        falseSearchB = new JButton("🔎");
        searchAdminB = new JButton("🔎");
        falseSearchAdminB = new JButton("🔎");

        warehouses = GuardarCargarDatos.LoadObject(warehouses, path);

        manageB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageB.setBackground(new Color(52, 52, 52));
        manageB.setForeground(new Color(255, 255, 255));
        manageB.setBounds(0,500,800,60);
        manageB.addActionListener(this);
        add(manageB);

        warehouseLabel.setFont(new Font("Comic Sans MS", 2, 18)); 
        warehouseLabel.setForeground(new Color(255, 255, 255));
        warehouseLabel.setText("Warehouse");
        add(warehouseLabel);
        warehouseLabel.setBounds(580, 5, 120, 26);

        adminLabel.setFont(new Font("Comic Sans MS", 2, 18)); 
        adminLabel.setForeground(new Color(255, 255, 255));
        adminLabel.setText("Admin");
        add(adminLabel);
        adminLabel.setBounds(600, 113, 120, 26);

        nameField.setFont(new Font("Comic Sans MS", 2, 12));
        add(nameField);
        nameField.setBounds(540, 32, 210, 40);

        adminField.setFont(new Font("Comic Sans MS", 2, 12));
        add(adminField);
        adminField.setBounds(540, 140, 210, 40);

        searchB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchB.setBackground(new Color(52, 52, 52));
        searchB.setForeground(new Color(255, 255, 255));
        searchB.setBounds(490,32,50,40);
        searchB.addActionListener(this);
        

        falseSearchB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        falseSearchB.setBackground(new Color(52, 52, 52));
        falseSearchB.setForeground(new Color(255, 255, 255));
        falseSearchB.setBounds(490,32,50,40);
        falseSearchB.addActionListener(this);
        add(falseSearchB);

        searchAdminB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchAdminB.setBackground(new Color(52, 52, 52));
        searchAdminB.setForeground(new Color(255, 255, 255));
        searchAdminB.setBounds(490,140,50,40);
        searchAdminB.addActionListener(this);
        

        falseSearchAdminB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        falseSearchAdminB.setBackground(new Color(52, 52, 52));
        falseSearchAdminB.setForeground(new Color(255, 255, 255));
        falseSearchAdminB.setBounds(490,140,50,40);
        falseSearchAdminB.addActionListener(this);
        add(falseSearchAdminB);

        addressField.setFont(new Font("Comic Sans MS", 2, 12));
        add(addressField);
        addressField.setBounds(600, 220, 150, 22);

        addressLabel.setFont(new Font("Comic Sans MS", 2, 12)); 
        addressLabel.setText("Address :");
        addressLabel.setForeground(new Color(255, 255, 255));
        add(addressLabel);
        addressLabel.setBounds(535, 220, 60, 18);

        EditableFields(false);
        warehouses = GuardarCargarDatos.LoadObject(warehouses,path);
        
   
    
        table = new JTable();
        table.setBackground(new Color(52, 52, 52));
        table.setForeground(new Color(255,255,255));
        tableScroll = new JScrollPane();

        table = new JTable();
            table.setModel(new DefaultTableModel(new String[]{"Warehouse"},warehouses.size()){
                public boolean isCellEditable(int row,int column){
                    return false;
                }
            });
        String [] names = new String[warehouses.size()];
            for(int j = 0; j<names.length;j++){
                 names[j]=warehouses.get(j).getName();
                    
            }
            
        for(int i=0;i<warehouses.size();i++){
                
            table.setValueAt(names[i], i, 0);
               
        }

        tableScroll.setViewportView(table);    
        add(tableScroll);
        tableScroll.setBounds(0, 0, 450, 500);
        table.addMouseListener(this);
        table.addKeyListener(this);
        
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
public void actionPerformed(ActionEvent e) {
if(e.getSource()==manageB){
        if(index!=-1){
            
        /*OptionPanel panel = new OptionPanel(daddy,index);
        panel.getWarehouseLabel().setText(warehouses.get(index).getName());
        daddy.ChangePanel(panel);*/
        daddy.setWarehouse(warehouses.get(index).getName());
        daddy.ShowWarehouseOptions(index, warehouses);

        }
    }else if(e.getSource()==falseSearchB){
        EmptyFields();
        remove(searchAdminB);
        add(falseSearchAdminB);
        remove(falseSearchB);
        add(searchB);
        nameField.setEditable(true);
        setSize(getWidth()+1,getHeight()+1);
        setSize(getWidth()-1,getHeight()-1);

    }else if(e.getSource()==searchB){
        remove(searchB);
        add(falseSearchB);
        int value = -1;
        this.index=-1;
        if(nameField.getText()==""){}else{
        for(int i = 0;i<warehouses.size();i++){
            if(warehouses.get(i).getName().equalsIgnoreCase(nameField.getText().stripIndent())){
                Warehouse save = warehouses.get(i);
                warehouses.set(i, warehouses.get(0));
                warehouses.set(0, save);
                this.index=0;
                ReloadTable();
                EditableFields(false);
                showInfo(index);
                remove(searchB);
                setSize(getWidth()+1,getHeight()+1);
                setSize(getWidth()-1,getHeight()-1);
                table.setRowSelectionInterval(0, 0);
                GuardarCargarDatos.SaveObject(warehouses,path);
                value = i;
                this.index=0;
               
            }
        }if(value==-1){
            remove(falseSearchB);
            add(searchB);
            JOptionPane.showMessageDialog(null, "The Warehouse you're looking for it doesn't exist", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    }else if(e.getSource()==falseSearchAdminB){
        EmptyFields();
        remove(searchB);
        add(falseSearchB);
        remove(falseSearchAdminB);
        add(searchAdminB);
        adminField.setEditable(true);
        setSize(getWidth()+1,getHeight()+1);
        setSize(getWidth()-1,getHeight()-1);

    }else if(e.getSource()==searchAdminB){
        remove(searchAdminB);
        add(falseSearchAdminB);
        int value = -1;
        this.index=-1;
        if(adminField.getText()==""){}else{
        for(int i = 0;i<warehouses.size();i++){
            if(warehouses.get(i).getAdmin().getName().equalsIgnoreCase(adminField.getText().stripIndent())){
                Warehouse save = warehouses.get(i);
                warehouses.set(i, warehouses.get(0));
                warehouses.set(0, save);
                this.index=0;
                ReloadTable();
                adminField.setEditable(false);
                EditableFields(false);
                showInfo(index);
                remove(searchB);
                setSize(getWidth()+1,getHeight()+1);
                setSize(getWidth()-1,getHeight()-1);
                table.setRowSelectionInterval(0, 0);
                GuardarCargarDatos.SaveObject(warehouses,path);
                value = i;
                this.index=0;
               
            }
        }if(value==-1){
            remove(falseSearchAdminB);
            add(searchAdminB);
            JOptionPane.showMessageDialog(null, "The Admin you're looking for it doesn't exist", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    }
    
    
    
    
}
///////////////////////////////////////////////////////////////////////////////////////////////
public void paintComponent(Graphics g){
    super.paintComponent(g);
    try{
        image = ImageIO.read(new File("src/img/background.jpg")); 
    }catch(IOException e){
        System.out.println("La imagen no se encuentra");
    }
    
    g.drawImage(image, 0, 0, null);
    
}

////////////////////////////////////////////////////////////////////////////////////////////////////////

public void mouseClicked(MouseEvent e) {
if(e.getSource()==table){
    
Point point = e.getPoint();
this.index = table.rowAtPoint(point);
if(index!=-1){

    daddy.setWarehouse(warehouses.get(index).getName());
    EditableFields(false);
    showInfo(index);
    remove(searchB);
    setSize(getWidth()+1,getHeight()+1);
    setSize(getWidth()-1,getHeight()-1);
} 
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

public void ReloadTable(){
    table.setModel(new DefaultTableModel(new String[]{"Warehouse"},warehouses.size()){
        public boolean isCellEditable(int row,int column){
            return false;
        }
    });
String [] names = new String[warehouses.size()];
    for(int j = 0; j<names.length;j++){
        names[j]=warehouses.get(j).getName();
        
    }

for(int i=0;i<warehouses.size();i++){
    
    table.setValueAt(names[i], i, 0);
   
}
}
public void EditableFields(boolean x){

    if(x==false){
        addressField.setEditable(false);
        nameField.setEditable(false);
        adminField.setEditable(false);
    }else{
        addressField.setEditable(true);
        nameField.setEditable(true);
        adminField.setEditable(true);
    }

}
public void EmptyFields(){
    addressField.setText("");
        nameField.setText("");
}
  
public int getIndex(){
    return index;
}

public void showInfo(int position){
    addressField.setText( warehouses.get(position).getAddress());
    nameField.setText(warehouses.get(position).getName());
    adminField.setText(warehouses.get(position).getAdmin().getName());
}

public void keyTyped(KeyEvent e) {
    
    
}

public void keyPressed(KeyEvent e) {
    
    
}

public void keyReleased(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_ENTER){
        if(index!=-1){
            OptionPanel panel = new OptionPanel(daddy,index);
            panel.getWarehouseLabel().setText(warehouses.get(index).getName());
            daddy.ChangePanel(panel);
            }
    }
    
}      
}

