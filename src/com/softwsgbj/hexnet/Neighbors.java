//	LICENSE:
//	Neighbors.java is part of HexNet.
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

import java.util.ArrayList;

import com.softwsgbj.hexnet.dw.GeoElements;

public class Neighbors<H extends HexPoint> {

	protected ArrayList<H> neighbors;
	protected H origin;
	protected Neighbors(H origin){
		this.origin = origin;
		this.neighbors = new ArrayList<H>(6);
	}
	Neighbors(H origin, H[] n){
		this(origin);
		for(H h : n)
			this.neighbors.add(h);
	}
	public H getOrigin(){
		return origin;
	}
	public H getAdjacentTo(GeoElements.OfHexagon.Segments side){
		switch(side){
			case SIDE_0:
				return neighbors.get(0);
			case SIDE_1:
				return neighbors.get(1);
			case SIDE_2:
				return neighbors.get(2);
			case SIDE_3:
				return neighbors.get(3);
			case SIDE_4:
				return neighbors.get(4);
			case SIDE_5:
				return neighbors.get(5);
			default:
				return null;
		}
	}
	public ArrayList<H> getAll(){
		return this.neighbors;
	}
	public ArrayList<H> getAllTrimmed(){
		int size = 0;
		for(int i = 0; i < 6; i++)
			if(neighbors.get(i) != null) size++;
		ArrayList<H> h = new ArrayList<H>(size);
		int j = 0;
		for(int i = 0; i < 6; i++)
			if(neighbors.get(i)!= null) 
				h.set(j, neighbors.get(i));
		return h;
	}

	@SuppressWarnings("unchecked")
	<K extends H> Neighbors<K> castCopy(){
		Neighbors<K> n = new Neighbors<K>((K) this.origin);
		
		for(int i = 0; i < 6; i++)
			n.neighbors.set(i, (K) neighbors.get(i));
		return n;
	}
}
