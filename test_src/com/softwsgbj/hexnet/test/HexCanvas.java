//	LICENSE:
//	HexCanvas.java is part of HexNet.
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
package com.softwsgbj.hexnet.test;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.softwsgbj.hexnet.Hexagon;
import com.softwsgbj.hexnet.Map;
import com.softwsgbj.hexnet.dw.GeoElements;
import com.softwsgbj.hexnet.dw.GeoPoint;
import com.softwsgbj.hexnet.dw.GeometricAdapter;
import com.softwsgbj.hexnet.dw.HexImage;

public class HexCanvas extends Canvas{

	private enum Task { CLEAN, PAINT;}
	
	private static final long serialVersionUID = 1L;
	private HexImage[] h;
	private Task task;

	public HexCanvas() {
		super();
	}
	public void clean(){
		task = Task.CLEAN;
		this.repaint();
	}
	public void paint(Graphics g){
		switch(task){
		case CLEAN:
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			break;
		case PAINT:
			if(h == null) return;
			for(int i = 0; i < h.length; i++){
				if(h[i] == null) return;
				BufferedImage img = (BufferedImage) h[i].getImages().getImage("I");
				GeoPoint p = h[i].getPoint();
				//System.out.println("Point ("+h[i].getHexagon().x()+","+h[i].getHexagon().y()+") X:" +p.getX()+ " Y:" + p.getY());
				int x = (int) p.getX();
				int y = (int) p.getY();
				g.drawImage(img, x,y,null);
			}
			break;
		default:
			break;
		
		}
	}
	public void paintHex( GeometricAdapter adapter, Map m){

		this.h = new HexImage[m.getBoundX()*m.getBoundY()];
		for(int i = 0; i < m.getBoundX(); i++){
			for(int j = 0; j < m.getBoundY(); j++){
				Hexagon aux = m.getHexagonIn(m.buildPoint(i, j));
				if(aux != null)
					h[i*m.getBoundY()+j] = adapter.getImageOf(aux, GeoElements.OfRectangle.Points.APEX_NW);
				else
					h[i*m.getBoundY()+j] = null;
			}
		}
		task = Task.PAINT;
		this.repaint();
	}
	
}
