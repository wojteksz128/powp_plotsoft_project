package edu.iis.powp.strategy;

import java.util.List;

import javafx.geometry.Point2D;

public class MoveStrategy implements ModifyStrategy {

	int x, y;
	public MoveStrategy(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public void modify(List<Point2D> points) {
		for(int i = 0; i < points.size(); ++i) {
			points.set(i, points.get(i).add(x,y));
		}
	}

}
