package com.liamtbrand.snake.model.concrete.test;

import com.liamtbrand.snake.model.IMapModel;

public class RandomMap implements IMapModel {
	
	private int data[][] = new int[64][64];
	
	public RandomMap() {
		buildMap();
	}
	
	
	
	private void buildMap() {
		
		
		int heightmap[][] = new int[64][64];
		
		int distance = 64;
		int seed = 512;
		
		for(int x = 0; x < 64-1; x++) {
			for(int y = 0; y < 64-1; y++) {
				heightmap[x][y] = 0;
			}
		}
		heightmap[0][0] = seed;
		
		while(distance >= 1) {
			for(int x = 0; x <= 64 ; x += distance) {
				for(int y = 0; y <= 64; x += distance) {
					if(heightmap[x][y] == 0) {
						// ...
					}
				}
			}
			distance = distance / 2;
		}
		
		// Fill empty
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				data[x][y] = 0;
			}
		}
		
		// Edges
		for (int i = 0; i < data.length; ++i) { // horizontal
			data[i][0] = 1;
			data[i][data[0].length-1] = 1;
		}
		for (int i = 0; i < data[0].length; ++i) { // vertical
			data[0][i] = 1;
			data[data.length-1][i] = 1;
		}
		
		// Random values added
		
	}

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
