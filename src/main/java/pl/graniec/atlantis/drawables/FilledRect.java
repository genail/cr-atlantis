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

import pl.graniec.atlantis.Drawable;
import pl.graniec.atlantis.Stage;
import pl.graniec.atlantis.animation.Color;
import pl.graniec.atlantis.animation.Fixed;

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public abstract class FilledRect extends Drawable {

	/** Fill color */
	public Color fillColor = new Color();
	
	/** X position of rectangle */
	public Fixed x = new Fixed();
	
	/** Y position of rectangle */
	public Fixed y = new Fixed();
	
	/** Width of rectangle */
	public Fixed width = new Fixed();
	
	/** Height of rectangle */
	public Fixed height = new Fixed();

	/**
	 * 
	 */
	public FilledRect() {
		x.set(0);
		y.set(0);
		width.set(Stage.getWidth());
		height.set(Stage.getHeight());
	}
	
	/**
	 * @param fillColor the fillColor to set
	 */
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public void setFillColor(int color) {
		this.fillColor.set(color);
	}

	/**
	 * @return the fillColor
	 */
	public Color getFillColor() {
		return fillColor;
	}
	
	public void setGeometry(double x, double y, double width, double height) {
		this.x.set(x);
		this.y.set(y);
		this.width.set(width);
		this.height.set(height);
	}
	
	/* (non-Javadoc)
	 * @see pl.graniec.atlantis.Drawable#update(int)
	 */
	@Override
	public void update(int elapsedTime) {
		x.update(elapsedTime);
		y.update(elapsedTime);
		width.update(elapsedTime);
		height.update(elapsedTime);
		fillColor.update(elapsedTime);
	}

}
