package lobos.andrew.game.hid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	private KeyListener listener = null;
	private static Keyboard instance = null;
	private Keyboard()
	{
		 
	}
	
	public static Keyboard getInstance()
	{
		if ( instance == null )
			instance = new Keyboard();
		return instance;
	}
	
	public void setHandler(KeyListener listener)
	{
		this.listener = listener;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if ( listener != null ) listener.keyPressed(e);		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if ( listener != null ) listener.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if ( listener != null ) listener.keyTyped(e);
	}

}
