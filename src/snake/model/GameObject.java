package snake.model;

/**
 * Game objects can be placed on the stage.
 * Each game object should implement this interface.
 * A game object should have a type, and position.
 * @author liamtbrand
 *
 */
public interface GameObject {
	
	public static enum Type {
		FOOD
	}
	
	public int getX();
	public int getY();
	public Type getType();
	
}
