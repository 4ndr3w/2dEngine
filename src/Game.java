import lobos.andrew.game.core.Renderer;


public class Game {
	public static void main(String[] args) {
		Renderer r = new Renderer();
		MyClass level = new MyClass();
		
		r.setScene(level);
		
	}

}
