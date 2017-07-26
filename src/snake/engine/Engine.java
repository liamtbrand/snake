package snake.engine;

import snake.model.Map;
import snake.model.Snake;
import snake.model.concrete.Stage;

public abstract class Engine extends Thread {

	private snake.model.Stage _stage;
	
	private volatile boolean _running;
	
	private long _tickTime = 100;
	private long _lastTick = 0;
	
	public Engine() {
		_running = false;
	}
	
	/**
	 * Fetches the current time in millis.
	 * @return
	 */
	private long time() {
		return System.currentTimeMillis();
	}
	
	/**
	 * Changes the current map the engine is running.
	 * This will reset the stage, and all game variables.
	 * @param map
	 * @throws Exception
	 */
	public void selectMap(Map map) throws Exception {
		if(!_running) {
			_stage = new Stage(map);
		}else {
			throw new Exception("Can't select a map while the engine is running!");
		}
	}
	
	/**
	 * Sets the time between ticks. Time is measured in millis.
	 * @param tick
	 */
	public void setEngineTickTime(long tick) {
		_tickTime = tick;
	}
	
	public synchronized void run() {
		_running = true;
		_lastTick = time();
		long elapsed = 0;
		while(_running) {
			
			// GAME LOGIC TODO
			
			
			// wait for the remaining time, until the next tick.
			try {
				elapsed = time() - _lastTick;
				if(elapsed < _tickTime) {
					wait(_tickTime - elapsed);
				}
				_lastTick = time();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public void halt() {
		_running = false;
	}
	
	public Snake spawnSnake() {
		return null;
	}
	
	public snake.model.Stage getStage() {
		return _stage;
	}
	
	public abstract void registerControls(Controls ctrls);
	
}
