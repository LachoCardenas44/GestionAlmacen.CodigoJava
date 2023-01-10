package View.Admin;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;

import Controller.Exeptions.EmptyFieldsExeption;
import Controller.Exeptions.NotFoundSupplierExeption;
import Controller.ExternalAgents.Supplier;
import Controller.ProductsStock.PhisicLocation;
import Controller.ProductsStock.Product;
import Controller.WareHouse.Warehouse;
import Model.GuardarCargarDatos;
import View.Warehouse.FrmStartWarehouse;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class PnlAddProduct extends JPanel implements ActionListener, MouseInputListener, InCheckSupplierOnWarehouse{

    private PnlStock predecessor;
    private FrmStartWarehouse pater;
	private int index;
	private ArrayList<Warehouse> warehouses = new ArrayList<>(){};
	private ArrayList<Supplier> suppliers = new ArrayList<>(){}; 
    
	private JTextField textField;	
	private JButton btnBack;
	private JLabel lblFillAll;
	private JButton btnDone;
	private JLabel lblName;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblProductType;
	private JLabel lbCost;
	private JLabel lbSellPrice;
	private JLabel lbShelf;
	private JLabel lbHall;
	private JLabel lbHigh;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblSupplier_1;
	private JTextField textField_7;
	private JSeparator separator;
	private JSeparator separator_1;
    
    public PnlAddProduct(FrmStartWarehouse pater, PnlStock predecessor, ArrayList<Warehouse> warehouses, int index) {

        this.predecessor = predecessor;
        this.pater = pater;
		this.warehouses = warehouses;
		this.index = index;

        textField = new JTextField();
        textField_1 = new JTextField();
        textField_2 = new JTextField();
        textField_3 = new JTextField();
        textField_4 = new JTextField();
        textField_5 = new JTextField();
        textField_6 = new JTextField();
        textField_7 = new JTextField();
        btnBack = new JButton("Back");
        btnDone = new JButton("Done");
        lblFillAll = new JLabel("Fill all the fields");
        lblName = new JLabel("Name:");
        lblProductType = new JLabel(" Product Type:");
        lbCost = new JLabel("Cost:");
        lbSellPrice = new JLabel("Sell Price:");
        lbShelf = new JLabel("Shelf:");
        lbHall = new JLabel("Hall:");
        lbHigh = new JLabel("High:");
        lblSupplier_1 = new JLabel("Supplier:");
        separator = new JSeparator();
        separator_1 = new JSeparator();

		suppliers = GuardarCargarDatos.LoadObject(suppliers, "src/data/"+ warehouses.get(index).getName() +"supplier.dat");

        setBackground(new Color(52, 52, 52));		
		setLayout(null);



       
		textField.setBounds(190, 60, 221, 40);


		
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
		


		
		btnBack.setForeground(new Color(204, 204, 204));
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		btnBack.setBackground(new Color(28, 28, 28));
		btnBack.setBounds(0, 500, 394, 61);
		btnBack.addActionListener(this);
		add(btnBack);
		


		
		lblFillAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillAll.setForeground(new Color(255, 0, 0));
		lblFillAll.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblFillAll.setBounds(113, 438, 531, 46);
        lblFillAll.setVisible(false);
		add(lblFillAll);
		


		
		btnDone.setForeground(new Color(204, 204, 204));
		btnDone.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnDone.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		btnDone.setBackground(new Color(28, 28, 28));
		btnDone.setBounds(390, 500, 394, 61);
		btnDone.addActionListener(this);
		add(btnDone);


		
		
		lblName.setForeground(new Color(153, 153, 153));
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblName.setBorder(null);
		lblName.setBounds(100, 60, 65, 40);
		add(lblName);
		


		
		textField_1.setForeground(new Color(114, 114, 114));
		textField_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_1.setBounds(190, 120, 221, 40);
        textField_1.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isLetter(e.getKeyChar())
			     && !(e.getKeyChar() == KeyEvent.VK_SPACE)) {

					e.consume();
					
				}
					
					

			}
	    });
		textField_1.addMouseListener(this);
		add(textField_1);
		


		
		textField_2.setForeground(new Color(114, 114, 114));
		textField_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_2.setBounds(190, 180, 221, 40);
        textField_2.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isDigit(e.getKeyChar())) {

					e.consume();
					
				}
				

			}
		});
		textField_2.addMouseListener(this);
		add(textField_2);
		


		
		textField_3.setForeground(new Color(114, 114, 114));
		textField_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_3.setBounds(190, 240, 221, 40);
        textField_3.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isDigit(e.getKeyChar())) {

					e.consume();
					
				}
				

			}
		});
		textField_3.addMouseListener(this);
		add(textField_3);
		


		
		lblProductType.setForeground(new Color(153, 153, 153));
		lblProductType.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblProductType.setBorder(null);
		lblProductType.setBounds(26, 120, 139, 40);
		add(lblProductType);


		
		
		lbCost.setForeground(new Color(153, 153, 153));
		lbCost.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lbCost.setBorder(null);
		lbCost.setBounds(113, 177, 52, 46);
		add(lbCost);


		
		
		lbSellPrice.setForeground(new Color(153, 153, 153));
		lbSellPrice.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lbSellPrice.setBorder(null);
		lbSellPrice.setBounds(66, 237, 99, 46);
		add(lbSellPrice);
		


		
		lbShelf.setHorizontalAlignment(SwingConstants.CENTER);
		lbShelf.setForeground(new Color(153, 153, 153));
		lbShelf.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lbShelf.setBorder(null);
		lbShelf.setBounds(436, 60, 90, 46);
		add(lbShelf);


		
		
		lbHall.setHorizontalAlignment(SwingConstants.CENTER);
		lbHall.setForeground(new Color(153, 153, 153));
		lbHall.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lbHall.setBorder(null);
		lbHall.setBounds(436, 114, 90, 46);
		add(lbHall);


		
		
		lbHigh.setHorizontalAlignment(SwingConstants.CENTER);
		lbHigh.setForeground(new Color(153, 153, 153));
		lbHigh.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lbHigh.setBorder(null);
		lbHigh.setBounds(436, 174, 90, 46);
		add(lbHigh);
		


		
		textField_4.setForeground(new Color(114, 114, 114));
		textField_4.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_4.setBounds(536, 60, 221, 40);
        textField_4.addMouseListener(this);
		add(textField_4);
		


		
		textField_5.setForeground(new Color(114, 114, 114));
		textField_5.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_5.setBounds(536, 120, 221, 40);
        textField_5.addMouseListener(this);
		add(textField_5);


		
		
		textField_6.setForeground(new Color(114, 114, 114));
		textField_6.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_6.setColumns(10);
		textField_6.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_6.setBounds(536, 180, 221, 40);
        textField_6.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isDigit(e.getKeyChar())) {

					e.consume();
					
				}
				

			}
		});
		textField_6.addMouseListener(this);
		add(textField_6);


		
		
		lblSupplier_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupplier_1.setForeground(Color.WHITE);
		lblSupplier_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblSupplier_1.setBorder(null);
		lblSupplier_1.setBounds(127, 344, 119, 46);
		add(lblSupplier_1);
		


		
		textField_7.setForeground(new Color(114, 114, 114));
		textField_7.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		textField_7.setColumns(10);
		textField_7.setBorder(new LineBorder(new Color(128, 128, 128)));
		textField_7.setBounds(283, 347, 387, 40);
        textField_7.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {				

				if (!Character.isLetter(e.getKeyChar())
			     && !(e.getKeyChar() == KeyEvent.VK_SPACE)) {

					e.consume();
					
				}
					
					

			}
	    });
		textField_7.addMouseListener(this);
		add(textField_7);


		
		
		separator.setForeground(new Color(192, 192, 192));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(436, 44, 7, 270);
		add(separator);



		
		separator_1.setForeground(new Color(192, 192, 192));
		separator_1.setBounds(26, 315, 731, 18);
		add(separator_1);
        
        
    }

	public boolean isSupplierOnWarehouse (String supplier){

		boolean existSupplier = false;

		for (int i = 0; i < suppliers.size(); i++) {

			if (suppliers.get(i).getName().equalsIgnoreCase(supplier)) {

				existSupplier = true;
				
			}
			
		}

		return existSupplier;

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnDone) {

            if (!(textField.getText().trim().equals("") 
		 	 || textField_1.getText().trim().equals("")
             || textField_2.getText().trim().equals("")
             || textField_3.getText().trim().equals("")
             || textField_4.getText().trim().equals("")
             || textField_5.getText().trim().equals("")
             || textField_6.getText().trim().equals("")
             || textField_7.getText().trim().equals(""))) {
				

				if (isSupplierOnWarehouse(textField_7.getText().trim())) {

					predecessor.getProducts().add(new Product(textField.getText().trim(), new PhisicLocation(textField_4.getText().trim(), textField_5.getText().trim(), textField_6.getText().trim()), textField_7.getText().trim(), textField_1.getText().trim(), textField_3.getText().trim(), textField_2.getText().trim()));
                	GuardarCargarDatos.SaveObject(predecessor.getProducts(), "src/data/"+ predecessor.getWarehouses().get(predecessor.getIndex()).getName() +"product.dat");
                	pater.ShowStock(predecessor.getIndex());
					
				} else {

					try {

						throw new NotFoundSupplierExeption();
						
					} catch (NotFoundSupplierExeption exc) {
						
						lblFillAll.setText(exc.getMessage());
					    lblFillAll.setVisible(true);

					}					

				}

				

                
			} else {

				try {

					throw new EmptyFieldsExeption();

				} catch (EmptyFieldsExeption exc) {

					lblFillAll.setText(exc.getMessage());
					lblFillAll.setVisible(true);
					
				}

			}       
            

        } else {

            pater.ShowStock(predecessor.getIndex());
            
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
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
