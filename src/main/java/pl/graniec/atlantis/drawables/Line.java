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
package pl.graniec.atlantis.drawables;

import java.util.logging.Logger;

import pl.graniec.atlantis.Drawable;
import pl.graniec.atlantis.Graphics;
import pl.graniec.atlantis.animation.Color;
import pl.graniec.atlantis.animation.Fixed;

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class Line extends Drawable {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Line.class.getName());
	
	/** The color of beginning of line */
	public final Color aColor = new Color();
	
	/** The X coordinate of beginning of line */
	public final Fixed aX = new Fixed();
	
	/** The Y coordinate of beginning of line */
	public final Fixed aY = new Fixed();
	
	/** The color of end of line */
	public final Color bColor = new Color();
	
	/** The X coordinate of end of line */
	public final Fixed bX = new Fixed();
	
	/** The Y coordinate of end of line */
	public final Fixed bY = new Fixed();

	/* (non-Javadoc)
	 * @see pl.graniec.atlantis.Drawable#draw(pl.graniec.atlantis.Graphics)
	 */
	@Override
	public void draw(Graphics g) {

	}
	
	public void setColor(Color color) {
		setColor(color.get());
	}
	
	public void setColor(Color aColor, Color bColor) {
		setColor(aColor.get(), bColor.get());
	}
	
	public void setColor(int color) {
		this.aColor.set(color);
		this.bColor.set(color);
	}
	
	public void setColor(int aColor, int bColor) {
		this.aColor.set(aColor);
		this.bColor.set(bColor);
	}
	
	public void setPosition(double ax, double ay, double bx, double by) {
		this.aX.set(ax);
		this.aY.set(ay);
		this.bX.set(bx);
		this.bY.set(by);
	}
	
	/* (non-Javadoc)
	 * @see pl.graniec.atlantis.Drawable#update(int)
	 */
	@Override
	public void update(int elapsedTime) {
		super.update(elapsedTime);
		
		aColor.update(elapsedTime);
		aX.update(elapsedTime);
		aY.update(elapsedTime);
		bColor.update(elapsedTime);
		bX.update(elapsedTime);
		bY.update(elapsedTime);
	}
}
