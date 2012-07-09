package com.softwsgbj.hexnet.test;

import java.util.ArrayList;

import com.softwsgbj.hexnet.HexMapBuilder;
import com.softwsgbj.hexnet.Map;

class MyMapBuilder implements HexMapBuilder<MyHex> {

	private int x;
	private int y;
	
	
	public void setSize(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public Map<MyHex> buildMap() {
		ArrayList<MyHex>[] a = new ArrayList[x];
		ArrayList<MyHex> b0 ;
		for(int i = 0; i < x; i++){
			b0 = new ArrayList<MyHex>(y);
			for(int j = 0; j < y; j++){
				b0.add(j, new MyHex(i,j));
			}
			a[i] = b0;
		}
		return new Map<MyHex>(a);
	}
}
