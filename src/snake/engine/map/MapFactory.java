package snake.engine.map;

import java.io.File;

public abstract class MapFactory {

	public Map loadMap(File f) {
		SnakeMap map = new SnakeMap();
		
		return new SnakeMap();
	}
	
	public Map makeMap() {
		return new SnakeMap();
	}
	
}
