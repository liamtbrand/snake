package snake.engine.object;

import snake.engine.Snake;

/**
 * This is a base object of the game.
 * It causes the snake that collides with it to grow.
 * @author liamtbrand
 *
 */
public class FoodObject extends GameObject {

	public FoodObject(int x, int y) {
		super(x, y);
	}

	@Override
	public void onCollision(Snake collider) {
		collider.grow();
		
	}
	
}
