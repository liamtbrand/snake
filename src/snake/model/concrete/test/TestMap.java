package snake.model.concrete.test;

import snake.model.Map;

public class TestMap implements Map {
	
	private int data[][] = new int[][] {
		{1,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,0,1},
		{1,0,0,1,1,1,0,0,0,1},
		{0,0,0,0,0,0,0,0,0,0},
		{1,0,0,0,0,0,0,0,0,1},
		{1,0,0,1,0,0,1,1,0,1},
		{1,0,0,0,0,0,1,0,0,1},
		{1,0,0,0,0,0,0,0,0,1},
		{1,1,1,1,1,1,1,1,1,1}
	};

	@Override
	public int getWidth() {
		return 10;
	}

	@Override
	public int getHeight() {
		return 10;
	}

	@Override
	public boolean isWall(int x, int y) {
		if(data[y][x] == 1) {
			return true;
		}else {
			return false;
		}
	}

	
	
}
