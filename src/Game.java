 import lobos.andrew.game.core.Renderer;


public class Game {
	public static void main(String[] args) {
		Renderer r = Renderer.getInstance();
		MyScene level = new MyScene();
		
		r.setScene(level);
	}

}
