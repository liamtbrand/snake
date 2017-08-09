package com.liamtbrand.snake.model.concrete;

import com.liamtbrand.snake.model.IGameObjectModel;

public class BasicGameObjectModel implements IGameObjectModel {

	private int _x;
	private int _y;
	
	private Type _t;
	
	public BasicGameObjectModel(int x, int y, Type t) {
		_x = x;
		_y = y;
		_t = t;
	}

	@Override
	public int getX() {
		return _x;
	}

	@Override
	public int getY() {
		return _y;
	}

	@Override
	public Type getType() {
		return _t;
	}
	
}
