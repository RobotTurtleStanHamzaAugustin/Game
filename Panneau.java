import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panneau extends JPanel {

	Game panneau = new Game();
	private int position = 30;
	private int angle = 270;

	public int getPosition() {
		return position;
	}

	public void SetPosition(int i) {
		this.position = i;
	}
	
	public int getAngle() {
		return angle;
	}

	public void SetAngle(int i) {
		this.angle = i;
	}
	

	
	public void paintComponent(Graphics g) {
		try {
			this.removeAll();
			
			Image plateau = ImageIO.read(new File("//home//eleves//s//stfc10586//Images//images//images//plateau.jpg"));
			Image carteB = ImageIO
					.read(new File("//home//eleves//s//stfc10586//Images//images//images//cards//BlueCard.png"));
			Image carteV = ImageIO
					.read(new File("//home//eleves//s//stfc10586//Images//images//images//cards//PurpleCard.png"));
			Image carteJ = ImageIO
					.read(new File("//home//eleves//s//stfc10586//Images//images//images//cards//YellowCard.png"));
			Image carteL = ImageIO
					.read(new File("//home//eleves//s//stfc10586//Images//images//images//cards//LaserCard.png"));

			BufferedImage tortue1 = ImageIO.read(new File("//home//eleves//s//stfc10586//Images//images//images//turtle1.jpg"));
			
			double rotationRequired = Math.toRadians (angle);
			double locationX = tortue1.getWidth() / 2;
			double locationY = tortue1.getHeight() / 2;
			AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

			// Drawing the rotated image at the required drawing locations

			
			
			
			g.drawImage(plateau, 0, 0, this.getWidth() - 300, this.getWidth() - 300, this);

			g.drawImage(carteB, 0, this.getHeight() - 230, 150, 200, this);
			g.drawImage(carteV, 150, this.getHeight() - 230, 150, 200, this);
			g.drawImage(carteJ, 300, this.getHeight() - 230, 150, 200, this);
			g.drawImage(carteL, 450, this.getHeight() - 230, 150, 200, this);
			g.drawImage(carteL, 600, this.getHeight() - 230, 150, 200, this);
			g.drawImage(op.filter(tortue1, null), this.getHeight() - 950, position, 70, 70, this);

			this.updateUI();
			this.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
