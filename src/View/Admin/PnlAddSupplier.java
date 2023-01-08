package View.Admin;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import Controller.ExternalAgents.Client;
import Controller.ExternalAgents.Supplier;
import Model.GuardarCargarDatos;
import View.Warehouse.FrmStartWarehouse;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class PnlAddSupplier extends JPanel implements ActionListener, MouseInputListener{    

    private PnlAgentManagment predecessor;
    private FrmStartWarehouse pater;    
   
    private JLabel lbName;
    private JLabel lbId;
    private JLabel lblFillAll;
	private JTextField textField_1;
	private JTextField textField;	
	private JButton btnBack;	
	private JButton btnDone;

    public PnlAddSupplier(FrmStartWarehouse pater, PnlAgentManagment predecessor) {
        
        this.predecessor = predecessor;
        this.pater = pater;        

        lbName = new JLabel("Name");
        lbId = new JLabel("ID");
        lblFillAll = new JLabel("Fill all the fields");
        textField = new JTextField();
        textField_1 = new JTextField();
        btnDone = new JButton("Done");
        btnBack = new JButton("Back");
        

       
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

		
		
		lbId.setBounds(231, 253, 25, 46);		
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
		lblFillAll.setBounds(323, 386, 151, 46);
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

    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == btnDone) {

            if (!(textField.getText().trim().equals("") 
		 	 || textField_1.getText().trim().equals(""))) {


				predecessor.getSuppliers().add(new Supplier(textField.getText().trim(), textField_1.getText().trim()));
                GuardarCargarDatos.SaveObject(predecessor.getSuppliers(), "src/data/"+ predecessor.getWarehouses().get(predecessor.getIndex()).getName() +"supplier.dat");
                pater.ShowAgentManagment(predecessor.getIndex());

                
			} else {

				lblFillAll.setVisible(true);

			}       
            

        } else {

            pater.ShowAgentManagment(predecessor.getIndex());
            
        }
        
    }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		
		if (e.getSource() == textField || e.getSource() == textField_1) {

			lblFillAll.setVisible(false);
			
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
