//	LICENSE:
//	HexPoint.java is part of HexNet.
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
package com.softwsgbj.hexnet;

import java.io.Serializable;
import java.util.ArrayList;

public class HexPoint implements Cloneable, Serializable, Localizable {

	private static final long serialVersionUID = 177L;
	
	protected int x;
	protected int y;
	
	HexPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int x(){
		return x;
	}
	public int y(){
		return y;
	}

	@Override
	public HexPoint getPoint() {
		return (HexPoint) this.clone();
	}

	@Override
	public Hexagon getHexIn(Map<?> m) {
		return m.getHexagonIn(this);
	}
	
	public boolean equals(Object o){
		if(o != null && o instanceof HexPoint)
			return this.x == ((HexPoint)o).x && this.y == ((HexPoint)o).y;
		else return false;
	}
	public HexPoint clone(){
		return new HexPoint(x,y);
	}
	public String toString(){
		return "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
	}

	@Override
	public Neighbors<HexPoint> getNeighbors() {
		HexPoint[] h = new HexPoint[6];
		h[2] = new HexPoint(x, y-1);
		h[5] = new HexPoint(x, y+1);
		if((x & 1) == 0){
			h[0] = new HexPoint(x+1, y-1);
			h[1] = new HexPoint(x+1, y);
			h[3] = new HexPoint(x-1, y);
			h[4] = new HexPoint(x-1, y-1);
		} else {
			h[0] = new HexPoint(x+1, y);
			h[1] = new HexPoint(x+1, y+1);
			h[3] = new HexPoint(x-1, y+1);
			h[4] = new HexPoint(x-1, y);
		}
		return new Neighbors<HexPoint>(this, h);
	}

	@Override
	public Neighbors<Hexagon> getNeighbors(Map<?> m) {
		Hexagon[] h = new Hexagon[6];
		ArrayList<HexPoint> array_p = this.getNeighbors().getAll();
		for(int i = 0; i < 6; i ++)
			h[i] = m.getHexagonIn(array_p.get(i));
		return new Neighbors<Hexagon>(m.getHexagonIn(this),h);
	}

}
