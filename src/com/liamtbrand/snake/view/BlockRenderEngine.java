package com.liamtbrand.snake.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.AbstractSnake;
import com.liamtbrand.snake.model.IGameObjectModel.Type;

public class BlockRenderEngine extends RenderEngine {
	
	private int scale = 10; // default scale
	private int xOffset = 0;
	private int yOffset = 0;
	
	public BlockRenderEngine(int scale) {
		this.scale = scale;
	}

	public void calculateScale(Dimension size) {
		//dim = width * scale
		//scale = dim / width
		
		double scaleX = size.getWidth() / stage.getMap().getWidth();
		double scaleY = size.getHeight() / stage.getMap().getHeight();
		
		scale = (int) Math.min(scaleX, scaleY);
		
		xOffset = (int) ((size.getWidth() - scale * stage.getMap().getWidth()) / 2); 
		yOffset = (int) ((size.getHeight() - scale * stage.getMap().getHeight()) / 2);
	}
	
	@Override
	public void renderStage() {
		
	}
	
	private void renderMap(Graphics g) {
		for(int x = 0; x < stage.getMap().getWidth(); x++) {
			for(int y = 0; y < stage.getMap().getHeight(); y++) {
				if(stage.getMap().isWall(x, y)) {
					g.fillRect(xOffset + x*scale, yOffset + y*scale, scale, scale);
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
			g.fillRect(xOffset + object.model.getX()*scale, yOffset + object.model.getY()*scale, scale, scale);
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
				g.fillRect(xOffset + snake.model.getSegmentX(i)*scale, yOffset + snake.model.getSegmentY(i)*scale, scale, scale);
			}
			g.setColor(new Color(0.8f,0.5f,0.5f));
			g.fillRect(xOffset + snake.model.getSegmentX(0)*scale, yOffset + snake.model.getSegmentY(0)*scale, scale, scale);
		}
		g.setColor(new Color(0.0f,0.0f,0.0f));
	}
	
	public void renderStage(Graphics g) {
		clearMap(g);
		renderMap(g);
		renderGameObjects(g);
		renderSnakes(g);
	}

	private void clearMap(Graphics g) {
		g.clearRect(0, 0, scale * stage.getMap().getWidth() + xOffset * 2, scale * stage.getMap().getHeight() + yOffset * 2);
	}
	
}
