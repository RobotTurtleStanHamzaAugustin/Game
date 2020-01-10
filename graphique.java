import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class graphique extends JFrame {
	
	Panneau Panneau = new Panneau();
	int i = Panneau.getPosition();

	  
	  
	  
	  
	  public graphique(){
		
	    this.setTitle("Ma première fenêtre Java");
	    this.setSize(1000, 1000);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    
	    JPanel boutonPane = new JPanel();
		JButton bouton = new JButton();
		
		
		
		
	    bouton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	
	        	 i+=80;
	        	 
	        	 System.out.println(i);
	        	 Panneau.SetPosition(i);
	        }
	      });
	    
	    this.add(bouton);
	    
	    
	    
	    bouton.setBounds(0, this.getHeight()-230,150, 200);
	    bouton.setOpaque(false);
	    bouton.setContentAreaFilled(false);
	    bouton.setBorderPainted(false);
	    
		this.setResizable(false);

	    this.getContentPane().add(Panneau);

	    
	    this.setVisible(true);
	  }
	  
	  
	
	} 

