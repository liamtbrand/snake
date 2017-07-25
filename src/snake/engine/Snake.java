package snake.engine;

import java.util.List;

/**
 * This abstract class controls most of the snakes ability in the game.
 * @author liamtbrand
 *
 */
public abstract class Snake {
	
	public enum Direction {
		NORTH, SOUTH, EAST, WEST
	}
	
	public class SnakeSegment {
		private int x;
		private int y;
		public SnakeSegment(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private List<SnakeSegment> _segments;
	private int _x;
	private int _y;
	private Direction _direction;
	
	public Snake(int x, int y, Direction direction,int length) {
		_x = x;
		_y = y;
		for(int i = 0; i < length; i++) {
			grow();
		}
		_direction = direction;
	}

	/**
	 * Tests whether any part of the snake is on a given tile.
	 * @return True if the snake is at this tile.
	 */
	public boolean isAt(int x, int y) {
		for(SnakeSegment segment : _segments) {
			if(segment.x == x && segment.y == y) {
				return true;
			}
		}
		return false;
	}
	
	public int getHeadX() {
		return _x;
	}
	
	public int getHeadY() {
		return _y;
	}
	
	public int getLength() {
		return _segments.size();
	}
	
	/**
	 * This moves the snake by 1 tile in the game.
	 * The snake will move onto this tile.
	 * Before calling this, you should check if the snake can really move here.
	 */
	public void move() {
		switch(_direction) {
			case NORTH:
				_y -= 1;
				break;
			case SOUTH:
				_y += 1;
				break;
			case EAST:
				_x += 1;
				break;
			case WEST:
				_x -= 1;
				break;
			default:
				System.out.println("Impossible! - How?");
				break;
		}
		SnakeSegment s = _segments.get(_segments.size());
		_segments.remove(_segments.size());
		_segments.add(0, s);
	}
	
	/**
	 * This will cause a new segment to be added to the tail of the snake.
	 * The new segment will be at the same position as the last tail segment.
	 * The snake will appear to grow the following move.
	 */
	public void grow() {
		_segments.add(new SnakeSegment(_x,_y));
	}
	
}
