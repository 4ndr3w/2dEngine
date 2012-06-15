import java.awt.event.KeyEvent;

import lobos.andrew.game.objects.Player;
import lobos.andrew.game.scene.Scene;


public class MyClass extends Scene {

	public MyClass()
	{
		addObject(new Player(0.2f, 0.2f));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
