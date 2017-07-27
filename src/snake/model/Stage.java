package snake.model;

import java.util.Iterator;

/**
 * The stage is the heart of game play.
 * The stage is comprised of a map, game objects, and snakes.
 * It stores the model objects to manipulate this data.
 * @author liamtbrand
 *
 */
public interface Stage {
	
	@SuppressWarnings("serial")
	public class InvalidIdException extends Exception {
		public InvalidIdException() {
			
		}
	}
	
	/**
	 * Clears the stage of maps, snakes, and game objects.
	 */
	public void clearStage();
	
	public void addGameObject(int id, GameObject go) throws InvalidIdException;
	public GameObject getGameObject(int id) throws InvalidIdException;
	public void removeGameObject(int id) throws InvalidIdException;
	
	public Iterator<GameObject> getGameObjectIterator();
	
	public void addSnake(int id, Snake snake) throws InvalidIdException;
	public Snake getSnake(int id) throws InvalidIdException;
	public void removeSnake(int id) throws InvalidIdException;
	
	public Iterator<Snake> getSnakeIterator();
	
	public void setMap(Map map);
	public Map getMap();
	
}
