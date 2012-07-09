package com.softwsgbj.hexnet.dw;

import java.util.LinkedList;

import com.softwsgbj.hexnet.HexPoint;
import com.softwsgbj.hexnet.Hexagon;
import com.softwsgbj.hexnet.Map;
import com.softwsgbj.hexnet.dw.GeoElements.Point;

public class GeometricAdapter {

	private final Map<?> map;
	private LinkedList<HexImage> childs;
	
	private GeoElements.OfHexagon.NotableSegments reference_vector;
	private double reference_vector_size;
	
	public GeometricAdapter(Map<?> m){
		this.map = m;
		childs = new LinkedList<HexImage> ();
		reference_vector = GeoElements.OfHexagon.NotableSegments.RADIUS;
		reference_vector_size = 1.0;
	}
	public void setMetric(GeoElements.OfHexagon.NotableSegments ref, double value){
		reference_vector = ref;
		if(value > 0)
			reference_vector_size = value;
	}
	public GeoPoint getPointOfHexagon(GeoElements.OfHexagon.Points which, HexPoint p){

		GeoPoint g = new GeoPoint(GeoElements.OfRectangleContainer.Points.APEX_NW, getXof(p.x(), p.y()), getYof(p.x(), p.y()));
		changePointReference(g, which);
		return g;
	}
	public GeoSegment getSegmentOfHexagon(GeoElements.OfHexagon.Segments which, HexPoint p){
		return new GeoSegment(which, getPointOfHexagon(which.getOrigin(), p), getPointOfHexagon(which.getDestiny(), p));
		
	}
	public GeoPoint getPointOfRectangleContainer(GeoElements.OfRectangleContainer.Points which, HexPoint p){
		GeoPoint g = new GeoPoint(GeoElements.OfRectangleContainer.Points.APEX_NW, getXof(p.x(), p.y()), getYof(p.x(), p.y()));
		changePointReference(g, which);
		return g;
	}
	public GeoSegment getSegmentOfRectangleContainer(GeoElements.OfRectangleContainer.Segments which, HexPoint p){
		return new GeoSegment(which, getPointOfRectangleContainer(which.getOrigin(), p), getPointOfRectangleContainer(which.getDestiny(), p));
	}
	public HexImage getImageOf(Hexagon hex, Point reference){
		HexImage h = new HexImage(hex, this.getPoint(reference, hex.getPoint()),this);
		this.attach(h);
		return h;
	}
	public GeoPoint getPoint(GeoElements.Point ref, HexPoint p){
		if(ref instanceof GeoElements.OfHexagon.Points)
			return getPointOfHexagon((GeoElements.OfHexagon.Points) ref, p);
		else if(ref instanceof GeoElements.OfRectangleContainer.Points)
			return getPointOfRectangleContainer((GeoElements.OfRectangleContainer.Points) ref, p);
		else return null;
	}
	
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
		return this.reference_vector.getApothemProportion()*this.reference_vector_size;
	}
	protected double getRadius(){
		return this.reference_vector.getRadiusProportion()*this.reference_vector_size;
	}
	protected void actualizeChildRefernce(HexImage child){
		GeoPoint p = this.getPoint(child.getPoint().getReferedElement(), child.getHexagon());
		child.setReference(p);
	}
}
