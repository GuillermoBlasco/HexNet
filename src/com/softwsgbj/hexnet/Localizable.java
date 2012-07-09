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

public interface Localizable{

	public HexPoint getPoint();
	public Hexagon getHexIn(Map<?> m);
	public Neighbors<HexPoint> getNeighbors();
	public Neighbors<Hexagon> getNeighbors(Map<?> m);
	
}
