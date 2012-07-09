package com.softwsgbj.hexnet;

public interface Localizable{

	public HexPoint getPoint();
	public Hexagon getHexIn(Map<?> m);
	public Neighbors<HexPoint> getNeighbors();
	public Neighbors<Hexagon> getNeighbors(Map<?> m);
	
}
