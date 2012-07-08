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
