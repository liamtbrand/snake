package com.liamtbrand.snake.model;

/**
 * This interface controls the interaction with a snake's data model.
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
	
	/**
	 * Segment head is at position 0.
	 * @return The length of the snake in segments.
	 */
	public int getLength();
	
	/**
	 * Get the x coordinate for the given segment.
	 * @param segment
	 * @return y coordinate
	 */
	public int getSegmentX(int segment);
	
	/**
	 * Get the y coordinate for the given segment.
	 * @param segment
	 * @return x coordinate
	 */
	public int getSegmentY(int segment);
	
	/**
	 * This moves the head of the snake to the position given.
	 * @param x
	 * @param y
	 */
	public void moveTo(int x, int y);
	
	/**
	 * Allows the direction of the snake to be set.
	 * When the snake moves, it's head will move in this direction.
	 * @param d
	 */
	public void setDirection(Direction d);
	
	/**
	 * Allows the direction of the snake to be observed.
	 * This can be used to move the snake in this direction.
	 * @return
	 */
	public Direction getDirection();
	
	/**
	 * This will cause a new segment to be added to the tail of the snake.
	 * The new segment will be at the same position as the last tail segment.
	 * The snake will appear to grow the following move.
	 */
	public void grow();
	
	/**
	 * This will cause the last tail segment to be removed.
	 */
	public void shrink();
	
}
