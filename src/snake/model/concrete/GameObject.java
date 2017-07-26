package snake.model.concrete;

public class GameObject implements snake.model.GameObject {

	private int _x;
	private int _y;
	
	private Type _t;
	
	public GameObject(int x, int y, Type t) {
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
