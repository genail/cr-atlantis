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

/**
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public class DisplayMode {
	
	private static final int DEFAULT_REFRESH_RATE = 60;

	private static final int DEFAULT_COLOR_DEPTH = 32;

	/** Width and height of draw area */
	private final int width, height;
	
	/** Color depth */
	private final int colorDepth;
	
	/** Screen refresh rate */
	private final int refreshRate;
	
	/** Is fullscreen? */
	private final boolean fullscreen;

	public DisplayMode(int width, int height, boolean fullscreen) {
		this(width, height, fullscreen, DEFAULT_COLOR_DEPTH, DEFAULT_REFRESH_RATE);
	}
	
	public DisplayMode(int width, int height, boolean fullscreen, int colorDepth) {
		this(width, height, fullscreen, colorDepth, DEFAULT_REFRESH_RATE);
	}
	
	public DisplayMode(int width, int height, boolean fullscreen, int colorDepth, int refreshRate) {
		this.width = width;
		this.height = height;
		this.fullscreen = fullscreen;
		this.colorDepth = colorDepth;
		this.refreshRate = refreshRate;
	}
	
	/**
	 * @return the colorDepth
	 */
	public int getColorDepth() {
		return colorDepth;
	}
	
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return the refreshRate
	 */
	public int getRefreshRate() {
		return refreshRate;
	}
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return the fullscreen
	 */
	public boolean isFullscreen() {
		return fullscreen;
	}
	
}
