package com.liamtbrand.snake.controller.concrete;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.model.IGameObjectModel;

public class WormholeObject extends AbstractGameObject {
	
	public final int outx;
	public final int outy;

	public WormholeObject(IGameObjectModel model, int outx, int outy) {
		super(model);
		this.outx = outx;
		this.outy = outy;
	}

	@Override
	public void onEat() {
		destroy = false;
	}

}
