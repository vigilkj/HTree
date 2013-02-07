/**
 *HTree
 *
 * 		Recursively draws an HTree
 * 
 */


import java.awt.Graphics;
public class TTree{

	private int x, y, length, depth;
	private Graphics g;

	public static final int MAX_DEPTH = 7;

	/**
	 *Constructor
	 *
	 * @param x - center x position of the htree
	 * @param y - center y position of the htree
	 * @param length - the length of the middle bar of the H
	 */
	public TTree(int x, int y, int length){
		this.x = x;
		this.y = y;
		this.length = length;
		this.depth = 1;
	}

	/**
	 * 
	 *Getters and Setters
	 *	 
	 */
	public int getX(){
		return this.x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return this.y;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getLength(){
		return this.length;
	}

	public void setLength(int length){
		this.length = length;
	}

	public int getDepth(){
		return this.depth;
	}

	// public void setDepth(int depth){
	// 	this.depth = depth;
	// }
	
	/**
	 * incrementDepth
	 *
	 * 		Increment the depth by one, unless the dpeth is greater than MAX_DEPTH, in which case it should be set to 1.
	 */
	public void incrementDepth(){
		if(this.depth >= MAX_DEPTH){
			this.depth = 1;
		}else{
			this.depth++;
		}
	}

	/**
	 *draw
	 *
	 * 		draw the htree to the screen	
	 *
	 * 		this is an accessor mehtod that calls the real private recursive method
	 *
	 * @param g - the Graphics object associated with the window
	 */
	public void draw(Graphics g){
		this.g = g;
		recursiveDrawRight(depth, x, y, length);
		recursiveDrawLeft(depth,x,y,length);
	}

	/**
	 *recursiveDraw
	 *
	 * 		actually draw the htree
	 *
	 * @param n - current depth of the htree
	 * @param a, b - center point of the htree
	 * @param s - length of a line at the current depth 
	 *
	 * precondtion - g must not be null
	 */
	private void recursiveDraw(int n, int a, int b, int s){
		//base case
		if(n < 0){
			return;
		}
		//draw step
		
		//math to calculate new position and sizes
		int halfLength = s / 2;

		//horizontal line
		int x1 = a;
		int y1 = b;
		int x2 = a + halfLength;
		int y2 = b;
		g.drawLine(x1, y1, x2, y2);

		//vertical
		y1 = b + halfLength;
		x1 = x2;
		y2 = b - halfLength;
		g.drawLine(x1, y1, x2, y2);

		//reduction step
		recursiveDraw(n - 1, x1, y1, halfLength);
		recursiveDraw(n - 1, x2, y2, halfLength);


		//reduction step
		// recursiveDraw(n - 1, x1, y1, halfLength);
		// recursiveDraw(n - 1, x2, y2, halfLength);
	}

	private void recursiveDrawRight(int n, int a, int b, int s){
		//base case
		if(n < 0){
			return;
		}
		//draw step
		
		//math to calculate new position and sizes
		int halfLength = s / 2;

		//horizontal line
		int x1 = a;
		int y1 = b;
		int x2 = a + halfLength;
		int y2 = b;
		g.drawLine(x1, y1, x2, y2);

		//vertical
		y1 = b + halfLength;
		x1 = x2;
		y2 = b - halfLength;
		g.drawLine(x1, y1, x2, y2);

		//reduction step
		recursiveDrawRight(n - 1, x1, y1, halfLength);
		recursiveDrawRight(n - 1, x2, y2, halfLength);


		//reduction step
		// recursiveDraw(n - 1, x1, y1, halfLength);
		// recursiveDraw(n - 1, x2, y2, halfLength);
	}

	private void recursiveDrawLeft(int n, int a, int b, int s){
		//base case
		if(n < 0){
			return;
		}
		//draw step
		
		//math to calculate new position and sizes
		int halfLength = s / 2;

		//horizontal line
		int x1 = a;
		int y1 = b;
		int x2 = a - halfLength;
		int y2 = b;
		g.drawLine(x1, y1, x2, y2);

		//vertical
		y1 = b + halfLength;
		x1 = x2;
		y2 = b - halfLength;
		g.drawLine(x1, y1, x2, y2);

		//reduction step
		recursiveDrawLeft(n - 1, x1, y1, halfLength);
		recursiveDrawLeft(n - 1, x2, y2, halfLength);


		//reduction step
		// recursiveDraw(n - 1, x1, y1, halfLength);
		// recursiveDraw(n - 1, x2, y2, halfLength);
	}








}