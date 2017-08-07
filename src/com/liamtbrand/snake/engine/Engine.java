package com.liamtbrand.snake.engine;

import java.util.Iterator;
import java.util.Set;

import com.liamtbrand.snake.model.GameObject;
import com.liamtbrand.snake.model.Map;
import com.liamtbrand.snake.model.Snake;
import com.liamtbrand.snake.model.Stage.InvalidIdException;
import com.liamtbrand.snake.model.concrete.Stage;

public abstract class Engine extends Thread {

	private com.liamtbrand.snake.model.Stage _stage;
	
	private volatile boolean _running;
	
	private long _tickTime = 200;
	private long _lastTick = 0;
	
	public Engine() {
		_running = false;
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
	public void selectMap(Map map) throws Exception {
		if(!_running) {
			_stage = new Stage(map);
		}else {
			throw new Exception("Can't select a map while the engine is running!");
		}
	}
	
	/**
	 * Sets the time between ticks. Time is measured in millis.
	 * @param tick
	 */
	public void setEngineTickTime(long tick) {
		_tickTime = tick;
	}
	
	public synchronized void run() {
		
		_running = true;
		_lastTick = time();
		long elapsed = 0;
		
		while(_running) {
			
			// GAME LOGIC TODO
			
			// For each snake on the map, do the logic for this snake.
			Iterator<Snake> snakes = _stage.getSnakeIterator();
			Snake snake;
			int dx, dy;
			while(snakes.hasNext()) {
				snake = snakes.next();
				
				dx = 0;
				dy = 0;
				switch(snake.getDirection()) {
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
				
				// Do the logic for each object.
				GameObject object;
				Set<Integer> ids = _stage.getGameObjectIds();
				for(int key : ids) {
					try {
						object = _stage.getGameObject(key);
						
						if(	object.getX() == snake.getSegmentX(0) + dx &&
							object.getY() == snake.getSegmentY(0) + dy
						) {
							if(object.getType() == GameObject.Type.FOOD) {
								_stage.removeGameObject(key);
								snake.grow();
							}
						}
						
					} catch (InvalidIdException e) {
						e.printStackTrace();
					}
				}
				
				// Do the logic for each foreign snake.
				
				
				
				// Check for walls
				if(_stage.getMap().isWall(snake.getSegmentX(0)+dx, snake.getSegmentY(0)+dy)) {
					// Death of the snake, we hit a wall!
					
					// TODO make the death of the snake.
					
					// In the meantime, we will just freeze.
				} else {
					snake.moveTo(
						(snake.getSegmentX(0)+dx+_stage.getMap().getWidth())%_stage.getMap().getWidth(),
						(snake.getSegmentY(0)+dy+_stage.getMap().getHeight())%_stage.getMap().getHeight()
					);
				}
			}
			
			// wait for the remaining time, until the next tick.
			try {
				elapsed = time() - _lastTick;
				if(elapsed < _tickTime) {
					wait(_tickTime - elapsed);
				}
				_lastTick = time();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public void halt() {
		_running = false;
	}
	
	public Snake spawnSnake() {
		return null;
	}
	
	public com.liamtbrand.snake.model.Stage getStage() {
		return _stage;
	}
	
	public abstract void registerControls(Controls ctrls);
	
}
