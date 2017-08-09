package com.liamtbrand.snake.engine;

import java.util.Iterator;
import java.util.Set;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.AbstractSnake;
import com.liamtbrand.snake.controller.IStage;
import com.liamtbrand.snake.model.IMapModel;
import com.liamtbrand.snake.model.ISnakeModel;
import com.liamtbrand.snake.model.concrete.Stage;

public abstract class Engine extends Thread {

	public IStage stage;
	
	private volatile boolean running;
	
	private long tickTime = 200;
	private long lastTick = 0;
	
	public Engine() {
		running = false;
	}
	
	/**
	 * Fetches the current time in millis.
	 * @return
	 */
	private long time() {
		return System.currentTimeMillis();
	}
	
	/**
	 * Changes the current map the engine is running.
	 * This will reset the stage, and all game variables.
	 * @param map
	 * @throws Exception
	 */
	public void selectMap(IMapModel map) throws Exception {
		if(!running) {
			stage = new Stage(map);
		}else {
			throw new Exception("Can't select a map while the engine is running!");
		}
	}
	
	/**
	 * Sets the time between ticks. Time is measured in millis.
	 * @param tick
	 */
	public void setEngineTickTime(long tick) {
		tickTime = tick;
	}
	
	public synchronized void run() {
		
		running = true;
		lastTick = time();
		long elapsed = 0;
		
		while(running) {
			
			// GAME LOGIC TODO
			
			// For each snake on the stage, do the logic for this snake.
			Iterator<AbstractSnake> snakes = stage.getSnakeIterator();
			AbstractSnake snake;
			int dx, dy;
			int headx, heady;
			while(snakes.hasNext()) {
				snake = snakes.next();
				dx = 0;
				dy = 0;
				
				switch(snake.model.getDirection()) {
					case NORTH:
						dy = -1;
						break;
					case SOUTH:
						dy = 1;
						break;
					case EAST:
						dx = 1;
						break;
					case WEST:
						dx = -1;
						break;
					default:
						System.out.println("Impossible?");
						break;
				}
				
				headx = snake.model.getSegmentX(0)+dx;
				heady = snake.model.getSegmentY(0)+dy;
				
				// Do the logic for each object.
				Set<AbstractGameObject> objects = stage.getGameObjectsAt(headx, heady);
				for(AbstractGameObject object : objects) {
					snake.eat(object);
				}
				
				// Do the logic for each foreign snake.
				Set<AbstractSnake> otherSnakes = stage.getSnakesAt(headx, heady);
				if(otherSnakes.size() > 0) {
					snake.die(); // We crashed, so die.
					continue;
				}
				
				// Check for walls
				if(stage.getMap().isWall(headx, heady)) {
					// Death of the snake, we hit a wall!
					
					// TODO make the death of the snake.
					snake.die();
					continue;
					
					// In the meantime, we will just freeze.
				} else {
					snake.model.moveTo(
						(headx+stage.getMap().getWidth())%stage.getMap().getWidth(),
						(heady+stage.getMap().getHeight())%stage.getMap().getHeight()
					);
				}
				
			}
			
			
			// wait for the remaining time, until the next tick.
			try {
				elapsed = time() - lastTick;
				if(elapsed < tickTime) {
					wait(tickTime - elapsed);
				}
				lastTick = time();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public void halt() {
		running = false;
	}
	
	public ISnakeModel spawnSnake() {
		return null;
	}
	
	public abstract void registerControls(Controls ctrls);
	
}
