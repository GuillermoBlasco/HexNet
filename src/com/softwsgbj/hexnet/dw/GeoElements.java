//	LICENSE:
//	GeoElements.java is part of HexNet.
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
package com.softwsgbj.hexnet.dw;

public class GeoElements {

	
	private static final double cos_30 = Math.cos(Math.PI/6.0);
	interface NotableElement{
	}
	interface NotablePoint extends NotableElement{
	}
	interface NotableSegment extends NotableElement{
		public double getRadiusProportion();
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
			SIDE	(1			, cos_30	),
			DIAMETER(0.5		, 0.5*cos_30),
			RADIUS	(1			, cos_30	),
			APOTHEM	(1/cos_30	, 1			),
			HEIGH	(0.5/cos_30	, 0.5		);
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
	
	public static class OfRectangle {
		public enum NotablePoints implements NotablePoint{
			CENTER, APEX, MIDPOINT;
		}
		public enum NotableSegments implements NotableSegment {
			TOP_SIDE(2.0),
			LATERAL_SIDE(2.0*cos_30),
			DIAGONAL(Math.sqrt(4.0*(1+cos_30*cos_30)));
			private double r_prop;
			NotableSegments(double r){
				this.r_prop = r;
			}
			public double getRadiusProportion() {
				return r_prop;
			}
			
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
			
			private OfRectangle.NotablePoints notable;
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
			
			SIDE_N 			(NotableSegments.TOP_SIDE, 
					Points.APEX_NW, Points.APEX_NE),
					
			SIDE_E 			(NotableSegments.LATERAL_SIDE, 
					Points.APEX_NE, Points.APEX_SE),
					
			SIDE_S 			(NotableSegments.TOP_SIDE, 
					Points.APEX_SE, Points.APEX_SW),
					
			SIDE_W 			(NotableSegments.LATERAL_SIDE, 
					Points.APEX_SW, Points.APEX_NW),
					
			DIAGONAL_NE_SW 	(NotableSegments.DIAGONAL,
					Points.APEX_NE, Points.APEX_SW),
					
			DIAGONAL_SE_NW 	(NotableSegments.DIAGONAL, 
					Points.APEX_NW, Points.APEX_SE);
			
			private OfRectangle.Points origin;
			private OfRectangle.Points destiny;

			private OfRectangle.NotableSegments notable;
			Segments(NotableSegments  notable, Points origin, Points destiny){
				this.notable = notable;
				this.origin = origin;
				this.destiny = destiny;
			}
			public OfRectangle.Points getOrigin(){
				return this.origin;
			}
			public OfRectangle.Points getDestiny(){
				return this.destiny;
			}
			public OfRectangle.NotableSegments getNotable(){
				return this.notable;
			}
		}
	}
	
	public static class OfSquare {

		public enum NotablePoints implements NotablePoint{
			CENTER, APEX, MIDPOINT;
		}
		public enum NotableSegments implements NotableSegment {
			SIDE (2.0), DIAGONAL(Math.sqrt(8.0));
			private double r_prop;
			NotableSegments(double r){
				this.r_prop = r;
			}
			public double getRadiusProportion() {
				return r_prop;
			}
		}
		public enum Points implements Point {
			CENTER			(NotablePoints.CENTER,	1.0 ,1.0		),
			APEX_NE			(NotablePoints.APEX,	2.0, 0.0		),
			APEX_SE			(NotablePoints.APEX,	2.0, 2.0/cos_30	),
			APEX_SW			(NotablePoints.APEX,	0.0, 2.0/cos_30	),
			APEX_NW			(NotablePoints.APEX, 	0.0, 0.0		),
			MIDPOINT_NE_SE	(NotablePoints.MIDPOINT,2.0, 1.0/cos_30	),
			MIDPOINT_SE_SW	(NotablePoints.MIDPOINT,1.0, 2.0/cos_30	),
			MIDPOINT_SW_NW	(NotablePoints.MIDPOINT,0.0, 1.0/cos_30	),
			MIDPOINT_NW_NE	(NotablePoints.MIDPOINT,1.0, 0.0		);
			
			private OfSquare.NotablePoints notable;
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
			
			private OfSquare.Points origin;
			private OfSquare.Points destiny;

			private OfSquare.NotableSegments notable;
			Segments(NotableSegments  notable, Points origin, Points destiny){
				this.notable = notable;
				this.origin = origin;
				this.destiny = destiny;
			}
			public OfSquare.Points getOrigin(){
				return this.origin;
			}
			public OfSquare.Points getDestiny(){
				return this.destiny;
			}
			public OfSquare.NotableSegments getNotable(){
				return this.notable;
			}
		}
	}
	
}
