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
/**
 * HexPoint represents a bidimensional point.
 * @author GuillermoBlascoJimenez
 * @version 1.0
 */
public class HexPoint implements Cloneable, Serializable, Localizable {

	private static final long serialVersionUID = 177L;
	/** x coordinate of point*/
	protected int x;
	/** y coordinate of point*/
	protected int y;
	
	/**
	 * Sole constructor of both coordinates.
	 * @param x x coordinate of point.
	 * @param y y coordinate of point.
	 */
	HexPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * Gets the x coordinate of point.
	 * @return x coordinate.
	 */
	public int x(){
		return x;
	}
	/**
	 * Gets the y coordinate of point.
	 * @return y coordinate.
	 */
	public int y(){
		return y;
	}
	
	// 	FROM LOCALIZABLE INTERFACE
	
	/**
	 * Returns a copy of itself.
	 * @return A copy of itself.
	 */
	@Override
	public HexPoint getPoint() {
		return (HexPoint) this.clone();
	}
	/**
	 * Retrieves from given map object the associated hexagon of this HexPoint
	 * object.
	 * @param m Map where hexagon object must be retrieved.
	 * @return The associated hexagon object.
	 */
	@Override
	public AbstractHexagon getHexIn(Map<?> m) {
		return m.getHexagonIn(this);
	}
	/**
	 * Returns the set of neighbors of this point without checking the existence
	 * of this in the map.
	 * @return The neighbors.
	 */
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
	/**
	 * Returns the set of neighbors as Hexagon of this point checking if these
	 * exists in the given map.
	 * @param m Map where point is contained.
	 * @return The neighbors hexagons of these points.
	 */
	@Override
	public Neighbors<AbstractHexagon> getNeighbors(Map<?> m) {
		AbstractHexagon[] h = new AbstractHexagon[6];
		ArrayList<HexPoint> array_p = this.getNeighbors().getAll();
		for(int i = 0; i < 6; i ++)
			h[i] = m.getHexagonIn(array_p.get(i));
		return new Neighbors<AbstractHexagon>(m.getHexagonIn(this),h);
	}

	// OBJECT METHODS OVERIDE
	/**
	 * Returns a new point with the same coordinates. Coherent with equals.
	 * @return New point with same coordinates.
	 */
	public HexPoint clone(){
		return new HexPoint(x,y);
	}
	/**
	 * Asks if given object is equal to this. Are equals if and only if both
	 * coordinates of given are equals to coordenates of this.
	 * @param o Object to know if is equal to this.
	 * @return true if and only if both coordinates are equals, false otherwise.
	 */
	public boolean equals(Object o){
		if(o != null && o instanceof HexPoint)
			return this.x == ((HexPoint)o).x && this.y == ((HexPoint)o).y;
		else return false;
	}
	/**
	 * The string representation is: "(x,y)" where x is the x coordinate and
	 * y the y coordinate.
	 * @return A string representation.
	 */
	public String toString(){
		return "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
	}


}
