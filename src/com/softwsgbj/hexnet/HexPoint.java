package com.softwsgbj.hexnet;

import java.io.Serializable;

public class HexPoint implements Cloneable, Serializable, Localizable {

	private static final long serialVersionUID = 177L;
	
	protected int x;
	protected int y;
	
	
	HexPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int x(){
		return x;
	}
	public int y(){
		return y;
	}

	@Override
	public HexPoint getPoint() {
		return (HexPoint) this.clone();
	}

	@Override
	public Hexagon getHexIn(Map<?> m) {
		return m.getHexagonIn(this);
	}
	
	public boolean equals(Object o){
		if(o != null && o instanceof HexPoint)
			return this.x == ((HexPoint)o).x && this.y == ((HexPoint)o).y;
		else return false;
	}
	public HexPoint clone(){
		return new HexPoint(x,y);
	}
	public String toString(){
		return "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
	}

}
