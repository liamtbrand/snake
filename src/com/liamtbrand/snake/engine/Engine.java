package com.liamtbrand.snake.engine;

import java.util.Iterator;
import java.util.Set;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.AbstractSnake;
import com.liamtbrand.snake.controller.IStage;
import com.liamtbrand.snake.model.IMapModel;
import com.liamtbrand.snake.model.concrete.Stage;

public abstract class Engine {

	public IStage stage;
	
	public Engine() {
	}
	
	/**
	 * Changes the current map the engine is running.
	 * This will reset the stage, and all game variables.
	 * @param map
	 * @throws Exception
	 */
	@Deprecated
	public void selectMap(IMapModel map) throws Exception {
		//if(!running) {
			stage = new Stage(map);
		//}else {
		//	throw new Exception("Can't select a map while the engine is running!");
		//}
	}
	
	/**
	 * Runs the logic for the engine.
	 * This should be called on every tick.
	 */
	public void tick() {
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
			
			// Do the logic for each foreign snake.
			Set<AbstractSnake> otherSnakes = stage.getSnakesAt(headx, heady);
			if(otherSnakes.size() > 0) {
				snake.die(); // We crashed, so die.
				System.out.println("snake -> die");
				continue;
			}
			
			// Check for walls
			if(stage.getMap().isWall(headx, heady)) {
				snake.die(); // Death of the snake, we hit a wall!
				System.out.println("wall -> die");
				continue;
			} else {
				snake.model.moveTo(
					(headx+stage.getMap().getWidth())%stage.getMap().getWidth(),
					(heady+stage.getMap().getHeight())%stage.getMap().getHeight()
				);
			}
			
			// Do the logic for each object.
			Set<AbstractGameObject> objects = stage.getGameObjectsAt(headx, heady);
			for(AbstractGameObject object : objects) {
				snake.eat(object);
				System.out.println("object -> eat");
			}
			
		}
	}
	
}
