package com.liamtbrand.snake.engine;

public class EngineTicker extends Thread {

	private volatile boolean running;
	private long tickTime;
	private long lastTick = 0;
	private Engine engine;
	
	public EngineTicker(Engine e, int tickTime) {
		this.engine = e;
		this.tickTime = tickTime;
	}
	
	public EngineTicker(Engine e) {
		this(e,200);
	}
	
	/**
	 * Fetches the current time in millis.
	 * @return
	 */
	private long time() {
		return System.currentTimeMillis();
	}
	
	/**
	 * Sets the time between ticks. Time is measured in millis.
	 * @param tick
	 */
	public void setEngineTickTime(long tick) {
		tickTime = tick;
	}
	
	public synchronized void run() {
		
		running = true;
		lastTick = time();
		long elapsed = 0;
		
		while(running) {
			
			// Run the game logic.
			engine.tick();
			
			// wait for the remaining time, until the next tick.
			try {
				elapsed = time() - lastTick;
				if(elapsed < tickTime) {
					wait(tickTime - elapsed);
				}
				lastTick = time();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}
	
	public void halt() {
		running = false;
	}
	
}
