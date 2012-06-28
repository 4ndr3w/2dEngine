package lobos.andrew.game.baseObjects;

import javax.media.opengl.GL;

public class BoundingBox 
{
	public static boolean renderBoxes = false;
	float highestY, lowestY;
	float leftX, rightX;
	private float xPos, yPos;
	
	public BoundingBox()
	{
		
	}
	
	public void setExtremes(
			float highestY, float lowestY,
			float leftX, float rightX)
	{
		this.highestY = highestY;
		this.lowestY= lowestY;
		
		this.leftX = leftX;
		this.rightX = rightX;
	}
	
	
	public void setLocation(float xPos, float yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public float getHighestY()
	{
		return highestY+yPos;
	}
	
	public float getLowestY()
	{
		return lowestY+yPos;
	}

	public float getLeftX()
	{
		return leftX+xPos;
	}
	
	public float getRightX()
	{
		return rightX+xPos;
	}
	
	public void render(GL gl)
	{
		if ( !renderBoxes )
			return;
		
		gl.glBegin(GL.GL_LINES);
		
		gl.glVertex2d(getLeftX(), getHighestY());
		gl.glVertex2d(getRightX(), getHighestY());
		
		gl.glVertex2d(getLeftX(), getLowestY());
		gl.glVertex2d(getRightX(), getLowestY());
		
		gl.glVertex2d(getLeftX(), getHighestY());
		gl.glVertex2d(getLeftX(), getLowestY());
		
		gl.glVertex2d(getRightX(), getHighestY());
		gl.glVertex2d(getRightX(), getLowestY());
		
		gl.glEnd();
	}
	
	
	public boolean intersects(BoundingBox box)
	{
		if ( this.equals(box) )
			System.out.println("Warning! Tried to check if BoundingBox is contacting itself.");
		
		//System.out.println(String.format("%b %b %b %b", getLeftX() < box.getRightX(), getRightX() > box.getLeftX(),
		//		getHighestY() > box.getLowestY() ,getLowestY() < box.getHighestY()));
		if ( getLeftX() < box.getRightX() && getRightX() > box.getLeftX() &&
			    getHighestY() > box.getLowestY() && getLowestY() < box.getHighestY() )
			return true;
		return false;
		
	}
}
