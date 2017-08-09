package com.liamtbrand.snake.controller;

import java.util.Iterator;
import java.util.Set;

import com.liamtbrand.snake.model.IMapModel;

/**
 * The stage is the heart of game play.
 * The stage is comprised of a map, game objects, and snakes.
 * It stores the model objects to manipulate this data.
 * @author liamtbrand
 *
 */
public interface IStage {
	
	/**
	 * Clears the stage of maps, snakes, and game objects.
	 */
	public void clearStage();
	
	public void addGameObject(AbstractGameObject go);
	public void removeGameObject(AbstractGameObject go);
	public Set<AbstractGameObject> getGameObjectsAt(int x, int y);
	
	public Iterator<AbstractGameObject> getGameObjectIterator();
	
	public void addSnake(AbstractSnake snake);
	public void removeSnake(AbstractSnake snake);
	public Set<AbstractSnake> getSnakesAt(int x, int y);
	
	public Iterator<AbstractSnake> getSnakeIterator();
	
	public void setMap(IMapModel map);
	public IMapModel getMap();
	
}
