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
import com.softwsgbj.hexnet.test.Main.MyHex;

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
					h[i*m.getBoundY()+j] = adapter.getImageOf(aux, GeoElements.OfRectangleContainer.Points.APEX_NW);
				else
					h[i*m.getBoundY()+j] = null;
			}
		}
		task = Task.PAINT;
		this.repaint();
	}
	
}
