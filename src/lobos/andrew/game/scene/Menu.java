package lobos.andrew.game.scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Vector;

import lobos.andrew.game.baseObjects.Text;
import lobos.andrew.game.core.Renderer;


public abstract class Menu extends Scene {
	
	Text bigText = new Text(new Font("SansSerif", Font.BOLD, 48), -0.4f, 0.19f);
	
	Font optionFont = new Font("SansSerif", Font.PLAIN, 12);
	Font selectedFont = new Font("SansSerif", Font.BOLD, 12);
	
	Vector<Text> options = new Vector<Text>();

	
	int selected = 0;
	
	public Menu(String title)
	{	
		bigText.setText(title);
		bigText.setColor(Color.GREEN);
		
		setBackgroundColor(Color.BLACK);
		addObject(bigText);
	}
	
	public void addOption(String name)
	{
		Text t = new Text(optionFont, -0.339f, 0.15f-(0.025f*options.size()));
		t.setColor(Color.GREEN);
		t.setText(name);
		if ( options.size() == 0 )
			t.setFont(selectedFont);
		addObject(t);
		options.add(t);
	}
	
	protected abstract void optionSelected(int selected);
	
	@Override
	public void keyPressed(KeyEvent event) 
	{
		super.keyPressed(event);

		if ( event.getKeyCode() == 10 ) // Enter Key
		{
			optionSelected(selected);
		}
		
		if ( event.getKeyCode() == KeyEvent.VK_UP )
		{
			selected--;
			if ( selected < 0 )
				selected = options.size();
		}
		
		if ( event.getKeyCode() == KeyEvent.VK_DOWN )
		{
			selected++;
			if ( selected > options.size() )
				selected = 0;
		}
		
		
		for ( int i = 0; i < options.size(); i++ )
		{
			
			if ( i == selected )
				options.get(i).setFont(selectedFont);
			else options.get(i).setFont(optionFont);
		}
	}
	
	@Override
	public void sceneLogic() {
		
		
	}
	

}
