package com.softwsgbj.hexnet.dw;

import com.softwsgbj.hexnet.HexPoint;
import com.softwsgbj.hexnet.AbstractHexagon;
import com.softwsgbj.hexnet.Map;
import com.softwsgbj.hexnet.dw.GeoElements.OfHexagon.Points;

public abstract class MapRender {

	private Map<?> m;
	private GeometricAdapter geo;
	
	public MapRender(Map<?> m){
		this.m = m;
		this.geo = new GeometricAdapter(m);
	}
	
	public void repaintAll(){
		int x = m.getBoundX();
		int y = m.getBoundY();
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				paint(i,j);
	}
	public void paint(int x, int y){
		HexPoint p = m.buildPoint(x, y);
		if(p!= null){
			AbstractHexagon h = m.getHexagonIn(p);
			if(h != null){
				HexImage i = geo.getImageOf(h, GeoElements.OfSquare.Points.APEX_NW);
				this.paint(i.getImages(), (int) i.getPoint().getX(), (int) i.getPoint().getY());
			} else {
				/*not exists*/
				/*paint default hexagon*/
			}
				
		} else { /* out of bounds*/ }
	}
	
	protected abstract void paint(HexDraw draw, int x, int y);
}
