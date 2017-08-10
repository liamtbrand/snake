package com.liamtbrand.snake.controller.concrete;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.AbstractSnake;
import com.liamtbrand.snake.model.ISnakeModel;

public class Snake extends AbstractSnake {

	public Snake(ISnakeModel model) {
		super(model);
	}

	@Override
	public void eat(AbstractGameObject object) {
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

	@Override
	public void onDie() {
		// TODO Auto-generated method stub
		
	}

}
