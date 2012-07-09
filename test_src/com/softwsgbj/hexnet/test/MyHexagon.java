package com.softwsgbj.hexnet.test;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.softwsgbj.hexnet.Hexagon;
import com.softwsgbj.hexnet.dw.HexDraw;

class MyHex extends Hexagon {

	private static final long serialVersionUID = 1L;

	MyHex(int x, int y) {
		super(x, y);
	}

	@Override
	public HexDraw getAsDraw() {
		HexDraw d = new HexDraw(this);
		try {
			d.setImage("I", ImageIO.read(new File("test_res/void_hex.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	
}
