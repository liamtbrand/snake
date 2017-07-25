package snake.engine.stage;

import java.util.ArrayList;
import java.util.List;

import snake.engine.Snake;
import snake.engine.map.Map;
import snake.engine.object.GameObject;

/**
 * The stage is the heart of game play.
 * The stage is comprised of a map, game objects, and snakes.
 * @author liamtbrand
 *
 */
public abstract class Stage {
	
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
	
	
}
