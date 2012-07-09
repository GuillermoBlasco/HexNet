//	LICENSE:
//	Hexagon.java is part of HexNet.
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

import com.softwsgbj.hexnet.dw.HexDraw;

/**
 * Base class for hexagon objects. Has, by inheritance, the properties of an 
 * object HexPoint.
 * 
 * @author GuillermoBlascoJimenez
 * @version 1.0
 */
public abstract class Hexagon extends HexPoint {

	private static final long serialVersionUID = 177L;
	
	/**
	 * Sole constructor
	 * @param x x coordinate of hexagon in map.
	 * @param y y coordinate of hexagon in map.
	 */
	protected Hexagon(int x, int y) {
		super(x, y);
	}

	/**
	 * Must return a object that represents the current state of this Hexagon
	 * object.
	 * @return A HexDraw object containing the draws that represents this.
	 */
	public abstract HexDraw getAsDraw();
}
