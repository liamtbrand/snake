package snake.engine.object;

import snake.engine.Snake;

/**
 * Game objects can be placed on the stage.
 * Each game object should extend this class.
 * These objects can have specific actions when
 * a snake collides with them.
 * @author liamtbrand
 *
 */
public abstract class GameObject {

	private int _x;
	private int _y;
	
	public GameObject(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	/**
	 * This should be called when the object is collided with.
	 * Object specific behaviour will then be actioned.
	 * The collider is passed in case this is needed for something.
	 * @param collider
	 */
	public abstract void onCollision(Snake collider);
	
}
