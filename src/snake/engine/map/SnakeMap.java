package snake.engine.map;

/**
 * 
 * @author liamtbrand
 *
 */
public class SnakeMap implements Map {
	
	private int[] _data;
	private int _width;
	private int _height;

	@Override
	public int getWidth() {
		return _width;
	}

	@Override
	public int getHeight() {
		return _height;
	}

	@Override
	public boolean isWall(int x, int y) {
		if(
			x >= _width ||
			x < 0 ||
			y >= _height ||
			y < 0
		){
			return true;
		}
		return (_data[x+y*_width] == 1) ? true : false;
	}

}
