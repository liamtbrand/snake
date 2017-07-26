package snake.model;

/**
 * This interface controls the interaction with a snake.
 * @author liamtbrand
 *
 */
public interface Snake {
	
	public static enum Direction {
		NORTH, SOUTH, EAST, WEST
	}

	/**
	 * Tests whether any part of the snake is on a given tile.
	 * @return True if the snake is at this tile.
	 */
	public boolean isAt(int x, int y);
	
	public int getHeadX();
	public int getHeadY();
	public int getLength();
	
	/**
	 * This moves the snake by 1 tile in the game.
	 * The snake will move onto this tile.
	 * Before calling this, you should check if the snake can really move here.
	 */
	public void move();
	
	/**
	 * Allows the direction of the snake to be set.
	 * When the snake moves, it's head will move in this direction.
	 * @param d
	 */
	public void setDirection(Direction d);
	
	/**
	 * This will cause a new segment to be added to the tail of the snake.
	 * The new segment will be at the same position as the last tail segment.
	 * The snake will appear to grow the following move.
	 */
	public void grow();
	
}
