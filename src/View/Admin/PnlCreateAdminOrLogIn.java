package View.Admin;


import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import View.Warehouse.FrmStartWarehouse;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PnlCreateAdminOrLogIn extends JPanel implements ActionListener{   

    private FrmStartWarehouse pater;
    private JButton btnCreateAdmin;
    private JButton btnLogIn;
	private Image image;

    public PnlCreateAdminOrLogIn(FrmStartWarehouse pater) {

        this.pater = pater;

		setBorder(new LineBorder(new Color(192, 192, 192), 2));        
        setLayout(null);
		setBackground(new Color(144, 144, 144));

        btnCreateAdmin = new JButton("Create Admin");
        btnLogIn = new JButton("Log in"); 
       
		btnCreateAdmin.setForeground(new Color(255, 255, 255));
		btnCreateAdmin.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnCreateAdmin.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		btnCreateAdmin.setBackground(new Color(52, 52, 52));
		btnCreateAdmin.setBounds(213, 135, 350, 85);
		btnCreateAdmin.addActionListener(this);
		add(btnCreateAdmin);
		
		
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		btnLogIn.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		btnLogIn.setBackground(new Color(52, 52, 52));
		btnLogIn.setBounds(213, 276, 350, 85);
		btnLogIn.addActionListener(this);
		add(btnLogIn);
        
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
		
		
		if (e.getSource() == btnCreateAdmin) {

			pater.ShowCreateAdmin();
			
		}

		if (e.getSource() == btnLogIn) {

			pater.ShowLogin();
						
		}		
		
	}
    
}
