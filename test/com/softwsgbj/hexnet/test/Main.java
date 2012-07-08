package com.softwsgbj.hexnet.test;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.softwsgbj.hexnet.HexMapBuilder;
import com.softwsgbj.hexnet.Hexagon;
import com.softwsgbj.hexnet.Map;
import com.softwsgbj.hexnet.dw.GeoElements;
import com.softwsgbj.hexnet.dw.GeoPoint;
import com.softwsgbj.hexnet.dw.GeometricAdapter;
import com.softwsgbj.hexnet.dw.HexDraw;
import com.softwsgbj.hexnet.dw.GeoElements.OfHexagon.Points;
import com.softwsgbj.hexnet.dw.HexImage;

public class Main extends JFrame{

	MyCanvas c;
	Map<MyHex> map;
	GeometricAdapter adapter;
	
	class MyHex extends Hexagon {

		private static final long serialVersionUID = 1L;

		MyHex(int x, int y) {
			super(x, y);
		}

		@Override
		public HexDraw getAsImage() {
			HexDraw d = new HexDraw(this);
			try {
				d.setImage("I", ImageIO.read(new File("test/res/void_hex.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return d;
		}
		
	}
	class MyBuilder implements HexMapBuilder<MyHex> {

		@Override
		public Map<MyHex> buildMap() {
			ArrayList<MyHex>[] a = new ArrayList[2];
			ArrayList<MyHex> b0 = new ArrayList<MyHex>();
			b0.add(new MyHex(0,0));
			b0.add(new MyHex(0,1));
			ArrayList<MyHex> b1 = new ArrayList<MyHex>();
			b1.add(new MyHex(1,0));
			b1.add(new MyHex(1,1));
			a[0] = b0;
			a[1] = b1;
			return new Map<MyHex>(a);
		}
	}
	
	class MyCanvas extends Canvas {

		private static final long serialVersionUID = 1L;
		private HexImage[] h;
		public void paint(Graphics g){
			if(h == null) return;
			for(int i = 0; i < h.length; i++){
				if(h[i] == null) return;
				BufferedImage img = (BufferedImage) h[i].getImages().getImage("I");
				GeoPoint p = h[i].getPoint();
				System.out.println("Point ("+h[i].getHexagon().x()+","+h[i].getHexagon().y()+") X:" +p.getX()+ " Y:" + p.getY());
				int x = (int) p.getX();
				int y = (int) p.getY();
				g.drawImage(img, x,y,null);
			}
		}
		public void paintHex( GeometricAdapter adapter, MyHex... h){
			this.h = new HexImage[h.length];
			for(int  i = 0; i < h.length; i++)
				this.h[i] =adapter.getImageOf(h[i], GeoElements.OfRectangleContainer.Points.APEX_NW) ;
			this.repaint();
		}
		
	}
	public Main(){
		this.map = (new MyBuilder()).buildMap();
		this.adapter = new GeometricAdapter(map);
		adapter.setMetric(GeoElements.OfHexagon.NotableSegments.RADIUS, 25);
		c = new MyCanvas();
		this.add(c);
		//this.setSize((int)adapter.sizeX(), (int)adapter.sizeY());
		//this.setSize(500, 500);
		System.out.println("Sizes: X:" +(int)adapter.sizeX()+ " Y:" + (int)adapter.sizeY());
		MyHex[] mh = {map.getHexagonIn(map.buildPoint(0, 0)),
				map.getHexagonIn(map.buildPoint(1, 0)),
				map.getHexagonIn(map.buildPoint(0, 1)),
				map.getHexagonIn(map.buildPoint(1, 1))};
		
		c.paintHex(adapter,mh);
		//this.setSize((int)adapter.sizeX(), (int)adapter.sizeY());
		
		
	}
	public MyCanvas getCanvas(){
		return c;
	}
	public void setSize(){
		//this.setSize((int)adapter.sizeX(), (int)adapter.sizeY());
		this.setSize(90, 108);
	}
	
	public static void main(String[] args){
		Main m = new Main();
		m.setVisible(true);
		m.setSize();
	}
}
