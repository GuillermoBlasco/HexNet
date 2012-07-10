//	LICENSE:
//	MyHex.java is part of HexNet.
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
package com.softwsgbj.hexnet.test2;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.softwsgbj.hexnet.AbstractHexagon;
import com.softwsgbj.hexnet.dw.HexDraw;

class MyHex extends AbstractHexagon {

	private static final long serialVersionUID = 1L;

	private boolean visited;
	
	MyHex(int x, int y) {
		super(x, y);
		visited = false;
	}

	public void visit(){
		visited = true;
	}
	public boolean hasBeenVisited(){
		return visited;
	}
	
	@Override
	public HexDraw getAsDraw() {
		HexDraw d = new HexDraw(this);
		try {
			String file;
			if(!visited)
				file = "test_res/void_hex.png";
			else
				file = "test_res/fill_hex.png";
			d.setImage("I", ImageIO.read(new File(file)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	
}
