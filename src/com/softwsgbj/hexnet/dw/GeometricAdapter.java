//	LICENSE:
//	GeometricAdapter.java is part of HexNet.
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

import java.util.LinkedList;

import com.softwsgbj.hexnet.HexPoint;
import com.softwsgbj.hexnet.AbstractHexagon;
import com.softwsgbj.hexnet.Map;
import com.softwsgbj.hexnet.dw.GeoElements.Point;

public class GeometricAdapter {

	private final Map<?> map;
	private LinkedList<HexImage> childs;
	private Metric metric;
	
	public GeometricAdapter(Map<?> m){
		this.map = m;
		childs = new LinkedList<HexImage> ();
		metric = new Metric(GeoElements.OfHexagon.NotableSegments.RADIUS, 1.0);
	}
	public void setMetric(Metric metric){
		this.metric = metric;
	}
	public GeoPoint getPointOfHexagon(GeoElements.OfHexagon.Points which, HexPoint p){

		GeoPoint g = new GeoPoint(GeoElements.OfRectangle.Points.APEX_NW, getXof(p.x(), p.y()), getYof(p.x(), p.y()));
		changePointReference(g, which);
		return g;
	}
	public GeoSegment getSegmentOfHexagon(GeoElements.OfHexagon.Segments which, HexPoint p){
		return new GeoSegment(which, getPointOfHexagon(which.getOrigin(), p), getPointOfHexagon(which.getDestiny(), p));
	}
	public GeoPoint getPointOfRectangleContainer(GeoElements.OfRectangle.Points which, HexPoint p){
		GeoPoint g = new GeoPoint(GeoElements.OfRectangle.Points.APEX_NW, getXof(p.x(), p.y()), getYof(p.x(), p.y()));
		changePointReference(g, which);
		return g;
	}
	public GeoSegment getSegmentOfRectangleContainer(GeoElements.OfRectangle.Segments which, HexPoint p){
		return new GeoSegment(which, getPointOfRectangleContainer(which.getOrigin(), p), getPointOfRectangleContainer(which.getDestiny(), p));
	}
	public HexImage getImageOf(AbstractHexagon hex, Point reference){
		HexImage h = new HexImage(hex, this.getPoint(reference, hex.getPoint()),this);
		this.attach(h);
		return h;
	}
	public GeoPoint getPoint(GeoElements.Point ref, HexPoint p){
		if(ref instanceof GeoElements.OfHexagon.Points)
			return getPointOfHexagon((GeoElements.OfHexagon.Points) ref, p);
		else if(ref instanceof GeoElements.OfRectangle.Points)
			return getPointOfRectangleContainer((GeoElements.OfRectangle.Points) ref, p);
		else return null;
	}/*
	public HexPoint getPoint(double x, double y){
		int x_coord = (x % this.getR)
	}*/
	public void actualizeChilds(){
		HexImage[] childs_copy = childs.toArray(new HexImage[childs.size()]);
		for(int i = 0; i < childs_copy.length; i++){
			this.actualizeChildRefernce(childs_copy[i]);
			childs_copy[i].actualizeDraw();
		}
	}
	public double sizeX(){
		return (map.getBoundX()*1.5 + 0.5)*getRadius(); 
	}
	public double sizeY(){
		return ((map.getBoundY())*2 +1.0)*getApothem();
	}
	public void changePointReference(HexImage hexImage, Point new_ref) {
		changePointReference(hexImage.getPoint(), new_ref);
	}	
	public void changePointReference(GeoPoint old, Point new_ref) {
		old.setX(old.getX() - old.getReferedElement().getXRadiusToA()*getRadius());
		old.setX(old.getX() + new_ref.getXRadiusToA()*getRadius());
		old.setY(old.getY() - old.getReferedElement().getYApothemsToA()*getApothem());
		old.setY(old.getY() + new_ref.getYApothemsToA()*getApothem());
		old.setReferedElement(new_ref);
	}
	void detach(HexImage child){
		this.childs.remove(child);
	}
	void attach(HexImage child){
		this.childs.add(child);
	}
	
	
	protected double getXof(int x, int y){
		return (x*1.5 )*getRadius(); 
	}
	protected double getYof(int x, int y){
		if((x & 1) == 0)
			return y*2*getApothem();
		else 
			return ((y)*2 +1.0)*getApothem();
	}
	protected double getApothem(){
		return this.metric.getApothemSize();
	}
	protected double getRadius(){	
		return this.metric.getRadiusSize();
	}
	protected void actualizeChildRefernce(HexImage child){
		GeoPoint p = this.getPoint(child.getPoint().getReferedElement(), child.getHexagon());
		child.setReference(p);
	}
}
