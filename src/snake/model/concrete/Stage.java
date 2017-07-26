package snake.model.concrete;

import java.util.ArrayList;
import java.util.List;

import snake.model.GameObject;
import snake.model.Map;
import snake.model.Snake;

public class Stage implements snake.model.Stage {

	private Map _map;
	private List<GameObject> _objects;
	private List<Snake> _snakes;
	
	public Stage(Map map) {
		_map = map;
		_objects = new ArrayList<GameObject>();
	}
	
	public void addGameObject(GameObject go) {
		_objects.add(go);
	}
	
	public void addSnake(Snake snake) {
		_snakes.add(snake);
	}

	public Map getMap() {
		return _map;
	}
	
}
