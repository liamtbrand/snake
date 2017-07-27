package snake.model.concrete;

import java.util.Collections;
import java.util.Iterator;

import snake.model.GameObject;
import snake.model.Map;
import snake.model.Snake;

public class Stage implements snake.model.Stage {

	private Map _map;
	private java.util.Map<Integer,GameObject> _objects;
	private java.util.Map<Integer,Snake> _snakes;
	
	public Stage(Map map) {
		clearStage();
		_map = map;
	}

	/**
	 * Used to prevent map drawing calls from calling an empty object.
	 * @return
	 */
	private Map getEmptyMap() {
		return new Map() {

			@Override
			public int getWidth() {
				return 0;
			}

			@Override
			public int getHeight() {
				return 0;
			}

			@Override
			public boolean isWall(int x, int y) {
				return false;
			}
			
		};
	}
	
	@Override
	public void clearStage() {
		_map = getEmptyMap();
		_objects = new java.util.HashMap<Integer,GameObject>();
		_snakes = new java.util.HashMap<Integer,Snake>();
	}

	@Override
	public void addGameObject(int id, GameObject go) throws InvalidIdException {
		if(!_objects.containsKey(id)) {
			_objects.put(id, go);
		} else {
			throw new InvalidIdException();
		}
	}

	@Override
	public GameObject getGameObject(int id) throws InvalidIdException {
		if(_objects.containsKey(id)) {
			return _objects.get(id);
		} else {
			throw new InvalidIdException();
		}
	}

	@Override
	public void removeGameObject(int id) throws InvalidIdException {
		if(_objects.containsKey(id)) {
			_objects.remove(id);
		} else {
			throw new InvalidIdException();
		}
	}

	@Override
	public Iterator<GameObject> getGameObjectIterator() {
		return Collections.unmodifiableCollection(_objects.values()).iterator();
	}

	@Override
	public void addSnake(int id, Snake snake) throws InvalidIdException {
		if(!_snakes.containsKey(id)) {
			_snakes.put(id,snake);
		} else {
			throw new InvalidIdException();
		}
	}

	@Override
	public Snake getSnake(int id) throws InvalidIdException {
		if(_snakes.containsKey(id)) {
			return _snakes.get(id);
		} else {
			throw new InvalidIdException();
		}
	}

	@Override
	public void removeSnake(int id) throws InvalidIdException {
		if(_snakes.containsKey(id)) {
			_snakes.remove(id);
		} else {
			throw new InvalidIdException();
		}
	}

	@Override
	public Iterator<Snake> getSnakeIterator() {
		return Collections.unmodifiableCollection(_snakes.values()).iterator();
	}

	@Override
	public void setMap(Map map) {
		_map = map;
	}

	@Override
	public Map getMap() {
		return _map;
	}
	
}
