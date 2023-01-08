package View.Admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import Controller.InternalAgents.Admin;
import Controller.WareHouse.Warehouse;
import Model.GuardarCargarDatos;
import View.Warehouse.FrmStartWarehouse;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class PnlToCreateAdmin extends JPanel implements ActionListener{   

    private FrmStartWarehouse pater;	
	private ArrayList<Warehouse> warehouses = new ArrayList<>(){};
	Image image;

    JLabel lbName;
    JLabel lblPassword;
    JLabel lblWarehouseName;
	JLabel lblAdress;
    JTextField textField;
    JTextField textField_1;
    JTextField textField_2;
	JTextField textField_3;
    JButton btnNext;
	JButton btnBack;
	JLabel lblFillAll;


    public PnlToCreateAdmin(FrmStartWarehouse pater) {

        this.pater = pater;

        lbName = new JLabel("Name");
        lblPassword = new JLabel("New Password");
        lblWarehouseName = new JLabel("Warehouse Name");
		lblAdress = new JLabel("Warehouse Address");
        textField = new JTextField();
        textField_1 = new JTextField();
        textField_2 = new JTextField();
		textField_3 = new JTextField();
        btnNext = new JButton("Next");
		btnBack = new JButton("Back");
		lblFillAll = new JLabel("");
        

        setBounds(0, 0, 784, 561);
		setBackground(new Color(192, 192, 192));
        setLayout(null);

        
		lbName.setBounds(204, 63, 52, 46);		
		lbName.setForeground(new Color(0, 0, 0));
		lbName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(lbName);
		
		
		textField.setBounds(291, 63, 334, 46);		
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
        add(textField);
		
		
		textField_1.setBounds(291, 147, 334, 46);		
		textField_1.setForeground(new Color(114, 114, 114));
		textField_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(128, 128, 128)));		
        add(textField_1);
		
		
		lblPassword.setBounds(122, 147, 134, 46);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(lblPassword);
		
		
		textField_2.setBounds(291, 230, 334, 46); 
		textField_2.setForeground(new Color(114, 114, 114));
		textField_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_2.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isLetter(e.getKeyChar())
				 && !(e.getKeyChar() == KeyEvent.VK_SPACE)) {

					e.consume();
					
				}
				

			}
		});
        add(textField_2);

		
		textField_3.setForeground(new Color(114, 114, 114));
		textField_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_3.setBounds(291, 314, 334, 46);
		add(textField_3);
		
		
		lblWarehouseName.setBounds(93, 230, 163, 46);	
		lblWarehouseName.setForeground(new Color(0, 0, 0));
		lblWarehouseName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        add(lblWarehouseName);

		
		lblAdress.setForeground(Color.BLACK);
		lblAdress.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblAdress.setBounds(66, 314, 190, 46);
		add(lblAdress);

		
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

			warehouses = GuardarCargarDatos.LoadObject(warehouses, "src/data/wareh.dat");

			if (!(textField.getText().trim().equals("") 
		 	 || textField_1.getText().trim().equals("") 
		 	 || textField_2.getText().trim().equals("")
		 	 || textField_3.getText().trim().equals(""))) {


				warehouses.add(new Warehouse(textField_2.getText().trim(),textField_3.getText().trim(), new Admin(textField.getText().trim(), textField_1.getText().trim())));
				GuardarCargarDatos.SaveObject(warehouses, "src/data/wareh.dat");	
				System.out.println(warehouses.size());
				pater.setWarehouse(textField_2.getText().trim());

				pater.ShowWarehouseOptions(warehouses.size()-1, warehouses);

			} else {

				lblFillAll.setText("Fill all the fields");
				
			} 
				
		} else {

			pater.ShowCreateOrLog();

		}
		

        
    }
    
}
