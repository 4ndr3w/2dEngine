package lobos.andrew.game.baseObjects;

import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import lobos.andrew.game.scene.BasicObject;

public class Image extends BasicObject {

	int height, width;
	BufferedImage bufferedImage = null;
	ByteBuffer byteBuffer = null;
	static private int lastTextureID = 0;
	int myTexture = 0;
	public Image(float xPos, float yPos, int h, int w, BufferedImage file) throws IOException {
		super(xPos, yPos);
		
		lastTextureID++;
		
		height = file.getHeight();
		width = file.getWidth();
		
		bufferedImage = file;
		
		WritableRaster raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,
				w,
				h,
				4,
				null);
		ComponentColorModel colorModel = new ComponentColorModel(
				ColorSpace.getInstance(ColorSpace.CS_sRGB),
				new int[] {8,8,8,8},
				true,
				false,
				ComponentColorModel.TRANSLUCENT,
				DataBuffer.TYPE_BYTE);
		BufferedImage dImg = new BufferedImage(colorModel, raster, false, null);
		
		Graphics2D g = dImg.createGraphics();
		g.drawImage(bufferedImage, null, null);
		DataBufferByte dBuf = (DataBufferByte)raster.getDataBuffer();
		
		byte[] dRGBA = dBuf.getData();
		byteBuffer = ByteBuffer.wrap(dRGBA);
		byteBuffer.position(0);
		byteBuffer.mark();
		
		lastTextureID++;
		myTexture = lastTextureID;

		
	}

	@Override
	public void renderObject(GL gl, GLAutoDrawable renderable) {
		
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, 300, 300, 0, 0, 1);
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glDisable(GL.GL_DEPTH_TEST);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);  
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBlendFunc (GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA); 
		gl.glEnable (GL.GL_BLEND);
		
		gl.glBindTexture(GL.GL_TEXTURE_2D, myTexture);
		gl.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
		gl.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
		gl.glTexImage2D (GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, width, height, 0, GL.GL_RGBA, 
				GL.GL_UNSIGNED_BYTE, byteBuffer);
		gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glBindTexture (GL.GL_TEXTURE_2D, myTexture);
		gl.glBegin (GL.GL_POLYGON);
		gl.glTexCoord2d (0, 0);
		gl.glVertex2d (0,0);
		gl.glTexCoord2d(1,0);
		gl.glVertex2d (0 + width, 0);
		gl.glTexCoord2d(1,1);
		gl.glVertex2d (width, width);
		gl.glTexCoord2d(0,1);
		gl.glVertex2d (0, 0 + width);
		gl.glEnd ();	
		gl.glFlush();
	}

}
