package snake.model;

/**
 * The map interface allows for interaction with the map.
 * 
 * Map coordinates have the origin in the top left.
 * Tiles begin at 0, and go to size-1.
 * 
 * @author liamtbrand
 *
 */
public interface Map {

	public int getWidth();
	public int getHeight();
	
	/**
	 * 
	 * @param x - The x position on the map.
	 * @param y - The y position on the map.
	 * @return Whether the tile specified is a wall or not.
	 */
	public boolean isWall(int x, int y);

}
