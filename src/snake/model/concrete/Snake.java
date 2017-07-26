package snake.model.concrete;

import java.util.List;

public class Snake implements snake.model.Snake {
	
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
	
	// TODO refine this more.
	
	public Snake(int x, int y, Direction direction,int length) {
		_x = x;
		_y = y;
		for(int i = 0; i < length; i++) {
			grow();
		}
		_direction = direction;
	}
	
	@Override
	public boolean isAt(int x, int y) {
		for(SnakeSegment segment : _segments) {
			if(segment.x == x && segment.y == y) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int getHeadX() {
		return _x;
	}
	
	@Override
	public int getHeadY() {
		return _y;
	}
	
	@Override
	public int getLength() {
		return _segments.size();
	}
	
	@Override
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

	@Override
	public void setDirection(Direction d) {
		_direction = d;
	}
	
	@Override
	public void grow() {
		_segments.add(new SnakeSegment(_x,_y));
	}
	
}
