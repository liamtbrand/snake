package com.liamtbrand.snake.controller;

import com.liamtbrand.snake.model.IGameObjectModel;

public abstract class AbstractGameObject {
	
	protected boolean eaten;
	public final IGameObjectModel model;
	
	public AbstractGameObject(IGameObjectModel model) {
		this.model = model;
		eaten = false;
	}
	
	/**
	 * When a game object is eaten, this method should be invoked.
	 * The object specific behaviour should be implemented in onEat().
	 */
	public final void eat() {
		eaten = true;
		onEat();
	}
	
	/**
	 * Object specific behaviour.
	 */
	public void onEat() { /* Default do nothing. */ };
	
}
