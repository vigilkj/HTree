/**
 *Triangle Window
 *
 *		Displays the SirTriangle
 *		
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.event.*;

class TriangleWindow extends JFrame implements MouseListener {
	
	private SirTri tri = null;
	
	// double buffering objects
	// used to eliminate flicker when resizing window
    private Image offscreen; 
	private Graphics buffer;
	
	
	/**
	 * Constructor
	 * 
	 * @param width - width of the window
	 * @param height - height of the window
	 * @param depth - recursive depth of the Sirpinski Triangle
	 */
	public TriangleWindow(int width, int height) {
		super("Triangle Window");
		this.setBounds(200, 200, width, height);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.setVisible(true);
	}


	@Override
	public void paint(Graphics g) {
		//reset();
		Rectangle b = this.getBounds();
		if(tri == null){
			tri = new SirTri(b.width / 2, b.height / 2, b.height / 3);
		}

		offscreen = createImage(b.width,b.height);
		buffer = offscreen.getGraphics();
		buffer.setColor(Color.white);

		tri.draw(buffer);
		g.drawImage(offscreen, 0, 0, this);


	}

	public void update(Graphics g) {
		paint(g);
	}

	
	/**
	 * main
	 * 		create an HTree window with an appropriate recursive depth
	 * 
	 * @param args - args[1] is the depth of recursion
	 */
	public static void main(String[] args) {
		TriangleWindow htwin = new TriangleWindow(600, 600);

	}
	

	/**
	 * incrementDepth
	 * 		increase the depth of the HTree, up to a point
	 */
	public void incrementDepth() {
		tri.incrementDepth();
		repaint();
	}


	/**
	 * mouseClicked
	 * 		mouse was clicked (pressed and released) on the window
	 * 		
	 * 		must be overwritten when implementing MouseListener
	 * 
	 * @param e - object holding info about the mouse event
	 */
	public void mouseClicked(MouseEvent e) {
		incrementDepth();
	}


	/**
	 * mousePressed
	 * 		mouse was pressed down
	 * 		
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mousePressed(MouseEvent e) {

	}

	/**
	 * mouseReleased
	 * 		mouse was released after a press
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * mouseEntered
	 * 		mouse entered the window
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * mouseExited
	 * 		mouse exited the window
	 * 
	 * 		must be overwritten when implementing MouseListener
	 *
	 * @param e - object holding info about the mouse event
	 */
	public void mouseExited(MouseEvent e) {

	}

}
