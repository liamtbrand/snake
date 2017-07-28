package snake.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import snake.model.GameObject;
import snake.model.Snake;

public class BlockRenderEngine extends RenderEngine {

	@Override
	public void renderStage() {
		
	}
	
	private void renderMap(Graphics g) {
		for(int x = 0; x < _stage.getMap().getWidth(); x++) {
			for(int y = 0; y < _stage.getMap().getHeight(); y++) {
				if(_stage.getMap().isWall(x, y)) {
					g.fillRect(x*10, y*10, 10, 10);
				}
			}
		}
	}
	
	private void renderGameObjects(Graphics g) {
		Iterator<GameObject> objects = _stage.getGameObjectIterator();
		GameObject object;
		while(objects.hasNext()) {
			object = objects.next();
			
			g.setColor(new Color(0.5f,0.8f,0.5f));
			g.fillRect(object.getX()*10, object.getY()*10, 10, 10);
			g.setColor(new Color(0.0f,0.0f,0.0f));
		}
	}
	
	private void renderSnakes(Graphics g) {
		Iterator<Snake> snakes = _stage.getSnakeIterator();
		Snake snake;
		int snakeLength;
		while(snakes.hasNext()) {
			snake = snakes.next();
			
			g.setColor(new Color(0.8f,0.5f,0.5f));
			g.fillRect(snake.getSegmentX(0)*10, snake.getSegmentY(0)*10, 10, 10);
			g.setColor(new Color(0.5f,0.5f,0.8f));
			for(int i = 1; i < snake.getLength(); i++) {
				g.fillRect(snake.getSegmentX(i)*10, snake.getSegmentY(i)*10, 10, 10);
			}
		}
		g.setColor(new Color(0.0f,0.0f,0.0f));
	}
	
	public void renderStage(Graphics g) {
		renderMap(g);
		renderGameObjects(g);
		renderSnakes(g);
	}
	
}
