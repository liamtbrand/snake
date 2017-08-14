package com.liamtbrand.snake.engine.mechanic;

import java.util.Random;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.concrete.FoodObject;
import com.liamtbrand.snake.engine.Engine;
import com.liamtbrand.snake.model.IGameObjectModel;
import com.liamtbrand.snake.model.concrete.BasicGameObjectModel;

public class SpawnFoodMechanic extends AbstractMechanic {

	private AbstractGameObject food;
	
	public SpawnFoodMechanic(Engine engine) {
		super(engine);
	}

	@Override
	public void run() {
		if(food == null || food.destroyed()) {
			int newFoodX = new Random().nextInt(engine.stage.getMap().getWidth());
			int newFoodY = new Random().nextInt(engine.stage.getMap().getHeight());
			if(!engine.stage.getMap().isWall(newFoodX, newFoodY)) {
				food = new FoodObject(new BasicGameObjectModel(newFoodX, newFoodY, IGameObjectModel.Type.FOOD));
				engine.stage.addGameObject(food);
			}
		}
	}

}
