//	LICENSE:
//	Localizable.java is part of HexNet.
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
/**
 * Interface for all classes that can be localized on map.
 * @author GuillermoBlascoJimenez
 * @version 1.0
 */
public interface Localizable{
	/**
	 * Returns the associated point.
	 * @return A copy of associated point.
	 */
	public HexPoint getPoint();
	/**
	 * Retrieves from given map object the associated hexagon of this object.
	 * @param m Map where hexagon object must be retrieved.
	 * @return The associated hexagon object.
	 */
	public Hexagon getHexIn(Map<?> m);
	/**
	 * Returns the set of neighbors of this object without checking the
	 * existence.
	 * of this in the map.
	 * @return The neighbors.
	 */
	public Neighbors<HexPoint> getNeighbors();
	/**
	 * Returns the set of neighbors as Hexagon of this checking if these
	 * exists in the given map.
	 * @param m Map where point is contained.
	 * @return The neighbors hexagons of these points.
	 */
	public Neighbors<Hexagon> getNeighbors(Map<?> m);
	
}
