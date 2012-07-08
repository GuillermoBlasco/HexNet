package com.softwsgbj.hexnet.dw;

public class GeoElements {

	interface NotableElement{
	}
	interface NotablePoint extends NotableElement{
	}
	interface NotableSegment extends NotableElement{
	}
	
	interface GeoElement{
	}
	
	interface Point extends GeoElement {
		public double getXRadiusToA();
		public double getYApothemsToA();
	}
	
	interface Segment extends GeoElement {
		public Point getOrigin();
		public Point getDestiny();
	}
	
	public static class OfHexagon {
		public enum NotablePoints implements NotablePoint{
			CENTER, APEX, MIDPOINT;
		}
		public enum NotableSegments implements NotableSegment{
			SIDE	(1						, Math.cos(Math.PI/6)	 ),
			DIAMETER(0.5					, 0.5*Math.cos(Math.PI/6)),
			RADIUS	(1						, Math.cos(Math.PI/6)	 ),
			APOTHEM	(1/Math.cos(Math.PI/6)	, 1						 ),
			HEIGH	(0.5/Math.cos(Math.PI/6), 0.5					 );
			private double k_radius;
			private double k_apothem;
			NotableSegments(double k_radius, double k_apothem)
			{ this.k_radius = k_radius; this.k_apothem = k_apothem; }
			public double getRadiusProportion(){ return k_radius;}
			public double getApothemProportion(){ return k_apothem;}
		}
		
		public enum Points implements Point {
			CENTER(NotablePoints.CENTER, 		 1.0 , 1.0),
			APEX_0(NotablePoints.APEX, 			 1.5 , 0.0),
			APEX_1(NotablePoints.APEX, 			 2.0 , 1.0),
			APEX_2(NotablePoints.APEX,			 1.5 , 2.0),
			APEX_3(NotablePoints.APEX,			 0.5 , 2.0),
			APEX_4(NotablePoints.APEX, 			 0.0 , 1.0),
			APEX_5(NotablePoints.APEX,			 0.5 , 0.0),
			MIDPOINT_0_1(NotablePoints.MIDPOINT, 1.75, 0.5),
			MIDPOINT_1_2(NotablePoints.MIDPOINT, 1.75, 1.5),
			MIDPOINT_2_3(NotablePoints.MIDPOINT, 1.0 , 2.0),
			MIDPOINT_3_4(NotablePoints.MIDPOINT, 0.25, 1.5),
			MIDPOINT_4_5(NotablePoints.MIDPOINT, 0.25, 0.5),
			MIDPOINT_5_0(NotablePoints.MIDPOINT, 1.0 , 0.0);
			
			private OfHexagon.NotablePoints notable;
			private double x_radius;
			private double y_apothems;
			Points(NotablePoints notable,double x_radius,  double y_apothems){
				this.notable = notable;
				this.x_radius =x_radius;
				this.y_apothems = y_apothems;
			}
			public NotablePoint getNotable(){
				return this.notable;
			}
			@Override
			public double getXRadiusToA() {
				return x_radius;
			}
			@Override
			public double getYApothemsToA() {
				return y_apothems;
			}
		}
		public enum Segments implements Segment {
			
			SIDE_0 			(NotableSegments.SIDE,
					Points.APEX_0, Points.APEX_1),
					
			SIDE_1 			(NotableSegments.SIDE,
					Points.APEX_1, Points.APEX_2),
					
			SIDE_2 			(NotableSegments.SIDE,
					Points.APEX_2, Points.APEX_3),
					
			SIDE_3 			(NotableSegments.SIDE,
					Points.APEX_3, Points.APEX_4),
					
			SIDE_4 			(NotableSegments.SIDE,
					Points.APEX_4, Points.APEX_5), 
					
			SIDE_5 			(NotableSegments.SIDE,
					Points.APEX_5, Points.APEX_0),
					
			DIAMETER_0_3	(NotableSegments.DIAMETER,
					Points.APEX_0, Points.APEX_3),
					
			DIAMETER_1_4 	(NotableSegments.DIAMETER,
					Points.APEX_1, Points.APEX_4),
					
			DIAMETER_2_5 	(NotableSegments.DIAMETER,
					Points.APEX_2, Points.APEX_5),
					
			RADIUS_0 		(NotableSegments.RADIUS,
					Points.CENTER, Points.APEX_0),
					
			RADIUS_1 		(NotableSegments.RADIUS,
					Points.CENTER, Points.APEX_1),
					
			RADIUS_2 		(NotableSegments.RADIUS,
					Points.CENTER, Points.APEX_2),
					
			RADIUS_3 		(NotableSegments.RADIUS,
					Points.CENTER, Points.APEX_3),
					
			RADIUS_4 		(NotableSegments.RADIUS,
					Points.CENTER, Points.APEX_4),
					
			RADIUS_5 		(NotableSegments.RADIUS,
					Points.CENTER, Points.APEX_5),
					
			APOTHEM_0 		(NotableSegments.APOTHEM,
					Points.CENTER, Points.MIDPOINT_5_0),
					
			APOTHEM_1 		(NotableSegments.APOTHEM,
					Points.CENTER, Points.MIDPOINT_0_1),
					
			APOTHEM_2 		(NotableSegments.APOTHEM,
					Points.CENTER, Points.MIDPOINT_1_2),
					
			APOTHEM_3 		(NotableSegments.APOTHEM,
					Points.CENTER, Points.MIDPOINT_2_3),
					
			APOTHEM_4 		(NotableSegments.APOTHEM,
					Points.CENTER, Points.MIDPOINT_3_4),
					
			APOTHEM_5 		(NotableSegments.APOTHEM,
					Points.CENTER, Points.MIDPOINT_4_5);
			
			private OfHexagon.Points origin;
			private OfHexagon.Points destiny;
			private OfHexagon.NotableSegments notable;
			Segments(NotableSegments notable, Points origin, Points destiny){
				this.notable = notable;
				this.origin = origin;
				this.destiny = destiny;
			}
			public OfHexagon.Points getOrigin(){
				return this.origin;
			}
			public OfHexagon.Points getDestiny(){
				return this.destiny;
			}
			public OfHexagon.NotableSegments getNotable() {
				return notable;
			}
		}
	}
	
	public static class OfRectangleContainer {
		public enum NotablePoints implements NotablePoint{
			CENTER, APEX, MIDPOINT;
		}
		public enum NotableSegments implements NotableSegment {
			SIDE, DIAGONAL;
		}
		public enum Points implements Point {
			CENTER			(NotablePoints.CENTER,	1.0 ,1.0),
			APEX_NE			(NotablePoints.APEX,	2.0, 0.0),
			APEX_SE			(NotablePoints.APEX,	2.0, 2.0),
			APEX_SW			(NotablePoints.APEX,	0.0, 2.0),
			APEX_NW			(NotablePoints.APEX, 	0.0, 0.0),
			MIDPOINT_NE_SE	(NotablePoints.MIDPOINT,2.0, 1.0),
			MIDPOINT_SE_SW	(NotablePoints.MIDPOINT,1.0, 2.0),
			MIDPOINT_SW_NW	(NotablePoints.MIDPOINT,0.0, 1.0),
			MIDPOINT_NW_NE	(NotablePoints.MIDPOINT,1.0, 0.0);
			
			private OfRectangleContainer.NotablePoints notable;
			private double x_radius;
			private double y_apothems;
			Points(NotablePoints notable,double x_radius,  double y_apothems){
				this.notable = notable;
				this.x_radius =x_radius;
				this.y_apothems = y_apothems;
			}
			public NotablePoint getNotable(){
				return this.notable;
			}
			@Override
			public double getXRadiusToA() {
				return x_radius;
			}
			@Override
			public double getYApothemsToA() {
				return y_apothems;
			}
		}
		public enum Segments implements Segment {
			
			SIDE_N 			(NotableSegments.SIDE, 
					Points.APEX_NW, Points.APEX_NE),
					
			SIDE_E 			(NotableSegments.SIDE, 
					Points.APEX_NE, Points.APEX_SE),
					
			SIDE_S 			(NotableSegments.SIDE, 
					Points.APEX_SE, Points.APEX_SW),
					
			SIDE_W 			(NotableSegments.SIDE, 
					Points.APEX_SW, Points.APEX_NW),
					
			DIAGONAL_NE_SW 	(NotableSegments.DIAGONAL,
					Points.APEX_NE, Points.APEX_SW),
					
			DIAGONAL_SE_NW 	(NotableSegments.DIAGONAL, 
					Points.APEX_NW, Points.APEX_SE);
			
			private OfRectangleContainer.Points origin;
			private OfRectangleContainer.Points destiny;

			private OfRectangleContainer.NotableSegments notable;
			Segments(NotableSegments  notable, Points origin, Points destiny){
				this.notable = notable;
				this.origin = origin;
				this.destiny = destiny;
			}
			public OfRectangleContainer.Points getOrigin(){
				return this.origin;
			}
			public OfRectangleContainer.Points getDestiny(){
				return this.destiny;
			}
			public OfRectangleContainer.NotableSegments getNotable(){
				return this.notable;
			}
		}
	}
	public static class OfReference {
		public enum Points{
			CENTER,
			APEX_NE, APEX_SE, APEX_SW, APEX_NW,
		}
	}

}
