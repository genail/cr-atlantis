/**
 * Copyright (c) 2009, Coral Reef Project
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *  * Neither the name of the Coral Reef Project nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package pl.graniec.atlantis;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Logger;

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class Stage {
	
//	private class DisplayThread extends Thread {
//		/* (non-Javadoc)
//		 * @see java.lang.Thread#run()
//		 */
//		@Override
//		public void run() {
//			int rr = -1, step = 0;
//			Scene currentScene;
//			long before, next, now;
//			
//			while (!isInterrupted()) {
//				
//				if (rr != refreshRate) {
//					rr = refreshRate;
//					step = 1000 / rr;
//				}
//				
//				before = System.currentTimeMillis();
//				next = before + step;
//				
//				try {
//					synchronized (sceneStack) {
//						currentScene = sceneStack.peek();
//					}
//					
//					currentScene.drawScene();
//					
//				} catch (EmptyStackException e) {
//				}
//				
//				now = System.currentTimeMillis();
//				
//				if (now <  next) {
//					try {
//						sleep(next - now);
//					} catch (InterruptedException e) {
//						return;
//					}
//				}
//			}
//		}
//	}
	
	private static Logger logger = Logger.getLogger(Stage.class.getName());
	
	/** Default refresh rate */
	private static final int DEFAULT_REFRESH_RATE = 60;
	
	/** Scene stack */
	private static Stack<Scene> sceneStack = new Stack<Scene>();
	
	/** Canvas resolution */
	private static int width, height;
	
	public static Scene popScene() {
		try {
			return sceneStack.pop();
		} catch (EmptyStackException e) {
			logger.severe(EMessage.prepare("pop() on empty stack", e));
		}
		
		return null;
	}
	
	public static void pushScene(Scene scene) {
		synchronized (sceneStack) {
			sceneStack.push(scene);
		}
	}
	
	public static void setScene(Scene scene) {
		synchronized (sceneStack) {
			if (!sceneStack.isEmpty()) {
				sceneStack.pop();
			}
			
			sceneStack.push(scene);
		}
	}
	
	/** Refresh rate */
	private int refreshRate = DEFAULT_REFRESH_RATE;
	
	/** Last draw time */
	private static long lastDrawTime;
	
	/**
	 * @return the height
	 */
	public static int getHeight() {
		return height;
	}
	
	/**
	 * @return the width
	 */
	public static int getWidth() {
		return width;
	}
	
	public static void repaintStage(Graphics g) {
		
		Stage.width = g.getWidth();
		Stage.height = g.getHeight();
		
		try {
			Scene currentScene;
			
			synchronized (sceneStack) {
				currentScene = sceneStack.peek();
			}
			
			long now = System.currentTimeMillis();
			
			if (!currentScene.loaded) {
				currentScene.load();
				currentScene.loaded = true;
			} else {
				currentScene.update((int) (now - lastDrawTime));
			}
			
			lastDrawTime = now;

			currentScene.drawScene(g);
			
		} catch (EmptyStackException e) {
		}
	}
	
	/**
	 * @param refreshRate the refreshRate to set
	 */
	public void setRefreshRate(int refreshRate) {
		this.refreshRate = refreshRate;
	}
}
