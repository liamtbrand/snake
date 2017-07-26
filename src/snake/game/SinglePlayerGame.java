package snake.game;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import snake.engine.render.BlockRenderEngine;

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
		
	}

}
