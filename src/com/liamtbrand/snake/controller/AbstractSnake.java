package com.liamtbrand.snake.controller;

import com.liamtbrand.snake.controller.concrete.FoodObject;
import com.liamtbrand.snake.controller.concrete.WormholeObject;
import com.liamtbrand.snake.model.ISnakeModel;

public abstract class AbstractSnake {
	
	private boolean alive;
	public final ISnakeModel model;
	
	public AbstractSnake(ISnakeModel model) {
		this.model = model;
		alive = true;
	}
	
	/**
	 * This should be called when a snake is to eat an object.
	 */
	public final void eat(AbstractGameObject object) {
		if(object instanceof FoodObject) {
			object.eat();
			this.model.grow();
		}
		if(object instanceof WormholeObject) {
			WormholeObject wh = (WormholeObject) object;
			object.eat();
			this.model.moveTo(wh.outx,wh.outy);
		}
	}
	
	/**
	 * When a snake dies, this method should be invoked.
	 */
	public final void die() {
		alive = false;
		onDie();
	}
	
	/**
	 * This method should be overridden with specific behaviour,
	 * for when the snake dies.
	 */
	public void onDie() {
		// Some callback.
	}
	
}
