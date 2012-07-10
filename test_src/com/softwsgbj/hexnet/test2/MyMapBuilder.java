//	LICENSE:
//	MyMapBuilder.java is part of HexNet.
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
