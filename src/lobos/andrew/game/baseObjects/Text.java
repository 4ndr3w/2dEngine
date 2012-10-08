package lobos.andrew.game.baseObjects;

import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;

import lobos.andrew.game.scene.BasicObject;

public class Text extends BasicObject {
	UnicodeFont font = null;
	String text = "";
	public Text(Font font, float xPos, float yPos)
	{
		super(xPos, yPos);
		this.font = new UnicodeFont(font);
	}
	
	public void setFont(Font f)
	{
		this.font = new UnicodeFont(f);
	}
	
	@Override
	public void renderObject() 
	{
		font.drawString(getX(), getY(), text);
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
