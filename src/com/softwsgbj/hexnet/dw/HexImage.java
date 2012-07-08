package com.softwsgbj.hexnet.dw;

import com.softwsgbj.hexnet.Hexagon;

public class HexImage  {

	private HexDraw draw;
	private GeoPoint point;
	private GeometricAdapter adapter;
	
	HexImage(Hexagon origin, GeoPoint point,GeometricAdapter adapter) {
		this.draw = origin.getAsImage();
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
	public Hexagon getHexagon(){
		return draw.getHexagon();
	}
	
	public void remove(){
		adapter.detach(this);
	}
	
	public void finalize(){
		adapter.detach(this);
	}
}
