package com.liamtbrand.snake.model.concrete;

import java.util.ArrayList;
import java.util.List;

public class BasicSnakeModel implements com.liamtbrand.snake.model.ISnakeModel {
	
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
	
	public BasicSnakeModel(int x, int y, Direction direction,int length) {
		_x = x;
		_y = y;
		_segments = new ArrayList<SnakeSegment>();
		_segments.add(new SnakeSegment(_x,_y));
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
	public int getLength() {
		return _segments.size();
	}

	@Override
	public void setDirection(Direction d) {
		_direction = d;
	}
	
	@Override
	public void grow() {
		_segments.add(new SnakeSegment(_segments.get(0).x,_segments.get(0).y));
	}

	@Override
	public int getSegmentX(int segment) {
		return _segments.get(segment).x;
	}

	@Override
	public int getSegmentY(int segment) {
		return _segments.get(segment).y;
	}

	@Override
	public void moveTo(int x, int y) {
		SnakeSegment s = _segments.get(_segments.size()-1);
		_segments.remove(_segments.size()-1);
		s.x = x;
		s.y = y;
		_segments.add(0, s);
	}

	@Override
	public Direction getDirection() {
		return _direction;
	}

	@Override
	public void shrink() {
		_segments.remove(_segments.size()-1);
	}
	
}
