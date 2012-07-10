package com.softwsgbj.hexnet.test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import com.softwsgbj.hexnet.Map;
import com.softwsgbj.hexnet.dw.GeometricAdapter;

public class HexExplorer implements Runnable {

	private Thread thread;
	private boolean run;
	private HexCanvas canvas;
	private Map<MyHex> m;
	private LinkedList<MyHex> nexts;
	private Random r;
	private GeometricAdapter geo;
	
	public HexExplorer(Map<MyHex> m, GeometricAdapter geo, HexCanvas canvas){
		thread = null;
		run = false;
		this.canvas = canvas;
		this.m = m;
		this.nexts = new LinkedList<MyHex>();
		nexts.add(m.getHexagonIn(m.buildPoint(0, 0)));
		this.r = new Random();
		this.geo = geo;
	}
	
	public void start(){
		run = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop(){
		run = false;
	}
	
	public void nextStep(){
		MyHex current = nexts.pollLast();
		current.visit();
		ArrayList<MyHex> k = m.getNeighbors(current).getAllTrimmed();
		for(MyHex h : k)
			if(!h.hasBeenVisited() && !nexts.contains(h))
				nexts.push(h);
		//canvas.paintOne(geo, m, current.x(), current.y());
		canvas.paintAll(geo, m);
		if(nexts.isEmpty()){
			this.stop();
			return;
		}
	}
	
	public void run(){
		while(run){
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				run = false;
			}
			nextStep();
		}
		this.thread = null;
		this.canvas.clean();
	}
	
	
}
