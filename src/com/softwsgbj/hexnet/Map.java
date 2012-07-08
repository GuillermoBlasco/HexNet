package com.softwsgbj.hexnet;

import java.io.Serializable;
import java.util.ArrayList;

public class Map<H extends Hexagon> implements Serializable, PointFactory{

	private static final long serialVersionUID = 177L;
	
	private ArrayList<H>[] table;
	
	public Map(ArrayList<H>[] table){
		this.table = table;
	}
	
	public Relations.PointInMap relation(HexPoint p){
		if(p.x() >= getBoundX() || p.y() >= getBoundY() || p.x() < 0 || p.y() < 0)
			return Relations.PointInMap.IS_OUT_OF_BOUNDS;
		else if(this.getH(p.x(),p.y()) == null)
			return Relations.PointInMap.IS_OUT_OF_EXISTENCE;
		else
			return Relations.PointInMap.EXISTS;
	}
	
	public H getHexagonIn(HexPoint p){
		if(this.relation(p).exists())
			return getH(p.x(), p.y());
		else
			return null;
	}
	
	public int getBoundX(){
		return table.length;
	}
	
	public int getBoundY(){
		return table[0].size();
	}
	
	public PointFactory getPointFactory(){
		return this;
	}
	
	private H getH(int x, int y){
		return table[x].get(y);
	}

	public HexPoint buildPoint(int x, int y) {
		if(x >= getBoundX() || y >= getBoundY() || x < 0 || y < 0)
			return null;
		else 
			return new HexPoint(x,y);
	}
	
}
