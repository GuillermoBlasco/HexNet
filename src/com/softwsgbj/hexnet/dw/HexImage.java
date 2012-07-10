//	LICENSE:
//	HexImage.java is part of HexNet.
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

import com.softwsgbj.hexnet.AbstractHexagon;

public class HexImage  {

	private HexDraw draw;
	private GeoPoint point;
	private GeometricAdapter adapter;
	
	HexImage(AbstractHexagon origin, GeoPoint point,GeometricAdapter adapter) {
		this.draw = origin.getAsDraw();
		this.point = point;
		this.adapter = adapter;
	}

	public GeoPoint getPoint(){
		return point;
	}
	void setReference(GeoPoint point){
		this.point = point;
	}
	public void changePoint(GeoElements.Point new_ref){
		adapter.changePointReference(this, new_ref);
	}
	public HexDraw getImages(){
		return draw;
	}

	public void actualizeDraw() {
		draw.actualizeDraw();
	}
	public AbstractHexagon getHexagon(){
		return draw.getHexagon();
	}
	
	public void remove(){
		adapter.detach(this);
	}
	
	public void finalize(){
		adapter.detach(this);
	}
}
