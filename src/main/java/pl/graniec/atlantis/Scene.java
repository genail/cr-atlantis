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

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public abstract class Scene {
	
	/** All drawables added to scene. First is one on the bottom, last on top. */
	private final Set<Drawable> drawables = new LinkedHashSet<Drawable>();
	
	/** Tells if scene is loaded */
	boolean loaded;
	
	/**
	 * Adds new <code>drawable</code> to the scene. Keep on mind that
	 * you can add every Drawable object only once to one scene.
	 *   
	 * @param drawable
	 */
	public void add(Drawable drawable) {
		synchronized (drawables) {
			drawables.add(drawable);
		}
	}
	
	/**
	 * All resources loading should be in this method.
	 */
	public abstract void load();
	
	/**
	 * Removes <code>drawable</code> from scene if it exists in it.
	 * If not then nothing happens.
	 * 
	 * @param drawable The drawable to remove from scene.
	 */
	public void remove(Drawable drawable) {
		synchronized (drawables) {
			drawables.remove(drawable);
		}
	}

	/**
	 * @param g
	 */
	public void drawScene(Graphics g) {
		synchronized (drawables) {
			for (Drawable d : drawables) {
				d.draw(g);
			}
		}
	}
	
	public void update(int timeElapsed) {
		synchronized (drawables) {
			for (Drawable d : drawables) {
				d.update(timeElapsed);
			}
		}
	}
}
