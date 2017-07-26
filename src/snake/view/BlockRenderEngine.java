package snake.view;

import java.awt.Graphics;

public class BlockRenderEngine extends RenderEngine {

	@Override
	public void renderStage() {
		
	}
	
	private void renderMap(Graphics g) {
		for(int x = 0; x < _stage.getMap().getWidth(); x++) {
			for(int y = 0; y < _stage.getMap().getHeight(); y++) {
				if(_stage.getMap().isWall(x, y)) {
					g.fillRect(x*10, y*10, 10, 10);
				}
			}
		}
	}
	
	public void renderStage(Graphics g) {
		renderMap(g);
	}
	
}
