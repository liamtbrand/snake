package com.liamtbrand.snake.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.AbstractSnake;
import com.liamtbrand.snake.model.IGameObjectModel.Type;

public class BlockRenderEngine extends RenderEngine {
	
	private int scale = 10; // default scale
	
	public BlockRenderEngine(int scale) {
		this.scale = scale;
	}

	@Override
	public void renderStage() {
		
	}
	
	private void renderMap(Graphics g) {
		for(int x = 0; x < stage.getMap().getWidth(); x++) {
			for(int y = 0; y < stage.getMap().getHeight(); y++) {
				if(stage.getMap().isWall(x, y)) {
					g.fillRect(x*scale, y*scale, scale, scale);
				}
			}
		}
	}
	
	private void renderGameObjects(Graphics g) {
		Iterator<AbstractGameObject> objects = stage.getGameObjectIterator();
		AbstractGameObject object;
		while(objects.hasNext()) {
			object = objects.next();
			
			if(object.model.getType() == Type.FOOD) {
				g.setColor(new Color(0.5f,0.8f,0.5f));
			}
			if(object.model.getType() == Type.WORMHOLE) {
				g.setColor(new Color(0.8f,0.8f,1.0f));
			}
			g.fillRect(object.model.getX()*scale, object.model.getY()*scale, scale, scale);
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
				g.fillRect(snake.model.getSegmentX(i)*scale, snake.model.getSegmentY(i)*scale, scale, scale);
			}
			g.setColor(new Color(0.8f,0.5f,0.5f));
			g.fillRect(snake.model.getSegmentX(0)*scale, snake.model.getSegmentY(0)*scale, scale, scale);
		}
		g.setColor(new Color(0.0f,0.0f,0.0f));
	}
	
	public void renderStage(Graphics g) {
		renderMap(g);
		renderGameObjects(g);
		renderSnakes(g);
	}
	
}
