//	LICENSE:
//	GeoPoint.java is part of HexNet.
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


public class GeoPoint {

	private double x;
	private double y;
	private GeoElements.Point refered_element;
		
	GeoPoint(GeoElements.Point refered, double x, double y) {
		this.refered_element =(refered);
		this.x = x;
		this.y = y;
	}
	
	void setX(double x) {
		this.x = x;
	}
	void setY(double y) {
		this.y = y;
	}
	
	void setReferedElement(GeoElements.Point refered_element) {
		this.refered_element = refered_element;
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public GeoElements.Point getReferedElement(){
		return this.refered_element;
	}
	
	
}
