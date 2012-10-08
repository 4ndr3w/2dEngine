package lobos.andrew.game.core;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import lobos.andrew.game.scene.Scene;


public class Renderer extends Thread
{
	
	private static Scene scene = null;

	public static void init(Scene firstScene) 
	{
		
		try {
			Display.setDisplayMode(new DisplayMode(800,800));
			Display.create();
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			
			GL11.glOrtho(0, 800, 800, 0, 0, 0);
			setScene(firstScene);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void renderLoop() {
		while ( !Display.isCloseRequested() )
		{
	        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	        GL11.glLoadIdentity();
	        
	        if ( scene != null )
	        	scene.render();
			GL11.glFlush();
			Display.update();
			Display.sync(10);
		}
	}

	
	public static void setScene(Scene s)
	{
		scene = s;
	}
	
	public static Scene getCurrentScene()
	{
		return scene;
	}

}
