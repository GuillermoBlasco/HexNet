package com.softwsgbj.hexnet.dw;

public class Metric implements Comparable<Metric>{

	private GeoElements.NotableSegment reference_segment;
	private double value;
	
	public Metric(GeoElements.NotableSegment reference_segment, double value){
		changeMetric(reference_segment, value);
	}
	
	public double getRadiusSize(){
		return value*reference_segment.getRadiusProportion();
	}
	public double getApothemSize(){
		return getRadiusSize()*Math.cos(Math.PI/6.0);
	}
	public double getSizeOf(GeoElements.NotableSegment reference_segment){
		double prev = getRadiusSize();
		return prev / reference_segment.getRadiusProportion();
	}
	public void changeMetric(GeoElements.NotableSegment reference_segment, double value){
		if(value <= 0.0)
			throw new IllegalArgumentException("value must be positive.");
		this.reference_segment = reference_segment;
		this.value = value;
	}
	public boolean equals(Object o){
		if(o!=null && o instanceof Metric){
			Metric m = (Metric) o;
			return this.getRadiusSize() == m.getRadiusSize();
		} else return false;
	}
	public int compareTo(Metric m){
		double dif = getRadiusSize() - m.getRadiusSize();
		if(dif > 0) return (int)Math.ceil(dif);
		else if(dif < 0) return (int) Math.ceil(-dif);
		else return 0;
	}
}
