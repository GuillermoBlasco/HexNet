package com.softwsgbj.hexnet.dw;

import java.util.TreeMap;

import com.softwsgbj.hexnet.HexPoint;
import com.softwsgbj.hexnet.Hexagon;

public class HexDraw {

	private final Hexagon hex;
	private TreeMap<String, Object> images;
	
	public HexDraw(Hexagon origin){
		this(origin, new TreeMap<String,Object>());
	}
	public HexDraw(Hexagon origin, TreeMap<String, Object> images){
		this.hex = origin;
		this.images = images;
	}
	
	public Hexagon getHexagon(){
		return hex;
	}
	public HexPoint getHexPoint(){
		return hex.getPoint();
	}
	public Object getImage(String key){
		return images.get(key);
	}
	public void setImage(String key, Object value){
		images.put(key, value);
	}
	public void actualizeDraw(){
		images = hex.getAsImage().images;
	}
	
}
