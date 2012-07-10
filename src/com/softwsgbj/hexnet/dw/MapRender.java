package com.softwsgbj.hexnet.dw;

import com.softwsgbj.hexnet.HexPoint;
import com.softwsgbj.hexnet.Hexagon;
import com.softwsgbj.hexnet.Map;

public abstract class MapRender {

	private Map<?> m;
	private GeometricAdapter geo;
	
	public MapRender(Map<?> m){
		this.m = m;
		this.geo = new GeometricAdapter(m);
	}
	
	public void repaintAll(){
		
	}
	public void paint(int x, int y){
		HexPoint p = m.buildPoint(x, y);
		if(p!= null){
			Hexagon h = m.getHexagonIn(p);
			if(h != null){
				
			} else {
				/*not exists*/
				/*paint default hexagon*/
			}
				
		} else { /* out of bounds*/ }
	}
	
	protected abstract void paint(HexDraw draw, int x, int y);
}
