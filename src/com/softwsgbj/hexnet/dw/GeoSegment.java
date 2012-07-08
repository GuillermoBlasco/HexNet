package com.softwsgbj.hexnet.dw;

import com.softwsgbj.hexnet.dw.GeoElements.Segment;

public class GeoSegment  {

	
	private GeoElements.Segment refered;
	private GeoPoint origin;
	private GeoPoint destiny;
	GeoSegment(Segment refered, GeoPoint origin, GeoPoint destiny) {
		super();
		this.refered = refered;
		this.origin = origin;
		this.destiny = destiny;
	}
	void setRefered(GeoElements.Segment refered) {
		this.refered = refered;
	}
	void setOrigin(GeoPoint origin) {
		this.origin = origin;
	}
	void setDestiny(GeoPoint destiny) {
		this.destiny = destiny;
	}
	public GeoElements.Segment getRefered() {
		return refered;
	}
	public GeoPoint getOrigin() {
		return origin;
	}
	public GeoPoint getDestiny() {
		return destiny;
	}
	
	
	

}
