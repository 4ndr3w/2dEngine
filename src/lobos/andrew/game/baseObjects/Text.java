package lobos.andrew.game.baseObjects;

import java.awt.Font;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import com.sun.opengl.util.j2d.TextRenderer;

import lobos.andrew.game.scene.BasicObject;

public class Text extends BasicObject {
	TextRenderer renderer = null;
	String text = "";
	public Text(Font font, float xPos, float yPos)
	{
		super(xPos, yPos);
		renderer = new TextRenderer(font);
	}
	
	public void setFont(Font f)
	{
		renderer = new TextRenderer(f);
	}
	
	@Override
	public void renderObject(GL gl, GLAutoDrawable renderable) 
	{
		renderer.beginRendering(renderable.getWidth(), renderable.getHeight());
		renderer.setColor(color);
		renderer.draw(text, (int)Math.floor((getX()+0.5f)*renderable.getWidth()), (int)Math.floor((getY()+0.5f)*renderable.getHeight()));
		renderer.endRendering();
	}
	
	public void setText(String t)
	{
		text = t;
	}
	
	public String getText()
	{
		return text;
	}
}
