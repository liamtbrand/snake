package com.liamtbrand.snake.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import com.liamtbrand.snake.model.ISnakeModel.Direction;
import com.liamtbrand.snake.controller.AbstractSnake;
import com.liamtbrand.snake.controller.concrete.FoodObject;
import com.liamtbrand.snake.controller.concrete.Snake;
import com.liamtbrand.snake.controller.concrete.WormholeExitObject;
import com.liamtbrand.snake.controller.concrete.WormholeObject;
import com.liamtbrand.snake.engine.Engine;
import com.liamtbrand.snake.engine.EngineTicker;
import com.liamtbrand.snake.engine.mechanic.AbstractMechanic;
import com.liamtbrand.snake.engine.mechanic.SpawnFoodMechanic;
import com.liamtbrand.snake.model.IGameObjectModel;
import com.liamtbrand.snake.model.concrete.BasicGameObjectModel;
import com.liamtbrand.snake.model.concrete.BasicSnakeModel;
import com.liamtbrand.snake.model.concrete.Stage;
import com.liamtbrand.snake.model.concrete.test.TestMap;
import com.liamtbrand.snake.view.BlockRenderEngine;

public class SinglePlayerGame {

	public static void main(String[] args) {
		
		Stage stage = new Stage(new TestMap());
		Engine engine = new Engine(stage);
		
		// Setup the render engine to render using the block render engine.
		BlockRenderEngine rEngine = new BlockRenderEngine(20);
		rEngine.observeStage(engine.stage);
		
		AbstractSnake snake = new Snake(new BasicSnakeModel(2, 4, Direction.EAST, 5));
		
		// Setup some example snake and food.
		engine.stage.addSnake(snake);
		engine.stage.addGameObject(new FoodObject(new BasicGameObjectModel(1,4,IGameObjectModel.Type.FOOD)));
		engine.stage.addGameObject(new FoodObject(new BasicGameObjectModel(5,6,IGameObjectModel.Type.FOOD)));
		engine.stage.addGameObject(new WormholeObject(new BasicGameObjectModel(10,1,IGameObjectModel.Type.WORMHOLE), 12, 14));
		engine.stage.addGameObject(new WormholeExitObject(new BasicGameObjectModel(12,14,IGameObjectModel.Type.WORMHOLE)));
		
		AbstractMechanic spawnFood = new SpawnFoodMechanic(engine);
		
		JFrame frame = new JFrame();
		
		// Set the panel to show the render engine.
		JPanel pane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				rEngine.renderStage(g);
			}
		};
		
		pane.addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent paramComponentEvent) {
				rEngine.calculateScale(pane.getSize());
			}

			@Override public void componentMoved(ComponentEvent paramComponentEvent) {}
			@Override public void componentShown(ComponentEvent paramComponentEvent) {}
			@Override public void componentHidden(ComponentEvent paramComponentEvent) {}
		});
		
		// Setup the input controls for the player 1 snake.
		pane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "p1");
		pane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "p1");
		pane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "p1");
		pane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "p1");
		pane.getActionMap().put("p1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Direction d = Direction.NORTH;
				switch(e.getActionCommand()) {
					case "w":
						d = Direction.NORTH;
						break;
					case "a":
						d = Direction.WEST;
						break;
					case "s":
						d = Direction.SOUTH;
						break;
					case "d":
						d = Direction.EAST;
						break;
					default:
						System.out.println("Invalid keypress: "+e.getActionCommand());
						break;
				}
				snake.model.setDirection(d);
			}
		});
		
		// Setup the frame.
		frame.add(pane);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 422);
		frame.setVisible(true);
		
		// Start the engine.
		EngineTicker engineTicker = new EngineTicker(engine,200);
		engineTicker.start();
		
		// Start the render engine to render the stage to the screen.
		new Timer(60, e -> pane.repaint()).start();
		
	}

}
