package lobos.andrew.game.baseObjects;

import static org.lwjgl.opengl.GL11.*;

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
	
	public void render()
	{
		if ( !renderBoxes )
			return;
		
		glBegin(GL_LINES);
		
		glVertex2d(getLeftX(), getHighestY());
		glVertex2d(getRightX(), getHighestY());
		
		glVertex2d(getLeftX(), getLowestY());
		glVertex2d(getRightX(), getLowestY());
		
		glVertex2d(getLeftX(), getHighestY());
		glVertex2d(getLeftX(), getLowestY());
		
		glVertex2d(getRightX(), getHighestY());
		glVertex2d(getRightX(), getLowestY());
		
		glEnd();
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
	
	public boolean isAbove(BoundingBox box)
	{
		return false;
	}
	
	public boolean isBelow(BoundingBox box)
	{
		return false;
	}
	
	public boolean isLeftOf(BoundingBox box)
	{
		return false;
	}
	
	public boolean isRightOf(BoundingBox box)
	{
		return false;
	}
}
