import lobos.andrew.game.baseObjects.Circle;
import lobos.andrew.game.baseObjects.Line;
import lobos.andrew.game.scene.Scene;


public class MyScene extends Scene {
	Circle hitme = new Circle(0.2f, 0, 0.2f);
	Line otherHit = new Line(
			0, 0, 
			0.5f, 0,
			0, -0.5f);
	Player player = new Player(0.2f, 0.2f);
	public MyScene()
	{
		player.setGravityAffected(true);
		
		addObject(player);
		addObject(hitme);
		addObject(otherHit);
		setCharacter(player);
	}
	@Override
	public void sceneLogic() {
		// TODO Auto-generated method stub
		
	}


}
