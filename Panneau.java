import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panneau extends JPanel {

	Game panneau = new Game();
	private int position = 30;

	public int getPosition() {
		return position;
	}

	public void SetPosition(int i) {
		this.position = i;
	}


	
	public void paintComponent(Graphics g) {
		try {

			Image plateau = ImageIO.read(new File("//home//eleves//s//stfc10586//Images//images//images//plateau.jpg"));
			Image carteB = ImageIO
					.read(new File("//home//eleves//s//stfc10586//Images//images//images//cards//BlueCard.png"));
			Image carteV = ImageIO
					.read(new File("//home//eleves//s//stfc10586//Images//images//images//cards//PurpleCard.png"));
			Image carteJ = ImageIO
					.read(new File("//home//eleves//s//stfc10586//Images//images//images//cards//YellowCard.png"));
			Image carteL = ImageIO
					.read(new File("//home//eleves//s//stfc10586//Images//images//images//cards//LaserCard.png"));

			Image tortue1 = ImageIO.read(new File("//home//eleves//s//stfc10586//Images//images//images//turtle1.jpg"));

			g.drawImage(plateau, 0, 0, this.getWidth() - 300, this.getWidth() - 300, this);

			g.drawImage(carteB, 0, this.getHeight() - 230, 150, 200, this);
			g.drawImage(carteV, 150, this.getHeight() - 230, 150, 200, this);
			g.drawImage(carteJ, 300, this.getHeight() - 230, 150, 200, this);
			g.drawImage(carteL, 450, this.getHeight() - 230, 150, 200, this);
			g.drawImage(carteL, 600, this.getHeight() - 230, 150, 200, this);

			System.out.println(position);

			g.drawImage(tortue1, this.getHeight() - 950, position, 70, 70, this);
			this.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
