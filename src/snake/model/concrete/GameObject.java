package snake.model.concrete;

public class GameObject implements snake.model.GameObject {

	private int _x;
	private int _y;
	
	public GameObject(int x, int y) {
		_x = x;
		_y = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This should be called when the object is collided with.
	 * Object specific behaviour will then be actioned.
	 * The collider is passed in case this is needed for something.
	 * @param collider
	 */
	/*
	public abstract void onCollision(Snake collider);
	*/
	
}
