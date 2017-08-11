package com.liamtbrand.snake.controller.concrete;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.model.IGameObjectModel;

public class WormholeExitObject extends AbstractGameObject {

	public WormholeExitObject(IGameObjectModel model) {
		super(model);
	}

	@Override
	public void onEat() {
		destroy = false;
	}

}
