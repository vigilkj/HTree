/**
 *SirTri
 *
 * 		Recursively draws a Sirpinski Triangle
 * 
 */

import java.lang.Math;
import java.awt.*;
public class SirTri {
	
	private Graphics g;
	private int cx,cy,w,depth;
	public static final int MAX_DEPTH=7;
	private int x1,x2,x3,y1,y2,y3;

	/**
	 * SirTri
	 *
	 *
	 * @param cx - x value of center of triangle
	 * @param cy - y value of center of triangle
	 *
	 */
	public SirTri(int cx, int cy, int w){
		this.cx=cx;
		this.cy=cy;
		this.w=w;
		this.depth = 1;
	}

	public int getCX(){
		return this.cx;
	}

	public void setCX(){
		this.cx=cx;
	}

	public int getCY(){
		return this.cy;
	}

	public void setCY(){
		this.cy=cy;
	}

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
	 * 		draw the Sirpinski Triangle to the screen	
	 *
	 * 		this is an accessor mehtod that calls the real private recursive method
	 *
	 * @param g - the Graphics object associated with the window
	 */
	public void draw(Graphics g){
		this.g = g;
		drawFirstTri();
		drawRecursiveTri(((x2-x1)/2) + x1, ((x2-x3)/2) + x3, ((x3-x1)/2) + x3,((y2-y1)/2) + y1, ((y2-y3)/2) + y3, ((y3-y1)/2) + y3);
	}

	public void drawRecursiveTri(int ptOneX, int ptTwoX, int ptThreeX, int ptOneY, int ptTwoY, int ptThreeY){

	}


	/**
	 * [recursiveTriangle 
	 * 		adds points and draws the triangle
	 * 		
	 * @param cx center point x
	 * @param cy center point y
	 * @param w  distance from the center point to the lines
	 */
	public void drawFirstTri(){
		Polygon p = new Polygon();
		//top point
		p.addPoint(cx, cy - w);
		this.x1 = this.cx;
		this.y1 = this.cy-this.w;

		//right point 
		p.addPoint(cx + (int) Math.sqrt( (double) (w*w) - ((w*(0.5)) * (w*(0.5))) ), (int) (cx + (w*(0.5))) );
		this.x2 = this.cx + (int) Math.sqrt( (double) (this.w*this.w) - ((this.w*(0.5)) * (this.w*(0.5))) );
		this.y2 = (int) (cx + (this.w*(0.5)));
		//left point
		p.addPoint(cx - (int) Math.sqrt( (double) (w*w) - ((w*(0.5)) * (w*(0.5))) ), (int) (cx + (w*(0.5))) );
		


		g.drawPolygon(p);

	}

}

