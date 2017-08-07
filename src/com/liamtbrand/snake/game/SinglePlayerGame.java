package com.liamtbrand.snake.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import com.liamtbrand.snake.model.Snake;
import com.liamtbrand.snake.model.Snake.Direction;
import com.liamtbrand.snake.model.Stage.InvalidIdException;
import com.liamtbrand.snake.model.concrete.GameObject;
import com.liamtbrand.snake.model.concrete.test.TestMap;
import com.liamtbrand.snake.view.BlockRenderEngine;

public class SinglePlayerGame {

	public static void main(String[] args) {
		
		Engine engine = new Engine();
		
		// Setup the engine with a simple testing map.
		try {
			engine.selectMap(new TestMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Setup the render engine to render using the block render engine.
		BlockRenderEngine rEngine = new BlockRenderEngine();
		rEngine.observeStage(engine.getStage());
		
		// Setup some example snake and food.
		try {
			engine.getStage().addSnake(0, new TestSnake());
			engine.getStage().addGameObject(0, new GameObject(1,4,GameObject.Type.FOOD));
			engine.getStage().addGameObject(1, new GameObject(5,6,GameObject.Type.FOOD));
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame();
		
		// Set the panel to show the render engine.
		JPanel pane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				rEngine.renderStage(g);
			}
		};
		
		// Setup the input controls for the player 1 snake.
		pane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "p1");
		pane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "p1");
		pane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "p1");
		pane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "p1");
		pane.getActionMap().put("p1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Snake.Direction d = Direction.NORTH;
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
					engine.getStage().getSnake(0).setDirection(d);
				} catch (InvalidIdException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// Setup the frame.
		frame.add(pane);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(200, 122);
		frame.setVisible(true);
		
		// Start the engine.
		engine.start();
		
		// Start the render engine to render the stage to the screen.
		(new Thread() {
			
			public synchronized void run(){
				while(true) {
					try {
						this.wait(1000/60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pane.repaint();
				}
				
			}
			
		}).start();
		
	}

}
