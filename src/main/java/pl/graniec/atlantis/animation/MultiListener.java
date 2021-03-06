/*
    Copyright (c) 2007, Interactive Pulp, LLC
    All rights reserved.
    
    Redistribution and use in source and binary forms, with or without 
    modification, are permitted provided that the following conditions are met:

        * Redistributions of source code must retain the above copyright 
          notice, this list of conditions and the following disclaimer.
        * Redistributions in binary form must reproduce the above copyright 
          notice, this list of conditions and the following disclaimer in the 
          documentation and/or other materials provided with the distribution.
        * Neither the name of Interactive Pulp, LLC nor the names of its 
          contributors may be used to endorse or promote products derived from 
          this software without specific prior written permission.
    
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
    ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
    CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
    SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
    INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
    CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
    POSSIBILITY OF SUCH DAMAGE.
*/

package pl.graniec.atlantis.animation;

import java.util.ArrayList;

/**
    A PropertyListener for Properties with multiple listeners
*/
class MultiListener implements PropertyListener {
    
    private ArrayList listeners;
    
    MultiListener(PropertyListener a, PropertyListener b) {
        listeners = new ArrayList(2);
        listeners.add(a);
        listeners.add(b);
    }
    
    PropertyListener[] getListeners() {
        PropertyListener[] array = new PropertyListener[listeners.size()]; 
        listeners.toArray(array);
        return array;
    }
    
    int size() {
        return listeners.size();
    }
    
    PropertyListener get(int index) {
        return (PropertyListener)listeners.get(index);
    }
    
    void addListener(PropertyListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }
    
    void removeListener(PropertyListener listener) {
        listeners.remove(listener);
    }

    public void propertyChange(Property property) {
        // Make a copy in case any of the listeners remove themselves
        PropertyListener[] list = getListeners();
        for (int i = 0; i < list.length; i++) {
            list[i].propertyChange(property);
        }
    }
    
}
  
