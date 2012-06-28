package lobos.andrew.game.hid;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
	static private Mouse instance = null;
	
	static public Mouse getInstance()
	{
		if ( instance == null )
			instance = new Mouse();
		return instance;
	}
	
	public Mouse()
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		System.out.println("Mouse clicked at ("+event.getX()+","+event.getY()+")");
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		System.out.println("Mouse entered at ("+event.getX()+","+event.getY()+")");
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		System.out.println("Mouse exited at ("+event.getX()+","+event.getY()+")");
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		System.out.println("Mouse pressed at ("+event.getX()+","+event.getY()+")");
		
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		System.out.println("Mouse released at ("+event.getX()+","+event.getY()+")");
		
	}
}
