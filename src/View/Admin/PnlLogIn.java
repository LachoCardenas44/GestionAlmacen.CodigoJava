package View.Admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import Controller.WareHouse.Warehouse;
import Model.GuardarCargarDatos;
import View.WareHouse.FrmStartWarehouse;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class PnlLogIn extends JPanel implements ActionListener, MouseInputListener{

    private FrmStartWarehouse pater;
	private ArrayList<Warehouse> warehouses = new ArrayList<>(){};
	private Image image;



    JLabel lbName;
    JLabel lblPassword;    
    JTextField textField;
    JTextField textField_1;    
    JButton btnNext;
	JButton btnBack;
	JLabel lblFillAll;
    
    public PnlLogIn(FrmStartWarehouse pater) {

        this.pater = pater;
		warehouses = GuardarCargarDatos.LoadObject(warehouses,"src/data/wareh.dat");

        lbName = new JLabel("Name");
        lblPassword = new JLabel("New Password");        
        textField = new JTextField();
        textField_1 = new JTextField();        
        btnNext = new JButton("Next");
		btnBack = new JButton("Back");
		lblFillAll = new JLabel("");

        setBounds(0, 0, 784, 561);
		setBackground(new Color(192, 192, 192));
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
		textField.addMouseListener(this);
	    textField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isLetter(e.getKeyChar())
			     && !(e.getKeyChar() == KeyEvent.VK_SPACE)) {

					e.consume();
					
				}
					
					

			}
	    });
        add(textField);
		
		
		textField_1.setBounds(291, 253, 334, 46);		
		textField_1.setForeground(new Color(114, 114, 114));
		textField_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(128, 128, 128)));	
		textField_1.addMouseListener(this);	
        add(textField_1);
		
		
		lblPassword.setBounds(122, 253, 134, 46);	
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(lblPassword);	
		
		
		
		lblFillAll.setForeground(new Color(255, 0, 0));
		lblFillAll.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblFillAll.setBounds(301, 362, 163, 46);
	    add(lblFillAll);
		
		
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnNext.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		btnNext.setBackground(new Color(52, 52, 52));		
		btnNext.setBounds(291, 419, 173, 61);		
		btnNext.addActionListener(this);
		add(btnNext);

		btnBack.setForeground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		btnBack.setBackground(new Color(52, 52, 52));
		btnBack.setBounds(0, 500, 784, 61);
		btnBack.addActionListener(this);
		add(btnBack);

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

    @Override
    public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnNext) {

			if (!(textField.getText().trim().equals("") 
			|| textField_1.getText().trim().equals(""))) {

		   	int index = -1;

		   	for (int i = 0; i < warehouses.size(); i++) {				

			   	if (textField.getText().trim().equals(warehouses.get(i).getAdmin().getName().trim())) {

				   	index = i;					

			   	} 

		   	}			
			
		   	if (index != -1) {

				pater.setWarehouse(warehouses.get(index).getName());
			   	pater.ShowWarehouseOptions(index, warehouses);
				
		   	} else {

			   	lblFillAll.setBounds(262, 362, 236, 46);
			   	lblFillAll.setText("You're not in the system");
				
		   	}



	   		} else {

		   		lblFillAll.setBounds(301, 362, 163, 46);
		   		lblFillAll.setText("Fill all the fields");
				
	   		}


			
		} else {

			pater.ShowCreateOrLog();

		}


			     

        
    }

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		
		if (e.getSource() == textField || e.getSource() == textField_1) {

			lblFillAll.setText("");
			
		}
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
