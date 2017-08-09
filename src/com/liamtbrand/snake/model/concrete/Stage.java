package com.liamtbrand.snake.model.concrete;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.liamtbrand.snake.controller.AbstractGameObject;
import com.liamtbrand.snake.controller.AbstractSnake;
import com.liamtbrand.snake.controller.IStage;
import com.liamtbrand.snake.model.IMapModel;

public class Stage implements IStage {

	private volatile IMapModel map;
	private volatile Set<AbstractGameObject> objects;
	private volatile Set<AbstractSnake> snakes;
	
	public Stage(IMapModel map) {
		clearStage();
		this.map = map;
	}

	/**
	 * Used to prevent map drawing calls from calling an empty object.
	 * @return
	 */
	private IMapModel getEmptyMap() {
		return new IMapModel() {

			@Override
			public int getWidth() {
				return 0;
			}

			@Override
			public int getHeight() {
				return 0;
			}

			@Override
			public boolean isWall(int x, int y) {
				return false;
			}
			
		};
	}
	
	@Override
	public void clearStage() {
		map = getEmptyMap();
		objects = new HashSet<AbstractGameObject>();
		snakes = new HashSet<AbstractSnake>();
	}

	@Override
	public void addGameObject(AbstractGameObject go) {
		if(!objects.contains(go)) {
			objects.add(go);
		}
	}

	@Override
	public void removeGameObject(AbstractGameObject go) {
		if(objects.contains(go)) {
			objects.remove(go);
		}
	}

	@Override
	public Set<AbstractGameObject> getGameObjectsAt(int x, int y) {
		Set<AbstractGameObject> obs = new HashSet<AbstractGameObject>();
		for(AbstractGameObject object : objects) {
			if(object.model.getX() == x && object.model.getY() == y) {
				obs.add(object);
			}
		}
		return obs;
	}

	@Override
	public Iterator<AbstractGameObject> getGameObjectIterator() {
		return objects.iterator();
	}

	@Override
	public void addSnake(AbstractSnake snake) {
		if(!snakes.contains(snake)) {
			snakes.add(snake);
		}
	}

	@Override
	public void removeSnake(AbstractSnake snake) {
		if(snakes.contains(snake)) {
			snakes.remove(snake);
		}
	}

	@Override
	public Set<AbstractSnake> getSnakesAt(int x, int y) {
		Set<AbstractSnake> snks = new HashSet<AbstractSnake>();
		for(AbstractSnake snk : snakes) {
			if(snk.model.getSegmentX(0) == x && snk.model.getSegmentY(0) == y) {
				snks.add(snk);
			}
		}
		return snks;
	}
	
	@Override
	public Iterator<AbstractSnake> getSnakeIterator() {
		return snakes.iterator();
	}
	
	@Override
	public void setMap(IMapModel map) {
		this.map = map;
	}
	
	@Override
	public IMapModel getMap() {
		return map; // TODO make unmodifiable?
	}
	
}
