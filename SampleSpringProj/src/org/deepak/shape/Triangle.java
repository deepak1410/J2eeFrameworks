package org.deepak.shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Triangle implements Shape, InitializingBean, DisposableBean{
	private String type;
	private int height;
	
	private Point pointA;
	private Point pointB;
	private Point pointC;

	//Creating Map variable to test Spring Map feature.
	private Map<String, Point> pointList = new HashMap<String, Point>();
	
	//Creating List variable to test Spring List feature.
	private List<Point> points = new ArrayList<Point>();
	
	
	/* Variable of a bean class can be initialized using either setter or constructor. If both are used then constructor gets executed first
	 hence setter overrides the values */

	public void setHeight(int height) {
		this.height = height;
	}

	public Triangle() {}
	
	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHeight() {
		return height;
	}

	/* Getters and Setters to test DI */
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public Map<String, Point> getPointList() {
		return pointList;
	}

	public void setPointList(Map<String, Point> pointList) {
		this.pointList = pointList;
	}
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw(){
		System.out.println("Triangle drawn with height= " + getHeight());
	}
	
	public void showTriangle() {
		System.out.println("Point1:(" + getPointA() + "), Point2:(" + getPointB() + "), Point3:(" + getPointC() + ")");
	}
	
	public void myInit() {
		//System.out.println("My Init method has been called...");
	}
	
	public void myDesposable() {
		//System.out.println("My Desposable method has been called...");
	}

	@Override
	public void destroy() throws Exception {
		//System.out.println("Default Init method provided by Spring is called...");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//System.out.println("Default Distroy method provided by Spring is called...");
		
	}

}
