//	LICENSE:
//	HexDraw.java is part of HexNet.
//
//	HexNet is free software: you can redistribute it and/or modify
//	it under the terms of the GNU General Public License as published by
//	the Free Software Foundation, either version 3 of the License, or
//	(at your option) any later version.
//
//	HexNet is distributed in the hope that it will be useful,
//	but WITHOUT ANY WARRANTY; without even the implied warranty of
//	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//	GNU General Public License for more details.
//
//	You should have received a copy of the GNU General Public License
//	along with HexNet.  If not, see <http://www.gnu.org/licenses/>.
package com.softwsgbj.hexnet.dw;

import java.util.TreeMap;

import com.softwsgbj.hexnet.HexPoint;
import com.softwsgbj.hexnet.AbstractHexagon;

public class HexDraw {

	private final AbstractHexagon hex;
	private TreeMap<String, Object> images;
	
	public HexDraw(AbstractHexagon origin){
		this(origin, new TreeMap<String,Object>());
	}
	public HexDraw(AbstractHexagon origin, TreeMap<String, Object> images){
		this.hex = origin;
		this.images = images;
	}
	
	public AbstractHexagon getHexagon(){
		return hex;
	}
	public HexPoint getHexPoint(){
		return hex.getPoint();
	}
	public Object getImage(String key){
		return images.get(key);
	}
	public void setImage(String key, Object value){
		images.put(key, value);
	}
	public void actualizeDraw(){
		images = hex.getAsDraw().images;
	}
	
}
