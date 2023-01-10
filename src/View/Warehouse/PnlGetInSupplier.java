package View.Warehouse;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import Controller.ExternalAgents.Supplier;
import Controller.WareHouse.Warehouse;
import Model.GuardarCargarDatos;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class PnlGetInSupplier extends JPanel implements ActionListener, MouseInputListener, InCheckSupplierOnSystem{   
   
    private FrmStartWarehouse pater;    
   
    private JLabel lbName;
    private JLabel lbId;
    private JLabel lblFillAll;
	private JTextField textField_1;
	private JTextField textField;	
	private JButton btnBack;	
	private JButton btnDone;
	private Image image ;
	private ArrayList<Warehouse> warehouses = new ArrayList<>(){};
	private ArrayList<Supplier> suppliers = new ArrayList<>(){}; 

    public PnlGetInSupplier(FrmStartWarehouse pater) {        
        
        this.pater = pater;        

        lbName = new JLabel("Name");
        lbId = new JLabel("First 4 ID Digits");
        lblFillAll = new JLabel("");
        textField = new JTextField();
        textField_1 = new JTextField();
        btnDone = new JButton("Done");
        btnBack = new JButton("Back");

		warehouses = GuardarCargarDatos.LoadObject(warehouses,"src/data/wareh.dat");
        

       
		setBounds(0, 0, 784, 561);
		setBackground(new java.awt.Color(52, 52, 52));		
		setLayout(null);

		
		
		lbName.setBounds(204, 155, 52, 46);
		lbName.setForeground(new Color(0, 0, 0));
		lbName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(lbName);

        		
		
		textField.setBounds(291, 155, 334, 46);		
		textField.setForeground(new Color(114, 114, 114));
		textField.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isLetter(e.getKeyChar())
			     && !(e.getKeyChar() == KeyEvent.VK_SPACE)) {

					e.consume();
					
				}
					
					

			}
	    });
		textField.addMouseListener(this);
        add(textField);

		
		
		textField_1.setBounds(291, 253, 334, 46);		
		textField_1.setForeground(new Color(114, 114, 114));
		textField_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(128, 128, 128)));		
        textField_1.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isDigit(e.getKeyChar())) {

					e.consume();
					
				}
				

			}
		});
		textField_1.addMouseListener(this);
        add(textField_1);

		
		
		lbId.setBounds(100, 253, 156, 46);
		lbId.setForeground(new Color(0, 0, 0));
		lbId.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(lbId);

		
		
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		btnBack.setBackground(new java.awt.Color(28, 28, 28));
		btnBack.setBounds(0, 500, 394, 61);
        btnBack.addActionListener(this);
		add(btnBack);
	
        
		
		lblFillAll.setForeground(new Color(255, 0, 0));
		lblFillAll.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblFillAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillAll.setBounds(231, 386, 334, 46);
        lblFillAll.setVisible(false);
		add(lblFillAll);

		
		
		btnDone.setForeground(Color.LIGHT_GRAY);
		btnDone.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnDone.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		btnDone.setBackground(new java.awt.Color(28, 28, 28));
		btnDone.setBounds(390, 500, 394, 61);
        btnDone.addActionListener(this);
		add(btnDone);
        
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

	public boolean isSupplierOnSystem(String name, String digits) {		

		boolean exist = false;
		
		for (int i = 0; i < warehouses.size(); i++) {

			suppliers = GuardarCargarDatos.LoadObject(suppliers, "src/data/"+ warehouses.get(i).getName() +"supplier.dat");

			for (int j = 0; j < suppliers.size(); j++) {
				
				try {

					if (suppliers.get(j).getName().equals(name) 
					 && suppliers.get(j).getId().substring(0, 4).equals(digits)) {
					
						exist = true;

					}
					
				} catch (Exception e) {
					
				}				

			}
			
		}

		return exist;

	}

    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == btnDone) {

            if (!(textField.getText().trim().equals("") 
		 	 || textField_1.getText().trim().equals(""))) {


				if (isSupplierOnSystem(textField.getText(), textField_1.getText())) {
					
					pater.ShowWarehouseConsultation();

				} else {

					lblFillAll.setText("You don't belong here");
					lblFillAll.setVisible(true);

				}

                
			} else {

				lblFillAll.setText("Fill all the fields");
				lblFillAll.setVisible(true);

			}       
            

        } else {

            pater.ShowChoice();
            
        }
        
    }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {		
		
		lblFillAll.setVisible(false);	
		
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
