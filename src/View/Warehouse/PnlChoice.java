package View.Warehouse;


import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PnlChoice extends JPanel implements ActionListener{

    private FrmStartWarehouse pater;
	public static String agent = "";

    private JButton btnAdmin;
    private JButton btnClient;
    private JButton btnSupplier;
	private JSeparator line1;
    private JSeparator line2;
	Image image ;

    public PnlChoice(FrmStartWarehouse pater) {

        this.pater = pater;

        setBorder(new LineBorder(new Color(192, 192, 192), 2));        
        setLayout(null);
		setBackground(new Color(144, 144, 144));

		line1 = new JSeparator();
        line2 = new JSeparator();
        btnAdmin = new JButton("Admin");
        btnClient = new JButton("Client");
        btnSupplier = new JButton("Supplier");


		
        line1.setBounds(20, 216, 741, 11);
        add(line1);


        line2.setBounds(20, 348, 741, 11);
        add(line2);
        		
		btnAdmin.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		btnAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdmin.setBackground(new Color(52, 52, 52));
		btnAdmin.setForeground(new Color(255, 255, 255));
		btnAdmin.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnAdmin.setBounds(216, 113, 350, 85);
		btnAdmin.addActionListener(this);
		add(btnAdmin);
		
		
		btnClient.setForeground(new Color(255, 255, 255));
		btnClient.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnClient.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		btnClient.setBackground(new Color(52, 52, 52));
		btnClient.setBounds(216, 238, 350, 85);
		btnClient.addActionListener(this);
		add(btnClient);
		
		
		btnSupplier.setForeground(new Color(255, 255, 255));
		btnSupplier.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnSupplier.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		btnSupplier.setBackground(new Color(52, 52, 52));
		btnSupplier.setBounds(216, 370, 350, 85);
		btnSupplier.addActionListener(this);
		add(btnSupplier);

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

		if (e.getSource() == btnAdmin) {			

			agent = "Admin";
			pater.ShowCreateOrLog();			
			
		}		


		if (e.getSource() == btnClient) {
						
			agent = "Client";
			pater.ShowWareHouseConsultation();

		}

		if (e.getSource() == btnSupplier) {

			agent = "Supplier";
			pater.ShowGetInSupplier();
			
		}
		
	}

    
}
