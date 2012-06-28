

import lobos.andrew.game.baseObjects.Circle;
import lobos.andrew.game.baseObjects.Line;
import lobos.andrew.game.objects.ControllableCharacter;
import lobos.andrew.game.physics.Contact;
import lobos.andrew.game.scene.ContainerObject;

public class Player extends ContainerObject implements ControllableCharacter {
	public Player(float xPos, float yPos)
	{
		super(xPos, yPos);
		
		Line leg1 = new Line(0.0f, 0.0f, 0.05f, -0.05f, 0, 0);
		Line leg2 = new Line(0.0f, 0.0f, -0.05f, -0.05f, 0, 0);
		Line body = new Line(0.0f, 0.0f, 0.0f, 0.13f, 0, 0);
		
		Circle head = new Circle(0.03f, 0.0f, 0.155f);
		
		addObject(leg1);
		addObject(leg2);
		addObject(body);
		addObject(head);
		
		initPos();
	}

	@Override
	public void moveRight() {
		System.out.println("right");
		xPos += 0.02;
		initPos();
	}

	@Override
	public void moveLeft() {
		System.out.println("left");
		xPos -= 0.02;
		initPos();
	}

	@Override
	public void jump() {
		// TODO Implement
	}

	@Override
	public void moveUp() {
		yPos += 0.02;
		initPos();
		
	}

	@Override
	public void moveDown() {
		yPos -= 0.02;
		initPos();
		
	}

}
