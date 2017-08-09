package com.liamtbrand.snake.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.AbstractSnake;

public class BlockRenderEngine extends RenderEngine {

	@Override
	public void renderStage() {
		
	}
	
	private void renderMap(Graphics g) {
		for(int x = 0; x < stage.getMap().getWidth(); x++) {
			for(int y = 0; y < stage.getMap().getHeight(); y++) {
				if(stage.getMap().isWall(x, y)) {
					g.fillRect(x*10, y*10, 10, 10);
				}
			}
		}
	}
	
	private void renderGameObjects(Graphics g) {
		Iterator<AbstractGameObject> objects = stage.getGameObjectIterator();
		AbstractGameObject object;
		while(objects.hasNext()) {
			object = objects.next();
			
			g.setColor(new Color(0.5f,0.8f,0.5f));
			g.fillRect(object.model.getX()*10, object.model.getY()*10, 10, 10);
			g.setColor(new Color(0.0f,0.0f,0.0f));
		}
	}
	
	private void renderSnakes(Graphics g) {
		Iterator<AbstractSnake> snakes = stage.getSnakeIterator();
		AbstractSnake snake;
		while(snakes.hasNext()) {
			snake = snakes.next();
			
			g.setColor(new Color(0.5f,0.5f,0.8f));
			for(int i = 1; i < snake.model.getLength(); i++) {
				g.fillRect(snake.model.getSegmentX(i)*10, snake.model.getSegmentY(i)*10, 10, 10);
			}
			g.setColor(new Color(0.8f,0.5f,0.5f));
			g.fillRect(snake.model.getSegmentX(0)*10, snake.model.getSegmentY(0)*10, 10, 10);
		}
		g.setColor(new Color(0.0f,0.0f,0.0f));
	}
	
	public void renderStage(Graphics g) {
		renderMap(g);
		renderGameObjects(g);
		renderSnakes(g);
	}
	
}
