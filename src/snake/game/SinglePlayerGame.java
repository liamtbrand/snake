package snake.game;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import snake.model.Stage.InvalidIdException;
import snake.model.concrete.test.TestMap;
import snake.view.BlockRenderEngine;

public class SinglePlayerGame {

	public static void main(String[] args) {
		
		Engine engine = new Engine();
		
		try {
			engine.selectMap(new TestMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BlockRenderEngine rEngine = new BlockRenderEngine();
		rEngine.observeStage(engine.getStage());
		
		try {
			engine.getStage().addSnake(0, new TestSnake());
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame();
		
		JPanel pane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				rEngine.renderStage(g);
			}
		};
		
		
		frame.add(pane);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(100, 122);
		frame.setVisible(true);
		
		engine.start();
		
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
