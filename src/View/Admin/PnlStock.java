package View.Admin;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;
import javax.swing.event.MouseInputListener;
import Controller.ProductsStock.Product;
import Controller.WareHouse.Warehouse;
import Model.GuardarCargarDatos;
import View.Warehouse.FrmStartWarehouse;
import View.Warehouse.PnlChoice;


public class PnlStock extends JPanel implements ActionListener, MouseInputListener{	

    private FrmStartWarehouse pater;
    private int index; 

    private JScrollPane scrollPane;
    private JList<String> list;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnBack;
    private JLabel lbStock;
    private JLabel lbProductType;
    private JLabel lbCost;
    private JLabel lbSellPrice;
    private JLabel lblProductTypeValue;
    private JLabel lbCostValue;
    private JLabel lbSellPriceValue;
    private JLabel lbPhisicLocation;
    private JLabel lbHall;
    private JLabel lbShelf;
    private JLabel lbHigh;
    private JLabel lbShelfValue;
    private JLabel lbHallValue;
    private JLabel lbHighValue;
	private JLabel lblSupplier;
	private JLabel lbSupplierName;
    private ArrayList<Warehouse> warehouses = new ArrayList<>(){};
    private ArrayList<Product> products = new ArrayList<>(){};	

	public PnlStock(FrmStartWarehouse pater, int index) {

        this.pater = pater;
        this.index = index;

        scrollPane = new JScrollPane();
        list = new JList<String>();
        btnAdd = new JButton("Add");
        btnDelete = new JButton("Delete");
        btnBack = new JButton("Back");
        lbStock = new JLabel("Stock");
        lbProductType = new JLabel(" Product Type:");
        lbCost = new JLabel("Cost:");
        lbSellPrice = new JLabel("Sell Price:");
        lblProductTypeValue = new JLabel("...");
        lbCostValue = new JLabel("...");
        lbSellPriceValue = new JLabel("...");
        lbPhisicLocation = new JLabel("Phisic Location:");
        lbHall = new JLabel("Hall:");
        lbShelf = new JLabel("Shelf:");
        lbHigh = new JLabel("High:");
        lbShelfValue = new JLabel("...");
        lbHallValue = new JLabel("...");
        lbHighValue = new JLabel("...");
		lblSupplier = new JLabel("Supplier");
		lbSupplierName = new JLabel("...");

        warehouses = GuardarCargarDatos.LoadObject(warehouses,"src/data/wareh.dat");
        products = GuardarCargarDatos.LoadObject(products,"src/data/"+ warehouses.get(index).getName() +"product.dat");
		
		
		setBackground(new Color(52, 52, 52));
		setLayout(null);
		


		if (PnlChoice.agent.equals("Admin")) {

			list.setBackground(new Color(192, 192, 192));
			list.setModel(new javax.swing.AbstractListModel<String>() {            
				private ArrayList<Product> strings = products;
				public int getSize() { return strings.size(); }
				public String getElementAt(int i) { return strings.get(i).getName(); }
			});
			list.addMouseListener(this);



			scrollPane.setViewportView(list);
			scrollPane.setBounds(22, 89, 305, 334);
			add(scrollPane);


			btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			btnAdd.setForeground(new Color(204, 204, 204));
			btnAdd.setBackground(new Color(28, 28, 28));
			btnAdd.setBounds(22, 434, 137, 49);
			btnAdd.addActionListener(this);
			add(btnAdd);		

		
		
			btnDelete.setForeground(new Color(204, 204, 204));
			btnDelete.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			btnDelete.setBackground(new Color(28, 28, 28));
			btnDelete.setBounds(190, 434, 137, 49);
			btnDelete.addActionListener(this);
			add(btnDelete);


			
			
			btnBack.setForeground(new Color(204, 204, 204));
			btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			btnBack.setBackground(new Color(28, 28, 28));
			btnBack.setBounds(0, 512, 784, 49);
			btnBack.addActionListener(this);
			add(btnBack);


			
			
			lbStock.setHorizontalAlignment(SwingConstants.CENTER);
			lbStock.setForeground(new Color(255, 255, 255));
			lbStock.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
			lbStock.setBounds(306, 11, 156, 67);
			add(lbStock);


			
			
			lbProductType.setBorder(null);
			lbProductType.setForeground(new Color(153, 153, 153));
			lbProductType.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbProductType.setBounds(363, 107, 146, 46);
			add(lbProductType);


			
			
			lbCost.setForeground(new Color(153, 153, 153));
			lbCost.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbCost.setBorder(null);
			lbCost.setBounds(449, 164, 60, 46);
			add(lbCost);


			
			
			lbSellPrice.setForeground(new Color(153, 153, 153));
			lbSellPrice.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbSellPrice.setBorder(null);
			lbSellPrice.setBounds(405, 221, 104, 46);
			add(lbSellPrice);


			
			
			lblProductTypeValue.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductTypeValue.setForeground(new Color(204, 204, 204));
			lblProductTypeValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblProductTypeValue.setBorder(new LineBorder(new Color(153, 153, 153), 2));
			lblProductTypeValue.setBounds(519, 107, 172, 46);
			add(lblProductTypeValue);


			
			
			lbCostValue.setHorizontalAlignment(SwingConstants.CENTER);
			lbCostValue.setForeground(new Color(204, 204, 204));
			lbCostValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbCostValue.setBorder(new LineBorder(new Color(153, 153, 153), 2));
			lbCostValue.setBounds(519, 164, 172, 46);
			add(lbCostValue);


			
			
			lbSellPriceValue.setHorizontalAlignment(SwingConstants.CENTER);
			lbSellPriceValue.setForeground(new Color(204, 204, 204));
			lbSellPriceValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbSellPriceValue.setBorder(new LineBorder(new Color(153, 153, 153), 2));
			lbSellPriceValue.setBounds(519, 221, 172, 46);
			add(lbSellPriceValue);


			
			
			lbPhisicLocation.setHorizontalAlignment(SwingConstants.CENTER);
			lbPhisicLocation.setForeground(new Color(153, 153, 153));
			lbPhisicLocation.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbPhisicLocation.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(153, 153, 153)));
			lbPhisicLocation.setBounds(337, 293, 198, 46);
			add(lbPhisicLocation);


			
			lbShelf.setHorizontalAlignment(SwingConstants.CENTER);
			lbShelf.setForeground(new Color(153, 153, 153));
			lbShelf.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbShelf.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(153, 153, 153)));
			lbShelf.setBounds(337, 337, 90, 46);
			add(lbShelf);
			


			
			lbHall.setHorizontalAlignment(SwingConstants.CENTER);
			lbHall.setForeground(new Color(153, 153, 153));
			lbHall.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbHall.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(153, 153, 153)));
			lbHall.setBounds(337, 377, 90, 46);
			add(lbHall);
			


			
			lbHigh.setHorizontalAlignment(SwingConstants.CENTER);
			lbHigh.setForeground(new Color(153, 153, 153));
			lbHigh.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbHigh.setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(153, 153, 153)));
			lbHigh.setBounds(337, 423, 90, 46);
			add(lbHigh);
			


			
			lbShelfValue.setHorizontalAlignment(SwingConstants.CENTER);
			lbShelfValue.setForeground(new Color(204, 204, 204));
			lbShelfValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbShelfValue.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(153, 153, 153)));
			lbShelfValue.setBounds(425, 337, 110, 46);
			add(lbShelfValue);
			
			


			lbHallValue.setHorizontalAlignment(SwingConstants.CENTER);
			lbHallValue.setForeground(new Color(204, 204, 204));
			lbHallValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbHallValue.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(153, 153, 153)));
			lbHallValue.setBounds(425, 377, 110, 46);
			add(lbHallValue);
			
			


			lbHighValue.setHorizontalAlignment(SwingConstants.CENTER);
			lbHighValue.setForeground(new Color(204, 204, 204));
			lbHighValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbHighValue.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(153, 153, 153)));
			lbHighValue.setBounds(425, 423, 110, 46);
			add(lbHighValue);



			
			lblSupplier.setHorizontalAlignment(SwingConstants.CENTER);
			lblSupplier.setForeground(new Color(255, 255, 255));
			lblSupplier.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblSupplier.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(153, 153, 153)));
			lblSupplier.setBounds(555, 325, 198, 46);
			add(lblSupplier);



			
			lbSupplierName.setHorizontalAlignment(SwingConstants.CENTER);
			lbSupplierName.setForeground(new Color(255, 255, 255));
			lbSupplierName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbSupplierName.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(153, 153, 153)));
			lbSupplierName.setBounds(555, 365, 198, 46);
			add(lbSupplierName);


		} else {

			list.setBackground(new Color(192, 192, 192));
			list.setModel(new javax.swing.AbstractListModel<String>() {            
				private ArrayList<Product> strings = products;
				public int getSize() { return strings.size(); }
				public String getElementAt(int i) { return strings.get(i).getName(); }
			});
			list.addMouseListener(this);



			scrollPane.setViewportView(list);
			scrollPane.setBounds(22, 89, 305, 334);
			add(scrollPane);


			lbProductType.setBorder(null);
			lbProductType.setForeground(new Color(153, 153, 153));
			lbProductType.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbProductType.setBounds(363, 107, 146, 46);
			add(lbProductType);

			
			
			lbSellPrice.setForeground(new Color(153, 153, 153));
			lbSellPrice.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbSellPrice.setBorder(null);
			lbSellPrice.setBounds(405, 221, 104, 46);
			add(lbSellPrice);



			btnBack.setForeground(new Color(204, 204, 204));
			btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			btnBack.setBackground(new Color(28, 28, 28));
			btnBack.setBounds(0, 512, 784, 49);
			btnBack.addActionListener(this);
			add(btnBack);



			lblProductTypeValue.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductTypeValue.setForeground(new Color(204, 204, 204));
			lblProductTypeValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lblProductTypeValue.setBorder(new LineBorder(new Color(153, 153, 153), 2));
			lblProductTypeValue.setBounds(519, 107, 172, 46);
			add(lblProductTypeValue);



			
			lbSellPriceValue.setHorizontalAlignment(SwingConstants.CENTER);
			lbSellPriceValue.setForeground(new Color(204, 204, 204));
			lbSellPriceValue.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			lbSellPriceValue.setBorder(new LineBorder(new Color(153, 153, 153), 2));
			lbSellPriceValue.setBounds(519, 221, 172, 46);
			add(lbSellPriceValue);
			
		}	


	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
		if (e.getSource() == btnAdd) {

			pater.ShowAddProduct(this, warehouses, index);
			
		} else if (e.getSource() == btnDelete) {

			if (products.size() == 0) {
				
			} else {

				products.remove(list.getSelectedIndex());
				GuardarCargarDatos.SaveObject(products, "src/data/"+ warehouses.get(index).getName() +"product.dat");
				pater.ShowStock(index);

			}			
			
		} else {
			
			pater.ShowWarehouseOptions(index, warehouses);

		}
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
		if (products.size() == 0) {
				
		} else {

			lblProductTypeValue.setText(products.get(list.getSelectedIndex()).getProductType());
			lbSellPriceValue.setText(products.get(list.getSelectedIndex()).getSellPrice());
			lbShelfValue.setText(products.get(list.getSelectedIndex()).getPhisicLocation().getShelf());
			lbHighValue.setText(products.get(list.getSelectedIndex()).getPhisicLocation().getHigh());
			lbHallValue.setText(products.get(list.getSelectedIndex()).getPhisicLocation().getHall());
			lbCostValue.setText(products.get(list.getSelectedIndex()).getCost());
			lbSupplierName.setText(products.get(list.getSelectedIndex()).getSupplier());

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
