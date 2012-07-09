//	LICENSE:
//	Relations.java is part of HexNet.
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
package com.softwsgbj.hexnet;

public class Relations {

	interface Relation{ }
	
	public enum PointInMap implements Relation {
		IS_OUT_OF_BOUNDS ,
		IS_OUT_OF_EXISTENCE,
		EXISTS;
		public boolean isOutOfBounds(){
			return this.equals(IS_OUT_OF_BOUNDS);
		}
		public boolean isOutOfEsistence(){
			return !this.equals(EXISTS);
			}
		public boolean exists(){
			return this.equals(EXISTS);
		}
	}
	public enum MapRespectPoint implements Relation {
		OUTER, CONTAINER, CONTAINER_EXISTENCE;
		public boolean isOuter(){
			return this.equals(OUTER);
		}
		public boolean isContainer(){ 
			return !this.equals(OUTER);
		}
		public boolean isContainerOfExistence(){
			return this.equals(CONTAINER_EXISTENCE);
		}
	}
	public enum PointRespectPoint{
		FAR_AWAY, ADJACENTS, EQUALS;
	}
	
	
}
