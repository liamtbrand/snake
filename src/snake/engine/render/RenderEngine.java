package snake.engine.render;

import snake.engine.stage.Stage;

public abstract class RenderEngine {
	
	protected Stage _stage;
	
	public RenderEngine() {
		
	}
	
	public void observeStage(Stage stage) {
		_stage = stage;
	}
	
	public abstract void renderStage();
	
}
