package lobos.andrew.game.physics;

import lobos.andrew.game.scene.SceneObject;

public class Force {
	float x,y,targetIterations;
	float iterations = 0;
	public Force(float x, float y, float targetIterations)
	{
		this.x = x;
		this.y = y;
		this.targetIterations = targetIterations;
	}
	
	public Force(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.iterations = 0;		
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public void update(SceneObject obj)
	{
		float xPos = obj.getX(), yPos = obj.getY();
		obj.setLocation(xPos+x, yPos+y);
	}
	
	public void finishedIteration()
	{
		iterations++;
	}
	
	public boolean shouldApply()
	{
		if ( targetIterations == 0 )
			return true;
		return (targetIterations>iterations);
	}
	
	public void stop()
	{
		targetIterations = -1;
	}
	
}

