import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class graphique extends JFrame {
	boolean b=true;
	Panneau Panneau = new Panneau();
	int i = Panneau.getPosition();
	int angle = Panneau.getAngle();

	  
	  
	  
	  
	  public graphique(){
		
	    this.setTitle("Ma première fenêtre Java");
	    this.setSize(1000, 1000);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    
	    JPanel boutonPane = new JPanel();
		JButton boutonCarte1 = new JButton();
		JButton boutonCarte2 = new JButton();
		
		
		
		
	    boutonCarte1.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	
	        	 i+=82;
	        	 b=true;

	        	 Panneau.SetPosition(i);
	        	 
	        }
	        
	      });
	    
	    boutonCarte2.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	
	        	 angle+=90;
	        	 b=true;

	        	 Panneau.SetAngle(angle);
	        	 
	        }
	        
	      });
	    
	    if(b==true) {
	    	b=false;
	    this.add(boutonCarte1);
	    this.add(boutonCarte2);
	    
	    
	    
	    boutonCarte1.setBounds(0, this.getHeight()-255,150, 200);
	    boutonCarte1.setOpaque(false);
	    boutonCarte1.setContentAreaFilled(false);
	    boutonCarte1.setBorderPainted(false);
	    
	    boutonCarte2.setBounds(150, this.getHeight()-255,150, 200);
	    boutonCarte2.setOpaque(false);
	    boutonCarte2.setContentAreaFilled(false);
	    boutonCarte2.setBorderPainted(false);
	    
		this.setResizable(false);

	    this.getContentPane().add(Panneau);

	    
	    this.setVisible(true);
	  }
	  }
	  
	
	} 

