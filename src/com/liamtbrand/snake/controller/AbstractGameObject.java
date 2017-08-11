package com.liamtbrand.snake.controller;

import com.liamtbrand.snake.model.IGameObjectModel;

public abstract class AbstractGameObject {
	
	protected boolean destroy;
	public final IGameObjectModel model;
	
	public AbstractGameObject(IGameObjectModel model) {
		this.model = model;
		destroy = false;
	}
	
	/**
	 * When a game object is eaten, this method should be invoked.
	 * The object specific behaviour should be implemented in onEat().
	 */
	public final void eat() {
		destroy = true;
		onEat();
	}
	
	/**
	 * Object specific behaviour.
	 */
	public abstract void onEat();
	
	/**
	 * Used to clean up game objects from the stage.
	 * @return
	 */
	public boolean destroyed() {
		return destroy;
	}
	
}
