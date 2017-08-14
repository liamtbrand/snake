package com.liamtbrand.snake.engine.mechanic;

import com.liamtbrand.snake.engine.Engine;

public abstract class AbstractMechanic implements Runnable {
	protected Engine engine;
	public AbstractMechanic(Engine engine) {
		this.engine = engine;
		this.engine.addMechanic(this);
	}
}
