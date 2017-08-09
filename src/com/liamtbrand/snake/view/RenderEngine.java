package com.liamtbrand.snake.view;

import com.liamtbrand.snake.controller.IStage;
public abstract class RenderEngine {
	
	protected IStage stage;
	
	public RenderEngine() {
		
	}
	
	public void observeStage(IStage stage) {
		this.stage = stage;
	}
	
	public abstract void renderStage();
	
}
