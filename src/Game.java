 import lobos.andrew.game.core.Renderer;


public class Game {
	public static void main(String[] args) {
		Renderer.init(new MyScene());
		Renderer.renderLoop();
	}

}
