package com.liamtbrand.snake.engine;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.AbstractSnake;
import com.liamtbrand.snake.controller.IStage;
import com.liamtbrand.snake.engine.mechanic.AbstractMechanic;

public class Engine {

	public IStage stage;
	private Set<AbstractMechanic> mechanics;
	
	public Engine(IStage stage) {
		this.stage = stage;
		this.mechanics = new HashSet<AbstractMechanic>();
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
			
			dx = snake.model.getDirection().dx();
			dy = snake.model.getDirection().dy();
			
			headx = snake.model.getSegmentX(0)+dx;
			heady = snake.model.getSegmentY(0)+dy;
			
			// Do the logic for each foreign snake.
			Set<AbstractSnake> otherSnakes = stage.getSnakesAt(headx, heady);
			if(otherSnakes.size() > 0) {
				snake.die(); // We crashed, so die.
				continue;
			}
			
			// Check for walls
			if(stage.getMap().isWall(headx, heady)) {
				snake.die(); // Death of the snake, we hit a wall!
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
				if(object.destroyed() == true) {
					stage.removeGameObject(object);
				}
			}
			
		}
		
		// Game mechanics, run them all!
		for(AbstractMechanic mechanic : mechanics) {
			mechanic.run();
		}
	}
	
	/**
	 * Adds a game mechanic. Each mechanic should be runnable.
	 * The mechanics will be run on each tick.
	 * @param mechanic
	 */
	public void addMechanic(AbstractMechanic mechanic) {
		if(!mechanics.contains(mechanic)) {
			mechanics.add(mechanic);
		}
	}
	
	/**
	 * Removes a game mechanic.
	 * @param mechanic
	 */
	public void removeMechanic(AbstractMechanic mechanic) {
		if(mechanics.contains(mechanic)) {
			mechanics.remove(mechanic);
		}
	}
	
}
