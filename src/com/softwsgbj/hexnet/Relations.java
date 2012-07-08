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
