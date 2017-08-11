package com.liamtbrand.snake.controller;

import com.liamtbrand.snake.model.ISnakeModel;

public abstract class AbstractSnake {
	
	private boolean destroy;
	public final ISnakeModel model;
	
	public AbstractSnake(ISnakeModel model) {
		this.model = model;
		destroy = false;
	}
	
	/**
	 * This should be called when a snake is to eat an object.
	 */
	public abstract void eat(AbstractGameObject object);
	
	/**
	 * When a snake dies, this method should be invoked.
	 */
	public final void die() {
		destroy = true;
		onDie();
	}
	
	/**
	 * This method should be overridden with specific behaviour,
	 * for when the snake dies.
	 */
	public abstract void onDie();
	
	/**
	 * Used to clean up snakes from the stage.
	 * @return
	 */
	public boolean destroyed() {
		return destroy;
	}
	
}
