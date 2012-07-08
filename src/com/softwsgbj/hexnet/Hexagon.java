package com.softwsgbj.hexnet;

import com.softwsgbj.hexnet.dw.HexDraw;

public abstract class Hexagon extends HexPoint {

	private static final long serialVersionUID = 177L;
	
	protected Hexagon(int x, int y) {
		super(x, y);
	}

	public abstract HexDraw getAsImage();
}
