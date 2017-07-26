package snake.model;

/**
 * The stage is the heart of game play.
 * The stage is comprised of a map, game objects, and snakes.
 * It stores the model objects to manipulate this data.
 * @author liamtbrand
 *
 */
public interface Stage {
	
	public void addGameObject(GameObject go);
	public void addSnake(Snake snake);
	public Map getMap();
	
}
