package lobos.andrew.game.core;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import lobos.andrew.game.hid.Keyboard;
import lobos.andrew.game.scene.Scene;

import com.sun.opengl.util.Animator;

public class Renderer implements GLEventListener
{
	private Scene scene = null;
	
	private static Renderer instance = null;
	
	public static Renderer getInstance()
	{
		if ( instance == null )
			instance = new Renderer();
		return instance;
	}
	
	public Renderer()
	{
		Frame frame = new Frame("Game");
		frame.setTitle("Game");
		frame.setName("Game");
		
		GLCanvas canvas = new GLCanvas();
		canvas.addGLEventListener(this);
		frame.setSize(800, 800);
		frame.add(canvas);
		frame.addKeyListener(Keyboard.getInstance());
		canvas.addKeyListener(Keyboard.getInstance());
		
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

         @Override
         public void windowClosing(WindowEvent e) {
             new Thread(new Runnable() {
                 public void run() {
                     animator.stop();
                     System.exit(0);
                 }
             }).start();
         }
     });
     
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);   
	 animator.start();	
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        if ( scene != null )
        	scene.render(gl, drawable);
        
		gl.glFlush();
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		
		gl.setSwapInterval(1);
        gl.glShadeModel(GL.GL_SMOOTH);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        if (height <= 0)
            height = 1;

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
		
	}
	
	public void setScene(Scene s)
	{
		scene = s;
	}
	
	public Scene getCurrentScene()
	{
		return scene;
	}

}
