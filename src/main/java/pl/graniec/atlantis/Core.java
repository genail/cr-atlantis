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

import pl.graniec.atlantis.drawables.FilledRect;

/**
 * Core of Atlantis engine. The Core will provide all implementations
 * for Atiantis interface. All you must do is to instance Core
 * implementation of your choice.
 * 
 * @author Piotr Korzuszek <piotr.korzuszek@gmail.com>
 *
 */
public abstract class Core {
	
	/** Current Core */
	private static Core current;
	
	/**
	 * Provides the current Core object.
	 * <p>
	 * Usually it contains first created Core implementation,
	 * unless {@link #makeCurrent()} is called manually.
	 * @return
	 */
	public static Core getCurrent() {
		return current;
	}
	
	/**
	 * Makes the current Core implementation current.
	 * <p>
	 * If you're using only one implementation of Core then
	 * this is probably not what you want to do.
	 */
	public void makeCurrent() {
		Core.current = this;
	}
	
	public abstract FilledRect newFilledRect();
	
	public abstract Window newWindow();
	
}
