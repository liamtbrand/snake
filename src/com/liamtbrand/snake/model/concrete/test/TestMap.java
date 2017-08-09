package com.liamtbrand.snake.model.concrete.test;

import com.liamtbrand.snake.model.IMapModel;

public class TestMap implements IMapModel {
	
	private int data[][] = new int[][] {
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,1,1,1,0,0,0,1,0,0,1,1,0,0,0,0,0,1},
		{0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0},
		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
		{1,0,0,1,0,0,1,1,0,0,0,0,0,0,0,1,1,1,0,1},
		{1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};

	@Override
	public int getWidth() {
		return 20;
	}

	@Override
	public int getHeight() {
		return 10;
	}

	@Override
	public boolean isWall(int x, int y) {
		
		if(x < 0 || y < 0 || x >= 20 || y >= 10) {
			return false;
		}
		
		if(data[y][x] == 1) {
			return true;
		}else {
			return false;
		}
	}

	
	
}
