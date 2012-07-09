//	LICENSE:
//	GeoSegment.java is part of HexNet.
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

import com.softwsgbj.hexnet.dw.GeoElements.Segment;

public class GeoSegment  {

	
	private GeoElements.Segment refered;
	private GeoPoint origin;
	private GeoPoint destiny;
	GeoSegment(Segment refered, GeoPoint origin, GeoPoint destiny) {
		super();
		this.refered = refered;
		this.origin = origin;
		this.destiny = destiny;
	}
	void setRefered(GeoElements.Segment refered) {
		this.refered = refered;
	}
	void setOrigin(GeoPoint origin) {
		this.origin = origin;
	}
	void setDestiny(GeoPoint destiny) {
		this.destiny = destiny;
	}
	public GeoElements.Segment getRefered() {
		return refered;
	}
	public GeoPoint getOrigin() {
		return origin;
	}
	public GeoPoint getDestiny() {
		return destiny;
	}
	
	
	

}
